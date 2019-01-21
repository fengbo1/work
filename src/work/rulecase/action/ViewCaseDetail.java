package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.pojo.RcCase;
import work.rulecase.pojo.RcRule;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class ViewCaseDetail {
	private int id;
	private String imagepath;
	private RcCase rc;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public RcCase getRc() {
		return rc;
	}
	public void setRc(RcCase rc) {
		this.rc = rc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String execute() throws Exception{
		//imagepath = Tld.rulecasepath+"case/image/";
		imagepath =Tld.imagepath+"rulecase/case/image/";
		String hql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		hql = "from RcCase as rc where rc.id="+id;
		List<RcCase> list = session.createQuery(hql).list();
		if(!list.isEmpty())
		{
			rc = list.get(0);
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		if(type!=null&&type.equals("to_update"))
		{
			return "toupdate";
		}
		else
		{
			return "success";
		}
		
	}
}
