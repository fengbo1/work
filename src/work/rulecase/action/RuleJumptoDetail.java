package work.rulecase.action;

public class RuleJumptoDetail {

	private String id;
	private String type;
	private String word;

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

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String execute() throws Exception
	{
		if(word!=null)
			word = new String(word.getBytes("ISO8859-1"),"UTF-8");
		return "success";
	}
}
