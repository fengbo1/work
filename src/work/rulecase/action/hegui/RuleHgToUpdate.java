package work.rulecase.action.hegui;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcRule;

public class RuleHgToUpdate {

	private int id;
	private String pool;
	private RcRule rr;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		
		RcRuleDAO rrdao = new RcRuleDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			System.out.println("pool:"+pool);
			rr = rrdao.findAllById(id);
		}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success"+pool;
	}
}
