package work.charts.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.UserCfgDAO;
import work.control.pojo.NameValueBean;
import ccb.hibernate.HibernateSessionFactory;

public class SummaryAjax {

	private String part;
	private String type;
	private String name;
	private String key;
	private List<NameValueBean> listnv;
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public List<NameValueBean> getListnv() {
		return listnv;
	}
	public void setListnv(List<NameValueBean> listnv) {
		this.listnv = listnv;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String execute() throws Exception
	{
		name = "";
		UserCfgDAO ucdao = new UserCfgDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		if(type.equals("chu")||type.equals("chartchu"))
    		{
    			listnv = ucdao.findIndexByTypeAndNum("chu",part);
    		}
    		else
    		{
    			listnv = ucdao.findAllByTypeAndName(type,part);
    		}
    		if(type.equals("chu"))//人员信息修改中chu
    		{
    			key="key";
    			name="";
    		}
    		else if(type.equals("chartchu"))//图表展示中chu
    		{
    			key="team";
    			name="小组";
    		}
    		else
    		{
    			key="key";
    			name="业务指标";
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
