package art.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.antlr.runtime.RecognitionException;

import art.exception.MissingVariableException;
import art.exception.ARTSyntaxException;
import art.stat.ExprRecord;
import art.stat.VariableRecord;
import art.stat.WhileRecord;
import art.type.MultiValVariable;
import art.type.ProcessVariable;
import art.utils.Utils;


/**
 * Implementation of the while command
 */
public class WhileCommand extends Command {

	private List<String> inputList;
	private List<ProcessVariable> varList;
	private final String content;
	private int loopVarSize;
	private final List<String> varNameList;
	private final List<ExprRecord> exprRecordList;

	public WhileCommand(List<String> iterVarList, String content, int lineNo) {
		this(iterVarList, content);
		this.lineNo = lineNo;
		if (!Utils.getLastWhilesStartLine().empty()) {
			Utils.getLastWhilesStartLine().add(lineNo + Utils.getLastWhilesStartLine().peek());
		} else {
			Utils.getLastWhilesStartLine().add(lineNo);
		}
	}

	/**
	 * Constructor of the while command
	 * 
	 * @param iterVarList
	 *            - the name of the variables we are iterating over
	 * @param content
	 *            - the while command's body
	 */
	public WhileCommand(List<String> iterVarList, String content) {
		inputList = iterVarList;
		varList = new ArrayList<ProcessVariable>();

		varNameList = new ArrayList<>();
		exprRecordList = new ArrayList<>();

		String[] contArray = content.split(System.getProperty("line.separator"));
		if (contArray.length > 0) {
			String first = contArray[0];
			String last = contArray[contArray.length - 1];

			if (last.replaceAll("\\s", "").length() == 0) {
				content = splitLastLine(content);
			}

			if (first.replaceAll("\\s", "").length() == 0) {
				content = content.substring(first.length(), content.length());
			}
		}
		this.content = content;

		this.setLoopVarSize(0);
	}

	private String splitLastLine(String content2) {
		StringTokenizer st = new StringTokenizer(content2, System.getProperty("line.separator"));
		StringBuilder ret = new StringBuilder();
		int num = st.countTokens();
		for (int i = 0 ; i < num - 1 ; i++) {
			ret.append(System.getProperty("line.separator") + st.nextToken());
		}
		return ret.toString();
	}

	/*
	 * private String reArrangeContent(String content) { /*if (content.charAt(0) == '\n'){ content =
	 * content.substring(1, content.length()); } else if (content.charAt(0) == '\r'){ content = content.substring(2,
	 * content.length()); }
	 */

	/*
	 * if (content.charAt(content.length() - 1) == '\n'){ content = content.substring(0, content.length() - 2); }
	 * content += System.getProperty("line.separator"); return content; }
	 */

