package art.type;

/**
 * Abstract class for storing the variables for the time of processing
 */
public abstract class ProcessVariable extends ARTType{
	
	private boolean defered;
	
	/**
	 * Constructor of variables
	 * 
	 * @param deferred - deferred evaluation option
	 */
	public ProcessVariable(boolean deferred) {
		this.defered = deferred;
	}

	/**
	 * Getting the value of the variable.
	 * 	- if the variable is a simple variable: we get it's value
	 *  - if the variable is a multi value variable:
	 *  	- if is in iteration (in any while command as variable to iterate over) we get the i=th value
	 *  	- if is not in iteration we get the first value.
	 *  - if is a setloop variable: the processor donesn't refer directly to the value of the setloop variable.
	 *    The setloop variable has multi value variables inside, the processor refers to the value of these variables .
	 *    
	 * @return value (described above)
	 */
	public abstract String getValue();

	public boolean isDeferred() {
		return defered;
	}
}
