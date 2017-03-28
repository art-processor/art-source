package art.command;

import art.stat.StatParam;


/**
 * Abstract Command class
 */
public abstract class Command {
	protected int lineNo;
	
	protected StatParam statParam = StatParam.getInstance();
	
	/**
	 * Override this method for the new commands.
	 */
	public abstract void execute();

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
}
