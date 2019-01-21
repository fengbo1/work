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

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ccb.hibernate.HibernateSessionFactory;

import work.charts.beans.Series;
import work.hn.dao.SummaryDailyDAO;
import work.util.GeneralCheck;
import work.util.Tld;
/**
 * 
 * @author htzx
 * 行内环节业务量趋势图
 *
 */
public class DetailAction {
	private String btime;
	private String etime;
	private String part;
	private String key;
	private String name;
	private String name1;
	private static final Logger logger = LoggerFactory.getLogger(DetailAction.class);
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

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String execute() throws Exception
	{
		String sql="";
		String type="lv";
		double min=0.0;
		double max=0.0;
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		name1 = new String(name1.getBytes("ISO-8859-1"), "utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		List<String> legendList = new ArrayList<String>();//数据分组  
		List<String> categoryList = new ArrayList<String>();//横坐标时间轴  
		List<String> slist = new ArrayList<String>();//传到前台的数组
		List<Double> mlist = new ArrayList<Double>();//主曲线
		List<Double> clist = new ArrayList<Double>();//成都平均
		List<Double> wlist = new ArrayList<Double>();//武汉平均
		List<Double> dlist = new ArrayList<Double>();//对比曲线
		int interval = 0;
		String bt = btime.replace("-","");
		String et = etime.replace("-","");
		Map map = new HashMap();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*比对数据组名称*/
		legendList.add("成都均值");
		legendList.add("武汉均值");
		legendList.add(name);
		if(!name1.equals("null")){legendList.add(name1);};
    	
    	Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try 
		{
			/*时间轴坐标*/
			sql="select distinct time from t_daily_status where time>='"+bt+"' and time<='"+et+"' order by time";
			Query queryObject = session.createSQLQuery(sql);
			List<String> dateList=queryObject.list();
			
			//各种率
			if(key.contains("ccl")||key.contains("cxl")||key.contains("tpl")||key.contains("bhl")||key.contains("lrzl")||key.contains("lrcc/lrxg")||key.contains("jhcc/jhxg"))
			{
				type="lv";
				/*数据组*/
				for(int i=0;i<dateList.size();i++)
				{
					String date = dateList.get(i);
					categoryList.add(Tld.eightStringToFour(date));
					String keyc = "";
					String keyw = "";
					double m = 0.0;
					double c = 0.0;
					double w = 0.0;
					double d = 0.0;
					if(part.equals("zw"))
					{
						keyc = "cd_891";
						keyw = "wh_891";
					}
					else if(part.equals("fz"))
					{
						keyc = "cd_895";
						keyw = "wh_895";
					}
					else
					{
						keyc = "cd_real";
						keyw = "wh_real";
					}
					//本人指标
					sql = "select "+key+" from "+partToTable(part)+" where "+partToDate(part)+"='"+date+"' and name='"+name+"' and zx=0";
					Object obj = session.createSQLQuery(sql).uniqueResult();
					if(obj!=null)
					{m=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);}
					//对比指标
					sql = "select "+key+" from "+partToTable(part)+" where "+partToDate(part)+"='"+date+"' and name='"+name1+"' and zx=0";
					Object objd = session.createSQLQuery(sql).uniqueResult();
					if(objd!=null)
					{d=Tld.DoubleTo2double(Double.parseDouble(objd.toString())*100);}
					//成都指标
					sql = "select "+keyc+" from t_daily_summary where date='"+date+"' and item_code='"+partKeyToSummary(part,key)+"'";
					Object objc = session.createSQLQuery(sql).uniqueResult();
					if(objc!=null)
					{c=Tld.DoubleTo2double(Double.parseDouble(objc.toString())*100);}
					//武汉指标
					sql = "select "+keyw+" from t_daily_summary where date='"+date+"' and item_code='"+partKeyToSummary(part,key)+"'";
					Object objw = session.createSQLQuery(sql).uniqueResult();
					if(objw!=null)
					{w=Tld.DoubleTo2double(Double.parseDouble(objw.toString())*100);}
					
					
					clist.add(c);
					wlist.add(w);
					mlist.add(m);
					dlist.add(d);
					
					max=max>m?max:m;
					max=max>c?max:c;
					max=max>w?max:w;
					max=max>d?max:d;
					
					min=min<m?min:m;
					min=min<c?min:c;
					min=min<w?min:w;
					min=min<d?min:d;
				}
				max=max*1.1;
			}
			else
			{
				type="num";
				/*数据组*/
				for(int i=0;i<dateList.size();i++)
				{
					String date = dateList.get(i);
					categoryList.add(Tld.eightStringToFour(date));
					String keyc = "";
					String keyw = "";
					double m = 0.0;
					double c = 0.0;
					double w = 0.0;
					double d = 0.0;
					if(part.equals("zw"))
					{
						keyc = "cd_891";
						keyw = "wh_891";
					}
					else if(part.equals("fz"))
					{
						keyc = "cd_895";
						keyw = "wh_895";
					}
					else
					{
						keyc = "cd_real";
						keyw = "wh_real";
					}
					//本人指标
					sql = "select "+key+" from "+partToTable(part)+" where "+partToDate(part)+"='"+date+"' and name='"+name+"' and zx=0";
					Object obj = session.createSQLQuery(sql).uniqueResult();
					if(obj!=null)
					{m=Double.parseDouble(obj.toString());}
					//对比指标
					sql = "select "+key+" from "+partToTable(part)+" where "+partToDate(part)+"='"+date+"' and name='"+name1+"' and zx=0";
					Object objd = session.createSQLQuery(sql).uniqueResult();
					if(objd!=null)
					{d=Double.parseDouble(objd.toString());}
					//成都指标
					sql = "select "+keyc+" from t_daily_summary where date='"+date+"' and item_code='"+partKeyToSummary(part,key)+"'";
					Object objc = session.createSQLQuery(sql).uniqueResult();
					if(objc!=null)
					{c=Double.parseDouble(objc.toString());}
					//武汉指标
					sql = "select "+keyw+" from t_daily_summary where date='"+date+"' and item_code='"+partKeyToSummary(part,key)+"'";
					Object objw = session.createSQLQuery(sql).uniqueResult();
					if(objw!=null)
					{w=Double.parseDouble(objw.toString());}
					
					mlist.add(Tld.DoubleTo0double(m));
					clist.add(c);
					wlist.add(w);
					dlist.add(Tld.DoubleTo0double(d));
					
					max=max>m?max:m;
					max=max>c?max:c;
					max=max>w?max:w;
					max=max>d?max:d;
					
					min=min<m?min:m;
					min=min<c?min:c;
					min=min<w?min:w;
					min=min<d?min:d;
				}
				max=max*1.1;
			}
			System.out.println("max:"+max);
			interval = categoryList.size()/40;
			
			slist.add(SeriesOperation.toString("成都均值","line", clist, true,true,"red",false,false));
			slist.add(SeriesOperation.toString("武汉均值","line", wlist, true,true,"#0066B3",false,false));
			slist.add(SeriesOperation.toString(name,"line", mlist, true,true,"green",false,false));
			if(!name1.equals("null"))
			{
				slist.add(SeriesOperation.toString(name1,"line", dlist, true,true,"blue",false,false));
			}
			
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
		
		
		map.put("interval",interval);//x轴间隔，避免太密
		map.put("legend", legendList);
		map.put("category", categoryList);
		map.put("series", slist);
		map.put("max",max);
		map.put("min",min);//
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
	
	public String partToDate (String part)
	{
		String date = "";
		if(part.equals("zw")||part.equals("fz"))
		{
			date = "time";
		}
		else
		{
			date = "date";
		}
		return date;
	}

	public String partToTable (String part)
	{
		String table = "";
		if(part.equals("all"))
		{
			table = "t_hn_new";//no
		}
		else if(part.equals("zw")||part.equals("fz"))
		{
			table = "t_hn_detail";//no
		}
		else if(part.equals("wh"))
		{
			table = "t_hn_waihui";//no
		}
		else if(part.equals("jy"))
		{
			table = "t_hn_jianya";//no
		}
		else if(part.equals("jh"))
		{
			table = "t_hn_jihe";//newnumber
		}
		else if(part.equals("fxq"))
		{
			table = "t_hn_fxq";//newnumber
		}
		return table;
	}
	public String partToNo (String part)
	{
		String table = "";
		if(part.equals("jh")||part.equals("fxq"))
		{
			table = "newnumber";//no
		}
		else
		{
			table = "no";//no
		}
		return table;
	}
	
	public String partKeyToSummary(String part,String key)
	{
		String sumkey = "";
		if(part.equals("all"))
		{
			if(key.equals("cl"))
			{
				sumkey = "rjcl";
			}
			else if(key.equals("xl"))
			{
				sumkey = "xl";
			}
			else if(key.equals("ccl"))
			{
				sumkey = "lv_zyccl";
			}
		}
		else if(part.equals("zw")||part.equals("fz"))
		{
			if(key.contains("output"))
			{
				sumkey = "rjcl_rmb";
			}
			else if(key.contains("ccl"))
			{
				sumkey = "lv_rmb";
			}
			else if(key.contains("cxl"))
			{
				sumkey = "lv_cx";
			}
			else if(key.contains("tpl"))
			{
				sumkey = "lv_tp";
			}
			else if(key.contains("qdlr"))
			{
				sumkey = "lv_zwd";
			}
			else if(key.contains("lrcc/lrxg"))
			{
				sumkey = "lv_lrxg";
			}
			else if(key.contains("jhcc/jhxg"))
			{
				sumkey = "lv_jhxg";
			}
		}
		else if(part.equals("wh"))
		{
			if(key.equals("zhcl"))
			{
				sumkey = "rjcl_wh";
			}
			else if(key.equals("ccl"))
			{
				sumkey = "lv_wh_ccl";
			}
			else if(key.equals("cxlv"))
			{
				sumkey = "lv_wh_cx";
			}
			else if(key.equals("tplv"))
			{
				sumkey = "lv_wh_tp";
			}
			else if(key.equals("percl"))
			{
				sumkey = "xl_wh";
			}
			else if(key.equals("bhl"))
			{
				sumkey = "lv_wh_bh";
			}
		}
		else if(part.equals("jy"))
		{
			if(key.equals("zhcl"))
			{
				sumkey = "rjcl_jy";
			}
			else if(key.equals("ccl"))
			{
				sumkey = "lv_jy_ccl";
			}
			else if(key.equals("cxlv"))
			{
				sumkey = "lv_jy_cx";
			}
			else if(key.equals("tplv"))
			{
				sumkey = "lv_jy_tp";
			}
			else if(key.equals("percl"))
			{
				sumkey = "xl_jy";
			}
		}
		else if(part.equals("jh"))
		{
			if(key.equals("cl"))
			{
				sumkey = "rjcl_jh";
			}
		}
		else if(part.equals("fxq"))
		{
			if(key.equals("cl"))
			{
				sumkey = "rjcl_fxq";
			}
		}
		return sumkey;
	}
}
