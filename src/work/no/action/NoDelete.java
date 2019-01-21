package work.no.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.no.dao.NoLogDAO;
import work.no.pojo.No;
import work.no.pojo.NoLog;
import work.util.YearSeason;

import ccb.hibernate.HibernateSessionFactory;

public class NoDelete {
	
	private int id;
	private String message;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception
	{
		NoLogDAO nldao = new NoLogDAO();
		YearSeason ys = new YearSeason();
		message = "成功";
		String hql = "delete from t_no where id="+id;
		String hql1 = "from No as n where n.id="+id;
		System.out.println(hql);
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		No no = (No) session.createQuery(hql1).list().get(0);
		String sql = "delete from user_info where no891='"+no.getNo891()+"'";
		session.createSQLQuery(hql).executeUpdate();
		session.createSQLQuery(sql).executeUpdate();
		NoLog nl = new NoLog(no.getName(),no.getNo891(),2,"","","","", ys.getDateTime(),"删除", "", "");
		nldao.save(nl);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
