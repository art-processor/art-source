#adapt: "resources/jbdSource/input/revoke.vcl"
	#select folderName
	  #option jbd2
		#insert release_data_buffer
static void jbd2_commit_block_csum_set(journal_t *j,
				       struct journal_head *descriptor)
{
	struct commit_header *h;
	__u32 csum;

	if (!JBD2_HAS_INCOMPAT_FEATURE(j, JBD2_FEATURE_INCOMPAT_CSUM_V2))
		return;

	h = (struct commit_header *)(jh2bh(descriptor)->b_data);
	h->h_chksum_type = 0;
	h->h_chksum_size = 0;
	h->h_chksum[0] = 0;
	csum = jbd2_chksum(j, j->j_csum_seed, jh2bh(descriptor)->b_data,
			   j->j_blocksize);
	h->h_chksum[0] = cpu_to_be32(csum);
}
		#endinsert
		#insert release_data_buffer
/*
 * This function along with journal_submit_commit_record
 * allows to write the commit record asynchronously.
 */
static int journal_wait_on_commit_record(journal_t *journal,
					 struct buffer_head *bh)
{
	int ret = 0;

	clear_buffer_dirty(bh);
	wait_on_buffer(bh);

	if (unlikely(!buffer_uptodate(bh)))
		ret = -EIO;
	put_bh(bh);            /* One for getblk() */
	jbd2_journal_put_journal_head(bh2jh(bh));

	return ret;
}

/*
 * write the filemap data using writepage() address_space_operations.
 * We don't do block allocation here even for delalloc. We don't
 * use writepages() because with dealyed allocation we may be doing
 * block allocation in writepages().
 */
static int journal_submit_inode_data_buffers(struct address_space *mapping)
{
	int ret;
	struct writeback_control wbc = {
		.sync_mode =  WB_SYNC_ALL,
		.nr_to_write = mapping->nrpages * 2,
		.range_start = 0,
		.range_end = i_size_read(mapping->host),
	};

	ret = generic_writepages(mapping, &wbc);
	return ret;
}

/*
 * Submit all the data buffers of inode associated with the transaction to
 * disk.
 *
 * We are in a committing transaction. Therefore no new inode can be added to
 * our inode list. We use JI_COMMIT_RUNNING flag to protect inode we currently
 * operate on from being released while we write out pages.
 */
static int journal_submit_data_buffers(journal_t *journal,
		transaction_t *commit_transaction)
{
	struct jbd2_inode *jinode;
	int err, ret = 0;
	struct address_space *mapping;

	spin_lock(&journal->j_list_lock);
	list_for_each_entry(jinode, &commit_transaction->t_inode_list, i_list) {
		mapping = jinode->i_vfs_inode->i_mapping;
		set_bit(__JI_COMMIT_RUNNING, &jinode->i_flags);
		spin_unlock(&journal->j_list_lock);
		/*
		 * submit the inode data buffers. We use writepage
		 * instead of writepages. Because writepages can do
		 * block allocation  with delalloc. We need to write
		 * only allocated blocks here.
		 */
		trace_jbd2_submit_inode_data(jinode->i_vfs_inode);
		err = journal_submit_inode_data_buffers(mapping);
		if (!ret)
			ret = err;
		spin_lock(&journal->j_list_lock);
		J_ASSERT(jinode->i_transaction == commit_transaction);
		clear_bit(__JI_COMMIT_RUNNING, &jinode->i_flags);
		smp_mb__after_clear_bit();
		wake_up_bit(&jinode->i_flags, __JI_COMMIT_RUNNING);
	}
	spin_unlock(&journal->j_list_lock);
	return ret;
}

/*
 * Wait for data submitted for writeout, refile inodes to proper
 * transaction if needed.
 *
 */
static int journal_finish_inode_data_buffers(journal_t *journal,
		transaction_t *commit_transaction)
{
	struct jbd2_inode *jinode, *next_i;
	int err, ret = 0;

	/* For locking, see the comment in journal_submit_data_buffers() */
	spin_lock(&journal->j_list_lock);
	list_for_each_entry(jinode, &commit_transaction->t_inode_list, i_list) {
		set_bit(__JI_COMMIT_RUNNING, &jinode->i_flags);
		spin_unlock(&journal->j_list_lock);
		err = filemap_fdatawait(jinode->i_vfs_inode->i_mapping);
		if (err) {
			/*
			 * Because AS_EIO is cleared by
			 * filemap_fdatawait_range(), set it again so
			 * that user process can get -EIO from fsync().
			 */
			set_bit(AS_EIO,
				&jinode->i_vfs_inode->i_mapping->flags);

			if (!ret)
				ret = err;
		}
		spin_lock(&journal->j_list_lock);
		clear_bit(__JI_COMMIT_RUNNING, &jinode->i_flags);
		smp_mb__after_clear_bit();
		wake_up_bit(&jinode->i_flags, __JI_COMMIT_RUNNING);
	}

	/* Now refile inode to proper lists */
	list_for_each_entry_safe(jinode, next_i,
				 &commit_transaction->t_inode_list, i_list) {
		list_del(&jinode->i_list);
		if (jinode->i_next_transaction) {
			jinode->i_transaction = jinode->i_next_transaction;
			jinode->i_next_transaction = NULL;
			list_add(&jinode->i_list,
				&jinode->i_transaction->t_inode_list);
		} else {
			jinode->i_transaction = NULL;
		}
	}
	spin_unlock(&journal->j_list_lock);

	return ret;
}

