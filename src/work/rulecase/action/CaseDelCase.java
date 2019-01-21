package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.pojo.RcCase;
import work.rulecase.pojo.RcRule;
import work.util.FileOperation;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class CaseDelCase {
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
	public String execute() throws Exception{
		String sql = "";
		String hql = "";
		String path = "";
		message = "删除成功";
//		FileOperation fo = new FileOperation();
//		String realpath = Tld.rulecasepath+"case/image/";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from RcCase as rc where rc.id="+id;
			sql = "delete from t_rc_case where id="+id;
//			List<RcCase> list = session.createQuery(hql).list();
//			if(!list.isEmpty())
//			{
//				RcCase rc = list.get(0);
//				fo.DeleteFolder(realpath+rc.getPicname());
				session.createSQLQuery(sql).executeUpdate();
//				else
//				{
//					message = "请确认文件名或路径！";
//				}
//			}
//			else
//			{
//				message = "id为空";
//			}
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
