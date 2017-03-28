package art.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import art.exception.MissingVariableException;
import art.stat.SetRecord;
import art.type.LoopVariable;
import art.type.MultiValVariable;
import art.type.ProcessVariable;
import art.type.SimpleVariable;
import art.utils.SetLoopInfo;
import art.utils.Utils;


/**
 * Implementation of set command.
 */
public class SetCommand extends Command {

	private String varName;
	private ProcessVariable variable;
	private List<String> results;
	private boolean defer;

	public SetCommand(String varName, List<String> values, boolean defer, int lineNo) {
		this(varName, values, defer);
	}

	/**
	 * Constructor of set command
	 * 
	 * @param varName
	 *            - IDENT identifier of the variable
	 * @param values
	 *            - expression(s) giving the value(s) of the variable (Can be simple of multi value variable)
	 * @param defer
	 *            - defer evaluation option
	 * @param inExtendedAdapt
	 *            - if the set command is in an extended adapt, we create a middle scope for it. It will be on higher
	 *            level than the adapted file and still lower level than the file it is in.
	 */
	public SetCommand(String varName, List<String> values, boolean defer) {
		super();
		this.varName = varName;
		this.setDefer(defer);

		if (null != values) {
			if (!defer) {
				results = getValuesOfExpressions(values);
			} else {
				results = values;
			}

			// if we are in an extended adapt we are creating the middle scoping level (by adding a "|level2" string to
			// the path)
			String scope = Utils.getActualProcessor().getProcessData().getFiles().lastElement();

			if (results.size() > 0) {
				if (results.size() < 2) {
					this.setVariable(new SimpleVariable(results.get(0), scope, defer));
				} else {
					this.setVariable(new MultiValVariable(results, scope, defer));
				}
			}
		}
	}

	@Override
	public void execute() {
		// look if we have a var in an upper level
		if (!(null == Utils.getVariables().get(varName))) {
			ProcessVariable stored = Utils.getVariables().get(varName);
			// save a copy of the variable to set it back after the adapt command -->
			// if is an extended adapt (and in the local file)
			if (!(Utils.getExtendedAdapts().isEmpty()) && !(stored.getScope().endsWith(Utils.MIDDLE_SCOPE_NAME))) {
				if (!Utils.getSavedVariables().containsKey(varName)) {
					Utils.getSavedVariables().put(varName, stored);
				}
				if (Utils.getFiles().size() > 0) {
					if (Utils.getExtendedAdapts().size() > 0) {
						if ( (stored.getScope().equals(Utils.getExtendedAdapts().lastElement())) ) {
							// if is on samelevel, don't put it in middle-scpoe
							if ( (Utils.getSameLevelAdapts().isEmpty()) || (!(Utils.getSameLevelAdapts().isEmpty()) && !(stored.getScope().equals(Utils.getSameLevelAdapts().lastElement()))) ) {
								// now I mark the middle scope level with a "|level2" string added to the end of the
								// filename
								variable.setScope(stored.getScope() + Utils.MIDDLE_SCOPE_NAME);
							}
						}
					}
				}
			}
			// <--

			// if it's on the same level, we override the value, if not we don't store the new value
			String oldScope = Utils.getVariables().get(varName).getScope();
			if (!(null == variable)) {
				if (oldScope.equals(variable.getScope()) || (oldScope + Utils.MIDDLE_SCOPE_NAME).equals(variable.getScope())
						&& oldScope.equals(Utils.getAdaptedFiles().lastElement())) {
					storeVariable(variable);
				}
			}
		} else {
			// if we don't have, just store the new variable
			if (!(Utils.getExtendedAdapts().isEmpty()) && Utils.getCurrentFile().equals(Utils.getExtendedAdapts().lastElement())) {
				variable.setScope(variable.getScope() + Utils.MIDDLE_SCOPE_NAME);
			}
			storeVariable(variable);
		}
	}

