/*
 * Try to flush one buffer from the checkpoint list to disk.
 *
 * Return 1 if something happened which requires us to abort the current
 * scan of the checkpoint list.  Return <0 if the buffer has failed to
 * be written out.
 *
 * Called with j_list_lock held and drops it if 1 is returned
 * Called under jbd_lock_bh_state(jh2bh(jh)), and drops it
 */
#select fileName
	#option jbd
static int __process_buffer(journal_t *journal, struct journal_head *jh,
			struct buffer_head **bhs, int *batch_count)
	#endoption
	#option jbd2
static int __process_buffer(journal_t *journal, struct journal_head *jh,
			    int *batch_count, transaction_t *transaction)
	#endoption
#endselect
{
	struct buffer_head *bh = jh2bh(jh);
	int ret = 0;

	if (buffer_locked(bh)) {
		get_bh(bh);
		spin_unlock(&journal->j_list_lock);
#select fileName
	#option jbd
		jbd_unlock_bh_state(bh);
	#endoption
#endselect
		wait_on_buffer(bh);
		/* the journal_head may have gone by now */
		BUFFER_TRACE(bh, "brelse");
		__brelse(bh);
		ret = 1;
	} else if (jh->b_transaction != NULL) {
		transaction_t *t = jh->b_transaction;
		tid_t tid = t->t_tid;

#select fileName
	#option jbd
		spin_unlock(&journal->j_list_lock);
		jbd_unlock_bh_state(bh);
	#endoption
	#option jbd2
		transaction->t_chp_stats.cs_forced_to_close++;
		spin_unlock(&journal->j_list_lock);
		if (unlikely(journal->j_flags & JBD2_UNMOUNT))
			/*
			 * The journal thread is dead; so starting and
			 * waiting for a commit to finish will cause
			 * us to wait for a _very_ long time.
			 */
			printk(KERN_ERR \"JBD2: %s: \"
			       \"Waiting for Godot: block %llu\n\",
			       journal->j_devname,
			       (unsigned long long) bh->b_blocknr);
	#endoption
#endselect
		?@jbd2Prefix?log_start_commit(journal, tid);
		?@jbd2Prefix?log_wait_commit(journal, tid);
		ret = 1;
	} else if (!buffer_dirty(bh)) {
		ret = 1;
		if (unlikely(buffer_write_io_error(bh)))
			ret = -EIO;
		get_bh(bh);
#select fileName
	#option jbd
		J_ASSERT_JH(jh, !buffer_jbddirty(bh));
	#endoption
#endselect
		BUFFER_TRACE(bh, "remove from checkpoint");
		__?@jbd2Prefix?journal_remove_checkpoint(jh);
		spin_unlock(&journal->j_list_lock);
#select fileName
	#option jbd
		jbd_unlock_bh_state(bh);
	#endoption
#endselect	
		__brelse(bh);
	} else {
		/*
		 * Important: we are about to write the buffer, and
		 * possibly block, while still holding the journal lock.
		 * We cannot afford to let the transaction logic start
		 * messing around with this buffer before we write it to
		 * disk, as that would break recoverability.
		 */
		BUFFER_TRACE(bh, "queue");
		get_bh(bh);
		J_ASSERT_BH(bh, !buffer_jwrite(bh));
#select fileName
	#option jbd
		set_buffer_jwrite(bh);
		bhs[*batch_count] = bh;
		__buffer_relink_io(jh);
		jbd_unlock_bh_state(bh);
		(*batch_count)++;
		if (*batch_count == NR_BATCH) {
			spin_unlock(&journal->j_list_lock);
			__flush_batch(journal, bhs, batch_count);
	#endoption
	#option jbd2
				journal->j_chkpt_bhs[*batch_count] = bh;
		__buffer_relink_io(jh);
		transaction->t_chp_stats.cs_written++;
		(*batch_count)++;
		if (*batch_count == JBD2_NR_BATCH) {
			spin_unlock(&journal->j_list_lock);
			__flush_batch(journal, batch_count);
	#endoption
#endselect
			ret = 1;
		}
	}
	return ret;
}