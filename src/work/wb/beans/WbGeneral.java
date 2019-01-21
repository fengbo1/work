package work.wb.beans;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import work.daily.dao.DailyStatusDAO;
import work.daily.pojo.DailyStatus;
import work.hndetail.dao.HnDetailDAO;
import work.hndetail.pojo.HnDetail;
import work.util.GeneralCheck;
import work.wb.dao.WbFzyyDAO;
import work.wb.dao.WbLrzcDAO;
import work.wb.dao.WbYslrDAO;
import work.wb.pojo.CorpCode;
import work.wb.pojo.WbFzyy;
import work.wb.pojo.WbLrzc;
import work.wb.pojo.WbYslr;
import ccb.hibernate.HibernateSessionFactory;

public class WbGeneral {

	private String date;//时间
	private String key;//关键字名称
	private List list;
	private String message;
	private static Logger logger = Logger.getLogger(BaseData.class);

/*生成外包日报表数据,生成完成后清理离场外包数据*/	
   public String execute() throws Exception
   {
	   String yslr="";
	   String lrzc="";
	   String fzyy="";
	   String result="success";
	   yslr=YslrDaily();
	   lrzc=LrzcDaily();
	   fzyy=FzyyDaily();
	   if(yslr.equals("success")&&lrzc.equals("success")&&fzyy.equals("success"))
	   {
		   result="success";
		   
	   }
	   updateStatus();
	   ClearWb();
	   truncate("t_wb_base");
	   message = "外包加工完毕!";
	   return result;
   }
   /*要素录入日报表*/
   public String YslrDaily() throws Exception
   {
	  int ywl=0;
	  String sql="";
	  String corpsql="";
	  ArrayList<CorpCode> corplist;
	  Query query;
	  Transaction trans = null;
	  String result="success";
	  date=date.replaceAll("-", "");
	  corplist=new ArrayList<CorpCode>();
	  Session session = HibernateSessionFactory.getSession();
	  double worktime=0;
	  GeneralCheck check =new GeneralCheck();
	  WbYslr yslr = new WbYslr();
	  try 
	  {
		 trans=session.beginTransaction();
		 String sqldel = "delete from t_wb_yslr where date='"+date+"'";
		 session.createSQLQuery(sqldel).executeUpdate();
		 /*总在线人数*/
		 String sqlsum="select count(*) from t_wb_base " +
	 			" as w where w.date='"+date+"'  and w.yslr>10 and w.lrzc<=10 and w.fzyy<=10 ";
 		 query=session.createSQLQuery(sqlsum);
		 Object objtmp=(Object)query.uniqueResult();
		 int online=check.IsNullInteger(objtmp);
		 yslr.setOnline(online);
		 /*总在线人数--不剔除*/
		 sqlsum="select count(*) from t_wb_base " +
	 			" as w where w.date='"+date+"'  and w.yslr>10 and w.lrzc<=10 and w.fzyy<=10 ";
 		 query=session.createSQLQuery(sqlsum);
		 objtmp=(Object)query.uniqueResult();
		 int online_all=check.IsNullInteger(objtmp);
		 yslr.setOnline(online);
		 /*剔除后的业务量*/
		 String sqltmp="select sum(yslr) from t_wb_base " +
		 " as w where w.date='"+date+"'  and w.yslr>10 and w.lrzc<=10 and w.fzyy<=10  ";
		 query=session.createSQLQuery(sqltmp);
		 objtmp=(Object)query.uniqueResult();
		 int ywl_tc=check.IsNullInteger(objtmp);
	 	
		/*计算合计行单笔时长、录入占比、录入差错、录入回收、录入量*/
	 	 WbYslrDAO dao=new WbYslrDAO();
		 sql="select sum(yslr), sum(yslr_cc),sum(yslr_hs),cast(sum(yslr_time*yslr)/sum(yslr) AS DECIMAL(18,2)) from t_wb_base " +
			" as w where w.date='"+date+"' ";
		 query=session.createSQLQuery(sql);
		 List listall=query.list();
		 if(!listall.get(0).equals(null)&&online_all>0)
		 {
		    	
		    Object[] obj = (Object[])listall.get(0);
		    String str=obj[0].toString();
		    ywl=Integer.parseInt(str);
		    yslr.setCl(ywl);
		    yslr.setCc(check.IsNullDouble(obj[1]));
		    yslr.setHs(check.IsNullDouble(obj[2]));
		 	yslr.setAvertime(check.IsNullDouble(obj[3]));
			yslr.setOnlineZb(1.0);
		    yslr.setClZb(1.0);
		    yslr.setCcl(check.DoubleTo4(check.division(yslr.getCc(), yslr.getCl())));
		    yslr.setHsl(check.DoubleTo4(check.division(yslr.getHs(), yslr.getCl())));
		    /*人均切片量：剔除后的总业务量除以剔除后的人数*/
		    yslr.setAvevCl(check.DoubleTo0(check.division(ywl_tc,online)));
		    /*总的平均作业时长*/
		    sql="select sum(yslr*yslr_time) from t_wb_base " +
		    	" as w where w.date='"+date+"'  and w.yslr>10 and lrzc<=10 and fzyy<=10";
		    query=session.createSQLQuery(sql);
		    objtmp=query.uniqueResult();
		    worktime=check.DoubleTo2(check.division(check.IsNullDouble(objtmp),3600*online));
		    System.out.println("worktime:"+worktime);
		    /*有效工作时长大于平均值占比*/
		    String sqlabove="select count(*) from t_wb_base where  date='"+date+"' and work_yslr>'"+worktime+"' and yslr>10 and lrzc<=10 and fzyy<=10";
		    query=session.createSQLQuery(sqlabove);
		    objtmp=(Object)query.uniqueResult();
		    yslr.setAboveTime(check.IsNullInteger(objtmp));
		    yslr.setAboveTimezb(check.DoubleTo4(check.division(yslr.getAboveTime(), online)));
		    /*2520片以上人员占比*/
		    sqlabove="select count(*) from t_wb_base where  date='"+date+"' and yslr>2520 and fzyy<=10 and lrzc<=10";
			query=session.createSQLQuery(sqlabove);
			objtmp=(Object)query.uniqueResult();
			yslr.setAboveNum(check.IsNullInteger(objtmp));
			yslr.setAboveZb(check.DoubleTo4(check.division(yslr.getAboveNum(), online)));
			}else{
			    yslr.setCl(0);
			}
			yslr.setDate(date);
			yslr.setCorpname("合计");
			    
     		dao.save(yslr);
		    
		    
		    /*按公司计算*/
     		corpsql="from CorpCode";
     		query=session.createQuery(corpsql);
     		corplist=(ArrayList<CorpCode>) query.list();
		
     		for(int i=0;i<corplist.size();i++)
     		{
     			yslr=new WbYslr();
     			/*上线人数--剔除同时做要素录入和辅助验印的人数*/
     			sql="select count(*) from t_wb_base " +
     			" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' and w.yslr>10 and w.lrzc<=10 and w.fzyy<=10   ";
     			query=session.createSQLQuery(sql);
     			objtmp=(Object)query.uniqueResult();
     			int corponline=check.IsNullInteger(objtmp);
     			yslr.setOnline(corponline);
     			sql="select count(*) from t_wb_base " +
     			" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' ";
     			query=session.createSQLQuery(sql);
     			objtmp=(Object)query.uniqueResult();
     			int corponline_all=check.IsNullInteger(objtmp);
     			
     			if(corponline_all>0)
     			{
     				/*人均切片量--剔除同时做要素录入和辅助验印的人数*/
     				sql="select sum(yslr)/count(*) from t_wb_base " +
     				" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' and w.yslr>10 and w.lrzc<=10 and w.fzyy<=10   ";
     				query=session.createSQLQuery(sql);
     				objtmp=(Object)query.uniqueResult();
     				double avercl=check.DoubleTo0(check.IsNullDouble(objtmp));
     				yslr.setAvevCl(avercl);
     				/*计算单笔时长、录入占比、录入差错、录入回收、录入量*/
     				sql="select sum(yslr), sum(yslr_cc),sum(yslr_hs),cast(sum(yslr_time*yslr)/sum(yslr) AS DECIMAL(18,2)) from t_wb_base " +
     				" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' ";
     				query=session.createSQLQuery(sql);
     				List list=query.list();
     				
			    	Object[] obj = (Object[])list.get(0);
			    	
			    	yslr.setCl(check.IsNullInteger(obj[0]));
					yslr.setCc(check.IsNullDouble(obj[1]));
					yslr.setHs(check.IsNullDouble(obj[2]));
					yslr.setAvertime(check.IsNullDouble(obj[3]));
								    
					 /*有效工作时长大于平均值占比*/
					String sqlabove="select count(*) from t_wb_base where date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' and work_yslr>'"+worktime+"' and yslr>10 and lrzc<=10 and fzyy<=10 ";
				    query=session.createSQLQuery(sqlabove);
				    objtmp=(Object)query.uniqueResult();
				    int above=Integer.parseInt(objtmp.toString());
					yslr.setAboveTime(above);
					yslr.setAboveTimezb(check.DoubleTo4(check.division(above, yslr.getOnline())));
					/*2520片以上人员占比*/
					sqlabove="select count(*) from t_wb_base where date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' and yslr>2520 and fzyy<=10 and lrzc<=10";
					query=session.createSQLQuery(sqlabove);
					objtmp=(Object)query.uniqueResult();
				    above=Integer.parseInt(objtmp.toString());
					yslr.setAboveNum(above);
					yslr.setAboveZb(check.DoubleTo4(check.division(above, yslr.getOnline())));
					yslr.setOnlineZb(check.DoubleTo4(check.division(yslr.getOnline(),online)));
					yslr.setClZb(check.DoubleTo4(check.division(yslr.getCl(),ywl)));
					yslr.setCcl(check.DoubleTo4(check.division(yslr.getCc(), yslr.getCl())));
					yslr.setHsl(check.DoubleTo4(check.division(yslr.getHs(), yslr.getCl())));
    			}else
     			{
     				yslr.setCl(0);
     				
     			}
     			
     			yslr.setCorpname(corplist.get(i).getName());
     			yslr.setCorpcode(corplist.get(i).getNo());
     			yslr.setDate(date);
     			dao.save(yslr);
     		}
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
	   return result;
   }

   /*录入仲裁日报表*/
   public String LrzcDaily() throws Exception
   {
	   String sql="";
	   String corpsql="";
	   ArrayList<CorpCode> corplist;
	   Query query;
	   Transaction trans = null;
	   String result="success";
	   date=date.replaceAll("-", "");
	   corplist=new ArrayList<CorpCode>();
	   Session session = HibernateSessionFactory.getSession();
	   WbLrzcDAO dao=new WbLrzcDAO();
	   GeneralCheck check =new GeneralCheck();
	   WbLrzc lrzc = new WbLrzc();
	   int ywl=0;
	   int ywl_tc=0;
	   int corponline=0;
	   try 
	   {
		
		   trans=session.beginTransaction();
		   String sqldel = "delete from t_wb_lrzc where date='"+date+"'";
		   session.createSQLQuery(sqldel).executeUpdate();
		   /*总在线人数--剔除小于10笔*/
		   String sqlsum="select count(*) from t_wb_base " +
				" as w where w.date='"+date+"'  and  w.lrzc>10 ";
		   query=session.createSQLQuery(sqlsum);
		   Object objtmp=(Object)query.uniqueResult();
		   int online=check.IsNullInteger(objtmp);
		   lrzc.setOnline(online);
		   /*总在线人数--不剔除小于10笔*/
		  sqlsum="select count(*) from t_wb_base " +
				" as w where w.date='"+date+"'  ";
		   query=session.createSQLQuery(sqlsum);
		   objtmp=(Object)query.uniqueResult();
		   int online_all=check.IsNullInteger(objtmp);
		   
		   /*总业务量--剔除*/
		   String sqltmp="select sum(lrzc) as sum from t_wb_base " +
		   	" as w where w.date='"+date+"' and  w.lrzc>10 ";
		   query=session.createSQLQuery(sqltmp);
		   objtmp=(Object)query.uniqueResult();
		   ywl_tc=check.IsNullInteger(objtmp);
		   /*总业务量*/
		   sqltmp="select sum(lrzc) as sum from t_wb_base " +
		   	" as w where w.date='"+date+"'";
		   query=session.createSQLQuery(sqltmp);
		   objtmp=(Object)query.uniqueResult();
		   ywl=check.IsNullInteger(objtmp);	   
		   /*计算合计行单笔时长、录入占比、录入差错、录入回收、录入量*/
		   sql="select sum(lrzc), sum(lrzc_cc),sum(lrzc_hs),cast(sum(lrzc_time*lrzc)/sum(lrzc) AS DECIMAL(18,2)) from t_wb_base " +
			" as w where w.date='"+date+"' ";
		   query=session.createSQLQuery(sql);
		   List listall=query.list();
		   if(!listall.get(0).equals(null))
		   {
			 
			  Object[] obj = (Object[])listall.get(0);
			  String str=obj[3].toString();
			  if(online_all>0)
			  {
				 str=obj[0].toString();
				 int tmp=Integer.parseInt(str);
				 lrzc.setCl(tmp);
				 lrzc.setCc(check.IsNullDouble(obj[1]));
				 lrzc.setHs(check.IsNullDouble(obj[2]));
				 lrzc.setAvertime(check.IsNullDouble(obj[3]));
				 lrzc.setOnlineZb(1.0);
				 lrzc.setClZb(1.0);
				 lrzc.setCcl(check.DoubleTo4(check.division(lrzc.getCc(), lrzc.getCl())));
				 lrzc.setHsl(check.DoubleTo4(check.division(lrzc.getHs(), lrzc.getCl())));
				 lrzc.setAvevCl(check.DoubleTo0(check.division(ywl_tc,lrzc.getOnline())));
				 
			}else
			{
				lrzc.setCl(0);
			}
			lrzc.setCorpname("合计");
			lrzc.setDate(date); 
		    dao.save(lrzc);
		}
		    
		/*按公司计算*/
		
		corpsql="from CorpCode where status='0'";
		query=session.createQuery(corpsql);
		corplist=(ArrayList<CorpCode>) query.list();
		for(int i=0;i<corplist.size();i++)
		{
			lrzc=new WbLrzc();
			
 			/*上线人数--剔除小于10笔人数*/
 			sql="select count(*) from t_wb_base " +
 			" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' and w.lrzc>10 ";
 			query=session.createSQLQuery(sql);
 			objtmp=(Object)query.uniqueResult();
 			corponline=check.IsNullInteger(objtmp);
 			lrzc.setOnline(corponline);
 			/*上线人数--不剔除小于10笔人数*/
 			sql="select count(*) from t_wb_base " +
 			" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"'  ";
 			query=session.createSQLQuery(sql);
 			objtmp=(Object)query.uniqueResult();
 			int corponline_all=check.IsNullInteger(objtmp);
 			
 			/*总业务量--剔除*/
 		    sqltmp="select sum(lrzc) as sum from t_wb_base " +
 		   	" as w where w.date='"+date+"'and substr(no,1,3)='"+corplist.get(i).getNo()+"'  and  w.lrzc>10 ";
 		    query=session.createSQLQuery(sqltmp);
 		    objtmp=(Object)query.uniqueResult();
 		    ywl_tc=check.IsNullInteger(objtmp);
 			/*录入量、录入差错、录入回收、单笔时长--不剔除小于10笔*/
			sql="select sum(lrzc), sum(lrzc_cc),sum(lrzc_hs),cast(sum(lrzc_time*lrzc)/sum(lrzc) AS DECIMAL(18,2)) from t_wb_base " +
				" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' ";
		    query=session.createSQLQuery(sql);
		    List list=query.list();
		    if(!list.get(0).equals(null))
		    {
		    	
		    	Object[] obj = (Object[])list.get(0);
		    	String str="";
				
				if(corponline_all>0)
				{
					 str=obj[0].toString();
				     int tmp=Integer.parseInt(str);
				     lrzc.setCl(tmp);
					 lrzc.setCc(check.IsNullDouble(obj[1]));
					 lrzc.setHs(check.IsNullDouble(obj[2]));
					 lrzc.setAvertime(check.IsNullDouble(obj[3]));
					 lrzc.setOnlineZb(check.DoubleTo4(check.division(lrzc.getOnline(),online)));
			         lrzc.setClZb(check.DoubleTo4(check.division(lrzc.getCl(),ywl)));
				     lrzc.setCcl(check.DoubleTo4(check.division(lrzc.getCc(), lrzc.getCl())));
				     lrzc.setHsl(check.DoubleTo4(check.division(lrzc.getHs(), lrzc.getCl())));
				     lrzc.setAvevCl(check.DoubleTo0(check.division(ywl_tc,lrzc.getOnline())));
				}else
				{
				    lrzc.setCl(0);
			        lrzc.setCc(0.0);
			        lrzc.setHs(0.0);
			     	lrzc.setAvertime(0.0);
				    lrzc.setOnlineZb(0.0);
		            lrzc.setClZb(0.0);
			        lrzc.setCcl(0.0);
			        lrzc.setHsl(0.0);
			        lrzc.setAvevCl(0.0);
					
				}
				lrzc.setCorpname(corplist.get(i).getName());
				lrzc.setCorpcode(corplist.get(i).getNo());
				lrzc.setDate(date);
			    dao.save(lrzc);
		    }
		}
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
	return result;
}

   /*辅助验印日报表*/
   public String FzyyDaily() throws Exception
   {
	  int online;
	  int ywl;
	  String sql="";
	  String corpsql="";
	  String sqldel="";
	  String sqlsum="";
	  String str="";
	  ArrayList<CorpCode> corplist;
	  Query query;
	  Transaction trans = null;
	  String result="success";
	  date=date.replaceAll("-", "");
	  corplist=new ArrayList<CorpCode>();
	  Session session = HibernateSessionFactory.getSession();
	  WbFzyyDAO dao=new WbFzyyDAO();
	  GeneralCheck check =new GeneralCheck();
	  WbFzyy fzyy = new WbFzyy();
	  int corponline=0;
	  int ywl_tc=0;
	  try 
	  {
		 fzyy = new WbFzyy();
		 trans=session.beginTransaction();
		 sqldel = "delete from t_wb_fzyy where date='"+date+"'";
		 session.createSQLQuery(sqldel).executeUpdate();
		 /*总在线人数*/
		 sqlsum="select count(*) from t_wb_base " +
		 " as w where w.date='"+date+"'  and  w.fzyy>10 ";
		 query=session.createSQLQuery(sqlsum);
		 Object objtmp=(Object)query.uniqueResult();
		 online=check.IsNullInteger(objtmp);
		 fzyy.setOnline(online);
		 /*总在线人数--不剔除小于10笔*/
		 sqlsum="select count(*) from t_wb_base " +
		 " as w where w.date='"+date+"' ";
		 query=session.createSQLQuery(sqlsum);
		 objtmp=(Object)query.uniqueResult();
		 int online_all=check.IsNullInteger(objtmp);
		 
		 /*总业务量--剔除*/
		 String sqltmp="select sum(fzyy) from t_wb_base " +
		 " as w where w.date='"+date+"' and  w.fzyy>10";
		 query=session.createSQLQuery(sqltmp);
		 objtmp=(Object)query.uniqueResult();
		 ywl_tc=check.IsNullInteger(objtmp);
		 /*总业务量*/
		 sqltmp="select sum(fzyy) from t_wb_base " +
		 " as w where w.date='"+date+"'";
		 query=session.createSQLQuery(sqltmp);
		 objtmp=(Object)query.uniqueResult();
		 ywl=check.IsNullInteger(objtmp);
		 /*计算合计*/
		 sql="select sum(fzyy), sum(fzyy_cc),sum(fzyy_hs),cast(sum(fzyy_time*fzyy)/sum(fzyy) AS DECIMAL(18,2)) from t_wb_base " +
		 	" as w where w.date='"+date+"' ";
		 query=session.createSQLQuery(sql);
		 List listall=query.list();
		 if(!listall.get(0).equals(null))
		 {
			 
			 Object[] obj = (Object[])listall.get(0);
			 		 
			 if(online_all>0)
			 {
				 str=obj[0].toString();
				 int tmp=Integer.parseInt(str);
				 fzyy.setCl(tmp);
				 fzyy.setCc(check.IsNullDouble(obj[1]));
				 fzyy.setHs(check.IsNullDouble(obj[2]));
				 fzyy.setAvertime(check.IsNullDouble(obj[3]));
				 fzyy.setOnlineZb(1.0);
				 fzyy.setClZb(1.0);
				 fzyy.setCcl(check.DoubleTo4(check.division(fzyy.getCc(), fzyy.getCl())));
				 fzyy.setHsl(check.DoubleTo4(check.division(fzyy.getHs(), fzyy.getCl())));
				 fzyy.setAvevCl(check.DoubleTo0(check.division(ywl_tc,fzyy.getOnline())));
		    }	
		    else
		    {
		    	fzyy.setCl(0);
		    	
		    }
		    fzyy.setCorpname("合计");
		    fzyy.setDate(date);		
		    dao.save(fzyy);
		 }
		    
		/*按公司计算*/
		 corpsql="from CorpCode where status='0'";
		 query=session.createQuery(corpsql);
		 corplist=(ArrayList<CorpCode>) query.list();
		
		 for(int i=0;i<corplist.size();i++)
		 {
			 fzyy = new WbFzyy();
			 /*上线人数--剔除小于10笔人数*/
			 sql="select count(*) from t_wb_base " +
	 			" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' and w.fzyy>10 ";
			 query=session.createSQLQuery(sql);
			 objtmp=(Object)query.uniqueResult();
			 corponline=check.IsNullInteger(objtmp);
			 fzyy.setOnline(corponline);
			 /*上线人数--不剔除小于10笔人数*/
			 sql="select count(*) from t_wb_base " +
	 			" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' and w.fzyy>10 ";
			 query=session.createSQLQuery(sql);
			 objtmp=(Object)query.uniqueResult();
			 int corponline_all=check.IsNullInteger(objtmp);
			
			 /*业务量---剔除*/
			 sql="select sum(fzyy) from t_wb_base " +
	 			" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"' and w.fzyy>10 ";
			 query=session.createSQLQuery(sql);
			 objtmp=(Object)query.uniqueResult();
			 ywl_tc=check.IsNullInteger(objtmp);
	 			/*录入量、录入差错、录入回收、单笔时长--不剔除小于10笔*/ 
			 sql="select sum(fzyy), sum(fzyy_cc),sum(fzyy_hs),cast(sum(fzyy_time*fzyy)/sum(fzyy) AS DECIMAL(18,2)) from t_wb_base " +
				" as w where w.date='"+date+"' and substr(no,1,3)='"+corplist.get(i).getNo()+"'";
			 query=session.createSQLQuery(sql);
			 List list=query.list();
			 if(!list.get(0).equals(null))
			 {
				 
				 Object[] obj = (Object[])list.get(0);
		    	
				 if(corponline_all>0)
				 {
					str=obj[0].toString();
					int tmp=Integer.parseInt(str);
					fzyy.setCl(tmp);
					
					fzyy.setCc(check.IsNullDouble(obj[1]));
					
					fzyy.setHs(check.IsNullDouble(obj[2]));
					
					fzyy.setAvertime(check.IsNullDouble(obj[3]));
					fzyy.setOnlineZb(check.DoubleTo4(check.division(fzyy.getOnline(),online)));
					fzyy.setClZb(check.DoubleTo4(check.division(fzyy.getCl(),ywl)));
					fzyy.setCcl(check.DoubleTo4(check.division(fzyy.getCc(), fzyy.getCl())));
					fzyy.setHsl(check.DoubleTo4(check.division(fzyy.getHs(), fzyy.getCl())));
					fzyy.setAvevCl(check.DoubleTo0(check.division(ywl_tc,fzyy.getOnline())));
				}else
				{
					fzyy.setCl(0);
					fzyy.setCc(0.0);
					fzyy.setHs(0.0);
					fzyy.setAvertime(0.0);
					fzyy.setOnlineZb(0.0);
				    fzyy.setClZb(0.0);
				    fzyy.setCcl(0.0);
				    fzyy.setHsl(0.0);
				    fzyy.setAvevCl(0.0);
					
				}
				fzyy.setCorpname(corplist.get(i).getName());
				fzyy.setCorpcode(corplist.get(i).getNo());
				fzyy.setDate(date);
			    dao.save(fzyy);
		    }
		 }
	  }catch (Exception e) {
		 trans.rollback();
		 e.printStackTrace();
		 logger.error(e);
	  }finally{
		 trans.commit();
		 session.flush();
		 session.clear();
		 session.close();
	  }
	  return result;
    }
   /*清除离场外包数据*/
    public String ClearWb()
    {
    	String result="";
    	String sql="";
    	Transaction trans = null;
    	String sql_del=null;
    	Session session = HibernateSessionFactory.getSession();
    	try 
  	    {
  		   trans=session.beginTransaction();
  		   sql_del="delete from t_wb_base_save where date='"+date+"'";
  		   session.createSQLQuery(sql_del).executeUpdate();
  		   sql="insert into t_wb_base_save(date,no,name,yslr,yslr_time,yslr_cc,yslr_hs,yslr_zy," +
  		   		"yslr_zl,lrzc,lrzc_time,lrzc_cc,lrzc_hs,lrzc_zl,fzyy,fzyy_time,fzyy_cc,fzyy_hs," +
  		   		"work_yslr,yslr_ccl,yslr_hsl,yslr_zyl,yslr_zll,lrzc_ccl,lrzc_hsl,fzyy_ccl,fzyy_hsl," +
  		   		"lrzc_zll,work_fzyy,work_lrzc,work_time) " +
  		   		"select date,no,name,yslr,yslr_time,yslr_cc,yslr_hs,yslr_zy," +
  		   		"yslr_zl,lrzc,lrzc_time,lrzc_cc,lrzc_hs,lrzc_zl,fzyy,fzyy_time,fzyy_cc,fzyy_hs," +
  		   		"work_yslr,yslr_ccl,yslr_hsl,yslr_zyl,yslr_zll,lrzc_ccl,lrzc_hsl,fzyy_ccl,fzyy_hsl," +
  		   		"lrzc_zll,work_fzyy,work_lrzc,work_time from t_wb_base where date='"+date+"' and substr(no,1,3) in('STC','STW')";
  		   session.createSQLQuery(sql).executeUpdate();
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
    	return result;
    }
    /*truncate表*/
	public void truncate(String table)
	{
		Session truncate_session = HibernateSessionFactory.getSession();
		Transaction tran=truncate_session.beginTransaction();
		Query queryObject = truncate_session.createSQLQuery("truncate "+ table);
		queryObject.executeUpdate();
		tran.commit();
		truncate_session.flush();
		truncate_session.clear();
		truncate_session.close();
	}
	/*更新数据加工情况表*/
	public String updateStatus()
	{
		String result="";
		String sql="";
		DailyStatus status=new DailyStatus();
		DailyStatusDAO dao =new DailyStatusDAO();
		int i=0;
		String tmp="";
		date=date.replaceAll("-", "");
		Query query;
  	    
    	
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();		
    	try 
  	    {
		status=dao.findByTime(date);
		
		if(status==null||status.equals(null))
		{
			status=new DailyStatus();
			status.setTime(date);
			status.setWbjiagong(1);
			
		}
		else
		{
			if(status.getWbjiagong()==null||status.getWbjiagong().equals(null))
				i=1;
			else
				i=status.getWbjiagong()+1;
			status.setWbjiagong(i);
			status.setTime(date);
		}
		dao.merge(status);
	}catch (Exception e) {
  		// TODO Auto-generated catch block
  		
  		e.printStackTrace();
  		logger.error(e);
  	    }finally{
  	       trans.commit();
           session.flush();
           session.clear();
           session.close();
  	    }
		return result;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}


