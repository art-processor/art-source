/*
 * __?@jbd2Prefix?log_wait_for_space: wait until there is space in the journal.
 *
 * Called under j-state_lock *only*.  It will be unlocked if we have to wait
 * for a checkpoint to free up some space in the log.
 */
void __?@jbd2Prefix?log_wait_for_space(journal_t *journal)
{
	int nblocks, space_left;
#select fileName
	#option jbd
	assert_spin_locked(&journal->j_state_lock);
	#endoption
#endselect
	nblocks = jbd_space_needed(journal);
	while (__?@jbd2Prefix?log_space_left(journal) < nblocks) {
#select fileName
	#option jbd
		if (journal->j_flags & JFS_ABORT)
	#endoption
	#option jbd2
		if (journal->j_flags & JBD2_ABORT)
	#endoption
#endselect
			return;
		?@spinWrite?_unlock(&journal->j_state_lock);
		mutex_lock(&journal->j_checkpoint_mutex);

		/*
		 * Test again, another process may have checkpointed while we
		 * were waiting for the checkpoint lock. If there are no
		 * transactions ready to be checkpointed, try to recover
		 * journal space by calling cleanup_journal_tail(), and if
		 * that doesn't work, by waiting for the currently committing
		 * transaction to complete.  If there is absolutely no way
		 * to make progress, this is either a BUG or corrupted
		 * filesystem, so abort the journal and leave a stack
		 * trace for forensic evidence.
		 */
		?@spinWrite?_lock(&journal->j_state_lock);
		spin_lock(&journal->j_list_lock);
		nblocks = jbd_space_needed(journal);
		space_left = __?@jbd2Prefix?log_space_left(journal);
		if (space_left < nblocks) {
			int chkpt = journal->j_checkpoint_transactions != NULL;
			tid_t tid = 0;

			if (journal->j_committing_transaction)
				tid = journal->j_committing_transaction->t_tid;
			spin_unlock(&journal->j_list_lock);
			?@spinWrite?_unlock(&journal->j_state_lock);
			if (chkpt) {
				?@jbd2Prefix?log_do_checkpoint(journal);
			} else if (?@jbd2Prefix?cleanup_journal_tail(journal) == 0) {
				/* We were able to recover space; yay! */
				;
			} else if (tid) {
				?@jbd2Prefix?log_wait_commit(journal, tid);
			} else {
				printk(KERN_ERR "%s: needed %d blocks and "
				       "only had %d space available\n",
				       __func__, nblocks, space_left);
#select fileName
	#option jbd
				printk(KERN_ERR \"%s: no way to get more \"
				       \"journal space\n\", __func__);
	#endoption
	#option jbd2
				printk(KERN_ERR \"%s: no way to get more \"
				       \"journal space in %s\n\", __func__,
				       journal->j_devname);
	#endoption
#endselect
				WARN_ON(1);
				?@jbd2Prefix?journal_abort(journal, 0);
			}
			?@spinWrite?_lock(&journal->j_state_lock);
		} else {
			spin_unlock(&journal->j_list_lock);
		}
		mutex_unlock(&journal->j_checkpoint_mutex);
	}
}