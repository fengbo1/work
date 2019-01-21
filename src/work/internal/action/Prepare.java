package work.internal.action;

import work.daily.dao.DailyStatusDAO;
import work.daily.pojo.DailyStatus;
import work.util.GeneralCheck;
/**
 * 数据导入前的准备工作，读取导入状态
 * @author htzx
 *
 */
public class Prepare {

	private String time;
	private int online;
	private int hn891;
	private int hn895;
	private int whbb;
	private int wb891;
	private int wb895;
	private DailyStatus ds1;
	private DailyStatus ds2;
	private DailyStatus ds3;
	private DailyStatus ds4;
	private DailyStatus ds5;
	private int wbjg;//外包加工
	private int hnjg;//行内汇总表加工
	
	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int getOnline() {
		return online;
	}


	public void setOnline(int online) {
		this.online = online;
	}


	public int getHn891() {
		return hn891;
	}


	public void setHn891(int hn891) {
		this.hn891 = hn891;
	}


	public int getHn895() {
		return hn895;
	}


	public void setHn895(int hn895) {
		this.hn895 = hn895;
	}


	public int getWhbb() {
		return whbb;
	}


	public void setWhbb(int whbb) {
		this.whbb = whbb;
	}


	public int getWb891() {
		return wb891;
	}


	public void setWb891(int wb891) {
		this.wb891 = wb891;
	}


	public int getWb895() {
		return wb895;
	}


	public void setWb895(int wb895) {
		this.wb895 = wb895;
	}


	public int getWbjg() {
		return wbjg;
	}


	public void setWbjg(int wbjg) {
		this.wbjg = wbjg;
	}


	public int getHnjg() {
		return hnjg;
	}


	public void setHnjg(int hnjg) {
		this.hnjg = hnjg;
	}

	public DailyStatus getDs1() {
		return ds1;
	}


	public void setDs1(DailyStatus ds1) {
		this.ds1 = ds1;
	}


	public DailyStatus getDs2() {
		return ds2;
	}


	public void setDs2(DailyStatus ds2) {
		this.ds2 = ds2;
	}


	public DailyStatus getDs3() {
		return ds3;
	}


	public void setDs3(DailyStatus ds3) {
		this.ds3 = ds3;
	}


	public DailyStatus getDs4() {
		return ds4;
	}


	public void setDs4(DailyStatus ds4) {
		this.ds4 = ds4;
	}


	public DailyStatus getDs5() {
		return ds5;
	}


	public void setDs5(DailyStatus ds5) {
		this.ds5 = ds5;
	}


	public String execute() throws Exception
	{
		GeneralCheck check = new GeneralCheck();
		DailyStatusDAO dsdao = new DailyStatusDAO();
		ds1 = dsdao.findNew(1);
		ds2 = dsdao.findNew(2);
		ds3 = dsdao.findNew(3);
		ds4 = dsdao.findNew(4);
		ds5 = dsdao.findNew(5);
		if(ds1!=null)
		{
			time = ds1.getTime();
			online = check.IsNullInteger(ds1.getHnonline());
			hn891 = check.IsNullInteger(ds1.getHn891());
			hn895 = check.IsNullInteger(ds1.getHn895());
			whbb = check.IsNullInteger(ds1.getHnwhbb());
			wb891 = check.IsNullInteger(ds1.getWb891());
			wb895 = check.IsNullInteger(ds1.getWb895());
			wbjg = check.IsNullInteger(ds1.getWbjiagong());
			hnjg = check.IsNullInteger(ds1.getHnSummaryQuick());
		}
		
		return "success";
	}
}
