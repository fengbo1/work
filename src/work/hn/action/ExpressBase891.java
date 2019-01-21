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

import ccb.hibernate.HibernateSessionFactory;

import work.hn.pojo.Hn891;
import work.hn.pojo.Hn891Express;
import work.internal.action.Operation;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;

public class ExpressBase891 {

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
		ExpressBase891.logger = logger;
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
	public ExpressBase891() {
		//super(WbBaseAction.class);
		
		// TODO Auto-generated constructor stub
	}
	public String execute() throws Exception 
    {
		String filePath="";
		String result="success";
		String btime = begindate.replace("-", "");
		String etime = enddate.replace("-", "");
		ExportExcel<Hn891Express> ex = new ExportExcel<Hn891Express>();
		String[] headers = { "序号","时间","工号", "姓名", "折合产量", "差错率","查询量",
				"查询率","版面识别任务量","影像拆分任务量","录入修改任务量","录入修改授权任务量",
				"检核修改任务量","检核修改授权任务量","失败原因分析任务量","单位账户影像标注任务量","初审录入任务量",
				"专业复审任务量","版面识别效率","影像拆分效率","录入修改效率","录入授权效率",
				"检核修改效率","检核授权效率","失败原因分析效率","单位账户影像标注效率","初审录入效率",
				"专业复审效率","录入修改差错量","检核修改差错量","录入修改差错率",
				"检核修改差错率","退票量","退票率","所在中心","人员性质","业务总量","效率总量"
		};
		List<Hn891Express> dataset = findHn891ExpressReport(btime,etime);
		filePath=Tld.downloadpath+btime+"-"+etime+"jichushuju891.xls";
        Path = btime+"-"+etime+"jichushuju891.xls";
			try {
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("891基础数据",headers, dataset, out);
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
	public List<Hn891Express> findHn891ExpressReport(String btime,String etime)
	{
		GeneralCheck check = new GeneralCheck();
		String sql="";
		Query query;
		List<Hn891> list=new ArrayList<Hn891>();
		List<Hn891Express> baselist = new ArrayList<Hn891Express>();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		sql="select * from hn891 where time>='"+btime+"' and time<='"+etime+"' order by time, zhcl desc";
			query = session.createSQLQuery(sql).addEntity(Hn891.class);
			list=(List<Hn891>) query.list();
			for(int i=0;i<list.size();i++)
			{
				Hn891Express he = new Hn891Express();
				Hn891 h = list.get(i);
				he.setId(i+1);
				he.setTime(h.getTime());
				he.setNo(h.getNo());
				he.setName(h.getName());
				he.setZhcl(hengToDouble(Tld.DoubleTo0(h.getZhcl())));
				he.setCx(Tld.IntegerDownloadNew(h.getYwl(),h.getCx()));
				he.setCcl(Tld.DoubleDownloadNew(check.IsNullInteger(h.getLrxg())+check.IsNullInteger(h.getJhxg()),h.getCcl()));
				he.setCxl(Tld.DoubleDownloadNew(h.getYwl(),h.getCxl()));
				he.setBmsb(hengToInteger(Tld.IntegerToString(h.getBmsb())));
				he.setYxcf(hengToInteger(Tld.IntegerToString(h.getYxcf())));
				he.setLrxg(hengToInteger(Tld.IntegerToString(h.getLrxg())));
				he.setLrsq(hengToInteger(Tld.IntegerToString(h.getLrsq())));
				he.setJhxg(hengToInteger(Tld.IntegerToString(h.getJhxg())));
				he.setJhsq(hengToInteger(Tld.IntegerToString(h.getJhsq())));
				he.setSbyy(hengToInteger(Tld.IntegerToString(h.getSbyy())));
				he.setYxbz(hengToInteger(Tld.IntegerToString(h.getYxbz())));
				he.setCslr(hengToInteger(Tld.IntegerToString(h.getCslr())));
				he.setZyfs(hengToInteger(Tld.IntegerToString(h.getZyfs())));
				he.setYwl(hengToInteger(Tld.IntegerToString(h.getYwl())));
				he.setXlBmsb(hengToDouble(Tld.DoubleTo2(h.getXlBmsb())));
				he.setXlYxcf(hengToDouble(Tld.DoubleTo2(h.getXlYxcf())));
				he.setXlLrxg(hengToDouble(Tld.DoubleTo2(h.getXlLrxg())));
				he.setXlLrsq(hengToDouble(Tld.DoubleTo2(h.getXlLrsq())));
				he.setXlJhxg(hengToDouble(Tld.DoubleTo2(h.getXlJhxg())));
				he.setXlJhsq(hengToDouble(Tld.DoubleTo2(h.getXlJhsq())));
				he.setXlCslr(hengToDouble(Tld.DoubleTo2(h.getXlCslr())));
				he.setXlYxbz(hengToDouble(Tld.DoubleTo2(h.getXlYxbz())));
				he.setXlSbyy(hengToDouble(Tld.DoubleTo2(h.getXlSbyy())));
				he.setXlZyfs(hengToDouble(Tld.DoubleTo2(h.getXlZyfs())));
				he.setSumxl(hengToInteger(Tld.DoubleTo2(h.getSumxl())));
				he.setLrcc(Tld.IntegerDownloadNew(h.getLrxg(),h.getLrcc()));
				he.setJhcc(Tld.IntegerDownloadNew(h.getJhxg(),h.getJhcc()));
				he.setLrccl(Tld.DoubleDownloadNew(h.getLrxg(),h.getLrccl()));
				he.setJhccl(Tld.DoubleDownloadNew(h.getJhxg(),h.getJhccl()));
				he.setLrtp(Tld.IntegerDownloadNew(h.getYwl(),h.getLrtp()));
				he.setLrtpl(Tld.DoubleDownloadNew(h.getYwl(),h.getLrtpl()));
				he.setZx(Tld.zxToString(h.getZx()));
				he.setXz(Tld.xzToString(h.getXz()));
				baselist.add(he);
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
		return baselist;
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
