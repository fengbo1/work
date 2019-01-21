package work.hn.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.ControlDAO;
import work.control.pojo.Control;
import work.daily.dao.DailyStatusDAO;
import work.daily.pojo.DailyStatus;
import work.hn.dao.SummaryDAO;
import work.hn.dao.SummaryDailyDAO;
import work.hn.pojo.Hn891;
import work.hn.pojo.Hn895;
import work.hn.pojo.Summary;
import work.hn.pojo.SummaryDaily;
import work.util.GeneralCheck;
import work.wb.beans.BaseData;

import ccb.hibernate.HibernateSessionFactory;
/*生成汇总简表---没有查询率*/

public class SummarySimple
{
	private String date;//时间
	private static Logger logger = Logger.getLogger(BaseData.class);
	private String message;
	public SummarySimple() {
		
	}
	public String execute() throws Exception
	{
		String result="";
		/*删除表*/
		date=date.replace("-", "");
		DelTable("t_summary",date);
		    
		date=date.replaceAll("-", "");
		message = "汇总简表加工成功！";
		/*计算*/
		result=CountOperator(date);
		/*操作数据加工表*/
		result=updateStatus(date);
	    
		return "success";
	}
	public String execute(String date) throws Exception
	{
		String result="";
		/*删除表*/
		date=date.replace("-", "");
		DelTable("t_summary",date);
		    
		date=date.replaceAll("-", "");
		message = "汇总简表加工成功！";
		/*计算*/
		result=CountOperator(date);
		/*操作数据加工表*/
		result=updateStatus(date);
	    
		return "success";
	}
	public String WhbbUpdate(String idate) throws Exception
	{
		String result="success";
		/*删除表*/
		idate=idate.replace("-", "");
		DelTable("t_summary",idate);
			
		/*计算*/
		result=CountOperator(idate);
		/*操作数据加工表*/
		result=updateStatus(idate);
	    
		return "success";
	}
	/*计算总行栏位*/
	public String CountOperator(String date)
	{
		String result="success";
		String sql="";
		double lv = 0.0;
		ControlDAO condao = new ControlDAO();		
		SummaryDAO dao= new SummaryDAO();
		/*总行平均*/
		Summary summary_aver=new Summary();
		/*总行最高*/
		Summary summary_max=new Summary();
		/*总行最低*/
		Summary summary_min=new Summary();
		/*成都平均*/
		Summary cd_aver=new Summary();
		/*成都最高*/
		Summary cd_max=new Summary();
		/*成都最低*/
		Summary cd_min=new Summary();
		
		GeneralCheck check =new GeneralCheck();
		
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
		Control control = (Control) condao.findAll().get(0);	
         /*******************************************总行平均值*******************************************/	
		summary_aver.setJg("总行");
		summary_aver.setType("平均");
		/*总行当日任务量不上线的也算在内*/
		String bdate =date.substring(0, 6)+"01";
		sql="where time='"+date+"' and xz='0' ";
		int all_cl=0;
		int all_cc=0;
		double dcc=0.0;
		double dcl=0.0;
		int sxts=0;
//		int lrxg895 = 0;
//		int jhxg895 = 0;
//		int lrcc895	= 0;
//		int jhcc895 = 0;
		
		//日均
		sql = "SELECT sum(cl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and xz=0 and sx=1";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sx) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and xz=0 and sx=1";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setClAver(check.DoubleTo0(check.division(dcl, sxts)));
		
