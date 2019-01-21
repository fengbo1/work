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

import work.hn.pojo.HnWaihui;
import work.hn.pojo.HnWaihuiBean;
import work.hndetail.action.HnExportNew;
import work.hndetail.pojo.HnDetailExpNew;
import work.hndetail.pojo.HnNew;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class ExpWaihui {
	private static Logger logger = Logger.getLogger(ExpWaihui.class);
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
		ExpWaihui.logger = logger;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String execute() throws Exception 
    {
		String filePath = "";
		String result="success";
		String time = begindate.replace("-", "");
		ExportExcel<HnWaihuiBean> ex = new ExportExcel<HnWaihuiBean>();
		String[] headers = { "序号","日期","工号","姓名", "中心", "业务初审",
				"业务复审","录入修改","录入授权","检核修改","检核授权","票据初审","票据复审",
				"失败原因","业务初审效率","业务复审效率","录入修改效率","录入授权效率",
				"检核修改效率","检核授权效率","票据初审效率","票据复审效率","失败原因效率",
				"录入差错","录入差错率","检核差错","检核差错率","退票","退票率","查询","查询率",
				"业务笔数","差错率","单位产能作业时间","有效作业时长","驳回量","驳回率","折合产量"
		};
		List<HnWaihuiBean> dataset = findData(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath = Tld.downloadpath+time+"-"+enddate.replace("-", "")+"waihui.xls";
        //filePath="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/work/derive/"+time+"-"+enddate.replace("-", "")+"zuoyezhibiaomingxibiao.xls";
        Path = time+"-"+enddate.replace("-", "")+"waihui.xls";
        try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("外汇明细表",headers, dataset, out);
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
	public List<HnWaihuiBean> findData(String bdate,String edate)
	{
		String sqlcd="";
		Query querycd;
		GeneralCheck check = new GeneralCheck();
		List<HnWaihui> list=new ArrayList<HnWaihui>();
		//List<HnDetail> baselistwh=new ArrayList<HnDetail>();
		List<HnWaihuiBean> listexp = new ArrayList<HnWaihuiBean>();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		sqlcd="select * from t_hn_waihui where date>='"+bdate+"' and date<='"+edate+"' order by date,zx,zhcl desc";
			querycd = session.createSQLQuery(sqlcd).addEntity(HnWaihui.class);
			list=(List<HnWaihui>) querycd.list();
			for(int i=0;i<list.size();i++)
			{
				HnWaihuiBean hde = new HnWaihuiBean();
				HnWaihui hd = list.get(i);
				//hn891中查询录入修改，检核修改任务量
				//HnSimple hs = getHn891Simple(session,hd.getTime(),hd.getNo());
				hde.setId(i+1);
				hde.setDate(hd.getDate());
				hde.setNo(hd.getNo());
				hde.setName(hd.getName());
				hde.setZx(Tld.zxToString(hd.getZx()));
				
				hde.setZycs(String.valueOf(hd.getZycs()));
				hde.setZyfs(String.valueOf(hd.getZyfs()));
				hde.setLrxg(String.valueOf(hd.getLrxg()));
				hde.setLrsq(String.valueOf(hd.getLrsq()));
				hde.setJhxg(String.valueOf(hd.getJhxg()));
				hde.setJhsq(String.valueOf(hd.getJhsq()));
				hde.setPjcs(String.valueOf(hd.getPjcs()));
				hde.setPjfs(String.valueOf(hd.getPjfs()));
				hde.setSbyy(String.valueOf(hd.getSbyy()));
				
				hde.setXlzycs(String.valueOf(hd.getXlzycs()));
				hde.setXlzyfs(String.valueOf(hd.getXlzyfs()));
				hde.setXllrxg(String.valueOf(hd.getXllrxg()));
				hde.setXllrsq(String.valueOf(hd.getXllrsq()));
				hde.setXljhxg(String.valueOf(hd.getXljhxg()));
				hde.setXljhsq(String.valueOf(hd.getXljhsq()));
				hde.setXlpjcs(String.valueOf(hd.getXlpjcs()));
				hde.setXlpjfs(String.valueOf(hd.getXlpjfs()));
				hde.setXlsbyy(String.valueOf(hd.getXlsbyy()));
				
				hde.setLrcc(String.valueOf(hd.getLrcc()));
				hde.setLclv(Tld.DoubleDownloadNew(hd.getLrxg(),hd.getLclv()));
				hde.setJhcc(String.valueOf(hd.getJhcc()));
				hde.setJclv(Tld.DoubleDownloadNew(hd.getJhxg(),hd.getJclv()));
				hde.setTp(String.valueOf(hd.getTp()));
				hde.setTplv(Tld.DoubleDownloadNew(hd.getTp(),hd.getTplv()));
				hde.setCx(String.valueOf(hd.getCx()));
				hde.setCxlv(Tld.DoubleDownloadNew(hd.getCx(),hd.getCxlv()));
				
				hde.setYwl(String.valueOf(hd.getYwl()));
				hde.setCcl(Tld.DoubleDownloadNew(hd.getZhcl(),hd.getCcl()));
				hde.setPercl(String.valueOf(hd.getPercl()));
				hde.setSumxl(String.valueOf(Tld.DoubleTo2double(hd.getSumxl()/3600)));
				hde.setBh(String.valueOf(hd.getBh()));
				hde.setBhl(Tld.DoubleDownloadNew(hd.getZyfs(),hd.getBhl()));
				
				hde.setZhcl(String.valueOf(hd.getZhcl()));
				
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
}
