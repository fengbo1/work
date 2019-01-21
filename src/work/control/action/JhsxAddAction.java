package work.control.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import work.control.dao.JhsxDAO;
import work.control.pojo.Jhsx;

public class JhsxAddAction {

	private String date;
	private int cdjh;
	private int whjh;
	private String operator;
	private String message;
	
	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getCdjh() {
		return cdjh;
	}



	public void setCdjh(int cdjh) {
		this.cdjh = cdjh;
	}



	public String getOperator() {
		return operator;
	}



	public void setOperator(String operator) {
		this.operator = operator;
	}

	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}


	public int getWhjh() {
		return whjh;
	}



	public void setWhjh(int whjh) {
		this.whjh = whjh;
	}



	public String execute() throws Exception
	{
		JhsxDAO dao = new JhsxDAO();
		Jhsx jhsx = new Jhsx();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			List<Jhsx> list = dao.findByDate(date.replace("-", ""));
//			if(list.isEmpty())
//			{
//				jhsx.setDate(date.replace("-", ""));
//				jhsx.setOperator(operator);
//				jhsx.setCdjh(cdjh);
//				jhsx.setWhjh(whjh);
//				dao.merge(jhsx);
//			}
//			else
//			{
//				jhsx = (Jhsx) dao.findByDate(date.replace("-", "")).get(0);
//				jhsx.setOperator(operator);
//				jhsx.setCdjh(cdjh);
//				jhsx.setWhjh(whjh);
//				dao.merge(jhsx);
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		message="操作成功，请返回";
		return "success";
	}
}
