package work.rulecase.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcRule;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

/**
 * 搜索功能
 * @author htzx
 *
 */
public class RcRuleSearch {

	private List<String> list;
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String execute() throws Exception{
		
		RcRuleDAO rrdao = new RcRuleDAO();
		String sql = "select distinct(plate) from t_rc_rule where plate!='合规业务' order by locate(substr(plate,1,1),'外合稽反其')";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		list = session.createSQLQuery(sql).list();
//		if(plate==0)
//		{
//			hql = "from RcRule as rr where 1=1";
//		}
//		else if(pool.equals("qxz"))
//		{
//			hql = "from RcRule as rr where rr.plate="+plate;
//		}
//		else if(part.equals("qxz"))
//		{
//			hql = "from RcRule as rr where rr.plate="+plate+" and rr.pool='"+pool+"'";
//		}
//		else if(factor.equals("qxz"))
//		{
//			hql = "from RcRule as rr where rr.plate="+plate+" and rr.pool='"+pool+"' and rr.part='"+part+"'";
//		}
//		else
//		{
//			hql = "from RcRule as rr where rr.plate="+plate+" and rr.pool='"+pool+"' and rr.part='"+part+"' and rr.factor='"+factor+"'";
//		}
//		list = session.createQuery(hql).list();
//		System.out.println(hql);
//		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
