package art.command;

import org.antlr.runtime.RecognitionException;

import art.exception.MissingVariableException;
import art.exception.ARTSyntaxException;
import art.type.BreakPoint;
import art.utils.Utils;


/**
 * This is used when we use break command among setloop's iter section. Extends from BreakCommand, we have to insert the
 * content in other way.
 */
public class SetLoopIterBreak extends BreakCommand {

	/**
	 * Constructor of extended break command. We don't have default content
	 * 
	 * @param input
	 *            - expression the breakpoint's name
	 */
	public SetLoopIterBreak(String input) {
		super(input);
	}

	/**
	 * Constructor of extended break command. We have default content
	 * 
	 * @param input
	 *            - expression the breakpoint's name
	 * @param content
	 *            - the default content of the breakpoint
	 */
	public SetLoopIterBreak(String input, String content) {
		super(input, content);
	}

	@Override
	protected void insert(BreakPoint bp) {
		try {
			Utils.processInsertIterString(bp.getContent());
		} catch (MissingVariableException e) {
			if (bp.getScope().lastIndexOf('|') > 0) {
				throw new MissingVariableException(e.getMessage() + " (break command: content inserted from file "
						+ bp.getScope().substring(0, bp.getScope().lastIndexOf('|')) + ")");
			} else {
				throw new MissingVariableException(e.getMessage() + " (break command: content inserted from file " + bp.getScope() + ")");
				// e.printStackTrace();
			}
		} catch (RecognitionException e) {
			throw new ARTSyntaxException(e.getMessage());
		}
	}

	@Override
	protected void writeBreaksContent(String cont) {
		if (!(null == cont)) {
			try {
				Utils.processInsertIterString(cont);
			} catch (MissingVariableException e) {
				throw new MissingVariableException(e.getMessage() + " (setloop command)");
			} catch (RecognitionException e) {
				throw new ARTSyntaxException(e.getMessage());
			}
		}
	}
}
