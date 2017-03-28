package art.command;

import java.sql.SQLException;

import art.exception.MissingVariableException;
import art.stat.ExprRecord;
import art.stat.SelectRecord;
import art.utils.SelectInfo;
import art.utils.Utils;


/**
 * Implementation of the select command. Implementation of select command also in {@link OptionCommandPart}
 */
public class SelectCommand extends Command {

	String input;
	private final ExprRecord exprRecord = null;
	private String expr;
	private String varName;

	public SelectCommand(String input, int lineNo) {
		this(input);
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of select command
	 * 
	 * @param input
	 *            - expression (must lead to a variable's name)
	 */
	public SelectCommand(String input) {
		// I had to delete whitespace here
		String temp = input.replaceAll("\\s", "");

		this.input = temp;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Override
	public void execute() {
		String expRes = null;
		expr = input;

		try {
			if (input.contains("@") || input.contains("?")) {
				// it has one more level of expression
				input = Utils.getExpressionsVal(input, lineNo);
				if (statParam.isStatEnabled()) {
					ExprRecord er = new ExprRecord();
					er.setFileId(statParam.getCurrentFileId());
					er.setLineNo(lineNo);
					er.setExpr(expr);
					er.setValue(input);
					er.setUsedSetIdList(statParam.getUsedSetIdList());
				}
			}
			expRes = Utils.getExpressionsVal(input, lineNo);
			varName = expRes;
			SelectInfo.addSelect(input, expRes);
			processStat();
		} catch (MissingVariableException e) {
			SelectInfo.addSelect(input, null);
		}
	}

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				SelectRecord sr = new SelectRecord();
				sr.setFileId(statParam.getCurrentFileId());
				sr.setLineNo(lineNo);
				sr.setVarName(varName);
				sr.setExpr(expr);
				sr.save();

				if (exprRecord != null) {
					exprRecord.save();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "SelectCommand [input=" + input + "]";
	}
}
