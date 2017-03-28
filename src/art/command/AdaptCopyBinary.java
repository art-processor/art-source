package art.command;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import art.exception.MissingVariableException;
import art.utils.Utils;


public class AdaptCopyBinary extends Command {

	private String srcFile;
	private String destFile;

	public AdaptCopyBinary(String srcFile, String destFile, int lineNo) {
		this(srcFile, destFile);
		this.lineNo = lineNo;
	}

	public AdaptCopyBinary(String srcFile, String destFile) {
		super();
		this.srcFile = srcFile;
		this.destFile = destFile;
	}

	@Override
	public void execute() {
		String src = null;
		String dest = null;
		String tempCurrentFile = Utils.getCurrentFile();
		try {
			src = Utils.getExpressionsVal(srcFile, lineNo);
			dest = Utils.getExpressionsVal(destFile, lineNo);
			copyFile(src, dest);
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (adapt command)");
		} catch (IOException e) {
			System.err.println("Error: File: " + tempCurrentFile + " line: " + lineNo + " " + e.getMessage());
		}
	}

	private void copyFile(String srcFile, String destFile) throws IOException {
		if (!(new File(srcFile).isAbsolute())) {
			srcFile = Utils.getRelativeAdaptPath() + File.separatorChar + srcFile;
		}
		File src = new File(srcFile);
		if (!(new File(destFile).isAbsolute())) {
			destFile = Utils.getRelativeOutputPath() + File.separatorChar + destFile;
		}
		File dest = new File(destFile);

		// System.out.println("--- coppying from " + src + " to " + dest);

		FileUtils.copyFile(src, dest);
	}

	public String getSrcFile() {
		return srcFile;
	}

	public void setSrcFile(String srcFile) {
		this.srcFile = srcFile;
	}

	public String getDestFile() {
		return destFile;
	}

	public void setDestFile(String destFile) {
		this.destFile = destFile;
	}
}
