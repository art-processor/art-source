#break copyright
 *
 * Generic filesystem journal-writing code; part of the ext2fs
 * journaling system.
 *
 * This file manages journals: areas of disk reserved for logging
 * transactional updates.  This includes the kernel journaling thread
 * which is responsible for scheduling updates to the log.
 *
 * We do not actually manage the physical storage of the journal in this
 * file: that is left to a per-journal policy function, which allows us
 * to store the journal within a filesystem-specified area for ext2
 * journaling (ext2 can use a reserved inode for storing the log).
 */

#include <linux/module.h>
#include <linux/time.h>
#include <linux/fs.h>
#include <linux/?@folderName?.h>
#include <linux/errno.h>
#include <linux/slab.h>
#include <linux/init.h>
#include <linux/mm.h>
#include <linux/freezer.h>
#include <linux/pagemap.h>
#include <linux/kthread.h>
#include <linux/poison.h>
#include <linux/proc_fs.h>
#break: moreInclude
#include <linux/ratelimit.h>

#define CREATE_TRACE_POINTS
#include <trace/events/?@folderName?.h>

#include <asm/uaccess.h>
#include <asm/page.h>
#endbreak
EXPORT_SYMBOL(?@jbd2Prefix?journal_extend);
EXPORT_SYMBOL(?@jbd2Prefix?journal_stop);
EXPORT_SYMBOL(?@jbd2Prefix?journal_lock_updates);
EXPORT_SYMBOL(?@jbd2Prefix?journal_unlock_updates);
EXPORT_SYMBOL(?@jbd2Prefix?journal_get_write_access);
EXPORT_SYMBOL(?@jbd2Prefix?journal_get_create_access);
EXPORT_SYMBOL(?@jbd2Prefix?journal_get_undo_access);
#select folderName
	#option jbd
EXPORT_SYMBOL(journal_dirty_data);
EXPORT_SYMBOL(journal_dirty_metadata);
EXPORT_SYMBOL(journal_release_buffer);
	#endoption
	#option jbd2
EXPORT_SYMBOL(jbd2_journal_set_triggers);
EXPORT_SYMBOL(jbd2_journal_dirty_metadata);
	#endoption
#endselect
EXPORT_SYMBOL(?@jbd2Prefix?journal_forget);
#if 0
EXPORT_SYMBOL(journal_sync_buffer);
#endif
EXPORT_SYMBOL(?@jbd2Prefix?journal_flush);
EXPORT_SYMBOL(?@jbd2Prefix?journal_revoke);

EXPORT_SYMBOL(?@jbd2Prefix?journal_init_dev);
EXPORT_SYMBOL(?@jbd2Prefix?journal_init_inode);
#select folderName
	#option jbd
EXPORT_SYMBOL(journal_update_format);	
	#endoption
#endselect
EXPORT_SYMBOL(?@jbd2Prefix?journal_check_used_features);
EXPORT_SYMBOL(?@jbd2Prefix?journal_check_available_features);
EXPORT_SYMBOL(?@jbd2Prefix?journal_set_features);
#select folderName
	#option jbd
EXPORT_SYMBOL(journal_create);
	#endoption
#endselect
EXPORT_SYMBOL(?@jbd2Prefix?journal_load);
EXPORT_SYMBOL(?@jbd2Prefix?journal_destroy);
EXPORT_SYMBOL(?@jbd2Prefix?journal_abort);
EXPORT_SYMBOL(?@jbd2Prefix?journal_errno);
EXPORT_SYMBOL(?@jbd2Prefix?journal_ack_err);
EXPORT_SYMBOL(?@jbd2Prefix?journal_clear_err);
EXPORT_SYMBOL(?@jbd2Prefix?log_wait_commit);
EXPORT_SYMBOL(?@jbd2Prefix?log_start_commit);
EXPORT_SYMBOL(?@jbd2Prefix?journal_start_commit);
EXPORT_SYMBOL(?@jbd2Prefix?journal_force_commit_nested);
EXPORT_SYMBOL(?@jbd2Prefix?journal_wipe);
EXPORT_SYMBOL(?@jbd2Prefix?journal_blocks_per_page);
EXPORT_SYMBOL(?@jbd2Prefix?journal_invalidatepage);
EXPORT_SYMBOL(?@jbd2Prefix?journal_try_to_free_buffers);
EXPORT_SYMBOL(?@jbd2Prefix?journal_force_commit);
#break: exportSymbols
static int journal_convert_superblock_v1(journal_t *, journal_superblock_t *);
static void __journal_abort_soft (journal_t *journal, int errno);
static const char *journal_dev_name(journal_t *journal, char *buffer);
#endbreak
/*
 * Helper function used to manage commit timeouts
 */

static void commit_timeout(unsigned long __data)
{
	struct task_struct * p = (struct task_struct *) __data;

	wake_up_process(p);
}

/*
 * ?@kjournald?: The main thread function used to manage a logging device
 * journal.
 *
 * This kernel thread is responsible for two things:
 *
 * 1) COMMIT:  Every so often we need to commit the current state of the
 *    filesystem to disk.  The journal thread is responsible for writing
 *    all of the metadata buffers to disk.
 *
 * 2) CHECKPOINT: We cannot reuse a used section of the log file until all
 *    of the data in that part of the log has been rewritten elsewhere on
 *    the disk.  Flushing these old buffers to reclaim space in the log is
 *    known as checkpointing, and this thread is responsible for that job.
 */

