package work.control.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.ControlDAO;
import work.control.pojo.Control;
import work.monthpara.dao.ParaLogDAO;
import work.monthpara.pojo.ParaLog;
import work.util.YearSeason;

import ccb.hibernate.HibernateSessionFactory;

public class ControlUpdate {

	private double zlYj;
	private double clZbLow;
	private double clZbHigh;
	
	public double getZlYj() {
		return zlYj;
	}
	public void setZlYj(double zlYj) {
		this.zlYj = zlYj;
	}
	public double getClZbLow() {
		return clZbLow;
	}
	public void setClZbLow(double clZbLow) {
		this.clZbLow = clZbLow;
	}
	public double getClZbHigh() {
		return clZbHigh;
	}
	public void setClZbHigh(double clZbHigh) {
		this.clZbHigh = clZbHigh;
	}
	
	public String execute() throws Exception
	{
		ControlDAO cdao = new ControlDAO();
		YearSeason ys = new YearSeason();
		ParaLogDAO pldao = new ParaLogDAO();
		Session session = HibernateSessionFactory.getSession();
        Transaction trans=session.beginTransaction();
        try {
        	 Control control = (Control) cdao.findAll().get(0);
        	 if(zlYj!=control.getZlYj())
        	 {
        		 ParaLog pl = new ParaLog("", 0, "作业质量", String.valueOf(control.getZlYj()), String.valueOf(zlYj), "", ys.getDateTime(), "", "", "");
        		 pldao.save(pl);
        	 }
        	 control.setZlYj(zlYj);
        	 if(clZbLow!=control.getClZbLow())
        	 {
        		 ParaLog pl = new ParaLog("", 0, "产量指标（低）", String.valueOf(control.getClZbLow()), String.valueOf(clZbLow), "", ys.getDateTime(), "", "", "");
        		 pldao.save(pl);
        	 }
        	 control.setClZbLow(clZbLow);
        	 if(clZbHigh!=control.getClZbHigh())
        	 {
        		 ParaLog pl = new ParaLog("", 0, "产量指标（高）", String.valueOf(control.getClZbHigh()), String.valueOf(clZbHigh), "", ys.getDateTime(), "", "", "");
        		 pldao.save(pl);
        	 }
        	 control.setClZbHigh(clZbHigh);
        	 cdao.merge(control);
			 return "success";
	      } catch (RuntimeException re) {
	         throw re;
	      }finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}
}
