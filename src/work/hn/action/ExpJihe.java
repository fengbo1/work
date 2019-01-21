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

import work.hn.pojo.HnJihe;
import work.hn.pojo.HnJiheBean;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class ExpJihe {
	private static Logger logger = Logger.getLogger(ExpJihe.class);
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
		ExpJihe.logger = logger;
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
		ExportExcel<HnJiheBean> ex = new ExportExcel<HnJiheBean>();
		String[] headers = { "序号","日期","工号","姓名", "中心","折合产量","核对类质检",
				"分析性质检","分析性稽核","问题管理业务量","发布问题量","审核取消问题量",
				"直接取消问题量"
		};
		List<HnJiheBean> dataset = findData(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath = Tld.downloadpath+time+"-"+enddate.replace("-", "")+"jihe.xls";
        //filePath="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/work/derive/"+time+"-"+enddate.replace("-", "")+"zuoyezhibiaomingxibiao.xls";
        Path = time+"-"+enddate.replace("-", "")+"jihe.xls";
        try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("稽核明细表",headers, dataset, out);
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
	public List<HnJiheBean> findData(String bdate,String edate)
	{
		String sqlcd="";
		Query querycd;
		GeneralCheck check = new GeneralCheck();
		List<HnJihe> list=new ArrayList<HnJihe>();
		//List<HnDetail> baselistwh=new ArrayList<HnDetail>();
		List<HnJiheBean> listexp = new ArrayList<HnJiheBean>();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		sqlcd="select * from t_hn_jihe where date>='"+bdate+"' and date<='"+edate+"' order by date,zx,cl desc";
			querycd = session.createSQLQuery(sqlcd).addEntity(HnJihe.class);
			list=(List<HnJihe>) querycd.list();
			for(int i=0;i<list.size();i++)
			{
				HnJiheBean hde = new HnJiheBean();
				HnJihe hd = list.get(i);
				//hn891中查询录入修改，检核修改任务量
				//HnSimple hs = getHn891Simple(session,hd.getTime(),hd.getNo());
				hde.setId(i+1);
				hde.setDate(hd.getDate());
				hde.setNewnumber(hd.getNewnumber());
				hde.setName(hd.getName());
				hde.setZx(Tld.zxToString(hd.getZx()));
				hde.setCl(String.valueOf(hd.getCl()));
				//hde.setRole(hd.getRole());
				//hde.setYwl(String.valueOf(hd.getYwl()));
				hde.setHdlzj(String.valueOf(hd.getHdlzj()));
				//hde.setHdljh(String.valueOf(hd.getHdljh()));
				hde.setFxxzj(String.valueOf(hd.getFxxzj()));
				hde.setFxxjh(String.valueOf(hd.getFxxjh()));
				
				int fb = hd.getFbYs()+hd.getFbJy()+hd.getFbGf()+hd.getFbYb()+hd.getFbZd();
				int sh = hd.getShYs()+hd.getShJy()+hd.getShGf()+hd.getShYb()+hd.getShZd();
				int zj = hd.getZjYs()+hd.getZjJy()+hd.getZjGf()+hd.getZjYb()+hd.getZjZd();
				hde.setFb(String.valueOf(fb));
				hde.setSh(String.valueOf(sh));
				hde.setZj(String.valueOf(zj));
				hde.setWt(String.valueOf(fb+sh+zj));
				
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
