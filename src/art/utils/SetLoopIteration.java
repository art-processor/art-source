package art.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import art.exception.MissingVariableException;


/**
 * Helper class representing one iteration in the setloop variable
 */
public class SetLoopIteration {

	private Map<String, String> values;

	public SetLoopIteration(Map<String, String> iterVars) {
		Map<String, String> tempVals = new HashMap<String, String>();
		for (Iterator<Map.Entry<String, String>> iterator = iterVars.entrySet().iterator() ; iterator.hasNext() ;) {
			Map.Entry<String, String> var = iterator.next();
			try {
				tempVals.put(var.getKey(), Utils.getExpressionsVal(var.getValue(), Utils.getExpressionLine()));
			} catch (MissingVariableException e) {
				System.err.println(e);
			}
		}
		values = tempVals;
	}

	public Map<String, String> getValues() {
		if (null == values) {
			return new HashMap<String, String>();
		}
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "SetLoopIteration [values=" + values + "]";
	}

	public boolean containsVar(String var) {
		if (values.keySet().contains(var)) {
			return true;
		}
		return false;
	}

	public Set<String> getVarList() {
		return values.keySet();
	}
}
