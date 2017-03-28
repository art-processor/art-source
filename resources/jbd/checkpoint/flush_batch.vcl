#select fileName
	#option jbd
#define NR_BATCH	64
	#endoption
#endselect

static void
#select fileName
	#option jbd
__flush_batch(journal_t *journal, struct buffer_head **bhs, int *batch_count)
	#endoption
	#option jbd2
__flush_batch(journal_t *journal, int *batch_count)
	#endoption
#endselect
{
	int i;
	struct blk_plug plug;

	blk_start_plug(&plug);
	for (i = 0; i < *batch_count; i++)
		write_dirty_buffer(?@bhsPrefix?bhs[i], WRITE_SYNC);
	blk_finish_plug(&plug);

	for (i = 0; i < *batch_count; i++) {
		struct buffer_head *bh = ?@bhsPrefix?bhs[i];
#select fileName
	#option jbd
		clear_buffer_jwrite(bh);
	#endoption
#endselect
		BUFFER_TRACE(bh, "brelse");
		__brelse(bh);
	}
	*batch_count = 0;
}