package art.command;

import java.io.File;

import art.exception.MissingVariableException;
import art.stat.OutputRecord;
import art.utils.Utils;


/**
 * Implementation of the output command.
 */
public class OutputCommand extends Command {

	private String fileName;

	public OutputCommand(String fileName, int lineNo) {
		this(fileName);
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of the output command.
	 * 
	 * @param fileNameExpr
	 *            - expression (usually a string containing the adapted file's path)
	 */
	public OutputCommand(String fileNameExpr) {
		super();
		fileName = fileNameExpr;
	}

	@Override
	public void execute() {
		String expRes = null;
		try {
			expRes = Utils.getExpressionsVal(fileName, lineNo);

			if (!(new File(expRes).isAbsolute())) {
				expRes = Utils.getRelativeOutputPath() + File.separatorChar + expRes;
			}

			File newOutput = new File(expRes);

			// This will make the directories if they doesn't exist
			if (!(null == newOutput.getParentFile())) {
				newOutput.getParentFile().mkdirs();
			}

			Utils.changeOutput(expRes);

			processStat();
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (output command)");
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Output [fileName=" + fileName + "]";
	}

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				OutputRecord or = new OutputRecord();
				or.setFileId(statParam.getCurrentFileId());
				// or.setCmdValue(fileName);
				or.setLineNo(lineNo);
				or.setOutputFile(Utils.getExpressionsVal(fileName, lineNo));
				or.save();
			}
		} catch (Exception e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}
}
