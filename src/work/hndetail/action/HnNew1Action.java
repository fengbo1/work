package work.hndetail.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import work.control.dao.CfgXzDAO;
import work.control.pojo.CfgXz;
import work.control.pojo.CfgXzBean;
import work.control.pojo.NameValueBean;
import work.util.Tld;

public class HnNew1Action {

	private String choice;
	private List<NameValueBean> listqz;
	private List<CfgXzBean> listcxb;
	private List<NameValueBean> part;
	
	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public List<NameValueBean> getListqz() {
		return listqz;
	}

	public void setListqz(List<NameValueBean> listqz) {
		this.listqz = listqz;
	}

	public List<CfgXzBean> getListcxb() {
		return listcxb;
	}

	public void setListcxb(List<CfgXzBean> listcxb) {
		this.listcxb = listcxb;
	}

	public List<NameValueBean> getPart() {
		return part;
	}

	public void setPart(List<NameValueBean> part) {
		this.part = part;
	}

	public String execute() throws Exception
	{
		choice = "";
		String sql = "";
		CfgXzDAO cxdao = new CfgXzDAO();
		part = new ArrayList<NameValueBean>();
		for(int i=0;i<Tld.PARTC.length;i++)
		{
			NameValueBean nvb = new NameValueBean();
			nvb.setName(Tld.PARTC[i]);
			nvb.setValue(Tld.PARTE[i]);
			part.add(nvb);
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			listqz = new ArrayList<NameValueBean>();
			sql = "select * from t_cfg_xz where indx='0'";
			List<CfgXz> listcxqz = session.createSQLQuery(sql).addEntity(CfgXz.class).list();
			for(int i=0;i<listcxqz.size();i++)
			{
				CfgXz cx = listcxqz.get(i);
				NameValueBean nvb = new NameValueBean();
				nvb.setName(cx.getContent());
				nvb.setValue(cx.getCnum());
				listqz.add(nvb);
			}
			
			listcxb = new ArrayList<CfgXzBean>();
			sql = "select distinct(type) from t_cfg_xz where indx>0 order by indx";
			List<String> liststr = session.createSQLQuery(sql).list();
			for(int i=0;i<liststr.size();i++)
			{
				CfgXzBean cxb = new CfgXzBean();
				List<CfgXz> listcxtemp = new ArrayList<CfgXz>();
				String name = liststr.get(i);
				sql = "select * from t_cfg_xz where type='"+name+"'";
				List<CfgXz> listcx = session.createSQLQuery(sql).addEntity(CfgXz.class).list();
				for(int j=0;j<listcx.size();j++)
				{
					CfgXz cxtemp = new CfgXz();
					
					CfgXz cx = listcx.get(j);
					cxtemp.setCnum(cx.getCnum());
					cxtemp.setContent(cx.getContent());
					listcxtemp.add(cxtemp);
					cxb.setTnum(cx.getTnum());
				}
				cxb.setTid("choice"+cxb.getTnum());
				cxb.setType(name);
				cxb.setContents(listcxtemp);
				listcxb.add(cxb);
				
				choice+=cxb.getTid();
				choice+=",";
			}
			if(choice.length()>1)
			{
				choice = choice.substring(0, choice.length()-1);
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
