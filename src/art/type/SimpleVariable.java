package art.type;

/**
 * Class for storing the simple variables for the time of processing
 */
public class SimpleVariable extends ProcessVariable {

	private String value;
	
	public SimpleVariable(String value, String scope, boolean deferred) {
		super(deferred);
		setValue(value);
		this.setScope(scope);
	}
	
	@Override
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SimpleVariable [value=" + value + ", getScope()=" + getScope()
				+ "]";
	}
	
	public void overrideValue(String value) {
		this.value = value;
	}
}
