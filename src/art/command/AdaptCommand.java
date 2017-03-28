package art.command;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import antlrGen.command.commandLexer;
import antlrGen.command.commandParser;
import art.exception.MissingVariableException;
import art.exception.ARTSyntaxException;
import art.stat.AdaptRecord;
import art.stat.CommandFileRecord;
import art.type.BreakPoint;
import art.type.ProcessVariable;
import art.utils.Utils;

/**
 * Implementation of the adapt commands. (Simple and Extended adapt)
 */
public class AdaptCommand extends Command {

	private String input;
	private final boolean sameLevel;

	public AdaptCommand(String input, boolean sameLevel, int lineNo) {
		this(input, sameLevel);
		this.lineNo = lineNo;
	}

	/**
	 * Constructor of the command. The input can be an expression.
	 * 
	 * @param input
	 *            - expression (usually a string containing the adapted file's path)
	 * @param sameLevel
	 *            - with this option we raise the adapted file in the adaptor's scoping level
	 */
	public AdaptCommand(String input, boolean sameLevel) {
		super();
		this.input = input;
		this.sameLevel = sameLevel;
	}

	@Override
	public void execute() {
		String expRes = null;
		String tempCurrentFile = Utils.getCurrentFile();

		try {
			processStat();

			expRes = Utils.getExpressionsVal(input, lineNo);
			adaptFile(expRes);

			if (statParam.isStatEnabled()) {
				statParam.popFileId();
			}
		} catch (IOException e) {
			System.err.println("Error: File: " + tempCurrentFile + " line: " + lineNo + " File " + expRes + " doesn't exist.");
			// e.printStackTrace();
		} catch (RecognitionException e) {
			throw new ARTSyntaxException(e.getMessage());
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (adapt command)");
		}
	}

