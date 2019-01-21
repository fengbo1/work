package work.rulecase.action;

public class RuleToAdd {

	private String plate;
	
	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String execute() throws Exception{
		if(plate!=null)
		plate = new String(plate.getBytes("ISO8859-1"),"UTF-8");
		return "success";
	}
}