	@Override
	public void execute() {

		if (statParam.isStatEnabled()) {
			processStat();
			statParam.addProcessingWhile(lineNo);
		}

		for (Iterator<String> iterator = inputList.iterator() ; iterator.hasNext() ;) {
			String str = iterator.next();

			// I had to delete here the whitespace
			str = str.replaceAll("\\s", "");

			String expRes = null;

			// If the expression led to another expression, evaluate it further
			if (str.contains("?@")) {
				try {
					expRes = Utils.getExpressionsVal(str, lineNo);
					if (statParam.isStatEnabled()) {
						ExprRecord er = new ExprRecord();
						er.setFileId(statParam.getCurrentFileId());
						er.setLineNo(lineNo);
						er.setExpr(str);
						er.setValue(expRes);
						er.setUsedSetIdList(statParam.getUsedSetIdList());
						exprRecordList.add(er);
					}
				} catch (MissingVariableException e1) {
					System.err.println(e1);
				}
			} else {
				expRes = str;
				Utils.setExpressionLine(lineNo);
			}

			varNameList.add(expRes);

			if (!(null == expRes)) {
				try {
					ProcessVariable var = Utils.getVariables().get(expRes);
					if (!(null == var)) {
						// we set the size of the variable. Every variable has to be the same size. (in number of
						// values)
						if (var instanceof MultiValVariable) {
							varList.add(var);
							if (loopVarSize == 0) {
								setLoopVarSize(((MultiValVariable) var).getAllValues().size());
							} else {
								if (((MultiValVariable) var).getAllValues().size() != loopVarSize) {
									throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: "
											+ (Utils.getExpressionLine() - lineNo) + ":  " + expRes + "Error occured in the while command");
								}
							}
							// we can have simple variable in the while command, is like a multi value variable with one
							// value.
							// Every variable has to be the same size. (in number of values)
						} else {
							if (loopVarSize == 0) {
								setLoopVarSize(1);
							} else {
								if (1 != loopVarSize) {
									throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: "
											+ (Utils.getExpressionLine() - lineNo) + ":  " + expRes + "Error occured in the while command");
								}
							}
						}
						// if the input of the while command is a setloop, we add all multi value variables form the
						// setloop to the list of values we are iterating over.
					} else if (!(null == Utils.getSetLoopVars().get(expRes))) {
						varList.addAll(Utils.getSetLoopVars().get(expRes).getVars());
						setLoopVarSize(Utils.getSetLoopVars().get(expRes).getVars().get(0).getAllValues().size());

						// In case any variables were added after the definition to the setloop
						for (Iterator<Entry<String, ProcessVariable>> iterator2 = Utils.getVariables().entrySet().iterator() ; iterator2.hasNext() ;) {
							Entry<String, ProcessVariable> entry = iterator2.next();
							if (entry.getKey().startsWith(expRes + '.')) {
								if (!(varList.contains(entry.getValue()))) {
									varList.add(entry.getValue());
								}
							}
						}

					} else {
						throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + (Utils.getExpressionLine() - lineNo)
								+ ": Variable " + expRes + " is not defined");
					}
				} catch (MissingVariableException e) {
					System.err.println(e.getMessage());
					// e.printStackTrace();
				}
			}
		}

		for (Iterator<ProcessVariable> iterator = varList.iterator() ; iterator.hasNext() ;) {
			ProcessVariable pv = iterator.next();
			if (pv instanceof MultiValVariable) {
				((MultiValVariable) pv).setInIteration(true);
			}
		}

		processStat();

		// do the process of the content i times
		for (int i = 0 ; i < loopVarSize ; i++) {
			processOnce(content);
			incLoopIter();
		}

		// for line numbers in error messages
		if (!Utils.getLastWhilesStartLine().isEmpty()) {
			Utils.getLastWhilesStartLine().pop();
		}

		// set variables back to start after process
		for (Iterator<ProcessVariable> iterator = varList.iterator() ; iterator.hasNext() ;) {
			MultiValVariable var = (MultiValVariable) iterator.next();
			var.setActualIter(0);
			if (var instanceof MultiValVariable) {
				var.setInIteration(false);
			}
		}

		if (statParam.isStatEnabled()) {
			statParam.removeProcessingWhile();
		}
	}

	private void incLoopIter() {
		for (Iterator<ProcessVariable> iterator = varList.iterator() ; iterator.hasNext() ;) {
			MultiValVariable var = (MultiValVariable) iterator.next();
			var.setActualIter(var.getActualIter() + 1);
		}
	}

	/**
	 * Process the content using the i-th value if the iterated variables
	 * 
	 * @param content
	 *            - the doby of the while command
	 */
	private void processOnce(String content) {
		try {
			Utils.processString(content);
		} catch (MissingVariableException e) {
			throw new MissingVariableException(e.getMessage() + " (while command)");
		} catch (RecognitionException e) {
			throw new ARTSyntaxException(e.getMessage());
		}
	}

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				WhileRecord wr = new WhileRecord();
				wr.setFileId(statParam.getCurrentFileId());
				wr.setLineNo(lineNo);

				StringBuilder sb = new StringBuilder();
				for (String e : inputList) {
					sb.append(e);
					sb.append(",");
				}
				sb.setLength(sb.length() - 1);
				wr.setExpr(sb.toString());

				List<Long> varIdList = new ArrayList<Long>();
				for (String varName : varNameList) {
					VariableRecord vr = VariableRecord.findByVarName(varName);
					if (vr != null) {
						varIdList.add(vr.getVarId());
					}
				}
				wr.setVarIdList(varIdList);
				wr.save();

				for (ExprRecord er : exprRecordList) {
					er.save();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}

	public List<String> getInputList() {
		return inputList;
	}

	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}

	public List<ProcessVariable> getVarList() {
		return varList;
	}

	public void setVarList(List<ProcessVariable> varList) {
		this.varList = varList;
	}

	@Override
	public String toString() {
		return "WhileCommand [inputList=" + inputList + "]";
	}

	public int getLoopVarSize() {
		return loopVarSize;
	}

	public void setLoopVarSize(int size) {
		loopVarSize = size;
	}
}
