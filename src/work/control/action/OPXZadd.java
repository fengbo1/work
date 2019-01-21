package work.control.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.CfgXzDAO;
import work.control.dao.HnConfigDAO;
import work.control.pojo.CfgXz;
import work.control.pojo.HnConfig;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class OPXZadd {

	private String type;
	private String qzsx;
	private String content;
	private String detail;
	private String message;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQzsx() {
		return qzsx;
	}
	public void setQzsx(String qzsx) {
		this.qzsx = qzsx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception{
		CfgXzDAO hcdao = new CfgXzDAO();
		message = "增加成功";
		String sql = "";
		int m = 0;
		String n="0";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			
			CfgXz cx = new CfgXz();
			cx.setType(type);
			cx.setContent(content);
			cx.setDetail(detail);
			if(qzsx.equals("qz"))
			{
				n=findCqznum(session);
				cx.setTnum(0);
				cx.setCnum(n);
				cx.setIndx(0);
			}
			else
			{
				m=findTnum(session);
				n=findCnum(session,m);
				cx.setTnum(m);
				cx.setCnum(n);
				cx.setIndx(findIndxnum(session));
			}
			
			hcdao.merge(cx);
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
	public int findIndxnum(Session session)
	{
		int m=0;
		String sql = "from CfgXz where type='"+type+"'";
		List<CfgXz> listt = session.createQuery(sql).list();
		if(listt.isEmpty())
		{
			m=10;
		}
		else
		{
			m=listt.get(0).getIndx();
		}
		return m;
	}
	public String findCqznum(Session session)
	{
		int m=0;
		String sql = "";
		for(int i=1;m==0;i++)
		{
			sql = "SELECT * from t_cfg_xz where type='"+type+"' and cnum="+i;
			List listcx = session.createSQLQuery(sql).list();
			if(listcx.isEmpty())
			{
				m=i;
			}
		}
		return String.valueOf(m);
	}
	public int findTnum(Session session)
	{
		int m=0;
		String sql = "from CfgXz where type='"+type+"'";
		List<CfgXz> listt = session.createQuery(sql).list();
		if(listt.isEmpty())
		{
			for(int i=1;m==0;i++)
			{
				sql = "SELECT * from t_cfg_xz where tnum="+i;
				List listcx = session.createSQLQuery(sql).list();
				if(listcx.isEmpty())
				{
					m=i;
				}
			}
		}
		else
		{
			m=listt.get(0).getTnum();
		}
		return m;
	}
	public String findCnum(Session session,int m)
	{
		String n="0";
		for(int i=1;n.equals("0");i++)
		{
			String s = Tld.chars26.substring(i-1,i);
			String sql = "SELECT * from t_cfg_xz where tnum="+m+" and cnum='"+s+"'";
			List listc = session.createSQLQuery(sql).list();
			if(listc.isEmpty())
			{
				n=s;
			}
		}
		return n;
	}
}
