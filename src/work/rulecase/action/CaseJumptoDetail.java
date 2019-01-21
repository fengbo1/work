package work.rulecase.action;

public class CaseJumptoDetail {
	private String id;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String execute() throws Exception
	{
		//System.out.println("type:"+type);
		return "success";
	}
}
