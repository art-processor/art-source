#break copyright
 * Journal commit routines for the generic filesystem journaling code;
 * part of the ext2fs journaling system.
 */

#include <linux/time.h>
#include <linux/fs.h>
#include <linux/?@folderName?.h>
#include <linux/errno.h>
#select folderName
	#option jbd
#include <linux/mm.h>
#include <linux/pagemap.h>
#include <linux/bio.h>
#include <linux/blkdev.h>	
	#endoption
	#option jbd2
#include <linux/slab.h>
#include <linux/mm.h>
#include <linux/pagemap.h>
#include <linux/jiffies.h>
#include <linux/crc32.h>
#include <linux/writeback.h>
#include <linux/backing-dev.h>
#include <linux/bio.h>
#include <linux/blkdev.h>
#include <linux/bitops.h>
	#endoption
#endselect
#include <trace/events/jbd.h>

/*
 * Default IO end handler for temporary BJ_IO buffer_heads.
 */
static void journal_end_buffer_io_sync(struct buffer_head *bh, int uptodate)
{
	BUFFER_TRACE(bh, "");
	if (uptodate)
		set_buffer_uptodate(bh);
	else
		clear_buffer_uptodate(bh);
	unlock_buffer(bh);
}

/*
 * When an ext3-ordered file is truncated, it is possible that many pages are
 * not successfully freed, because they are attached to a committing transaction.
 * After the transaction commits, these pages are left on the LRU, with no
 * ->mapping, and with attached buffers.  These pages are trivially reclaimable
 * by the VM, but their apparent absence upsets the VM accounting, and it makes
 * the numbers in /proc/meminfo look odd.
 *
 * So here, we have a buffer which has just come off the forget list.  Look to
 * see if we can strip all buffers from the backing page.
 *
#select folderName
	#option jbd
 * Called under journal->j_list_lock.  The caller provided us with a ref
 * against the buffer, and we drop that here.
	#endoption
	#option jbd2
 * Called under lock_journal(), and possibly under journal_datalist_lock.  The
 * caller provided us with a ref against the buffer, and we drop that here.
	#endoption
#endselect
 */
static void release_buffer_page(struct buffer_head *bh)
{
	struct page *page;

	if (buffer_dirty(bh))
		goto nope;
	if (atomic_read(&bh->b_count) != 1)
		goto nope;
	page = bh->b_page;
	if (!page)
		goto nope;
	if (page->mapping)
		goto nope;

	/* OK, it's a truncated page */
	if (!trylock_page(page))
		goto nope;

	page_cache_get(page);
	__brelse(bh);
	try_to_free_buffers(page);
	unlock_page(page);
	page_cache_release(page);
	return;

nope:
	__brelse(bh);
}
#break: release_data_buffer_commit
/*
 * Decrement reference counter for data buffer. If it has been marked
 * 'BH_Freed', release it and the page to which it belongs if possible.
 */
static void release_data_buffer(struct buffer_head *bh)
{
	if (buffer_freed(bh)) {
		WARN_ON_ONCE(buffer_dirty(bh));
		clear_buffer_freed(bh);
		clear_buffer_mapped(bh);
		clear_buffer_new(bh);
		clear_buffer_req(bh);
		bh->b_bdev = NULL;
		release_buffer_page(bh);
	} else
		put_bh(bh);
}

/*
 * Try to acquire jbd_lock_bh_state() against the buffer, when j_list_lock is
 * held.  For ranking reasons we must trylock.  If we lose, schedule away and
 * return 0.  j_list_lock is dropped in this case.
 */
static int inverted_lock(journal_t *journal, struct buffer_head *bh)
{
	if (!jbd_trylock_bh_state(bh)) {
		spin_unlock(&journal->j_list_lock);
		schedule();
		return 0;
	}
	return 1;
}
#endbreak
/* Done it all: now write the commit record.  We should have
 * cleaned up our previous buffers by now, so if we are in abort
 * mode we can now just skip the rest of the journal write
 * entirely.
 *
 * Returns 1 if the journal needs to be aborted or 0 on success
 */
#break: journal_submit_commit
static int journal_write_commit_record(journal_t *journal,
					transaction_t *commit_transaction)
{
	struct journal_head *descriptor;
	struct buffer_head *bh;
	journal_header_t *header;
	int ret;

	if (is_journal_aborted(journal))
		return 0;

	descriptor = journal_get_descriptor_buffer(journal);
	if (!descriptor)
		return 1;

	bh = jh2bh(descriptor);

	header = (journal_header_t *)(bh->b_data);
	header->h_magic = cpu_to_be32(JFS_MAGIC_NUMBER);
	header->h_blocktype = cpu_to_be32(JFS_COMMIT_BLOCK);
	header->h_sequence = cpu_to_be32(commit_transaction->t_tid);

	JBUFFER_TRACE(descriptor, "write commit block");
	set_buffer_dirty(bh);

	if (journal->j_flags & JFS_BARRIER)
		ret = __sync_dirty_buffer(bh, WRITE_SYNC | WRITE_FLUSH_FUA);
	else
		ret = sync_dirty_buffer(bh);

	put_bh(bh);		/* One for getblk() */
	journal_put_journal_head(descriptor);

	return (ret == -EIO);
}

static void journal_do_submit_data(struct buffer_head **wbuf, int bufs,
				   int write_op)
{
	int i;

	for (i = 0; i < bufs; i++) {
		wbuf[i]->b_end_io = end_buffer_write_sync;
		/*
		 * Here we write back pagecache data that may be mmaped. Since
		 * we cannot afford to clean the page and set PageWriteback
		 * here due to lock ordering (page lock ranks above transaction
		 * start), the data can change while IO is in flight. Tell the
		 * block layer it should bounce the bio pages if stable data
		 * during write is required.
		 *
		 * We use up our safety reference in submit_bh().
		 */
		_submit_bh(write_op, wbuf[i], 1 << BIO_SNAP_STABLE);
	}
}

