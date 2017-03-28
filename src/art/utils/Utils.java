package art.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import antlrGen.command.commandLexer;
import antlrGen.command.commandParser;
import antlrGen.command.setloopiterinsertsLexer;
import antlrGen.command.setloopiterinsertsParser;
import antlrGen.command.setloopvarinsertsLexer;
import antlrGen.command.setloopvarinsertsParser;
import antlrGen.expression.expressionLexer;
import antlrGen.expression.expressionParser;
import antlrGen.expression.expressionParser.evaluator_return;
import antlrGen.expression.expressionWalker;
import art.exception.MissingVariableException;
import art.processor.Processor;
import art.stat.StatParam;
import art.type.BreakPoint;
import art.type.LoopVariable;
import art.type.ProcessVariable;

/**
 * Helper methods for one processing flow
 */
public class Utils {

	public static final String MIDDLE_SCOPE_NAME = "|level2";

	private static Processor actualProcessor;
	private static Stack<String> writeblockStack = new Stack<String>();
	private static Stack<Boolean> elseStack = new Stack<Boolean>();
	private static Stack<Boolean> skipIfStack = new Stack<Boolean>();
	private static Stack<String> extendedAdapts = new Stack<String>();
	private static Stack<String> sameLevelAdapts = new Stack<String>();
	// for line numbers in error messages
	private static Stack<Integer> lastWhilesStartLine;

	private static int expressionLine;
	private static boolean isArithmetic = false;
	private static boolean debugMode = false;

	public static Processor getActualProcessor() {
		return actualProcessor;
	}

	public static void setActualProcessor(Processor processor) {
		actualProcessor = processor;
	}

	/**
	 * Returning the variables stored in this processing flow
	 */
	public static Map<String, ProcessVariable> getVariables() {
		return actualProcessor.getProcessData().getVariables();
	}

	public static Stack<String> getFiles() {
		return actualProcessor.getProcessData().getFiles();
	}

