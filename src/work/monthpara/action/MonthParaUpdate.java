package work.monthpara.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.hndetail.dao.HnDetailDAO;
import work.hndetail.pojo.HnDetail;
import work.monthpara.dao.MonthParaDAO;
import work.monthpara.dao.ParaLogDAO;
import work.monthpara.pojo.MonthPara;
import work.monthpara.pojo.ParaLog;
import work.util.GeneralCheck;
import work.util.YearSeason;
import ccb.hibernate.HibernateSessionFactory;

public class MonthParaUpdate {
	private int id;
	private String month;
	private Double hnCl;
	private Double hnZl;
	private Double wbCl;
	private Double TBz;
	private Double clYj;
	private Double zlYj;
	private Double xlYj;
	private String username;
	private String message;
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}



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



	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public String execute() throws Exception
	{
		MonthParaDAO mpdao = new MonthParaDAO();
		YearSeason ys = new YearSeason();
		MonthPara mp = new MonthPara();
		MonthPara mpold = (MonthPara) mpdao.findByMonth(month).get(0);
		ParaLogDAO pldao = new ParaLogDAO();
		HnDetailDAO hddao = new HnDetailDAO();
		//String sql = "select * from t_para_log where='"+id+
		mp.setId(id);
		mp.setMonth(month);
		mp.setHnCl(hnCl);
		mp.setHnZl(hnZl);
		mp.setWbCl(wbCl);
		mp.setTBz(TBz);
		mp.setClYj(clYj);
		mp.setZlYj(zlYj);
		mp.setXlYj(xlYj);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			
			if(mpold.getHnCl().doubleValue()!=hnCl)
			{
				ParaLog pl = new ParaLog();
				pl.setMonth(month);
				pl.setOperator(username);
				pl.setPara("行内产量");
				pl.setBef(String.valueOf(mpold.getHnCl()));
				pl.setAft(String.valueOf(hnCl));
				pl.setTime(ys.getDateTime());
				pldao.save(pl);
				hddao.updateWclByMonth(session, hnCl, month);
			}
			if(mpold.getHnZl().doubleValue()!=hnZl)
			{
				ParaLog pl = new ParaLog();
				pl.setMonth(month);
				pl.setOperator(username);
				pl.setPara("行内质量");
				pl.setBef(String.valueOf(mpold.getHnZl()));
				pl.setAft(String.valueOf(hnZl));
				pl.setTime(ys.getDateTime());
				pldao.save(pl);
				updateZyzl(mpdao,session,month,hnZl);
			}
			if(mpold.getWbCl()!=null&&mpold.getWbCl().doubleValue()!=wbCl)
			{
				ParaLog pl = new ParaLog();
				pl.setMonth(month);
				pl.setOperator(username);
				pl.setPara("外包产量");
				pl.setBef(String.valueOf(mpold.getWbCl()));
				pl.setAft(String.valueOf(wbCl));
				pl.setTime(ys.getDateTime());
				pldao.save(pl);
			}
			if(mpold.getTBz()!=null&&mpold.getTBz().doubleValue()!=TBz)
			{
				ParaLog pl = new ParaLog();
				pl.setMonth(month);
				pl.setOperator(username);
				pl.setPara("外包质量");
				pl.setBef(String.valueOf(mpold.getTBz()));
				pl.setAft(String.valueOf(TBz));
				pl.setTime(ys.getDateTime());
				pldao.save(pl);
			}
			mpdao.merge(mp);
			message="修改成功";
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
	
	public String updateZyzl(MonthParaDAO mpdao,Session session,String month,Double hnzl)
	{
		HnDetailDAO hddao = new HnDetailDAO();
		GeneralCheck check = new GeneralCheck();
		Double hncl = mpdao.findHnclByMonth(Integer.parseInt(month));
		String bdate = month+"01";
		String edate = month+"31";
		String sql = "select * from t_hn_detail where time>='"+bdate+"' and time<='"+edate+"' and xz =0";//
		List<HnDetail> listhdupdate = (List<HnDetail>)session.createSQLQuery(sql).addEntity(HnDetail.class).list();
		for(int i=0;i<listhdupdate.size();i++)
		{
			HnDetail hd = listhdupdate.get(i);
			int flag = 1;
			if(check.IsNullInteger(hd.getLjlr())>0&&hd.getLjsxts()>0&&hd.getRjccl891()!=null&&hd.getRjccl891()<=hnzl)
			{
				flag+=1;
			}
			if(hd.getLjrjcl()>=hncl)
			{
				flag+=1;
			}
			if(hd.getLjsxts()==0)
			{
				flag=-1;
			}
			hd.setZyzl(flag);
			hddao.merge(hd);
		}
		
		return "success";
	}
}



















