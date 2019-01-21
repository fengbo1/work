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
import work.hn.pojo.HnYcsh;
import work.hn.pojo.HnYcshBean;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class ExpYcsh {
	private static Logger logger = Logger.getLogger(ExpYcsh.class);
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
		ExpYcsh.logger = logger;
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
		ExportExcel<HnYcshBean> ex = new ExportExcel<HnYcshBean>();
		String[] headers = { "序号","日期","工号","姓名", "中心","折合产量","审核笔数",
				"审核总时长","平均时长","通过笔数","通过率","拒绝笔数",
				"拒绝率","撤销笔数","撤销率","在线时长（小时）"
		};
		List<HnYcshBean> dataset = findData(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath = Tld.downloadpath+time+"-"+enddate.replace("-", "")+"ycsh.xls";
        //filePath="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/work/derive/"+time+"-"+enddate.replace("-", "")+"zuoyezhibiaomingxibiao.xls";
        Path = time+"-"+enddate.replace("-", "")+"ycsh.xls";
        try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("远程审核明细表",headers, dataset, out);
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
	public List<HnYcshBean> findData(String bdate,String edate)
	{
		String sqlcd="";
		Query querycd;
		GeneralCheck check = new GeneralCheck();
		List<HnYcsh> list=new ArrayList<HnYcsh>();
		//List<HnDetail> baselistwh=new ArrayList<HnDetail>();
		List<HnYcshBean> listexp = new ArrayList<HnYcshBean>();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		sqlcd="select * from t_hn_ycsh where date>='"+bdate+"' and date<='"+edate+"' order by date,zx,cl desc";
			querycd = session.createSQLQuery(sqlcd).addEntity(HnYcsh.class);
			list=(List<HnYcsh>) querycd.list();
			for(int i=0;i<list.size();i++)
			{
				HnYcshBean hde = new HnYcshBean();
				HnYcsh hd = list.get(i);
				//hn891中查询录入修改，检核修改任务量
				//HnSimple hs = getHn891Simple(session,hd.getTime(),hd.getNo());
				hde.setId(i+1);
				hde.setDate(hd.getDate());
				hde.setNewnumber(hd.getNewnumber());
				hde.setName(hd.getName());
				hde.setZx(Tld.zxToString(hd.getZx()));
				hde.setCl(String.valueOf(hd.getCl()));
				hde.setNum(String.valueOf(hd.getNum()));
				hde.setSc(String.valueOf(hd.getSc()));
				hde.setPjsc(String.valueOf(hd.getPjsc()));
				
				hde.setTg(String.valueOf(hd.getTg()));
				hde.setTgl(String.valueOf(hd.getTgl()));
				hde.setJj(String.valueOf(hd.getJj()));
				hde.setJjl(String.valueOf(hd.getJjl()));
				hde.setCx(String.valueOf(hd.getCx()));
				
				hde.setCxl(String.valueOf(hd.getCxl()));
				hde.setZxsc(String.valueOf(hd.getZxsc()));
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