	public static void changeOutput(String newFile) {
		try {
			String fileName = new File(newFile).getCanonicalPath();

			getActualOutput().flush();
			FileWriter fw = new FileWriter(fileName, getOutputFiles().contains(fileName));

			// if (!getOutputFiles().contains(fileName)) {
			getOutputFiles().add(fileName);
			actualProcessor.getProcessData().getFileWriters().put(fileName, fw);
			
			if (!(Utils.getExtendedAdapts().isEmpty()) && Utils.getCurrentFile().equals(Utils.getExtendedAdapts().lastElement()) ) {
					Utils.getSavedOutputStatements().put(getCurrentFile(), getCurrentOutput());
					getOutputStatements().put(fileName, getFiles().lastElement() + MIDDLE_SCOPE_NAME);
			} else {
				getOutputStatements().put(fileName, getFiles().lastElement());
			}
			// }

			actualProcessor.getProcessData().setOutputFile(fileName);

			if (!Utils.getRelativeOutputPath().equals(getFilesDir(fileName))) {
				setRelativeOutputPath(getFilesDir(fileName));
				setOutputDir(getFilesDir(fileName));
			}
			setOutputFile(fileName);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void setOutputDir(String filesDir) {
		actualProcessor.getProcessData().setOutputDir(filesDir);
	}

	/**
	 * Evaluating string expressions and arithmetical expressions
	 * 
	 * @param in
	 *            - the expression as a string
	 * @return - the result of evaluation as a string
	 * @throws RecognitionException
	 * @throws MissingVariableException
	 */
	public static String getExpressionsVal(String in, int line) {
		ANTLRStringStream cahrStream = null;
		setExpressionLine(line);
		try {

			cahrStream = new ANTLRStringStream(in);
		} catch (Exception e) {
			System.err.println("Error in file: " + getCurrentFile() + " line: " + getExpressionLine() + ": " + e);
			// e.printStackTrace();
		}

		expressionLexer lexer = new expressionLexer(cahrStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		expressionParser parser = new expressionParser(tokenStream);
		evaluator_return evaluator;

		String a = null;
		expressionWalker walker = null;

		try {
			evaluator = parser.evaluator();

			CommonTreeNodeStream treeNodeStream = new CommonTreeNodeStream(evaluator.getTree());
			walker = new expressionWalker(treeNodeStream);

			a = walker.evaluator();
		} catch (RecognitionException e) {
			// e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Error in file: " + getCurrentFile() + " line: " + getExpressionLine() + ":");
			// e.printStackTrace();
		}

		if (null == a) {
			throw new MissingVariableException("Error while evaluating " + in);
		}
		StatParam statParam = StatParam.getInstance();
		statParam.setUsedSetIdList(walker.getUsedSetIdList());
		return a.toString();
	}

	/**
	 * Processing contents containing ART commands and expressions
	 * 
	 * @param in
	 *            - the input content as a string
	 * @throws RecognitionException
	 * @throws MissingVariableException
	 */
	public static void processString(String in) throws RecognitionException, MissingVariableException {
		ANTLRStringStream cahrStream = new ANTLRStringStream(in);

		commandLexer lexer = new commandLexer(cahrStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		commandParser parser = new commandParser(tokenStream);

		parser.evaluator();
	}

	/**
	 * Processing content for the inserting in a setloop command's vars section
	 * 
	 * @param in
	 *            - the input content as a string
	 * @throws RecognitionException
	 * @throws MissingVariableException
	 */
	public static void processInsertVarString(String in) throws RecognitionException, MissingVariableException {
		ANTLRStringStream cahrStream = new ANTLRStringStream(in);

		setloopvarinsertsLexer lexer = new setloopvarinsertsLexer(cahrStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		setloopvarinsertsParser parser = new setloopvarinsertsParser(tokenStream);

		parser.evaluator();
	}

	/**
	 * Processing content for the inserting in a setloop command's iter section
	 * 
	 * @param in
	 *            - the input content as a string
	 * @throws RecognitionException
	 * @throws MissingVariableException
	 */
	public static void processInsertIterString(String in) throws RecognitionException, MissingVariableException {
		ANTLRStringStream cahrStream = new ANTLRStringStream(in);

		setloopiterinsertsLexer lexer = new setloopiterinsertsLexer(cahrStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		setloopiterinsertsParser parser = new setloopiterinsertsParser(tokenStream);

		parser.evaluator();
	}

	public static void addWriteblocker(String string) {
		writeblockStack.add(string);
	}

	public static void removeWriteblocker(String string) {
		if (!writeblockStack.isEmpty() && writeblockStack.lastElement().equals(string)) {
			writeblockStack.remove(writeblockStack.lastElement());
		}
	}

	public static Stack<String> getWriteblockStack() {
		return writeblockStack;
	}

	public static boolean canWrite() {
		return writeblockStack.isEmpty();
	}

	public static boolean isSkipElse() {
		if (elseStack.size() > 0) {
			return elseStack.lastElement();
		} else {
			return false;
		}
	}

	public static boolean isSkipIf() {
		if (skipIfStack.size() > 0) {
			return skipIfStack.lastElement();
		} else {
			return false;
		}
	}

	public static void setSkipElse(boolean skipElse) {
		if (elseStack.size() > 0) {
			elseStack.pop();
		}
		elseStack.add(skipElse);
	}

	public static Stack<Boolean> getElseStack() {
		return elseStack;
	}

	/**
	 * Returning the Breakpoint stored in this processing flow
	 */
	public static Map<String, BreakPoint> getBreakPoints() {
		return actualProcessor.getProcessData().getBreakPoints();
	}

	public static void addBreakPoint(BreakPoint value) {
		// Now I'm storing the breakpoint vith an ID: bpName|type (i.e.: AAA|after)
		actualProcessor.getProcessData().getBreakPoints().put(value.getName() + "|" + value.getType().toString(), value);
	}

	public static boolean isString(String value) {
		if (value.charAt(0) == '"' && value.charAt(value.length() - 1) == '"') {
			return true;
		}
		return false;
	}

	public static String copyMultiVariable(String string) {
		return "CopyMultiVariable";
	}

	public static boolean isArithmetic() {
		return isArithmetic;
	}

	public static void setArithmetic(boolean isArithmetic) {
		Utils.isArithmetic = isArithmetic;
	}

	public static void addSetLoopVar(String name, LoopVariable setLoopVar) {
		SetLoopInfo.setActualSetLoopVar(setLoopVar);
		SetLoopInfo.setActualSetLoopVarName(name);
		actualProcessor.getProcessData().getSetLoopVars().put(name, SetLoopInfo.getActualSetLoopVar());
	}

	public static Map<String, LoopVariable> getSetLoopVars() {
		return actualProcessor.getProcessData().getSetLoopVars();
	}

	public static Stack<Boolean> getSkipIfStack() {
		return skipIfStack;
	}

	public static void setSkipIf(boolean skip) {
		if (skipIfStack.size() > 0) {
			skipIfStack.pop();
		}
		skipIfStack.add(skip);
	}

	public static Stack<String> getOutputFiles() {
		return actualProcessor.getProcessData().getOutputFiles();
	}

	public static FileWriter getActualOutput() {
		return Utils.getActualProcessor().getProcessData().getFileWriters().get(Utils.getOutputFiles().peek().toString());
	}

	public static Map<String, String> getOutputStatements() {
		return getActualProcessor().getProcessData().getOutputStatements();
	}

	public static Map<String, ProcessVariable> getSavedVariables() {
		return getActualProcessor().getProcessData().getSavedVariables();
	}

	public static Map<String, String> getSavedOutputStatements() {
		return getActualProcessor().getProcessData().getSavedOutputStatements();
	}

	public static Map<String, BreakPoint> getSavedBreakPoints() {
		return getActualProcessor().getProcessData().getSavedBreakPoints();
	}

	public static Stack<String> getExtendedAdapts() {
		return extendedAdapts;
	}

	public static Stack<String> getSameLevelAdapts() {
		return sameLevelAdapts;
	}

	public static Stack<String> getAdaptedFiles() {
		return actualProcessor.getProcessData().getAdaptedfiles();
	}

	public static String getCurrentFile() {
		return getAdaptedFiles().peek();
	}

	public static int getExpressionLine() {
		if (!getLastWhilesStartLine().isEmpty()) {
			return expressionLine + getLastWhilesStartLine().peek();
		}
		return expressionLine;
	}

	public static void setExpressionLine(int expressionLine) {
		Utils.expressionLine = expressionLine;
	}

	public static Stack<Integer> getLastWhilesStartLine() {
		if (null == lastWhilesStartLine) {
			lastWhilesStartLine = new Stack<Integer>();
		}
		return lastWhilesStartLine;
	}

	public static String getFilesDir(String absolutePath) {
		return absolutePath.substring(0, absolutePath.lastIndexOf(File.separatorChar));
	}

	public static String getCurrentOutputFilePostfix() throws IOException {
		String absolutePath = getCurrentOutput();
		return absolutePath.substring(absolutePath.lastIndexOf(File.separatorChar) + 1, absolutePath.length());
	}

	public static String getOutputDir() throws IOException {
		return getFilesDir(getOutputFile().getCanonicalPath());
	}

	public static File getOutputFile() {
		return new File(getActualProcessor().getProcessData().getOutputFile());
	}

	public static void setOutputFile(String outfile) {
		actualProcessor.getProcessData().setOutputFile(outfile);
	}

	public static String getRelativeAdaptPath() {
		return actualProcessor.getProcessData().getRelativeAdaptPath();
	}

	public static String getRelativeOutputPath() {
		return actualProcessor.getProcessData().getRelativeOutputPath();
	}

	public static void setRelativeAdaptPath(String path) {
		actualProcessor.getProcessData().setRelativeAdaptPath(path);
	}

	public static void setRelativeOutputPath(String path) {
		actualProcessor.getProcessData().setRelativeOutputPath(path);
	}

	public static String getCurrentOutput() throws IOException {
		return getOutputFile().getCanonicalPath();
	}

	public static String getDefaultOutput() {
		return actualProcessor.getProcessData().getDefaultOutput();
	}

	public static boolean isDebugMode() {
		return debugMode;
	}

	public static void setDebugMode(boolean debugMode) {
		Utils.debugMode = debugMode;
	}
}
