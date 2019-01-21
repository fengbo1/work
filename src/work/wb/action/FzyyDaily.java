package work.wb.action;



import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.daily.dao.DailyStatusDAO;

import work.wb.dao.WbFzyyDAO;
import work.wb.dao.WbLrzcDAO;
import work.wb.dao.WbYslrDAO;
import work.wb.pojo.WbFzyy;
import work.wb.pojo.WbLrzc;
import work.wb.pojo.WbYslr;

import com.opensymphony.xwork2.ActionContext;
import ccb.hibernate.HibernateSessionFactory;


public class FzyyDaily  {

	public FzyyDaily() {
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
		WbFzyyDAO dao = new WbFzyyDAO();
		
		DailyStatusDAO dailydao=new DailyStatusDAO();
		List<WbFzyy> list =new ArrayList<WbFzyy>();
		System.out.println(date);
		/*未选择日期默认最近一天日报表*/
		if(getDate()==null||date.isEmpty()||date.length()<1)
		{
			 date=dailydao.findFinalWithWb();
			//ActionContext.getContext().put("message", "请选择正确的日期！");
			 //return "error";
			
		}
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		list = dao.findByDate(date.replace("-", ""));
		trans.commit();
        session.flush();
        session.clear();
        session.close();
        this.setList(list);
        ActionContext.getContext().put("message", message);
		return "success";
	}
}
