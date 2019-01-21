package work.fiona.FUserInfo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import work.fiona.FUserInfo.pojo.FUserInfo;
import work.hibernate.FionaSessionFactory;

public class FionaUserInfoAction {

	public String execute() throws Exception {
		System.out.println("<-测试用例->");
		//String sql = "select * from t_user_info";
		String sql = "insert into t_user_info values ('M79','冯波', '冯波', '286731', '9', '', '30302', '', '', '')";
		Session session = FionaSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.createSQLQuery(sql).executeUpdate();
		//List<FUserInfo> list = session.createSQLQuery(sql).addEntity(FUserInfo.class).list();
		//for(int i=0;i<list.size();i++)
		//{
		//	FUserInfo fui = list.get(i);
			//System.out.println(fui.getName());
		//}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