		//当日
		sql = "SELECT sum(cl) from t_hn_new where date='"+date+"' and xz=0 and sx=1";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sx) from t_hn_new where date='"+date+"' and xz=0 and sx=1";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setClDay(check.DoubleTo0(check.division(dcl, sxts)));
		
		//当日人民币
		sql = "SELECT sum(output) from t_hn_detail where time='"+date+"' and xz=0 and online=1 and output>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(online) from t_hn_detail where time='"+date+"' and xz=0 and online=1 and output>0";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setClDayRmb(check.DoubleTo0(check.division(dcl, sxts)));
		//当日外汇
		sql = "SELECT sum(clwh) from t_hn_new where date='"+date+"'";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxwh) from t_hn_new where date='"+date+"'";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setClDayWh(check.DoubleTo0(check.division(dcl, sxts)));
		//当日稽核
		sql = "SELECT sum(cljh) from t_hn_new where date='"+date+"'";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxjh) from t_hn_new where date='"+date+"'";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setClDayJh(check.DoubleTo0(check.division(dcl, sxts)));
		//当日审核
		sql = "SELECT sum(clsh) from t_hn_new where date='"+date+"'";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxsh) from t_hn_new where date='"+date+"'";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setClDaySh(check.DoubleTo0(check.division(dcl, sxts)));
		//当日建亚
		sql = "SELECT sum(cljy) from t_hn_new where date='"+date+"'";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxjy) from t_hn_new where date='"+date+"'";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setClDayJy(check.DoubleTo0(check.division(dcl, sxts)));
		//当日反洗钱
		sql = "SELECT sum(clfxq) from t_hn_new where date='"+date+"'";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxfxq) from t_hn_new where date='"+date+"'";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setClDayFxq(check.DoubleTo0(check.division(dcl, sxts)));
		
		
		/*总行当月任务量*/
		
		
		/*总行当日作业差错率*/
		//当日差错
		sql = "SELECT sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz) from t_hn_new where date='"+date+"' and xz=0";
		dcc=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) from t_hn_new where date='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setZycclDay(check.DoubleTo4(check.division(dcc, dcl)));
		
		/*总行当月日均作业差错率*/
		sql = "SELECT sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and xz=0";
		dcc=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_aver.setZycclAver(check.DoubleTo4(check.division(dcc, dcl)));
		
		/*总行当日作业退票率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0')";
		all_cc=dao.countColumn("tp891+tp895", "t_hn_detail_temp", sql);
		all_cl=dao.countColumn("ywl891+ywl895", "t_hn_detail_temp", sql);
		summary_aver.setZytplDay(check.DoubleTo4(check.division(all_cc,all_cl)));
		
		/*总行当月日均作业退票率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0')";
		all_cc=dao.countColumn("ljtp891+ljtp895", "t_hn_detail_temp", sql);
		all_cl=dao.countColumn("ljywl891+ljywl895", "t_hn_detail_temp", sql);
		summary_aver.setZytplAver(check.DoubleTo4(check.division(all_cc,all_cl)));
		
		/*总行当日作业查询率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0')";
		all_cc=dao.countColumn("cx891+cx895", "t_hn_detail_temp", sql);
		all_cl=dao.countColumn("ywl891+ywl895", "t_hn_detail_temp", sql);
		summary_aver.setZycxlDay(check.DoubleTo4(check.division(all_cc,all_cl)));
		
		/*总行当月日均作业查询率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0')";
		all_cc=dao.countColumn("ljcx891+ljcx895", "t_hn_detail_temp", sql);
		all_cl=dao.countColumn("ljywl891+ljywl895", "t_hn_detail_temp", sql);
		summary_aver.setZycxlAver(check.DoubleTo4(check.division(all_cc,all_cl)));
		
		
		
		/*总行当日转网点率*/	
		sql="where time='"+date+"' and xz='0'";
		all_cc=dao.countColumn("qdlrz", "t_hn_detail", sql);
		all_cl=dao.countColumn("qdlr", "t_hn_detail", sql);
		summary_aver.setZwd(check.DoubleTo4(check.division(all_cc, all_cl)));
		
		/*总行当月转网点率*/	
		sql="where time='"+date+"' and xz='0' ";
		all_cc=dao.countColumn("ljqdlrz", "t_hn_detail", sql);
		all_cl=dao.countColumn("ljqdlr", "t_hn_detail", sql);
		summary_aver.setLjzwd(check.DoubleTo4(check.division(all_cc, all_cl)));
		
		summary_aver.setDate(date);
		dao.save(summary_aver);
		
		/*******************************************总行最大值*******************************************/
		summary_max.setJg("总行");
		summary_max.setType("最大");
		//日均
		sql = "SELECT max(rjcl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setClAver(dcl);
		
		//当日
		sql = "SELECT max(cl) from t_hn_new where date='"+date+"' and xz=0 and sx>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setClDay(dcl);
		
		//当日人民币
		sql = "SELECT max(output) from t_hn_detail where time='"+date+"' and xz=0 and online=1";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setClDayRmb(dcl);
		//当日外汇
		sql = "SELECT max(clwh) from t_hn_new where date='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setClDayWh(dcl);
		//当日稽核
		sql = "SELECT max(cljh) from t_hn_new where date='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setClDayJh(dcl);
		//当日审核
		sql = "SELECT max(clsh) from t_hn_new where date='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setClDaySh(dcl);
		//当日建亚
		sql = "SELECT max(cljy) from t_hn_new where date='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setClDayJy(dcl);
		//当日反洗钱
		sql = "SELECT max(clfxq) from t_hn_new where date='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setClDayFxq(dcl);
		/*总行当月任务量*/
		
		
		/*总行当日作业差错率*/
		//当日差错
		sql = "SELECT max(ccl) from t_hn_new where date='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setZycclDay(dcl);
		
		/*总行当月日均作业差错率*/
		sql = "SELECT max(rjccl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_max.setZycclAver(dcl);
		
		/*总行当日作业退票率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0')";
		lv=dao.countMaxd("(tp891+tp895)/(ywl891+ywl895)", "t_hn_detail_temp", sql);
		summary_max.setZytplDay(lv);
		/*总行当月作业退票率*/
		sql="where time='"+date+"' and ljsxts>0 and no in (select no891 from t_no where xz='0')";
		lv=dao.countMaxd("(ljtp891+ljtp895)/(ljywl891+ljywl895)", "t_hn_detail_temp", sql);
		summary_max.setZytplAver(lv);
		
		/*总行当日作业查询率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0')";
		lv=dao.countMaxd("(cx891+cx895)/(ywl891+ywl895)", "t_hn_detail_temp", sql);
		summary_max.setZycxlDay(lv);
		/*总行当月作业查询率*/
		sql="where time='"+date+"' and ljsxts>0 and no in (select no891 from t_no where xz='0')";
		lv=dao.countMaxd("(ljcx891+ljcx895)/(ljywl891+ljywl895)", "t_hn_detail_temp", sql);
		summary_max.setZycxlAver(lv);
		
		
		/*总行当日转网点率*/	
		sql="where time='"+date+"' and xz='0' and online=1";
		lv=dao.countMaxd("qdlrzl", "t_hn_detail", sql);
		summary_max.setZwd(lv);
		/*总行当月转网点率*/	
		sql="where time='"+date+"' and xz='0' and ljsxts>0";
		lv=dao.countMaxd("ljqdlrzl", "t_hn_detail", sql);
		summary_max.setLjzwd(lv);
		summary_max.setDate(date);
		dao.save(summary_max);
		
		/******************************************总行最小值**************************************/
		summary_min.setJg("总行");
		summary_min.setType("最小");
		//日均
		sql = "SELECT min(rjcl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and xz=0 and sx=1";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setClAver(dcl);
		
		//当日
		sql = "SELECT min(cl) from t_hn_new where date='"+date+"' and sx>0 and xz=0 ";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setClDay(dcl);
		
		//当日人民币
		sql = "SELECT min(output) from t_hn_detail where time='"+date+"' and online=1 and xz=0 and output>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setClDayRmb(dcl);
		//当日外汇
		sql = "SELECT min(clwh) from t_hn_new where date='"+date+"' and sxwh>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setClDayWh(dcl);
		//当日稽核
		sql = "SELECT min(cljh) from t_hn_new where date='"+date+"' and sxjh>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setClDayJh(dcl);
		//当日审核
		sql = "SELECT min(clsh) from t_hn_new where date='"+date+"' and sxsh>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setClDaySh(dcl);
		//当日建亚
		sql = "SELECT min(cljy) from t_hn_new where date='"+date+"' and sxjy>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setClDayJy(dcl);
		//当日反洗钱
		sql = "SELECT min(clfxq) from t_hn_new where date='"+date+"' and sxfxq>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setClDayFxq(dcl);
		/*总行当月任务量*/
		
		
		/*总行当日作业差错率*/
		//当日差错
		sql = "SELECT min(ccl) from t_hn_new where date='"+date+"' and sx>0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setZycclDay(dcl);
		
		/*总行当月日均作业差错率*/
		sql = "SELECT min(rjccl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and sx>0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		summary_min.setZycclAver(dcl);
		
		
		/*总行当日作业退票率*/
		sql="where time='"+date+"' and no in (select no from t_hn_detail_ls where time='"+date+"' and online=1 and xz='0')";
		lv=dao.countMind("(tp891+tp895)/(ywl891+ywl895)", "t_hn_detail_temp", sql);
		summary_min.setZytplDay(lv);
		/*总行当月作业退票率*/
		sql="where time='"+date+"' and no in (select no from t_hn_detail_ls where time='"+date+"' and ljsxts>0 and xz='0')";
		lv=dao.countMind("(ljtp891+ljtp895)/(ljywl891+ljywl895)", "t_hn_detail_temp", sql);
		summary_min.setZytplAver(lv);
		
		/*总行当日作业查询率*/
		sql="where time='"+date+"' and no in (select no from t_hn_detail_ls where time='"+date+"' and online=1 and xz='0')";
		lv=dao.countMind("(cx891+cx895)/(ywl891+ywl895)", "t_hn_detail_temp", sql);
		summary_min.setZycxlDay(lv);
		/*总行当月作业查询率*/
		sql="where time='"+date+"' and no in (select no from t_hn_detail_ls where time='"+date+"' and ljsxts>0 and xz='0')";
		lv=dao.countMind("(ljcx891+ljcx895)/(ljywl891+ljywl895)", "t_hn_detail_temp", sql);
		summary_min.setZycxlAver(lv);
		
		/*总行当日转网点率*/	
		sql="where time='"+date+"' and xz='0'  and online=1 and qdlr>0";
		lv=dao.countMind("qdlrzl", "t_hn_detail", sql);
		summary_min.setZwd(lv);
		/*总行当月转网点率*/	
		sql="where time='"+date+"' and xz='0' and ljsxts>0 and ljqdlr>0";
		lv=dao.countMind("ljqdlrzl", "t_hn_detail", sql);
		summary_min.setLjzwd(lv);
		
		summary_min.setDate(date);
		dao.save(summary_min);
		
		/*******************************************成都平均*******************************************/
		/*平均值*/	
		cd_aver.setJg("成都");
		cd_aver.setType("平均");
		
		//日均 
		sql = "SELECT sum(cl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and zx=0 and xz=0 and sx=1";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sx) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and zx=0 and xz=0 and sx=1";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setClAver(check.DoubleTo0(check.division(dcl, sxts)));
		
		//当日
		sql = "SELECT sum(cl) from t_hn_new where date='"+date+"' and zx=0 and xz=0 and sx=1";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sx) from t_hn_new where date='"+date+"' and zx=0 and xz=0 and sx=1";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setClDay(check.DoubleTo0(check.division(dcl, sxts)));
		
		//当日人民币
		sql = "SELECT sum(output) from t_hn_detail where time='"+date+"' and zx=0 and xz=0 and online=1 and output>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(online) from t_hn_detail where time='"+date+"' and zx=0 and xz=0 and online=1 and output>0";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setClDayRmb(check.DoubleTo0(check.division(dcl, sxts)));
		//当日外汇
		sql = "SELECT sum(clwh) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxwh) from t_hn_new where date='"+date+"' and zx=0";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setClDayWh(check.DoubleTo0(check.division(dcl, sxts)));
		//当日稽核
		sql = "SELECT sum(cljh) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxjh) from t_hn_new where date='"+date+"' and zx=0";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setClDayJh(check.DoubleTo0(check.division(dcl, sxts)));
		//当日审核
		sql = "SELECT sum(clsh) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxsh) from t_hn_new where date='"+date+"' and zx=0";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setClDaySh(check.DoubleTo0(check.division(dcl, sxts)));
		//当日建亚
		sql = "SELECT sum(cljy) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxjy) from t_hn_new where date='"+date+"' and zx=0";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setClDayJy(check.DoubleTo0(check.division(dcl, sxts)));
		//当日反洗钱
		sql = "SELECT sum(clfxq) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(sxfxq) from t_hn_new where date='"+date+"' and zx=0";
		sxts=check.IsNullInteger(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setClDayFxq(check.DoubleTo0(check.division(dcl, sxts)));
		/*总行当月任务量*/
		
		
		/*总行当日作业差错率*/
		//当日差错
		sql = "SELECT sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz) from t_hn_new where date='"+date+"' and zx=0 and xz=0 and sx=1";
		dcc=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) from t_hn_new where date='"+date+"' and zx=0 and xz=0 and sx=1";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setZycclDay(check.DoubleTo4(check.division(dcc, dcl)));
		
		/*总行当月日均作业差错率*/
		sql = "SELECT sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and zx=0 and xz=0";
		dcc=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_aver.setZycclAver(check.DoubleTo4(check.division(dcc, dcl)));
		
		
		/*成都当日作业退票率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0' and zx='0')";
		all_cc=dao.countColumn("tp891+tp895", "t_hn_detail_temp", sql);
		all_cl=dao.countColumn("ywl891+ywl895", "t_hn_detail_temp", sql);
		cd_aver.setZytplDay(check.DoubleTo4(check.division(all_cc,all_cl)));
		
		/*成都当月日均作业退票率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0' and zx='0')";
		all_cc=dao.countColumn("ljtp891+ljtp895", "t_hn_detail_temp", sql);
		all_cl=dao.countColumn("ljywl891+ljywl895", "t_hn_detail_temp", sql);
		cd_aver.setZytplAver(check.DoubleTo4(check.division(all_cc,all_cl)));
		
		/*成都当日作业查询率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0' and zx='0')";
		all_cc=dao.countColumn("cx891+cx895", "t_hn_detail_temp", sql);
		all_cl=dao.countColumn("ywl891+ywl895", "t_hn_detail_temp", sql);
		cd_aver.setZycxlDay(check.DoubleTo4(check.division(all_cc,all_cl)));
		
		/*成都当月日均作业查询率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0' and zx='0')";
		all_cc=dao.countColumn("ljcx891+ljcx895", "t_hn_detail_temp", sql);
		all_cl=dao.countColumn("ljywl891+ljywl895", "t_hn_detail_temp", sql);
		cd_aver.setZycxlAver(check.DoubleTo4(check.division(all_cc,all_cl)));
		
		
		/*成都当日转网点率*/	
		sql="where time='"+date+"' and xz='0' and zx='0' and zx='0'";
		all_cc=dao.countColumn("qdlrz", "t_hn_detail", sql);
		all_cl=dao.countColumn("qdlr", "t_hn_detail", sql);
		cd_aver.setZwd(check.DoubleTo4(check.division(all_cc, all_cl)));
		/*成都当月转网点率*/	
		sql="where time='"+date+"' and xz='0' and zx='0' and zx='0'";
		all_cc=dao.countColumn("ljqdlrz", "t_hn_detail", sql);
		all_cl=dao.countColumn("ljqdlr", "t_hn_detail", sql);
		cd_aver.setLjzwd(check.DoubleTo4(check.division(all_cc, all_cl)));
		
		cd_aver.setDate(date);
		dao.save(cd_aver);
		
		/*******************************************成都最大值*******************************************/
		cd_max.setJg("成都");
		cd_max.setType("最大");
		//日均
		sql = "SELECT max(rjcl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setClAver(dcl);
		
		//当日
		sql = "SELECT max(cl) from t_hn_new where date='"+date+"' and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setClDay(dcl);
		
		//当日人民币
		sql = "SELECT max(output) from t_hn_detail where time='"+date+"' and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setClDayRmb(dcl);
		//当日外汇
		sql = "SELECT max(clwh) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setClDayWh(dcl);
		//当日稽核
		sql = "SELECT max(cljh) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setClDayJh(dcl);
		//当日审核
		sql = "SELECT max(clsh) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setClDaySh(dcl);
		//当日建亚
		sql = "SELECT max(cljy) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setClDayJy(dcl);
		//当日反洗钱
		sql = "SELECT max(clfxq) from t_hn_new where date='"+date+"' and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setClDayFxq(dcl);
		/*总行当月任务量*/
		
		
		/*总行当日作业差错率*/
		//当日差错
		sql = "SELECT max(ccl) from t_hn_new where date='"+date+"' and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setZycclDay(dcl);
		
		/*总行当月日均作业差错率*/
		sql = "SELECT max(rjccl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_max.setZycclAver(dcl);
		
		/*成都当日作业退票率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0' and zx='0')";
		lv=dao.countMaxd("(tp891+tp895)/(ywl891+ywl895)", "t_hn_detail_temp", sql);
		cd_max.setZytplDay(lv);
		/*成都当月作业退票率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0' and zx='0')";
		lv=dao.countMaxd("(ljtp891+ljtp895)/(ljywl891+ljywl895)", "t_hn_detail_temp", sql);
		cd_max.setZytplAver(lv);
		
		/*成都当日作业查询率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0' and zx='0')";
		lv=dao.countMaxd("(cx891+cx895)/(ywl891+ywl895)", "t_hn_detail_temp", sql);
		cd_max.setZycxlDay(lv);
		/*成都当月作业查询率*/
		sql="where time='"+date+"' and no in (select no891 from t_no where xz='0' and zx='0')";
		lv=dao.countMaxd("(ljcx891+ljcx895)/(ljywl891+ljywl895)", "t_hn_detail_temp", sql);
		cd_max.setZycxlAver(lv);
		
		/*成都当日转网点率*/	
		sql="where time='"+date+"' and xz='0' and zx='0' and online=1";
		lv=dao.countMaxd("qdlrzl", "t_hn_detail", sql);
		cd_max.setZwd(lv);
		/*成都当月转网点率*/	
		sql="where time='"+date+"' and xz='0' and zx='0' and ljsxts>0";
		lv=dao.countMaxd("ljqdlrzl", "t_hn_detail", sql);
		cd_max.setLjzwd(lv);
		cd_max.setDate(date);
		dao.save(cd_max);
		
		/*******************************************成都最小值*******************************************/
		cd_min.setJg("成都");
		cd_min.setType("最小");
		//日均
		sql = "SELECT min(rjcl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and xz=0 and zx=0 and sx=1";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setClAver(dcl);
		
		//当日
		sql = "SELECT min(cl) from t_hn_new where date='"+date+"' and sx>0 and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setClDay(dcl);
		
		//当日人民币
		sql = "SELECT min(output) from t_hn_detail where time='"+date+"' and online>0 and zx=0 and xz=0 and output>0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setClDayRmb(dcl);
		//当日外汇
		sql = "SELECT min(clwh) from t_hn_new where date='"+date+"' and sxwh>0 and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setClDayWh(dcl);
		//当日稽核
		sql = "SELECT min(cljh) from t_hn_new where date='"+date+"' and sxjh>0 and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setClDayJh(dcl);
		//当日审核
		sql = "SELECT min(clsh) from t_hn_new where date='"+date+"' and sxsh>0 and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setClDaySh(dcl);
		//当日建亚
		sql = "SELECT min(cljy) from t_hn_new where date='"+date+"' and sxjy>0 and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setClDayJy(dcl);
		//当日反洗钱
		sql = "SELECT min(clfxq) from t_hn_new where date='"+date+"' and sxfxq>0 and zx=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setClDayFxq(dcl);
		/*总行当月任务量*/
		
		
		/*总行当日作业差错率*/
		//当日差错
		sql = "SELECT min(ccl) from t_hn_new where date='"+date+"' and sx>0 and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setZycclDay(dcl);
		
		/*总行当月日均作业差错率*/
		sql = "SELECT min(rjccl) from t_hn_new where date>='"+bdate+"' and date<='"+date+"' and sx>0 and zx=0 and xz=0";
		dcl=check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		cd_min.setZycclAver(dcl);
		
		/*成都当日作业退票率*/
		sql="where time='"+date+"' and no in (select no from t_hn_detail_ls where time='"+date+"' and online=1 and xz='0' and zx='0')";
		lv=dao.countMind("(tp891+tp895)/(ywl891+ywl895)", "t_hn_detail_temp", sql);
		cd_min.setZytplDay(lv);
		/*成都当月作业退票率*/
		sql="where time='"+date+"' and no in (select no from t_hn_detail_ls where time='"+date+"' and ljsxts>0 and xz='0' and zx='0')";
		lv=dao.countMind("(ljtp891+ljtp895)/(ljywl891+ljywl895)", "t_hn_detail_temp", sql);
		cd_min.setZytplAver(lv);
		
		/*成都当日作业查询率*/
		sql="where time='"+date+"' and no in (select no from t_hn_detail_ls where time='"+date+"' and online=1 and xz='0' and zx='0')";
		lv=dao.countMind("(cx891+cx895)/(ywl891+ywl895)", "t_hn_detail_temp", sql);
		cd_min.setZycxlDay(lv);
		/*成都当月作业查询率*/
		sql="where time='"+date+"' and no in (select no from t_hn_detail_ls where time='"+date+"' and ljsxts>0 and xz='0' and zx='0')";
		lv=dao.countMind("(ljcx891+ljcx895)/(ljywl891+ljywl895)", "t_hn_detail_temp", sql);
		cd_min.setZycxlAver(lv);
		
		
		/*成都当日转网点率*/	
		sql="where time='"+date+"' and xz='0' and zx='0'  and online=1 and qdlr>0";
		lv=dao.countMind("qdlrzl", "t_hn_detail", sql);
		cd_min.setZwd(lv);
		/*成都当月转网点率*/	
		sql="where time='"+date+"' and xz='0' and zx='0' and ljsxts>0 and ljqdlr>0";
		lv=dao.countMind("ljqdlrzl", "t_hn_detail", sql);
		cd_min.setLjzwd(lv);
		
		cd_min.setDate(date);
		dao.save(cd_min);
		
		} catch (RuntimeException re) {
			re.printStackTrace();
			logger.error(re.toString());
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
				
		return result;
	}
	/*更新数据加工情况表*/
	public String updateStatus(String date)
	{
		String result="";
		String sql="";
		DailyStatus status=new DailyStatus();
		DailyStatusDAO dao =new DailyStatusDAO();
		int i=0;
		String tmp="";
		date=date.replaceAll("-", "");
		status=dao.findByTime(date);
		
		if(status==null||status.equals(null))
		{
			status.setTime(date);
			status.setHnSummaryQuick(1);
			
		}
		else
		{
			if(status.getHnSummaryQuick()==null||status.getHnSummaryQuick().equals(null))
				i=1;
			else
				i=status.getHnSummaryQuick()+1;
			status.setHnSummaryQuick(i);
			status.setTime(date);
		}
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		dao.merge(status);
		 trans.commit();
         session.flush();
         session.clear();
         session.close();
		return result;
	}
	/*删除表*/
	public void DelTable(String table,String date)
	{
		Session session = HibernateSessionFactory.getSession();
	    
	    Transaction trans = null;
	    
	    try
		{
			 trans=session.beginTransaction();
			 String sqldel = "delete from "+table+" where date='"+date+"'";
			 session.createSQLQuery(sqldel).executeUpdate();
		}catch (Exception e) {
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
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
}