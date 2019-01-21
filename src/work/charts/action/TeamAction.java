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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

import work.charts.beans.ChartUtil;
import work.control.dao.CfgXzDAO;
import work.control.dao.UserCfgDAO;
import work.control.pojo.NameValueBean;
import work.hn.dao.SummaryDailyDAO;
import work.team.dao.TeamDAO;
import work.team.pojo.Team;
import work.util.GeneralCheck;
import work.util.Tld;

public class TeamAction {

	private String btime;
	private String etime;
	private String chu;
	private String team;
	private String part;
	private String key;
	private int qz1;
	private int qz2;
	private static Logger logger = Logger.getLogger(TeamAction.class);
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
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public int getQz1() {
		return qz1;
	}
	public void setQz1(int qz1) {
		this.qz1 = qz1;
	}
	public int getQz2() {
		return qz2;
	}
	public void setQz2(int qz2) {
		this.qz2 = qz2;
	}
	public String execute() throws Exception
	{
		String sql="";
		String type="lv";
		double min=999999;
		double max=0.0;
		int qznum = 0;//选中自定义群组条数
		String qz1names = "";
		String qz2names = "";
		int L1 = 0;
		int R1 = 0;
		int L2 = 0;
		int R2 = 0;
		
		int num = 0;//曲线条数
		CfgXzDAO cxdao = new CfgXzDAO();
		UserCfgDAO ucdao = new UserCfgDAO();
		GeneralCheck check = new GeneralCheck();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		TeamDAO teamdao = new TeamDAO();
		String bt = btime.replace("-","");
		String et = etime.replace("-","");
		int interval = 0;
//		List<Team> teamlist = new ArrayList<Team>();
		List<String> legendList = new ArrayList<String>();//数据分组  
		List<String> categoryList = new ArrayList<String>();//横坐标  
		List<String> slist = new ArrayList<String>();
		List<NameValueBean> listnv = new ArrayList<NameValueBean>();
		List<Double> list0 = new ArrayList<Double>();//第1条
		List<Double> list1 = new ArrayList<Double>();//第1条
		List<Double> list2 = new ArrayList<Double>();//第2条
		List<Double> list3 = new ArrayList<Double>();//
		List<Double> list4 = new ArrayList<Double>();//
		List<Double> list5 = new ArrayList<Double>();//
		List<Double> list6 = new ArrayList<Double>();//
		List<Double> list7 = new ArrayList<Double>();//
		List<Double> list8 = new ArrayList<Double>();//
		List<Double> list9 = new ArrayList<Double>();//第9条
		
		
		
		Map map = new HashMap();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*加载数据*/
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		
    		if(qz1>0)
    		{
    			qznum+=1;
    			qz1names = teamdao.findNamesByZDY("zdy", qz1, "1", session);
//				L1 = qz1-1;
//				R1 = qz1+1;
//				sql = "select name from t_no where source=concat(mid(source,1,"+L1+"),'"+1+"',mid(source,"+R1+",49)) and position!='99999'";
//				List<String> lists = session.createSQLQuery(sql).list();
//				for(int i=0;i<lists.size();i++)
//				{
//					qz1names +="'";
//					String s = lists.get(i);
//					qz1names +=s;
//					qz1names +="'";
//					qz1names +=",";
//				}
//				if(qz1names.length()>1)
//				{
//					qz1names = qz1names.substring(0, qz1names.length()-1);
//				}
    		}
    		if(qz2>0)
    		{
    			qznum+=1;
    			qz2names = teamdao.findNamesByZDY("zdy", qz2, "1", session);
    		}
    		
    		
    		if(qznum==0)//选的是处室团队
    		{
    			if(chu==null||chu.equals(""))
    			{
    				chu="3";
    			}
    			if(team==null||team.equals(""))
    			{
    				team="0";
    			}
    			if(team.equals("0"))//如果选全部小组
        		{
        			listnv = ucdao.findScIndexByTypeAndNum("chu",chu);
        		}
        		else
        		{
        			listnv.add(ucdao.findScIndexByTypeAndNum("chu",chu).get(Integer.valueOf(team)));
        		}
        		num = listnv.size();
        		for(int i=0;i<num;i++)
        		{
        			/*加载图示数据*/
        			legendList.add(listnv.get(i).getValue());
        		}
    		}
    		else//选的是自定义群组
    		{
    			num = qznum;
    			if(qz1>0)
    			{
    				/*加载图示数据*/
        			legendList.add(cxdao.findAllByZDYAndCnum(qz1));
    			}
    			if(qz2>0)
    			{
    				/*加载图示数据*/
    				legendList.add(cxdao.findAllByZDYAndCnum(qz2));
    			}
    		}
    		
    		/*时间轴坐标*/
			sql="select distinct time from t_daily_status where time>='"+bt+"' and time<='"+et+"' order by time";
			Query queryObject = session.createSQLQuery(sql);
			List<String> dateList=queryObject.list();
			
			if(key.contains("ccl"))//差错率
			{
				type="lv";
				for(int i=0;i<dateList.size();i++)
				{
					double data = 0.0;
					String date = dateList.get(i);
					categoryList.add(Tld.eightStringToFour(date));
					if(num>0)//
					{
						if(qz1>0)//如果是自定义群组，用另一个sql（写一个转换key的方法）
						{
							sql = "SELECT "+partKeyToZDY(part,key)+" from t_hn_new where "+keyToDate(part,key,date)+" and name in ("+qz1names+")";
						}
						else if(qz2>0)
						{
							sql = "SELECT "+partKeyToZDY(part,key)+" from t_hn_new where "+keyToDate(part,key,date)+" and name in ("+qz2names+")";
						}
						else
						{
							NameValueBean nvb = listnv.get(0);
							sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						}
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list0.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>1)//
					{
						
						if(qz1>0&&qz2>0)
						{
							sql = "SELECT "+partKeyToZDY(part,key)+" from t_hn_new where "+keyToDate(part,key,date)+" and name in ("+qz2names+")";
						}
						else
						{
							NameValueBean nvb = listnv.get(1);
							sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						}
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list1.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>2)//
					{
						NameValueBean nvb = listnv.get(2);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list2.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>3)//第一条曲线
					{
						NameValueBean nvb = listnv.get(3);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list3.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>4)//第一条曲线
					{
						NameValueBean nvb = listnv.get(4);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list4.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>5)//第一条曲线
					{
						NameValueBean nvb = listnv.get(5);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list5.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>6)//第一条曲线
					{
						NameValueBean nvb = listnv.get(6);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list6.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>7)//第一条曲线
					{
						NameValueBean nvb = listnv.get(7);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list7.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>8)//第一条曲线
					{
						NameValueBean nvb = listnv.get(8);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo2double(Double.parseDouble(obj.toString())*100);
						}
						list8.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
				}
				max=max*1.1;
			}
			else
			{
				type="num";
				for(int i=0;i<dateList.size();i++)
				{
					double data = 0.0;
					String date = dateList.get(i);
					categoryList.add(Tld.eightStringToFour(date));
					if(num>0)//
					{
						
						if(qz1>0)//如果是自定义群组，用另一个sql（写一个转换key的方法）
						{
							sql = "SELECT "+partKeyToZDY(part,key)+" from t_hn_new where "+keyToDate(part,key,date)+" and name in ("+qz1names+")";
						}
						else if(qz2>0)
						{
							sql = "SELECT "+partKeyToZDY(part,key)+" from t_hn_new where "+keyToDate(part,key,date)+" and name in ("+qz2names+")";
						}
						else
						{
							NameValueBean nvb = listnv.get(0);
							sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						}
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list0.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>1)//
					{
						
						if(qz1>0&&qz2>0)
						{
							sql = "SELECT "+partKeyToZDY(part,key)+" from t_hn_new where "+keyToDate(part,key,date)+" and name in ("+qz2names+")";
						}
						else
						{
							NameValueBean nvb = listnv.get(1);
							sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						}
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list1.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>2)//
					{
						NameValueBean nvb = listnv.get(2);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list2.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>3)//第一条曲线
					{
						NameValueBean nvb = listnv.get(3);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list3.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>4)//第一条曲线
					{
						NameValueBean nvb = listnv.get(4);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list4.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>5)//第一条曲线
					{
						NameValueBean nvb = listnv.get(5);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list5.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>6)//第一条曲线
					{
						NameValueBean nvb = listnv.get(6);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list6.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>7)//第一条曲线
					{
						NameValueBean nvb = listnv.get(7);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list7.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
					if(num>8)//第一条曲线
					{
						NameValueBean nvb = listnv.get(8);
						sql = "SELECT "+key+" from t_hn_team where time='"+date+"' and chu='"+chu+"' and team='"+nvb.getName()+"'";
						Object obj = session.createSQLQuery(sql).uniqueResult();
						if(obj!=null)
						{
							data=Tld.DoubleTo0double(Double.parseDouble(obj.toString()));
						}
						list8.add(data);
						max=max>data?max:data;
						min=min<data?min:data;
					}
				}
				max=max*1.1;
			}
			System.out.println("max:"+max);
			interval = categoryList.size()/40;
			if(num>0)
			{
				//NameValueBean nvb = listnv.get(0);
				slist.add(SeriesOperation.toString(legendList.get(0),"line", list0, true,true,"red",false,false));
			}
			if(num>1)
			{
				//NameValueBean nvb = listnv.get(1);
				slist.add(SeriesOperation.toString(legendList.get(1),"line", list1, true,true,"#0066B3",false,false));
			}
			if(num>2)
			{
				//NameValueBean nvb = listnv.get(2);
				slist.add(SeriesOperation.toString(legendList.get(2),"line", list2, true,true,"green",false,false));
			}
			if(num>3)
			{
				//NameValueBean nvb = listnv.get(3);
				slist.add(SeriesOperation.toString(legendList.get(3),"line", list3, true,true,"blue",false,false));
			}
			if(num>4)
			{
				//NameValueBean nvb = listnv.get(4);
				slist.add(SeriesOperation.toString(legendList.get(4),"line", list4, true,true,"#CD853F",false,false));
			}
			if(num>5)
			{
				//NameValueBean nvb = listnv.get(5);
				slist.add(SeriesOperation.toString(legendList.get(5),"line", list5, true,true,null,false,false));
			}
			if(num>6)
			{
				//NameValueBean nvb = listnv.get(6);
				slist.add(SeriesOperation.toString(legendList.get(6),"line", list6, true,true,"#00CDCD",false,false));
			}
			if(num>7)
			{
				//NameValueBean nvb = listnv.get(7);
				slist.add(SeriesOperation.toString(legendList.get(7),"line", list7, true,true,null,false,false));
			}
			if(num>8)
			{
				//NameValueBean nvb = listnv.get(8);
				slist.add(SeriesOperation.toString(legendList.get(8),"line", list8, true,true,null,false,false));
			}
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		trans.rollback();
    		e.printStackTrace();
    		logger.error("");
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
		map.put("max",max);//
		map.put("min",min);//
		map.put("type",type);
		//map.put("key", key);//关键字，根据关键字决定页面显示样式
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
    	return "success";
	}
	
//	public String partToTable(String part)
//	{
//		if(part.equals("all"))
//		{
//			return "t_hn_new";
//		}
//		else if(part.equals("rmb"))
//		{
//			return "t_hn_detail";
//		}
//		else if(part.equals("wh"))
//		{
//			return "t_hn_waihui";
//		}
//		else if(part.equals("jy"))
//		{
//			return "t_hn_jianya";
//		}
//		else if(part.equals("jh"))
//		{
//			return "t_hn_jihe";
//		}
//		else if(part.equals("fxq"))
//		{
//			return "t_hn_fxq";
//		}
//		else
//		{
//			return "";
//		}
//	}
	public String keyToDate(String part,String key,String date)
	{
		String result = "";
		String temp = "";
		if(part.equals("t_hn_detail"))
		{
			temp = "time";
		}
		else{
			temp = "date";
		}
		if(date!=null&&date.length()>7)
		{
			if(key.contains("rj"))
			{
				result = temp+">='"+date.substring(0, 6)+"01' and "+temp+"<='"+date+"'";
			}
			else
			{
				result = temp+"='"+date+"'";
			}
		}
		return result;
	}
	public String partKeyToZDY(String part,String key)
	{
		String result = "";
		if(part.equals("all"))
		{
			if(key.equals("rjcl"))
			{
				result = "sum(cl)/sum(sx)";
			}
			else if(key.equals("cl"))
			{
				result = "sum(cl)/sum(sx)";
			}
			else if(key.equals("ccl"))
			{
				result = "sum(cclrmb_fz+cclwh_fz+ccljy_fz)/sum(cclrmb_fm+cclwh_fm+ccljy_fm)";
			}
			else if(key.equals("xl"))
			{
				result = "sum(xlrmb_fz+xlwh_fz+xljy_fz)/sum(xlrmb_fm+xlwh_fm+xljy_fm)";
			}
		}
		else if(part.equals("rmb"))
		{
			if(key.equals("rjclrmb"))
			{
				result = "sum(clrmb)/sum(sxrmb)";
			}
			else if(key.equals("clrmb"))
			{
				result = "sum(clrmb)/sum(sxrmb)";
			}
			else if(key.equals("cclrmb"))
			{
				result = "sum(cclrmb_fz)/sum(cclrmb_fm)";
			}
			else if(key.equals("xlrmb"))
			{
				result = "sum(xlrmb_fz)/sum(xlrmb_fm)";
			}
		}
		else if(part.equals("wh"))
		{
			if(key.equals("rjclwh"))
			{
				result = "sum(clwh)/sum(sxwh)";
			}
			else if(key.equals("clwh"))
			{
				result = "sum(clwh)/sum(sxwh)";
			}
			else if(key.equals("cclwh"))
			{
				result = "sum(cclwh_fz)/sum(cclwh_fm)";
			}
			else if(key.equals("xlwh"))
			{
				result = "sum(xlwh_fz)/sum(xlwh_fm)";
			}
		}
		else if(part.equals("jy"))
		{
			if(key.equals("rjcljy"))
			{
				result = "sum(cljy)/sum(sxjy)";
			}
			else if(key.equals("cljy"))
			{
				result = "sum(cljy)/sum(sxjy)";
			}
			else if(key.equals("ccljy"))
			{
				result = "sum(ccljy_fz)/sum(ccljy_fm)";
			}
			else if(key.equals("xljy"))
			{
				result = "sum(xljy_fz)/sum(xljy_fm)";
			}
		}
		else if(part.equals("jh"))
		{
			result = "sum(cljh)/sum(sxjh)";
		}
		else if(part.equals("fxq"))
		{
			result = "sum(clfxq)/sum(sxfxq)";
		}
		return result;
	}
}
