package art.type;

/**
 * Class for storing the breakpoint for the time of processing
 */
public class BreakPoint extends ARTType{
	
	private InsertType type;
	private String content;
	private String name;
	
	/**
	 * Constructor for breakpoint
	 * 
	 * @param name - the breakpoint's reference name
	 * @param type - the breakpoint's type (for insert) can be before-into-after @see {@link InsertType}
	 * @param content - the content we want to insert into the breakpoint
	 * @param scope - the breakpoint's scope, important for overriding rules
	 */
	public BreakPoint(String name, InsertType type, String content, String scope) {
		super();
		this.type = type;
		this.content = content;
		this.setName(name);
		this.setScope(scope);
	}

	public InsertType getType() {
		return type;
	}

	public void setType(InsertType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BreakPoint [type=" + type + ", content=" + content + ", name="
				+ name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
