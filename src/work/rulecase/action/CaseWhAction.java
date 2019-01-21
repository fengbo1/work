package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcCase;
import ccb.hibernate.HibernateSessionFactory;

public class CaseWhAction {
	private int mg;
	private List<String> list;
	
	public int getMg() {
		return mg;
	}
	public void setMg(int mg) {
		this.mg = mg;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String execute() throws Exception{
		
		RcRuleDAO rrdao = new RcRuleDAO();
		String sql = "select distinct(pool) from t_rc_case where plate='外汇业务' order by pool";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
//		if(pool.equals("qxz"))
//		{
//			hql = "from RcCase as rr where rr.plate='外汇业务'";
//		}
//		else if(part.equals("qxz"))
//		{
//			hql = "from RcCase as rr where rr.plate='外汇业务' and rr.pool='"+pool+"'";
//		}
//		else if(factor.equals("qxz"))
//		{
//			hql = "from RcCase as rr where rr.plate='外汇业务' and rr.pool='"+pool+"' and rr.part='"+part+"'";
//		}
//		else
//		{
//			hql = "from RcCase as rr where rr.plate='外汇业务' and rr.pool='"+pool+"' and rr.part='"+part+"' and rr.factor='"+factor+"'";
//		}
		list = session.createSQLQuery(sql).list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
