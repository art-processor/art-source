package art.type;

import java.util.List;

/**
 * Class for storing the multi value variables for the time of processing
 */
public class MultiValVariable extends ProcessVariable {

	private List<String> allValues;
	private int actualIter;
	private boolean inIteration;

	public MultiValVariable(List<String> values, String scope, boolean deferred) {
		super(deferred);
		setallValues(values);
		this.setActualIter(0);
		this.setScope(scope);
		this.setInIteration(false);
	}

	@Override
	public String getValue() {
		if (isInIteration()) {
			return allValues.get(actualIter);
		}
		return allValues.toString();
	}

	public List<String> getAllValues() {
		return allValues;
	}

	public void setallValues(List<String> values) {
		allValues = values;
	}

	public int getActualIter() {
		return actualIter;
	}

	public void setActualIter(int actualIter) {
		this.actualIter = actualIter;
	}

	@Override
	public String toString() {
		return "MultiValVariable [allValues=" + allValues + ", actualIter=" + actualIter + "]";
	}

	public boolean isInIteration() {
		return inIteration;
	}

	public void setInIteration(boolean inIteration) {
		this.inIteration = inIteration;
	}

}
