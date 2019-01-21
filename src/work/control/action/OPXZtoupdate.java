package work.control.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.CfgXzDAO;
import work.control.pojo.CfgXz;
import work.no.pojo.No;
import ccb.hibernate.HibernateSessionFactory;

public class OPXZtoupdate {
	private int id;
	private CfgXz cx;
	private String members;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CfgXz getCx() {
		return cx;
	}
	public void setCx(CfgXz cx) {
		this.cx = cx;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String execute() throws Exception{
		String sql = "";
		members = "";
		CfgXzDAO hcdao = new CfgXzDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			cx = hcdao.findAllById(id);
			if(cx.getIndx()==0)
			{
				sql = "from No where mid(source,"+cx.getCnum()+",1)='1'";
			}
			else
			{
				sql = "from No where mid(no2,"+cx.getTnum()+",1)='"+cx.getCnum()+"'";
			}
			List<No> list = session.createQuery(sql).list();
			for(int i=0;i<list.size();i++)
			{
				members += list.get(i).getName();
				if(i<(list.size()-1))
				{
					members += "、";
				}
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
