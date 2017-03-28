void __?@jbd2Prefix?journal_drop_transaction(journal_t *journal, transaction_t *transaction)
{
	assert_spin_locked(&journal->j_list_lock);
	if (transaction->t_cpnext) {
		transaction->t_cpnext->t_cpprev = transaction->t_cpprev;
		transaction->t_cpprev->t_cpnext = transaction->t_cpnext;
		if (journal->j_checkpoint_transactions == transaction)
			journal->j_checkpoint_transactions =
				transaction->t_cpnext;
		if (journal->j_checkpoint_transactions == transaction)
			journal->j_checkpoint_transactions = NULL;
	}
	
	J_ASSERT(transaction->t_state == T_FINISHED);
	J_ASSERT(transaction->t_buffers == NULL);
#select fileName
	#option jbd
	J_ASSERT(transaction->t_sync_datalist == NULL);
	#endoption
#endselect
	J_ASSERT(transaction->t_forget == NULL);
	J_ASSERT(transaction->t_iobuf_list == NULL);
	J_ASSERT(transaction->t_shadow_list == NULL);
	J_ASSERT(transaction->t_log_list == NULL);
	J_ASSERT(transaction->t_checkpoint_list == NULL);
	J_ASSERT(transaction->t_checkpoint_io_list == NULL);
#select fileName
	#option jbd
	J_ASSERT(transaction->t_updates == 0);
	#endoption
	#option jbd2
	J_ASSERT(atomic_read(&transaction->t_updates) == 0);
	#endoption
#endselect
	
	J_ASSERT(journal->j_committing_transaction != transaction);
	J_ASSERT(journal->j_running_transaction != transaction);

	trace_?@fileName?_drop_transaction(journal, transaction);
	jbd_debug(1, "Dropping transaction %d, all done\n", transaction->t_tid);
#select fileName
	#option jbd
	kfree(transaction);
	#endoption
#endselect
}