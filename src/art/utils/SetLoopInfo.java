package art.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import art.exception.SetLoopException;
import art.type.LoopVariable;
import art.type.MultiValVariable;


/**
 * Helper class for processing and setting up the setloop variables
 */
public class SetLoopInfo {

	private static Map<String, String> tempVariables;
	private static LoopVariable actualSetLoopVar;
	private static String actualSetLoopVarName;

	// storing all variable names from vars or iters
	private static List<String> allDefinedVars = new ArrayList<String>();

	private static List<SetLoopIteration> allIterations;

	public static void addVariableToSetLoop(String varName, String defaultValue) {
		actualSetLoopVar.setVarSection(true);
		getTempVariables().put(varName, defaultValue);
	}

	public static Map<String, String> getTempVariables() {
		if (null == tempVariables) {
			tempVariables = new HashMap<String, String>();
		}
		return tempVariables;
	}

	public static void addIter(Map<String, String> iterVars) {
		getAllIterations().add(new SetLoopIteration(iterVars));
	}

	public static void generateSetLoopData() {
		verifySetLoopData();

		// making multiVars out of the iterations
		// already verified, here everything has to work.
		for (Iterator<String> it = allDefinedVars.iterator() ; it.hasNext() ;) {
			List<String> valuesForVar = new ArrayList<String>();
			String varName = it.next();
			for (Iterator<SetLoopIteration> iterator2 = allIterations.iterator() ; iterator2.hasNext() ;) {
				SetLoopIteration iter = iterator2.next();

				if (iter.containsVar(varName)) {
					valuesForVar.add(iter.getValues().get(varName));
				} else {
					valuesForVar.add(tempVariables.get(varName));
				}
			}
			MultiValVariable variable = new MultiValVariable(valuesForVar, Utils.getActualProcessor().getProcessData().getFiles().lastElement(), false);
			Utils.getActualProcessor().getProcessData().getVariables().put(actualSetLoopVarName + "." + varName, variable);
			actualSetLoopVar.getVars().add(variable);
		}
	}

	public static void verifySetLoopData() {
		// getting all iterations, looking if every value is determined in iter, or with default value in vars section

		// get the vars section if we have (we can't define new variables in the #iter commands, if we have #vars
		// section)
		if (actualSetLoopVar.hasVarSection()) {
			getAllDefinedVars().addAll(tempVariables.keySet());
			// error if we didn't specify a variable in an iteration which has no default value.
			int itNum = 1;
			for (Iterator<String> it = allDefinedVars.iterator() ; it.hasNext() ;) {
				String varName = it.next();
				for (Iterator<SetLoopIteration> iterator = allIterations.iterator() ; iterator.hasNext() ;) {
					SetLoopIteration SLiteration = iterator.next();
					if (!SLiteration.containsVar(varName) && null == tempVariables.get(varName)) {
						throw new SetLoopException("Error in file: " + Utils.getCurrentFile() + ": In setloop " + actualSetLoopVarName
								+ " Not all variables specified for iterations.\n" + "Variable " + varName + " has no value in iteration " + itNum);
					}
				}
				itNum++;
			}
			// if we don't have #vars section, we don't have default values for variables,
			// so in every iteration we have to define the value of variable
		} else {
			allDefinedVars.addAll(allIterations.get(0).getVarList());
			// error if we didn't defined our variables for every iteration
			int size = allIterations.get(0).getValues().size();
			for (Iterator<SetLoopIteration> iterator2 = allIterations.iterator() ; iterator2.hasNext() ;) {
				SetLoopIteration iter = iterator2.next();
				if (iter.getValues().size() != size) {
					throw new SetLoopException("Error in file: " + Utils.getCurrentFile() + ": In setloop " + actualSetLoopVarName
							+ " [B] Not all variables specified for iterations.\n"
							+ "The setloop command has not default values. Please specify the following variables " + allDefinedVars + " in every iteration: ");
				}
			}
		}
	}

	private static List<String> getAllDefinedVars() {
		if (null == allDefinedVars) {
			allDefinedVars = new ArrayList<String>();
		}
		return allDefinedVars;
	}

	public static LoopVariable getActualSetLoopVar() {
		return actualSetLoopVar;
	}

	public static void setActualSetLoopVar(LoopVariable actualSetLoopVar) {
		SetLoopInfo.actualSetLoopVar = actualSetLoopVar;
		initState();
	}

	private static void initState() {
		allDefinedVars = new ArrayList<String>();
		tempVariables = new HashMap<String, String>();
		allIterations = new ArrayList<SetLoopIteration>();
	}

	public static String getActualSetLoopVarName() {
		return actualSetLoopVarName;
	}

	public static void setActualSetLoopVarName(String actualSetLoopVarName) {
		SetLoopInfo.actualSetLoopVarName = actualSetLoopVarName;
	}

	public static List<SetLoopIteration> getAllIterations() {
		if (null == allIterations) {
			allIterations = new ArrayList<SetLoopIteration>();
		}
		return allIterations;
	}
}