	/**
	 * Processing the adapted file. After process the processor continues with the adaptor file
	 * 
	 * @param input
	 *            - expression (usually a string containing the adapted file's path)
	 * @throws IOException
	 * @throws RecognitionException
	 */
	private void adaptFile(String input) throws IOException, RecognitionException {
		// If the sameLevel attribute is set. We wont store the new file in the fileStack.
		// That way we don't open a new scoping level, the scoping level of the adapted file will be the same.

		// set up relative path to absolute
		if (!(new File(input).isAbsolute())) {
			input = Utils.getRelativeAdaptPath() + File.separatorChar + input;
		}

		String path = new File(input).getCanonicalPath();
		Utils.getAdaptedFiles().add(path);
		Utils.setRelativeAdaptPath(Utils.getFilesDir(Utils.getCurrentFile()));

		if (!sameLevel) {
			Utils.getFiles().add(path);
		}

		ANTLRFileStream cahrStream = new ANTLRFileStream(input);

		commandLexer lexer = new commandLexer(cahrStream);

		TokenStream tokenStream = new CommonTokenStream(lexer);
		commandParser parser = new commandParser(tokenStream);

		parser.evaluator();

		// we are out of the scope of the adapted file.
		// delete all variables which are defined in this scope. -->
		for (Iterator<Entry<String, ProcessVariable>> iterator = Utils.getVariables().entrySet().iterator() ; iterator.hasNext() ;) {
			Entry<String, ProcessVariable> pv = iterator.next();
			if (pv.getValue().getScope().equals(new File(input).getCanonicalPath())) {
				iterator.remove();
			}
		}
		// <--
		// delete all breakpoints which are defined in this scope. -->
		for (Iterator<Entry<String, BreakPoint>> iterator = Utils.getBreakPoints().entrySet().iterator() ; iterator.hasNext() ;) {
			Entry<String, BreakPoint> bp = iterator.next();
			if (!(null == bp.getValue())) {
				if (bp.getValue().getScope().equals(new File(input).getCanonicalPath())) {
					iterator.remove();
				}
			}
		}
		// <--

		// delete the output statement which is defined in this scope -->
		int popNum = 0;
		for (Iterator<Entry<String, String>> iterator = Utils.getOutputStatements().entrySet().iterator() ; iterator.hasNext() ;) {
			Entry<String, String> os = iterator.next();
			if (os.getValue().equals(new File(input).getCanonicalPath())) {
				iterator.remove();
				popNum++;
			}
		}
		for (int i = 0 ; i < popNum ; i++) {	
			Utils.getOutputFiles().pop();
			
			// This deletes the middle scoped outputs at the end of adapt
			while (Utils.getOutputStatements().get(Utils.getOutputFiles().lastElement()).endsWith(Utils.MIDDLE_SCOPE_NAME)){
				Utils.getOutputStatements().remove(Utils.getOutputFiles().lastElement());
				Utils.getOutputFiles().pop();
			}
		}
		if (popNum > 0) {
			Utils.changeOutput(Utils.getOutputFiles().lastElement());
			popNum = 0;
		}
		// <--

		if (!sameLevel) {
			Utils.getFiles().pop();
		}
		Utils.getAdaptedFiles().pop();
		Utils.setRelativeAdaptPath(Utils.getFilesDir(Utils.getCurrentFile()));

		// delete the middle scoping level if we are in an extended adapt, so we set back scoping to normal -->
		if (!Utils.getExtendedAdapts().isEmpty()) {
			List<String> varKeys = new ArrayList<String>();
			// for variables -->
			for (Iterator<Entry<String, ProcessVariable>> iterator = Utils.getVariables().entrySet().iterator() ; iterator.hasNext() ;) {
				Entry<String, ProcessVariable> pv = iterator.next();
				// set back the scoping of the variable to the one before we created the middle scoping level
				if ((pv.getValue().getScope()).equals(Utils.getExtendedAdapts().lastElement() + Utils.MIDDLE_SCOPE_NAME)) {
					varKeys.add(pv.getKey());
					iterator.remove();
				}
			}
			if (varKeys.size() > 0) {
				for (String key : varKeys) {
					if (!(null == Utils.getSavedVariables().get(key))) {
						Utils.getVariables().put(key, Utils.getSavedVariables().get(key));
					}
				}
			}
			// <--

			// for breakpoints
			List<String> bpKeys = new ArrayList<String>();
			for (Iterator<Entry<String, BreakPoint>> iterator = Utils.getBreakPoints().entrySet().iterator() ; iterator.hasNext() ;) {
				Entry<String, BreakPoint> bp = iterator.next();
				// set beck the scoping of the breakpoint to the one before we created the middle scoping level
				if (!(null == bp.getValue())) {
					if ((bp.getValue().getScope()).equals(Utils.getExtendedAdapts().lastElement() + Utils.MIDDLE_SCOPE_NAME)) {
						bpKeys.add(bp.getKey());
						iterator.remove();
					}
				}
			}
			if (bpKeys.size() > 0) {
				for (String key : bpKeys) {
					if (!(null == Utils.getSavedBreakPoints().get(key))) {
						Utils.getBreakPoints().put(key, Utils.getSavedBreakPoints().get(key));
					}
				}
			}
			// <--

			// for outputStatements
			List<String> osKeys = new ArrayList<String>();
			int popNum2 = 0;
			for (Iterator<Entry<String, String>> iterator = Utils.getOutputStatements().entrySet().iterator() ; iterator.hasNext() ;) {
				Entry<String, String> os = iterator.next();
				// System.out.println("v: " + os.getValue());
				// System.out.println("k: " + os.getKey());
				// System.out.println(os.getValue());
				// System.out.println(Utils.getExtendedAdapts().lastElement() + Utils.MIDDLE_SCOPE_NAME);
				if (os.getValue().equals(Utils.getExtendedAdapts().lastElement() + Utils.MIDDLE_SCOPE_NAME)) {
					osKeys.add(os.getKey());
					// System.out.println("in " + os);
					iterator.remove();
					popNum2++;
				}
			}
			for (int i = 0 ; i < popNum2 ; i++) {
				Utils.getOutputFiles().pop();
			}
			if (popNum2 > 0) {
				Utils.changeOutput(Utils.getOutputFiles().lastElement());
				popNum2 = 0;
			}
			
			// <--
			if (!Utils.getExtendedAdapts().isEmpty()) {
				
				Utils.getExtendedAdapts().pop();
			}
			if (!Utils.getSameLevelAdapts().isEmpty()) {
				
				Utils.getSameLevelAdapts().pop();
			}
			
			if (osKeys.size() > 0) {
				for (String key : osKeys) {
					if (!(null == Utils.getSavedOutputStatements().get(key))) {
						Utils.getOutputStatements().put(key, Utils.getSavedOutputStatements().get(key));
					}
				}
			}
			// System.out.println(Utils.getSavedOutputStatements());
			// System.out.println(Utils.getOutputStatements());
		}
		// <--
	}

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				String fileName = Utils.getExpressionsVal(input, lineNo);
				CommandFileRecord cfr = new CommandFileRecord(fileName);
				cfr.save();
				AdaptRecord ar = new AdaptRecord();
				ar.setFileId(statParam.getCurrentFileId());
				// ar.setCmdValue(input);
				ar.setLineNo(lineNo);
				/*
				 * String adaptExpr = input; if(adaptExpr.startsWith("\"")) { adaptExpr = adaptExpr.substring(1); }
				 * if(adaptExpr.endsWith("\"")) { adaptExpr = adaptExpr.substring(0, adaptExpr.length() - 1); }
				 * ar.setAdaptExpr(adaptExpr);
				 */
				ar.setAdaptExpr(fileName);
				ar.setAdaptingFileId(statParam.getCurrentFileId());
				ar.setAdaptedFileId(cfr.getFileId());
				ar.setSameLevel(sameLevel);
				ar.save();
				statParam.pushFileId(cfr.getFileId());
			}
		} catch (Exception e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Override
	public String toString() {
		return "AdaptCommand [input=" + input + "]";
	}
}
