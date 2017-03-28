#adapt: "resources/jbdSource/input/checkpoint.vcl"
	#select folderName
	  #option jbd
		  #insert-before __wait_cp_io
			if (!jbd_trylock_bh_state(bh)) {
				jbd_sync_bh(journal, bh);
				spin_lock(&journal->j_list_lock);
				goto restart;
			}
		  #endinsert
		  #insert-after __wait_cp_io
				jbd_unlock_bh_state(bh);
		  #endinsert
	  #endoption
	  #option jbd2
		  #insert __process_buffer
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
		  #endinsert
		  #insert __try_to_free_cp_buf
	if (jh->b_transaction == NULL && !buffer_locked(bh) &&
		!buffer_dirty(bh) && !buffer_write_io_error(bh)) {
			/*
			 * Get our reference so that bh cannot be freed before
			 * we unlock it
			 */
			get_bh(bh);
			JBUFFER_TRACE(jh, "remove from checkpoint list");
			ret = __?@jbd2Prefix?journal_remove_checkpoint(jh) + 1;
		BUFFER_TRACE(bh, "release");
			__brelse(bh);
		}
		return ret;
	}
		  #endinsert
		  #insert wait_for_space
		  #endinsert
		  #insert cleanup_journal_tail
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
		  #endinsert
		  #insert-before __wait_cp_io
		  #endinsert
		  #insert-after __wait_cp_io
		  #endinsert
	  #endoption
	#endselect
#endadapt
