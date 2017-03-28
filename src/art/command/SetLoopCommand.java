package art.command;

import art.utils.SetLoopInfo;

/**
 * Implementation of setloop command.
 */
public class SetLoopCommand extends Command {

	private String input;

	public SetLoopCommand(String input, int lineNo) {
		this.input = input;
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of setloop command
	 * 
	 * @param input
	 *            - IDENT identifier of the setloop
	 */
	public SetLoopCommand(String input) {
		this.input = input;
	}

	@Override
	public void execute() {
		SetLoopInfo.generateSetLoopData();
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}
