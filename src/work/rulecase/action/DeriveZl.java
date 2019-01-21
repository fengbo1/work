package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.dao.RcZlDAO;
import work.rulecase.pojo.RcZl;
import ccb.hibernate.HibernateSessionFactory;

public class DeriveZl {

	private int id;
	private String Path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception{
		RcZlDAO rzdao = new RcZlDAO();
		String hql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from RcZl as rz where rz.id="+id;
			List<RcZl> list = session.createQuery(hql).list();
			if(!list.isEmpty())
			{
				RcZl rz = list.get(0);
				Path = rz.getFilename();
			}
			
		}catch (Exception e) {
			trans.rollback();//出错回滚
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
