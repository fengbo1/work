package work.rulecase.action.hegui;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class Mgopset {

	private String mngop;
	private String delmngop;
	private String message;
	public String getMngop() {
		return mngop;
	}
	public void setMngop(String mngop) {
		this.mngop = mngop;
	}
	public String getDelmngop() {
		return delmngop;
	}
	public void setDelmngop(String delmngop) {
		this.delmngop = delmngop;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
public String execute() throws Exception{
		
		String sql = "";
		message = "操作成功";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			sql = "update t_no set role='0' where name='"+delmngop+"' and zx='0' and xz!='3'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_no set role='11' where name='"+mngop+"' and zx='0' and xz!='3'";
			session.createSQLQuery(sql).executeUpdate();
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
