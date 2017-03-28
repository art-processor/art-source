#adapt: "input/recovery.vcl"
	#select folderName
	  #option jbd
		  #insert count_tags
	static int count_tags(struct buffer_head *bh, int size)
	{
		char *			tagp;
		journal_block_tag_t *	tag;
		int			nr = 0;		  
		  #endinsert
		  #insert do_one_pass
		  	/* If it is a valid descriptor block, replay it
			 * in pass REPLAY; otherwise, just skip over the
			 * blocks it describes. */
			if (pass != PASS_REPLAY) {
				next_log_block +=
					count_tags(bh, journal->j_blocksize);
				wrap(journal, next_log_block);
				brelse(bh);
		  #endinsert
	  #endoption
	  #option jbd2
		#insert do_one_pass
				/* Verify checksum first */
				if (JBD2_HAS_INCOMPAT_FEATURE(journal,
						JBD2_FEATURE_INCOMPAT_CSUM_V2))
					descr_csum_size =
						sizeof(struct jbd2_journal_block_tail);
				if (descr_csum_size > 0 &&
					!jbd2_descr_block_csum_verify(journal,
								  bh->b_data)) {
					err = -EIO;
					goto failed;
				}

				/* If it is a valid descriptor block, replay it
				 * in pass REPLAY; if journal_checksums enabled, then
				 * calculate checksums in PASS_SCAN, otherwise,
				 * just skip over the blocks it describes. */
				if (pass != PASS_REPLAY) {
					if (pass == PASS_SCAN &&
						JBD2_HAS_COMPAT_FEATURE(journal,
							JBD2_FEATURE_COMPAT_CHECKSUM) &&
						!info->end_transaction) {
						if (calc_chksums(journal, bh,
								&next_log_block,
								&crc32_sum)) {
							put_bh(bh);
							break;
						}
						put_bh(bh);
						continue;
					}
					next_log_block += count_tags(journal, bh);
					wrap(journal, next_log_block);
					put_bh(bh);
		  #endinsert
		  #insert count_tags
	static int count_tags(journal_t *journal, struct buffer_head *bh)
	{
		char *			tagp;
		journal_block_tag_t *	tag;
		int			nr = 0, size = journal->j_blocksize;
		int			tag_bytes = journal_tag_bytes(journal);

		if (JBD2_HAS_INCOMPAT_FEATURE(journal, JBD2_FEATURE_INCOMPAT_CSUM_V2))
			size -= sizeof(struct jbd2_journal_block_tail);
		  #endinsert
		  #insert jbd2_descr_block
	static int jbd2_descr_block_csum_verify(journal_t *j, void *buf)
	{
		struct jbd2_journal_block_tail *tail;
		__u32 provided, calculated;

		if (!JBD2_HAS_INCOMPAT_FEATURE(j, JBD2_FEATURE_INCOMPAT_CSUM_V2))
			return 1;

		tail = (struct jbd2_journal_block_tail *)(buf + j->j_blocksize -
				sizeof(struct jbd2_journal_block_tail));
		provided = tail->t_checksum;
		tail->t_checksum = 0;
		calculated = jbd2_chksum(j, j->j_csum_seed, buf, j->j_blocksize);
		tail->t_checksum = provided;

		provided = be32_to_cpu(provided);
		return provided == calculated;
	}		
		  #endinsert
		  #insert read_tag_block
	static inline unsigned ?@typeChange? read_tag_block(int tag_bytes, journal_block_tag_t *tag)
	{
		unsigned ?@typeChange? block = be32_to_cpu(tag->t_blocknr);
		if (tag_bytes > JBD2_TAG_SIZE32)
			block |= (u64)be32_to_cpu(tag->t_blocknr_high) << 32;
		return block;
	}

	/*
	 * calc_chksums calculates the checksums for the blocks described in the
	 * descriptor block.
	 */
	static int calc_chksums(journal_t *journal, struct buffer_head *bh,
				unsigned long *next_log_block, __u32 *crc32_sum)
	{
		int i, num_blks, err;
		unsigned long io_block;
		struct buffer_head *obh;

		num_blks = count_tags(journal, bh);
		/* Calculate checksum of the descriptor block. */
		*crc32_sum = crc32_be(*crc32_sum, (void *)bh->b_data, bh->b_size);

		for (i = 0; i < num_blks; i++) {
			io_block = (*next_log_block)++;
			wrap(journal, *next_log_block);
			err = jread(&obh, journal, io_block);
			if (err) {
				printk(KERN_ERR "JBD2: IO error %d recovering block "
					"%lu in log\n", err, io_block);
				return 1;
			} else {
				*crc32_sum = crc32_be(*crc32_sum, (void *)obh->b_data,
						 obh->b_size);
			}
			put_bh(obh);
		}
		return 0;
	}

	static int jbd2_commit_block_csum_verify(journal_t *j, void *buf)
	{
		struct commit_header *h;
		__u32 provided, calculated;

		if (!JBD2_HAS_INCOMPAT_FEATURE(j, JBD2_FEATURE_INCOMPAT_CSUM_V2))
			return 1;

		h = buf;
		provided = h->h_chksum[0];
		h->h_chksum[0] = 0;
		calculated = jbd2_chksum(j, j->j_csum_seed, buf, j->j_blocksize);
		h->h_chksum[0] = provided;

		provided = be32_to_cpu(provided);
		return provided == calculated;
	}

	static int jbd2_block_tag_csum_verify(journal_t *j, journal_block_tag_t *tag,
						  void *buf, __u32 sequence)
	{
		__u32 provided, calculated;

		if (!JBD2_HAS_INCOMPAT_FEATURE(j, JBD2_FEATURE_INCOMPAT_CSUM_V2))
			return 1;

		sequence = cpu_to_be32(sequence);
		calculated = jbd2_chksum(j, j->j_csum_seed, (__u8 *)&sequence,
					 sizeof(sequence));
		calculated = jbd2_chksum(j, calculated, buf, j->j_blocksize);
		provided = be32_to_cpu(tag->t_checksum);

		return provided == cpu_to_be32(calculated);
	}
		  #endinsert
	  #endoption
	#endselect
#endadapt

