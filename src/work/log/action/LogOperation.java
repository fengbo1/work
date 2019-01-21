package work.log.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ccb.hibernate.HibernateSessionFactory;
import work.log.dao.WorkLogDAO;
import work.log.pojo.WorkLog;
import work.util.YearSeason;

public class LogOperation extends ActionSupport implements ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setServletResponse(HttpServletResponse response)
    {
    }
	
	public String addLog(String name,String operate,String detail)
	{
		YearSeason ys = new YearSeason();
		WorkLogDAO wldao = new WorkLogDAO();
		String ip = (String) ActionContext.getContext().getSession().get("IP");
		WorkLog wl = new WorkLog(ys.getDateTime(), name, ip, operate, detail, "", "", "", "", "");
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		wldao.save(session, wl);
		trans.commit();
        session.flush();
        session.clear();
        session.close();
		return "success";
	}
}
