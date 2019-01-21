package work.hn.action;



import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.daily.dao.DailyStatusDAO;
import work.hn.dao.SummaryDAO;
import work.hn.dao.SummaryDailyDAO;
import work.hn.pojo.SummaryDaily;

import work.wb.dao.WbLrzcDAO;
import work.wb.dao.WbYslrDAO;
import work.wb.pojo.WbLrzc;
import work.wb.pojo.WbYslr;

import com.opensymphony.xwork2.ActionContext;
import ccb.hibernate.HibernateSessionFactory;
/*展示汇总快报表
 * */

public class SummaryDailyReport  {

	public SummaryDailyReport() {
		//super(WbDaily.class);
		// TODO Auto-generated constructor stub
	}
	
	private String date;//时间
	private int xz;//人员性质
	private int zx;//所属中心
	private int team;//分组
	private int sequence;
	private String key;//关键字名称
	private List list;
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	public int getXz() {
		return xz;
	}


	public void setXz(int xz) {
		this.xz = xz;
	}


	public int getZx() {
		return zx;
	}


	public void setZx(int zx) {
		this.zx = zx;
	}


	public int getTeam() {
		return team;
	}


	public void setTeam(int team) {
		this.team = team;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}

	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}

	public int getSequence() {
		return sequence;
	}


	public void setSequence(int sequence) {
		this.sequence = sequence;
	}


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		String message="success";
		SummaryDailyDAO dao = new SummaryDailyDAO();
				
		DailyStatusDAO dailydao=new DailyStatusDAO();
		List<SummaryDaily> list =new ArrayList<SummaryDaily>();
		System.out.println(date);
		/*未选择日期默认最近一天日报表*/
		if(getDate()==null||date.isEmpty()||date.length()<1)
		{
			 date=dailydao.findSummary();
			 list = dao.findByDate(date);
		}
		else
		{
			list = dao.findByDate(date.replace("-", ""));
		}
		
        this.setList(list);
        ActionContext.getContext().put("message", message);
		
		return "success";
	}
}
