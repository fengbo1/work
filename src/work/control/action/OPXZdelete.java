package work.control.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.CfgXzDAO;
import work.control.pojo.CfgXz;
import work.no.pojo.No;

import ccb.hibernate.HibernateSessionFactory;

public class OPXZdelete {
	private int id;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception{
		message="删除成功";
		String sql = "";
		CfgXzDAO hcdao = new CfgXzDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			CfgXz cx = hcdao.findAllById(id);
			int m = 0;
			String n = "";
			if(cx.getIndx()==0)//自定义群组
			{
				m=Integer.valueOf(cx.getCnum());
				int L = m-1;
				int R = m+1;
				sql = "update t_no set source=concat(mid(source,1,"+L+"),'0',mid(source,"+R+",49))";
				session.createSQLQuery(sql).executeUpdate();
				sql = "delete from t_cfg_xz where id='"+id+"'";
				session.createSQLQuery(sql).executeUpdate();
			}
			else
			{
				m=cx.getTnum();
				n=cx.getCnum();
				int L = m-1;
				int R = m+1;
				sql = "update t_no set no2=concat(mid(no2,1,"+L+"),'0',mid(no2,"+R+",49)) where mid(no2,"+m+",1)='"+n+"'";
				session.createSQLQuery(sql).executeUpdate();
				sql = "delete from t_cfg_xz where id='"+id+"'";
				session.createSQLQuery(sql).executeUpdate();
			}
			
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
