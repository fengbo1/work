package work.charts.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ccb.hibernate.HibernateSessionFactory;

import work.control.dao.UserCfgDAO;
import work.control.pojo.CfgXz;
import work.control.pojo.NameValueBean;
import work.hn.dao.SummaryDailyDAO;

public class TeamJspAction {

	private String btime;
	private String etime;
	private String chu;
	private String team;
	private String part;
	private String key;
	private int qz1;
	private int qz2;
	private List<NameValueBean> listnvc;
	private List<NameValueBean> listnvk;
	private List<NameValueBean> listqz;
	private static final Logger logger = LoggerFactory.getLogger(SummaryDailyDAO.class);

	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getQz1() {
		return qz1;
	}
	public void setQz1(int qz1) {
		this.qz1 = qz1;
	}
	public int getQz2() {
		return qz2;
	}
	public void setQz2(int qz2) {
		this.qz2 = qz2;
	}
	public List<NameValueBean> getListnvc() {
		return listnvc;
	}
	public void setListnvc(List<NameValueBean> listnvc) {
		this.listnvc = listnvc;
	}
	public List<NameValueBean> getListnvk() {
		return listnvk;
	}
	public void setListnvk(List<NameValueBean> listnvk) {
		this.listnvk = listnvk;
	}
	public List<NameValueBean> getListqz() {
		return listqz;
	}
	public void setListqz(List<NameValueBean> listqz) {
		this.listqz = listqz;
	}
	public String execute() throws Exception
	{
		UserCfgDAO ucdao = new UserCfgDAO();
		listqz = new ArrayList<NameValueBean>();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		if(chu==null||!chu.equals("2")&&!chu.equals("3")&&!chu.equals("6"))
    		{
    			chu="3";
    		}
    		listnvc = ucdao.findIndexByTypeAndNum("chu",chu);
    		listnvk = ucdao.findAllByTypeAndName("chartt",part);
    		
    		String sql = "select * from t_cfg_xz where indx='0'";
			List<CfgXz> listcxqz = session.createSQLQuery(sql).addEntity(CfgXz.class).list();
			for(int i=0;i<listcxqz.size();i++)
			{
				CfgXz cx = listcxqz.get(i);
				NameValueBean nvb = new NameValueBean();
				nvb.setName(cx.getContent());
				nvb.setValue(cx.getCnum());
				listqz.add(nvb);
			}
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		trans.rollback();
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
