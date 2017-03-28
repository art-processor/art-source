package art.command;

import java.sql.SQLException;

import art.stat.RemoveRecord;
import art.utils.Utils;


/**
 * Implementation of the remove command.
 */
public class RemoveCommand extends Command {

	private String varName;

	public RemoveCommand(String varName, int lineNo) {
		this(varName);
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of the remove part.
	 * 
	 * @param varName
	 *            - expression (must lead to a variable's name)
	 */
	public RemoveCommand(String varName) {
		super();
		this.varName = varName;
	}

	@Override
	public void execute() {
		Utils.getVariables().remove(varName);
		processStat();
	}

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				RemoveRecord rr = new RemoveRecord();
				rr.setFileId(statParam.getCurrentFileId());
				rr.setLineNo(lineNo);
				rr.setVarName(varName);
				rr.save();
			}
		} catch (SQLException e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

}