static __u32 jbd2_checksum_data(__u32 crc32_sum, struct buffer_head *bh)
{
	struct page *page = bh->b_page;
	char *addr;
	__u32 checksum;

	addr = kmap_atomic(page);
	checksum = crc32_be(crc32_sum,
		(void *)(addr + offset_in_page(bh->b_data)), bh->b_size);
	kunmap_atomic(addr);

	return checksum;
}

static void write_tag_block(int tag_bytes, journal_block_tag_t *tag,
				   unsigned long long block)
{
	tag->t_blocknr = cpu_to_be32(block & (u32)~0);
	if (tag_bytes > JBD2_TAG_SIZE32)
		tag->t_blocknr_high = cpu_to_be32((block >> 31) >> 1);
}

static void jbd2_descr_block_csum_set(journal_t *j,
				      struct journal_head *descriptor)
{
	struct jbd2_journal_block_tail *tail;
	__u32 csum;

	if (!JBD2_HAS_INCOMPAT_FEATURE(j, JBD2_FEATURE_INCOMPAT_CSUM_V2))
		return;

	tail = (struct jbd2_journal_block_tail *)
			(jh2bh(descriptor)->b_data + j->j_blocksize -
			sizeof(struct jbd2_journal_block_tail));
	tail->t_checksum = 0;
	csum = jbd2_chksum(j, j->j_csum_seed, jh2bh(descriptor)->b_data,
			   j->j_blocksize);
	tail->t_checksum = cpu_to_be32(csum);
}

static void jbd2_block_tag_csum_set(journal_t *j, journal_block_tag_t *tag,
				    struct buffer_head *bh, __u32 sequence)
{
	struct page *page = bh->b_page;
	__u8 *addr;
	__u32 csum;

	if (!JBD2_HAS_INCOMPAT_FEATURE(j, JBD2_FEATURE_INCOMPAT_CSUM_V2))
		return;

	sequence = cpu_to_be32(sequence);
	addr = kmap_atomic(page);
	csum = jbd2_chksum(j, j->j_csum_seed, (__u8 *)&sequence,
			  sizeof(sequence));
	csum = jbd2_chksum(j, csum, addr + offset_in_page(bh->b_data),
			  bh->b_size);
	kunmap_atomic(addr);

	tag->t_checksum = cpu_to_be32(csum);
}
		#endinsert
		#insert write_commit_record
	if (!JBD2_HAS_INCOMPAT_FEATURE(journal,
				       JBD2_FEATURE_INCOMPAT_ASYNC_COMMIT)) {
		err = journal_submit_commit_record(journal, commit_transaction,
						&cbh, crc32_sum);
		if (err)
			__jbd2_journal_abort_hard(journal);
	}
	if (cbh)
		err = journal_wait_on_commit_record(journal, cbh);
	if (JBD2_HAS_INCOMPAT_FEATURE(journal,
				      JBD2_FEATURE_INCOMPAT_ASYNC_COMMIT) &&
	    journal->j_flags & JBD2_BARRIER) {
		blkdev_issue_flush(journal->j_dev, GFP_NOFS, NULL);
	}

	if (err)
		jbd2_journal_abort(journal, err);

	/*
	 * Now disk caches for filesystem device are flushed so we are safe to
	 * erase checkpointed transactions from the log by updating journal
	 * superblock.
	 */
	if (update_tail)
		jbd2_update_log_tail(journal, first_tid, first_block);			
		#endinsert
		#insert revoke_csum
	if (JBD2_HAS_INCOMPAT_FEATURE(journal, JBD2_FEATURE_INCOMPAT_64BIT)) {
		* ((__be64 *)(&jh2bh(descriptor)->b_data[offset])) =
			cpu_to_be64(record->blocknr);
		offset += 8;

	} else {
	* ((__be32 *)(&jh2bh(descriptor)->b_data[offset])) =
		cpu_to_be32(record->blocknr);
	offset += 4;
	}
	*offsetp = offset;
}
static void jbd2_revoke_csum_set(journal_t *j,
				 struct journal_head *descriptor)
{
	struct jbd2_journal_revoke_tail *tail;
	__u32 csum;

	if (!JBD2_HAS_INCOMPAT_FEATURE(j, JBD2_FEATURE_INCOMPAT_CSUM_V2))
		return;

	tail = (struct jbd2_journal_revoke_tail *)
			(jh2bh(descriptor)->b_data + j->j_blocksize -
			sizeof(struct jbd2_journal_revoke_tail));
	tail->r_checksum = 0;
	csum = jbd2_chksum(j, j->j_csum_seed, jh2bh(descriptor)->b_data,
			   j->j_blocksize);
	tail->r_checksum = cpu_to_be32(csum);
}
		#endinsert
	  #endoption
	#endselect
#endadapt
	