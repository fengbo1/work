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
import work.wb.pojo.FzyyExpress;
import work.wb.pojo.WbFzyy;
import work.wb.pojo.WbYslr;
import ccb.hibernate.HibernateSessionFactory;
import work.util.ExportExcel;
import work.util.Tld;


public class FzyyDownload{
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
	public FzyyDownload() {
		//super(WbBaseAction.class);
		
		// TODO Auto-generated constructor stub
	}
	public String execute() throws Exception 
    {
		String filePath="";
		String result="success";
		ExportExcel<FzyyExpress> ex = new ExportExcel<FzyyExpress>();
		String[] headers = { "id","日期","公司代码", "公司名称", "在线人数", "人员占比",
				"单笔平均时长","录入量","录入量占比","差错笔数","差错率","回收笔数","回收率",
				"人均切片量","2520片以上人数","2520片以上人员占比","有效工作时长大于平均值人员数","有效工作时长大于平均值人员数占比"
		};
		List<FzyyExpress> dataset = findFzyy(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath=Tld.downloadpath+begindate.replace("-", "")+"-"+enddate.replace("-", "")+"fzyy.xls";
		Path = begindate.replace("-", "")+"-"+enddate.replace("-", "")+"fzyy.xls";
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
	public List<FzyyExpress> findFzyy(String begindate,String enddate)
	{
		List<WbFzyy> list= new ArrayList<WbFzyy>();
		List<FzyyExpress> baselist=new ArrayList<FzyyExpress>();
		String sql="";
		Query query;
		int i;
		FzyyExpress fzyy = new FzyyExpress();
		Transaction trans = null;
    	Session session = HibernateSessionFactory.getSession();
    	try {
			trans=session.beginTransaction();
			sql="select * from t_wb_fzyy where date>='"+begindate+"' and date<='"+enddate+"'";
			query = session.createSQLQuery(sql).addEntity(WbFzyy.class);
			list=(List<WbFzyy>) query.list();
			for(i=0;i<list.size();i++)
			{
				fzyy = new FzyyExpress();
				
				fzyy.setAvertime(list.get(i).getAvertime());
				fzyy.setAvevCl(list.get(i).getAvevCl());
				fzyy.setCc(list.get(i).getCc());
				fzyy.setCcl(list.get(i).getCcl());
				fzyy.setCl(list.get(i).getCl());
				fzyy.setClZb(list.get(i).getClZb());
				fzyy.setCorpcode(list.get(i).getCorpcode());
				fzyy.setCorpname(list.get(i).getCorpname());
				fzyy.setDate(list.get(i).getDate());
				fzyy.setHs(list.get(i).getHs());
				fzyy.setHsl(list.get(i).getHsl());
				fzyy.setOnline(list.get(i).getOnline());
				fzyy.setOnlineZb(list.get(i).getOnlineZb());
				
				baselist.add(fzyy);
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
