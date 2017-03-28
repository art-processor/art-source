package art.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import art.type.BreakPoint;
import art.type.LoopVariable;
import art.type.ProcessVariable;


/**
 * Helper class for one processing flow
 */
public class ProcessData {

	// storing variables
	private Map<String, ProcessVariable> variables;
	// we need it for the scoping of the output
	private Map<String, String> outputStatements;
	// for storing breakpoints
	private final Map<String, BreakPoint> breakPoints;
	// for storing setloops
	private Map<String, LoopVariable> setLoopVars;
	// files opened during the processing (for SCOPING)
	private final Stack<String> files;
	// files adapted during the processing (CURRENTFILE)
	private Stack<String> adaptedfiles;
	// outputfiles during the processing
	private Stack<String> outputFiles;
	// current output file
	private String outputFile;
	private Map<String, FileWriter> fileWriters;
	// this is for the extended adapt when we are creating a middle scoping layer
	// we save the current variable to set it back after the adapt command
	private Map<String, ProcessVariable> savedVariables;
	// same goes for breakpoints
	private Map<String, BreakPoint> savedBreakPoints;
	// and output statements
	private Map<String, String> savedOutputStatements;

	private String outputDir;
	private String relativeAdaptPath;
	private String relativeOutputPath;
	private String defaultOutput = "defaultOutput.txt";

	/**
	 * Constructor of processdata, initialize variables, breakpoints, files.
	 * 
	 * @throws IOException
	 */
	public ProcessData() throws IOException {
		super();
		variables = new HashMap<String, ProcessVariable>();
		breakPoints = new HashMap<String, BreakPoint>();
		files = new Stack<String>();
		outputFile = defaultOutput;
		getFileWriters().put(new File(outputFile).getCanonicalPath(), new FileWriter(outputFile));
		getOutputFiles().add(new File(outputFile).getCanonicalPath());
	}

	public Map<String, ProcessVariable> getVariables() {
		if (null == variables) {
			variables = new HashMap<String, ProcessVariable>();
		}
		return variables;
	}

	public Stack<String> getFiles() {
		return files;
	}

	@Override
	public String toString() {
		return "ProcessData [variables=" + variables + ", files=" + files + "]";
	}

	public void clear() {
		if (!(null == files) && !(files.isEmpty())) {
			files.clear();
		}
		if (!(null == variables) && !(variables.isEmpty())) {
			variables.clear();
		}
		if (!(null == breakPoints) && !(breakPoints.isEmpty())) {
			breakPoints.clear();
		}
		if (!(null == setLoopVars) && !(setLoopVars.isEmpty())) {
			setLoopVars.clear();
		}
		if (!(null == outputFiles) && !(outputFiles.isEmpty())) {
			outputFiles.clear();
		}
		if (!(null == outputFile)) {
			outputFile = null;
		}
		if (!(null == fileWriters)) {
			try {
				for (FileWriter fw : fileWriters.values()) {
					fw.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
				// e.printStackTrace();
			}
		}
		fileWriters = null;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public Map<String, BreakPoint> getBreakPoints() {
		return breakPoints;
	}

	public Map<String, LoopVariable> getSetLoopVars() {
		if (null == setLoopVars) {
			setLoopVars = new HashMap<String, LoopVariable>();
		}
		return setLoopVars;
	}

	public Stack<String> getOutputFiles() {
		if (null == outputFiles) {
			outputFiles = new Stack<String>();
		}
		return outputFiles;
	}

	public Map<String, FileWriter> getFileWriters() {
		if (null == fileWriters) {
			fileWriters = new HashMap<String, FileWriter>();
		}
		return fileWriters;
	}

	public Map<String, String> getOutputStatements() {
		if (null == outputStatements) {
			outputStatements = new HashMap<String, String>();
		}
		return outputStatements;
	}

	public Map<String, ProcessVariable> getSavedVariables() {
		if (null == savedVariables) {
			savedVariables = new HashMap<String, ProcessVariable>();
		}
		return savedVariables;
	}

	public Stack<String> getAdaptedfiles() {
		if (null == adaptedfiles) {
			adaptedfiles = new Stack<String>();
		}
		return adaptedfiles;
	}

	public Map<String, BreakPoint> getSavedBreakPoints() {
		if (null == savedBreakPoints) {
			savedBreakPoints = new HashMap<String, BreakPoint>();
		}
		return savedBreakPoints;
	}

	public String getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public String getRelativeAdaptPath() {
		return relativeAdaptPath;
	}

	public void setRelativeAdaptPath(String relativePath) {
		relativeAdaptPath = relativePath;
	}

	public String getRelativeOutputPath() {
		return relativeOutputPath;
	}

	public void setRelativeOutputPath(String relativeOutputPath) {
		this.relativeOutputPath = relativeOutputPath;
	}

	public String getDefaultOutput() {
		return defaultOutput;
	}

	public void setDefaultOutput(String defaultOutput) {
		this.defaultOutput = defaultOutput;
	}

	public Map<String, String> getSavedOutputStatements() {
		if (null == savedOutputStatements) {
			savedOutputStatements = new HashMap<String, String>();
		}
		return savedOutputStatements;
	}
}
