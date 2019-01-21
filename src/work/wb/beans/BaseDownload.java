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


import work.hn.pojo.SummaryDaily;
import work.hn.pojo.SummaryExpress;
import work.internal.action.Operation;
import work.wb.pojo.WbBase;
import work.wb.pojo.WbBaseSave;



import ccb.hibernate.HibernateSessionFactory;
import work.util.ExportExcel;
import work.util.Tld;

@SuppressWarnings("serial")
public class BaseDownload{
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
	public BaseDownload() {
		//super(WbBaseAction.class);
		
		// TODO Auto-generated constructor stub
	}
	public String execute() throws Exception 
    {
		String filePath="";
		String result="success";
		ExportExcel<WbBaseSave> ex = new ExportExcel<WbBaseSave>();
		String[] headers = { "id","日期","工号", "姓名", "要素录入", "要素录入单笔时长",
				"要素录入差错","要素录入回收","要素录入转影像拆分","要素录入转录入修改","录入仲裁",
				"录入仲裁单笔时长","录入仲裁差错","录入仲裁回收","录入仲裁转录入修改","辅助验印","辅助验印单笔时长"
				,"辅助验印差错","辅助验印回收","要素录入差错率","要素录入回收率","要素录入转影像拆分率",
				"要素录入转录入修改率","录入仲裁差错率","录入仲裁回收率","辅助验印差错率",
				"辅助验印回收率","录入仲裁转录入修改率","要素录入工作时长","辅助验印工作时长","录入仲裁工作时长","处理时长","备注一","备注二"
		};
		List<WbBaseSave> dataset = findWbBase(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath=Tld.downloadpath+begindate.replace("-", "")+"-"+enddate.replace("-", "")+"wbbase.xls";
		Path = begindate.replace("-", "")+"-"+enddate.replace("-", "")+"wbbase.xls";
		// filePath="D:/";
		
		try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("外包基础数据",headers, dataset, out);
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
	
	/*查询外包基础数据表*/
	@SuppressWarnings("unchecked")
	public List<WbBaseSave> findWbBase(String begindate,String enddate)
	{
		List<WbBaseSave> baselist=new ArrayList<WbBaseSave>();
		List<WbBaseSave> resultlist=new ArrayList<WbBaseSave>();
		String sql="";
		Query query;
		WbBaseSave temp=new WbBaseSave();
		
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
			sql="select * from t_wb_base_save where date>='"+begindate+"' and date<='"+enddate+"'";
			query = session.createSQLQuery(sql).addEntity(WbBaseSave.class);
			baselist=(List<WbBaseSave>) query.list();
			
			for(int i=0;i<baselist.size();i++)
			{
				WbBaseSave base=new WbBaseSave();
				temp=baselist.get(i);
				base.setNo(temp.getNo());
				base.setDate(temp.getDate());
				base.setFzyy(temp.getFzyy());
				base.setFzyyCc(temp.getFzyyCc());
				base.setFzyyCcl(temp.getFzyyCcl());
				base.setFzyyHs(temp.getFzyyHs());
				base.setFzyyHsl(temp.getFzyyHsl());
				base.setFzyyTime(temp.getFzyyTime());
				base.setId(temp.getId());
				base.setLrzc(temp.getLrzc());
				base.setLrzcCc(temp.getLrzcCc());
				base.setLrzcCcl(temp.getLrzcCcl());
				base.setLrzcHs(temp.getLrzcHs());
				base.setLrzcHsl(temp.getLrzcHsl());
				base.setLrzcTime(temp.getLrzcTime());
				base.setLrzcZl(temp.getLrzcZl());
				base.setLrzcZll(temp.getLrzcZll());
				base.setName(temp.getName());
				base.setWorkFzyy(temp.getWorkFzyy());
				base.setWorkLrzc(temp.getWorkLrzc());
				base.setWorkTime(temp.getWorkTime());
				base.setWorkYslr(temp.getWorkYslr());
				base.setYslr(temp.getYslr());
				base.setYslrCc(temp.getYslrCc());
				base.setYslrCcl(temp.getYslrCcl());
				base.setYslrHs(temp.getYslrHs());
				base.setYslrTime(temp.getYslrTime());
				base.setYslrHsl(temp.getYslrHsl());
				base.setYslrZl(temp.getYslrZl());
				base.setYslrZll(temp.getYslrZll());
				base.setYslrZy(temp.getYslrZy());
				base.setYslrZyl(temp.getYslrZyl());
				
				resultlist.add(base);
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
		return resultlist;
		 
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