/*
 *  Submit all the data buffers to disk
 */
static int journal_submit_data_buffers(journal_t *journal,
				       transaction_t *commit_transaction,
				       int write_op)
{
	struct journal_head *jh;
	struct buffer_head *bh;
	int locked;
	int bufs = 0;
	struct buffer_head **wbuf = journal->j_wbuf;
	int err = 0;

	/*
	 * Whenever we unlock the journal and sleep, things can get added
	 * onto ->t_sync_datalist, so we have to keep looping back to
	 * write_out_data until we *know* that the list is empty.
	 *
	 * Cleanup any flushed data buffers from the data list.  Even in
	 * abort mode, we want to flush this out as soon as possible.
	 */
write_out_data:
	cond_resched();
	spin_lock(&journal->j_list_lock);

	while (commit_transaction->t_sync_datalist) {
		jh = commit_transaction->t_sync_datalist;
		bh = jh2bh(jh);
		locked = 0;

		/* Get reference just to make sure buffer does not disappear
		 * when we are forced to drop various locks */
		get_bh(bh);
		/* If the buffer is dirty, we need to submit IO and hence
		 * we need the buffer lock. We try to lock the buffer without
		 * blocking. If we fail, we need to drop j_list_lock and do
		 * blocking lock_buffer().
		 */
		if (buffer_dirty(bh)) {
			if (!trylock_buffer(bh)) {
				BUFFER_TRACE(bh, "needs blocking lock");
				spin_unlock(&journal->j_list_lock);
				trace_jbd_do_submit_data(journal,
						     commit_transaction);
				/* Write out all data to prevent deadlocks */
				journal_do_submit_data(wbuf, bufs, write_op);
				bufs = 0;
				lock_buffer(bh);
				spin_lock(&journal->j_list_lock);
			}
			locked = 1;
		}
		/* We have to get bh_state lock. Again out of order, sigh. */
		if (!inverted_lock(journal, bh)) {
			jbd_lock_bh_state(bh);
			spin_lock(&journal->j_list_lock);
		}
		/* Someone already cleaned up the buffer\? */
		if (!buffer_jbd(bh) || bh2jh(bh) != jh
			|| jh->b_transaction != commit_transaction
			|| jh->b_jlist != BJ_SyncData) {
			jbd_unlock_bh_state(bh);
			if (locked)
				unlock_buffer(bh);
			BUFFER_TRACE(bh, "already cleaned up");
			release_data_buffer(bh);
			continue;
		}
		if (locked && test_clear_buffer_dirty(bh)) {
			BUFFER_TRACE(bh, "needs writeout, adding to array");
			wbuf[bufs++] = bh;
			__journal_file_buffer(jh, commit_transaction,
						BJ_Locked);
			jbd_unlock_bh_state(bh);
			if (bufs == journal->j_wbufsize) {
				spin_unlock(&journal->j_list_lock);
				trace_jbd_do_submit_data(journal,
						     commit_transaction);
				journal_do_submit_data(wbuf, bufs, write_op);
				bufs = 0;
				goto write_out_data;
			}
		} else if (!locked && buffer_locked(bh)) {
			__journal_file_buffer(jh, commit_transaction,
						BJ_Locked);
			jbd_unlock_bh_state(bh);
			put_bh(bh);
		} else {
			BUFFER_TRACE(bh, "writeout complete: unfile");
			if (unlikely(!buffer_uptodate(bh)))
				err = -EIO;
			__journal_unfile_buffer(jh);
			jbd_unlock_bh_state(bh);
			if (locked)
				unlock_buffer(bh);
			release_data_buffer(bh);
		}

		if (need_resched() || spin_needbreak(&journal->j_list_lock)) {
			spin_unlock(&journal->j_list_lock);
			goto write_out_data;
		}
	}
	spin_unlock(&journal->j_list_lock);
	trace_jbd_do_submit_data(journal, commit_transaction);
	journal_do_submit_data(wbuf, bufs, write_op);

	return err;
}
#endbreak

/*
 * ?@jbd2Prefix?journal_commit_transaction
 *
 * The primary function for committing a transaction to the log.  This
 * function is called by the journal thread to begin a complete commit.
 */
