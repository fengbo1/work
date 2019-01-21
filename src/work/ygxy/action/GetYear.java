package work.ygxy.action;

import work.util.YearSeason;

public class GetYear {

	private String yeara;
	private String yearb;
	
	public String getYeara() {
		return yeara;
	}

	public void setYeara(String yeara) {
		this.yeara = yeara;
	}

	public String getYearb() {
		return yearb;
	}

	public void setYearb(String yearb) {
		this.yearb = yearb;
	}

	public String execute() throws Exception
	{
		YearSeason ys = new YearSeason();
		yeara = ys.getThisYear();
		yearb = ys.getLastYear();
		
		return "success";
	}
}
