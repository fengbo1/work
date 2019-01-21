package work.hn.action;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.ControlDAO;
import work.control.dao.HnConfigDAO;
import work.control.pojo.Control;
import work.control.pojo.Xishu;
import work.daily.dao.DailyStatusDAO;
import work.daily.pojo.DailyStatus;
import work.hn.dao.SummaryDailyDAO;
import work.hn.pojo.SummaryDaily;
import work.util.GeneralCheck;
import work.wb.beans.BaseData;

import ccb.hibernate.HibernateSessionFactory;
/*生成汇总快报表---没有查询率*/

public class ProduceSummary
{
	private String date;//时间
	private static Logger logger = Logger.getLogger(BaseData.class);
	private String message;
	public ProduceSummary() {
		
	}
	public String execute() throws Exception
	{
		String result="success";
		/*删除表*/
		date=date.replace("-", "");
		DelTable("t_daily_summary",date);
		SummarySimple simple=new SummarySimple();  
		date=date.replaceAll("-", "");
		message = "汇总表加工成功！";
		/*计算人数*/
		result=CountOperator();
		/*计算任务量*/
		result=countTask();
		/*计算折合产量*/
		result=countZHTask();
		/*计算人均折合产量*/
		result=averTask();
		Zyzl();
		xl();
		//Cxl();
		/*操作数据加工表*/
		result=updateStatus();
	    simple.execute(date);
		return "success";
	}
	public String WhbbUpdate(String idate) throws Exception
	{
		SummarySimple simple=new SummarySimple();  
		String result="success";
		/*删除表*/
		date=idate.replace("-", "");
		DelTable("t_daily_summary",date);
			
		/*计算人数*/
		result=CountOperator();
		/*计算任务量*/
		result=countTask();
		/*计算折合产量*/
		result=countZHTask();
		/*计算人均折合产量*/
		result=averTask();
		Zyzl();
		xl();
		//Cxl();
		
		/*操作数据加工表*/
		result=updateStatus();
		simple.execute(date);
		return "success";
	}
	/*计算人数栏位*/
	public String CountOperator()
	{
		String result="success";
		String sql="";
				
		SummaryDailyDAO dao= new SummaryDailyDAO();
		/*合计*/
		SummaryDaily summary=new SummaryDaily();
		/*人民币*/
		SummaryDaily summary_rmb=new SummaryDaily();
		/*人民币专职*/
		SummaryDaily summary_zz=new SummaryDaily();
		/*人民币非专职*/
		SummaryDaily summary_fz=new SummaryDaily();
		/*外汇*/
		SummaryDaily summary_wh=new SummaryDaily();
		/*稽核*/
		SummaryDaily summary_jh=new SummaryDaily();
		/*集中审核*/
		SummaryDaily summary_sh=new SummaryDaily();
		/*建亚*/
		SummaryDaily summary_jy=new SummaryDaily();
		/*反洗钱*/
		SummaryDaily summary_fxq=new SummaryDaily();
		GeneralCheck check =new GeneralCheck();
		
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
			
			
			
			/*总人数*/
			summary.setItemName("一、总人数");
			summary.setItemCode("rs");
			sql="where date='"+date+"' and zx=0 and sx=1";
			summary.setCdReal(dao.countDouble(sql,"t_hn_new"));
			sql="where date='"+date+"' and zx=1 and sx=1";
			summary.setWhReal(dao.countDouble(sql,"t_hn_new"));
			summary.setTotalReal(summary.getCdReal()+summary.getWhReal());	
			summary.setWhRealZb(check.DoubleTo4(check.division(summary.getWhReal(), summary.getTotalReal())));	
			summary.setCdRealZb(check.DoubleTo4(check.division(summary.getCdReal(), summary.getTotalReal())));
			summary.setDate(date);
			dao.save(summary);
			
			/*总计*/
			/*合计：895任务池（COS_T系统导出数据）*/
			summary_rmb.setItemName("1 人民币");
			summary_rmb.setItemCode("rs_rmb");
			//sql="where time='"+date+"' and zhcl>0";
			sql="where time='"+date+"' and output895>0 and online=1";
			summary_rmb.setTotal895(dao.countDouble(sql,"t_hn_detail"));
			/*成都-895任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='0' and output895>0 and online=1";
			summary_rmb.setCd895(dao.countDouble(sql,"t_hn_detail"));
			summary_rmb.setCd895Zb(check.DoubleTo4(check.division(summary_rmb.getCd895(), summary_rmb.getTotal895())));
			/*武汉-895任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='1' and output895>0 and online=1";
			summary_rmb.setWh895(dao.countDouble(sql,"t_hn_detail"));
			summary_rmb.setWh895Zb(check.DoubleTo4(check.division(summary_rmb.getWh895(), summary_rmb.getTotal895())));
			/*891环节上线人数*/
			/*合计：891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and output891>0 and online=1";
			summary_rmb.setTotal891(dao.countDouble(sql,"t_hn_detail"));
			/*成都-891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='0' and output891>0 and online=1";
			summary_rmb.setCd891(dao.countDouble(sql,"t_hn_detail"));
			summary_rmb.setCd891Zb(check.DoubleTo4(check.division(summary_rmb.getCd891(), summary_rmb.getTotal891())));
			/*武汉-891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='1' and output891>0 and online=1";
			summary_rmb.setWh891(dao.countDouble(sql,"t_hn_detail"));
			summary_rmb.setWh891Zb(check.DoubleTo4(check.division(summary_rmb.getWh891(), summary_rmb.getTotal891())));
			/*成都-891任务池（(实际生产值）*/
//			sql="where time='"+date+"' and online='1' and zx='0' ";
//			summary_rmb.setCdReal(dao.countDouble(sql,"t_hn_detail"));
			sql="where date='"+date+"' and sxrmb=1 and zx=0 and clrmb>0";
			summary_rmb.setCdReal(dao.countDouble(sql,"t_hn_new"));
			/*武汉-891任务池（(实际生产值）*/
			sql="where date='"+date+"' and sxrmb=1 and zx=1 and clrmb>0";
			summary_rmb.setWhReal(dao.countDouble(sql,"t_hn_new"));
			/*合计：两任务池(实际生产值）*/
			summary_rmb.setTotalReal(summary_rmb.getCdReal()+summary_rmb.getWhReal());	
			summary_rmb.setWhRealZb(check.DoubleTo4(check.division(summary_rmb.getWhReal(), summary_rmb.getTotalReal())));	
			summary_rmb.setCdRealZb(check.DoubleTo4(check.division(summary_rmb.getCdReal(), summary_rmb.getTotalReal())));
			summary_rmb.setDate(date);
			dao.save(summary_rmb);
			
			/*行内专职*/
			/*合计：895任务池（COS_T系统导出数据）*/
			summary_zz.setItemName("1 人民币专职人员");
			summary_zz.setItemCode("rs_zz");
			sql="where time='"+date+"' and xz='0' and output895>0 and online=1";
			summary_zz.setTotal895(dao.countDouble(sql,"t_hn_detail"));
			/*成都-895任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='0' and xz in('0','2') and output895>0 and online=1";
			summary_zz.setCd895(dao.countDouble(sql,"t_hn_detail"));
			summary_zz.setCd895Zb(check.DoubleTo4(check.division(summary_zz.getCd895(), summary_zz.getTotal895())));
			/*武汉-895任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='1' and xz in('0','2') and output895>0 and online=1";
			summary_zz.setWh895(dao.countDouble(sql,"t_hn_detail"));
			summary_zz.setWh895Zb(check.DoubleTo4(check.division(summary_zz.getWh895(), summary_zz.getTotal895())));
			/*891环节上线人数*/
			/*合计：891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"'  and xz in('0','2') and output891>0 and online=1";
			summary_zz.setTotal891(dao.countDouble(sql,"t_hn_detail"));
			/*成都-891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='0' and xz in('0','2') and output891>0 and online=1";
			summary_zz.setCd891(dao.countDouble(sql,"t_hn_detail"));
			summary_zz.setCd891Zb(check.DoubleTo4(check.division(summary_zz.getCd891(), summary_zz.getTotal891())));
			/*武汉-891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='1' and xz in('0','2') and output891>0 and online=1";
			summary_zz.setWh891(dao.countDouble(sql,"t_hn_detail"));
			summary_zz.setWh891Zb(check.DoubleTo4(check.division(summary_zz.getWh891(), summary_zz.getTotal891())));
			/*成都-891任务池（(实际生产值）*/
			sql="where time='"+date+"' and online='1' and zx='0' and xz in('0','2') and output>0";
			summary_zz.setCdReal(dao.countDouble(sql,"t_hn_detail"));
			/*武汉-891任务池（(实际生产值）*/
			sql="where time='"+date+"' and online='1' and zx='1' and xz in('0','2') and output>0";
			summary_zz.setWhReal(dao.countDouble(sql,"t_hn_detail"));
			/*合计：两任务池(实际生产值）*/
			summary_zz.setTotalReal(check.IsNullDouble(summary_zz.getCdReal())+check.IsNullDouble(summary_zz.getWhReal()));	
			summary_zz.setWhRealZb(check.DoubleTo4(check.division(summary_zz.getWhReal(), summary_zz.getTotalReal())));	
			summary_zz.setCdRealZb(check.DoubleTo4(check.division(summary_zz.getCdReal(), summary_zz.getTotalReal())));
			summary_zz.setDate(date);
			dao.save(summary_zz);
			
			/*行内非专职*/
			/*合计：895任务池（COS_T系统导出数据）*/
			summary_fz.setItemName("2人民币其他人员");
			summary_fz.setItemCode("rs_fz");
			sql="where time='"+date+"' and xz in (1,4) and output895>0 and online=1";
			summary_fz.setTotal895(dao.countDouble(sql,"t_hn_detail"));
			/*成都-895任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='0' and xz in (1,4) and output895>0 and online=1";
			summary_fz.setCd895(dao.countDouble(sql,"t_hn_detail"));
			summary_fz.setCd895Zb(check.DoubleTo4(check.division(summary_fz.getCd895(), summary_fz.getTotal895())));
			/*武汉-895任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='1' and xz in (1,4) and output895>0 and online=1";
			summary_fz.setWh895(dao.countDouble(sql,"t_hn_detail"));
			summary_fz.setWh895Zb(check.DoubleTo4(check.division(summary_fz.getWh895(), summary_fz.getTotal895())));
			/*891环节上线人数*/
			/*合计：891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and xz in (1,4) and output891>0 and online=1";
			summary_fz.setTotal891(dao.countDouble(sql,"t_hn_detail"));
			/*成都-891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='0' and xz in (1,4) and output891>0 and online=1";
			summary_fz.setCd891(dao.countDouble(sql,"t_hn_detail"));
			summary_fz.setCd891Zb(check.DoubleTo4(check.division(summary_fz.getCd891(), summary_fz.getTotal891())));
			/*武汉-891任务池（COS_T系统导出数据）*/
			sql="where time='"+date+"' and zx='1' and xz in (1,4) and output891>0 and online=1";
			summary_fz.setWh891(dao.countDouble(sql,"t_hn_detail"));
			summary_fz.setWh891Zb(check.DoubleTo4(check.division(summary_fz.getWh891(), summary_fz.getTotal891())));
			/*成都-891任务池（(实际生产值）*/
			sql="where time='"+date+"' and online='1' and zx='0' and xz in (1,4) and output>0";
			summary_fz.setCdReal(dao.countDouble(sql,"t_hn_detail"));
			/*武汉-891任务池（(实际生产值）*/
			sql="where time='"+date+"' and online='1' and zx='1' and xz in (1,4) and output>0";
			summary_fz.setWhReal(dao.countDouble(sql,"t_hn_detail"));
			/*合计：两任务池(实际生产值）*/
			summary_fz.setTotalReal(summary_fz.getCdReal()+summary_fz.getWhReal());	
			summary_fz.setWhRealZb(check.DoubleTo4(check.division(summary_fz.getWhReal(), summary_fz.getTotalReal())));	
			summary_fz.setCdRealZb(check.DoubleTo4(check.division(summary_fz.getCdReal(), summary_fz.getTotalReal())));
			summary_fz.setDate(date);
			dao.save(summary_fz);
			
			/*外汇*/
			summary_wh.setItemName("3 外汇");
			summary_wh.setItemCode("rs_wh");
			sql="where date='"+date+"' and zx=0 and sxwh=1";
			summary_wh.setCdReal(dao.countDouble(sql,"t_hn_new"));
			sql="where date='"+date+"' and zx=1 and sxwh=1";
			summary_wh.setWhReal(dao.countDouble(sql,"t_hn_new"));
			summary_wh.setTotalReal(summary_wh.getCdReal()+summary_wh.getWhReal());	
			summary_wh.setWhRealZb(check.DoubleTo4(check.division(summary_wh.getWhReal(), summary_wh.getTotalReal())));	
			summary_wh.setCdRealZb(check.DoubleTo4(check.division(summary_wh.getCdReal(), summary_wh.getTotalReal())));
			summary_wh.setDate(date);
			dao.save(summary_wh);
			
			/*稽核*/
			summary_jh.setItemName("4 稽核");
			summary_jh.setItemCode("rs_jh");
			sql="where date='"+date+"' and zx=0 and sxjh=1";
			summary_jh.setCdReal(dao.countDouble(sql,"t_hn_new"));
			sql="where date='"+date+"' and zx=1 and sxjh=1";
			summary_jh.setWhReal(dao.countDouble(sql,"t_hn_new"));
			summary_jh.setTotalReal(summary_jh.getCdReal()+summary_jh.getWhReal());	
			summary_jh.setWhRealZb(check.DoubleTo4(check.division(summary_jh.getWhReal(), summary_jh.getTotalReal())));	
			summary_jh.setCdRealZb(check.DoubleTo4(check.division(summary_jh.getCdReal(), summary_jh.getTotalReal())));
			summary_jh.setDate(date);
			dao.save(summary_jh);
			
			/*远程审核*/
			summary_sh.setItemName("5 远程审核");
			summary_sh.setItemCode("rs_sh");
			sql="where date='"+date+"' and zx=0 and sxsh=1";
			summary_sh.setCdReal(dao.countDouble(sql,"t_hn_new"));
			sql="where date='"+date+"' and zx=1 and sxsh=1";
			summary_sh.setWhReal(dao.countDouble(sql,"t_hn_new"));
			summary_sh.setTotalReal(summary_sh.getCdReal()+summary_sh.getWhReal());	
			summary_sh.setWhRealZb(check.DoubleTo4(check.division(summary_sh.getWhReal(), summary_sh.getTotalReal())));	
			summary_sh.setCdRealZb(check.DoubleTo4(check.division(summary_sh.getCdReal(), summary_sh.getTotalReal())));
			summary_sh.setDate(date);
			dao.save(summary_sh);
			
			/*建亚*/
			summary_jy.setItemName("6 建亚");
			summary_jy.setItemCode("rs_jy");
			sql="where date='"+date+"' and zx=0 and sxjy=1";
			summary_jy.setCdReal(dao.countDouble(sql,"t_hn_new"));
			sql="where date='"+date+"' and zx=1 and sxjy=1";
			summary_jy.setWhReal(dao.countDouble(sql,"t_hn_new"));
			summary_jy.setTotalReal(summary_jy.getCdReal()+summary_jy.getWhReal());	
			summary_jy.setWhRealZb(check.DoubleTo4(check.division(summary_jy.getWhReal(), summary_jy.getTotalReal())));	
			summary_jy.setCdRealZb(check.DoubleTo4(check.division(summary_jy.getCdReal(), summary_jy.getTotalReal())));
			summary_jy.setDate(date);
			dao.save(summary_jy);
			
			/*反洗钱*/
			summary_fxq.setItemName("7反洗钱");
			summary_fxq.setItemCode("rs_fxq");
			sql="where date='"+date+"' and zx=0 and sxfxq=1";
			summary_fxq.setCdReal(dao.countDouble(sql,"t_hn_new"));
			sql="where date='"+date+"' and zx=1 and sxfxq=1";
			summary_fxq.setWhReal(dao.countDouble(sql,"t_hn_new"));
			summary_fxq.setTotalReal(summary_fxq.getCdReal()+summary_fxq.getWhReal());	
			summary_fxq.setWhRealZb(check.DoubleTo4(check.division(summary_fxq.getWhReal(), summary_fxq.getTotalReal())));	
			summary_fxq.setCdRealZb(check.DoubleTo4(check.division(summary_fxq.getCdReal(), summary_fxq.getTotalReal())));
			summary_fxq.setDate(date);
			dao.save(summary_fxq);
		
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
	
	/*统计任务量*/
	public String countTask()
	{
		
		String result="";
		String sql="";
		date=date.replace("-", "");
		SummaryDailyDAO dao= new SummaryDailyDAO();
		/*合计任务量*/
		SummaryDaily summary=new SummaryDaily();
		/*人民币*/
		SummaryDaily summary_rmb=new SummaryDaily();
		/*外汇*/
		SummaryDaily summary_wh=new SummaryDaily();
		/*稽核*/
		SummaryDaily summary_jh=new SummaryDaily();
		/*远程审核*/
		SummaryDaily summary_sh=new SummaryDaily();
		/*建亚*/
		SummaryDaily summary_jy=new SummaryDaily();
		/*反洗钱*/
		SummaryDaily summary_fxq=new SummaryDaily();
		/*人工版面识别*/
		SummaryDaily summary_bm=new SummaryDaily();
		/*影像拆分*/
		SummaryDaily summary_cf=new SummaryDaily();
		/*录入修改*/
		SummaryDaily summary_lrxg=new SummaryDaily();
		/*录入修改授权*/
		SummaryDaily summary_lrsq=new SummaryDaily();
		/*检核修改*/
		SummaryDaily summary_jhxg=new SummaryDaily();
		/*检核授权*/
		SummaryDaily summary_jhsq=new SummaryDaily();
		/*失败原因分析*/
		SummaryDaily summary_sbyy=new SummaryDaily();
		/*单位账户影像标注*/
		SummaryDaily summary_yxbz=new SummaryDaily();
		/*初审录入*/
		SummaryDaily summary_cslr=new SummaryDaily();
		/*专业复审*/
		SummaryDaily summary_zyfs=new SummaryDaily();
		
		GeneralCheck check =new GeneralCheck();
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
		
		
		/*人工版面识别*/
		summary_bm.setItemName("① 人工版面识别");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_bm.setWh891(dao.countCDouble("bmsb","hn891",sql));
		summary_bm.setWh895(dao.countCDouble("bmsb","hn895",sql));
		summary_bm.setWhReal(check.DoubleTo0(summary_bm.getWh891()+summary_bm.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_bm.setCd891(dao.countCDouble("bmsb","hn891",sql));
		summary_bm.setCd895(dao.countCDouble("bmsb","hn895",sql));
		summary_bm.setCdReal(check.DoubleTo0(summary_bm.getCd891()+summary_bm.getCd895()));
		/*合计*/
		summary_bm.setTotal891(summary_bm.getCd891()+summary_bm.getWh891());
		summary_bm.setTotal895(summary_bm.getCd895()+summary_bm.getWh895());
		summary_bm.setTotalReal(check.DoubleTo0(summary_bm.getTotal891()+summary_bm.getTotal895()));
		/*占比*/
		summary_bm.setCd891Zb(check.DoubleTo4(check.division(summary_bm.getCd891(), summary_bm.getTotal891())));
		summary_bm.setWh891Zb(check.DoubleTo4(check.division(summary_bm.getWh891(), summary_bm.getTotal891())));
		summary_bm.setCd895Zb(check.DoubleTo4(check.division(summary_bm.getCd895(), summary_bm.getTotal895())));
		summary_bm.setWh895Zb(check.DoubleTo4(check.division(summary_bm.getWh895(), summary_bm.getTotal895())));
		summary_bm.setCdRealZb(check.DoubleTo4(check.division(summary_bm.getCdReal(),summary_bm.getTotalReal())));
		summary_bm.setWhRealZb(check.DoubleTo4(check.division(summary_bm.getWhReal(),summary_bm.getTotalReal())));
		summary_bm.setDate(date);
		
		
		/*影像拆分*/
		summary_cf.setItemName("② 人工影像拆分");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_cf.setWh891(dao.countCDouble("yxcf","hn891",sql));
		summary_cf.setWh895(dao.countCDouble("yxcf","hn895",sql));
		summary_cf.setWhReal(check.DoubleTo0(summary_cf.getWh891()+summary_cf.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_cf.setCd891(dao.countCDouble("yxcf","hn891",sql));
		summary_cf.setCd895(dao.countCDouble("yxcf","hn895",sql));
		summary_cf.setCdReal(check.DoubleTo0(summary_cf.getCd891()+summary_cf.getCd895()));
		/*合计*/
		summary_cf.setTotal891(summary_cf.getCd891()+summary_cf.getWh891());
		summary_cf.setTotal895(summary_cf.getCd895()+summary_cf.getWh895());
		summary_cf.setTotalReal(check.DoubleTo0(summary_cf.getTotal891()+summary_cf.getTotal895()));
		/*占比*/
		summary_cf.setCd891Zb(check.DoubleTo4(check.division(summary_cf.getCd891(), summary_cf.getTotal891())));
		summary_cf.setWh891Zb(check.DoubleTo4(check.division(summary_cf.getWh891(), summary_cf.getTotal891())));
		summary_cf.setCd895Zb(check.DoubleTo4(check.division(summary_cf.getCd895(), summary_cf.getTotal895())));
		summary_cf.setWh895Zb(check.DoubleTo4(check.division(summary_cf.getWh895(), summary_cf.getTotal895())));
		summary_cf.setCdRealZb(check.DoubleTo4(check.division(summary_cf.getCdReal(),summary_cf.getTotalReal())));
		summary_cf.setWhRealZb(check.DoubleTo4(check.division(summary_cf.getWhReal(),summary_cf.getTotalReal())));
		summary_cf.setDate(date);
		
		
		/*录入修改*/
		summary_lrxg.setItemName("③ 录入修改");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_lrxg.setWh891(dao.countCDouble("lrxg","hn891",sql));
		summary_lrxg.setWh895(dao.countCDouble("lrxg","hn895",sql));
		summary_lrxg.setWhReal(check.DoubleTo0(summary_lrxg.getWh891()+summary_lrxg.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_lrxg.setCd891(dao.countCDouble("lrxg","hn891",sql));
		summary_lrxg.setCd895(dao.countCDouble("lrxg","hn895",sql));
		summary_lrxg.setCdReal(check.DoubleTo0(summary_lrxg.getCd891()+summary_lrxg.getCd895()));
		/*合计*/
		summary_lrxg.setTotal891(summary_lrxg.getCd891()+summary_lrxg.getWh891());
		summary_lrxg.setTotal895(summary_lrxg.getCd895()+summary_lrxg.getWh895());
		summary_lrxg.setTotalReal(check.DoubleTo0(summary_lrxg.getTotal891()+summary_lrxg.getTotal895()));
		/*占比*/
		summary_lrxg.setCd891Zb(check.DoubleTo4(check.division(summary_lrxg.getCd891(), summary_lrxg.getTotal891())));
		summary_lrxg.setWh891Zb(check.DoubleTo4(check.division(summary_lrxg.getWh891(), summary_lrxg.getTotal891())));
		summary_lrxg.setCd895Zb(check.DoubleTo4(check.division(summary_lrxg.getCd895(), summary_lrxg.getTotal895())));
		summary_lrxg.setWh895Zb(check.DoubleTo4(check.division(summary_lrxg.getWh895(), summary_lrxg.getTotal895())));
		summary_lrxg.setCdRealZb(check.DoubleTo4(check.division(summary_lrxg.getCdReal(),summary_lrxg.getTotalReal())));
		summary_lrxg.setWhRealZb(check.DoubleTo4(check.division(summary_lrxg.getWhReal(),summary_lrxg.getTotalReal())));
		summary_lrxg.setDate(date);
		
		
		/*录入修改授权*/
		summary_lrsq.setItemName("④ 录入修改授权");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_lrsq.setWh891(dao.countCDouble("lrsq","hn891",sql));
		summary_lrsq.setWh895(dao.countCDouble("lrsq","hn895",sql));
		summary_lrsq.setWhReal(check.DoubleTo0(summary_lrsq.getWh891()+summary_lrsq.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_lrsq.setCd891(dao.countCDouble("lrsq","hn891",sql));
		summary_lrsq.setCd895(dao.countCDouble("lrsq","hn895",sql));
		summary_lrsq.setCdReal(check.DoubleTo0(summary_lrsq.getCd891()+summary_lrsq.getCd895()));
		/*合计*/
		summary_lrsq.setTotal891(summary_lrsq.getCd891()+summary_lrsq.getWh891());
		summary_lrsq.setTotal895(summary_lrsq.getCd895()+summary_lrsq.getWh895());
		summary_lrsq.setTotalReal(check.DoubleTo0(summary_lrsq.getTotal891()+summary_lrsq.getTotal895()));
		/*占比*/
		summary_lrsq.setCd891Zb(check.DoubleTo4(check.division(summary_lrsq.getCd891(), summary_lrsq.getTotal891())));
		summary_lrsq.setWh891Zb(check.DoubleTo4(check.division(summary_lrsq.getWh891(), summary_lrsq.getTotal891())));
		summary_lrsq.setCd895Zb(check.DoubleTo4(check.division(summary_lrsq.getCd895(), summary_lrsq.getTotal895())));
		summary_lrsq.setWh895Zb(check.DoubleTo4(check.division(summary_lrsq.getWh895(), summary_lrsq.getTotal895())));
		summary_lrsq.setCdRealZb(check.DoubleTo4(check.division(summary_lrsq.getCdReal(),summary_lrsq.getTotalReal())));
		summary_lrsq.setWhRealZb(check.DoubleTo4(check.division(summary_lrsq.getWhReal(),summary_lrsq.getTotalReal())));
		summary_lrsq.setDate(date);
		
		
		/*检核修改*/
		summary_jhxg.setItemName("⑤ 检核修改");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_jhxg.setWh891(dao.countCDouble("jhxg","hn891",sql));
		summary_jhxg.setWh895(dao.countCDouble("jhxg","hn895",sql));
		summary_jhxg.setWhReal(check.DoubleTo0(summary_jhxg.getWh891()+summary_jhxg.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_jhxg.setCd891(dao.countCDouble("jhxg","hn891",sql));
		summary_jhxg.setCd895(dao.countCDouble("jhxg","hn895",sql));
		summary_jhxg.setCdReal(check.DoubleTo0(summary_jhxg.getCd891()+summary_jhxg.getCd895()));
		/*合计*/
		summary_jhxg.setTotal891(summary_jhxg.getCd891()+summary_jhxg.getWh891());
		summary_jhxg.setTotal895(summary_jhxg.getCd895()+summary_jhxg.getWh895());
		summary_jhxg.setTotalReal(check.DoubleTo0(summary_jhxg.getTotal891()+summary_jhxg.getTotal895()));
		/*占比*/
		summary_jhxg.setCd891Zb(check.DoubleTo4(check.division(summary_jhxg.getCd891(), summary_jhxg.getTotal891())));
		summary_jhxg.setWh891Zb(check.DoubleTo4(check.division(summary_jhxg.getWh891(), summary_jhxg.getTotal891())));
		summary_jhxg.setCd895Zb(check.DoubleTo4(check.division(summary_jhxg.getCd895(), summary_jhxg.getTotal895())));
		summary_jhxg.setWh895Zb(check.DoubleTo4(check.division(summary_jhxg.getWh895(), summary_jhxg.getTotal895())));
		summary_jhxg.setCdRealZb(check.DoubleTo4(check.division(summary_jhxg.getCdReal(),summary_jhxg.getTotalReal())));
		summary_jhxg.setWhRealZb(check.DoubleTo4(check.division(summary_jhxg.getWhReal(),summary_jhxg.getTotalReal())));
		summary_jhxg.setDate(date);
		
		
		/*检核修改授权*/
		summary_jhsq.setItemName("⑥ 检核修改授权");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_jhsq.setWh891(dao.countCDouble("jhsq","hn891",sql));
		summary_jhsq.setWh895(dao.countCDouble("jhsq","hn895",sql));
		summary_jhsq.setWhReal(check.DoubleTo0(summary_jhsq.getWh891()+summary_jhsq.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_jhsq.setCd891(dao.countCDouble("jhsq","hn891",sql));
		summary_jhsq.setCd895(dao.countCDouble("jhsq","hn895",sql));
		summary_jhsq.setCdReal(check.DoubleTo0(summary_jhsq.getCd891()+summary_jhsq.getCd895()));
		/*合计*/
		summary_jhsq.setTotal891(summary_jhsq.getCd891()+summary_jhsq.getWh891());
		summary_jhsq.setTotal895(summary_jhsq.getCd895()+summary_jhsq.getWh895());
		summary_jhsq.setTotalReal(check.DoubleTo0(summary_jhsq.getTotal891()+summary_jhsq.getTotal895()));
		/*占比*/
		summary_jhsq.setCd891Zb(check.DoubleTo4(check.division(summary_jhsq.getCd891(), summary_jhsq.getTotal891())));
		summary_jhsq.setWh891Zb(check.DoubleTo4(check.division(summary_jhsq.getWh891(), summary_jhsq.getTotal891())));
		summary_jhsq.setCd895Zb(check.DoubleTo4(check.division(summary_jhsq.getCd895(), summary_jhsq.getTotal895())));
		summary_jhsq.setWh895Zb(check.DoubleTo4(check.division(summary_jhsq.getWh895(), summary_jhsq.getTotal895())));
		summary_jhsq.setCdRealZb(check.DoubleTo4(check.division(summary_jhsq.getCdReal(),summary_jhsq.getTotalReal())));
		summary_jhsq.setWhRealZb(check.DoubleTo4(check.division(summary_jhsq.getWhReal(),summary_jhsq.getTotalReal())));
		summary_jhsq.setDate(date);
		
		
		/*失败原因分析*/
		summary_sbyy.setItemName("⑦ 失败原因");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_sbyy.setWh891(dao.countCDouble("sbyy","hn891",sql));
		summary_sbyy.setWh895(dao.countCDouble("sbyy","hn895",sql));
		summary_sbyy.setWhReal(check.DoubleTo0(summary_sbyy.getWh891()+summary_sbyy.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_sbyy.setCd891(dao.countCDouble("sbyy","hn891",sql));
		summary_sbyy.setCd895(dao.countCDouble("sbyy","hn895",sql));
		summary_sbyy.setCdReal(check.DoubleTo0(summary_sbyy.getCd891()+summary_sbyy.getCd895()));
		/*合计*/
		summary_sbyy.setTotal891(summary_sbyy.getCd891()+summary_sbyy.getWh891());
		summary_sbyy.setTotal895(summary_sbyy.getCd895()+summary_sbyy.getWh895());
		summary_sbyy.setTotalReal(check.DoubleTo0(summary_sbyy.getTotal891()+summary_sbyy.getTotal895()));
		/*占比*/
		summary_sbyy.setCd891Zb(check.DoubleTo4(check.division(summary_sbyy.getCd891(), summary_sbyy.getTotal891())));
		summary_sbyy.setWh891Zb(check.DoubleTo4(check.division(summary_sbyy.getWh891(), summary_sbyy.getTotal891())));
		summary_sbyy.setCd895Zb(check.DoubleTo4(check.division(summary_sbyy.getCd895(), summary_sbyy.getTotal895())));
		summary_sbyy.setWh895Zb(check.DoubleTo4(check.division(summary_sbyy.getWh895(), summary_sbyy.getTotal895())));
		summary_sbyy.setCdRealZb(check.DoubleTo4(check.division(summary_sbyy.getCdReal(),summary_sbyy.getTotalReal())));
		summary_sbyy.setWhRealZb(check.DoubleTo4(check.division(summary_sbyy.getWhReal(),summary_sbyy.getTotalReal())));
		summary_sbyy.setDate(date);
		
		
		/*单位账户影像标注*/
		summary_yxbz.setItemName("⑧ 影像标注");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_yxbz.setWh891(dao.countCDouble("yxbz","hn891",sql));
		//summary_yxbz.setWh895(dao.countCDouble("yxbz","hn895",sql));
		summary_yxbz.setWhReal(check.DoubleTo0(summary_yxbz.getWh891()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_yxbz.setCd891(dao.countCDouble("yxbz","hn891",sql));
		//summary_yxbz.setCd895(dao.countCDouble("yxbz","hn895",sql));
		summary_yxbz.setCdReal(check.DoubleTo0(summary_yxbz.getCd891()));
		/*合计*/
		summary_yxbz.setTotal891(summary_yxbz.getCd891()+summary_yxbz.getWh891());
		//summary_yxbz.setTotal895(summary_yxbz.getCd895()+summary_yxbz.getWh895());
		summary_yxbz.setTotalReal(check.DoubleTo0(summary_yxbz.getTotal891()));
		/*占比*/
		summary_yxbz.setCd891Zb(check.DoubleTo4(check.division(summary_yxbz.getCd891(), summary_yxbz.getTotal891())));
		summary_yxbz.setWh891Zb(check.DoubleTo4(check.division(summary_yxbz.getWh891(), summary_yxbz.getTotal891())));
		//summary_yxbz.setCd895Zb(check.DoubleTo4(check.division(summary_yxbz.getCd895(), summary_yxbz.getTotal895())));
		//summary_yxbz.setWh895Zb(check.DoubleTo4(check.division(summary_yxbz.getWh895(), summary_yxbz.getTotal895())));
		summary_yxbz.setCdRealZb(check.DoubleTo4(check.division(summary_yxbz.getCdReal(),summary_yxbz.getTotalReal())));
		summary_yxbz.setWhRealZb(check.DoubleTo4(check.division(summary_yxbz.getWhReal(),summary_yxbz.getTotalReal())));
		summary_yxbz.setDate(date);
		
		
		/*初审录入*/
		summary_cslr.setItemName("⑨ 初审录入");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_cslr.setWh891(dao.countCDouble("cslr","hn891",sql));
		//summary_cslr.setWh895(dao.countCDouble("cslr","hn895",sql));
		summary_cslr.setWhReal(check.DoubleTo0(summary_cslr.getWh891()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_cslr.setCd891(dao.countCDouble("cslr","hn891",sql));
		//summary_cslr.setCd895(dao.countCDouble("cslr","hn895",sql));
		summary_cslr.setCdReal(check.DoubleTo0(summary_cslr.getCd891()));
		/*合计*/
		summary_cslr.setTotal891(summary_cslr.getCd891()+summary_cslr.getWh891());
		//summary_cslr.setTotal895(summary_cslr.getCd895()+summary_cslr.getWh895());
		summary_cslr.setTotalReal(check.DoubleTo0(summary_cslr.getTotal891()));
		/*占比*/
		summary_cslr.setCd891Zb(check.DoubleTo4(check.division(summary_cslr.getCd891(), summary_cslr.getTotal891())));
		summary_cslr.setWh891Zb(check.DoubleTo4(check.division(summary_cslr.getWh891(), summary_cslr.getTotal891())));
		//summary_cslr.setCd895Zb(check.DoubleTo4(check.division(summary_cslr.getCd895(), summary_cslr.getTotal895())));
		//summary_cslr.setWh895Zb(check.DoubleTo4(check.division(summary_cslr.getWh895(), summary_cslr.getTotal895())));
		summary_cslr.setCdRealZb(check.DoubleTo4(check.division(summary_cslr.getCdReal(),summary_cslr.getTotalReal())));
		summary_cslr.setWhRealZb(check.DoubleTo4(check.division(summary_cslr.getWhReal(),summary_cslr.getTotalReal())));
		summary_cslr.setDate(date);
		
		/*专业复审*/
		summary_zyfs.setItemName("⑩ 专业复审");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_zyfs.setWh891(dao.countCDouble("zyfs","hn891",sql));
		summary_zyfs.setWhReal(check.DoubleTo0(summary_zyfs.getWh891()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_zyfs.setCd891(dao.countCDouble("zyfs","hn891",sql));
		summary_zyfs.setCdReal(check.DoubleTo0(summary_zyfs.getCd891()));
		/*合计*/
		summary_zyfs.setTotal891(summary_zyfs.getCd891()+summary_zyfs.getWh891());
		summary_zyfs.setTotalReal(check.DoubleTo0(summary_zyfs.getTotal891()));
		/*占比*/
		summary_zyfs.setCd891Zb(check.DoubleTo4(check.division(summary_zyfs.getCd891(), summary_zyfs.getTotal891())));
		summary_zyfs.setWh891Zb(check.DoubleTo4(check.division(summary_zyfs.getWh891(), summary_zyfs.getTotal891())));
		summary_zyfs.setCdRealZb(check.DoubleTo4(check.division(summary_zyfs.getCdReal(),summary_zyfs.getTotalReal())));
		summary_zyfs.setWhRealZb(check.DoubleTo4(check.division(summary_zyfs.getWhReal(),summary_zyfs.getTotalReal())));
		summary_zyfs.setDate(date);
		
		
		/**********************************************人民币******************************/
		/*任务量*/
		summary_rmb.setItemName("1 人民币");
		
		/*武汉中心*/
		summary_rmb.setWh891(summary_bm.getWh891()+summary_cf.getWh891()+summary_lrxg.getWh891()+summary_lrsq.getWh891()
				+summary_jhxg.getWh891()+summary_jhsq.getWh891()+summary_sbyy.getWh891()+summary_yxbz.getWh891()
				+summary_cslr.getWh891()+summary_zyfs.getWh891());
		summary_rmb.setWh895(summary_bm.getWh895()+summary_cf.getWh895()+summary_lrxg.getWh895()+summary_lrsq.getWh895()
				+summary_jhxg.getWh895()+summary_jhsq.getWh895()+summary_sbyy.getWh895());
		summary_rmb.setWhReal(check.DoubleTo0(summary_rmb.getWh891()+summary_rmb.getWh895()));
		/*成都中心*/
		summary_rmb.setCd891(summary_bm.getCd891()+summary_cf.getCd891()+summary_lrxg.getCd891()+summary_lrsq.getCd891()
				+summary_jhxg.getCd891()+summary_jhsq.getCd891()+summary_sbyy.getCd891()+summary_yxbz.getCd891()
				+summary_cslr.getCd891()+summary_zyfs.getCd891());
		summary_rmb.setCd895(summary_bm.getCd895()+summary_cf.getCd895()+summary_lrxg.getCd895()+summary_lrsq.getCd895()
				+summary_jhxg.getCd895()+summary_jhsq.getCd895()+summary_sbyy.getCd895());
		summary_rmb.setCdReal(check.DoubleTo0(summary_rmb.getCd891()+summary_rmb.getCd895()));
		/*合计*/
		summary_rmb.setTotal891(summary_rmb.getCd891()+summary_rmb.getWh891());
		summary_rmb.setTotal895(summary_rmb.getCd895()+summary_rmb.getWh895());
		summary_rmb.setTotalReal(check.DoubleTo0(summary_rmb.getTotal891()+summary_rmb.getTotal895()));
		/*占比*/
		summary_rmb.setCd891Zb(check.DoubleTo4(check.division(summary_rmb.getCd891(), summary_rmb.getTotal891())));
		summary_rmb.setWh891Zb(check.DoubleTo4(check.division(summary_rmb.getWh891(), summary_rmb.getTotal891())));
		summary_rmb.setCd895Zb(check.DoubleTo4(check.division(summary_rmb.getCd895(), summary_rmb.getTotal895())));
		summary_rmb.setWh895Zb(check.DoubleTo4(check.division(summary_rmb.getWh895(), summary_rmb.getTotal895())));
		summary_rmb.setCdRealZb(check.DoubleTo4(check.division(summary_rmb.getCdReal(),summary_rmb.getTotalReal())));
		summary_rmb.setWhRealZb(check.DoubleTo4(check.division(summary_rmb.getWhReal(),summary_rmb.getTotalReal())));
		summary_rmb.setDate(date);
		
		/******************************************外汇*********************************/
		/*任务量*/
		summary_wh.setItemName("2 外汇");
		
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_wh.setWhReal(dao.countCDouble("ywl","t_hn_waihui",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_wh.setCdReal(dao.countCDouble("ywl","t_hn_waihui",sql));
		/*合计*/
		summary_wh.setTotalReal(check.DoubleTo0(summary_wh.getWhReal()+summary_wh.getCdReal()));
		/*占比*/
		summary_wh.setCdRealZb(check.DoubleTo4(check.division(summary_wh.getCdReal(),summary_wh.getTotalReal())));
		summary_wh.setWhRealZb(check.DoubleTo4(check.division(summary_wh.getWhReal(),summary_wh.getTotalReal())));
		summary_wh.setDate(date);
		
		/******************************************稽核*********************************/
		/*任务量*/
		summary_jh.setItemName("3 稽核");
		
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_jh.setWhReal(dao.countCDouble("ywl","t_hn_jihe",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_jh.setCdReal(dao.countCDouble("ywl","t_hn_jihe",sql));
		/*合计*/
		summary_jh.setTotalReal(check.DoubleTo0(summary_jh.getWhReal()+summary_jh.getCdReal()));
		/*占比*/
		summary_jh.setCdRealZb(check.DoubleTo4(check.division(summary_jh.getCdReal(),summary_jh.getTotalReal())));
		summary_jh.setWhRealZb(check.DoubleTo4(check.division(summary_jh.getWhReal(),summary_jh.getTotalReal())));
		summary_jh.setDate(date);
		
		/****************************************** 远程审核*********************************/
		/*任务量*/
		summary_sh.setItemName("4 远程审核");
		
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_sh.setWhReal(dao.countCDouble("num","t_hn_ycsh",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_sh.setCdReal(dao.countCDouble("num","t_hn_ycsh",sql));
		/*合计*/
		summary_sh.setTotalReal(check.DoubleTo0(summary_sh.getWhReal()+summary_sh.getCdReal()));
		/*占比*/
		summary_sh.setCdRealZb(check.DoubleTo4(check.division(summary_sh.getCdReal(),summary_sh.getTotalReal())));
		summary_sh.setWhRealZb(check.DoubleTo4(check.division(summary_sh.getWhReal(),summary_sh.getTotalReal())));
		summary_sh.setDate(date);
		
		/****************************************** 建亚*********************************/
		/*任务量*/
		summary_jy.setItemName("5 建亚");
		
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_jy.setWhReal(dao.countCDouble("ywl","t_hn_jianya",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_jy.setCdReal(dao.countCDouble("ywl","t_hn_jianya",sql));
		/*合计*/
		summary_jy.setTotalReal(check.DoubleTo0(summary_jy.getWhReal()+summary_jy.getCdReal()));
		/*占比*/
		summary_jy.setCdRealZb(check.DoubleTo4(check.division(summary_jy.getCdReal(),summary_jy.getTotalReal())));
		summary_jy.setWhRealZb(check.DoubleTo4(check.division(summary_jy.getWhReal(),summary_jy.getTotalReal())));
		summary_jy.setDate(date);
		
		/****************************************** 反洗钱*********************************/
		/*任务量*/
		summary_fxq.setItemName("6 反洗钱");
		
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_fxq.setWhReal(dao.countCDouble("ywl","t_hn_fxq",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_fxq.setCdReal(dao.countCDouble("ywl","t_hn_fxq",sql));
		/*合计*/
		summary_fxq.setTotalReal(check.DoubleTo0(summary_fxq.getWhReal()+summary_fxq.getCdReal()));
		/*占比*/
		summary_fxq.setCdRealZb(check.DoubleTo4(check.division(summary_fxq.getCdReal(),summary_fxq.getTotalReal())));
		summary_fxq.setWhRealZb(check.DoubleTo4(check.division(summary_fxq.getWhReal(),summary_fxq.getTotalReal())));
		summary_fxq.setDate(date);
		
		
		/****************************任务量****************************/
		/*任务量*/
		summary.setItemName("二、任务量");
		summary.setItemCode("rwl");
		summary.setWhReal(summary_rmb.getWhReal()+summary_wh.getWhReal()+summary_jh.getWhReal()+summary_sh.getWhReal()+summary_jy.getWhReal()+summary_fxq.getWhReal());
		/*成都中心*/
		summary.setCdReal(summary_rmb.getCdReal()+summary_wh.getCdReal()+summary_jh.getCdReal()+summary_sh.getCdReal()+summary_jy.getCdReal()+summary_fxq.getCdReal());
		/*合计*/
		summary.setTotalReal(check.DoubleTo0(summary.getWhReal()+summary.getCdReal()));
		/*占比*/
		summary.setCdRealZb(check.DoubleTo4(check.division(summary.getCdReal(),summary.getTotalReal())));
		summary.setWhRealZb(check.DoubleTo4(check.division(summary.getWhReal(),summary.getTotalReal())));
		summary.setDate(date);
		
		dao.save(summary);
		
		
		summary_rmb.setItemCode("rwl_rmb");
		dao.save(summary_rmb);
		
		summary_bm.setItemCode("rwl_bm");
		dao.save(summary_bm);
		summary_cf.setItemCode("rwl_cf");
		dao.save(summary_cf);
		summary_lrxg.setItemCode("rwl_lrxg");
		dao.save(summary_lrxg);
		summary_lrsq.setItemCode("rwl_lrsq");
		dao.save(summary_lrsq);
		summary_jhxg.setItemCode("rwl_jhxg");
		dao.save(summary_jhxg);
		summary_jhsq.setItemCode("rwl_jhsq");
		dao.save(summary_jhsq);
		summary_sbyy.setItemCode("rwl_sbyy");
		dao.save(summary_sbyy);
		summary_yxbz.setItemCode("rwl_yxbz");
		dao.save(summary_yxbz);
		summary_cslr.setItemCode("rwl_cslr");
		dao.save(summary_cslr);
		summary_zyfs.setItemCode("rwl_zyfs");
		dao.save(summary_zyfs);
		
		summary_wh.setItemCode("rwl_wh");
		dao.save(summary_wh);
		summary_jh.setItemCode("rwl_jh");
		dao.save(summary_jh);
		summary_sh.setItemCode("rwl_sh");
		dao.save(summary_sh);
		summary_jy.setItemCode("rwl_jy");
		dao.save(summary_jy);
		summary_fxq.setItemCode("rwl_fxq");
		dao.save(summary_fxq);
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
	/*三、统计折合产量*/
	public String countZHTask()
	{
		String result="";
		String sql="";
		
		SummaryDailyDAO dao= new SummaryDailyDAO();
		/*折合产量*/
		SummaryDaily summary=new SummaryDaily();
		/*行内专职*/
		SummaryDaily summary_zz=new SummaryDaily();
		/*行内非专职*/
		SummaryDaily summary_fz=new SummaryDaily();
		/*人民币*/
		SummaryDaily summary_rmb=new SummaryDaily();
		/*外汇*/
		SummaryDaily summary_wh=new SummaryDaily();
		/*稽核*/
		SummaryDaily summary_jh=new SummaryDaily();
		/*远程审核*/
		SummaryDaily summary_sh=new SummaryDaily();
		/*建亚*/
		SummaryDaily summary_jy=new SummaryDaily();
		/*反洗钱*/
		SummaryDaily summary_fxq=new SummaryDaily();
//		/*外包人员*/
//		SummaryDaily summary_wb=new SummaryDaily();
		
		date=date.replace("-", "");
		GeneralCheck check =new GeneralCheck();
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
		/*折合产量*/
		summary_rmb.setItemName("1 人民币");
		summary_rmb.setItemCode("zhcl_rmb");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' " ;
		summary_rmb.setWh891(dao.countCDouble("output891","t_hn_detail",sql));
		summary_rmb.setWh895(dao.countCDouble("output895","t_hn_detail",sql));
		summary_rmb.setWhReal(check.DoubleTo0(summary_rmb.getWh891()+summary_rmb.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' " ;
		summary_rmb.setCd891(dao.countCDouble("output891","t_hn_detail",sql));
		summary_rmb.setCd895(dao.countCDouble("output895","t_hn_detail",sql));
		summary_rmb.setCdReal(check.DoubleTo0(summary_rmb.getCd891()+summary_rmb.getCd895()));
		/*合计*/
		summary_rmb.setTotal891(summary_rmb.getCd891()+summary_rmb.getWh891());
		summary_rmb.setTotal895(summary_rmb.getCd895()+summary_rmb.getWh895());
		summary_rmb.setTotalReal(check.DoubleTo0(summary_rmb.getTotal891()+summary_rmb.getTotal895()));
		/*占比*/
		summary_rmb.setCd891Zb(check.DoubleTo4(check.division(summary_rmb.getCd891(), summary_rmb.getTotal891())));
		summary_rmb.setWh891Zb(check.DoubleTo4(check.division(summary_rmb.getWh891(), summary_rmb.getTotal891())));
		summary_rmb.setCd895Zb(check.DoubleTo4(check.division(summary_rmb.getCd895(), summary_rmb.getTotal895())));
		summary_rmb.setWh895Zb(check.DoubleTo4(check.division(summary_rmb.getWh895(), summary_rmb.getTotal895())));
		summary_rmb.setCdRealZb(check.DoubleTo4(check.division(summary_rmb.getCdReal(),summary_rmb.getTotalReal())));
		summary_rmb.setWhRealZb(check.DoubleTo4(check.division(summary_rmb.getWhReal(),summary_rmb.getTotalReal())));
		summary_rmb.setDate(date);
		
		
		/*行内专职*/
		summary_zz.setItemName("① 人民币专职人员");
		summary_zz.setItemCode("zhcl_zz");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' and xz in('0','2')" ;
		summary_zz.setWh891(dao.countCDouble("output891","t_hn_detail",sql));
		summary_zz.setWh895(dao.countCDouble("output895","t_hn_detail",sql));
		summary_zz.setWhReal(check.DoubleTo0(summary_zz.getWh891()+summary_zz.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' and xz in('0','2')" ;
		summary_zz.setCd891(dao.countCDouble("output891","t_hn_detail",sql));
		summary_zz.setCd895(dao.countCDouble("output895","t_hn_detail",sql));
		summary_zz.setCdReal(check.DoubleTo0(summary_zz.getCd891()+summary_zz.getCd895()));
		/*合计*/
		summary_zz.setTotal891(summary_zz.getCd891()+summary_zz.getWh891());
		summary_zz.setTotal895(summary_zz.getCd895()+summary_zz.getWh895());
		summary_zz.setTotalReal(check.DoubleTo0(summary_zz.getTotal891()+summary_zz.getTotal895()));
		/*占比*/
		summary_zz.setCd891Zb(check.DoubleTo4(check.division(summary_zz.getCd891(), summary_zz.getTotal891())));
		summary_zz.setWh891Zb(check.DoubleTo4(check.division(summary_zz.getWh891(), summary_zz.getTotal891())));
		summary_zz.setCd895Zb(check.DoubleTo4(check.division(summary_zz.getCd895(), summary_zz.getTotal895())));
		summary_zz.setWh895Zb(check.DoubleTo4(check.division(summary_zz.getWh895(), summary_zz.getTotal895())));
		summary_zz.setCdRealZb(check.DoubleTo4(check.division(summary_zz.getCdReal(),summary_zz.getTotalReal())));
		summary_zz.setWhRealZb(check.DoubleTo4(check.division(summary_zz.getWhReal(),summary_zz.getTotalReal())));
		summary_zz.setDate(date);
		
		
		/*行内非专职*/
		summary_fz.setItemName("② 人民币其他人员");
		summary_fz.setItemCode("zhcl_fz");
		/*武汉中心*/
		sql="where time='"+date+"' and zx='1' and xz in (1,4)" ;
		summary_fz.setWh891(dao.countCDouble("output891","t_hn_detail",sql));
		summary_fz.setWh895(dao.countCDouble("output895","t_hn_detail",sql));
		summary_fz.setWhReal(check.DoubleTo0(summary_fz.getWh891()+summary_fz.getWh895()));
		/*成都中心*/
		sql="where time='"+date+"' and zx='0' and xz in (1,4)" ;
		summary_fz.setCd891(dao.countCDouble("output891","t_hn_detail",sql));
		summary_fz.setCd895(dao.countCDouble("output895","t_hn_detail",sql));
		summary_fz.setCdReal(check.DoubleTo0(summary_fz.getCd891()+summary_fz.getCd895()));
		/*合计*/
		summary_fz.setTotal891(summary_fz.getCd891()+summary_fz.getWh891());
		summary_fz.setTotal895(summary_fz.getCd895()+summary_fz.getWh895());
		summary_fz.setTotalReal(check.DoubleTo0(summary_fz.getTotal891()+summary_fz.getTotal895()));
		/*占比*/
		summary_fz.setCd891Zb(check.DoubleTo4(check.division(summary_fz.getCd891(), summary_fz.getTotal891())));
		summary_fz.setWh891Zb(check.DoubleTo4(check.division(summary_fz.getWh891(), summary_fz.getTotal891())));
		summary_fz.setCd895Zb(check.DoubleTo4(check.division(summary_fz.getCd895(), summary_fz.getTotal895())));
		summary_fz.setWh895Zb(check.DoubleTo4(check.division(summary_fz.getWh895(), summary_fz.getTotal895())));
		summary_fz.setCdRealZb(check.DoubleTo4(check.division(summary_fz.getCdReal(),summary_fz.getTotalReal())));
		summary_fz.setWhRealZb(check.DoubleTo4(check.division(summary_fz.getWhReal(),summary_fz.getTotalReal())));
		summary_fz.setDate(date);
		
		/****************************************** 外汇*********************************/
		/*任务量*/
		summary_wh.setItemName("2 外汇");
		summary_wh.setItemCode("zhcl_wh");
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_wh.setWhReal(dao.countCDouble("clwh","t_hn_new",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_wh.setCdReal(dao.countCDouble("clwh","t_hn_new",sql));
		/*合计*/
		summary_wh.setTotalReal(check.DoubleTo0(summary_wh.getWhReal()+summary_wh.getCdReal()));
		/*占比*/
		summary_wh.setCdRealZb(check.DoubleTo4(check.division(summary_wh.getCdReal(),summary_wh.getTotalReal())));
		summary_wh.setWhRealZb(check.DoubleTo4(check.division(summary_wh.getWhReal(),summary_wh.getTotalReal())));
		summary_wh.setDate(date);
		
		/******************************************稽核*********************************/
		/*任务量*/
		summary_jh.setItemName("3 稽核");
		summary_jh.setItemCode("zhcl_jh");
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_jh.setWhReal(dao.countCDouble("cljh","t_hn_new",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_jh.setCdReal(dao.countCDouble("cljh","t_hn_new",sql));
		/*合计*/
		summary_jh.setTotalReal(check.DoubleTo0(summary_jh.getWhReal()+summary_jh.getCdReal()));
		/*占比*/
		summary_jh.setCdRealZb(check.DoubleTo4(check.division(summary_jh.getCdReal(),summary_jh.getTotalReal())));
		summary_jh.setWhRealZb(check.DoubleTo4(check.division(summary_jh.getWhReal(),summary_jh.getTotalReal())));
		summary_jh.setDate(date);
		
		/****************************************** 远程审核*********************************/
		/*任务量*/
		summary_sh.setItemName("4 远程审核");
		summary_sh.setItemCode("zhcl_sh");
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_sh.setWhReal(dao.countCDouble("clsh","t_hn_new",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_sh.setCdReal(dao.countCDouble("clsh","t_hn_new",sql));
		/*合计*/
		summary_sh.setTotalReal(check.DoubleTo0(summary_sh.getWhReal()+summary_sh.getCdReal()));
		/*占比*/
		summary_sh.setCdRealZb(check.DoubleTo4(check.division(summary_sh.getCdReal(),summary_sh.getTotalReal())));
		summary_sh.setWhRealZb(check.DoubleTo4(check.division(summary_sh.getWhReal(),summary_sh.getTotalReal())));
		summary_sh.setDate(date);
		
		/****************************************** 建亚*********************************/
		/*任务量*/
		summary_jy.setItemName("5 建亚");
		summary_jy.setItemCode("zhcl_jy");
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_jy.setWhReal(dao.countCDouble("cljy","t_hn_new",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_jy.setCdReal(dao.countCDouble("cljy","t_hn_new",sql));
		/*合计*/
		summary_jy.setTotalReal(check.DoubleTo0(summary_jy.getWhReal()+summary_jy.getCdReal()));
		/*占比*/
		summary_jy.setCdRealZb(check.DoubleTo4(check.division(summary_jy.getCdReal(),summary_jy.getTotalReal())));
		summary_jy.setWhRealZb(check.DoubleTo4(check.division(summary_jy.getWhReal(),summary_jy.getTotalReal())));
		summary_jy.setDate(date);
		
		/****************************************** 反洗钱*********************************/
		/*任务量*/
		summary_fxq.setItemName("6 反洗钱");
		summary_fxq.setItemCode("zhcl_fxq");
		/*武汉中心*/
		sql="where zx=1 and date='"+date+"'" ;
		summary_fxq.setWhReal(dao.countCDouble("clfxq","t_hn_new",sql));
		/*成都中心*/
		sql="where zx=0 and date='"+date+"'" ;
		summary_fxq.setCdReal(dao.countCDouble("clfxq","t_hn_new",sql));
		/*合计*/
		summary_fxq.setTotalReal(check.DoubleTo0(summary_fxq.getWhReal()+summary_fxq.getCdReal()));
		/*占比*/
		summary_fxq.setCdRealZb(check.DoubleTo4(check.division(summary_fxq.getCdReal(),summary_fxq.getTotalReal())));
		summary_fxq.setWhRealZb(check.DoubleTo4(check.division(summary_fxq.getWhReal(),summary_fxq.getTotalReal())));
		summary_fxq.setDate(date);
		
		
		/****************************折合产量****************************/
		/*任务量*/
		summary.setItemName("三、折合产量");
		summary.setItemCode("zhcl");
		summary.setWhReal(summary_rmb.getWhReal()+summary_wh.getWhReal()+summary_jh.getWhReal()+summary_sh.getWhReal()+summary_jy.getWhReal()+summary_fxq.getWhReal());
		/*成都中心*/
		summary.setCdReal(summary_rmb.getCdReal()+summary_wh.getCdReal()+summary_jh.getCdReal()+summary_sh.getCdReal()+summary_jy.getCdReal()+summary_fxq.getCdReal());
		/*合计*/
		summary.setTotalReal(check.DoubleTo0(summary.getWhReal()+summary.getCdReal()));
		/*占比*/
		summary.setCdRealZb(check.DoubleTo4(check.division(summary.getCdReal(),summary.getTotalReal())));
		summary.setWhRealZb(check.DoubleTo4(check.division(summary.getWhReal(),summary.getTotalReal())));
		summary.setDate(date);
		
		dao.save(summary);
		dao.save(summary_rmb);
		dao.save(summary_zz);
		dao.save(summary_fz);
		dao.save(summary_wh);
		dao.save(summary_jh);
		dao.save(summary_sh);
		dao.save(summary_jy);
		dao.save(summary_fxq);
		
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
	
	/*人均折合产量*/
	public String  averTask()
	{
		GeneralCheck check=new GeneralCheck();
				
		String result="";
		date=date.replace("-", "");
		SummaryDailyDAO dao=new SummaryDailyDAO();
		SummaryDaily summary=new SummaryDaily();
		
		SummaryDaily zz_zhcl=new SummaryDaily();
		SummaryDaily zhcl=new SummaryDaily();
		SummaryDaily fz_zhcl=new SummaryDaily();
		SummaryDaily rs=new SummaryDaily();
		SummaryDaily zz_rs=new SummaryDaily();
		SummaryDaily fz_rs=new SummaryDaily();
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
			/******************************************总产量*************************/
			zhcl=dao.findByItemcodeDate("zhcl", date);
			rs=dao.findByItemcodeDate("rs", date);
			summary.setItemName("四、人均折合产量");
			summary.setItemCode("rjcl");
			summary.setWhReal((check.DoubleTo0(check.division(zhcl.getWhReal(),rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(zhcl.getCdReal(), rs.getCdReal()))));
			summary.setTotalReal((check.DoubleTo0(check.division(zhcl.getTotalReal(), rs.getTotalReal()))));
			summary.setDate(date);
			dao.save(summary);
			
			/******************************************人民币*************************/
			/*统计产量*/
			zhcl=dao.findByItemcodeDate("zhcl_rmb", date);
			rs=dao.findByItemcodeDate("rs_rmb", date);
			/*人均折合产量*/
			summary=new SummaryDaily();
			summary.setItemName("1 人民币");
			summary.setItemCode("rjcl_rmb");
			summary.setWh891(check.DoubleTo0(check.division(zhcl.getWh891(), rs.getWh891())));
			summary.setWh895(check.DoubleTo0(check.division(zhcl.getWh895(), rs.getWh895())));
			summary.setCd891(check.DoubleTo0(check.division(zhcl.getCd891(), rs.getCd891())));
			summary.setCd895(check.DoubleTo0(check.division(zhcl.getCd895(), rs.getCd895())));
			summary.setTotal891(check.DoubleTo0(check.division(zhcl.getTotal891(), rs.getTotal891())));
			summary.setTotal895(check.DoubleTo0(check.division(zhcl.getTotal895(), rs.getTotal895())));
			summary.setTotalReal((check.DoubleTo0(check.division(zhcl.getTotalReal(), rs.getTotalReal()))));
			summary.setWhReal((check.DoubleTo0(check.division(zhcl.getWhReal(),rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(zhcl.getCdReal(), rs.getCdReal()))));
			summary.setDate(date);
			dao.save(summary);
			
			/*行内专职人员*/
			zz_zhcl=dao.findByItemcodeDate("zhcl_zz", date);
			zz_rs=dao.findByItemcodeDate("rs_zz", date);
			summary=new SummaryDaily();
			summary.setItemName("① 人民币专职人员");
			summary.setItemCode("rjcl_zz");
			summary.setWh891(check.DoubleTo0(check.division(zz_zhcl.getWh891(), zz_rs.getWh891())));
			summary.setWh895(check.DoubleTo0(check.division(zz_zhcl.getWh895(), zz_rs.getWh895())));
			summary.setCd891(check.DoubleTo0(check.division(zz_zhcl.getCd891(), zz_rs.getCd891())));
			summary.setCd895(check.DoubleTo0(check.division(zz_zhcl.getCd895(), zz_rs.getCd895())));
			summary.setTotal891(check.DoubleTo0(check.division(zz_zhcl.getTotal891(), zz_rs.getTotal891())));
			summary.setTotal895(check.DoubleTo0(check.division(zz_zhcl.getTotal895(), zz_rs.getTotal895())));
			summary.setTotalReal((check.DoubleTo0(check.division(zz_zhcl.getTotalReal(), zz_rs.getTotalReal()))));
			summary.setWhReal((check.DoubleTo0(check.division(zz_zhcl.getWhReal(),zz_rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(zz_zhcl.getCdReal(), zz_rs.getCdReal()))));
			summary.setDate(date);
			dao.save(summary);
			
			/*行内非专职人员*/
			fz_zhcl=dao.findByItemcodeDate("zhcl_fz", date);
			fz_rs=dao.findByItemcodeDate("rs_fz", date);
			summary=new SummaryDaily();
			summary.setItemName("② 人民币其他人员");
			summary.setItemCode("rjcl_fz");
			summary.setWh891(check.DoubleTo0(check.division(fz_zhcl.getWh891(), fz_rs.getWh891())));
			summary.setWh895(check.DoubleTo0(check.division(fz_zhcl.getWh895(), fz_rs.getWh895())));
			summary.setCd891(check.DoubleTo0(check.division(fz_zhcl.getCd891(), fz_rs.getCd891())));
			summary.setCd895(check.DoubleTo0(check.division(fz_zhcl.getCd895(), fz_rs.getCd895())));
			summary.setTotal891(check.DoubleTo0(check.division(fz_zhcl.getTotal891(), fz_rs.getTotal891())));
			summary.setTotal895(check.DoubleTo0(check.division(fz_zhcl.getTotal895(), fz_rs.getTotal895())));
			summary.setTotalReal((check.DoubleTo0(check.division(fz_zhcl.getTotalReal(), fz_rs.getTotalReal()))));
			summary.setWhReal((check.DoubleTo0(check.division(fz_zhcl.getWhReal(),fz_rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(fz_zhcl.getCdReal(), fz_rs.getCdReal()))));
			summary.setDate(date);
			dao.save(summary);
			
			/******************************************外汇*************************/
			zhcl=dao.findByItemcodeDate("zhcl_wh", date);
			rs=dao.findByItemcodeDate("rs_wh", date);
			summary=new SummaryDaily();
			summary.setItemName("2 外汇");
			summary.setItemCode("rjcl_wh");
			summary.setWhReal((check.DoubleTo0(check.division(zhcl.getWhReal(),rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(zhcl.getCdReal(), rs.getCdReal()))));
			summary.setTotalReal((check.DoubleTo0(check.division(zhcl.getTotalReal(), rs.getTotalReal()))));
			summary.setDate(date);
			dao.save(summary);
			
			/******************************************稽核*************************/
			zhcl=dao.findByItemcodeDate("zhcl_jh", date);
			rs=dao.findByItemcodeDate("rs_jh", date);
			summary=new SummaryDaily();
			summary.setItemName("3 稽核");
			summary.setItemCode("rjcl_jh");
			summary.setWhReal((check.DoubleTo0(check.division(zhcl.getWhReal(),rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(zhcl.getCdReal(), rs.getCdReal()))));
			summary.setTotalReal((check.DoubleTo0(check.division(zhcl.getTotalReal(), rs.getTotalReal()))));
			summary.setDate(date);
			dao.save(summary);
			
			/******************************************远程审核*************************/
			zhcl=dao.findByItemcodeDate("zhcl_sh", date);
			rs=dao.findByItemcodeDate("rs_sh", date);
			summary=new SummaryDaily();
			summary.setItemName("4 远程审核");
			summary.setItemCode("rjcl_sh");
			summary.setWhReal((check.DoubleTo0(check.division(zhcl.getWhReal(),rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(zhcl.getCdReal(), rs.getCdReal()))));
			summary.setTotalReal((check.DoubleTo0(check.division(zhcl.getTotalReal(), rs.getTotalReal()))));
			summary.setDate(date);
			dao.save(summary);
			
			/******************************************建亚*************************/
			zhcl=dao.findByItemcodeDate("zhcl_jy", date);
			rs=dao.findByItemcodeDate("rs_jy", date);
			summary=new SummaryDaily();
			summary.setItemName("5 建亚");
			summary.setItemCode("rjcl_jy");
			summary.setWhReal((check.DoubleTo0(check.division(zhcl.getWhReal(),rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(zhcl.getCdReal(), rs.getCdReal()))));
			summary.setTotalReal((check.DoubleTo0(check.division(zhcl.getTotalReal(), rs.getTotalReal()))));
			summary.setDate(date);
			dao.save(summary);
			
			/******************************************反洗钱*************************/
			zhcl=dao.findByItemcodeDate("zhcl_fxq", date);
			rs=dao.findByItemcodeDate("rs_fxq", date);
			summary=new SummaryDaily();
			summary.setItemName("6 反洗钱");
			summary.setItemCode("rjcl_fxq");
			summary.setWhReal((check.DoubleTo0(check.division(zhcl.getWhReal(),rs.getWhReal()))));
			summary.setCdReal((check.DoubleTo0(check.division(zhcl.getCdReal(), rs.getCdReal()))));
			summary.setTotalReal((check.DoubleTo0(check.division(zhcl.getTotalReal(), rs.getTotalReal()))));
			summary.setDate(date);
			dao.save(summary);
		
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
	/*作业质量*/
	public String Zyzl()
	{
		String result="";
		GeneralCheck check=new GeneralCheck();
		//ControlDAO condao = new ControlDAO();
		//Control control = (Control) condao.findAll().get(0);
		HnConfigDAO hcdao = new HnConfigDAO();
		Xishu xszz = hcdao.getConfigByType(1);//专职
		Xishu xsfz = hcdao.getConfigByType(2);//非专职
		double lr891 = Double.valueOf(xszz.getXs3());
		double jh891 = Double.valueOf(xszz.getXs5());
		double lr895 = Double.valueOf(xsfz.getXs3());
		double jh895 = Double.valueOf(xsfz.getXs5());
		date=date.replace("-", "");
		SummaryDailyDAO dao=new SummaryDailyDAO();
		SummaryDaily lrxg=new SummaryDaily();
		String sql="";
		int cl=0;
		int cc=0;
		double wh891cl=0.0;
		double wh895cl=0.0;
		double cd891cl=0.0;
		double cd895cl=0.0;
		double wh891cc=0.0;
		double wh895cc=0.0;
		double cd891cc=0.0;
		double cd895cc=0.0;
		double ccl=0;
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
		/*----------------------------------------------作业质量----------------------------------------------*/
		/*武汉*/
		lrxg.setItemName("五、作业质量");
		lrxg.setItemCode("lv");
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------作业差错率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("作业差错率");
		lrxg.setItemCode("lv_zyccl");
		sql = "SELECT sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz) from t_hn_new where date='"+date+"'";
		wh891cc = check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) from t_hn_new where date='"+date+"'";
		wh891cl = check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		lrxg.setTotalReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		
		sql = "SELECT sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz) from t_hn_new where date='"+date+"' and zx=0";
		wh891cc = check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) from t_hn_new where date='"+date+"' and zx=0";
		wh891cl = check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		lrxg.setCdReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		
		sql = "SELECT sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz) from t_hn_new where date='"+date+"' and zx=1";
		wh891cc = check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		sql = "SELECT sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) from t_hn_new where date='"+date+"' and zx=1";
		wh891cl = check.IsNullDouble(session.createSQLQuery(sql).uniqueResult());
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------人民币差错率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("1 人民币差错率");
		lrxg.setItemCode("lv_rmb");
		//武汉891
		sql="where zx='1' and time='"+date+"'";
		wh891cl=dao.countColumn("lrxg","hn891",sql)*lr891+dao.countColumn("jhxg","hn891",sql)*jh891;
		wh891cc=dao.countColumn("lrcc","hn891",sql)*lr891+dao.countColumn("jhcc","hn891",sql)*jh891;
		lrxg.setWh891(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		//武汉895
		sql="where zx='1' and time='"+date+"'";
		wh895cl=dao.countColumn("lrxg","hn895",sql)*lr895+dao.countColumn("jhxg","hn895",sql)*jh895;
		wh895cc=dao.countColumn("lrcc","hn895",sql)*lr895+dao.countColumn("jhcc","hn895",sql)*jh895;
		lrxg.setWh895(check.DoubleTo4(check.division(wh895cc, wh895cl)));
		
		//成都891
		sql="where zx='0' and time='"+date+"'";
		cd891cl=dao.countColumn("lrxg","hn891",sql)*lr891+dao.countColumn("jhxg","hn891",sql)*jh891;
		cd891cc=dao.countColumn("lrcc","hn891",sql)*lr891+dao.countColumn("jhcc","hn891",sql)*jh891;
		lrxg.setCd891(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		//成都895
		sql="where zx='0' and time='"+date+"'";
		cd895cl=dao.countColumn("lrxg","hn895",sql)*lr895+dao.countColumn("jhxg","hn895",sql)*jh895;
		cd895cc=dao.countColumn("lrcc","hn895",sql)*lr895+dao.countColumn("jhcc","hn895",sql)*jh895;
		lrxg.setCd895(check.DoubleTo4(check.division(cd895cc, cd895cl)));
		//武汉中心小计
		lrxg.setWhReal(check.DoubleTo4(check.division((wh891cc+wh895cc),(wh891cl+wh895cl))));
		//成都中心小计
		lrxg.setCdReal(check.DoubleTo4(check.division((cd891cc+cd895cc),(cd891cl+cd895cl))));
		//891合计
		lrxg.setTotal891(check.DoubleTo4(check.division((cd891cc+wh891cc),(cd891cl+wh891cl))));
		//895合计
		lrxg.setTotal895(check.DoubleTo4(check.division((cd895cc+wh895cc),(cd895cl+wh895cl))));
		//合计
		lrxg.setTotalReal(check.DoubleTo4(check.division((cd891cc+wh891cc+cd895cc+wh895cc),(cd891cl+wh891cl+cd895cl+wh895cl))));
		
		lrxg.setDate(date);
		dao.save(lrxg);
		
		
		/*----------------------------------------------人民币录入修改差错率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("① 录入修改差错率");
		lrxg.setItemCode("lv_lrxg");
		//武汉
		sql="where zx='1' and time='"+date+"'";
		wh891cl=dao.countColumn("lrxg","hn891",sql);
		wh891cc=dao.countColumn("lrcc","hn891",sql);
		lrxg.setWh891(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*根据产量判断显示标准*/
		if(wh891cl>0)
			lrxg.setRemark1("1");
		else/*不显示*/
			lrxg.setRemark1("0");
		wh895cl=dao.countColumn("lrxg","hn895",sql);
		wh895cc=dao.countColumn("lrcc","hn895",sql);
		lrxg.setWh895(check.DoubleTo4(check.division(wh895cc, wh895cl)));
		/*成都*/
		sql="where zx='0' and time='"+date+"'";
		cd891cl=dao.countColumn("lrxg","hn891",sql);
		cd891cc=dao.countColumn("lrcc","hn891",sql);
		lrxg.setCd891(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		cd895cl=dao.countColumn("lrxg","hn895",sql);
		cd895cc=dao.countColumn("lrcc","hn895",sql);
		lrxg.setCd895(check.DoubleTo4(check.division(cd895cc, cd895cl)));
		/*合计*/
		lrxg.setTotal891(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setTotal895(check.DoubleTo4(check.division((wh895cc+cd895cc), (wh895cl+cd895cl))));
		lrxg.setWhReal(check.DoubleTo4(check.division((wh891cc*lr891+wh895cc*lr895), (wh891cl*lr891+wh895cl*lr895))));
		lrxg.setCdReal(check.DoubleTo4(check.division((cd891cc*lr891+cd895cc*lr895), (cd891cl*lr891+cd895cl*lr895))));
		lrxg.setTotalReal(check.DoubleTo4(check.division(((wh891cc+cd891cc)*lr891+(wh895cc+cd895cc)*lr895), ((wh891cl+cd891cl)*lr891+(wh895cl+cd895cl)*lr895))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		
		/*----------------------------------------------人民币检核修改----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("② 检核修改差错率");
		lrxg.setItemCode("lv_jhxg");
		//武汉
		sql="where zx='1' and time='"+date+"'";
		wh891cl=dao.countColumn("jhxg","hn891",sql);
		wh891cc=dao.countColumn("jhcc","hn891",sql);
		lrxg.setWh891(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		wh895cl=dao.countColumn("jhxg","hn895",sql);
		wh895cc=dao.countColumn("jhcc","hn895",sql);
		lrxg.setWh895(check.DoubleTo4(check.division(wh895cc, wh895cl)));
		/*成都*/
		sql="where zx='0' and time='"+date+"'";
		cd891cl=dao.countColumn("jhxg","hn891",sql);
		cd891cc=dao.countColumn("jhcc","hn891",sql);
		lrxg.setCd891(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		cd895cl=dao.countColumn("jhxg","hn895",sql);
		cd895cc=dao.countColumn("jhcc","hn895",sql);
		lrxg.setCd895(check.DoubleTo4(check.division(cd895cc, cd895cl)));
		/*合计*/
		lrxg.setTotal891(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setTotal895(check.DoubleTo4(check.division((wh895cc+cd895cc), (wh895cl+cd895cl))));
		lrxg.setWhReal(check.DoubleTo4(check.division((wh891cc*jh891+wh895cc*jh895), (wh891cl*jh891+wh895cl*jh895))));
		lrxg.setCdReal(check.DoubleTo4(check.division((cd891cc*jh891+cd895cc*jh895), (cd891cl*jh891+cd895cl*jh895))));
		lrxg.setTotalReal(check.DoubleTo4(check.division(((wh891cc+cd891cc)*jh891+(wh895cc+cd895cc)*jh895), ((wh891cl+cd891cl)*jh891+(wh895cl+cd895cl)*jh895))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------人民币业务退票率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("③ 业务退票率");
		lrxg.setItemCode("lv_tp");
		//武汉
		sql="where zx='1' and time='"+date+"'";
		wh891cl=dao.countColumn("ywl","hn891",sql);
		wh891cc=dao.countColumn("lrtp","hn891",sql);
		lrxg.setWh891(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		wh895cl=dao.countColumn("ywl","hn895",sql);
		wh895cc=dao.countColumn("lrtp","hn895",sql);
		lrxg.setWh895(check.DoubleTo4(check.division(wh895cc, wh895cl)));
		/*成都*/
		sql="where zx='0' and time='"+date+"'";
		cd891cl=dao.countColumn("ywl","hn891",sql);
		cd891cc=dao.countColumn("lrtp","hn891",sql);
		lrxg.setCd891(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		cd895cl=dao.countColumn("ywl","hn895",sql);
		cd895cc=dao.countColumn("lrtp","hn895",sql);
		lrxg.setCd895(check.DoubleTo4(check.division(cd895cc, cd895cl)));
		/*合计*/
		lrxg.setTotal891(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setTotal895(check.DoubleTo4(check.division((wh895cc+cd895cc), (wh895cl+cd895cl))));
		lrxg.setWhReal(check.DoubleTo4(check.division((wh891cc+wh895cc), (wh891cl+wh895cl))));
		lrxg.setCdReal(check.DoubleTo4(check.division((cd891cc+cd895cc), (cd891cl+cd895cl))));
		lrxg.setTotalReal(check.DoubleTo4(check.division(((wh891cc+cd891cc)+(wh895cc+cd895cc)), ((wh891cl+cd891cl)+(wh895cl+cd895cl)))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		
		
		/*----------------------------------------------人民币查询查复率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("④ 查询查复率");
		lrxg.setItemCode("lv_cx");
		//武汉
		sql="where zx='1' and time='"+date+"'";
		wh891cl=dao.countCDouble("ywl","hn891_ls",sql);
		wh891cc=dao.countCDouble("cx","hn891_ls",sql);
		lrxg.setWh891(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		wh895cl=dao.countCDouble("ywl","hn895_ls",sql);
		wh895cc=dao.countCDouble("cx","hn895_ls",sql);
		lrxg.setWh895(check.DoubleTo4(check.division(wh895cc, wh895cl)));
		/*成都*/
		sql="where zx='0' and time='"+date+"'";
		cd891cl=dao.countColumn("ywl","hn891_ls",sql);
		cd891cc=dao.countColumn("cx","hn891_ls",sql);
		lrxg.setCd891(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		cd895cl=dao.countColumn("ywl","hn895_ls",sql);
		cd895cc=dao.countColumn("cx","hn895_ls",sql);
		lrxg.setCd895(check.DoubleTo4(check.division(cd895cc, cd895cl)));
		/*合计*/
		lrxg.setTotal891(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setTotal895(check.DoubleTo4(check.division((wh895cc+cd895cc), (wh895cl+cd895cl))));
		lrxg.setWhReal(check.DoubleTo4(check.division((wh891cc+wh895cc), (wh891cl+wh895cl))));
		lrxg.setCdReal(check.DoubleTo4(check.division((cd891cc+cd895cc), (cd891cl+cd895cl))));
		lrxg.setTotalReal(check.DoubleTo4(check.division(((wh891cc+cd891cc)+(wh895cc+cd895cc)), ((wh891cl+cd891cl)+(wh895cl+cd895cl)))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		
		/*----------------------------------------------人民币转网点占比----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("⑤ 转网点占比");
		lrxg.setItemCode("lv_zwd");
		//武汉
		sql="where zx='1' and time='"+date+"'";
		wh891cl=dao.countCDouble("qdlr","t_hn_detail_ls",sql);
		wh891cc=dao.countCDouble("qdlrz","t_hn_detail_ls",sql);
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		lrxg.setWh891(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx='0' and time='"+date+"'";
		cd891cl=dao.countCDouble("qdlr","t_hn_detail_ls",sql);
		cd891cc=dao.countCDouble("qdlrz","t_hn_detail_ls",sql);
		lrxg.setCdReal(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		lrxg.setCd891(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		/*合计*/
		lrxg.setTotal891(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setTotalReal(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		
		/*----------------------------------------------外汇差错率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("2 外汇差错率");
		lrxg.setItemCode("lv_wh_ccl");
		//武汉
		sql="where zx=1 and date='"+date+"'";
		wh891cl=dao.countCDouble("cclwh_fm","t_hn_new",sql);
		wh891cc=dao.countCDouble("cclwh_fz","t_hn_new",sql);
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx=0 and date='"+date+"'";
		cd891cl=dao.countCDouble("cclwh_fm","t_hn_new",sql);
		cd891cc=dao.countCDouble("cclwh_fz","t_hn_new",sql);
		lrxg.setCdReal(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------外汇业务退票率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("① 外汇退票率");
		lrxg.setItemCode("lv_wh_tp");
		//武汉
		sql="where zx='1' and date='"+date+"'";
		wh891cl=dao.countColumn("ywl","t_hn_waihui",sql);
		wh891cc=dao.countColumn("tp","t_hn_waihui",sql);
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx='0' and date='"+date+"'";
		cd891cl=dao.countColumn("ywl","t_hn_waihui",sql);
		cd891cc=dao.countColumn("tp","t_hn_waihui",sql);
		lrxg.setCdReal(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------外汇业务查询率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("② 外汇查询率");
		lrxg.setItemCode("lv_wh_cx");
		//武汉
		sql="where zx='1' and date='"+date+"'";
		wh891cl=dao.countColumn("ywl","t_hn_waihui",sql);
		wh891cc=dao.countColumn("cx","t_hn_waihui",sql);
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx='0' and date='"+date+"'";
		cd891cl=dao.countColumn("ywl","t_hn_waihui",sql);
		cd891cc=dao.countColumn("cx","t_hn_waihui",sql);
		lrxg.setCdReal(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		/*----------------------------------------------外汇业务驳回率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("③ 外汇驳回率");
		lrxg.setItemCode("lv_wh_bh");
		//武汉
		sql="where zx='1' and date='"+date+"'";
		wh891cl=dao.countColumn("zyfs","t_hn_waihui",sql);
		wh891cc=dao.countColumn("bh","t_hn_waihui",sql);
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx='0' and date='"+date+"'";
		cd891cl=dao.countColumn("zyfs","t_hn_waihui",sql);
		cd891cc=dao.countColumn("bh","t_hn_waihui",sql);
		lrxg.setCdReal(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------建亚差错率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("3 建亚差错率");
		lrxg.setItemCode("lv_jy_ccl");
		//武汉
		sql="where zx=1 and date='"+date+"'";
		wh891cl=dao.countCDouble("ccljy_fm","t_hn_new",sql);
		wh891cc=dao.countCDouble("ccljy_fz","t_hn_new",sql);
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx=0 and date='"+date+"'";
		cd891cl=dao.countCDouble("ccljy_fm","t_hn_new",sql);
		cd891cc=dao.countCDouble("ccljy_fz","t_hn_new",sql);
		lrxg.setCdReal(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------建亚业务退票率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("① 建亚退票率");
		lrxg.setItemCode("lv_jy_tp");
		//武汉
		sql="where zx='1' and date='"+date+"'";
		wh891cl=dao.countColumn("ywl","t_hn_jianya",sql);
		wh891cc=dao.countColumn("tp","t_hn_jianya",sql);
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx='0' and date='"+date+"'";
		cd891cl=dao.countColumn("ywl","t_hn_jianya",sql);
		cd891cc=dao.countColumn("tp","t_hn_jianya",sql);
		lrxg.setCdReal(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------建亚业务查询率----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("② 建亚查询率");
		lrxg.setItemCode("lv_jy_cx");
		//武汉
		sql="where zx='1' and date='"+date+"'";
		wh891cl=dao.countColumn("ywl","t_hn_jianya",sql);
		wh891cc=dao.countColumn("cx","t_hn_jianya",sql);
		lrxg.setWhReal(check.DoubleTo4(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx='0' and date='"+date+"'";
		cd891cl=dao.countColumn("ywl","t_hn_jianya",sql);
		cd891cc=dao.countColumn("cx","t_hn_jianya",sql);
		lrxg.setCdReal(check.DoubleTo4(check.division(cd891cc, cd891cl)));
		
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo4(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
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
	/*作业质量*/
	public String xl()
	{
		String result="";
		GeneralCheck check=new GeneralCheck();
		//ControlDAO condao = new ControlDAO();
		//Control control = (Control) condao.findAll().get(0);		
		date=date.replace("-", "");
		SummaryDailyDAO dao=new SummaryDailyDAO();
		SummaryDaily lrxg=new SummaryDaily();
		String sql="";
		//int cl=0;
		//int cc=0;
		double wh891cl=0.0;
		double wh895cl=0.0;
		double cd891cl=0.0;
		double cd895cl=0.0;
		double wh891cc=0.0;
		double wh895cc=0.0;
		double cd891cc=0.0;
		double cd895cc=0.0;
		double ccl=0;
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
		/*----------------------------------------------作业效率----------------------------------------------*/
		/*武汉*/
		lrxg.setItemName("六、作业效率");
		lrxg.setItemCode("xl");
		lrxg.setDate(date);
		//武汉
		sql="where zx=1 and date='"+date+"'";
		wh891cl=dao.countCDouble("xlrmb_fm+xlwh_fm+xljh_fm+xlsh_fm+xljy_fm","t_hn_new",sql);
		wh891cc=dao.countCDouble("xlrmb_fz+xlwh_fz+xljh_fz+xlsh_fz+xljy_fz","t_hn_new",sql);
		lrxg.setWhReal(check.DoubleTo2(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx=0 and date='"+date+"'";
		cd891cl=dao.countCDouble("xlrmb_fm+xlwh_fm+xljh_fm+xlsh_fm+xljy_fm","t_hn_new",sql);
		cd891cc=dao.countCDouble("xlrmb_fz+xlwh_fz+xljh_fz+xlsh_fz+xljy_fz","t_hn_new",sql);
		lrxg.setCdReal(check.DoubleTo2(check.division(cd891cc, cd891cl)));
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo2(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		//----------------------------------------------单位产能作业时间----------------------------------------------
		lrxg=new SummaryDaily();
		lrxg.setItemName("1 人民币业务");
		lrxg.setItemCode("xl_rmb");
		//lrxg.setRemark1("0");//不显示
		//武汉
		sql="where zx='1' and time='"+date+"'";
		wh891cl=dao.countCDouble("zhcl","hn891_ls",sql);
		wh891cc=dao.countCDouble("sumxl","hn891_ls",sql);
		lrxg.setWh891(check.DoubleTo2(check.division(wh891cc, wh891cl)));
		wh895cl=dao.countCDouble("zhcl","hn895_ls",sql);
		wh895cc=dao.countCDouble("sumxl","hn895_ls",sql);
		lrxg.setWh895(check.DoubleTo2(check.division(wh895cc, wh895cl)));
		/*成都*/
		sql="where zx='0' and time='"+date+"'";
		cd891cl=dao.countCDouble("zhcl","hn891_ls",sql);
		cd891cc=dao.countCDouble("sumxl","hn891_ls",sql);
		lrxg.setCd891(check.DoubleTo2(check.division(cd891cc, cd891cl)));
		cd895cl=dao.countCDouble("zhcl","hn895_ls",sql);
		cd895cc=dao.countCDouble("sumxl","hn895_ls",sql);
		lrxg.setCd895(check.DoubleTo2(check.division(cd895cc, cd895cl)));
		/*合计*/
		lrxg.setTotal891(check.DoubleTo2(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setTotal895(check.DoubleTo2(check.division((wh895cc+cd895cc), (wh895cl+cd895cl))));
		lrxg.setWhReal(check.DoubleTo2(check.division((wh891cc+wh895cc), (wh891cl+wh895cl))));
		lrxg.setCdReal(check.DoubleTo2(check.division((cd891cc+cd895cc), (cd891cl+cd895cl))));
		lrxg.setTotalReal(check.DoubleTo2(check.division(((wh891cc+cd891cc)+(wh895cc+cd895cc)), ((wh891cl+cd891cl)+(wh895cl+cd895cl)))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------单位产能作业时间-行内专职----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("其中：行内专职");
		lrxg.setItemCode("xl_rmb_hn");
		//lrxg.setRemark1("0");//不显示
		//武汉
		sql="where zx='1' and xz in('0','2') and time='"+date+"'";
		wh891cl=dao.countCDouble("zhcl","hn891_ls",sql);
		wh891cc=dao.countCDouble("sumxl","hn891_ls",sql);
		lrxg.setWh891(check.DoubleTo2(check.division(wh891cc, wh891cl)));
		wh895cl=dao.countCDouble("zhcl","hn895_ls",sql);
		wh895cc=dao.countCDouble("sumxl","hn895_ls",sql);
		lrxg.setWh895(check.DoubleTo2(check.division(wh895cc, wh895cl)));
		/*成都*/
		sql="where zx='0' and xz in('0','2') and time='"+date+"'";
		cd891cl=dao.countCDouble("zhcl","hn891_ls",sql);
		cd891cc=dao.countCDouble("sumxl","hn891_ls",sql);
		lrxg.setCd891(check.DoubleTo2(check.division(cd891cc, cd891cl)));
		cd895cl=dao.countCDouble("zhcl","hn895_ls",sql);
		cd895cc=dao.countCDouble("sumxl","hn895_ls",sql);
		lrxg.setCd895(check.DoubleTo2(check.division(cd895cc, cd895cl)));
		/*合计*/
		lrxg.setTotal891(check.DoubleTo2(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setTotal895(check.DoubleTo2(check.division((wh895cc+cd895cc), (wh895cl+cd895cl))));
		lrxg.setWhReal(check.DoubleTo2(check.division((wh891cc+wh895cc), (wh891cl+wh895cl))));
		lrxg.setCdReal(check.DoubleTo2(check.division((cd891cc+cd895cc), (cd891cl+cd895cl))));
		lrxg.setTotalReal(check.DoubleTo2(check.division(((wh891cc+cd891cc)+(wh895cc+cd895cc)), ((wh891cl+cd891cl)+(wh895cl+cd895cl)))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		/*----------------------------------------------单位产能作业时间-行内其他----------------------------------------------*/
		lrxg=new SummaryDaily();
		lrxg.setItemName("其中：行内其他");
		lrxg.setItemCode("xl_rmb_fz");
		//lrxg.setRemark1("0");//不显示
		//武汉
		sql="where zx='1' and xz in (1,4) and time='"+date+"'";
		wh891cl=dao.countCDouble("zhcl","hn891_ls",sql);
		wh891cc=dao.countCDouble("sumxl","hn891_ls",sql);
		lrxg.setWh891(check.DoubleTo2(check.division(wh891cc, wh891cl)));
		wh895cl=dao.countCDouble("zhcl","hn895_ls",sql);
		wh895cc=dao.countCDouble("sumxl","hn895_ls",sql);
		lrxg.setWh895(check.DoubleTo2(check.division(wh895cc, wh895cl)));
		/*成都*/
		sql="where zx='0' and xz in (1,4) and time='"+date+"'";
		cd891cl=dao.countCDouble("zhcl","hn891_ls",sql);
		cd891cc=dao.countCDouble("sumxl","hn891_ls",sql);
		lrxg.setCd891(check.DoubleTo2(check.division(cd891cc, cd891cl)));
		cd895cl=dao.countCDouble("zhcl","hn895_ls",sql);
		cd895cc=dao.countCDouble("sumxl","hn895_ls",sql);
		lrxg.setCd895(check.DoubleTo2(check.division(cd895cc, cd895cl)));
		/*合计*/
		lrxg.setTotal891(check.DoubleTo2(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setTotal895(check.DoubleTo2(check.division((wh895cc+cd895cc), (wh895cl+cd895cl))));
		lrxg.setWhReal(check.DoubleTo2(check.division((wh891cc+wh895cc), (wh891cl+wh895cl))));
		lrxg.setCdReal(check.DoubleTo2(check.division((cd891cc+cd895cc), (cd891cl+cd895cl))));
		lrxg.setTotalReal(check.DoubleTo2(check.division(((wh891cc+cd891cc)+(wh895cc+cd895cc)), ((wh891cl+cd891cl)+(wh895cl+cd895cl)))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		//----------------------------------------------单位产能作业时间----------------------------------------------
		lrxg=new SummaryDaily();
		lrxg.setItemName("2 外汇业务");
		lrxg.setItemCode("xl_wh");
		//lrxg.setRemark1("0");//不显示
		//武汉
		sql="where zx=1 and date='"+date+"'";
		wh891cl=dao.countCDouble("xlwh_fm","t_hn_new",sql);
		wh891cc=dao.countCDouble("xlwh_fz","t_hn_new",sql);
		lrxg.setWhReal(check.DoubleTo2(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx=0 and date='"+date+"'";
		cd891cl=dao.countCDouble("xlwh_fm","t_hn_new",sql);
		cd891cc=dao.countCDouble("xlwh_fz","t_hn_new",sql);
		lrxg.setCdReal(check.DoubleTo2(check.division(cd891cc, cd891cl)));
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo2(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		//----------------------------------------------单位产能作业时间----------------------------------------------
		lrxg=new SummaryDaily();
		lrxg.setItemName("3 稽核");
		lrxg.setItemCode("xl_jh");
		//lrxg.setRemark1("0");//不显示
		//武汉
		sql="where zx=1 and date='"+date+"'";
		wh891cl=dao.countCDouble("xljh_fm","t_hn_new",sql);
		wh891cc=dao.countCDouble("xljh_fz","t_hn_new",sql);
		lrxg.setWhReal(check.DoubleTo2(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx=0 and date='"+date+"'";
		cd891cl=dao.countCDouble("xljh_fm","t_hn_new",sql);
		cd891cc=dao.countCDouble("xljh_fz","t_hn_new",sql);
		lrxg.setCdReal(check.DoubleTo2(check.division(cd891cc, cd891cl)));
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo2(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		//----------------------------------------------单位产能作业时间----------------------------------------------
		lrxg=new SummaryDaily();
		lrxg.setItemName("4 远程审核");
		lrxg.setItemCode("xl_sh");
		//lrxg.setRemark1("0");//不显示
		//武汉
		sql="where zx=1 and date='"+date+"'";
		wh891cl=dao.countCDouble("xlsh_fm","t_hn_new",sql);
		wh891cc=dao.countCDouble("xlsh_fz","t_hn_new",sql);
		lrxg.setWhReal(check.DoubleTo2(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx=0 and date='"+date+"'";
		cd891cl=dao.countCDouble("xlsh_fm","t_hn_new",sql);
		cd891cc=dao.countCDouble("xlsh_fz","t_hn_new",sql);
		lrxg.setCdReal(check.DoubleTo2(check.division(cd891cc, cd891cl)));
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo2(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
		//----------------------------------------------单位产能作业时间----------------------------------------------
		lrxg=new SummaryDaily();
		lrxg.setItemName("5 建亚");
		lrxg.setItemCode("xl_jy");
		//lrxg.setRemark1("0");//不显示
		//武汉
		sql="where zx=1 and date='"+date+"'";
		wh891cl=dao.countCDouble("xljy_fm","t_hn_new",sql);
		wh891cc=dao.countCDouble("xljy_fz","t_hn_new",sql);
		lrxg.setWhReal(check.DoubleTo2(check.division(wh891cc, wh891cl)));
		/*成都*/
		sql="where zx=0 and date='"+date+"'";
		cd891cl=dao.countCDouble("xljy_fm","t_hn_new",sql);
		cd891cc=dao.countCDouble("xljy_fz","t_hn_new",sql);
		lrxg.setCdReal(check.DoubleTo2(check.division(cd891cc, cd891cl)));
		/*合计*/
		lrxg.setTotalReal(check.DoubleTo2(check.division((wh891cc+cd891cc), (wh891cl+cd891cl))));
		lrxg.setDate(date);
		dao.save(lrxg);
		
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
	public String updateStatus()
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
			status = new DailyStatus();
			status.setTime(date);
			status.setHnSummaryDaily(1);
			
		}
		else
		{
			if(status.getHnSummaryDaily()==null||status.getHnSummaryDaily().equals(null))
				i=1;
			else
				i=status.getHnSummaryDaily()+1;
			status.setHnSummaryDaily(i);
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
	
	/*计算查询率*/
//	public String Cxl()
//	{
//		String result="";
//		GeneralCheck check=new GeneralCheck();
//		Session session = HibernateSessionFactory.getSession();
//	    Transaction trans=session.beginTransaction();		
//		date=date.replace("-", "");
//		SummaryDailyDAO dao=new SummaryDailyDAO();
//		SummaryDaily lrxg=new SummaryDaily();
//		String sql="";
//		int cl=0;
//		double cxl=0;
//		int cc=0;
//		
//		try {
//		
//		/*录入修改差错率*/
//		/*武汉*/
//		lrxg=new SummaryDaily();
//		lrxg.setItemName("4 查询率");
//		lrxg.setItemCode("lv_cx");
//		sql="where zx='1' and time='"+date+"'";
//		cl=dao.countColumn("lrxg","hn891",sql);
//		cc=dao.countColumn("cx","hn891",sql);
//		cxl=check.DoubleTo4(check.division(cc, cl));
//		lrxg.setWh891(cxl);
//		
//		/*成都*/
//		sql="where zx='0' and time='"+date+"'";
//		cl=dao.countColumn("lrxg","hn891",sql);
//		cc=dao.countColumn("cx","hn891",sql);
//		cxl=check.DoubleTo4(check.division(cc, cl));
//		lrxg.setCd891(cxl);
//		lrxg.setDate(date);
//		dao.save(lrxg);
//		/*行内专职*/
//		lrxg=new SummaryDaily();
//		lrxg.setItemName("其中：行内专职");
//		lrxg.setItemCode("lv_cxzz");
//		sql="where zx='1' and xz in('0','2') and time='"+date+"'";
//		cl=dao.countColumn("lrxg","hn891",sql);
//		cc=dao.countColumn("cx","hn891",sql);
//		cxl=check.DoubleTo4(check.division(cc, cl));
//		lrxg.setWh891(cxl);
//		
//		sql="where zx='0' and xz in('0','2') and time='"+date+"'";
//		cl=dao.countColumn("lrxg","hn891",sql);
//		cc=dao.countColumn("cx","hn891",sql);
//		cxl=check.DoubleTo4(check.division(cc, cl));
//		lrxg.setCd891(cxl);
//		lrxg.setDate(date);
//		dao.save(lrxg);
//		
//		/*行内非专职*/
//		lrxg=new SummaryDaily();
//		lrxg.setItemName("其中：行内其他");
//		lrxg.setItemCode("lv_cxfz");
//		sql="where zx='1' and xz ='1' and time='"+date+"'";
//		cl=dao.countColumn("lrxg","hn891",sql);
//		cc=dao.countColumn("cx","hn891",sql);
//		cxl=check.DoubleTo4(check.division(cc, cl));
//		lrxg.setWh891(cxl);
//		
//		sql="where zx='0' and xz ='1' and time='"+date+"'";
//		cl=dao.countColumn("lrxg","hn891",sql);
//		cc=dao.countColumn("cx","hn891",sql);
//		cxl=check.DoubleTo4(check.division(cc, cl));
//		lrxg.setCd891(cxl);
//		lrxg.setDate(date);
//		dao.save(lrxg);
//		/*中级外包*/
//		lrxg=new SummaryDaily();
//		lrxg.setItemName("其中：外包人员");
//		lrxg.setItemCode("lv_cxwb");
//		sql="where zx='1' and xz='3' and time='"+date+"'";
//		cl=dao.countColumn("lrxg","hn891",sql);
//		cc=dao.countColumn("cx","hn891",sql);
//		cxl=check.DoubleTo4(check.division(cc, cl));
//		lrxg.setWh891(cxl);
//		
//		sql="where zx='0' and xz='3' and time='"+date+"'";
//		cl=dao.countColumn("lrxg","hn891",sql);
//		cc=dao.countColumn("cx","hn891",sql);
//		cxl=check.DoubleTo4(check.division(cc, cl));
//		lrxg.setCd891(cxl);
//		lrxg.setDate(date);
//		dao.save(lrxg);
//				
//		} catch (RuntimeException re) {
//			
//			re.printStackTrace();
//			logger.error(re.toString());
//			
//			throw re;
//		    }finally{
//	    	  trans.commit();
//	          session.flush();
//	          session.clear();
//	          session.close();
//	      }
//	    	  
//		return result;
//	}
	
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