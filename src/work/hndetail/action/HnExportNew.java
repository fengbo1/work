package work.hndetail.action;

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

import work.hn.dao.HnYcshDAO;
import work.hn.pojo.Hn891;
import work.hn.pojo.HnYcsh;
import work.hndetail.pojo.HnDetail;
import work.hndetail.pojo.HnDetailExpNew;
import work.hndetail.pojo.HnDetailExpress;
import work.hndetail.pojo.HnNew;
import work.hndetail.pojo.HnSimple;
import work.internal.action.Operation;
import work.no.action.NoUtil;
import work.no.dao.NoDAO;
import work.no.pojo.No;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class HnExportNew {
	private static Logger logger = Logger.getLogger(HnExportNew.class);
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
		HnExportNew.logger = logger;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String execute() throws Exception 
    {
		String filePath = "";
		String result="success";
		String time = begindate.replace("-", "");
		ExportExcel<HnDetailExpNew> ex = new ExportExcel<HnDetailExpNew>();
		String[] headers = { "序号","日期","是否达标","工号","姓名", "中心", "人员性质",
				"分组","产量","产量人民币","产量外汇","产量稽核","产量远程审核","产量建亚","产量反洗钱",
				"差错率","差错率人民币","差错率外汇","远程审核通过率","远程审核拒绝率","远程审核撤销率",
				"差错率建亚","效率","效率人民币","效率外汇","效率远程审核",
				"效率建亚","上线","上线人民币","上线外汇","上线稽核","上线远程审核",
				"上线建亚","上线反洗钱","日均产量","日均差错率","日均效率","来源"
		};
		List<HnDetailExpNew> dataset = findHnDtailReportNew(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath = Tld.downloadpath+time+"-"+enddate.replace("-", "")+"hangneiribao.xls";
        //filePath="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/work/derive/"+time+"-"+enddate.replace("-", "")+"zuoyezhibiaomingxibiao.xls";
        Path = time+"-"+enddate.replace("-", "")+"hangneiribao.xls";
        try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("操作员作业指标明细表",headers, dataset, out);
			out.flush();
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
	public List<HnDetailExpNew> findHnDtailReportNew(String bdate,String edate)
	{
		String sqlcd="";
		Query querycd;
		NoDAO nodao = new NoDAO();
		HnYcshDAO hydao = new HnYcshDAO();
		GeneralCheck check = new GeneralCheck();
		List<HnNew> list=new ArrayList<HnNew>();
		//List<HnDetail> baselistwh=new ArrayList<HnDetail>();
		List<HnDetailExpNew> listexp = new ArrayList<HnDetailExpNew>();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		sqlcd="select * from t_hn_new where date>='"+bdate+"' and date<='"+edate+"' order by date,zx,cl desc";
			querycd = session.createSQLQuery(sqlcd).addEntity(HnNew.class);
			list=(List<HnNew>) querycd.list();
			for(int i=0;i<list.size();i++)
			{
				HnDetailExpNew hde = new HnDetailExpNew();
				HnNew hd = list.get(i);
				//hn891中查询录入修改，检核修改任务量
				//HnSimple hs = getHn891Simple(session,hd.getTime(),hd.getNo());
				hde.setId(i+1);
				hde.setTime(hd.getDate());
				hde.setZyzl("");
				hde.setNo(hd.getNo());
				hde.setName(hd.getName());
				HnYcsh hy = hydao.findAllByDateAndName(hd.getDate(), hd.getName());
				
				hde.setZx(Tld.zxToString(hd.getZx()));
				hde.setXz(Tld.xzToString(hd.getXz()));
				hde.setTeam(Tld.positionToTeam(hd.getPos()));
				
				hde.setCl(hengToDouble(Tld.DoubleTo2(hd.getCl())));
				hde.setClrmb(hengToDouble(Tld.DoubleTo2(hd.getClrmb())));
				hde.setClwh(hengToDouble(Tld.DoubleTo2(hd.getClwh())));
				hde.setCljh(hengToDouble(Tld.DoubleTo2(hd.getCljh())));
				hde.setClsh(hengToDouble(Tld.DoubleTo2(hd.getClsh())));
				hde.setCljy(hengToDouble(Tld.DoubleTo2(hd.getCljy())));
				hde.setClfxq(hengToDouble(Tld.DoubleTo2(hd.getClfxq())));
				
				hde.setCcl(Tld.DoubleDownloadNew(hd.getCl(),hd.getCcl()));
				hde.setCclrmb(Tld.DoubleDownloadNew(hd.getClrmb(),hd.getCclrmb()));
				hde.setCclwh(Tld.DoubleDownloadNew(hd.getClwh(),hd.getCclwh()));
				hde.setShtgl(Tld.DoubleDownloadNew(hd.getClsh(),hd.getTglsh()));
				hde.setShjjl(Tld.DoubleDownloadNew(hd.getClsh(),hy.getJjl()));
				hde.setShcxl(Tld.DoubleDownloadNew(hd.getClsh(),hy.getCxl()));
				hde.setCcljy(Tld.DoubleDownloadNew(hd.getCljy(),hd.getCcljy()));
				
				hde.setXl(Tld.DoubleDownloadNew(hd.getCl(),hd.getXl()));
				hde.setXlrmb(Tld.DoubleDownloadNew(hd.getCl(),hd.getXlrmb()));
				hde.setXlwh(Tld.DoubleDownloadNew(hd.getCl(),hd.getXlwh()));
				//hde.setXljh(Tld.DoubleDownloadNew(hd.getCl(),hd.getXljh()));
				hde.setXlsh(Tld.DoubleDownloadNew(hd.getCl(),hd.getXlsh()));
				hde.setXljy(Tld.DoubleDownloadNew(hd.getCl(),hd.getXljy()));
				
				hde.setSx(String.valueOf(hd.getSx()));
				hde.setSxrmb(String.valueOf(hd.getSxrmb()));
				hde.setSxwh(String.valueOf(hd.getSxwh()));
				hde.setSxjh(String.valueOf(hd.getSxjh()));
				hde.setSxsh(String.valueOf(hd.getSxsh()));
				hde.setSxjy(String.valueOf(hd.getSxjy()));
				hde.setSxfxq(String.valueOf(hd.getSxfxq()));
				
				hde.setRjcl(hengToDouble(Tld.DoubleTo2(hd.getRjcl())));
				hde.setRjccl(Tld.DoubleDownloadNew(hd.getRjcl(),hd.getRjccl()));
				hde.setRjxl(Tld.DoubleDownloadNew(hd.getSx(),hd.getRjxl()));
				if(!nodao.findBy891No(hd.getNo()).isEmpty())
				{
					No no = (No) nodao.findBy891No(hd.getNo()).get(0);
					hde.setSource(no.getSource());
				}
				listexp.add(hde);
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
		return listexp;
		 
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
			return "0";
		}
		else
			return input;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getBegindate() {
		return begindate;
	}
}
