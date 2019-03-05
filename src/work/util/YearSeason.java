package work.util;
import java.util.Calendar;
import java.util.List;

import work.daily.dao.DailyStatusDAO;
import work.daily.pojo.DailyStatus;

/*
 * 返回年份和季度
 */
public class YearSeason {
	Calendar a=Calendar.getInstance();
	int year = a.get(Calendar.YEAR); 
	int month = a.get(Calendar.MONTH)+1; 
	int date = a.get(Calendar.DATE); 
	int hour = a.get(Calendar.HOUR_OF_DAY); 
	int minute = a.get(Calendar.MINUTE); 
	int second = a.get(Calendar.SECOND); 
	public String getThisYear()
	{
		return String.valueOf(year);
	}
	public String getThisSeason()
	{
		if(3<=month&&5>=month)
		{
			return "2";
		}
		else if(6<=month&&8>=month)
		{
			return "3";
		}
		else if(9<=month&&11>=month)
		{
			return "4";
		}
		else
		{
			return "1";
		}
	}
	public String getLastYear()
	{
		return String.valueOf(year-1);
	}
	public String getLastSeason()
	{
		int m = month+1;
		if(3<=m&&5>=m)
		{
			return "1";
		}
		else if(6<=m&&8>=m)
		{
			return "2";
		}
		else if(9<=m&&11>=m)
		{
			return "3";
		}
		else
		{
			return "4";
		}
	}
	public String getLastSeasonYear()
	{
		String thisSeason = getThisSeason();
		if(thisSeason.equals("1"))
		{
			return  getLastYear();
		}
		else
		{
			return getThisYear();
		}
	}
	public String getDateTime()
	{
		return year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分"+second+"秒";
	}
	public String getSimpleDateTime()
	{
		return year+std(month)+std(date)+std(hour)+std(minute)+std(second);
	}
	public String std(int input)
	{
		if(input<10)
		{
			return "0"+input;
		}
		else
		{
			return String.valueOf(input);
		}
		
	}
	public String getDate()
	{
		return year+"年"+month+"月"+date+"日";
	}
	public int getIntegerDate()
	{
		return year*10000+month*100+date;
	}
	public String getStringDate()
	{
		return String.valueOf(getIntegerDate());
	}
	public String getStdStringDate()
	{
		String dt = getStringDate();
		return dt.substring(0, 4)+"-"+dt.substring(4, 6)+"-"+dt.substring(6, 8);
	}
	public String getThisMonth()
	{
		return String.valueOf(year*100+month);
	}
	public String getNextMonth(String thismonth)
	{
		int year = Integer.parseInt(thismonth.substring(0,4));
		int month = Integer.parseInt(thismonth.substring(4,6));
		if(month==12)
		{
			month=1;
			year+=1;
		}
		else
		{
			month+=1;
		}
		return String.valueOf(year*100+month);
	}
	public String getLastMonth(String thismonth)
	{
		int year = Integer.parseInt(thismonth.substring(0,4));
		int month = Integer.parseInt(thismonth.substring(4,6));
		if(month==1)
		{
			month=12;
			year-=1;
		}
		else
		{
			month-=1;
		}
		return String.valueOf(year*100+month);
	}
	public String getLastMonthDate(String date)
	{
		return getLastMonth(date.substring(0, 6))+date.substring(6, 8);
	}
	public String getLastFiveDate1(String date)
	{
		DailyStatusDAO dsdao = new DailyStatusDAO();
		DailyStatus ds = null;
		List<DailyStatus> list = dsdao.findAllOrderByDateDesc();
		if(list.size()>5)
		{
			ds = list.get(4);
		}
		else
		{
			ds = list.get(list.size()-1);
		}
		return ds.getTime();
	}
	
//	public String getLastWeek(String date)
//	{
//		int year = Integer.parseInt(thismonth.substring(0,4));
//		int month = Integer.parseInt(thismonth.substring(4,6));
//		if(month==1)
//		{
//			month=12;
//			year-=1;
//		}
//		else
//		{
//			month-=1;
//		}
//		return String.valueOf(year*100+month);
//	}
}
