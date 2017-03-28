package art.exception;

public abstract class ARTException extends RuntimeException {

	protected String message;
	
	private static final long serialVersionUID = -432963893350092923L;
	
	public abstract String getMessage();

	public abstract void setMessage(String message);
}
