/* Checkpoint list management */

/*
 * journal_clean_one_cp_list
 *
 * Find all the written-back checkpoint buffers in the given list and release
 * them.
 *
 * Called with j_list_lock held.
 * Returns number of buffers reaped (for debug)
 */

static int journal_clean_one_cp_list(struct journal_head *jh, int *released)
{
	struct journal_head *last_jh;
	struct journal_head *next_jh = jh;
	int ret, freed = 0;

	*released = 0;
	if (!jh)
		return 0;

	last_jh = jh->b_cpprev;
	do {
		jh = next_jh;
		next_jh = jh->b_cpnext;
#select fileName
	#option jbd
		/* Use trylock because of the ranking */
		if (jbd_trylock_bh_state(jh2bh(jh))) {
	#endoption
#endselect
			ret = __try_to_free_cp_buf(jh);
			if (ret) {
				freed++;
				if (ret == 2) {
					*released = 1;
					return freed;
				}
			}
#select fileName
	#option jbd
		}
	#endoption
#endselect
		/*
		 * This function only frees up some memory
		 * if possible so we dont have an obligation
		 * to finish processing. Bail out if preemption
		 * requested:
		 */
		if (need_resched())
			return freed;
	} while (jh != last_jh);

	return freed;
}