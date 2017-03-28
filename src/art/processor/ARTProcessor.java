package art.processor;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import antlrGen.command.commandLexer;
import antlrGen.command.commandParser;
import art.exception.MissingVariableException;
import art.exception.SetLoopException;
import art.exception.ARTSyntaxException;
import art.stat.CommandFileRecord;
import art.stat.StatDB;
import art.stat.StatParam;
import art.utils.ProcessData;
import art.utils.Utils;

/**
 * ART Processor class
 */
public class ARTProcessor extends Processor {

	/**
	 * Constructor of the ART processor
	 * 
	 * @param input
	 *            - the SPC file's path
	 * @throws IOException
	 */
	private final StatParam statParam = StatParam.getInstance();

	public ARTProcessor(String input) throws IOException {
		super();
		inputFile = input;
		this.setProcessData(new ProcessData());
		Utils.setActualProcessor(this);
	}

	@Override
	public void beforeProcess(String inputFile) throws IOException {
		// setting up some default data
		String absolutePath = new File(inputFile).getCanonicalPath();
		String outputDir = Utils.getFilesDir(absolutePath);
		processData.getFiles().add(absolutePath);
		processData.setOutputDir(outputDir);
		processData.setRelativeAdaptPath(outputDir);
		processData.setRelativeOutputPath(outputDir);
		processData.setDefaultOutput(outputDir + File.separatorChar + "defaultOutput.txt");
		Utils.changeOutput(outputDir + File.separatorChar + "defaultOutput.txt");
		processData.getAdaptedfiles().add(absolutePath);

		// if the default output is not empty, delete it.
		File file = new File(processData.getOutputFile());
		if (file.exists()) {
			file.delete();
		}
		processStat();
	}

	@Override
	public void process() {
		try {
			ANTLRFileStream charStream = new ANTLRFileStream(inputFile);

			commandLexer lexer = new commandLexer(charStream);

			TokenStream tokenStream = new CommonTokenStream(lexer);
			commandParser parser = new commandParser(tokenStream);

			parser.evaluator();

			if (statParam.isStatEnabled()) {
				StatDB.shutdown();
			}

		} catch (IOException e) {
			System.err.println("Process couldn't start. Reason: " + e.getMessage());
			// e.printStackTrace();
		} catch (RecognitionException e) {
			System.err.println("Process error. Reason: " + e.getMessage());
			// e.printStackTrace();
		} catch (MissingVariableException e) {
			System.err.println("Process error. Reason: " + e.getMessage());
			// e.printStackTrace();
		} catch (ARTSyntaxException e) {
			System.err.println("Process error. Reason: " + e.getMessage());
			// e.printStackTrace();
		} catch (SetLoopException e) {
			System.err.println("Process error. Reason: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Error occured while processing statistics." + e.getMessage());
		}
	}

	@Override
	public void afterProcess() throws IOException {
		this.getProcessData().clear();

		File file = new File("defaultOutput.txt");
		if (file.exists() && file.length() == 0) {
			file.delete();
		}

		String absolutePath = new File(inputFile).getCanonicalPath();
		File file2 = new File(Utils.getFilesDir(absolutePath) + File.separatorChar + "defaultOutput.txt");
		if (file2.exists() && file.length() == 0) {
			file2.delete();
		}

		System.out.println("Processing done.");
	}

	private void processStat() {
		try {
			if (!(null == statParam) && statParam.isStatEnabled()) {
				StatDB.setup(false);
				CommandFileRecord cfr = new CommandFileRecord(inputFile);
				cfr.save();
				statParam.pushFileId(cfr.getFileId());
			}
		} catch (SQLException e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}

	public String getInput() {
		return inputFile;
	}

	public void setInput(String input) {
		inputFile = input;
	}

	@Override
	public ProcessData getProcessData() {
		return processData;
	}

	@Override
	public void setProcessData(ProcessData processData) {
		this.processData = processData;
	}

	@Override
	public String toString() {
		return "ARTProcessor [input=" + inputFile + ", processData=" + getProcessData() + "]";
	}

}
