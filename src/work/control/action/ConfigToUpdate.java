package work.control.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.HnConfigDAO;
import work.control.pojo.HnConfig;

import ccb.hibernate.HibernateSessionFactory;

public class ConfigToUpdate {

	private int id;
	private HnConfig hc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HnConfig getHc() {
		return hc;
	}
	public void setHc(HnConfig hc) {
		this.hc = hc;
	}
	public String execute() throws Exception{
		HnConfigDAO hcdao = new HnConfigDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hc = hcdao.findAllById(id);
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
