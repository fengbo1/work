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

import work.hn.pojo.Summary;

import work.hn.pojo.SummarySimpleE;
import work.internal.action.Operation;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;

public class ExpressSimple {

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
		ExpressSimple.logger = logger;
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
	public ExpressSimple() {
		//super(WbBaseAction.class);
		
		// TODO Auto-generated constructor stub
	}
	public String execute() throws Exception 
    {
		String filePath="";
		String result="success";
		String btime = begindate.replace("-", "");
		String etime = enddate.replace("-", "");
		ExportExcel<SummarySimpleE> ex = new ExportExcel<SummarySimpleE>();
		String[] headers = {"日期","机构","类型","当月日均产量","当日平均产量","当日人民币平均产量","当日外汇平均产量",
				"当日稽核平均产量","当日远程审核平均产量","当日建亚平均产量", "当月日均差错率","当日作业差错率",
				"当月日均退票率","当日业务退票率","当月查询查复率","当日查询查复率","当月转网点率", "当日转网点率",};
		List<SummarySimpleE> dataset = findSummarySimpleReport(btime,etime);
		filePath=Tld.downloadpath+btime+"-"+etime+"simple.xls";
        Path = btime+"-"+etime+"simple.xls";
			try {
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("汇总简报表",headers, dataset, out);
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
	public List<SummarySimpleE> findSummarySimpleReport(String btime,String etime)
	{
		GeneralCheck check = new GeneralCheck();
		String sql="";
		Query query;
		List<Summary> list=new ArrayList<Summary>();
		List<SummarySimpleE> resultlist=new ArrayList<SummarySimpleE>();
    	Session session = HibernateSessionFactory.getSession();
    	Summary temp=new Summary();
    	Transaction trans = session.beginTransaction();
    	try {
    		sql="select * from t_summary where date>='"+btime+"' and date<='"+etime+"' order by date,id";
			query = session.createSQLQuery(sql).addEntity(Summary.class);
			list=(List<Summary>) query.list();
			for(int i=0;i<list.size();i++)
			{
				SummarySimpleE summary=new SummarySimpleE();
				temp=list.get(i);
				summary.setDate(temp.getDate());
				summary.setJg(temp.getJg());
				summary.setType(temp.getType());
				summary.setClDay(temp.getClDay());
				summary.setClDayRmb(temp.getClDayRmb());
				summary.setClDayWh(temp.getClDayWh());
				summary.setClDayJh(temp.getClDayJh());
				summary.setClDaySh(temp.getClDaySh());
				summary.setClDayJy(temp.getClDayJy());
				summary.setClAver(temp.getClAver());
				summary.setZycclDay(temp.getZycclDay());
				summary.setZycclAver(temp.getZycclAver());
				summary.setZytplDay(temp.getZytplDay());
				summary.setZytplAver(temp.getZytplAver());
				summary.setZycxlDay(temp.getZycxlDay());
				summary.setZycxlAver(temp.getZycxlAver());
				summary.setZwd(temp.getZwd());
				summary.setLjzwd(temp.getLjzwd());
				resultlist.add(summary);
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
