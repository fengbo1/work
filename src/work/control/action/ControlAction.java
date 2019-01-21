package work.control.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.ControlDAO;
import work.control.pojo.Control;

import ccb.hibernate.HibernateSessionFactory;

public class ControlAction {
	
	private Control control;
	
	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public String execute() throws Exception
	{
		ControlDAO cdao = new ControlDAO();
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
	     
	    try {
	    	 control = (Control) cdao.findAll().get(0); 
	      } catch (RuntimeException re) {
	         throw re;
	      }finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	      return "success";
	}

}
