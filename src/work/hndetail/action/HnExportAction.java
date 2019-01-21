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

import work.hn.pojo.Hn891;
import work.hndetail.dao.HnDetailDAO;
import work.hndetail.pojo.HnDetail;
import work.hndetail.pojo.HnDetailExpress;
import work.hndetail.pojo.HnSimple;
import work.internal.action.Operation;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;

public class HnExportAction {
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
		HnExportAction.logger = logger;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public HnExportAction() {
		//super(WbBaseAction.class);
		
		// TODO Auto-generated constructor stub
	}
	public String execute() throws Exception 
    {
		String filePath = "";
		String result="success";
		String time = begindate.replace("-", "");
		ExportExcel<HnDetailExpress> ex = new ExportExcel<HnDetailExpress>();
		String[] headers = { "序号","日期","是否达标","工号","姓名", "中心", "人员性质",
				"分组","891折合产量","895折合产量","折合产量","单位产能作业时间","作业差错率","891差错率"
				,"891查询率","891退票率","895差错率","895查询率","895退票率","日均折合产量","日均产量完成率",
				"累计折合产量","891日均差错率","891日均查询率","891日均退票率","895日均差错率","895日均查询率",
				"895日均退票率","电子渠道录入修改任务量","电子渠道录入修改转网点量","电子渠道累计录入修改任务量"
				,"电子渠道累计录入修改转网点量","电子渠道转网点率","电子渠道日均转网点率","累计上线天数","累计录入差错","累计检核差错"
				,"当日上线标志"
		};
		List<HnDetailExpress> dataset = findHnDtailReport(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath = Tld.downloadpath+time+"-"+enddate.replace("-", "")+"hangneigerenmingxiribaobiao.xls";
        //filePath="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/work/derive/"+time+"-"+enddate.replace("-", "")+"zuoyezhibiaomingxibiao.xls";
        Path = time+"-"+enddate.replace("-", "")+"hangneigerenmingxiribaobiao.xls";
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
	public List<HnDetailExpress> findHnDtailReport(String btime,String etime)
	{
		String sqlcd="";
		Query querycd;
		GeneralCheck check = new GeneralCheck();
		List<HnDetail> baselistcd=new ArrayList<HnDetail>();
		//List<HnDetail> baselistwh=new ArrayList<HnDetail>();
		List<HnDetailExpress> baselist = new ArrayList<HnDetailExpress>();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		sqlcd="select * from t_hn_detail where time>='"+btime+"' and time<='"+etime+"' order by time,zx,zyzl desc, ljrjcl desc";
			querycd = session.createSQLQuery(sqlcd).addEntity(HnDetail.class);
			baselistcd=(List<HnDetail>) querycd.list();
			for(int i=0;i<baselistcd.size();i++)
			{
				HnDetailExpress hde = new HnDetailExpress();
				HnDetail hd = baselistcd.get(i);
				//hn891中查询录入修改，检核修改任务量
				//HnSimple hs = getHn891Simple(session,hd.getTime(),hd.getNo());
				hde.setId(i+1);
				hde.setNo(hd.getNo());
				hde.setTime(hd.getTime());
				hde.setName(hd.getName());
				hde.setZx(Tld.zxToString(hd.getZx()));
				hde.setXz(Tld.xzToString(hd.getXz()));
				hde.setTeam(Tld.posToTeamShort(hd.getTeam()));
				hde.setPercltime(Tld.DoubleTo2(hd.getPercltime()));
				hde.setZyccl(Tld.DoubleDownloadNew(hd.getOutput(),hd.getZyccl()));
				hde.setOutput891(hengToDouble(Tld.DoubleTo0(hd.getOutput891())));
				hde.setOutput895(hengToDouble(Tld.DoubleTo0(hd.getOutput895())));
				hde.setOutput(hengToDouble(Tld.DoubleTo0(hd.getOutput())));
				hde.setCcl891(Tld.DoubleDownloadNew(check.IsNullInteger(hd.getLrxg())+check.IsNullInteger(hd.getJhxg()),hd.getCcl891()));//
				hde.setCxl891(Tld.DoubleDownloadNew(hd.getOutput891(),hd.getCxl891()));
				hde.setTpl891(Tld.DoubleDownloadNew(hd.getOutput891(),hd.getTpl891()));
				hde.setCcl895(Tld.DoubleDownloadNew(hd.getOutput895(),hd.getCcl895()));//
				hde.setCxl895(Tld.DoubleDownloadNew(hd.getOutput895(),hd.getCxl895()));
				hde.setTpl895(Tld.DoubleDownloadNew(hd.getOutput895(),hd.getTpl895()));
				hde.setLjrjcl(hengToDouble(Tld.DoubleTo0(hd.getLjrjcl())));
				hde.setRjclwcl(Tld.DoubleDownloadNew(hd.getLjsxts(),hd.getRjclwcl()));
				hde.setLjcl(hengToDouble(Tld.DoubleTo0(hd.getLjcl())));
				hde.setRjccl891(Tld.DoubleDownloadNew(check.IsNullInteger(hd.getLjlr())+check.IsNullInteger(hd.getLjjh()),hd.getRjccl891()));//
				hde.setRjcxl891(Tld.DoubleDownloadNew(hd.getLjywl891(),hd.getRjcxl891()));//
				hde.setRjtpl891(Tld.DoubleDownloadNew(hd.getLjywl891(),hd.getRjtpl891()));//
				hde.setRjccl895(Tld.DoubleDownloadNew(check.IsNullInteger(hd.getLjlr895())+check.IsNullInteger(hd.getLjjh895()),hd.getRjccl895()));//
				hde.setRjcxl895(Tld.DoubleDownloadNew(hd.getLjywl895(),hd.getRjcxl895()));//
				hde.setRjtpl895(Tld.DoubleDownloadNew(hd.getLjywl895(),hd.getRjtpl895()));//
				hde.setQdlr(hengToInteger(Tld.IntegerToString(hd.getQdlr())));
				hde.setQdlrz(hengToInteger(Tld.IntegerToString(hd.getQdlrz())));
				hde.setLjqdlr(hengToInteger(Tld.IntegerToString(hd.getLjqdlr())));
				hde.setLjqdlrz(hengToInteger(Tld.IntegerToString(hd.getLjqdlrz())));
				hde.setQdlrzl(Tld.DoubleDownloadNew(check.IsNullInteger(hd.getQdlr()),hd.getQdlrzl()));
				hde.setLjqdlrzl(Tld.DoubleDownloadNew(check.IsNullInteger(hd.getLjqdlr()),hd.getLjqdlrzl()));
				hde.setLjsxts(hengToInteger(Tld.IntegerToString(hd.getLjsxts())));
				hde.setLjlrcc(Tld.IntegerToString(hd.getLjlrcc()));
				hde.setLjjhcc(Tld.IntegerToString(hd.getLjjhcc()));
				hde.setZyzl(Tld.zuoyezhiliang(hd.getZyzl()));
				hde.setOnline(hengToInteger(Tld.IntegerToString(hd.getOnline())));
				baselist.add(hde);
			}
//			baselist.add(temp);
//			sqlwh="select * from t_hn_detail where time='"+begindate.replace("-", "")+"' and xz in (0,1,2) and zx=1 order by ljrjcl desc";
//			querywh = session.createSQLQuery(sqlwh).addEntity(HnDetail.class);
//			baselistwh=(List<HnDetail>) querywh.list();
//			for(int i=0;i<baselistwh.size();i++)
//			{
//				HnDetailExpress hde = new HnDetailExpress();
//				HnDetail hd = baselistwh.get(i);
//				HnSimple hs = getHn891Simple(session,time,hd.getNo());
//				hde.setId(i+1);
//				hde.setNo(hd.getNo());
//				hde.setName(hd.getName());
//				hde.setZx(Tld.zxToString(hd.getZx()));
//				hde.setXz(Tld.xzToString(hd.getXz()));
//				hde.setTeam(Tld.teamToString(hd.getTeam()));
//				hde.setLrxg(hengToInteger(Tld.IntegerToString(hd.getLrxg())));
//				hde.setXlLrxg(hengToDouble(Tld.DoubleTo2(hd.getXlLrxg())));
//				hde.setLrsq(hengToInteger(Tld.IntegerToString(hd.getLrsq())));
//				hde.setXlLrsq(hengToDouble(Tld.DoubleTo2(hd.getXlLrsq())));
//				hde.setOutput891(hengToDouble(Tld.DoubleTo2(hd.getOutput891())));
//				hde.setOutput895(hengToDouble(Tld.DoubleTo2(hd.getOutput895())));
//				hde.setOutput(hengToDouble(Tld.DoubleTo2(hd.getOutput())));
//				hde.setCcl(Tld.DoubleDownloadNew(hs.getDtlr()+hs.getDtjh(),hd.getCcl()));
//				hde.setCxl(Tld.DoubleDownloadNew(hd.getLrxg(),hd.getCxl()));
//				hde.setTpl(Tld.DoubleDownloadNew(hd.getLrxg(),hd.getTpl()));
//				hde.setLjrjcl(hengToDouble(Tld.DoubleTo2(hd.getLjrjcl())));
//				hde.setRjclwcl(hengToDouble(Tld.DoubleTo4(hd.getRjclwcl())));
//				hde.setLjcl(hengToDouble(Tld.DoubleTo2(hd.getLjcl())));
//				hde.setLjlrcc(hengToInteger(Tld.IntegerToString(hd.getLjlrcc())));
//				hde.setLjjhcc(hengToInteger(Tld.IntegerToString(hd.getLjjhcc())));
//				hde.setLrrjccl(Tld.DoubleDownloadNew(hs.getLjlr()+hs.getLjjh(),hd.getLrrjccl()));
//				hde.setRjcxl(Tld.DoubleDownloadNew(hs.getLjlr(),hd.getRjcxl()));
//				hde.setRjtpl(Tld.DoubleDownloadNew(hs.getLjlr(),hd.getRjtpl()));
//				hde.setLjsxts(hengToInteger(Tld.IntegerToString(hd.getLjsxts())));
//				baselist.add(hde);
//			}
    		//baselistcd = hddao.findBykey(time, 5, 0, 0, "ljrjcl", 1);
    		//baselistwh = hddao.findBykey(time, 5, 1, 0, "ljrjcl", 1);
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
	/**
	 * 
	 * @param session
	 * @param btime
	 * @param etime
	 * @param no
	 * @return
	 */
	public HnSimple getHn891Simple(Session session,String etime,String no)
	{
		GeneralCheck check = new GeneralCheck();
		String btime =etime.substring(0,6)+"01";
		String sqlcdtemp = "select * from hn891 where time<='"+etime+"' and time>='"+btime+"' and no='"+no+"' order by time desc";
		Query querycdtemp = session.createSQLQuery(sqlcdtemp).addEntity(Hn891.class);
		List<Hn891> list891 = new ArrayList<Hn891>();
		HnSimple hs = new HnSimple();
		list891 = (List<Hn891>)querycdtemp.list();
		int ljlr = 0;
		int ljjh = 0;
		for(int i=0;i<list891.size();i++)
		{
			ljlr+=check.IsNullInteger(list891.get(i).getLrxg());
			ljjh+=check.IsNullInteger(list891.get(i).getJhxg());
		}
		hs.setNo(no);
		hs.setLjlr(ljlr);
		hs.setLjjh(ljjh);
		if(list891.size()>0)
		{
			hs.setDtlr(check.IsNullInteger(list891.get(0).getLrxg()));
			hs.setDtjh(check.IsNullInteger(list891.get(0).getJhxg()));
		}
		else
		{
			hs.setDtlr(0);
			hs.setDtjh(0);
		}
		
		return hs;
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

///

