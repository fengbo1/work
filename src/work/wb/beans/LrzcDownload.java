package work.wb.beans;

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
import work.internal.action.Operation;
import work.wb.pojo.LrzcExpress;
import work.wb.pojo.WbLrzc;
import work.wb.pojo.WbYslr;
import ccb.hibernate.HibernateSessionFactory;
import work.util.ExportExcel;
import work.util.Tld;


public class LrzcDownload{
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
	public LrzcDownload() {
		//super(WbBaseAction.class);
		
		// TODO Auto-generated constructor stub
	}
	public String execute() throws Exception 
    {
		String filePath="";
		String result="success";
		ExportExcel<LrzcExpress> ex = new ExportExcel<LrzcExpress>();
		String[] headers = { "id","日期","公司代码", "公司名称", "在线人数", "人员占比",
				"单笔平均时长","录入量","录入量占比","差错笔数","差错率","回收笔数","回收率",
				"人均切片量"	};
		List<LrzcExpress> dataset = findLrzc(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath=Tld.downloadpath+begindate.replace("-", "")+"-"+enddate.replace("-", "")+"lrzc.xls";
		Path = begindate.replace("-", "")+"-"+enddate.replace("-", "")+"lrzc.xls";
		try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("要素录入日报表数据",headers, dataset, out);
			out.close();
		
			System.out.println("excel导出成功！");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
    }
	
	/*查询外包基础数据表*/
	@SuppressWarnings("unchecked")
	public List<LrzcExpress> findLrzc(String begindate,String enddate)
	{
		List<WbLrzc> list= new ArrayList<WbLrzc>();
		List<LrzcExpress> baselist=new ArrayList<LrzcExpress>();
		String sql="";
		Query query;
		int i;
		LrzcExpress lrzc = new LrzcExpress();
		Transaction trans = null;
    	Session session = HibernateSessionFactory.getSession();
    	try {
			trans=session.beginTransaction();
			sql="select * from t_wb_lrzc where date>='"+begindate+"' and date<='"+enddate+"'";
			query = session.createSQLQuery(sql).addEntity(WbLrzc.class);
			list=(List<WbLrzc>) query.list();
			for(i=0;i<list.size();i++)
			{
				lrzc = new LrzcExpress();
				lrzc.setAvertime(list.get(i).getAvertime());
				lrzc.setAvevCl(list.get(i).getAvevCl());
				lrzc.setCc(list.get(i).getCc());
				lrzc.setCcl(list.get(i).getCcl());
				lrzc.setCl(list.get(i).getCl());
				lrzc.setClZb(list.get(i).getClZb());
				lrzc.setCorpcode(list.get(i).getCorpcode());
				lrzc.setCorpname(list.get(i).getCorpname());
				lrzc.setDate(list.get(i).getDate());
				lrzc.setHs(list.get(i).getHs());
				lrzc.setHsl(list.get(i).getHsl());
				lrzc.setOnline(list.get(i).getOnline());
				lrzc.setOnlineZb(list.get(i).getOnlineZb());
				
				baselist.add(lrzc);
			}
			
    	} catch (Exception e) {
		
			trans.rollback();
			e.printStackTrace();
			logger.error(e);
		}finally{
			trans.commit();
	        session.flush();
	        session.clear();
	        session.close();
		}
		return baselist;
		 
	}
	
	
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getEnddate() {
		return enddate;
	}
		
}
