package work.charts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import work.charts.beans.ChartUtil;
import work.hn.dao.SummaryDAO;
import work.hn.dao.SummaryDailyDAO;
import work.hn.pojo.Summary;
import work.hn.pojo.SummaryDaily;
import work.util.GeneralCheck;
import work.util.Tld;
/**
 * 
 * @author htzx
 * 行内环节业务量趋势图
 *
 */
public class SummaryAction {
	private static Logger logger = Logger.getLogger(SummaryAction.class);
	private String btime;
	private String etime;
	private String part;
	private String key;
	private String xz;
	public String getBtime() {
		return btime;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String execute() throws Exception
	{
		String type="lv";
		double min=9999999;
		double max=0.0;
		String title = "test趋势图";
		GeneralCheck check = new GeneralCheck();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		SummaryDailyDAO sddao = new SummaryDailyDAO();
		String bt = btime.replace("-","");
		String et = etime.replace("-","");
		int interval = 0;
		
		List<SummaryDaily> dailylist = new ArrayList<SummaryDaily>();
		List<String> legendList = new ArrayList<String>();//数据分组  
		List<String> categoryList = new ArrayList<String>();//横坐标  
		List<String> slist = new ArrayList<String>();
		List<Double> clist = new ArrayList<Double>();
		List<Double> wlist = new ArrayList<Double>();
		List<Double> zlist = new ArrayList<Double>();//总行中心
		
		Map map = new HashMap();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*加载图示数据*/
		legendList.add("成都分中心");
		legendList.add("武汉主中心");
		legendList.add("业务处理中心");
		/*加载数据*/
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		if(xz.equals("0"))//只有人民币人数、日均产量、效率分专职和非专职
			{
    			if(key.equals("rs_rmb"))
    			{
    				key = "rs_zz";
    			}
    			else if(key.equals("rjcl_rmb"))
    			{
    				key = "rjcl_zz";
    			}
    			else if(key.equals("xl_rmb"))
    			{
    				key = "xl_rmb_hn";
    			}	
			}
    		dailylist = sddao.findByItemcodeDate(key, bt, et);
    		if(key.contains("lv"))
    		{
    			for(int i=0;i<dailylist.size();i++)
    			{
    				SummaryDaily sm = dailylist.get(i);
    				if(max<check.DoubleTo2(check.IsNullDouble(sm.getCdReal())*100)){max=check.DoubleTo2(check.IsNullDouble(sm.getCdReal())*100);}
    				if(max<check.DoubleTo2(check.IsNullDouble(sm.getWhReal())*100)){max=check.DoubleTo2(check.IsNullDouble(sm.getWhReal())*100);}
    				if(max<check.DoubleTo2(check.IsNullDouble(sm.getTotalReal())*100)){max=check.DoubleTo2(check.IsNullDouble(sm.getTotalReal())*100);}
    				
    				if(min>check.DoubleTo2(check.IsNullDouble(sm.getCdReal())*100)){min=check.DoubleTo2(check.IsNullDouble(sm.getCdReal())*100);}
    				if(min>check.DoubleTo2(check.IsNullDouble(sm.getWhReal())*100)){min=check.DoubleTo2(check.IsNullDouble(sm.getWhReal())*100);}
    				if(min>check.DoubleTo2(check.IsNullDouble(sm.getTotalReal())*100)){min=check.DoubleTo2(check.IsNullDouble(sm.getTotalReal())*100);}
    				
    				categoryList.add(Tld.eightStringToFour(sm.getDate()));
    				clist.add(check.DoubleTo2(check.IsNullDouble(sm.getCdReal())*100));
    				wlist.add(check.DoubleTo2(check.IsNullDouble(sm.getWhReal())*100));
    				zlist.add(check.DoubleTo2(check.IsNullDouble(sm.getTotalReal())*100));
    			}
    			max = max*1.1;
    			//min = 0;
    			type = "lv";
    		}
    		else
    		{
    			//获取横坐标和数据
    			for(int i=0;i<dailylist.size();i++)
    			{
    				SummaryDaily sm = dailylist.get(i);
    				categoryList.add(Tld.eightStringToFour(sm.getDate()));
    				clist.add(sm.getCdReal());
    				wlist.add(sm.getWhReal());
    				zlist.add(sm.getTotalReal());
    				if(max<sm.getTotalReal()){max=sm.getTotalReal();}
    				if(max<sm.getCdReal()){max=sm.getCdReal();}
    				if(max<sm.getWhReal()){max=sm.getWhReal();}
    				
    				if(min>sm.getTotalReal()){min=sm.getTotalReal();}
    				if(min>sm.getCdReal()){min=sm.getCdReal();}
    				if(min>sm.getWhReal()){min=sm.getWhReal();}
    			}
    			max = max*1.1;
    			//min = 0;
    			type = "num";
    		}
    		slist.add(SeriesOperation.toString("成都分中心","line", clist, true,true,"red",false,false));
			slist.add(SeriesOperation.toString("武汉主中心","line", wlist, true,true,"#0066B3",false,false));
			slist.add(SeriesOperation.toString("业务处理中心","line", zlist, true,true,"green",false,false));
			interval = dailylist.size()/40;
    	
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
		
		//slist.add(SeriesOperation.toString("成都中心","line", clist, true,true,"red",true));
		//slist.add(SeriesOperation.toString("武汉中心","line", wlist, true,false,null,false));
		map.put("legend", legendList);
		map.put("category", categoryList);
		map.put("series", slist);
		map.put("key", key);//关键字，根据关键字决定页面显示样式
		map.put("interval",interval);//x轴间隔，避免太密
		map.put("min",min);
		map.put("max",max);//
		map.put("title",title);
		map.put("type",type);
		JSONObject jsonObject = JSONObject.fromObject(map);
		try {
			response.setHeader("Cache-Control", "no-cache");
			response.setContentType("aplication/json;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.print(jsonObject);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonObject.toString());
		return null;
	}
}
