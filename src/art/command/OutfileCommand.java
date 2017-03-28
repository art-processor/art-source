package art.command;

import java.io.File;
import java.io.IOException;

import art.exception.MissingVariableException;
import art.utils.Utils;


/**
 * Implementation of the output command.
 */
public class OutfileCommand extends Command {

	private String dirName;

	public OutfileCommand(String fileName, int lineNo) {
		this(fileName);
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of the outdir command.
	 * 
	 * @param dirNameExpr
	 *            - expression (usually a string containing the adapted file's path)
	 */
	public OutfileCommand(String dirNameExpr) {
		super();
		dirName = dirNameExpr;
	}

	@Override
	public void execute() {
		String expRes = null;
		try {
			expRes = Utils.getExpressionsVal(dirName, lineNo);

			File newOutputDir = new File(Utils.getRelativeOutputPath() + File.separatorChar + expRes);
			expRes = newOutputDir.getCanonicalPath();

			Utils.changeOutput(expRes);
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (outfile command)");
		} catch (IOException e) {
			System.err.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	public String getFileName() {
		return dirName;
	}

	public void setFileName(String fileName) {
		dirName = fileName;
	}

	@Override
	public String toString() {
		return "Output [fileName=" + dirName + "]";
	}
}
