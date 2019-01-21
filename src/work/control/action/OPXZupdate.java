package work.control.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.CfgXzDAO;
import work.control.dao.HnConfigDAO;
import work.control.pojo.CfgXz;
import work.control.pojo.HnConfig;
import ccb.hibernate.HibernateSessionFactory;

public class OPXZupdate {

	private int id;
	private int indx;
	private String type;
	private String oldtype;
	private String content;
	private String detail;
	private String members;
	private String message;
	private String oldmembers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndx() {
		return indx;
	}
	public void setIndx(int indx) {
		this.indx = indx;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOldtype() {
		return oldtype;
	}
	public void setOldtype(String oldtype) {
		this.oldtype = oldtype;
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
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getOldmembers() {
		return oldmembers;
	}
	public void setOldmembers(String oldmembers) {
		this.oldmembers = oldmembers;
	}
	public String execute() throws Exception{
		CfgXzDAO cxdao = new CfgXzDAO();
		OPXZadd oa = new OPXZadd();
		String sql = "";
		message = "更新成功";
		members = "'"+members.replace("、","','")+"'";
		oldmembers = "'"+oldmembers.replace("、","','")+"'";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			int m=0;
			String n="0";
			CfgXz cx = cxdao.findAllById(id);
			if(cx.getIndx()==0)//自定义群组
			{
				m = Integer.valueOf(cx.getCnum());
				int L = m-1;
				int R = m+1;
				sql = "update t_no set source=concat(mid(source,1,"+L+"),'0',mid(source,"+R+",49)) where name in ("+oldmembers+")";
				session.createSQLQuery(sql).executeUpdate();
				sql = "update t_no set source=concat(mid(source,1,"+L+"),'"+1+"',mid(source,"+R+",49)) where name in ("+members+")";
				session.createSQLQuery(sql).executeUpdate();
				cx.setType(type);
				cx.setContent(content);
				cx.setDetail(detail);
				cxdao.merge(cx);
			}
			else//自定义人员属性
			{
				m=cx.getTnum();
				n=cx.getCnum();
				int L = m-1;
				int R = m+1;
				
				sql = "update t_no set no2=concat(mid(no2,1,"+L+"),'0',mid(no2,"+R+",49)) where name in ("+oldmembers+")";
				session.createSQLQuery(sql).executeUpdate();
				if(!type.equals(oldtype))
				{
					sql = "from CfgXz where type='"+type+"'";
					System.out.println(sql);
					List<CfgXz> list = session.createQuery(sql).list();
					if(list.isEmpty())
					{
						m = oa.findTnum(session);
						System.out.println(oa.findTnum(session));
					}
					else
					{
						CfgXz cxt = list.get(0);
						m = cxt.getTnum();
						System.out.println(list.get(0).getTnum());
					}
					n = oa.findCnum(session, m);
					L = m-1;
					R = m+1;
				}
				sql = "update t_no set no2=concat(mid(no2,1,"+L+"),'"+n+"',mid(no2,"+R+",49)) where name in ("+members+")";
				session.createSQLQuery(sql).executeUpdate();
				cx.setType(type);
				cx.setContent(content);
				cx.setDetail(detail);
				cx.setTnum(m);
				cx.setCnum(n);
				
				sql = "select count(*) from t_cfg_xz where indx='"+indx+"' and type!='"+oldtype+"'";
				int a = Integer.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
				if(a==0)
				{
					sql = "update t_cfg_xz set indx='"+indx+"' where type='"+type+"'";
					session.createSQLQuery(sql).executeUpdate();
					cx.setIndx(indx);
				}
//				else
//				{
//					message = "已有序号【"+indx+"】";
//				}
				cxdao.merge(cx);
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
