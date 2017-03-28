#select fileName
	#option jbd
/*
 * We were unable to perform jbd_trylock_bh_state() inside j_list_lock.
 * The caller must restart a list walk.  Wait for someone else to run
 * jbd_unlock_bh_state().
 */
static void jbd_sync_bh(journal_t *journal, struct buffer_head *bh)
	__releases(journal->j_list_lock)
{
	get_bh(bh);
	spin_unlock(&journal->j_list_lock);
	jbd_lock_bh_state(bh);
	jbd_unlock_bh_state(bh);
	put_bh(bh);
}
	#endoption
#endselect