static int ?@kjournald?(void *arg)
{
	journal_t *journal = arg;
	transaction_t *transaction;

	/*
	 * Set up an interval timer which can be used to trigger a commit wakeup
	 * after the commit interval expires
	 */
	setup_timer(&journal->j_commit_timer, commit_timeout,
			(unsigned long)current);

	set_freezable();

	/* Record that the journal thread is running */
	journal->j_task = current;
	wake_up(&journal->j_wait_done_commit);
#select folderName
	#option jbd
	printk(KERN_INFO \"kjournald starting.  Commit interval %ld seconds\n\",
			journal->j_commit_interval / HZ);
	#endoption
#endselect

	/*
	 * And now, wait forever for commit wakeup events.
	 */
	?@spinWrite?_lock(&journal->j_state_lock);

loop:
	if (journal->j_flags & ?@jfsjbd2?_UNMOUNT)
		goto end_loop;

	jbd_debug(1, \"commit_sequence=%d, commit_request=%d\n\",
		journal->j_commit_sequence, journal->j_commit_request);

	if (journal->j_commit_sequence != journal->j_commit_request) {
		jbd_debug(1, "OK, requests differ\n");
		?@spinWrite?_unlock(&journal->j_state_lock);
		del_timer_sync(&journal->j_commit_timer);
		?@jbd2Prefix?journal_commit_transaction(journal);
		?@spinWrite?_lock(&journal->j_state_lock);
		goto loop;
	}

	wake_up(&journal->j_wait_done_commit);
	if (freezing(current)) {
		/*
		 * The simpler the better. Flushing journal isn't a
		 * good idea, because that depends on threads that may
		 * be already stopped.
		 */
		jbd_debug(1, \"Now suspending ?@kjournald?\n\");
		?@spinWrite?_unlock(&journal->j_state_lock);
		try_to_freeze();
		?@spinWrite?_lock(&journal->j_state_lock);
	} else {
		/*
		 * We assume on resume that commits are already there,
		 * so we don't sleep
		 */
		DEFINE_WAIT(wait);
		int should_sleep = 1;

		prepare_to_wait(&journal->j_wait_commit, &wait,
				TASK_INTERRUPTIBLE);
		if (journal->j_commit_sequence != journal->j_commit_request)
			should_sleep = 0;
		transaction = journal->j_running_transaction;
		if (transaction && time_after_eq(jiffies,
						transaction->t_expires))
			should_sleep = 0;
			if (journal->j_flags & ?@jfsjbd2?_UNMOUNT)
			should_sleep = 0;
		if (should_sleep) {
			?@spinWrite?_unlock(&journal->j_state_lock);
			schedule();
			?@spinWrite?_lock(&journal->j_state_lock);
		}
		finish_wait(&journal->j_wait_commit, &wait);
	}

	jbd_debug(1, \"?@kjournald? wakes\n\");

	/*
	 * Were we woken up by a commit wakeup event\?
	 */
	transaction = journal->j_running_transaction;
	if (transaction && time_after_eq(jiffies, transaction->t_expires)) {
		journal->j_commit_request = transaction->t_tid;
		jbd_debug(1, \"woke because of timeout\n\");
	}
	goto loop;

end_loop:
	?@spinWrite?_unlock(&journal->j_state_lock);
	del_timer_sync(&journal->j_commit_timer);
	journal->j_task = NULL;
	wake_up(&journal->j_wait_done_commit);
	jbd_debug(1, \"Journal thread exiting.\n\");
	return 0;
}

static int ?@jbd2Prefix?journal_start_thread(journal_t *journal)
{
	struct task_struct *t;

	t = kthread_run(?@kjournald?, journal, ?@kjournaldJBD2?);
	if (IS_ERR(t))
		return PTR_ERR(t);

	wait_event(journal->j_wait_done_commit, journal->j_task != NULL);
	return 0;
}

static void journal_kill_thread(journal_t *journal)
{
	?@spinWrite?_lock(&journal->j_state_lock);
	journal->j_flags |= ?@jfsjbd2?_UNMOUNT;

	while (journal->j_task) {
		wake_up(&journal->j_wait_commit);
		?@spinWrite?_unlock(&journal->j_state_lock);
		wait_event(journal->j_wait_done_commit, journal->j_task == NULL);
		?@spinWrite?_lock(&journal->j_state_lock);
	}
	?@spinWrite?_unlock(&journal->j_state_lock);
}

/*
 * ?@jbd2Prefix?journal_write_metadata_buffer: write a metadata buffer to the journal.
 *
 * Writes a metadata buffer to a given disk block.  The actual IO is not
 * performed but a new buffer_head is constructed which labels the data
 * to be written with the correct destination disk block.
 *
 * Any magic-number escaping which needs to be done will cause a
 * copy-out here.  If the buffer happens to start with the
 * ?@jfsjbd2?_MAGIC_NUMBER, then we can't write it to the log directly: the
 * magic number is only written to the log for descripter blocks.  In
 * this case, we copy the data and replace the first word with 0, and we
 * return a result code which indicates that this buffer needs to be
 * marked as an escaped buffer in the corresponding log descriptor
 * block.  The missing word can then be restored when the block is read
 * during recovery.
 *
 * If the source buffer has already been modified by a new transaction
 * since we took the last commit snapshot, we use the frozen copy of
 * that data for IO.  If we end up using the existing buffer_head's data
 * for the write, then we *have* to lock the buffer to prevent anyone
 * else from using and possibly modifying it while the IO is in
 * progress.
 *
 * The function returns a pointer to the buffer_heads to be used for IO.
 *
 * We assume that the journal has already been locked in this function.
 *
 * Return value:
 *  <0: Error
 * >=0: Finished OK
 *
 * On success:
 * Bit 0 set == escape performed on the data
 * Bit 1 set == buffer copy-out performed (kfree the data after IO)
 */
 
 int ?@jbd2Prefix?journal_write_metadata_buffer(transaction_t *transaction,
				  struct journal_head  *jh_in,
				  struct journal_head **jh_out,
				  unsigned ?@typeChange? blocknr)
{
	int need_copy_out = 0;
	int done_copy_out = 0;
	int do_escape = 0;
	char *mapped_data;
	struct buffer_head *new_bh;
	struct journal_head *new_jh;
	struct page *new_page;
	unsigned int new_offset;
	struct buffer_head *bh_in = jh2bh(jh_in);
	journal_t *journal = transaction->t_journal;

	/*
	 * The buffer really shouldn't be locked: only the current committing
	 * transaction is allowed to write it, so nobody else is allowed
	 * to do any IO.
	 *
	 * akpm: except if we're journalling data, and write() output is
	 * also part of a shared mapping, and another thread has
	 * decided to launch a writepage() against this buffer.
	 */
	J_ASSERT_BH(bh_in, buffer_jbddirty(bh_in));
	
#select folderName
	#option jbd
	new_bh = alloc_buffer_head(GFP_NOFS|__GFP_NOFAIL);
	#endoption
	#option jbd2
retry_alloc:
	new_bh = alloc_buffer_head(GFP_NOFS);
	if (!new_bh) {
		/*
		 * Failure is not an option, but __GFP_NOFAIL is going
		 * away; so we retry ourselves here.
		 */
		congestion_wait(BLK_RW_ASYNC, HZ/50);
		goto retry_alloc;
	}
	#endoption
#endselect

	/* keep subsequent assertions sane */
	atomic_set(&new_bh->b_count, 1);
	new_jh = ?@jbd2Prefix?journal_add_journal_head(new_bh);	/* This sleeps */

	/*
	 * If a new transaction has already done a buffer copy-out, then
	 * we use that version of the data for the commit.
	 */
	jbd_lock_bh_state(bh_in);
repeat:
	if (jh_in->b_frozen_data) {
		done_copy_out = 1;
		new_page = virt_to_page(jh_in->b_frozen_data);
		new_offset = offset_in_page(jh_in->b_frozen_data);
	} else {
		new_page = jh2bh(jh_in)->b_page;
		new_offset = offset_in_page(jh2bh(jh_in)->b_data);
	}

	mapped_data = kmap_atomic(new_page);
	/*
#select folderName
	#option jbd2
	 * Fire data frozen trigger if data already wasn't frozen.  Do this
	 * before checking for escaping, as the trigger may modify the magic
	 * offset.  If a copy-out happens afterwards, it will have the correct
	 * data in the buffer.
	 */
	if (!done_copy_out)
		jbd2_buffer_frozen_trigger(jh_in, mapped_data + new_offset,
					   jh_in->b_triggers);

	/*
	#endoption
#endselect
	 * Check for escaping
	 */
	if (*((__be32 *)(mapped_data + new_offset)) ==
				cpu_to_be32(?@jfsjbd2?_MAGIC_NUMBER)) {
		need_copy_out = 1;
		do_escape = 1;
	}
	kunmap_atomic(mapped_data);

	/*
	 * Do we need to do a data copy\?
	 */
	if (need_copy_out && !done_copy_out) {
		char *tmp;

		jbd_unlock_bh_state(bh_in);
		tmp = ?@folderName?_alloc(bh_in->b_size, GFP_NOFS);
#select folderName
	#option jbd2
		if (!tmp) {
			jbd2_journal_put_journal_head(new_jh);
			return -ENOMEM;
		}
	#endoption
#endselect
		jbd_lock_bh_state(bh_in);
		if (jh_in->b_frozen_data) {
			?@folderName?_free(tmp, bh_in->b_size);
			goto repeat;
		}

		jh_in->b_frozen_data = tmp;
		mapped_data = kmap_atomic(new_page);
		memcpy(tmp, mapped_data + new_offset, jh2bh(jh_in)->b_size);
		kunmap_atomic(mapped_data);

		new_page = virt_to_page(tmp);
		new_offset = offset_in_page(tmp);
		done_copy_out = 1;
#select folderName
	#option jbd2
		/*
		 * This isn't strictly necessary, as we're using frozen
		 * data for the escaping, but it keeps consistency with
		 * b_frozen_data usage.
		 */
		jh_in->b_frozen_triggers = jh_in->b_triggers;
	#endoption
#endselect		
	}
	
	/*
	 * Did we need to do an escaping\?  Now we've done all the
	 * copying, we can finally do so.
	 */
	if (do_escape) {
		mapped_data = kmap_atomic(new_page);
		*((unsigned int *)(mapped_data + new_offset)) = 0;
		kunmap_atomic(mapped_data);
	}

	set_bh_page(new_bh, new_page, new_offset);
	new_jh->b_transaction = NULL;
	new_bh->b_size = jh2bh(jh_in)->b_size;
	new_bh->b_bdev = transaction->t_journal->j_dev;
	new_bh->b_blocknr = blocknr;
	set_buffer_mapped(new_bh);
	set_buffer_dirty(new_bh);

	*jh_out = new_jh;

	/*
	 * The to-be-written buffer needs to get moved to the io queue,
	 * and the original buffer whose contents we are shadowing or
	 * copying is moved to the transaction's shadow queue.
	 */
	JBUFFER_TRACE(jh_in, "file as BJ_Shadow");
	spin_lock(&journal->j_list_lock);
	__?@jbd2Prefix?journal_file_buffer(jh_in, transaction, BJ_Shadow);
	spin_unlock(&journal->j_list_lock);
	jbd_unlock_bh_state(bh_in);

	JBUFFER_TRACE(new_jh, "file as BJ_IO");
	?@jbd2Prefix?journal_file_buffer(new_jh, transaction, BJ_IO);

	return do_escape | (done_copy_out << 1);
}

/*
 * Allocation code for the journal file.  Manage the space left in the
 * journal, so that we can begin checkpointing when appropriate.
 */

/*
 * __?@jbd2Prefix?log_space_left: Return the number of free blocks left in the journal.
 *
 * Called with the journal already locked.
 *
 * Called under j_state_lock
 */

int __?@jbd2Prefix?log_space_left(journal_t *journal)
{
	int left = journal->j_free;
#select folderName
	#option jbd
	assert_spin_locked(&journal->j_state_lock);
	#endoption
	#option jbd2
	/* assert_spin_locked(&journal->j_state_lock); */
	#endoption
#endselect

	/*
	 * Be pessimistic here about the number of those free blocks which
	 * might be required for log descriptor control blocks.
	 */

#define MIN_LOG_RESERVED_BLOCKS 32 /* Allow for rounding errors */

	left -= MIN_LOG_RESERVED_BLOCKS;

	if (left <= 0)
		return 0;
	left -= (left >> 3);
	return left;
}

/*
 * Called with j_state_lock locked for writing.
 * Returns true if a transaction commit was started.
 */
#break: start_commit
int __log_start_commit(journal_t *journal, tid_t target)
{
	/*
	 * The only transaction we can possibly wait upon is the
	 * currently running transaction (if it exists).  Otherwise,
	 * the target tid must be an old one.
	 */
	if (journal->j_commit_request != target &&
	    journal->j_running_transaction &&
	    journal->j_running_transaction->t_tid == target) {
		/*
		 * We want a new commit: OK, mark the request and wakeup the
		 * commit thread.  We do _not_ do the commit ourselves.
		 */

		journal->j_commit_request = target;
		jbd_debug(1, "JBD: requesting commit %d/%d\n",
			  journal->j_commit_request,
			  journal->j_commit_sequence);
		wake_up(&journal->j_wait_commit);
		return 1;
	} else if (!tid_geq(journal->j_commit_request, target))
		/* This should never happen, but if it does, preserve
		   the evidence before kjournald goes into a loop and
		   increments j_commit_sequence beyond all recognition. */
		WARN_ONCE(1, "jbd: bad log_start_commit: %u %u %u %u\n",
		    journal->j_commit_request, journal->j_commit_sequence,
		    target, journal->j_running_transaction \?
		    journal->j_running_transaction->t_tid : 0);
	return 0;
}

int log_start_commit(journal_t *journal, tid_t tid)
{
	int ret;

	spin_lock(&journal->j_state_lock);
	ret = __log_start_commit(journal, tid);
	spin_unlock(&journal->j_state_lock);
	return ret;
}
#endbreak

#select folderName
	#option jbd2
int jbd2_log_start_commit(journal_t *journal, tid_t tid)
{
	int ret;

	write_lock(&journal->j_state_lock);
	ret = __jbd2_log_start_commit(journal, tid);
	write_unlock(&journal->j_state_lock);
	return ret;
}
	#endoption
#endselect
/*
 * Force and wait upon a commit if the calling process is not within
 * transaction.  This is used for forcing out undo-protected data which contains
 * bitmaps, when the fs is running out of space.
 *
 * We can only force the running transaction if we don't have an active handle;
 * otherwise, we will deadlock.
 *
 * Returns true if a transaction was started.
 */
int ?@jbd2Prefix?journal_force_commit_nested(journal_t *journal)
{
	transaction_t *transaction = NULL;
	tid_t tid;
	
#select folderName
	#option jbd2
	int need_to_start = 0;
	#endoption
#endselect
?@spinRead?_lock(&journal->j_state_lock);
	if (journal->j_running_transaction && !current->journal_info) {
		transaction = journal->j_running_transaction;
#select folderName
	#option jbd
		__log_start_commit(journal, transaction->t_tid);
	#endoption
	#option jbd2
		if (!tid_geq(journal->j_commit_request, transaction->t_tid))
			need_to_start = 1;
	#endoption
#endselect
	} else if (journal->j_committing_transaction)
		transaction = journal->j_committing_transaction;

	if (!transaction) {
		?@spinRead?_unlock(&journal->j_state_lock);
		return 0;	/* Nothing to retry */
	}

	tid = transaction->t_tid;
	?@spinRead?_unlock(&journal->j_state_lock);
#select folderName
	#option jbd
	log_wait_commit(journal, tid);
	#endoption
	#option jbd2
	if (need_to_start)
		jbd2_log_start_commit(journal, tid);
	jbd2_log_wait_commit(journal, tid);
	#endoption
#endselect
	return 1;
}

/*
 * Start a commit of the current running transaction (if any).  Returns true
 * if a transaction is going to be committed (or is currently already
 * committing), and fills its tid in at *ptid
 */
int ?@jbd2Prefix?journal_start_commit(journal_t *journal, tid_t *ptid)
{
	int ret = 0;

	?@spinWrite?_lock(&journal->j_state_lock);
	if (journal->j_running_transaction) {
		tid_t tid = journal->j_running_transaction->t_tid;

		__?@jbd2Prefix?log_start_commit(journal, tid);
		/* There's a running transaction and we've just made sure
		 * it's commit has been scheduled. */
		if (ptid)
			*ptid = tid;
		ret = 1;
	} else if (journal->j_committing_transaction) {
		/*
		 * If commit has been started, then we have to wait for
		 * completion of that transaction.
		 */
		if (ptid)
			*ptid = journal->j_committing_transaction->t_tid;
		ret = 1;
	}
	?@spinWrite?_unlock(&journal->j_state_lock);
	return ret;
}

#break: log_wait_commit
/*
 * Wait for a specified commit to complete.
 * The caller may not hold the journal lock.
 */
int log_wait_commit(journal_t *journal, tid_t tid)
{
	int err = 0;

#ifdef CONFIG_JBD_DEBUG
	spin_lock(&journal->j_state_lock);
	if (!tid_geq(journal->j_commit_request, tid)) {
		printk(KERN_EMERG
		       "%s: error: j_commit_request=%d, tid=%d\n",
		       __func__, journal->j_commit_request, tid);
	}
	spin_unlock(&journal->j_state_lock);
#endif
	spin_lock(&journal->j_state_lock);
	/*
	 * Not running or committing trans\? Must be already committed. This
	 * saves us from waiting for a *long* time when tid overflows.
	 */
	if (!((journal->j_running_transaction &&
	       journal->j_running_transaction->t_tid == tid) ||
	      (journal->j_committing_transaction &&
	       journal->j_committing_transaction->t_tid == tid)))
		goto out_unlock;

	if (!tid_geq(journal->j_commit_waited, tid))
		journal->j_commit_waited = tid;
	while (tid_gt(tid, journal->j_commit_sequence)) {
		jbd_debug(1, "JBD: want %d, j_commit_sequence=%d\n",
				  tid, journal->j_commit_sequence);
		wake_up(&journal->j_wait_commit);
		spin_unlock(&journal->j_state_lock);
		wait_event(journal->j_wait_done_commit,
				!tid_gt(tid, journal->j_commit_sequence));
		spin_lock(&journal->j_state_lock);
	}
out_unlock:
	spin_unlock(&journal->j_state_lock);

	if (unlikely(is_journal_aborted(journal))) {
		printk(KERN_EMERG "journal commit I/O error\n");
		err = -EIO;
	}
	return err;
}
#endbreak
/*
 * Return 1 if a given transaction has not yet sent barrier request
 * connected with a transaction commit. If 0 is returned, transaction
 * may or may not have sent the barrier. Used to avoid sending barrier
 * twice in common cases.
 */
int ?@journalJbd2?_trans_will_send_data_barrier(journal_t *journal, tid_t tid)
{
	int ret = 0;
	transaction_t *commit_trans;

	if (!(journal->j_flags & ?@jfsjbd2?_BARRIER))
		return 0;
	?@spinRead?_lock(&journal->j_state_lock);
	/* Transaction already committed\? */
	if (tid_geq(journal->j_commit_sequence, tid))
		goto out;
#break: send_data_barrier
	/*
	 * Transaction is being committed and we already proceeded to
	 * writing commit record\?
	 */
	commit_trans = journal->j_committing_transaction;
	if (commit_trans && commit_trans->t_tid == tid &&
	    commit_trans->t_state >= T_COMMIT_RECORD)
		goto out;
	ret = 1;
out:
	spin_unlock(&journal->j_state_lock);
	return ret;
}
EXPORT_SYMBOL(journal_trans_will_send_data_barrier);	
#endbreak
/*
 * Log buffer allocation routines:
 */

int ?@jbd2Prefix?journal_next_log_block(journal_t *journal, unsigned ?@typeChange? *retp)
{
	unsigned ?@intlong? blocknr;

	?@spinWrite?_lock(&journal->j_state_lock);
	J_ASSERT(journal->j_free > 1);

	blocknr = journal->j_head;
	journal->j_head++;
	journal->j_free--;
	if (journal->j_head == journal->j_last)
		journal->j_head = journal->j_first;
	?@spinWrite?_unlock(&journal->j_state_lock);
	return ?@jbd2Prefix?journal_bmap(journal, blocknr, retp);
}

/*
 * Conversion of logical to physical block numbers for the journal
 *
 * On external journals the journal blocks are identity-mapped, so
 * this is a no-op.  If needed, we can use j_blk_offset - everything is
 * ready.
 */
int ?@jbd2Prefix?journal_bmap(journal_t *journal, unsigned ?@intlong? blocknr,
		 unsigned ?@typeChange? *retp)
{
	int err = 0;
	unsigned ?@typeChange? ret;

	if (journal->j_inode) {
		ret = bmap(journal->j_inode, blocknr);
		if (ret)
			*retp = ret;
		else {
#select folderName
	#option jbd
			char b[BDEVNAME_SIZE];

			printk(KERN_ALERT \"%s: journal block not found \"
					\"at offset %u on %s\n\",
				__func__,
				blocknr,
				bdevname(journal->j_dev, b));
	#endoption
	#option jbd2
			printk(KERN_ALERT \"%s: journal block not found \"
					\"at offset %lu on %s\n\",
			       __func__, blocknr, journal->j_devname);
	#endoption
#endselect
			err = -EIO;
			__journal_abort_soft(journal, err);
		}
	} else {
		*retp = blocknr; /* +journal->j_blk_offset */
	}
	return err;
}

/*
 * We play buffer_head aliasing tricks to write data/metadata blocks to
 * the journal without copying their contents, but for journal
 * descriptor blocks we do need to generate bona fide buffers.
 *
 * After the caller of ?@jbd2Prefix?journal_get_descriptor_buffer() has finished modifying
 * the buffer's contents they really should run flush_dcache_page(bh->b_page).
 * But we don't bother doing that, so there will be coherency problems with
 * mmaps of blockdevs which hold live JBD-controlled filesystems.
 */
struct journal_head *?@jbd2Prefix?journal_get_descriptor_buffer(journal_t *journal)
{
	struct buffer_head *bh;
	unsigned ?@typeChange? blocknr;
	int err;

	err = ?@jbd2Prefix?journal_next_log_block(journal, &blocknr);

	if (err)
		return NULL;

	bh = __getblk(journal->j_dev, blocknr, journal->j_blocksize);
	if (!bh)
		return NULL;
	lock_buffer(bh);
	memset(bh->b_data, 0, journal->j_blocksize);
	set_buffer_uptodate(bh);
	unlock_buffer(bh);
	BUFFER_TRACE(bh, "return this buffer");
	return ?@jbd2Prefix?journal_add_journal_head(bh);
}
#break get_log_tail
/*
 * Management for journal control blocks: functions to create and
 * destroy journal_t structures, and to initialise and read existing
 * journal blocks from disk.  */

/* First: create and setup a journal_t object in memory.  We initialise
 * very few fields yet: that has to wait until we have created the
 * journal structures from from scratch, or loaded them from disk. */

static journal_t * journal_init_common (void)
{
	journal_t *journal;
	int err;

	journal = kzalloc(sizeof(*journal), GFP_KERNEL);
	if (!journal)
		?@failNull?

	init_waitqueue_head(&journal->j_wait_transaction_locked);
	init_waitqueue_head(&journal->j_wait_logspace);
	init_waitqueue_head(&journal->j_wait_done_commit);
	init_waitqueue_head(&journal->j_wait_checkpoint);
	init_waitqueue_head(&journal->j_wait_commit);
	init_waitqueue_head(&journal->j_wait_updates);
#break: journal_init_common
	mutex_init(&journal->j_checkpoint_mutex);
	spin_lock_init(&journal->j_revoke_lock);
	spin_lock_init(&journal->j_list_lock);
	spin_lock_init(&journal->j_state_lock);

	journal->j_commit_interval = (HZ * JBD_DEFAULT_MAX_COMMIT_AGE);
#endbreak

	/* The journal is marked for error until we succeed with recovery! */
	journal->j_flags = ?@jfsjbd2?_ABORT;

	/* Set up a default-sized revoke table for the new mount. */
	err = ?@jbd2Prefix?journal_init_revoke(journal, JOURNAL_REVOKE_DEFAULT_HASH);
	if (err) {
		kfree(journal);
		?@failNull?
	}
#select folderName
	#option jbd
	return journal;
fail:
	return NULL;
	#endoption
	#option jbd2
	spin_lock_init(&journal->j_history_lock);
	return journal;
	#endoption
#endselect
}

/* ?@jbd2Prefix?journal_init_dev and ?@jbd2Prefix?journal_init_inode:
 *
 * Create a journal structure assigned some fixed set of disk blocks to
 * the journal.  We don't actually touch those disk blocks yet, but we
 * need to set up all of the mapping information to tell the journaling
 * system where the journal blocks are.
 *
 */

/**
 *  journal_t * ?@jbd2Prefix?journal_init_dev() - creates and initialises a journal structure
 *  @bdev: Block device on which to create the journal
 *  @fs_dev: Device which hold journalled filesystem for this journal.
 *  @start: Block nr Start of journal.
 *  @len:  Length of the journal in blocks.
 *  @blocksize: blocksize of journalling device
 *
 *  Returns: a newly created journal_t *
 *
 *  ?@jbd2Prefix?journal_init_dev creates a journal which maps a fixed contiguous
 *  range of blocks on an arbitrary block device.
 *
 */
journal_t * ?@jbd2Prefix?journal_init_dev(struct block_device *bdev,
			struct block_device *fs_dev,
			?@intulonglong? start, int len, int blocksize)
{
	journal_t *journal = journal_init_common();
	struct buffer_head *bh;
	int n;

	if (!journal)
		return NULL;

	/* journal descriptor can store up to n blocks -bzzz */
	journal->j_blocksize = blocksize;
#select folderName
	#option jbd2
	char *p;
		
	journal->j_dev = bdev;
	journal->j_fs_dev = fs_dev;
	journal->j_blk_offset = start;
	journal->j_maxlen = len;
	bdevname(journal->j_dev, journal->j_devname);
	p = journal->j_devname;
	while ((p = strchr(p, '/')))
		*p = '!';
	jbd2_stats_proc_init(journal);
	#endoption
#endselect

	n = journal->j_blocksize / sizeof(journal_block_tag_t);
	journal->j_wbufsize = n;
	journal->j_wbuf = kmalloc(n * sizeof(struct buffer_head*), GFP_KERNEL);
	if (!journal->j_wbuf) {
		printk(KERN_ERR \"%s: Can't allocate bhs for commit thread\n\",
			__func__);
		goto out_err;
	}

#select folderName
	#option jbd
	journal->j_dev = bdev;
	journal->j_fs_dev = fs_dev;
	journal->j_blk_offset = start;
	journal->j_maxlen = len;
	#endoption
#endselect
	bh = __getblk(journal->j_dev, start, journal->j_blocksize);
	if (!bh) {
		printk(KERN_ERR
		       \"%s: Cannot get buffer for journal superblock\n\",
		       __func__);
		goto out_err;
	}
	journal->j_sb_buffer = bh;
	journal->j_superblock = (journal_superblock_t *)bh->b_data;

	return journal;
out_err:
	kfree(journal->j_wbuf);
#select folderName
	#option jbd2
	jbd2_stats_proc_exit(journal);	
	#endoption
#endselect
	kfree(journal);
	return NULL;
}

/**
 *  journal_t * ?@jbd2Prefix?journal_init_inode () - creates a journal which maps to a inode.
 *  @inode: An inode to create the journal in
 *
 * ?@jbd2Prefix?journal_init_inode creates a journal which maps an on-disk inode as
 * the journal.  The inode must exist already, must support bmap() and
 * must have all data blocks preallocated.
 */
journal_t * ?@jbd2Prefix?journal_init_inode (struct inode *inode)
{
	struct buffer_head *bh;
	journal_t *journal = journal_init_common();
	int err;
	int n;
	unsigned ?@typeChange? blocknr;

	if (!journal)
		return NULL;

	journal->j_dev = journal->j_fs_dev = inode->i_sb->s_bdev;
	journal->j_inode = inode;	
#select folderName
	#option jbd2
	char *p;
		
	bdevname(journal->j_dev, journal->j_devname);
	p = journal->j_devname;
	while ((p = strchr(p, '/')))
		*p = '!';
	p = journal->j_devname + strlen(journal->j_devname);
	sprintf(p, \"-%lu\", journal->j_inode->i_ino);
	#endoption
#endselect
	jbd_debug(1,
		  \"journal %p: inode %s/%ld, size %Ld, bits %d, blksize %ld\n\",
		  journal, inode->i_sb->s_id, inode->i_ino,
		  (long long) inode->i_size,
		  inode->i_sb->s_blocksize_bits, inode->i_sb->s_blocksize);

	journal->j_maxlen = inode->i_size >> inode->i_sb->s_blocksize_bits;
	journal->j_blocksize = inode->i_sb->s_blocksize;
#select folderName
	#option jbd2
	jbd2_stats_proc_init(journal);
	#endoption
#endselect

	/* journal descriptor can store up to n blocks -bzzz */
	n = journal->j_blocksize / sizeof(journal_block_tag_t);
	journal->j_wbufsize = n;
	journal->j_wbuf = kmalloc(n * sizeof(struct buffer_head*), GFP_KERNEL);
	if (!journal->j_wbuf) {
		printk(KERN_ERR "%s: Can't allocate bhs for commit thread\n",
			__func__);
		goto out_err;
	}

	err = ?@jbd2Prefix?journal_bmap(journal, 0, &blocknr);
	/* If that failed, give up */
	if (err) {
		printk(KERN_ERR "%s: Cannot locate journal superblock\n",
		       __func__);
		goto out_err;
	}

	bh = __getblk(journal->j_dev, blocknr, journal->j_blocksize);
	if (!bh) {
		printk(KERN_ERR
		       "%s: Cannot get buffer for journal superblock\n",
		       __func__);
		goto out_err;
	}
	journal->j_sb_buffer = bh;
	journal->j_superblock = (journal_superblock_t *)bh->b_data;

	return journal;
out_err:
	kfree(journal->j_wbuf);
#select folderName
	#option jbd2
	jbd2_stats_proc_exit(journal);	
	#endoption
#endselect
	kfree(journal);
	return NULL;
}

/*
 * If the journal init or create aborts, we need to mark the journal
 * superblock as being NULL to prevent the journal destroy from writing
 * back a bogus superblock.
 */
static void journal_fail_superblock (journal_t *journal)
{
	struct buffer_head *bh = journal->j_sb_buffer;
	brelse(bh);
	journal->j_sb_buffer = NULL;
}

/*
 * Given a journal_t structure, initialise the various fields for
 * startup of a new journaling session.  We use this both when creating
 * a journal, and after recovering an old journal to reset it for
 * subsequent use.
 */

static int journal_reset(journal_t *journal)
{
	journal_superblock_t *sb = journal->j_superblock;
	unsigned ?@typeChange? first, last;

	first = be32_to_cpu(sb->s_first);
	last = be32_to_cpu(sb->s_maxlen);
	if (first + ?@jfsjbd2?_MIN_JOURNAL_BLOCKS > last + 1) {
#select folderName
		#option jbd
		printk(KERN_ERR \"JBD: Journal too short (blocks %u-%u).\n\",
		#endoption
		#option jbd2
		printk(KERN_ERR \"JBD2: Journal too short (blocks %llu-%llu).\n\",
		#endoption
#endselect
				first, last);
		journal_fail_superblock(journal);
		return -EINVAL;
	}
	
	journal->j_first = first;
	journal->j_last = last;

	journal->j_head = first;
	journal->j_tail = first;
	journal->j_free = last - first;

	journal->j_tail_sequence = journal->j_transaction_sequence;
	journal->j_commit_sequence = journal->j_transaction_sequence - 1;
	journal->j_commit_request = journal->j_commit_sequence;

	journal->j_max_transaction_buffers = journal->j_maxlen / 4;

	/*
	 * As a special case, if the on-disk copy is already marked as needing
	 * no recovery (s_start == 0), then we can safely defer the superblock
	 * update until the next commit by setting ?@jfsjbd2?_FLUSHED.  This avoids
	 * attempting a write to a potential-readonly device.
	 */
	if (sb->s_start == 0) {
		jbd_debug(1, \"?@CAP_FILENAME?: Skipping superblock update on recovered sb \"
	#select folderName
		#option jbd
			\"(start %u, seq %d, errno %d)\n\",
		#endoption
		#option jbd2
			\"(start %ld, seq %d, errno %d)\n\",
		#endoption
#endselect
			journal->j_tail, journal->j_tail_sequence,
			journal->j_errno);
		journal->j_flags |= ?@jfsjbd2?_FLUSHED;
	} else {
		/* Lock here to make assertions happy... */
		mutex_lock(&journal->j_checkpoint_mutex);
		/*
		 * Update log tail information. We use WRITE_FUA since new
		 * transaction will start reusing journal space and so we
		 * must make sure information about current log tail is on
		 * disk before that.
		 */
		?@jbd2Prefix?journal_update_sb_log_tail(journal,
					   journal->j_tail_sequence,
					   journal->j_tail,
					   WRITE_FUA);
		mutex_unlock(&journal->j_checkpoint_mutex);
	}
	return ?@jbd2Prefix?journal_start_thread(journal);
}

#break: journal_create
/**
 * int journal_create() - Initialise the new journal file
 * @journal: Journal to create. This structure must have been initialised
 *
 * Given a journal_t structure which tells us which disk blocks we can
 * use, create a new journal superblock and initialise all of the
 * journal fields from scratch.
 **/
int journal_create(journal_t *journal)
{
	unsigned int blocknr;
	struct buffer_head *bh;
	journal_superblock_t *sb;
	int i, err;

	if (journal->j_maxlen < JFS_MIN_JOURNAL_BLOCKS) {
		printk (KERN_ERR "Journal length (%d blocks) too short.\n",
			journal->j_maxlen);
		journal_fail_superblock(journal);
		return -EINVAL;
	}

	if (journal->j_inode == NULL) {
		/*
		 * We don't know what block to start at!
		 */
		printk(KERN_EMERG
		       "%s: creation of journal on external device!\n",
		       __func__);
		BUG();
	}

	/* Zero out the entire journal on disk.  We cannot afford to
	   have any blocks on disk beginning with JFS_MAGIC_NUMBER. */
	jbd_debug(1, \"JBD: Zeroing out journal blocks...\n\");
	for (i = 0; i < journal->j_maxlen; i++) {
		err = journal_bmap(journal, i, &blocknr);
		if (err)
			return err;
		bh = __getblk(journal->j_dev, blocknr, journal->j_blocksize);
		if (unlikely(!bh))
			return -ENOMEM;
		lock_buffer(bh);
		memset (bh->b_data, 0, journal->j_blocksize);
		BUFFER_TRACE(bh, "marking dirty");
		mark_buffer_dirty(bh);
		BUFFER_TRACE(bh, "marking uptodate");
		set_buffer_uptodate(bh);
		unlock_buffer(bh);
		__brelse(bh);
	}

	sync_blockdev(journal->j_dev);
	jbd_debug(1, \"JBD: journal cleared.\n\");

	/* OK, fill in the initial static fields in the new superblock */
	sb = journal->j_superblock;

	sb->s_header.h_magic	 = cpu_to_be32(JFS_MAGIC_NUMBER);
	sb->s_header.h_blocktype = cpu_to_be32(JFS_SUPERBLOCK_V2);

	sb->s_blocksize	= cpu_to_be32(journal->j_blocksize);
	sb->s_maxlen	= cpu_to_be32(journal->j_maxlen);
	sb->s_first	= cpu_to_be32(1);

	journal->j_transaction_sequence = 1;

	journal->j_flags &= ~JFS_ABORT;
	journal->j_format_version = 2;

	return journal_reset(journal);
}
#endbreak

static void ?@journalJbd2?_write_superblock(journal_t *journal, int write_op)
{
	struct buffer_head *bh = journal->j_sb_buffer;
	int ret;

	trace_?@journalJbd2?_write_superblock(journal, write_op);
	if (!(journal->j_flags & ?@jfsjbd2?_BARRIER))
		write_op &= ~(REQ_FUA | REQ_FLUSH);
	lock_buffer(bh);
	if (buffer_write_io_error(bh)) {
#select folderName
	#option jbd
		char b[BDEVNAME_SIZE];
	#endoption
#endselect
		/*
		 * Oh, dear.  A previous attempt to write the journal
		 * superblock failed.  This could happen because the
		 * USB device was yanked out.  Or it could happen to
		 * be a transient write error and maybe the block will
		 * be remapped.  Nothing we can do but to retry the
		 * write and hope for the best.
		 */
		printk(KERN_ERR \"?@CAP_FILENAME?: previous I/O error detected \"
		       \"for journal superblock update for %s.\n\",
		       ?@journalDevName?);
		clear_buffer_write_io_error(bh);
		set_buffer_uptodate(bh);
	}

	get_bh(bh);
	bh->b_end_io = end_buffer_write_sync;
	ret = submit_bh(write_op, bh);
	wait_on_buffer(bh);
	if (buffer_write_io_error(bh)) {
		clear_buffer_write_io_error(bh);
		set_buffer_uptodate(bh);
		ret = -EIO;
	}
	if (ret) {
#select folderName
	#option jbd
		char b[BDEVNAME_SIZE];
	#endoption
#endselect
		printk(KERN_ERR \"?@CAP_FILENAME?: Error %d detected \"
		       \"when updating journal superblock for %s.\n\",
		       ret, ?@journalDevName?);
	}
}

/**
 * ?@jbd2Prefix?journal_update_sb_log_tail() - Update log tail in journal sb on disk.
 * @journal: The journal to update.
 * @tail_tid: TID of the new transaction at the tail of the log
 * @tail_block: The first block of the transaction at the tail of the log
 * @write_op: With which operation should we write the journal sb
 *
 * Update a journal's superblock information about log tail and write it to
 * disk, waiting for the IO to complete.
 */
void ?@jbd2Prefix?journal_update_sb_log_tail(journal_t *journal, tid_t tail_tid,
				unsigned ?@intlong? tail_block, int write_op)
{
	journal_superblock_t *sb = journal->j_superblock;

	BUG_ON(!mutex_is_locked(&journal->j_checkpoint_mutex));
#select folderName
	#option jbd
		jbd_debug(1,\"JBD: updating superblock (start %u, seq %u)\n\",
	#endoption
	#option jbd2
		jbd_debug(1, \"JBD2: updating superblock (start %lu, seq %u)\n\",
	#endoption
#endselect

		  tail_block, tail_tid);

	sb->s_sequence = cpu_to_be32(tail_tid);
	sb->s_start    = cpu_to_be32(tail_block);

	?@journalJbd2?_write_superblock(journal, write_op);

	/* Log is no longer empty */
	?@spinWrite?_lock(&journal->j_state_lock);
	WARN_ON(!sb->s_sequence);
	journal->j_flags &= ~?@jfsjbd2?_FLUSHED;
	?@spinWrite?_unlock(&journal->j_state_lock);
}

/**
 * ?@jbd2Prefix?mark_journal_empty() - Mark on disk journal as empty.
 * @journal: The journal to update.
 *
 * Update a journal's dynamic superblock fields to show that journal is empty.
 * Write updated superblock to disk waiting for IO to complete.
 */
static void ?@jbd2Prefix?mark_journal_empty(journal_t *journal)
{
	journal_superblock_t *sb = journal->j_superblock;

	BUG_ON(!mutex_is_locked(&journal->j_checkpoint_mutex));
	?@spinRead?_lock(&journal->j_state_lock);
	/* Is it already empty\? */
	if (sb->s_start == 0) {
		?@spinRead?_unlock(&journal->j_state_lock);
		return;
	}
	jbd_debug(1, \"?@CAP_FILENAME?: Marking journal as empty (seq %d)\n\",
        	  journal->j_tail_sequence);

	sb->s_sequence = cpu_to_be32(journal->j_tail_sequence);
	sb->s_start    = cpu_to_be32(0);
	?@spinRead?_unlock(&journal->j_state_lock);

	?@journalJbd2?_write_superblock(journal, WRITE_FUA);

	?@spinWrite?_lock(&journal->j_state_lock);
	/* Log is empty */
	journal->j_flags |= ?@jfsjbd2?_FLUSHED;
	?@spinWrite?_unlock(&journal->j_state_lock);
}

/**
 * ?@jbd2Prefix?journal_update_sb_errno() - Update error in the journal.
 * @journal: The journal to update.
 *
 * Update a journal's errno.  Write updated superblock to disk waiting for IO
 * to complete.
 */
static void ?@jbd2Prefix?journal_update_sb_errno(journal_t *journal)
{
	journal_superblock_t *sb = journal->j_superblock;

	?@spinRead?_lock(&journal->j_state_lock);
	jbd_debug(1, \"?@CAP_FILENAME?: updating superblock error (errno %d)\n\",
        	  journal->j_errno);
	sb->s_errno = cpu_to_be32(journal->j_errno);
#select folderName
	#option jbd2
	jbd2_superblock_csum_set(journal, sb);
	#endoption
#endselect
	?@spinRead?_unlock(&journal->j_state_lock);

	?@journalJbd2?_write_superblock(journal, WRITE_SYNC);
}
#select folderName
	#option jbd2
EXPORT_SYMBOL(jbd2_journal_update_sb_errno);
	#endoption
#endselect

/*
 * Read the superblock for a given journal, performing initial
 * validation of the format.
 */
static int journal_get_superblock(journal_t *journal)
{
	struct buffer_head *bh;
	journal_superblock_t *sb;
	int err = -EIO;

	bh = journal->j_sb_buffer;

	J_ASSERT(bh != NULL);
	if (!buffer_uptodate(bh)) {
		ll_rw_block(READ, 1, &bh);
		wait_on_buffer(bh);
		if (!buffer_uptodate(bh)) {
			printk(KERN_ERR
				\"?@CAP_FILENAME?: IO error reading journal superblock\n\");
			goto out;
		}
	}
#select folderName
	#option jbd2
	if (buffer_verified(bh))
		return 0;
	#endoption
#endselect
	sb = journal->j_superblock;

	err = -EINVAL;

	if (sb->s_header.h_magic != cpu_to_be32(?@jfsjbd2?_MAGIC_NUMBER) ||
	    sb->s_blocksize != cpu_to_be32(journal->j_blocksize)) {
		printk(KERN_WARNING \"?@CAP_FILENAME?: no valid journal superblock found\n\");
		goto out;
	}

	switch(be32_to_cpu(sb->s_header.h_blocktype)) {
	case ?@jfsjbd2?_SUPERBLOCK_V1:
		journal->j_format_version = 1;
		break;
	case ?@jfsjbd2?_SUPERBLOCK_V2:
		journal->j_format_version = 2;
		break;
	default:
		printk(KERN_WARNING \"?@CAP_FILENAME?: unrecognised superblock format ID\n\");
		goto out;
	}

	if (be32_to_cpu(sb->s_maxlen) < journal->j_maxlen)
		journal->j_maxlen = be32_to_cpu(sb->s_maxlen);
	else if (be32_to_cpu(sb->s_maxlen) > journal->j_maxlen) {
		printk(KERN_WARNING \"?@CAP_FILENAME?: journal file too short\n\");
		goto out;
	}

	if (be32_to_cpu(sb->s_first) == 0 ||
	    be32_to_cpu(sb->s_first) >= journal->j_maxlen) {
		printk(KERN_WARNING
			\"?@CAP_FILENAME?: Invalid start block of journal: %u\n\",
			be32_to_cpu(sb->s_first));
		goto out;
	}
	
#break journal_get_superblock
	return 0;

out:
	journal_fail_superblock(journal);
	return err;
}

/*
 * Load the on-disk journal superblock and read the key fields into the
 * journal_t.
 */

static int load_superblock(journal_t *journal)
{
	int err;
	journal_superblock_t *sb;

	err = journal_get_superblock(journal);
	if (err)
		return err;

	sb = journal->j_superblock;

	journal->j_tail_sequence = be32_to_cpu(sb->s_sequence);
	journal->j_tail = be32_to_cpu(sb->s_start);
	journal->j_first = be32_to_cpu(sb->s_first);
	journal->j_last = be32_to_cpu(sb->s_maxlen);
	journal->j_errno = be32_to_cpu(sb->s_errno);

	return 0;
}

/**
 * int ?@jbd2Prefix?journal_load() - Read journal from disk.
 * @journal: Journal to act on.
 *
 * Given a journal_t structure which tells us which disk blocks contain
 * a journal, read the journal from disk to initialise the in-memory
 * structures.
 */
int ?@jbd2Prefix?journal_load(journal_t *journal)
{
	int err;
	journal_superblock_t *sb;

	err = load_superblock(journal);
	if (err)
		return err;

	sb = journal->j_superblock;
	/* If this is a V2 superblock, then we have to check the
	 * features flags on it. */

	if (journal->j_format_version >= 2) {
		if ((sb->s_feature_ro_compat &
		     ~cpu_to_be32(?@jfsjbd2?_KNOWN_ROCOMPAT_FEATURES)) ||
		    (sb->s_feature_incompat &
		     ~cpu_to_be32(?@jfsjbd2?_KNOWN_INCOMPAT_FEATURES))) {
			printk (KERN_WARNING
				\"?@CAP_FILENAME?: Unrecognised features on journal\n\");
			return -EINVAL;
		}
	}
#break: recovery_code
	/* Let the recovery code check whether it needs to recover any
	 * data from the journal. */
	if (?@jbd2Prefix?journal_recover(journal))
		goto recovery_error;
#endbreak

	/* OK, we've finished with the dynamic journal bits:
	 * reinitialise the dynamic contents of the superblock in memory
	 * and reset them on disk. */
	if (journal_reset(journal))
		goto recovery_error;

	journal->j_flags &= ~?@jfsjbd2?_ABORT;
	journal->j_flags |= ?@jfsjbd2?_LOADED;
	return 0;

recovery_error:
	printk (KERN_WARNING \"?@CAP_FILENAME?: recovery failed\n\");
	return -EIO;
}

/**
 * void ?@jbd2Prefix?journal_destroy() - Release a journal_t structure.
 * @journal: Journal to act on.
 *
 * Release a journal_t structure once it is no longer in use by the
 * journaled object.
 * Return <0 if we couldn't clean up the journal.
 */
int ?@jbd2Prefix?journal_destroy(journal_t *journal)
{
	int err = 0;

	
	/* Wait for the commit thread to wake up and die. */
	journal_kill_thread(journal);

	/* Force a final log commit */
	if (journal->j_running_transaction)
		?@jbd2Prefix?journal_commit_transaction(journal);

	/* Force any old transactions to disk */
#select folderName
	#option jbd
	/* We cannot race with anybody but must keep assertions happy */
	mutex_lock(&journal->j_checkpoint_mutex);
	#endoption
#endselect
	/* Totally anal locking here... */
	spin_lock(&journal->j_list_lock);
	while (journal->j_checkpoint_transactions != NULL) {
		spin_unlock(&journal->j_list_lock);
#select folderName
	#option jbd
		log_do_checkpoint(journal);
	#endoption
	#option jbd2
		mutex_lock(&journal->j_checkpoint_mutex);
		jbd2_log_do_checkpoint(journal);
		mutex_unlock(&journal->j_checkpoint_mutex);
	#endoption
#endselect
		spin_lock(&journal->j_list_lock);
	}

	J_ASSERT(journal->j_running_transaction == NULL);
	J_ASSERT(journal->j_committing_transaction == NULL);
	J_ASSERT(journal->j_checkpoint_transactions == NULL);
	spin_unlock(&journal->j_list_lock);

	if (journal->j_sb_buffer) {
		if (!is_journal_aborted(journal)) {
#select folderName
	#option jbd
			journal->j_tail_sequence =
				++journal->j_transaction_sequence;
			mark_journal_empty(journal);
	#endoption
	#option jbd2
			mutex_lock(&journal->j_checkpoint_mutex);
			jbd2_mark_journal_empty(journal);
			mutex_unlock(&journal->j_checkpoint_mutex);
	#endoption
#endselect
		} else
			err = -EIO;
		brelse(journal->j_sb_buffer);
	}
#select folderName
	#option jbd
mutex_unlock(&journal->j_checkpoint_mutex);
	#endoption
	#option jbd2
	if (journal->j_proc_entry)
		jbd2_stats_proc_exit(journal);
	#endoption
#endselect
	if (journal->j_inode)
		iput(journal->j_inode);
	if (journal->j_revoke)
		?@jbd2Prefix?journal_destroy_revoke(journal);
#select folderName
	#option jbd2
	if (journal->j_chksum_driver)
		crypto_free_shash(journal->j_chksum_driver);
	#endoption
#endselect
	kfree(journal->j_wbuf);
	kfree(journal);

	return err;
}

/**
 *int ?@jbd2Prefix?journal_check_used_features () - Check if features specified are used.
 * @journal: Journal to check.
 * @compat: bitmask of compatible features
 * @ro: bitmask of features that force read-only mount
 * @incompat: bitmask of incompatible features
 *
 * Check whether the journal uses all of a given set of
 * features.  Return true (non-zero) if it does.
 **/

int ?@jbd2Prefix?journal_check_used_features (journal_t *journal, unsigned long compat,
				 unsigned long ro, unsigned long incompat)
{
	journal_superblock_t *sb;

	if (!compat && !ro && !incompat)
		return 1;
#select folderName
	#option jbd2
	/* Load journal superblock if it is not loaded yet. */
	if (journal->j_format_version == 0 &&
	    journal_get_superblock(journal) != 0)
		return 0;
	#endoption
#endselect
	if (journal->j_format_version == 1)
		return 0;

	sb = journal->j_superblock;

	if (((be32_to_cpu(sb->s_feature_compat) & compat) == compat) &&
	    ((be32_to_cpu(sb->s_feature_ro_compat) & ro) == ro) &&
	    ((be32_to_cpu(sb->s_feature_incompat) & incompat) == incompat))
		return 1;

	return 0;
}

/**
 * int ?@jbd2Prefix?journal_check_available_features() - Check feature set in journalling layer
 * @journal: Journal to check.
 * @compat: bitmask of compatible features
 * @ro: bitmask of features that force read-only mount
 * @incompat: bitmask of incompatible features
 *
 * Check whether the journaling code supports the use of
 * all of a given set of features on this journal.  Return true
 * (non-zero) if it can. */

int ?@jbd2Prefix?journal_check_available_features (journal_t *journal, unsigned long compat,
				      unsigned long ro, unsigned long incompat)
{

	if (!compat && !ro && !incompat)
		return 1;

	/* We can support any known requested features iff the
	 * superblock is in version 2.  Otherwise we fail to support any
	 * extended sb features. */

	if (journal->j_format_version != 2)
		return 0;

	if ((compat   & ?@jfsjbd2?_KNOWN_COMPAT_FEATURES) == compat &&
	    (ro       & ?@jfsjbd2?_KNOWN_ROCOMPAT_FEATURES) == ro &&
	    (incompat & ?@jfsjbd2?_KNOWN_INCOMPAT_FEATURES) == incompat)
		return 1;

	return 0;
}

/**
 * int ?@jbd2Prefix?journal_set_features () - Mark a given journal feature in the superblock
 * @journal: Journal to act on.
 * @compat: bitmask of compatible features
 * @ro: bitmask of features that force read-only mount
 * @incompat: bitmask of incompatible features
 *
 * Mark a given journal feature as present on the
 * superblock.  Returns true if the requested features could be set.
 *
 */

int ?@jbd2Prefix?journal_set_features (journal_t *journal, unsigned long compat,
			  unsigned long ro, unsigned long incompat)
{
#break: journal_superblock_t
	journal_superblock_t *sb;
	
	if (?@jbd2Prefix?journal_check_used_features(journal, compat, ro, incompat))
		return 1;

	if (!?@jbd2Prefix?journal_check_available_features(journal, compat, ro, incompat))
		return 0;
#endbreak
	jbd_debug(1, "Setting new features 0x%lx/0x%lx/0x%lx\n",
		  compat, ro, incompat);

	sb = journal->j_superblock;
#break: journal_set_features
	sb->s_feature_compat    |= cpu_to_be32(compat);
	sb->s_feature_ro_compat |= cpu_to_be32(ro);
	sb->s_feature_incompat  |= cpu_to_be32(incompat);

	return 1;
}
#endbreak

/**
 * int ?@jbd2Prefix?journal_flush () - Flush journal
 * @journal: Journal to act on.
 *
 * Flush all data for a given journal to disk and empty the journal.
 * Filesystems can use this when remounting readonly to ensure that
 * recovery does not need to happen on remount.
 */

int ?@jbd2Prefix?journal_flush(journal_t *journal)
{
	int err = 0;
	transaction_t *transaction = NULL;

	?@spinWrite?_lock(&journal->j_state_lock);

	/* Force everything buffered to the log... */
	if (journal->j_running_transaction) {
		transaction = journal->j_running_transaction;
		__?@jbd2Prefix?log_start_commit(journal, transaction->t_tid);
	} else if (journal->j_committing_transaction)
		transaction = journal->j_committing_transaction;

	/* Wait for the log commit to complete... */
	if (transaction) {
		tid_t tid = transaction->t_tid;

		?@spinWrite?_unlock(&journal->j_state_lock);
		?@jbd2Prefix?log_wait_commit(journal, tid);
	} else {
		?@spinWrite?_unlock(&journal->j_state_lock);
	}

	/* ...and flush everything in the log out to disk. */
	spin_lock(&journal->j_list_lock);
	while (!err && journal->j_checkpoint_transactions != NULL) {
		spin_unlock(&journal->j_list_lock);
		mutex_lock(&journal->j_checkpoint_mutex);
		err = ?@jbd2Prefix?log_do_checkpoint(journal);
		mutex_unlock(&journal->j_checkpoint_mutex);
		spin_lock(&journal->j_list_lock);
	}
	spin_unlock(&journal->j_list_lock);

	if (is_journal_aborted(journal))
		return -EIO;

	mutex_lock(&journal->j_checkpoint_mutex);
	?@jbd2Prefix?cleanup_journal_tail(journal);

	/* Finally, mark the journal as really needing no recovery.
	 * This sets s_start==0 in the underlying superblock, which is
	 * the magic code for a fully-recovered superblock.  Any future
	 * commits of data to the journal will restore the current
	 * s_start value. */
	?@jbd2Prefix?mark_journal_empty(journal);
	mutex_unlock(&journal->j_checkpoint_mutex);
	?@spinWrite?_lock(&journal->j_state_lock);
	J_ASSERT(!journal->j_running_transaction);
	J_ASSERT(!journal->j_committing_transaction);
	J_ASSERT(!journal->j_checkpoint_transactions);
	J_ASSERT(journal->j_head == journal->j_tail);
	J_ASSERT(journal->j_tail_sequence == journal->j_transaction_sequence);
	?@spinWrite?_unlock(&journal->j_state_lock);
	return 0;
}

/**
 * int ?@jbd2Prefix?journal_wipe() - Wipe journal contents
 * @journal: Journal to act on.
 * @write: flag (see below)
 *
 * Wipe out all of the contents of a journal, safely.  This will produce
 * a warning if the journal contains any valid recovery information.
 * Must be called between journal_init_*() and ?@jbd2Prefix?journal_load().
 *
 * If 'write' is non-zero, then we wipe out the journal on disk; otherwise
 * we merely suppress recovery.
 */

int ?@jbd2Prefix?journal_wipe(journal_t *journal, int write)
{
	int err = 0;

	J_ASSERT (!(journal->j_flags & ?@jfsjbd2?_LOADED));

	err = load_superblock(journal);
	if (err)
		return err;

	if (!journal->j_tail)
		goto no_recovery;

	printk (KERN_WARNING \"?@CAP_FILENAME?: %s recovery information on journal\n\",
		write \? \"Clearing\" : \"Ignoring\");

	err = ?@jbd2Prefix?journal_skip_recovery(journal);
	if (write) {
		/* Lock to make assertions happy... */
		mutex_lock(&journal->j_checkpoint_mutex);
		?@jbd2Prefix?mark_journal_empty(journal);
		mutex_unlock(&journal->j_checkpoint_mutex);
	}

 no_recovery:
	return err;
}

#select folderName
	#option jbd
/*
 * journal_dev_name: format a character string to describe on what
 * device this journal is present.
 */

static const char *journal_dev_name(journal_t *journal, char *buffer)
{
	struct block_device *bdev;

	if (journal->j_inode)
		bdev = journal->j_inode->i_sb->s_bdev;
	else
		bdev = journal->j_dev;

	return bdevname(bdev, buffer);
}
	#endoption
#endselect
/*
 * Journal abort has very specific semantics, which we describe
 * for journal abort.
 *
 * Two internal function, which provide abort to te jbd layer
 * itself are here.
 */

/*
 * Quick version for internal journal use (doesn't lock the journal).
 * Aborts hard --- we mark the abort as occurred, but do _nothing_ else,
 * and don't attempt to make any other journal updates.
 */
static void __?@jbd2Prefix?journal_abort_hard(journal_t *journal)
{
	transaction_t *transaction;
#select folderName
	#option jbd
	char b[BDEVNAME_SIZE];
	#endoption
#endselect
	if (journal->j_flags & ?@jfsjbd2?_ABORT)
		return;

	printk(KERN_ERR "Aborting journal on device %s.\n",
		?@journalDevName?);

	?@spinWrite?_lock(&journal->j_state_lock);
	journal->j_flags |= ?@jfsjbd2?_ABORT;
	transaction = journal->j_running_transaction;
	if (transaction)
		__?@jbd2Prefix?log_start_commit(journal, transaction->t_tid);
	?@spinWrite?_unlock(&journal->j_state_lock);
}

/* Soft abort: record the abort error status in the journal superblock,
 * but don't do any other IO. */
static void __journal_abort_soft (journal_t *journal, int errno)
{
	if (journal->j_flags & ?@jfsjbd2?_ABORT)
		return;

	if (!journal->j_errno)
		journal->j_errno = errno;

	__?@jbd2Prefix?journal_abort_hard(journal);

	if (errno)
		?@jbd2Prefix?journal_update_sb_errno(journal);
}

/**
 * void ?@jbd2Prefix?journal_abort () - Shutdown the journal immediately.
 * @journal: the journal to shutdown.
 * @errno:   an error number to record in the journal indicating
 *           the reason for the shutdown.
 *
 * Perform a complete, immediate shutdown of the ENTIRE
 * journal (not of a single transaction).  This operation cannot be
 * undone without closing and reopening the journal.
 *
 * The ?@jbd2Prefix?journal_abort function is intended to support higher level error
 * recovery mechanisms such as the ext2/ext3 remount-readonly error
 * mode.
 *
 * Journal abort has very specific semantics.  Any existing dirty,
 * unjournaled buffers in the main filesystem will still be written to
 * disk by bdflush, but the journaling mechanism will be suspended
 * immediately and no further transaction commits will be honoured.
 *
 * Any dirty, journaled buffers will be written back to disk without
 * hitting the journal.  Atomicity cannot be guaranteed on an aborted
 * filesystem, but we _do_ attempt to leave as much data as possible
 * behind for fsck to use for cleanup.
 *
 * Any attempt to get a new transaction handle on a journal which is in
 * ABORT state will just result in an -EROFS error return.  A
 * ?@jbd2Prefix?journal_stop on an existing handle will return -EIO if we have
 * entered abort state during the update.
 *
 * Recursive transactions are not disturbed by journal abort until the
 * final ?@jbd2Prefix?journal_stop, which will receive the -EIO error.
 *
 * Finally, the ?@jbd2Prefix?journal_abort call allows the caller to supply an errno
 * which will be recorded (if possible) in the journal superblock.  This
 * allows a client to record failure conditions in the middle of a
 * transaction without having to complete the transaction to record the
 * failure to disk.  ext3_error, for example, now uses this
 * functionality.
 *
 * Errors which originate from within the journaling layer will NOT
 * supply an errno; a null errno implies that absolutely no further
 * writes are done to the journal (unless there are any already in
 * progress).
 *
 */

void ?@jbd2Prefix?journal_abort(journal_t *journal, int errno)
{
	__journal_abort_soft(journal, errno);
}

/**
 * int ?@jbd2Prefix?journal_errno () - returns the journal's error state.
 * @journal: journal to examine.
 *
 * This is the errno numbet set with ?@jbd2Prefix?journal_abort(), the last
 * time the journal was mounted - if the journal was stopped
 * without calling abort this will be 0.
 *
 * If the journal has been aborted on this mount time -EROFS will
 * be returned.
 */
int ?@jbd2Prefix?journal_errno(journal_t *journal)
{
	int err;

	?@spinRead?_lock(&journal->j_state_lock);
	if (journal->j_flags & ?@jfsjbd2?_ABORT)
		err = -EROFS;
	else
		err = journal->j_errno;
	?@spinRead?_unlock(&journal->j_state_lock);
	return err;
}
/**
 * int ?@jbd2Prefix?journal_clear_err () - clears the journal's error state
 * @journal: journal to act on.
 *
 * An error must be cleared or Acked to take a FS out of readonly
 * mode.
 */
int ?@jbd2Prefix?journal_clear_err(journal_t *journal)
{
	int err = 0;

	?@spinWrite?_lock(&journal->j_state_lock);
	if (journal->j_flags & ?@jfsjbd2?_ABORT)
		err = -EROFS;
	else
		journal->j_errno = 0;
	?@spinWrite?_unlock(&journal->j_state_lock);
	return err;
}

/**
 * void ?@jbd2Prefix?journal_ack_err() - Ack journal err.
 * @journal: journal to act on.
 *
 * An error must be cleared or Acked to take a FS out of readonly
 * mode.
 */
void ?@jbd2Prefix?journal_ack_err(journal_t *journal)
{
	?@spinWrite?_lock(&journal->j_state_lock);
	if (journal->j_errno)
		journal->j_flags |= ?@jfsjbd2?_ACK_ERR;
	?@spinWrite?_unlock(&journal->j_state_lock);
}

int ?@jbd2Prefix?journal_blocks_per_page(struct inode *inode)
{
	return 1 << (PAGE_CACHE_SHIFT - inode->i_sb->s_blocksize_bits);
}

#break journal_tag_bytes

/*
 * Journal_head storage management
 */
static struct kmem_cache *?@jbd2Prefix?journal_head_cache;
#ifdef CONFIG_?@CAP_FILENAME?_DEBUG
static atomic_t nr_journal_heads = ATOMIC_INIT(0);
#endif

static int ?@jbd2Prefix?journal_init_journal_head_cache(void)
{
	int retval;

	J_ASSERT(?@jbd2Prefix?journal_head_cache == NULL);
	?@jbd2Prefix?journal_head_cache = kmem_cache_create(\"?@jbd2Prefix?journal_head\",
				sizeof(struct journal_head),
				0,		/* offset */
				SLAB_TEMPORARY,	/* flags */
				NULL);		/* ctor */
	retval = 0;
	if (!?@jbd2Prefix?journal_head_cache) {
		retval = -ENOMEM;
		printk(KERN_EMERG \"?@CAP_FILENAME?: no memory for journal_head cache\n\");
	}
	return retval;
}

static void ?@jbd2Prefix?journal_destroy_journal_head_cache(void)
{
	if (?@jbd2Prefix?journal_head_cache) {
		kmem_cache_destroy(?@jbd2Prefix?journal_head_cache);
		?@jbd2Prefix?journal_head_cache = NULL;
	}
}

/*
 * journal_head splicing and dicing
 */
static struct journal_head *journal_alloc_journal_head(void)
{
	struct journal_head *ret;

#ifdef CONFIG_?@CAP_FILENAME?_DEBUG
	atomic_inc(&nr_journal_heads);
#endif
#select folderName
	#option jbd
	ret = kmem_cache_zalloc(journal_head_cache, GFP_NOFS);
	if (ret == NULL) {
	jbd_debug(1, \"out of memory for journal_head\n\");
	printk_ratelimited(KERN_NOTICE \"ENOMEM in s, retrying.\n\",
			   __func__);

	while (ret == NULL) {
		yield();
		ret = kmem_cache_zalloc(journal_head_cache, GFP_NOFS);
	#endoption
	#option jbd2
	ret = kmem_cache_alloc(jbd2_journal_head_cache, GFP_NOFS);
	if (!ret) {
		jbd_debug(1, \"out of memory for journal_head\n\");
		pr_notice_ratelimited(\"ENOMEM in %s, retrying.\n\", __func__);
		while (!ret) {
			yield();
			ret = kmem_cache_alloc(jbd2_journal_head_cache, GFP_NOFS);
	#endoption
#endselect	
		}
	}
	return ret;
}

static void journal_free_journal_head(struct journal_head *jh)
{
#ifdef CONFIG_?@CAP_FILENAME?_DEBUG
	atomic_dec(&nr_journal_heads);
	memset(jh, ?@CAP_FILENAME?_POISON_FREE, sizeof(*jh));
#endif
	kmem_cache_free(?@jbd2Prefix?journal_head_cache, jh);
}

/*
 * A journal_head is attached to a buffer_head whenever JBD has an
 * interest in the buffer.
 *
 * Whenever a buffer has an attached journal_head, its ->b_state:BH_JBD bit
 * is set.  This bit is tested in core kernel code where we need to take
 * JBD-specific actions.  Testing the zeroness of ->b_private is not reliable
 * there.
 *
 * When a buffer has its BH_JBD bit set, its ->b_count is elevated by one.
 *
 * When a buffer has its BH_JBD bit set it is immune from being released by
 * core kernel code, mainly via ->b_count.
 *
 * A journal_head is detached from its buffer_head when the journal_head's
 * b_jcount reaches zero. Running transaction (b_transaction) and checkpoint
 * transaction (b_cp_transaction) hold their references to b_jcount.
 *
 * Various places in the kernel want to attach a journal_head to a buffer_head
 * _before_ attaching the journal_head to a transaction.  To protect the
 * journal_head in this situation, ?@jbd2Prefix?journal_add_journal_head elevates the
 * journal_head's b_jcount refcount by one.  The caller must call
 * ?@jbd2Prefix?journal_put_journal_head() to undo this.
 *
 * So the typical usage would be:
 *
 *	(Attach a journal_head if needed.  Increments b_jcount)
 *	struct journal_head *jh = ?@jbd2Prefix?journal_add_journal_head(bh);
 *	...
 *      (Get another reference for transaction)
 *	?@jbd2Prefix?journal_grab_journal_head(bh);
 *	jh->b_transaction = xxx;
 *	(Put original reference)
 *	?@jbd2Prefix?journal_put_journal_head(jh);
 */

/*
 * Give a buffer_head a journal_head.
 *
 * May sleep.
 */
struct journal_head *?@jbd2Prefix?journal_add_journal_head(struct buffer_head *bh)
{
	struct journal_head *jh;
	struct journal_head *new_jh = NULL;

repeat:
#select folderName
	#option jbd2
	if (!buffer_jbd(bh)) {
		new_jh = journal_alloc_journal_head();
		memset(new_jh, 0, sizeof(*new_jh));
	}
	#endoption
	#option jbd
	if (!buffer_jbd(bh))
		new_jh = journal_alloc_journal_head();
	#endoption
#endselect
	jbd_lock_bh_journal_head(bh);
	if (buffer_jbd(bh)) {
		jh = bh2jh(bh);
	} else {
		J_ASSERT_BH(bh,
			(atomic_read(&bh->b_count) > 0) ||
			(bh->b_page && bh->b_page->mapping));

		if (!new_jh) {
			jbd_unlock_bh_journal_head(bh);
			goto repeat;
		}

		jh = new_jh;
		new_jh = NULL;		/* We consumed it */
		set_buffer_jbd(bh);
		bh->b_private = jh;
		jh->b_bh = bh;
		get_bh(bh);
		BUFFER_TRACE(bh, "added journal_head");
	}
	jh->b_jcount++;
	jbd_unlock_bh_journal_head(bh);
	if (new_jh)
		journal_free_journal_head(new_jh);
	return bh->b_private;
}

/*
 * Grab a ref against this buffer_head's journal_head.  If it ended up not
 * having a journal_head, return NULL
 */
struct journal_head *?@jbd2Prefix?journal_grab_journal_head(struct buffer_head *bh)
{
	struct journal_head *jh = NULL;

	jbd_lock_bh_journal_head(bh);
	if (buffer_jbd(bh)) {
		jh = bh2jh(bh);
		jh->b_jcount++;
	}
	jbd_unlock_bh_journal_head(bh);
	return jh;
}

static void __journal_remove_journal_head(struct buffer_head *bh)
{
	struct journal_head *jh = bh2jh(bh);

	J_ASSERT_JH(jh, jh->b_jcount >= 0);
	J_ASSERT_JH(jh, jh->b_transaction == NULL);
	J_ASSERT_JH(jh, jh->b_next_transaction == NULL);
	J_ASSERT_JH(jh, jh->b_cp_transaction == NULL);
	J_ASSERT_JH(jh, jh->b_jlist == BJ_None);
	J_ASSERT_BH(bh, buffer_jbd(bh));
	J_ASSERT_BH(bh, jh2bh(jh) == bh);
	BUFFER_TRACE(bh, "remove journal_head");
	if (jh->b_frozen_data) {
		printk(KERN_WARNING "%s: freeing b_frozen_data\n", __func__);
		?@folderName?_free(jh->b_frozen_data, bh->b_size);
	}
	if (jh->b_committed_data) {
		printk(KERN_WARNING "%s: freeing b_committed_data\n", __func__);
		?@folderName?_free(jh->b_committed_data, bh->b_size);
	}
	bh->b_private = NULL;
	jh->b_bh = NULL;	/* debug, really */
	clear_buffer_jbd(bh);
	journal_free_journal_head(jh);
}

/*
 * Drop a reference on the passed journal_head.  If it fell to zero then
 * release the journal_head from the buffer_head.
 */
void ?@jbd2Prefix?journal_put_journal_head(struct journal_head *jh)
{
	struct buffer_head *bh = jh2bh(jh);

	jbd_lock_bh_journal_head(bh);
	J_ASSERT_JH(jh, jh->b_jcount > 0);
	--jh->b_jcount;
	if (!jh->b_jcount) {
		__journal_remove_journal_head(bh);
		jbd_unlock_bh_journal_head(bh);
		__brelse(bh);
	} else
		jbd_unlock_bh_journal_head(bh);
}

#break: begudfs_init_jbd_inode
/*
 * debugfs tunables
 */
#ifdef CONFIG_JBD_DEBUG

u8 journal_enable_debug __read_mostly;
EXPORT_SYMBOL(journal_enable_debug);

static struct dentry *jbd_debugfs_dir;
static struct dentry *jbd_debug;

static void __init jbd_create_debugfs_entry(void)
{
	jbd_debugfs_dir = debugfs_create_dir("jbd", NULL);
	if (jbd_debugfs_dir)
		jbd_debug = debugfs_create_u8("jbd-debug", S_IRUGO | S_IWUSR,
					       jbd_debugfs_dir,
					       &journal_enable_debug);
}

static void __exit jbd_remove_debugfs_entry(void)
{
	debugfs_remove(jbd_debug);
	debugfs_remove(jbd_debugfs_dir);
}

#else

static inline void jbd_create_debugfs_entry(void)
{
}

static inline void jbd_remove_debugfs_entry(void)
{
}

#endif

struct kmem_cache *jbd_handle_cache;

static int __init journal_init_handle_cache(void)
{
	jbd_handle_cache = kmem_cache_create("journal_handle",
				sizeof(handle_t),
				0,		/* offset */
				SLAB_TEMPORARY,	/* flags */
				NULL);		/* ctor */
#endbreak
#select folderName
	#option jbd
	if (?@folderName?_handle_cache == NULL) {
		printk(KERN_EMERG \"?@CAP_FILENAME?: failed to create handle cache\n\");
		return -ENOMEM;
	}
	#endoption
#endselect
	return 0;
}

static void ?@jbd2Prefix?journal_destroy_handle_cache(void)
{
	if (?@folderName?_handle_cache)
		kmem_cache_destroy(?@folderName?_handle_cache);
#select folderName
	#option jbd2
	if (?@folderName?_inode_cache)
		kmem_cache_destroy(?@folderName?_inode_cache);
	#endoption
#endselect
}

/*
 * Module startup and shutdown
 */

static int __init journal_init_caches(void)
{
	int ret;

	ret = ?@jbd2Prefix?journal_init_revoke_caches();
	if (ret == 0)
		ret = ?@jbd2Prefix?journal_init_journal_head_cache();
	if (ret == 0)
		ret = ?@jbd2Prefix?journal_init_handle_cache();
#select folderName
	#option jbd2
	if (ret == 0)
		ret = jbd2_journal_init_transaction_cache();
	#endoption
#endselect
	return ret;
}

static void ?@jbd2Prefix?journal_destroy_caches(void)
{
	?@jbd2Prefix?journal_destroy_revoke_caches();
	?@jbd2Prefix?journal_destroy_journal_head_cache();
	?@jbd2Prefix?journal_destroy_handle_cache();
#select folderName
	#option jbd2
	jbd2_journal_destroy_transaction_cache();
	jbd2_journal_destroy_slabs();
	#endoption
#endselect
}

static int __init journal_init(void)
{
	int ret;

	BUILD_BUG_ON(sizeof(struct journal_superblock_s) != 1024);

	ret = journal_init_caches();
#select folderName
	#option jbd
	if (ret != 0)
		journal_destroy_caches();
	jbd_create_debugfs_entry();
	#endoption
	#option jbd2
	if (ret == 0) {
		jbd2_create_jbd_stats_proc_entry();
	} else {
		jbd2_journal_destroy_caches();
	}
	#endoption
#endselect
	return ret;
}

static void __exit journal_exit(void)
{
#ifdef CONFIG_?@CAP_FILENAME?_DEBUG
	int n = atomic_read(&nr_journal_heads);
	if (n)
		printk(KERN_EMERG \"?@CAP_FILENAME?: leaked d journal_heads!\n\", n);
#endif
#select folderName
	#option jbd
	jbd_remove_debugfs_entry();
	#endoption
	#option jbd2
	jbd2_remove_jbd_stats_proc_entry();
	#endoption
#endselect
	?@jbd2Prefix?journal_destroy_caches();
}

MODULE_LICENSE("GPL");
module_init(journal_init);
module_exit(journal_exit);