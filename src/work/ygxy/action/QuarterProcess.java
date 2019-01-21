package work.ygxy.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 计算季报表
 * @author htzx
 *
 */
public class QuarterProcess {

	private int year;
	private int quarter;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String execute() throws Exception
	{
		String sql = "";
		UserInfoDAO uidao = new UserInfoDAO();
		String bgdate = getBegindateFromYearAndQuarter(year,quarter);
		String eddate = getEnddateFromYearAndQuarter(year,quarter);
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		sql = "delete from y_day_quarter where year="+year+" and quarter="+quarter;
    		session.createSQLQuery(sql).executeUpdate();
    		List<UserInfo> list = uidao.findAllByChu("4");//员工响应
    		for(int i=0;i<list.size();i++)
    		{
    			UserInfo ui = list.get(i);
    			sql = "insert into y_day_quarter(year,quarter,name,position,gzsc,lxsc,zysc,gdl,ftclzsc,ftyddh,feclzsc,fejsl,steclzsc,stejsl) select "+year+","+quarter+",'"+ui.getUsername()+"','"+ui.getPosition()+"',sum(gzsc),sum(lxsc),sum(zysc),sum(gdl),sum(ft_pjclscd*ft_yddh),sum(ft_yddh),sum(fe_yjpjclscd*fe_drjsl),sum(fe_drjsl),sum(ste_ejpjclscd*ste_drjsl),sum(ste_drjsl) from y_day where name='"+ui.getUsername()+"' and date in (select b.date from t_mycalendar b where b.workday=1) and date>='"+bgdate+"' and date<='"+eddate+"'";
    			session.createSQLQuery(sql).executeUpdate();
    		}
    		//普通员工
    		sql = "update y_day_quarter set xyqqzsl=CAST(gdl/zysc AS DECIMAL(18,2)),ftpjclsc=CAST(ftclzsc/ftyddh AS DECIMAL(18,2)),fepjclsc=CAST(feclzsc/fejsl AS DECIMAL(18,2)),stepjclsc=CAST(steclzsc/stejsl AS DECIMAL(18,2)) where year="+year+" and quarter="+quarter;
			session.createSQLQuery(sql).executeUpdate();
			//管理 岗
			sql = "update y_day_quarter set xyqqzsl=0 where mid(position,4,1)!='0'";
			session.createSQLQuery(sql).executeUpdate();
			
			sql = "update y_day_quarter a set a.zjzf=(SELECT sum(b.fjdf) from y_zjmx as b where a.name=b.name),a.zjts=(SELECT count(b.fjdf) from y_zjmx as b where a.name=b.name) where a.year="+year+" and a.quarter="+quarter;
			session.createSQLQuery(sql).executeUpdate();
			sql = "update y_day_quarter set zjdf=CAST(zjzf/zjts AS DECIMAL(18,2)) where year="+year+" and quarter="+quarter;
			session.createSQLQuery(sql).executeUpdate();
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
	
	public String getBegindateFromYearAndQuarter(int year,int quarter)
	{
		StringBuffer result = new StringBuffer("");
		if(quarter==1)
		{
			year = year-1;
		}
		result.append(year);
		switch(quarter)
		{
			case 1:result.append("1201");break;
			case 2:result.append("0301");break;
			case 3:result.append("0601");break;
			case 4:result.append("0901");break;
		}
		return result.toString();
	}
	public String getEnddateFromYearAndQuarter(int year,int quarter)
	{
		StringBuffer result = new StringBuffer("");
		result.append(year);
		switch(quarter)
		{
			case 1:result.append("0229");break;
			case 2:result.append("0531");break;
			case 3:result.append("0831");break;
			case 4:result.append("1130");break;
		}
		return result.toString();
	}
}
