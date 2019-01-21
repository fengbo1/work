package work.warning.action;

import java.util.ArrayList;
import java.util.List;

import work.control.dao.JhsxDAO;
import work.control.pojo.Control;
import work.control.pojo.Jhsx;
import work.daily.dao.DailyStatusDAO;
import work.daily.pojo.DailyStatus;
import work.hn.action.SummarySimple;
import work.hn.dao.SummaryDAO;
import work.hn.pojo.SummaryDaily;
import work.util.GeneralCheck;
import work.util.Tld;
import work.warning.dao.WarningDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class WarningAction  {
	
	private String bbzt_time;
	private String y_time;
	private String y_cl; 
	private String q_cl_cd;
	private String q_rs_cd;
	private String cd_lj_zb;
	private String wh_lj_zb;
	private String q_cl_wh;
	private String q_rs_wh;
    private String y_lv;
    private String q_lv;
    private double lv891_cd;
    private double lv891_wh;
    private String bbzt_online;// 报表状态 上线人员
    private String bbzt_xtdr;// 报表状态 系统导入
    private String bbzt_hnrb;// 行内日报生成
    private String bbzt_wbrb;// 外包日报生成
    private String bbzt_whbb;// 武汉数据导入
    private String bbzt_wc;//报表完成数一共五个
    private String bbzt_summary;//行内汇总报表
    private String date;//时间
    private List list;
    private double cdjhzb;
    private double whjhzb;
    private double cdljzb;//成都累计人员占比
    private double whljzb;//武汉累计人员占比
    private DailyStatus ds;
    private int num;
    
    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
    
	public String getCd_lj_zb() {
		return cd_lj_zb;
	}

	public void setCd_lj_zb(String cdLjZb) {
		cd_lj_zb = cdLjZb;
	}

	public String getWh_lj_zb() {
		return wh_lj_zb;
	}

	public void setWh_lj_zb(String whLjZb) {
		wh_lj_zb = whLjZb;
	}

	public String getY_cl() {
		return y_cl;
	}

	public void setY_cl(String yCl) {
		y_cl = yCl;
	}

	public String getQ_cl_cd() {
		return q_cl_cd;
	}

	public void setQ_cl_cd(String qClCd) {
		q_cl_cd = qClCd;
	}

	public String getY_lv() {
		return y_lv;
	}

	public void setY_lv(String yLv) {
		y_lv = yLv;
	}

	public String getQ_lv() {
		return q_lv;
	}

	public void setQ_lv(String qLv) {
		q_lv = qLv;
	}

	
	public void setQ_rs_cd(String q_rs_cd) {
		this.q_rs_cd = q_rs_cd;
	}

	public String getQ_rs_cd() {
		return q_rs_cd;
	}

	public String getBbzt_online() {
		return bbzt_online;
	}

	public void setBbzt_online(String bbztOnline) {
		bbzt_online = bbztOnline;
	}

	public String getBbzt_xtdr() {
		return bbzt_xtdr;
	}

	public void setBbzt_xtdr(String bbztXtdr) {
		bbzt_xtdr = bbztXtdr;
	}

	public String getBbzt_hnrb() {
		return bbzt_hnrb;
	}

	public void setBbzt_hnrb(String bbztHnrb) {
		bbzt_hnrb = bbztHnrb;
	}

	public String getBbzt_wbrb() {
		return bbzt_wbrb;
	}

	public void setBbzt_wbrb(String bbztWbrb) {
		bbzt_wbrb = bbztWbrb;
	}

	public String getBbzt_whbb() {
		return bbzt_whbb;
	}

	public void setBbzt_whbb(String bbztWhbb) {
		bbzt_whbb = bbztWhbb;
	}



	public String getBbzt_wc() {
		return bbzt_wc;
	}

	public void setBbzt_wc(String bbztWc) {
		bbzt_wc = bbztWc;
	}

	public String getBbzt_time() {
		return bbzt_time;
	}

	public void setBbzt_time(String bbztTime) {
		bbzt_time = bbztTime;
	}

	public String getY_time() {
		return y_time;
	}

	public void setY_time(String yTime) {
		y_time = yTime;
	}


	public double getLv891_cd() {
		return lv891_cd;
	}

	public void setLv891_cd(double lv891Cd) {
		lv891_cd = lv891Cd;
	}

	public double getLv891_wh() {
		return lv891_wh;
	}

	public void setLv891_wh(double lv891Wh) {
		lv891_wh = lv891Wh;
	}

	public String getQ_cl_wh() {
		return q_cl_wh;
	}

	public void setQ_cl_wh(String qClWh) {
		q_cl_wh = qClWh;
	}

	public String getQ_rs_wh() {
		return q_rs_wh;
	}

	public void setQ_rs_wh(String qRsWh) {
		q_rs_wh = qRsWh;
	}
	
	public String getBbzt_summary() {
		return bbzt_summary;
	}
	public void setBbzt_summary(String bbztSummary) {
		bbzt_summary = bbztSummary;
	}
	public double getCdjhzb() {
		return cdjhzb;
	}
	public void setCdjhzb(double cdjhzb) {
		this.cdjhzb = cdjhzb;
	}
	public double getWhjhzb() {
		return whjhzb;
	}
	public void setWhjhzb(double whjhzb) {
		this.whjhzb = whjhzb;
	}
	public double getCdljzb() {
		return cdljzb;
	}
	public void setCdljzb(double cdljzb) {
		this.cdljzb = cdljzb;
	}
	public double getWhljzb() {
		return whljzb;
	}
	public void setWhljzb(double whljzb) {
		this.whljzb = whljzb;
	}
	public DailyStatus getDs() {
		return ds;
	}
	public void setDs(DailyStatus ds) {
		this.ds = ds;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {	
		WarningDAO dao=new WarningDAO();
		GeneralCheck check = new GeneralCheck();
		JhsxDAO jhdao = new JhsxDAO();
		String 	maxqtime=dao.findbigtime();
//		Jhsx jhsx =jhdao.findJhByDate();
//		cdjhzb = check.DoubleTo2(100*check.division(jhsx.getCdjh(), (jhsx.getCdjh()+jhsx.getWhjh())));
//		whjhzb = check.DoubleTo2(100*check.division(jhsx.getWhjh(), (jhsx.getCdjh()+jhsx.getWhjh())));
		String  starttime = maxqtime.substring(0,6)+"01";
		y_time=maxqtime.substring(0, 4)+"年"+maxqtime.substring(4, 6)+"月"+maxqtime.substring(6, 8)+"日";

		List <SummaryDaily> list_cl=new ArrayList<SummaryDaily>();
		List <SummaryDaily> list_rs=new ArrayList<SummaryDaily>();
		List <SummaryDaily> list_lv=new ArrayList<SummaryDaily>();
		List <SummaryDaily> list_clzb=new ArrayList<SummaryDaily>();
		List <Control> list_yj=new ArrayList<Control>();
		double cdljcl=0;
		double whljcl=0;
		double totalljcl=0;
		list_cl=dao.findcl(maxqtime);		
		list_rs=dao.findrs(maxqtime);
		list_lv=dao.findlv(maxqtime);
		list_clzb=dao.findclByDate(starttime, maxqtime);
		list_yj=dao.findyj();
		
		for(int i=0;i<list_clzb.size();i++)
		{
			SummaryDaily sd = list_clzb.get(i);
			cdljcl+=sd.getCdReal();
			whljcl+=sd.getWhReal();
			totalljcl+=sd.getTotalReal();
		}
		cd_lj_zb = ""+ Tld.DoubleTo2(100*cdljcl/totalljcl);
		wh_lj_zb = ""+ Tld.DoubleTo2(100*whljcl/totalljcl);
//		Double cl_cd_891=list_cl.get(0).getCd891();
//		Double cl_cd_895=list_cl.get(0).getCd895();
//		Double cl_wh_891=list_cl.get(0).getWh891();
//		Double cl_wh_895=list_cl.get(0).getWh895();
		
		Double cl_cd=list_cl.get(0).getCdReal();		//成都产量
		Double cl_wh=list_cl.get(0).getWhReal();	//武汉产量
		Double cl=cl_cd+cl_wh; //总产量
		
		int rs_wh=list_rs.get(0).getWhReal().intValue(); //武汉实际上线人数
		int rs_cd=list_rs.get(0).getCdReal().intValue();//成都实际上线人数
		
		int whljrs = dao.findrs("wh_real", maxqtime.substring(0, 6)+"01",maxqtime);//武汉累计上线人数
		int cdljrs = dao.findrs("cd_real", maxqtime.substring(0, 6)+"01",maxqtime);//成都累计上线人数
		whljzb = check.DoubleTo2(check.division((double)whljrs,(whljrs+cdljrs))*100);
		cdljzb = check.DoubleTo2(check.division((double)cdljrs,(whljrs+cdljrs))*100);
		
		Double lv_cd=list_lv.get(0).getCdReal(); //成都差错率
		Double lv_wh=list_lv.get(0).getWhReal();	//武汉差错率	
		
		lv891_cd=check.DoubleTo2((lv_cd)*100);
		lv891_wh=check.DoubleTo2((lv_wh)*100);
		//System.out.println((lv_wh)*100);
		
		//Double lv=Math.round(((lv_cd*cl_cd_891)+(lv_wh*cl_wh_891))/(cl_cd_891+cl_wh_891)*10000)/10000.0; //891平均差错率
		Double lv=list_lv.get(0).getTotal891(); //891平均差错率

		
		Double yj_cl_high=list_yj.get(0).getClZbHigh(); //产量占比上限预警值
		Double yj_cl_low=list_yj.get(0).getClZbLow(); //产量占比下限预警值
		Double yj_zl=list_yj.get(0).getZlYj(); //质量预警值
		
		 y_cl="0"; //产量预警标志位，1为预警，0为正常
		if((cl_cd/cl)>yj_cl_high)
		{
			y_cl="1";			
		}
		else if((cl_cd/cl)<yj_cl_low)
		{
			y_cl="-1";			
		}
		 q_cl_cd=""+Math.round((((cl_cd/cl)*100))*100)/100.0;//成都产量占比
		 q_cl_wh=""+Math.round((((cl_wh/cl)*100))*100)/100.0;//武汉产量占比
		
		 y_lv="0";//质量预警标志位，1为预警，0为正常
		if(lv_cd>yj_zl)
		{
			y_lv="1";
		}
		 q_lv=""+lv;//成都质量
		 
		 Double kj=(double)rs_cd/(rs_wh+rs_cd)*100; //成都人员占比
		 Double kjj=(double)rs_wh/(rs_wh+rs_cd)*100;//武汉人员占比
		 
		 
		 q_rs_cd=""+Math.round((kj)*100)/100.0; //成都人数占比
		 q_rs_wh=""+Math.round((kjj)*100)/100.0;//武汉人数占比
	
		List <DailyStatus> dslist=new ArrayList<DailyStatus>();		
		String maxtime_bbzt=dao.findbigtime_bbzt();
		dslist=dao.findbbzt(maxtime_bbzt);
		ds=dslist.get(0);
		num = ds.getHnonline()+ds.getHnfxq()+ds.getHnx13()*3+ds.getHnwhbb()+ds.getHnjihe();
	
		bbzt_time=maxtime_bbzt.substring(0, 4)+"年"+maxtime_bbzt.substring(4, 6)+"月"+maxtime_bbzt.substring(6, 8)+"日";
		
		  bbzt_online="0";
		  bbzt_xtdr="0";
          bbzt_hnrb="0";
		  bbzt_wbrb="0";
		  bbzt_whbb="0";
		  int wc=0;
		  
		if(dslist.get(0).getHnonline()!=null&&dslist.get(0).getHnonline()>0){
			bbzt_online="1";
			wc=wc+1;
		}
		
		if(dslist.get(0).getHn891()!=null&&dslist.get(0).getHn895()!=null&&dslist.get(0).getWb891()!=null&&dslist.get(0).getHn891()>0&&dslist.get(0).getHn895()>0&&dslist.get(0).getWb891()>0){
			bbzt_xtdr="1";
			wc=wc+1;
		}
		if(dslist.get(0).getHnSummaryDaily()!=null){
			bbzt_hnrb="1";
			wc=wc+1;
		}
		if(dslist.get(0).getHnwhbb()!=null&&dslist.get(0).getHnwhbb()>0){
			 bbzt_whbb="1";
				wc=wc+1;
		}
		if(dslist.get(0).getWbjiagong()!=null&&dslist.get(0).getWbjiagong()>0){
			bbzt_wbrb="1";
			wc=wc+1;
		}
		
		bbzt_wc=String.valueOf(wc);
				
		String message="success";
		SummaryDAO dao1 = new SummaryDAO();
				
		DailyStatusDAO dailydao=new DailyStatusDAO();
		
		
		System.out.println(maxqtime);
		/*未选择日期默认最近一天日报表*/
		if(getDate()==null||date.isEmpty()||date.length()<1)
		{
			list = dao1.findByDate(maxqtime.replace("-", ""));
			date=maxqtime;
		}
		else
		{
			 //date=dailydao.findSummary();
			 list = dao1.findByDate(date.replace("-", ""));
		}
		ActionContext.getContext().put("message", message);
		
		return "s";
	}

	



}