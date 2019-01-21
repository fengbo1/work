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
import work.hn.dao.HnJianyaDAO;
import work.hn.dao.HnWaihuiDAO;
import work.hn.dao.HnJiheDAO;
import work.hn.dao.HnYcshDAO;
import work.hn.pojo.HnJianya;
import work.hn.pojo.HnJihe;
import work.hn.pojo.HnWaihui;
import work.hn.pojo.HnYcsh;
import work.hndetail.pojo.HnDetailExpNew;
import work.hndetail.pojo.HnDetailExpOther;
import work.hndetail.pojo.HnNew;
import work.no.dao.NoDAO;
import work.no.pojo.No;
import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

/**
 * 导出新报表（明细）
 * @author htzx
 *
 */
public class HnExportNewDetail {

	private static Logger logger = Logger.getLogger(HnExportNewDetail.class);
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
		HnExportNewDetail.logger = logger;
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
		ExportExcel<HnDetailExpOther> ex = new ExportExcel<HnDetailExpOther>();
		String[] headers = { "序号","日期","工号","姓名", "中心", "人员性质",
				"分组","外汇专业初审","外汇专业复审","外汇录入修改","外汇录入授权",
				"外汇检核修改","外汇检核授权","外汇票据初审","外汇票据复审","外汇失败原因",
				"外汇录入差错","外汇检核差错","外汇退票量","外汇查询量","外汇折合产量",
				"建亚录入修改","建亚录入授权","建亚检核修改","建亚检核授权","建亚票据初审",
				"建亚票据复审","建亚失败原因","建亚录入差错","建亚检核差错","建亚退票量",
				"建亚查询量","建亚折合产量","稽核核对类质检","稽核分析性质检",
				"稽核分析性稽核","稽核问题管理业务量","稽核发布问题量",
				"稽核审核取消问题量","稽核直接取消问题量","稽核折合产量","远程审核笔数","远程审核总时长",
				"远程审核平均时长","远程审核通过笔数","远程审核通过率","远程审核拒绝笔数",
				"远程审核拒绝率","远程审核撤销笔数","远程审核撤销率","远程审核在线时长",
				"远程审核折合产量",
		};
		List<HnDetailExpOther> dataset = findHnDtailReportDetail(begindate.replace("-", ""),enddate.replace("-", ""));
		filePath = Tld.downloadpath+time+"-"+enddate.replace("-", "")+"hangneiribaoqita.xls";
        //filePath="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/work/derive/"+time+"-"+enddate.replace("-", "")+"zuoyezhibiaomingxibiao.xls";
        Path = time+"-"+enddate.replace("-", "")+"hangneiribaoqita.xls";
        try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("操作员作业指标明细表（其他）",headers, dataset, out);
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
	public List<HnDetailExpOther> findHnDtailReportDetail(String bdate,String edate)
	{
		Query query;
		NoDAO nodao = new NoDAO();
		HnWaihuiDAO whdao = new HnWaihuiDAO();
		HnJianyaDAO jydao = new HnJianyaDAO();
		HnJiheDAO jhdao = new HnJiheDAO();
		HnYcshDAO shdao = new HnYcshDAO();
		GeneralCheck check = new GeneralCheck();
		List<String> listdt=new ArrayList<String>();
		//List<HnDetail> baselistwh=new ArrayList<HnDetail>();
		List<HnDetailExpOther> listexpo = new ArrayList<HnDetailExpOther>();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		String sqldt="SELECT distinct(date) from t_hn_new where date>='"+bdate+"' and date<='"+edate+"'";
    		query = session.createSQLQuery(sqldt);
			listdt=(List<String>) query.list();
			for(int i=0;i<listdt.size();i++)
			{
				String dt = listdt.get(i);
				List<No> listno = nodao.findAllHangnei();
				for(int j=0;j<listno.size();j++)
				{
					No no = listno.get(j);
					String name = no.getName();
					System.out.println(name);
					String newnum = no.getNewnumber();
					HnWaihui wh=whdao.findAllByDateAndNameNull(dt, name);
		    		HnJianya jy=jydao.findAllByDateAndNameNull(dt, name);
		    		HnJihe jh = jhdao.findAllByDateAndNameNull(dt, name);
		    		HnYcsh sh = shdao.findAllByDateAndNameNull(dt, name);
					//hn891中查询录入修改，检核修改任务量
					//HnSimple hs = getHn891Simple(session,hd.getTime(),hd.getNo());
		    		if(wh!=null||jy!=null||jh!=null||sh!=null)
		    		{
		    			HnDetailExpOther hde = new HnDetailExpOther();
		    			hde.setId(i+1);
		    			hde.setTime(Tld.ifNull(dt));
		    			hde.setNo(Tld.ifNull(newnum));
		    			hde.setName(Tld.ifNull(name));
		    			hde.setZx(Tld.zxToString(no.getZx()));
						hde.setXz(Tld.xzStringToString(String.valueOf(no.getXz())));
						hde.setTeam(Tld.positionToTeam(no.getPosition()));
						
						if(wh!=null)
						{
							hde.setWh_zycs(String.valueOf(wh.getZycs()));
							hde.setWh_zyfs(String.valueOf(wh.getZyfs()));
							hde.setWh_lrxg(String.valueOf(wh.getLrxg()));
							hde.setWh_lrsq(String.valueOf(wh.getLrsq()));
							hde.setWh_jhxg(String.valueOf(wh.getJhxg()));
							hde.setWh_jhsq(String.valueOf(wh.getJhsq()));
							hde.setWh_pjcs(String.valueOf(wh.getPjcs()));
							hde.setWh_pjfs(String.valueOf(wh.getPjfs()));
							hde.setWh_sbyy(String.valueOf(wh.getSbyy()));
							hde.setWh_lrcc(String.valueOf(wh.getLrcc()));
							hde.setWh_jhcc(String.valueOf(wh.getJhcc()));
							hde.setWh_tp(String.valueOf(wh.getTp()));
							hde.setWh_cx(String.valueOf(wh.getCx()));
							hde.setWh_zhcl(String.valueOf(wh.getZhcl()));
						}
						if(jy!=null)
						{
							hde.setJy_lrxg(String.valueOf(jy.getLrxg()));
							hde.setJy_lrsq(String.valueOf(jy.getLrsq()));
							hde.setJy_jhxg(String.valueOf(jy.getJhxg()));
							hde.setJy_jhsq(String.valueOf(jy.getJhsq()));
							hde.setJy_pjcs(String.valueOf(jy.getPjcs()));
							hde.setJy_pjfs(String.valueOf(jy.getPjfs()));
							hde.setJy_sbyy(String.valueOf(jy.getSbyy()));
							hde.setJy_lrcc(String.valueOf(jy.getLrcc()));
							hde.setJy_jhcc(String.valueOf(jy.getJhcc()));
							hde.setJy_tp(String.valueOf(jy.getTp()));
							hde.setJy_cx(String.valueOf(jy.getCx()));
							hde.setJy_zhcl(String.valueOf(jy.getZhcl()));
						}
						if(jh!=null)
						{
							hde.setJh_hdlzj(String.valueOf(jh.getHdlzj()));
							//hde.setHdljh(String.valueOf(hd.getHdljh()));
							hde.setJh_fxxzj(String.valueOf(jh.getFxxzj()));
							hde.setJh_fxxjh(String.valueOf(jh.getFxxjh()));
							
							int f = jh.getFbYs()+jh.getFbJy()+jh.getFbGf()+jh.getFbYb()+jh.getFbZd();
							int s = jh.getShYs()+jh.getShJy()+jh.getShGf()+jh.getShYb()+jh.getShZd();
							int z = jh.getZjYs()+jh.getZjJy()+jh.getZjGf()+jh.getZjYb()+jh.getZjZd();
							hde.setJh_fb(String.valueOf(f));
							hde.setJh_sh(String.valueOf(s));
							hde.setJh_zj(String.valueOf(z));
							hde.setJh_wt(String.valueOf(f+s+z));
							
							hde.setJh_zhcl(String.valueOf(jh.getCl()));
						}
						if(sh!=null)
						{
							hde.setSh_num(String.valueOf(sh.getNum()));
							hde.setSh_sc(String.valueOf(sh.getSc()));
							hde.setSh_pjsc(String.valueOf(sh.getPjsc()));
							hde.setSh_tg(String.valueOf(sh.getTg()));
							hde.setSh_tgl(String.valueOf(sh.getTgl()));
							hde.setSh_jj(String.valueOf(sh.getJj()));
							hde.setSh_jjl(String.valueOf(sh.getJjl()));
							hde.setSh_cx(String.valueOf(sh.getCx()));
							hde.setSh_cxl(String.valueOf(sh.getCxl()));
							hde.setSh_zxsc(String.valueOf(sh.getZxsc()));
							hde.setSh_zhcl(String.valueOf(sh.getCl()));
						}
						
						listexpo.add(hde);
		    		}
					
				}
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
		return listexpo;
		 
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
