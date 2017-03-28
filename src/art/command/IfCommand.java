package art.command;

import java.sql.SQLException;

import art.exception.MissingVariableException;
import art.stat.IfRecord;
import art.utils.Utils;


/**
 * Implementation of the if command.
 */
public class IfCommand extends Command {

	String input;

	public IfCommand(String input, int lineNo) {
		this(input);
		this.lineNo = lineNo;
	}

	public IfCommand(String input) {
		this.input = input;
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
		try {
			// System.out.println("exp is : " + input);
			expRes = Utils.getExpressionsVal(input, lineNo);
			if (!(expRes.equals("true")) || !(Utils.canWrite())) {
				Utils.addWriteblocker("if");
			} else {
				Utils.setSkipElse(true);
				processStat();
			}
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (if command)");
		}
	}

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				IfRecord ir = new IfRecord();
				ir.setFileId(statParam.getCurrentFileId());
				ir.setLineNo(lineNo);
				ir.setExpr(input);
				ir.save();
			}
		} catch (SQLException e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "IfCommand [input=" + input + "]";
	}

}
