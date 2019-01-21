package work.hn.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.daily.dao.DailyStatusDAO;
import work.hn.dao.Hn895DAO;
import work.hn.pojo.Hn895;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class Hn895Search {
	private String time;//时间
	private int xz;//人员性质
	private int zx;//所属中心
	private int sequence;
	private String key;//关键字名称
	private List list;
	private String type;//快报，日报
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
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

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		String message="success";
		String temptime = "";
		Integer hndaily= 0;
		Hn895DAO hddao = new Hn895DAO();
		DailyStatusDAO dsdao = new DailyStatusDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		//String sql = "from Hndetail as hd where hd.time=:t order by hd."+key+" desc";
		System.out.println(time);
		if(time==null||time.equals("null"))
		{
			temptime = dsdao.findFinalWithHnWithsession(session);
		}
		else
		{
			temptime = time.replace("-", "");
		}
		 
		if(dsdao.findByTime(temptime)!=null)
		{
			hndaily = dsdao.findByTime(temptime).getHnDaily();
		}
		if(hndaily==null||hndaily!=1)
		{
			type = "quick";
		}
		else
		{
			type = "daily";
		}
		
		System.out.println(time+"-->"+temptime);
		time = temptime;
		List<Hn895> list = hddao.findBykey(temptime, xz, zx, key, sequence);
//		List<HnDetail> list = hddao.findBykey(key);
		trans.commit();
        session.flush();
        session.clear();
        session.close();
        this.setList(list);
        ActionContext.getContext().put("message", message);
		return "success";
	}
	
}
