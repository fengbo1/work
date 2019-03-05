package work.rulecase.action.hegui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcRule;
import ccb.hibernate.HibernateSessionFactory;

public class RuleShbzDetail {
	private String bianhao;
	private String pool;
	private RcRule rr;
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
	public RcRule getRr() {
		return rr;
	}
	public void setRr(RcRule rr) {
		this.rr = rr;
	}
public String execute() throws Exception{
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			System.out.println("pool:"+pool);
			String sql = "from RcRule where plate='合规业务' and part='"+bianhao+"' and pool='1'";
			List<RcRule> listtmp = session.createQuery(sql).list();
			if(listtmp.isEmpty())
			{
				rr = new RcRule();
			}
			else
			{
				rr = listtmp.get(0);
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
