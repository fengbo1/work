package work.hn.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import work.hn.pojo.SummaryDaily;
import work.hn.pojo.SummaryExpress;
import work.internal.action.Operation;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;

public class ExpressSummary {

	private static Logger logger = Logger.getLogger(Operation.class);
	private String begindate;
	private String enddate;
	private String Path;
	
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public static Logger getLogger() {
		return logger;
	}
	public static void setLogger(Logger logger) {
		ExpressSummary.logger = logger;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public ExpressSummary() {
		//super(WbBaseAction.class);
		
		// TODO Auto-generated constructor stub
	}
	public String execute() throws Exception 
    {
		String filePath="";
		String result="success";
		String btime = begindate.replace("-", "");
		String etime = enddate.replace("-", "");
		ExportExcel<SummaryExpress> ex = new ExportExcel<SummaryExpress>();
		String[] headers = { "日期","事项","武汉891任务池(COS_T系统导出数据)","武汉891占比","895任务池(COS_T系统导出数据)", "武汉895占比", "小计(按实际生产人数统计)", "武汉小计占比",
				 "成都891任务池(COS_T系统导出数据)","成都891占比","成都895任务池(COS_T系统导出数据)", "成都895占比", "成都小计(按实际生产人数统计)", "成都小计占比",
				 "合计891任务池(COS_T系统导出数据)","合计895任务池(COS_T系统导出数据)","合计两任务池(实际生产值)"
		};
		List<SummaryExpress> dataset = findSummaryDailyReport(btime,etime);
		filePath=Tld.downloadpath+btime+"-"+etime+"huizhong.xls";
        Path = btime+"-"+etime+"huizhong.xls";
			try {
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("汇总数据表",headers, dataset, out);
				out.close();
			//	JOptionPane.showMessageDialog(null, "导出成功！");
				System.out.println("excel导出成功！");
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
			//	JOptionPane.showMessageDialog(null, "导出失败！请选择正确路径！");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return result;
    }
	
	/*查询行内数据表*/
	@SuppressWarnings("unchecked")
	public List<SummaryExpress> findSummaryDailyReport(String btime,String etime)
	{
		GeneralCheck check = new GeneralCheck();
		String sql="";
		Query query;
		List<SummaryDaily> list=new ArrayList<SummaryDaily>();
		List<SummaryExpress> resultlist=new ArrayList<SummaryExpress>();
    	Session session = HibernateSessionFactory.getSession();
    	SummaryDaily temp=new SummaryDaily();
    	Transaction trans = session.beginTransaction();
    	try {
    		sql="select * from t_daily_summary where date>='"+btime+"' and date<='"+etime+"' order by date,id";
			query = session.createSQLQuery(sql).addEntity(SummaryDaily.class);
			list=(List<SummaryDaily>) query.list();
			for(int i=0;i<list.size();i++)
			{
				SummaryExpress summary=new SummaryExpress();
				temp=list.get(i);
				if(i<40)
				{
					summary.setCd891(Tld.DoubleTo2(temp.getCd891()));
					summary.setCd891Zb(Tld.DoubleTo4((temp.getCd891Zb())));
					summary.setCd895(Tld.DoubleTo2(temp.getCd895()));
					summary.setCd895Zb(Tld.DoubleTo4(temp.getCd895Zb()));
					summary.setCdReal(Tld.DoubleTo2(temp.getCdReal()));
					summary.setCdRealZb(Tld.DoubleTo4(temp.getCdRealZb()));
					summary.setItemName(temp.getItemName());
					summary.setTotal891(Tld.DoubleTo2(temp.getTotal891()));
					summary.setTotal895(Tld.DoubleTo2(temp.getTotal895()));
					summary.setTotalReal(Tld.DoubleTo2(temp.getTotalReal()));
					summary.setWh891(Tld.DoubleTo2(temp.getWh891()));
					summary.setWh891Zb(Tld.DoubleTo4(temp.getWh891Zb()));
					summary.setWh895(Tld.DoubleTo2(temp.getWh895()));
					summary.setWh895Zb(Tld.DoubleTo4(temp.getWh895Zb()));
					summary.setWhReal(Tld.DoubleTo2(temp.getWhReal()));
					summary.setWhRealZb(Tld.DoubleTo4(temp.getWhRealZb()));
					summary.setDate(temp.getDate());
					resultlist.add(summary);
				}
				else
				{
					summary.setCd891(Tld.DoubleTo4(temp.getCd891()));
					summary.setCd891Zb(Tld.DoubleTo4((temp.getCd891Zb())));
					summary.setCd895(Tld.DoubleTo4(temp.getCd895()));
					summary.setCd895Zb(Tld.DoubleTo4(temp.getCd895Zb()));
					summary.setCdReal(Tld.DoubleTo4(temp.getCdReal()));
					summary.setCdRealZb(Tld.DoubleTo4(temp.getCdRealZb()));
					summary.setItemName(temp.getItemName());
					summary.setTotal891(Tld.DoubleTo4(temp.getTotal891()));
					summary.setTotal895(Tld.DoubleTo4(temp.getTotal895()));
					summary.setTotalReal(Tld.DoubleTo4(temp.getTotalReal()));
					summary.setWh891(Tld.DoubleTo4(temp.getWh891()));
					summary.setWh891Zb(Tld.DoubleTo4(temp.getWh891Zb()));
					summary.setWh895(Tld.DoubleTo4(temp.getWh895()));
					summary.setWh895Zb(Tld.DoubleTo4(temp.getWh895Zb()));
					summary.setWhReal(Tld.DoubleTo4(temp.getWhReal()));
					summary.setWhRealZb(Tld.DoubleTo4(temp.getWhRealZb()));
					summary.setDate(temp.getDate());
					resultlist.add(summary);
				}
				
			}
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
		//baselistcd.addAll(baselistwh);
		return resultlist;
	}
	
	public String hengToInteger(String input)
	{
		if(input.equals("-"))
		{
			return "0";
		}
		else
			return input;
	}
	public String hengToDouble(String input)
	{
		if(input.equals("-"))
		{
			return "0.0";
		}
		else
			return input;
	}

}
