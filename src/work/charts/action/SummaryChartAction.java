package work.charts.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import work.control.dao.UserCfgDAO;
import work.control.pojo.NameValueBean;
import work.control.pojo.UserCfg;

/**
 * 刷新页面用的
 * @author htzx
 *
 */
public class SummaryChartAction {
	private static Logger logger = Logger.getLogger(SummaryChartAction.class);
	private String btime;
	private String etime;
	private String part;
	private List<NameValueBean> listnv;
	private String key;
	private String xz;
	private String zx;
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
	public List<NameValueBean> getListnv() {
		return listnv;
	}
	public void setListnv(List<NameValueBean> listnv) {
		this.listnv = listnv;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getXz() {
		return xz;
	}
	public void setXz(String xz) {
		this.xz = xz;
	}
	public String getZx() {
		return zx;
	}
	public void setZx(String zx) {
		this.zx = zx;
	}
	public String execute() throws Exception
	{
		
		UserCfgDAO ucdao = new UserCfgDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		listnv = ucdao.findAllByTypeAndName("charts",part);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		trans.rollback();
    		e.printStackTrace();
    		logger.error(e);
    	}finally{
    		trans.commit();
            session.flush();
            session.clear();
            session.close();
    	}
		return "success";
	}
}