	private void storeVariable(ProcessVariable var) {
		if (null != variable) {
			processStat();
			Utils.getActualProcessor().getProcessData().getVariables().put(varName, variable);

			// TODO if we want to add this feature (expanding an existing setLoopVar from outside without insert
			// commands)
			if (varName.contains(".")) {
				String loopVarName = varName.substring(0, varName.indexOf('.'));
				LoopVariable loopVariable = Utils.getActualProcessor().getProcessData().getSetLoopVars().get(loopVarName);
				SetLoopInfo.addVariableToSetLoop(varName, variable.getValue());

				loopVariable.insertVariable((MultiValVariable) Utils.getVariables().get(varName));
			}
		}
	}

	private List<String> getValuesOfExpressions(List<String> exprs) {
		List<String> results = new ArrayList<String>();
		for (String expr : exprs) {
			// solving refernces like #set a = ?@b?, 2, 3 where b is a multi val variable
			if (expr.replaceAll("\\s", "").matches("\\?@[a-zA-Z_][a-zA-Z_0-9]*\\?")) {
				String varName2 = expr.substring(expr.indexOf('@') + 1, expr.lastIndexOf('?')).replaceAll("\\s", "");
				if (null == Utils.getVariables().get(varName2)) {
					throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine() + ": Variable "
							+ varName2 + " is not defined.");
				}
				if (!(null == Utils.getVariables().get(varName2))) {
					// if multi val variable add all values
					if (Utils.getVariables().get(varName2) instanceof MultiValVariable) {
						MultiValVariable temp = (MultiValVariable) Utils.getVariables().get(varName2);
						for (String str2 : temp.getAllValues()) {
							results.add(str2);
						}
					} else {
						// if single val variable add the value
						results.add(Utils.getVariables().get(varName2).getValue());
					}
				}
				// solving refernces like #set a = b, 2, 3 where b is a multi val variable
			} else if (expr.replaceAll("\\s", "").matches("[a-zA-Z_][a-zA-Z_0-9]*")) {
				String varName3 = expr.replaceAll("\\s", "");
				if (null == Utils.getVariables().get(varName3)) {
					throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine() + ": Variable "
							+ varName3 + " is not defined.");
				}
				if (!(null == Utils.getVariables().get(varName3))) {
					// if multi val variable add all values
					if (Utils.getVariables().get(varName3) instanceof MultiValVariable) {
						MultiValVariable temp = (MultiValVariable) Utils.getVariables().get(varName3);
						for (String str2 : temp.getAllValues()) {
							results.add(str2);
						}
					} else {
						// if single val variable add the value
						results.add(Utils.getVariables().get(varName3).getValue());
					}
				}
				// every other case goes to the expressionWalker
			} else {
				// If we set it to arithmetic, we can add value by simple reference like #set a = b instead of #set a =
				// ?@b?
				Utils.setArithmetic(true);
				try {
					String res = Utils.getExpressionsVal(expr, Utils.getExpressionLine());
					results.add(res);
				} catch (MissingVariableException e) {
					// e.printStackTrace();
					throw new MissingVariableException(e.getMessage() + " (set command)");
				}
				Utils.setArithmetic(false);
			}
		}
		return results;
	}

	private void processStat() {
		try {
			if (statParam.isStatEnabled()) {
				SetRecord sr = new SetRecord();
				sr.setFileId(statParam.getCurrentFileId());
				// sr.setCmdValue(varName);
				sr.setVarName(varName);
				sr.setLineNo(lineNo);
				sr.setDefer(defer);
				sr.setValueList(results);
				sr.save();
			}
		} catch (SQLException e) {
			System.out.println("Error occured while processing statistics." + e.getMessage());
			// e.printStackTrace();
		}
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public ProcessVariable getVariable() {
		return variable;
	}

	public void setVariable(ProcessVariable variable) {
		this.variable = variable;
	}

	@Override
	public String toString() {
		return "SetCommand [varName=" + varName + ", variable=" + variable + "]";
	}

	public boolean isDefer() {
		return defer;
	}

	public void setDefer(boolean defer) {
		this.defer = defer;
	}
}
