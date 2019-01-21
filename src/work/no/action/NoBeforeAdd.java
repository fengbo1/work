package work.no.action;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import work.control.dao.CfgXzDAO;
import work.control.dao.UserCfgDAO;
import work.control.pojo.CfgXz;
import work.control.pojo.NameValueBean;
import work.control.pojo.UserCfg;
import ccb.hibernate.HibernateSessionFactory;

public class NoBeforeAdd {

	private List<UserCfg> listuc;
	public List<UserCfg> getListuc() {
		return listuc;
	}
	public void setListuc(List<UserCfg> listuc) {
		this.listuc = listuc;
	}
	public String execute() throws Exception
	{
		UserCfgDAO ucdao = new UserCfgDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		listuc = ucdao.findAllByType("chu");
		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
