package art.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import art.exception.MissingVariableException;
import art.utils.Utils;


public class AdaptCopy extends Command {

	private String input;

	public AdaptCopy(String input, int lineNo) {
		this(input);
		this.lineNo = lineNo;
	}

	public AdaptCopy(String input) {
		super();
		this.setInput(input);
	}

	@Override
	public void execute() {
		String expRes = null;
		String tempCurrentFile = Utils.getCurrentFile();
		try {
			expRes = Utils.getExpressionsVal(input, lineNo);
			copyFile(expRes);
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (adapt command)");
		} catch (IOException e) {
			System.err.println("Error: File: " + tempCurrentFile + " line: " + lineNo + " File " + expRes + " " + e.getMessage());
		}

	}

	private void copyFile(String input) throws IOException {
		if (!(new File(input).isAbsolute())) {
			input = Utils.getRelativeAdaptPath() + File.separatorChar + input;
		}
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		FileWriter out = Utils.getActualOutput();
		String line;
		while ((line = br.readLine()) != null) {
			// copy content to output
			if (Utils.canWrite()) {
				out.write(line + System.getProperty("line.separator"));
				out.flush();
			}
		}
		br.close();
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
}
