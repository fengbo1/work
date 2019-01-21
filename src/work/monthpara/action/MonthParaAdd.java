package work.monthpara.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.hndetail.dao.HnDetailDAO;
import work.monthpara.dao.MonthParaDAO;
import work.monthpara.dao.ParaLogDAO;
import work.monthpara.pojo.MonthPara;
import work.monthpara.pojo.ParaLog;
import work.util.YearSeason;
import ccb.hibernate.HibernateSessionFactory;

public class MonthParaAdd {

	private String month;
	private Double hnCl;
	private Double hnZl;
	private Double wbCl;
	private Double TBz;
	private Double clYj;
	private Double zlYj;
	private Double xlYj;
	private String username;
	private String no891;
	private String message;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Double getHnCl() {
		return hnCl;
	}
	public void setHnCl(Double hnCl) {
		this.hnCl = hnCl;
	}
	public Double getHnZl() {
		return hnZl;
	}
	public void setHnZl(Double hnZl) {
		this.hnZl = hnZl;
	}
	public Double getWbCl() {
		return wbCl;
	}
	public void setWbCl(Double wbCl) {
		this.wbCl = wbCl;
	}
	public Double getTBz() {
		return TBz;
	}
	public void setTBz(Double tBz) {
		TBz = tBz;
	}
	public Double getClYj() {
		return clYj;
	}
	public void setClYj(Double clYj) {
		this.clYj = clYj;
	}
	public Double getZlYj() {
		return zlYj;
	}
	public void setZlYj(Double zlYj) {
		this.zlYj = zlYj;
	}
	public Double getXlYj() {
		return xlYj;
	}
	public void setXlYj(Double xlYj) {
		this.xlYj = xlYj;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNo891() {
		return no891;
	}
	public void setNo891(String no891) {
		this.no891 = no891;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		YearSeason ys = new YearSeason();
		MonthParaDAO mpdao = new MonthParaDAO();
		ParaLogDAO pldao = new ParaLogDAO();
		ParaLog pl = new ParaLog();
		MonthPara mp = new MonthPara();
		HnDetailDAO hddao = new HnDetailDAO();
		mp.setMonth(month);
		mp.setHnCl(hnCl);
		mp.setHnZl(hnZl);
		mp.setWbCl(wbCl);
		mp.setTBz(TBz);
		mp.setClYj(clYj);
		mp.setZlYj(zlYj);
		mp.setXlYj(xlYj);
		pl.setMonth(month);
		pl.setType(0);
		pl.setPara("新增参数");
		pl.setOperator(username);
		pl.setTime(ys.getDateTime());
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			mpdao.save(mp);
			pldao.save(pl);
			hddao.updateWclByMonth(session,hnCl,month);
			message="";
		}catch (Exception e) {
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
