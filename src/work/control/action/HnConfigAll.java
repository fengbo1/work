package work.control.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.pojo.Jhsx;
import work.control.pojo.HnConfig;
import ccb.hibernate.HibernateSessionFactory;

public class HnConfigAll {


	/**
	* 列表数据
	*/
	private List<HnConfig> list;

	private static final Log log = LogFactory.getLog(HnConfigAll.class);

	public List<HnConfig> getList() {
		return list;
	}

	public void setList(List<HnConfig> list) {
		this.list = list;
	}

		public String execute() throws Exception{
			Query query;
			String hql = "from HnConfig as hc order by hc.type,hc.ord";
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();
			try {
				query = session.createQuery(hql);
				list = query.list();
			} catch (Exception e) {
				// TODO: handle exception
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
