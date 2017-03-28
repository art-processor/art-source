package art.command;

import java.sql.SQLException;
import java.util.StringTokenizer;

import org.antlr.runtime.RecognitionException;

import art.exception.MissingVariableException;
import art.exception.ARTSyntaxException;
import art.stat.BreakRecord;
import art.type.BreakPoint;
import art.type.InsertType;
import art.utils.Utils;


/**
 * Implementation of the break commands. (Simple and Extended break)
 */
public class BreakCommand extends Command {

	private String input;
	private String content = null;

	public BreakCommand(String input, int lineNo) {
		this(input);
		this.lineNo = lineNo;
	}

	public BreakCommand(String input, String content, int lineNo) {
		this(input, content);
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of simple break command. We don't have default content
	 * 
	 * @param input
	 *            - expression the breakpoint's name
	 */
	public BreakCommand(String input) {
		this.input = input;
	}

	/**
	 * Constructor of extended break command. We have default content
	 * 
	 * @param input
	 *            - expression the breakpoint's name
	 * @param content
	 *            - the default content of the breakpoint
	 */
	public BreakCommand(String input, String content) {
		this.input = input;

		String[] contArray = content.split(System.getProperty("line.separator"));
		if (contArray.length > 0) {
			String first = contArray[0];
			String last = contArray[contArray.length - 1];

			if (last.replaceAll("\\s", "").length() == 0) {
				content = splitLastLine(content);
			}

			if (first.replaceAll("\\s", "").length() == 0) {
				content = content.substring(first.length(), content.length());
			}

			this.content = content;
		}
	}

	private String splitLastLine(String content2) {
		StringTokenizer st = new StringTokenizer(content2, System.getProperty("line.separator"));
		StringBuilder ret = new StringBuilder();
		int num = st.countTokens();
		for (int i = 0 ; i < num - 1 ; i++) {
			ret.append(System.getProperty("line.separator") + st.nextToken());
		}
		return ret.toString();
	}

	@Override
	public void execute() {

		if (statParam.isStatEnabled()) {
			statParam.setProcessingInsert(true);
			statParam.setBreakLineNo(lineNo);
		}

		String expRes = null;
		try {
			expRes = Utils.getExpressionsVal(input, lineNo);
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (break command)");
			// e.printStackTrace();
		}

		// This is for distinguish the before after into inserts. This may change
		BreakPoint before = Utils.getBreakPoints().get(expRes + "|" + InsertType.BEFORE.toString());
		BreakPoint after = Utils.getBreakPoints().get(expRes + "|" + InsertType.AFTER.toString());
		BreakPoint into = Utils.getBreakPoints().get(expRes + "|" + InsertType.INTO.toString());

		try {

			// write outputs depending on insert types
			if (!(null == before)) {
				insert(before);
				if (null == into) {
					writeBreaksContent(content);
				}
			}
			if (!(null == into)) {
				insert(into);
			}
			if (!(null == after)) {
				if (null == into && null == before) {
					writeBreaksContent(content);
				}
				insert(after);
			}
			// write default content if is not on output yet
			if (null == into && null == before && null == after) {
				writeBreaksContent(content);
			}
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (break command)");
		}

		processStat();

		if (statParam.isStatEnabled()) {
			statParam.setProcessingInsert(false);
		}
	}

	/**
	 * Inserting the content from the insert command
	 * 
	 * @param bp
	 *            - The breakpoint showing the content to insert
	 */
	protected void insert(BreakPoint bp) {
		try {
			Utils.processString(bp.getContent());
		} catch (MissingVariableException e) {
			if (bp.getScope().lastIndexOf('|') > 0) {
				throw new MissingVariableException(e.getMessage() + " (break command: content inserted from file "
						+ bp.getScope().substring(0, bp.getScope().lastIndexOf('|')) + ")");
			} else {
				throw new MissingVariableException(e.getMessage() + " (break command: content inserted from file " + bp.getScope() + ")");
				// e.printStackTrace();
			}
		} catch (RecognitionException e) {
			System.err.println(e.getMessage());

		}
	}

	/**
	 * Inserting the content from the breakpoint if the breakpoint is an extended breakpoint. (it has default content)
	 * 
	 * @param cont
	 *            - The default content given in the body of break command.
	 */
	protected void writeBreaksContent(String cont) {
		if (!(null == cont)) {
			try {
				Utils.processString(cont);
			} catch (MissingVariableException e) {
				throw new MissingVariableException(e.getMessage() + " (break command)");
			} catch (RecognitionException e) {
				throw new ARTSyntaxException(e.getMessage());
			}
		}
	}

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				BreakRecord br = new BreakRecord();
				br.setFileId(statParam.getCurrentFileId());
				br.setLineNo(lineNo);
				br.setBreakName(input);
				br.save();
			}
		} catch (SQLException e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BreakCommand [input=" + input + "]";
	}
}
