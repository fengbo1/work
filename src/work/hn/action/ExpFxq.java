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

import work.hn.pojo.HnFxq;
import work.hn.pojo.HnFxqBean;
import work.hn.pojo.HnYcsh;
import work.hn.pojo.HnYcshBean;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class ExpFxq {

	private static Logger logger = Logger.getLogger(ExpFxq.class);
	private String begindate;
	private String enddate;
	private String Path;
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
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception 
    {
		String filePath = "";
		String result="success";
		String time = begindate.replace("-", "");
		ExportExcel<HnFxqBean> ex = new ExportExcel<HnFxqBean>();
		String[] headers = { "序号","日期","工号","姓名", "中心","折合产量","业务量",
				"大额交易-客户","大额交易-明细","可疑交易-客户","可疑交易-明细"
		};
		List<HnFxqBean> dataset = findData(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath = Tld.downloadpath+time+"-"+enddate.replace("-", "")+"fxq.xls";
        //filePath="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/work/derive/"+time+"-"+enddate.replace("-", "")+"zuoyezhibiaomingxibiao.xls";
        Path = time+"-"+enddate.replace("-", "")+"fxq.xls";
        try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("反洗钱明细表",headers, dataset, out);
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
	public List<HnFxqBean> findData(String bdate,String edate)
	{
		String sqlcd="";
		Query querycd;
		GeneralCheck check = new GeneralCheck();
		List<HnFxq> list=new ArrayList<HnFxq>();
		//List<HnDetail> baselistwh=new ArrayList<HnDetail>();
		List<HnFxqBean> listexp = new ArrayList<HnFxqBean>();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		sqlcd="select * from t_hn_fxq where date>='"+bdate+"' and date<='"+edate+"' order by date,zx,cl desc";
			querycd = session.createSQLQuery(sqlcd).addEntity(HnFxq.class);
			list=(List<HnFxq>) querycd.list();
			for(int i=0;i<list.size();i++)
			{
				HnFxqBean hde = new HnFxqBean();
				HnFxq hd = list.get(i);
				//hn891中查询录入修改，检核修改任务量
				//HnSimple hs = getHn891Simple(session,hd.getTime(),hd.getNo());
				hde.setId(i+1);
				hde.setDate(hd.getDate());
				hde.setNewnumber(hd.getNewnumber());
				hde.setName(hd.getName());
				hde.setZx(Tld.zxToString(hd.getZx()));
				hde.setCl(String.valueOf(hd.getCl()));
				hde.setYwl(String.valueOf(hd.getYwl()));
				hde.setDekh(String.valueOf(hd.getDekh()));
				hde.setDemx(String.valueOf(hd.getDemx()));
				
				hde.setKykh(String.valueOf(hd.getKykh()));
				hde.setKymx(String.valueOf(hd.getKymx()));
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
