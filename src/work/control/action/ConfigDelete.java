package work.control.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.HnConfigDAO;
import ccb.hibernate.HibernateSessionFactory;

public class ConfigDelete {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute() throws Exception{
		String sql = "delete from t_hn_config where id='"+id+"'";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			session.createSQLQuery(sql).executeUpdate();
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
