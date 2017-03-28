package art.exception;

public class ExpressionException extends ARTException {

	private static final long serialVersionUID = -8273063322628804501L;

	public ExpressionException(String message) {
		this.setMessage(message);
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

}
