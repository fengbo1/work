package work.control.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import work.control.dao.HnConfigDAO;
import work.control.pojo.HnConfig;

public class ConfigAdd {
	private List<HnConfig> list;
	private int type;
	private String code;
	private String part;
	private int intype;
	private String weig;
	private String message;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public int getIntype() {
		return intype;
	}

	public void setIntype(int intype) {
		this.intype = intype;
	}

	public String getWeig() {
		return weig;
	}

	public void setWeig(String weig) {
		this.weig = weig;
	}

	public List<HnConfig> getList() {
		return list;
	}

	public void setList(List<HnConfig> list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception{
		Query query;
		HnConfigDAO hcdao = new HnConfigDAO();
		String hql = "";
		int max=1;
		message = "增加成功";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "select max(ord) from t_hn_config where type='"+type+"'";
			if(session.createSQLQuery(hql).uniqueResult()!=null)
			{
				max = Integer.valueOf(session.createSQLQuery(hql).uniqueResult().toString())+1;
			}
			HnConfig hc = new HnConfig();
			hc.setType(type);
			hc.setPart(part.trim());
			hc.setCode(code);
			hc.setWeig(weig);
			hc.setIntype(intype);
			hc.setOrd(max);
			hcdao.merge(hc);
			hql = "from HnConfig as hc order by hc.type,hc.ord";
			query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
		
	}
}
