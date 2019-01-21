package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.dao.RcRuleDAO;
import ccb.hibernate.HibernateSessionFactory;

public class RuleJyAction {
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
		String sql = "select distinct(pool) from t_rc_rule where plate='建亚业务' order by pool";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		list = session.createSQLQuery(sql).list();
		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
