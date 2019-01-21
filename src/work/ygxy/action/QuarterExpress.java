package work.ygxy.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.util.ExportExcel;
import work.util.Tld;
import work.ygxy.pojo.QuarterBean;
import work.ygxy.pojo.Ygxy;
import work.ygxy.pojo.YgxyBean;
import work.ygxy.pojo.YgxyQuarter;
import ccb.hibernate.HibernateSessionFactory;

public class QuarterExpress {

	private String Path;
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

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String execute() throws Exception{
		String filePath = "";
		filePath=Tld.downloadpath+"ygxyjibaobiao.xls";
		return express(filePath);
	}
	
	public String express(String filePath) throws UnsupportedEncodingException
	{
		List<YgxyQuarter> list = new ArrayList<YgxyQuarter>();
		ExportExcel<QuarterBean> ex = new ExportExcel<QuarterBean>();
		String[] headers = { "年","季度","姓名","职务"
				,"季度工作总时长","季度离线总时长","实际作业总时长"
				,"季度工单折算总量","响应请求折算量"
				,"一级响应热线电话处理总时长","一级响应应答电话总量","一级响应热线电话平均处理时长"
				,"一级响应电子工单处理总时长","一级响应电子工单经手总量","一级响应电子工单平均处理时长"
				,"二级工单处理总时长","二级工单经手总量","二级工单平均处理时长","质检总分","质检条数","质检得分"
		};
        
        Path = "ygxyjibaobiao.xls";
       //数据库条件查询
		
		Query query;
		String hql = "from YgxyQuarter as yq where yq.year="+year+" and yq.quarter="+quarter;
		System.out.println(hql);
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		//list转存
		List<QuarterBean> listyq = new ArrayList<QuarterBean>();
		for(int i=0;i<list.size();i++)
		{
			QuarterBean yb = new QuarterBean();
			YgxyQuarter yq = list.get(i);
			yb.setYear(yq.getYear());
			yb.setQuarter(yq.getQuarter());
			yb.setName(yq.getName());
			yb.setPosition(yq.getPosition());
			yb.setGzsc(yq.getGzsc());
			yb.setLxsc(yq.getLxsc());
			yb.setZysc(yq.getZysc());
			yb.setGdl(yq.getGdl());
			yb.setXyqqzsl(yq.getXyqqzsl());
			yb.setFtclzsc(yq.getFtclzsc());
			yb.setFtyddh(yq.getFtyddh());
			yb.setFtpjclsc(yq.getFtpjclsc());
			yb.setFeclzsc(yq.getFeclzsc());
			yb.setFejsl(yq.getFejsl());
			yb.setFepjclsc(yq.getFepjclsc());
			yb.setSteclzsc(yq.getSteclzsc());
			yb.setStejsl(yq.getStejsl());
			yb.setStepjclsc(yq.getStepjclsc());
			yb.setZjzf(yq.getZjzf());
			yb.setZjts(yq.getZjts());
			yb.setZjdf(yq.getZjdf());
			listyq.add(yb);
		}
		//导出
		 try {
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("员工响应个人明细季报表",headers, listyq, out);
				out.close();
				System.out.println("excel导出成功！");
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return "success";
	}
}
