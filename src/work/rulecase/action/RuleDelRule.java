package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.pojo.RcRule;
import work.rulecase.pojo.RcZl;
import work.util.FileOperation;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 删除
 * @author htzx
 *
 */
public class RuleDelRule {
	
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
//		String realpath = Tld.rulecasepath+"rule/image/";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from RcRule as rr where rr.id="+id;
			sql = "delete from t_rc_rule where id="+id;
//			List<RcRule> list = session.createQuery(hql).list();
//			if(!list.isEmpty())
//			{
//				RcRule rr = list.get(0);
//				fo.DeleteFolder(realpath+rr.getPicname());
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
