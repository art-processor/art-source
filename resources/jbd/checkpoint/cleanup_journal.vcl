/*
 * Check the list of checkpoint transactions for the journal to see if
 * we have already got rid of any since the last update of the log tail
 * in the journal superblock.  If so, we can instantly roll the
 * superblock forward to remove those transactions from the log.
 *
 * Return <0 on error, 0 on success, 1 if there was nothing to clean up.
 *
 * This is the only part of the journaling code which really needs to be
 * aware of transaction aborts.  Checkpointing involves writing to the
 * main filesystem area rather than to the journal, so it can proceed
 * even in abort state, but we must not update the super block if
 * checkpointing may have failed.  Otherwise, we would lose some metadata
 * buffers which should be written-back to the filesystem.
 */

int ?@jbd2Prefix?cleanup_journal_tail(journal_t *journal)
{
#select fileName
	#option jbd
	transaction_t * transaction;
	tid_t		first_tid;
	unsigned int	blocknr, freed;

	if (is_journal_aborted(journal))
		return 1;

	/*
	 * OK, work out the oldest transaction remaining in the log, and
	 * the log block it starts at.
	 *
	 * If the log is now empty, we need to work out which is the
	 * next transaction ID we will write, and where it will
	 * start.
	 */
	spin_lock(&journal->j_state_lock);
	spin_lock(&journal->j_list_lock);
	transaction = journal->j_checkpoint_transactions;
	if (transaction) {
		first_tid = transaction->t_tid;
		blocknr = transaction->t_log_start;
	} else if ((transaction = journal->j_committing_transaction) != NULL) {
		first_tid = transaction->t_tid;
		blocknr = transaction->t_log_start;
	} else if ((transaction = journal->j_running_transaction) != NULL) {
		first_tid = transaction->t_tid;
		blocknr = journal->j_head;
	} else {
		first_tid = journal->j_transaction_sequence;
		blocknr = journal->j_head;
	}
	spin_unlock(&journal->j_list_lock);
	J_ASSERT(blocknr != 0);

	/* If the oldest pinned transaction is at the tail of the log
           already then there's not much we can do right now. */
	if (journal->j_tail_sequence == first_tid) {
		spin_unlock(&journal->j_state_lock);
		return 1;
	}
	spin_unlock(&journal->j_state_lock);

	/*
	 * We need to make sure that any blocks that were recently written out
	 * --- perhaps by log_do_checkpoint() --- are flushed out before we
	 * drop the transactions from the journal. Similarly we need to be sure
	 * superblock makes it to disk before next transaction starts reusing
	 * freed space (otherwise we could replay some blocks of the new
	 * transaction thinking they belong to the old one). So we use
	 * WRITE_FLUSH_FUA. It's unlikely this will be necessary, especially
	 * with an appropriately sized journal, but we need this to guarantee
	 * correctness.  Fortunately cleanup_journal_tail() doesn't get called
	 * all that often.
	 */
	journal_update_sb_log_tail(journal, first_tid, blocknr,
				   WRITE_FLUSH_FUA);

	spin_lock(&journal->j_state_lock);
	/* OK, update the superblock to recover the freed space.
	 * Physical blocks come first: have we wrapped beyond the end of
	 * the log\?  */
	freed = blocknr - journal->j_tail;
	if (blocknr < journal->j_tail)
		freed = freed + journal->j_last - journal->j_first;

	trace_jbd_cleanup_journal_tail(journal, first_tid, blocknr, freed);
	jbd_debug(1,
		  \"Cleaning journal tail from %d to %d (offset %u), \"
		  \"freeing %u\n\",
		  journal->j_tail_sequence, first_tid, blocknr, freed);

	journal->j_free += freed;
	journal->j_tail_sequence = first_tid;
	journal->j_tail = blocknr;
	spin_unlock(&journal->j_state_lock);
	#endoption
	#option jbd2
	tid_t		first_tid;
	unsigned long	blocknr;

	if (is_journal_aborted(journal))
		return 1;

	if (!jbd2_journal_get_log_tail(journal, &first_tid, &blocknr))
		return 1;
	J_ASSERT(blocknr != 0);

	/*
	 * We need to make sure that any blocks that were recently written out
	 * --- perhaps by jbd2_log_do_checkpoint() --- are flushed out before
	 * we drop the transactions from the journal. It's unlikely this will
	 * be necessary, especially with an appropriately sized journal, but we
	 * need this to guarantee correctness.  Fortunately
	 * jbd2_cleanup_journal_tail() doesn't get called all that often.
	 */
	if (journal->j_flags & JBD2_BARRIER)
		blkdev_issue_flush(journal->j_fs_dev, GFP_KERNEL, NULL);

	__jbd2_update_log_tail(journal, first_tid, blocknr);
	#endoption
#endselect
	return 0;
}