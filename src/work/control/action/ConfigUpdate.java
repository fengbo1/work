package work.control.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.HnConfigDAO;
import work.control.pojo.HnConfig;
import ccb.hibernate.HibernateSessionFactory;

public class ConfigUpdate {

	private int id;
	private int type;
	private String code;
	private String part;
	private int intype;
	private String weig;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception{
		HnConfigDAO hcdao = new HnConfigDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			HnConfig hc = hcdao.findAllById(id);
			hc.setType(type);
			hc.setCode(code);
			hc.setIntype(intype);
			hc.setWeig(weig);
			hc.setPart(part.trim());
			hcdao.merge(hc);
			message = "更新成功";
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
