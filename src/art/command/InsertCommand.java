package art.command;

import java.sql.SQLException;
import java.util.StringTokenizer;

import art.exception.MissingVariableException;
import art.stat.InsertRecord;
import art.type.BreakPoint;
import art.type.InsertType;
import art.utils.Utils;


/**
 * Implementation of the insert commands. (before-into-after)
 */
public class InsertCommand extends Command {

	private String input;
	private final InsertType type;
	private String content;
	private BreakPoint breakpoint;

	public InsertCommand(String input, InsertType type, String content, int lineNo) {
		this(input, type, content);
		this.lineNo = lineNo;
	}

	/**
	 * Constructor for the insert command
	 * 
	 * @param input
	 *            - expression showing the breakpoint name, where we want to insert the content
	 * @param type
	 *            - type can be before-into-after @see {@link art.type.InsertType}
	 * @param content
	 *            - the content we want to insert Scoping rules are the same as for variables
	 */
	public InsertCommand(String input, InsertType type, String content) {
		this.input = input;
		this.type = type;

		String[] contArray = content.split(System.getProperty("line.separator"));
		String first = contArray[0];
		String last = contArray[contArray.length - 1];

		if (content.replaceAll("\\s", "").length() == 0) {
			this.content = "";
		} else {
			
			if (last.replaceAll("\\s", "").length() == 0) {
				content = splitLastLine(content);
			}
	
			if (first.replaceAll("\\s", "").length() == 0) {	
				content = content.substring(first.length(), content.length());
			}
		
			this.content = content;
		}
	}

	@Override
	public void execute() {
		String expRes = null;
		boolean addNewBreakPoint = false;

		try {
			expRes = Utils.getExpressionsVal(input, lineNo);
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (insert command)");
		}

		String scope = Utils.getActualProcessor().getProcessData().getFiles().lastElement();

		breakpoint = new BreakPoint(expRes, type, content, scope);
		String breakPointName = breakpoint.getName() + "|" + breakpoint.getType().toString();

		// look if we have a breakpoint in an upper level
		if (!(null == Utils.getBreakPoints().get(breakPointName))) {
			BreakPoint stored = Utils.getBreakPoints().get(breakPointName);
			String oldScope = stored.getScope();
			// save a copy of the variable to set it back after the adapt command -->
			// if is an extended adapt (and in the local file)
			if (!(Utils.getExtendedAdapts().isEmpty()) && !(stored.getScope().endsWith(Utils.MIDDLE_SCOPE_NAME))) {
				if (!Utils.getSavedBreakPoints().containsKey(breakPointName)) {
					Utils.getSavedBreakPoints().put(breakPointName, stored);
				}
				if (Utils.getFiles().size() > 0) {
					if (Utils.getExtendedAdapts().size() > 0) {
						if ( (stored.getScope().equals(Utils.getExtendedAdapts().lastElement())) ) {
							// if is on samelevel, don't put it in middle-scpoe
							if ( (Utils.getSameLevelAdapts().isEmpty()) || (!(Utils.getSameLevelAdapts().isEmpty()) && !(stored.getScope().equals(Utils.getSameLevelAdapts().lastElement()))) ) {
								// now I mark the middle scope level with a "|level2" string added to the end of the
								// filename
								breakpoint.setScope(stored.getScope() + Utils.MIDDLE_SCOPE_NAME);
							}
						}
					}
				}
			}
			// <--

			// if it's on the same level, we override the content, if not we don't store the new breakpoint
			if (oldScope.equals(breakpoint.getScope()) || (oldScope + Utils.MIDDLE_SCOPE_NAME).equals(breakpoint.getScope())
					&& oldScope.equals(Utils.getAdaptedFiles().lastElement())) {
				Utils.addBreakPoint(breakpoint);
				addNewBreakPoint = true;
			}
		} else {
			// if we don't have, just store the new breakpoint
			if (!(Utils.getExtendedAdapts().isEmpty()) && Utils.getCurrentFile().equals(Utils.getExtendedAdapts().lastElement())) {
				breakpoint.setScope(breakpoint.getScope() + Utils.MIDDLE_SCOPE_NAME);
			}
			Utils.addBreakPoint(breakpoint);
			addNewBreakPoint = true;
		}

		// System.out.println(Utils.getCurrentFile() + " " + lineNo + " added : " + breakpoint.getName() + " in " +
		// breakpoint.getScope() + " cont "
		// + breakpoint.getContent());

		if (addNewBreakPoint) {
			processStat();
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

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				InsertRecord ir = new InsertRecord();
				ir.setFileId(statParam.getCurrentFileId());
				ir.setLineNo(lineNo);
				ir.setBreakName(input);

				switch (type) {
					case INTO:
						ir.setInsertType(InsertRecord.INSERT_INTO);
						break;
					case BEFORE:
						ir.setInsertType(InsertRecord.INSERT_BEFORE);
						break;
					case AFTER:
						ir.setInsertType(InsertRecord.INSERT_AFTER);
						break;
				}

				ir.save();
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

	@Override
	public String toString() {
		return "InsertCommand [input=" + input + "]";
	}

	public InsertType getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BreakPoint getBreakpoint() {
		return breakpoint;
	}

	public void setBreakpoint(BreakPoint breakpoint) {
		this.breakpoint = breakpoint;
	}
}