void ?@jbd2Prefix?journal_commit_transaction(journal_t *journal)
{
#select folderName
	#option jbd2
	struct transaction_stats_s stats;
	#endoption
#endselect
	transaction_t *commit_transaction;
	struct journal_head *jh, *new_jh, *descriptor;
	struct buffer_head **wbuf = journal->j_wbuf;
	int bufs;
	int flags;
	int err;
	unsigned ?@typeChange? blocknr;
	ktime_t start_time;
	u64 commit_time;
	char *tagp = NULL;
	journal_header_t *header;
	journal_block_tag_t *tag = NULL;
	int space_left = 0;
	int first_tag = 0;
	int tag_flag;
	int i;
#select folderName
	#option jbd
	struct blk_plug plug;
	int write_op = WRITE;
	#endoption
	#option jbd2
	int tag_bytes = journal_tag_bytes(journal);
	struct buffer_head *cbh = NULL; /* For transactional checksums */
	__u32 crc32_sum = ~0;
	struct blk_plug plug;
	/* Tail of the journal */
	unsigned long first_block;
	tid_t first_tid;
	int update_tail;
	int csum_size = 0;

	if (JBD2_HAS_INCOMPAT_FEATURE(journal, JBD2_FEATURE_INCOMPAT_CSUM_V2))
		csum_size = sizeof(struct jbd2_journal_block_tail);
	#endoption
#endselect

	/*
	 * First job: lock down the current transaction and wait for
	 * all outstanding updates to complete.
	 */

	/* Do we need to erase the effects of a prior ?@jbd2Prefix?journal_flush\? */
	if (journal->j_flags & ?@jfsjbd2?_FLUSHED) {
		jbd_debug(3, "super block updated\n");
		mutex_lock(&journal->j_checkpoint_mutex);
		/*
		 * We hold j_checkpoint_mutex so tail cannot change under us.
		 * We don't need any special data guarantees for writing sb
		 * since journal is empty and it is ok for write to be
		 * flushed only with transaction commit.
		 */
		?@jbd2Prefix?journal_update_sb_log_tail(journal,
						journal->j_tail_sequence,
						journal->j_tail,
						WRITE_SYNC);
		mutex_unlock(&journal->j_checkpoint_mutex);
	} else {
		jbd_debug(3, "superblock not updated\n");
	}

	J_ASSERT(journal->j_running_transaction != NULL);
	J_ASSERT(journal->j_committing_transaction == NULL);

	commit_transaction = journal->j_running_transaction;
	J_ASSERT(commit_transaction->t_state == T_RUNNING);

	trace_?@folderName?_start_commit(journal, commit_transaction);
	jbd_debug(1, \"?@CAP_FILENAME?: starting commit of transaction %d\n\",
			commit_transaction->t_tid);

	?@spinWrite?_lock(&journal->j_state_lock);
	commit_transaction->t_state = T_LOCKED;

	trace_?@folderName?_commit_locking(journal, commit_transaction);
#select folderName
	#option jbd2
	stats.run.rs_wait = commit_transaction->t_max_wait;
	stats.run.rs_request_delay = 0;
	stats.run.rs_locked = jiffies;
	if (commit_transaction->t_requested)
		stats.run.rs_request_delay =
			?@jbd2Prefix?time_diff(commit_transaction->t_requested,
				       stats.run.rs_locked);
	stats.run.rs_running = ?@jbd2Prefix?time_diff(commit_transaction->t_start,
					      stats.run.rs_locked);
	#endoption
#endselect
						  
	spin_lock(&commit_transaction->t_handle_lock);
#select folderName
	#option jbd
	while (commit_transaction->t_updates) {
	#endoption
	#option jbd2
	while (atomic_read(&commit_transaction->t_updates)) {
	#endoption
#endselect
		DEFINE_WAIT(wait);

		prepare_to_wait(&journal->j_wait_updates, &wait,
					TASK_UNINTERRUPTIBLE);
#select folderName
	#option jbd
	if (commit_transaction->t_updates) {
	#endoption
	#option jbd2
	if (atomic_read(&commit_transaction->t_updates)) {
	#endoption
#endselect
			spin_unlock(&commit_transaction->t_handle_lock);
			?@spinWrite?_unlock(&journal->j_state_lock);
			schedule();
			?@spinWrite?_lock(&journal->j_state_lock);	
		spin_lock(&commit_transaction->t_handle_lock);
		}
		finish_wait(&journal->j_wait_updates, &wait);
	}
	spin_unlock(&commit_transaction->t_handle_lock);

#select folderName
	#option jbd
	J_ASSERT (commit_transaction->t_outstanding_credits <=
	#endoption
	#option jbd2
	J_ASSERT (atomic_read(&commit_transaction->t_outstanding_credits) <=
	#endoption
#endselect
		journal->j_max_transaction_buffers);
	
	/*
	 * First thing we are allowed to do is to discard any remaining
	 * BJ_Reserved buffers.  Note, it is _not_ permissible to assume
	 * that there are no such buffers: if a large filesystem
	 * operation like a truncate needs to split itself over multiple
	 * transactions, then it may try to do a ?@jbd2Prefix?journal_restart() while
	 * there are still BJ_Reserved buffers outstanding.  These must
	 * be released cleanly from the current transaction.
	 *
	 * In this case, the filesystem must still reserve write access
	 * again before modifying the buffer in the new transaction, but
	 * we do not require it to remember exactly which old buffers it
	 * has reserved.  This is consistent with the existing behaviour
	 * that multiple ?@jbd2Prefix?journal_get_write_access() calls to the same
	 * buffer are perfectly permissible.
	 */
	while (commit_transaction->t_reserved_list) {
		jh = commit_transaction->t_reserved_list;
		JBUFFER_TRACE(jh, "reserved, unused: refile");
		/*
		 * A ?@jbd2Prefix?journal_get_undo_access()+?@jbd2Prefix?journal_release_buffer() may
		 * leave undo-committed data.
		 */
		if (jh->b_committed_data) {
			struct buffer_head *bh = jh2bh(jh);

			jbd_lock_bh_state(bh);
			?@folderName?_free(jh->b_committed_data, bh->b_size);
			jh->b_committed_data = NULL;
			jbd_unlock_bh_state(bh);
		}
		?@jbd2Prefix?journal_refile_buffer(journal, jh);
	}

	/*
	 * Now try to drop any written-back buffers from the journal's
	 * checkpoint lists.  We do this *before* commit because it potentially
	 * frees some memory
	 */
	spin_lock(&journal->j_list_lock);
	__?@jbd2Prefix?journal_clean_checkpoint_list(journal);
	spin_unlock(&journal->j_list_lock);

	jbd_debug(3, \"?@CAP_FILENAME?: commit phase 1\n\");

	/*
	 * Clear revoked flag to reflect there is no revoked buffers
	 * in the next transaction which is going to be started.
	 */
	?@journalJbd2?_clear_buffer_revoked_flags(journal);

	/*
	 * Switch to a new revoke table.
	 */
	?@jbd2Prefix?journal_switch_revoke_table(journal);

	trace_?@folderName?_commit_flushing(journal, commit_transaction);
#select folderName
	#option jbd2
	stats.run.rs_flushing = jiffies;
	stats.run.rs_locked = jbd2_time_diff(stats.run.rs_locked,
					     stats.run.rs_flushing);
	#endoption
#endselect
	commit_transaction->t_state = T_FLUSH;
	journal->j_committing_transaction = commit_transaction;
	journal->j_running_transaction = NULL;
	start_time = ktime_get();
	commit_transaction->t_log_start = journal->j_head;
	wake_up(&journal->j_wait_transaction_locked);
	?@spinWrite?_unlock(&journal->j_state_lock);

	jbd_debug(3, \"?@CAP_FILENAME?: commit phase 2\n\");
#select folderName
	#option jbd
	if (tid_geq(journal->j_commit_waited, commit_transaction->t_tid))
		write_op = WRITE_SYNC;
	#endoption
#endselect

	/*
	 * Now start flushing things to disk, in the order they appear
	 * on the transaction lists.  Data blocks go first.
	 */
#break: journal_submit_data
	blk_start_plug(&plug);
	err = journal_submit_data_buffers(journal, commit_transaction,
					  write_op);
	blk_finish_plug(&plug);

	/*
	 * Wait for all previously submitted IO to complete.
	 */
	spin_lock(&journal->j_list_lock);
	while (commit_transaction->t_locked_list) {
		struct buffer_head *bh;

		jh = commit_transaction->t_locked_list->b_tprev;
		bh = jh2bh(jh);
		get_bh(bh);
		if (buffer_locked(bh)) {
			spin_unlock(&journal->j_list_lock);
			wait_on_buffer(bh);
			spin_lock(&journal->j_list_lock);
		}
		if (unlikely(!buffer_uptodate(bh))) {
			if (!trylock_page(bh->b_page)) {
				spin_unlock(&journal->j_list_lock);
				lock_page(bh->b_page);
				spin_lock(&journal->j_list_lock);
			}
			if (bh->b_page->mapping)
				set_bit(AS_EIO, &bh->b_page->mapping->flags);

			unlock_page(bh->b_page);
			SetPageError(bh->b_page);
			err = -EIO;
		}
		if (!inverted_lock(journal, bh)) {
			put_bh(bh);
			spin_lock(&journal->j_list_lock);
			continue;
		}
		if (buffer_jbd(bh) && bh2jh(bh) == jh &&
		    jh->b_transaction == commit_transaction &&
		    jh->b_jlist == BJ_Locked)
			__journal_unfile_buffer(jh);
		jbd_unlock_bh_state(bh);
		release_data_buffer(bh);
		cond_resched_lock(&journal->j_list_lock);
	}
	spin_unlock(&journal->j_list_lock);

	if (err) {
		char b[BDEVNAME_SIZE];

		printk(KERN_WARNING
			"JBD: Detected IO errors while flushing file data "
			"on %s\n", bdevname(journal->j_fs_dev, b));
		if (journal->j_flags & JFS_ABORT_ON_SYNCDATA_ERR)
			journal_abort(journal, err);
		err = 0;
	}

	blk_start_plug(&plug);

	journal_write_revoke_records(journal, commit_transaction, write_op);

	/*
	 * If we found any dirty or locked buffers, then we should have
	 * looped back up to the write_out_data label.  If there weren't
	 * any then journal_clean_data_list should have wiped the list
	 * clean by now, so check that it is in fact empty.
	 */
	J_ASSERT (commit_transaction->t_sync_datalist == NULL);
	jbd_debug (3, "JBD: commit phase 3\n");
#endbreak

	/*
	 * Way to go: we have now written out all of the data for a
	 * transaction!  Now comes the tricky part: we need to write out
	 * metadata.  Loop over the transaction's entire buffer list:
	 */
	?@spinWrite?_lock(&journal->j_state_lock);
	commit_transaction->t_state = T_COMMIT;
	?@spinWrite?_unlock(&journal->j_state_lock);

	trace_?@folderName?_commit_logging(journal, commit_transaction);
#select folderName
	#option jbd
	J_ASSERT(commit_transaction->t_nr_buffers <=
		 commit_transaction->t_outstanding_credits);

	descriptor = NULL;
	bufs = 0;
	#endoption
	#option jbd2
	stats.run.rs_logging = jiffies;
	stats.run.rs_flushing = jbd2_time_diff(stats.run.rs_flushing,
					       stats.run.rs_logging);
	stats.run.rs_blocks =
		atomic_read(&commit_transaction->t_outstanding_credits);
	stats.run.rs_blocks_logged = 0;

	J_ASSERT(commit_transaction->t_nr_buffers <=
		 atomic_read(&commit_transaction->t_outstanding_credits));

	err = 0;
	descriptor = NULL;
	bufs = 0;
	blk_start_plug(&plug);
	#endoption
#endselect
	while (commit_transaction->t_buffers) {

		/* Find the next buffer to be journaled... */

		jh = commit_transaction->t_buffers;

		/* If we're in abort mode, we just un-journal the buffer and
		   release it. */

		if (is_journal_aborted(journal)) {
			clear_buffer_jbddirty(jh2bh(jh));
			JBUFFER_TRACE(jh, "journal is aborting: refile");
#select folderName
	#option jbd2
			jbd2_buffer_abort_trigger(jh,
						  jh->b_frozen_data \?
						  jh->b_frozen_triggers :
						  jh->b_triggers);
	#endoption
#endselect
			?@jbd2Prefix?journal_refile_buffer(journal, jh);
			/* If that was the last one, we need to clean up
			 * any descriptor buffers which may have been
			 * already allocated, even if we are now
			 * aborting. */
			if (!commit_transaction->t_buffers)
				goto start_journal_io;
			continue;
		}

		/* Make sure we have a descriptor block in which to
		   record the metadata buffer. */

		if (!descriptor) {
			struct buffer_head *bh;

			J_ASSERT (bufs == 0);

			jbd_debug(4, \"?@CAP_FILENAME?: get descriptor\n\");

			descriptor = ?@jbd2Prefix?journal_get_descriptor_buffer(journal);
			if (!descriptor) {
				?@jbd2Prefix?journal_abort(journal, -EIO);
				continue;
			}

			bh = jh2bh(descriptor);
			jbd_debug(4, \"?@CAP_FILENAME?: got buffer %llu (%p)\n\",
				(unsigned long long)bh->b_blocknr, bh->b_data);
			header = (journal_header_t *)&bh->b_data[0];
			header->h_magic     = cpu_to_be32(?@jfsjbd2?_MAGIC_NUMBER);
			header->h_blocktype = cpu_to_be32(?@jfsjbd2?_DESCRIPTOR_BLOCK);
			header->h_sequence  = cpu_to_be32(commit_transaction->t_tid);

			tagp = &bh->b_data[sizeof(journal_header_t)];
			space_left = bh->b_size - sizeof(journal_header_t);
			first_tag = 1;
			set_buffer_jwrite(bh);
			set_buffer_dirty(bh);
			wbuf[bufs++] = bh;

			/* Record it so that we can wait for IO
                           completion later */
			BUFFER_TRACE(bh, "ph3: file as descriptor");
			?@jbd2Prefix?journal_file_buffer(descriptor, commit_transaction,
					BJ_LogCtl);
		}

		/* Where is the buffer to be written\? */

		err = ?@jbd2Prefix?journal_next_log_block(journal, &blocknr);
		/* If the block mapping failed, just abandon the buffer
		   and repeat this loop: we'll fall into the
		   refile-on-abort condition above. */
		if (err) {
			?@jbd2Prefix?journal_abort(journal, err);
			continue;
		}
	/*
		 * start_this_handle() uses t_outstanding_credits to determine
		 * the free space in the log, but this counter is changed
		 * by ?@jbd2Prefix?journal_next_log_block() also.
		 */
#select folderName
	#option jbd
		commit_transaction->t_outstanding_credits--;

		/* Bump b_count to prevent truncate from stumbling over
                   the shadowed buffer!  @@@ This can go if we ever get
                   rid of the BJ_IO/BJ_Shadow pairing of buffers. */
		get_bh(jh2bh(jh));

		/* Make a temporary IO buffer with which to write it out
                   (this will requeue both the metadata buffer and the
                   temporary IO buffer). new_bh goes on BJ_IO*/

		set_buffer_jwrite(jh2bh(jh));
	#endoption
	#option jbd2
		atomic_dec(&commit_transaction->t_outstanding_credits);

		/* Bump b_count to prevent truncate from stumbling over
                   the shadowed buffer!  @@@ This can go if we ever get
                   rid of the BJ_IO/BJ_Shadow pairing of buffers. */
		atomic_inc(&jh2bh(jh)->b_count);

		/* Make a temporary IO buffer with which to write it out
                   (this will requeue both the metadata buffer and the
                   temporary IO buffer). new_bh goes on BJ_IO*/

		set_bit(BH_JWrite, &jh2bh(jh)->b_state);
	#endoption
#endselect
		/*
		 * akpm: ?@jbd2Prefix?journal_write_metadata_buffer() sets
		 * new_bh->b_transaction to commit_transaction.
		 * We need to clean this up before we release new_bh
		 * (which is of type BJ_IO)
		 */
		JBUFFER_TRACE(jh, "ph3: write metadata");
		flags = ?@jbd2Prefix?journal_write_metadata_buffer(commit_transaction,
						      jh, &new_jh, blocknr);
#select folderName
	#option jbd	
		set_buffer_jwrite(jh2bh(new_jh));
	#endoption
	#option jbd2	
		if (flags < 0) {
			jbd2_journal_abort(journal, flags);
			continue;
		}
		set_bit(BH_JWrite, &jh2bh(new_jh)->b_state);
	#endoption
#endselect
		wbuf[bufs++] = jh2bh(new_jh);
		/* Record the new block's tag in the current descriptor
                   buffer */

		tag_flag = 0;
		if (flags & 1)
			tag_flag |= ?@jfsjbd2?_FLAG_ESCAPE;
		if (!first_tag)
			tag_flag |= ?@jfsjbd2?_FLAG_SAME_UUID;

		tag = (journal_block_tag_t *) tagp;
#select folderName
	#option jbd	
		tag->t_blocknr = cpu_to_be32(jh2bh(jh)->b_blocknr);
		tag->t_flags = cpu_to_be32(tag_flag);
	#endoption
	#option jbd2
		write_tag_block(tag_bytes, tag, jh2bh(jh)->b_blocknr);
		tag->t_flags = cpu_to_be16(tag_flag);
		jbd2_block_tag_csum_set(journal, tag, jh2bh(new_jh),
					commit_transaction->t_tid);
	#endoption
#endselect
		tagp += ?@tagbyte?;
		space_left -= ?@tagbyte?;

		if (first_tag) {
			memcpy (tagp, journal->j_uuid, 16);
			tagp += 16;
			space_left -= 16;
			first_tag = 0;
		}

		/* If there's no more to do, or if the descriptor is full,
		   let the IO rip! */

		if (bufs == journal->j_wbufsize ||
		    commit_transaction->t_buffers == NULL ||
#select folderName
	#option jbd
		space_left < sizeof(journal_block_tag_t) + 16) {
	#endoption
	#option jbd2
		space_left < tag_bytes + 16 + csum_size) {
	#endoption
#endselect
			jbd_debug(4, \"?@CAP_FILENAME?: Submit d IOs\n\", bufs);
			
			/* Write an end-of-descriptor marker before
                           submitting the IOs.  "tag" still points to
                           the last tag we set up. */
#select folderName
	#option jbd
			tag->t_flags |= cpu_to_be32(JFS_FLAG_LAST_TAG);
	#endoption
	#option jbd2
			tag->t_flags |= cpu_to_be16(JBD2_FLAG_LAST_TAG);
			jbd2_descr_block_csum_set(journal, descriptor);
	#endoption
#endselect
start_journal_io:
			for (i = 0; i < bufs; i++) {
				struct buffer_head *bh = wbuf[i];
#select folderName
	#option jbd2
				/*
				 * Compute checksum.
				 */
				if (JBD2_HAS_COMPAT_FEATURE(journal,
					JBD2_FEATURE_COMPAT_CHECKSUM)) {
					crc32_sum =
					    jbd2_checksum_data(crc32_sum, bh);
				}	
	#endoption
#endselect
				lock_buffer(bh);
				clear_buffer_dirty(bh);
				set_buffer_uptodate(bh);
				bh->b_end_io = journal_end_buffer_io_sync;
#select folderName
	#option jbd
				/*
				 * In data=journal mode, here we can end up
				 * writing pagecache data that might be
				 * mmapped. Since we can't afford to clean the
				 * page and set PageWriteback (see the comment
				 * near the other use of _submit_bh()), the
				 * data can change while the write is in
				 * flight.  Tell the block layer to bounce the
				 * bio pages if stable pages are required.
				 */
				_submit_bh(write_op, bh, 1 << BIO_SNAP_STABLE);
			}
			cond_resched();
	#endoption
	#option jbd2
				submit_bh(WRITE_SYNC, bh);
			}
			cond_resched();
			stats.run.rs_blocks_logged += bufs;

	#endoption
#endselect
			/* Force a new descriptor to be generated next
                           time round the loop. */
			descriptor = NULL;
			bufs = 0;
		}
	}
	
#break journal_finish_inode
	blk_finish_plug(&plug);

	/* Lo and behold: we have just managed to send a transaction to
           the log.  Before we can commit it, wait for the IO so far to
           complete.  Control buffers being written are on the
           transaction's t_log_list queue, and metadata buffers are on
           the t_iobuf_list queue.

	   Wait for the buffers in reverse order.  That way we are
	   less likely to be woken up until all IOs have completed, and
	   so we incur less scheduling load.
	*/

	jbd_debug(3, \"?@CAP_FILENAME?: commit phase ?@3to4?\n\");

	/*
	 * akpm: these are BJ_IO, and j_list_lock is not needed.
	 * See __journal_try_to_free_buffer.
	 */
wait_for_iobuf:
	while (commit_transaction->t_iobuf_list != NULL) {
		struct buffer_head *bh;

		jh = commit_transaction->t_iobuf_list->b_tprev;
		bh = jh2bh(jh);
		if (buffer_locked(bh)) {
			wait_on_buffer(bh);
			goto wait_for_iobuf;
		}
		if (cond_resched())
			goto wait_for_iobuf;

		if (unlikely(!buffer_uptodate(bh)))
			err = -EIO;

		clear_buffer_jwrite(bh);

		JBUFFER_TRACE(jh, "ph4: unfile after journal write");
		?@jbd2Prefix?journal_unfile_buffer(journal, jh);

		/*
		 * ->t_iobuf_list should contain only dummy buffer_heads
		 * which were created by ?@jbd2Prefix?journal_write_metadata_buffer().
		 */
		BUFFER_TRACE(bh, "dumping temporary bh");
		?@jbd2Prefix?journal_put_journal_head(jh);
		__brelse(bh);
		J_ASSERT_BH(bh, atomic_read(&bh->b_count) == 0);
		free_buffer_head(bh);

		/* We also have to unlock and free the corresponding
                   shadowed buffer */
		jh = commit_transaction->t_shadow_list->b_tprev;
		bh = jh2bh(jh);
#select folderName
	#option jbd
		clear_buffer_jwrite(bh);
	#endoption
	#option jbd2
		clear_bit(BH_JWrite, &bh->b_state);
	#endoption
#endselect

		J_ASSERT_BH(bh, buffer_jbddirty(bh));

		/* The metadata is now released for reuse, but we need
                   to remember it against this transaction so that when
                   we finally commit, we can do any checkpointing
                   required. */
		JBUFFER_TRACE(jh, "file as BJ_Forget");
		?@jbd2Prefix?journal_file_buffer(jh, commit_transaction, BJ_Forget);
		/*
		 * Wake up any transactions which were waiting for this IO to
		 * complete. The barrier must be here so that changes by
		 * ?@jbd2Prefix?journal_file_buffer() take effect before wake_up_bit()
		 * does the waitqueue check.
		 */
		smp_mb();
		wake_up_bit(&bh->b_state, BH_Unshadow);
		JBUFFER_TRACE(jh, "brelse shadowed buffer");
		__brelse(bh);
	}

	J_ASSERT (commit_transaction->t_shadow_list == NULL);

	jbd_debug(3, \"?@CAP_FILENAME?: commit phase ?@5to4?\n\");
	
		/* Here we wait for the revoke record and descriptor record buffers */
 wait_for_ctlbuf:
	while (commit_transaction->t_log_list != NULL) {
		struct buffer_head *bh;

		jh = commit_transaction->t_log_list->b_tprev;
		bh = jh2bh(jh);
		if (buffer_locked(bh)) {
			wait_on_buffer(bh);
			goto wait_for_ctlbuf;
		}
		if (cond_resched())
			goto wait_for_ctlbuf;

		if (unlikely(!buffer_uptodate(bh)))
			err = -EIO;

		BUFFER_TRACE(bh, "ph5: control buffer writeout done: unfile");
		clear_buffer_jwrite(bh);
		?@jbd2Prefix?journal_unfile_buffer(journal, jh);
		?@jbd2Prefix?journal_put_journal_head(jh);
		__brelse(bh);		/* One for getblk */
		/* AKPM: bforget here */
	}

	if (err)
		?@jbd2Prefix?journal_abort(journal, err);

	jbd_debug(3, \"?@CAP_FILENAME?: commit phase ?@5to6?\n\");
	?@spinWrite?_lock(&journal->j_state_lock);
#select folderName
	#option jbd
	J_ASSERT(commit_transaction->t_state == T_COMMIT);
	commit_transaction->t_state = T_COMMIT_RECORD;
	#endoption
	#option jbd2
	J_ASSERT(commit_transaction->t_state == T_COMMIT_DFLUSH);
	commit_transaction->t_state = T_COMMIT_JFLUSH;
	#endoption
#endselect
	?@spinWrite?_unlock(&journal->j_state_lock);
#break: write_commit_record
	if (journal_write_commit_record(journal, commit_transaction))
		err = -EIO;
	if (err)
		journal_abort(journal, err);
#endbreak
	/* End of a transaction!  Finally, we can do checkpoint
           processing: any buffers committed as a result of this
           transaction can be removed from any checkpoint list it was on
           before. */

#select folderName
	#option jbd
	jbd_debug(3, \"JBD: commit phase 7\n\");
	J_ASSERT(commit_transaction->t_sync_datalist == NULL);
	#endoption
	#option jbd2
	jbd_debug(3, \"JBD2: commit phase 6\n\");
	J_ASSERT(list_empty(&commit_transaction->t_inode_list));
	#endoption
#endselect
	J_ASSERT(commit_transaction->t_buffers == NULL);
	J_ASSERT(commit_transaction->t_checkpoint_list == NULL);
	J_ASSERT(commit_transaction->t_iobuf_list == NULL);
	J_ASSERT(commit_transaction->t_shadow_list == NULL);
	J_ASSERT(commit_transaction->t_log_list == NULL);

restart_loop:
	/*
	 * As there are other places (journal_unmap_buffer()) adding buffers
	 * to this list we have to be careful and hold the j_list_lock.
	 */
	spin_lock(&journal->j_list_lock);
	while (commit_transaction->t_forget) {
		transaction_t *cp_transaction;
		struct buffer_head *bh;
		int try_to_free = 0;

		jh = commit_transaction->t_forget;
		spin_unlock(&journal->j_list_lock);
		bh = jh2bh(jh);
		/*
		 * Get a reference so that bh cannot be freed before we are
		 * done with it.
		 */
		get_bh(bh);
		jbd_lock_bh_state(bh);
#select folderName
	#option jbd
		J_ASSERT_JH(jh,	jh->b_transaction == commit_transaction ||
			jh->b_transaction == journal->j_running_transaction);
	#endoption
	#option jbd2
		J_ASSERT_JH(jh,	jh->b_transaction == commit_transaction);
	#endoption
#endselect

		/*
		 * If there is undo-protected committed data against
		 * this buffer, then we can remove it now.  If it is a
		 * buffer needing such protection, the old frozen_data
		 * field now points to a committed version of the
		 * buffer, so rotate that field to the new committed
		 * data.
		 *
		 * Otherwise, we can just throw away the frozen data now.
#select folderName
	#option jbd
		 */
	#endoption
	#option jbd2
		 *
		 * We also know that the frozen data has already fired
		 * its triggers if they exist, so we can clear that too.
		 */
	#endoption
#endselect
		if (jh->b_committed_data) {
			?@folderName?_free(jh->b_committed_data, bh->b_size);
			jh->b_committed_data = NULL;
			if (jh->b_frozen_data) {
				jh->b_committed_data = jh->b_frozen_data;
				jh->b_frozen_data = NULL;
#select folderName
	#option jbd2
				jh->b_frozen_triggers = NULL;
	#endoption
#endselect
			}
		} else if (jh->b_frozen_data) {
			?@folderName?_free(jh->b_frozen_data, bh->b_size);
			jh->b_frozen_data = NULL;
#select folderName
	#option jbd2
			jh->b_frozen_triggers = NULL;
	#endoption
#endselect	
		}

		spin_lock(&journal->j_list_lock);
		cp_transaction = jh->b_cp_transaction;
		if (cp_transaction) {
			JBUFFER_TRACE(jh, "remove from old cp transaction");
#select folderName
	#option jbd2
			cp_transaction->t_chp_stats.cs_dropped++;
	#endoption
#endselect
			__?@jbd2Prefix?journal_remove_checkpoint(jh);
		}
		/* Only re-checkpoint the buffer_head if it is marked
		 * dirty.  If the buffer was added to the BJ_Forget list
		 * by ?@jbd2Prefix?journal_forget, it may no longer be dirty and
		 * there's no point in keeping a checkpoint record for
		 * it. */

		/*
		* A buffer which has been freed while still being journaled by
		* a previous transaction.
		*/
		if (buffer_freed(bh)) {
			/*
			 * If the running transaction is the one containing
			 * "add to orphan" operation (b_next_transaction !=
			 * NULL), we have to wait for that transaction to
			 * commit before we can really get rid of the buffer.
			 * So just clear b_modified to not confuse transaction
			 * credit accounting and refile the buffer to
			 * BJ_Forget of the running transaction. If the just
			 * committed transaction contains "add to orphan"
			 * operation, we can completely invalidate the buffer
			 * now. We are rather through in that since the
			 * buffer may be still accessible when blocksize <
			 * pagesize and it is attached to the last partial
			 * page.
			 */
			jh->b_modified = 0;
			if (!jh->b_next_transaction) {
				clear_buffer_freed(bh);
				clear_buffer_jbddirty(bh);
				clear_buffer_mapped(bh);
				clear_buffer_new(bh);
				clear_buffer_req(bh);
				bh->b_bdev = NULL;
			}
		}

		if (buffer_jbddirty(bh)) {
			JBUFFER_TRACE(jh, "add to new checkpointing trans");
			__?@jbd2Prefix?journal_insert_checkpoint(jh, commit_transaction);
			if (is_journal_aborted(journal))
				clear_buffer_jbddirty(bh);
		} else {
			J_ASSERT_BH(bh, !buffer_dirty(bh));
			/*
			 * The buffer on BJ_Forget list and not jbddirty means
			 * it has been freed by this transaction and hence it
			 * could not have been reallocated until this
			 * transaction has committed. *BUT* it could be
			 * reallocated once we have written all the data to
			 * disk and before we process the buffer on BJ_Forget
			 * list.
			 */
			if (!jh->b_next_transaction)
				try_to_free = 1;
		}
		JBUFFER_TRACE(jh, "refile or unfile buffer");
		__?@jbd2Prefix?journal_refile_buffer(jh);
		jbd_unlock_bh_state(bh);
		if (try_to_free)
			release_buffer_page(bh);	/* Drops bh reference */
		else
			__brelse(bh);
		cond_resched_lock(&journal->j_list_lock);
	}
	spin_unlock(&journal->j_list_lock);
	/*
	 * This is a bit sleazy.  We use j_list_lock to protect transition
	 * of a transaction into T_FINISHED state and calling
	 * __?@jbd2Prefix?journal_drop_transaction(). Otherwise we could race with
	 * other checkpointing code processing the transaction...
	 */
	?@spinWrite?_lock(&journal->j_state_lock);
	spin_lock(&journal->j_list_lock);
	/*
	 * Now recheck if some buffers did not get attached to the transaction
	 * while the lock was dropped...
	 */
	if (commit_transaction->t_forget) {
		spin_unlock(&journal->j_list_lock);
		?@spinWrite?_unlock(&journal->j_state_lock);
		goto restart_loop;
	}

	/* Done with this transaction! */

#break: commit_transaction
	jbd_debug(3, "JBD: commit phase 8\n");
	J_ASSERT(commit_transaction->t_state == T_COMMIT_RECORD);
	commit_transaction->t_state = T_FINISHED;
#endbreak
	J_ASSERT(commit_transaction == journal->j_committing_transaction);
	journal->j_commit_sequence = commit_transaction->t_tid;
	journal->j_committing_transaction = NULL;
	commit_time = ktime_to_ns(ktime_sub(ktime_get(), start_time));

	/*
	 * weight the commit time higher than the average time so we don't
	 * react too strongly to vast changes in the commit time
	 */
	if (likely(journal->j_average_commit_time))
		journal->j_average_commit_time = (commit_time +
				journal->j_average_commit_time*3) / 4;
	else
		journal->j_average_commit_time = commit_time;

	?@spinWrite?_unlock(&journal->j_state_lock);
#select folderName
	#option jbd
	if (commit_transaction->t_checkpoint_list == NULL &&
	    commit_transaction->t_checkpoint_io_list == NULL) {
		__journal_drop_transaction(journal, commit_transaction);
	} else {
	#endoption
#endselect
	if (journal->j_checkpoint_transactions == NULL) {
		journal->j_checkpoint_transactions = commit_transaction;
		commit_transaction->t_cpnext = commit_transaction;
		commit_transaction->t_cpprev = commit_transaction;
	} else {
		commit_transaction->t_cpnext =
			journal->j_checkpoint_transactions;
		commit_transaction->t_cpprev =
			commit_transaction->t_cpnext->t_cpprev;
		commit_transaction->t_cpnext->t_cpprev =
			commit_transaction;
		commit_transaction->t_cpprev->t_cpnext =
				commit_transaction;
	}
#select folderName
	#option jbd2
	spin_unlock(&journal->j_list_lock);
	/* Drop all spin_locks because commit_callback may be block.
	 * __journal_remove_checkpoint() can not destroy transaction
	 * under us because it is not marked as T_FINISHED yet */
	if (journal->j_commit_callback)
		journal->j_commit_callback(journal, commit_transaction);

	trace_jbd2_end_commit(journal, commit_transaction);
	jbd_debug(1, \"JBD2: commit %d complete, head %d\n\",
		  journal->j_commit_sequence, journal->j_tail_sequence);

	write_lock(&journal->j_state_lock);
	spin_lock(&journal->j_list_lock);
	commit_transaction->t_state = T_FINISHED;
	/* Recheck checkpoint lists after j_list_lock was dropped */
	if (commit_transaction->t_checkpoint_list == NULL &&
	    commit_transaction->t_checkpoint_io_list == NULL) {
		__jbd2_journal_drop_transaction(journal, commit_transaction);
		jbd2_journal_free_transaction(commit_transaction);
	#endoption
#endselect
	}
	spin_unlock(&journal->j_list_lock);
#select folderName
	#option jbd
	trace_jbd_end_commit(journal, commit_transaction);
	jbd_debug(1, \"?@CAP_FILENAME?: commit %d complete, head %d\n\",
		  journal->j_commit_sequence, journal->j_tail_sequence);	
	#endoption
	#option jbd2
	write_unlock(&journal->j_state_lock);
	#endoption
#endselect
	wake_up(&journal->j_wait_done_commit);
}