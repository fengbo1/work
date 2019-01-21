package work.no.action;

import java.util.List;

import org.hibernate.Query;

import work.control.dao.CfgXzDAO;
import work.hndetail.pojo.HnDetail;

public class NoUtil {

	
	
	public static String IntegerToSex(Integer input)
	{
		if(input==null)
		{
			return "";
		}
		else if(input<0||input>9)
		{
			return "";
		}
		else if(1==input%2)
		{
			return "男";
		}
		else
		{
			return "女";
		}
	}
	public static Integer SexToInteger(String input)
	{
		if(input==null)
		{
			return null;
		}
		else if("男".equals(input))
		{
			return 1;
		}
		else if("女".equals(input))
		{
			return 0;
		}
		else
			return -1;
	}
//	public static String IntegerToSource(Integer input)
//	{
//		if(input==null)
//		{
//			return "";
//		}
//		else if(0==input)
//		{
//			return "校招大学生";
//		}
//		else if(input>0)
//		{
//			return "行内招聘员工"+input;
//		}
//		else
//		{
//			return "";
//		}
//	}
//	public static Integer SourceToInteger(String input)
//	{
//		if(input==null)
//		{
//			return null;
//		}
//		else if(input.contains("校"))
//		{
//			return 0;
//		}
//		else if(input.contains("行"))
//		{
//			if(input.contains("1"))
//			{
//				return 1;
//			}
//			else if(input.contains("2"))
//			{
//				return 2;
//			}
//			else if(input.contains("3"))
//			{
//				return 3;
//			}
//			else if(input.contains("4"))
//			{
//				return 4;
//			}
//			else if(input.contains("5"))
//			{
//				return 5;
//			}
//			else if(input.contains("6"))
//			{
//				return 6;
//			}
//			else
//			{
//				return 9;
//			}
//			
//		}
//		else
//		{
//			return -1;
//		}
//	}
	public static String IntegerToCompany(Integer input)
	{
		if(input==null)
		{
			return "";
		}
		else if(0==input)
		{
			return "成都三泰（驻场）";
		}
		else if(1==input)
		{
			return "武汉三泰（驻场）";
		}
		else if(2==input)
		{
			return "成都中投（驻场）";
		}
		else if(3==input)
		{
			return "武汉中投（驻场）";
		}
		else if(4==input)
		{
			return "大庆华拓（离场）";
		}
		else if(5==input)
		{
			return "无锡京北方（离场）";
		}
		else if(6==input)
		{
			return "重庆先特（离场）";
		}
		else if(7==input)
		{
			return "浙江中盈瑞博（离场）";
		}
		else if(8==input)
		{
			return "成都银雁（驻场）";
		}
		else
		{
			return "";
		}
	}
	public static Integer CompanyToInteger(String input)
	{
		if(input==null)
		{
			return null;
		}
		else if(input.contains("成都三泰")&&input.contains("驻场"))
		{
			return 0;
		}
		else if(input.contains("武汉三泰")&&input.contains("驻场"))
		{
			return 1;
		}
		else if(input.contains("成都中投")&&input.contains("驻场"))
		{
			return 2;
		}
		else if(input.contains("武汉中投")&&input.contains("驻场"))
		{
			return 3;
		}
		else if(input.contains("大庆华拓")&&input.contains("离场"))
		{
			return 4;
		}
		else if(input.contains("无锡京北方")&&input.contains("离场"))
		{
			return 5;
		}
		else if(input.contains("重庆先特")&&input.contains("离场"))
		{
			return 6;
		}
		else if(input.contains("浙江中盈瑞博")&&input.contains("离场"))
		{
			return 7;
		}
		else if(input.contains("成都银雁")&&input.contains("驻场"))
		{
			return 8;
		}
		else
		{
			return -1;
		}
	}
	
	public static String xzToString(String xz,Integer i)
	{
		String result="无";
		int len = xz.length();
		if(len>i)
		{
			if(xz.charAt(i)=='0')
			{
				result="专职";
			}
			else if(xz.charAt(i)=='1')
			{
				result="非专职";
			}
			else if(xz.charAt(i)=='3')
			{
				result="外包";
			}
		}
		return result;
	}
	
	public static String shuxingToMiaosu(String shuxing1,String shuxing2)
	{
		CfgXzDAO cxdao = new CfgXzDAO();
		String result = "";
		if(shuxing1!=null)
		{
			for(int i=0;i<shuxing1.length();i++)
			{
				char sx1 = shuxing1.charAt(i);
				if(sx1!='0')
				{
					result+=cxdao.findAllByTnumAndCnum(i+1,sx1);
					result+="、";
				}
			}
			for(int i=0;i<shuxing2.length();i++)
			{
				char sx2 = shuxing2.charAt(i);
				if(sx2=='1')
				{
					result+=cxdao.findAllByZDYAndCnum(i+1);
					result+="、";
				}
			}
		}
		
		return result;
	}
}

///////////////////////





