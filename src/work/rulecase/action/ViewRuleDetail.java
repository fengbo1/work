package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.pojo.RcRule;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class ViewRuleDetail {

	private int id;
	private String imagepath;
	private RcRule rr;
	private String type;
	private String word;
	private String Path;
	private String[] fujian;
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
	public RcRule getRr() {
		return rr;
	}
	public void setRr(RcRule rr) {
		this.rr = rr;
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
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String[] getFujian() {
		return fujian;
	}
	public void setFujian(String[] fujian) {
		this.fujian = fujian;
	}
	public String execute() throws Exception{
		Path = Tld.rulecasepath+"rule/doc/";
		imagepath =Tld.imagepath+"rulecase/rule/image/";
		String hql = "";
		word = new String(word.getBytes("ISO8859-1"),"UTF-8");
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		hql = "from RcRule as rr where rr.id="+id;
		List<RcRule> list = session.createQuery(hql).list();
		if(!list.isEmpty())
		{
			rr = list.get(0);
			String fj = rr.getFujian();
			if(fj!=null)
			fujian = fj.split(";");
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
