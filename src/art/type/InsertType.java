package art.type;

/**
 * The insert-xxx commands are matched with subsequently processed break
 *	commands in the descendant files via the break-name defined in the break commands. 
 *  In addition, to the break-name, scoping rules are used to
 *	determine which insert-xxx commands match which break commands.
 *	We describe the matching process later in this section.
 *	The following are the details of how insertions are processed:
 *	
 *		· If an insert-before command matches the break command, then the Insert-
 *		  Content of the insert-before command will be processed as if it were inserted
 *		  just before the matching break in the x-frame.
 *	
 *		· If an insert command matches a break command, then the Insert-Content of
 *		  the insert command will be processed as if it replaced the Break-Content of the
 *		  break command. (If the Insert-Content of the insert command is empty, it is
 *		  equivalent to deleting the Break-Content of the break command.)
 *	
 *		· If no insert command matches a particular break command, the processor will
 *		  process its Break-Content.
 *
 *		· The insert-after works analogous to insert-before.
 */
public enum InsertType {
	INTO,
	BEFORE,
	AFTER;
}
