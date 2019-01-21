package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.pojo.RcZl;
import work.util.FileOperation;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 删除规则资料
 * @author htzx
 *
 */
public class DelRuleZl {

	private int id;
	private int mg;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMg() {
		return mg;
	}
	public void setMg(int mg) {
		this.mg = mg;
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
		mg=1;
		message = "删除成功";
		FileOperation fo = new FileOperation();
		String realpath = Tld.rulecasepath+"rule/doc/";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from RcZl as rz where rz.id="+id;
			sql = "delete from t_rc_zl where id="+id;
			List<RcZl> list = session.createQuery(hql).list();
			if(!list.isEmpty())
			{
				RcZl rz = list.get(0);
				fo.DeleteFolder(realpath+rz.getFilename());
				session.createSQLQuery(sql).executeUpdate();
				
			}
			else
			{
				message = "id为空";
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
