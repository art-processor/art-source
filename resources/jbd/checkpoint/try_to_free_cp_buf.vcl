/*
 * Try to release a checkpointed buffer from its transaction.
 * Returns 1 if we released it and 2 if we also released the
 * whole transaction.
 *
 * Requires j_list_lock
 * Called under jbd_lock_bh_state(jh2bh(jh)), and drops it
 */
static int __try_to_free_cp_buf(struct journal_head *jh)
{
	int ret = 0;
	struct buffer_head *bh = jh2bh(jh);
	
#select fileName
	#option jbd
	if (jh->b_jlist == BJ_None && !buffer_locked(bh) &&
	#endoption
	#option jbd2
	if (jh->b_transaction == NULL && !buffer_locked(bh) &&
	#endoption
#endselect
	!buffer_dirty(bh) && !buffer_write_io_error(bh)) {
		/*
		 * Get our reference so that bh cannot be freed before
		 * we unlock it
		 */
		get_bh(bh);
		JBUFFER_TRACE(jh, "remove from checkpoint list");
		ret = __?@jbd2Prefix?journal_remove_checkpoint(jh) + 1;
#select fileName
	#option jbd
	jbd_unlock_bh_state(bh);
	#endoption
#endselect
		BUFFER_TRACE(bh, "release");
		__brelse(bh);
#select fileName
	#option jbd
	} else {
		jbd_unlock_bh_state(bh);
	#endoption
#endselect
	}
	return ret;
}