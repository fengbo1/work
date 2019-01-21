package work.charts.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import work.control.dao.UserCfgDAO;
import work.control.pojo.NameValueBean;
/**
 * 
 * @author htzx
 * 行内环节业务量趋势图
 *
 */
public class DetailJspAction {
	private String btime;
	private String etime;
	private String part;
	private String key;
	private List<NameValueBean> listnv;
	private String name;
	private String name1;
	private int zhuan;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZhuan() {
		return zhuan;
	}
	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}
	public List<NameValueBean> getListnv() {
		return listnv;
	}
	public void setListnv(List<NameValueBean> listnv) {
		this.listnv = listnv;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String execute() throws Exception
	{
		UserCfgDAO ucdao = new UserCfgDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		listnv = ucdao.findAllByTypeAndName("chartp",part);
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
		if(zhuan==1)
		{
			name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		}
		return "success";
	}
}