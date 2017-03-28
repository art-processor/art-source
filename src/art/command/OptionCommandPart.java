package art.command;

import java.util.Iterator;
import java.util.List;

import art.exception.MissingVariableException;
import art.exception.ARTSyntaxException;
import art.utils.SelectInfo;
import art.utils.Utils;


/**
 * Implementation of the select command's option part
 */
public class OptionCommandPart extends Command {

	private List<String> input;

	public OptionCommandPart(List<String> input, int lineNo) {
		this.input = input;
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of the option part.
	 * 
	 * @param input
	 *            - expression
	 */
	public OptionCommandPart(List<String> input) {
		this.input = input;
	}

	@Override
	public void execute() {
		String expRes = null;
		boolean thereIsGoodOption = false;

		try {
			for (Iterator<String> iterator = input.iterator() ; iterator.hasNext() ;) {
				String exp = iterator.next();

				expRes = Utils.getExpressionsVal(exp, lineNo);
				if (null == Utils.getVariables().get(SelectInfo.getSelectKeyStack().lastElement())) {
					throw new ARTSyntaxException("Error in file: " + Utils.getCurrentFile() + " line: " + lineNo
							+ " Variable given in the option's select command doensn't exist");
				}
				String compareToThisString = Utils.getVariables().get(SelectInfo.getSelectKeyStack().lastElement()).getValue();

				if (expRes.equals(compareToThisString)) {
					thereIsGoodOption = true;
				}

			}
			if (SelectInfo.undefined() || !(Utils.canWrite()) || !thereIsGoodOption) {
				Utils.addWriteblocker("option");
			} else {
				SelectInfo.setSkipOtherwise(true);
			}
		} catch (MissingVariableException | ARTSyntaxException e) {
			throw new MissingVariableException(e.getMessage() + " (option command)");
		}
	}

	public List<String> getInput() {
		return input;
	}

	public void setInput(List<String> input) {
		this.input = input;
	}

	@Override
	public String toString() {
		return "IfCommand [input=" + input + "]";
	}

}
