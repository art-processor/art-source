/*
 * Perform an actual checkpoint. We take the first transaction on the
 * list of transactions to be checkpointed and send all its buffers
 * to disk. We submit larger chunks of data at once.
 *
 * The journal should be locked before calling this function.
 * Called with j_checkpoint_mutex held.
 */
int ?@jbd2Prefix?log_do_checkpoint(journal_t *journal)
{
	transaction_t *transaction;
	tid_t this_tid;
	int result;

	jbd_debug(1, "Start checkpoint\n");

	/*
	 * First thing: if there are any transactions in the log which
	 * don't need checkpointing, just eliminate them from the
	 * journal straight away.
	 */
	result = ?@jbd2Prefix?cleanup_journal_tail(journal);
	trace_?@fileName?_checkpoint(journal, result);
	jbd_debug(1, "cleanup_journal_tail returned %d\n", result);
	if (result <= 0)
		return result;

	/*
	 * OK, we need to start writing disk blocks.  Take one transaction
	 * and write it.
	 */
	result = 0;
	spin_lock(&journal->j_list_lock);
	if (!journal->j_checkpoint_transactions)
		goto out;
	transaction = journal->j_checkpoint_transactions;
#select fileName
	#option jbd2
	if (transaction->t_chp_stats.cs_chp_time == 0)
		transaction->t_chp_stats.cs_chp_time = jiffies;
	#endoption
#endselect
	this_tid = transaction->t_tid;
restart:
	/*
	 * If someone cleaned up this transaction while we slept, we're
	 * done (maybe it's a new transaction, but it fell at the same
	 * address).
	 */
	if (journal->j_checkpoint_transactions == transaction &&
			transaction->t_tid == this_tid) {
		int batch_count = 0;
		
#select fileName
	#option jbd
		struct buffer_head *bhs[NR_BATCH];
		struct journal_head *jh;
		int retry = 0, err;

		while (!retry && transaction->t_checkpoint_list) {
			struct buffer_head *bh;

			jh = transaction->t_checkpoint_list;
			bh = jh2bh(jh);
			if (!jbd_trylock_bh_state(bh)) {
				jbd_sync_bh(journal, bh);
				retry = 1;
				break;
			}
			retry = __process_buffer(journal, jh, bhs,&batch_count);
	#endoption
	#option jbd2
		struct journal_head *jh;
		int retry = 0, err;

		while (!retry && transaction->t_checkpoint_list) {
			jh = transaction->t_checkpoint_list;
			retry = __process_buffer(journal, jh, &batch_count,
						 transaction);
	#endoption
#endselect
			if (retry < 0 && !result)
				result = retry;
			if (!retry && (need_resched() ||
				spin_needbreak(&journal->j_list_lock))) {
				spin_unlock(&journal->j_list_lock);
				retry = 1;
				break;
			}
		}

		if (batch_count) {
			if (!retry) {
				spin_unlock(&journal->j_list_lock);
				retry = 1;
			}
#select fileName
	#option jbd
		__flush_batch(journal, bhs, &batch_count);
	#endoption
	#option jbd2
		__flush_batch(journal, &batch_count);
	#endoption
#endselect		
		}
		if (retry) {
			spin_lock(&journal->j_list_lock);
			goto restart;
		}
		/*
		 * Now we have cleaned up the first transaction's checkpoint
		 * list. Let's clean up the second one
		 */
		err = __wait_cp_io(journal, transaction);
		if (!result)
			result = err;
	}
out:
	spin_unlock(&journal->j_list_lock);
	if (result < 0)
		?@jbd2Prefix?journal_abort(journal, result);
	else
		result = ?@jbd2Prefix?cleanup_journal_tail(journal);

	return (result < 0) \? result : 0;
}