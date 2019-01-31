package work.rulecase.action.hegui;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.no.pojo.No;
import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcRule;
import ccb.hibernate.HibernateSessionFactory;

public class Rulehgmngop {
	private String mngop;
	public String getMngop() {
		return mngop;
	}
	public void setMngop(String mngop) {
		this.mngop = mngop;
	}

public String execute() throws Exception{
		
		String hql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from No where role='11'";
			List<No> list = session.createQuery(hql).list();
			if(list.isEmpty())
			{
				mngop="无";
			}
			else
			{
				mngop = list.get(0).getName();
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
