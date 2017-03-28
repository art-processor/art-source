package art.command;

import java.io.File;
import java.io.IOException;

import art.exception.MissingVariableException;
import art.utils.Utils;


/**
 * Implementation of the output command.
 */
public class OutdirCommand extends Command {

	private String dirName;

	public OutdirCommand(String dirName, int lineNo) {
		this(dirName);
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of the outdir command.
	 * 
	 * @param dirNameExpr
	 *            - expression (usually a string containing the adapted file's path)
	 */
	public OutdirCommand(String dirNameExpr) {
		super();
		dirName = dirNameExpr;
	}

	@Override
	public void execute() {
		String expRes = null;
		try {
			expRes = Utils.getExpressionsVal(dirName, lineNo);

			if (!(new File(expRes).isAbsolute())) {
				expRes = Utils.getRelativeOutputPath() + File.separatorChar + expRes;
			}

			expRes = expRes + File.separatorChar + Utils.getCurrentOutputFilePostfix();
			File newOutput = new File(expRes);

			// This will make the directories if they doesn't exist
			if (!(null == newOutput.getParentFile())) {
				newOutput.getParentFile().mkdirs();
			}

			try {
				if (!newOutput.exists()) {
					newOutput.createNewFile();
				}
			} catch (IOException e) {
				System.err.println("Error: File: " + Utils.getCurrentFile() + " line: " + lineNo + e.getMessage());
			}

			Utils.changeOutput(expRes);
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (outdir command)");
		} catch (IOException e1) {
			System.err.println("Error: File: " + Utils.getCurrentFile() + " line: " + lineNo + e1.getMessage());
			// e1.printStackTrace();
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
