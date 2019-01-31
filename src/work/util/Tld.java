package work.util;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class Tld {

	/**
	 * 路径
	 */
//	public static final String path = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/work/" ;
//	public static final String uploadpath = "D:/import/work/";
	public static final String uploadpath = "C:/import/work/";
	public static final String path ="C:/Program Files/apache-tomcat-7.0.59/webapps/work/";
	public static final String chars26 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * 下载路径
	 */
	public static final String downloadpath = path+"derive/";
	/**
	 * 规则库案例库路径
	 */
	public static final String rulecasepath = path+"rulecase/";
	
	/**
	 * 员工响应文件上传目录
	 */
	public static final String  ygxyuploadpath = "D:/import/work/ygxy/";
	
	/**
	 * 图片路径
	 */
	public static final String imagepath =getImagePage();
	//public static final String imagepath ="http://192.168.1.162:8080/work/rulecase/rule/image/";
	
	public static final String[] RMB_ZW={"人工版面识别","人工影像拆分","录入修改","录入修改授权","检核修改","检核修改授权","记账失败人工异常处理","单位账户影像标注录入角色","初审录入","专业复审"};
	public static final String[] RMB_FZW={"人工版面识别","人工影像拆分","录入修改","录入修改授权","检核修改","检核修改授权","记账失败人工异常处理","初审录入","专业复审","商户签约资料审核","商户签约发布失败处理","人力资源初审","人力资源复审","人力资源失败原因分析","小微快贷复核","房源总行核对"};//增加9个环节
	public static final String[] WAIHUI={"外汇业务初审","外汇业务复审","录入修改","录入修改授权","检核修改","检核修改授权","记账失败人工异常处理","外汇票据初审","外汇票据复审","外汇汇入初审","外汇汇入复审"};//增加3个环节
	public static final String[] JIANYA={"录入修改","录入修改授权","检核修改","检核修改授权","海外票据初审","海外票据复审","记账失败人工异常处理","初审录入","专业复审"};//增加2个环节
	public static final String[] FXQ={};
	public static final String[] PART={"人民币（账务）","人民币（非账务）","外汇","稽核","远程审核","建亚","反洗钱"};
	public static final String[] PARTC={"人民币","外汇","稽核","建亚","反洗钱"};
	public static final String[] PARTE={"clrmb","clwh","cljh","cljy","clfxq"};
//	public static final String[] chuteamzh={"综合与生产管理处","综合与财务团队","人力资源团队","生产管理团队"};
//	public static final String[] chuteamzh_s={"综合处","综合","人力","生产"};
//	public static final String[] chuteamhg={"合规与监督二处","集中稽核团队","反洗钱团队"};
//	public static final String[] chuteamhg_s={"合规二处","稽核","反洗钱"};
//	public static final String[] chuteamty={"通用业务二处","业务处理1组","业务处理2组","业务处理3组","业务处理4组","业务处理5组","业务处理6组"};
//	public static final String[] chuteamty_s={"通用二处","业务1","业务2","业务3","业务4","业务5","业务6"};
//	public static final String[] chuteamzy={"专业处理二处","专业处理1组","专业处理2组","专业处理3组","专业处理4组","专业处理5组","专业处理6组"};
//	public static final String[] chuteamzy_s={"专业二处","专业1","专业2","专业3","专业4","专业5","专业6"};
//	public static final String[] chuteamyf={"研发支持二处"};
//	public static final String[] chuteamyf_s={"研发"};
	
	//public static final String[] =;
	public static final String cfgxz = "__________________________________________________";
	//public static final String cfgxz =a___a_____________________________________________
		
	public static String getImagePage()
	{
		InetAddress ia=null;
		String imagepath="";
		try {
			imagepath = "http://"+ia.getLocalHost().getHostAddress()+"/work/";
			//System.out.println(imagepath);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imagepath;
	}
	public static String IntegerToString(Integer num)
	{
		if(num==null)
		{
			return "-";
		}
		else if(num==0)
		{
			return "-";
		}
		else
			return String.valueOf(num);
			
	}
	/*
	 *double保留小数点后四位 
	 *
	 */
	public static String DoubleTo4(Double num)
	{
		double temp;
		String result="-";
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			result = "-";
		}
		else
		{
		BigDecimal b = new BigDecimal(num+0.00000001);  
		temp = b.setScale(4, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		if(temp<0.000001&&temp>-0.000001)
		{
			result = "-";
		}
		else
		{
			result = String.valueOf(temp);
		}
		}
		return result;
		
	}
	
	public static String DoubleTo2new(Double num)
	{
		double temp;
		String result="-";
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			result = "-";
		}
		else
		{
		BigDecimal b = new BigDecimal(num+0.00000001);  
		temp = b.setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		
		
			result = String.valueOf(temp);
		}
		return result;
		
	}
	/**
	 *double保留小数点后两位 
	 *
	 */
	public static String DoubleTo2(Double num)
	{
		String result="-";
		double temp;
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			result = "-";
		}
		else
		{
			BigDecimal b = new BigDecimal(num+0.00000001);  
			temp = b.setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
			if(temp<0.000001&&temp>-0.000001)
			{
				result = "-";
			}
			else
			{
				result = String.valueOf(temp);
			}
		}
		
		return result;
	}
	/**
	 *double保留小数点后两位 
	 *
	 */
	public static double DoubleTo2double(Double num)
	{
		double temp=0.0;
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			
		}
		else
		{
			BigDecimal b = new BigDecimal(num+0.00000001);  
			temp = b.setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
			if(temp<0.000001&&temp>-0.000001)
			{
				temp=0.0;
			}
		}
		return temp;
	}
	/**
	 *double保留小数点后0位 
	 *
	 */
	public static double DoubleTo0double(Double num)
	{
		double temp=0.0;
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			
		}
		else
		{
			BigDecimal b = new BigDecimal(num+0.00000001);  
			temp = b.setScale(0, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
			if(temp<0.000001&&temp>-0.000001)
			{
				temp=0.0;
			}
		}
		return temp;
	}
	/*
	 *double取整数 
	 *
	 */
	public static String DoubleTo0(Double num)
	{
		String result="-";
		double temp;
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			result = "-";
		}
		else
		{
		BigDecimal b = new BigDecimal(num+0.00000001);  
		temp = b.setScale(0, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		if(temp<0.000001&&temp>-0.000001)
		{
			result = "-";
		}
		else
		{
			result = String.valueOf((int)temp);
		}
		}
		return result;
		
	}
	public static String DoubleTo0new(Double num)
	{
		double temp;
		String result="-";
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			result = "-";
		}
		else
		{
			BigDecimal b = new BigDecimal(num+0.00000001);  
			temp = b.setScale(0, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		
			result = String.valueOf((int)temp);
		}
		return result;
		
	}
	
	/*
	 *double取整数 
	 *
	 */
	public static String DoubleTo0Integer(Double num)
	{
		double temp;
		if(num==null)
		{
			return "-";
		}
		else
		{
			BigDecimal b = new BigDecimal(num+0.00000001);  
			temp = b.setScale(0, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
			Integer a =(new Double(temp)).intValue(); 
			if(a==0)
			{
				return "-";
			}
			else
			{
				return String.valueOf(a);
			}
			
		}
	}
	/*
	 *double转化为百分制
	 *
	 */
	public static String DoubleToPercent(Double num)
	{
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			return  "-";
		}
		else if(num<0.000001&&num>-0.000001)
		{
			return  "-";
		}
		else
		return String.valueOf(DoubleTo2(num*100))+"%";
	}
	/**
	 * 如果业务量为0，率设为“-”，如果业务量大于零，率不做修改
	 * @param a 业务量
	 * @param num 各种率
	 * @return
	 */
	public static String DoubleToPercentNew(Integer a,Double num)
	{
		if(a==null||a==0)
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "-";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "-";
			}
			else
			return String.valueOf(DoubleTo2(num*100))+"%";
		}
		else
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "0.00%";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "0.00%";
			}
			else
			return String.valueOf(DoubleTo2(num*100))+"%";
		}
	}
	/**
	 * 如果业务量为0，率设为“-”，如果业务量大于零，率不做修改
	 * @param a 业务量
	 * @param num 各种率
	 * @return
	 */
	public static String DoubleToPercentNew(Double a,Double num)
	{
		if(a==null||a==0)
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "-";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "-";
			}
			else
			return String.valueOf(DoubleTo2(num*100))+"%";
		}
		else
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "0.00%";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "0.00%";
			}
			else
			return String.valueOf(DoubleTo2(num*100))+"%";
		}
	}
	/**
	 * 如果第二个参数根据第一个参数是否是0显示为-
	 * @param a 业务量
	 * @param num 各种率
	 * @return
	 */
	public static String IntegerAccordToInteger(Integer a,Integer num)
	{
		if(a==null||a==0)
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "-";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "-";
			}
			else
			return String.valueOf(num);
		}
		else
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "0";
			}
			else if(num==0)
			{
				return  "0";
			}
			else
			return String.valueOf(num);
		}
	}	
	/**
	 * 如果业务量为0，率设为“-”，如果业务量大于零，率不做修改
	 * @param a 业务量
	 * @param num 各种率
	 * @return
	 */
	public static String DoubleDoubleToPercentNew(Double a,Double num)
	{
		if(a==null||a==0.0)
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "-";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "-";
			}
			else
			return String.valueOf(DoubleTo2(num*100))+"%";
		}
		else
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "0.00%";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "0.00%";
			}
			else
			return String.valueOf(DoubleTo2(num*100))+"%";
		}
	}
	/** ----->用于下载<-------
	 * 如果业务量为0，率设为“0”，如果业务量大于零，率不做修改
	 * @param a 业务量
	 * @param num 各种率
	 * @return
	 */
	public static String DoubleDownloadNew(Integer a,Double num)
	{
		if(a==null||a==0)
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "";
			}
			else
			return String.valueOf(DoubleTo4(num));
		}
		else
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "0.0";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "0.0";
			}
			else
			return String.valueOf(DoubleTo4(num));
		}
	}
	/**----->用于下载<-------
	 * 如果业务量为0，率设为"0"，如果业务量大于零，率不做修改
	 * @param a 业务量
	 * @param num 各种率
	 * @return
	 */
	public static String DoubleDownloadNew(Double a,Double num)
	{
		if(a==null||a==0.0)
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "";
			}
			else
			return String.valueOf(DoubleTo4(num));
		}
		else
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "0.0";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "0.0";
			}
			else
			return String.valueOf(DoubleTo4(num));
		}
	}
	/**----->用于下载<-------
	 * 如果业务量为0，率设为"0"，如果业务量大于零，不做修改
	 * @param a 业务量
	 * @param num 退票量、差错量、查询量
	 * @return
	 */
	public static String IntegerDownloadNew(Integer a,Integer num)
	{
		if(a==null||a==0)
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "";
			}
			else
			return String.valueOf(num);
		}
		else
		{
			if(num==null||num.equals("null")||num.SIZE<1)
			{
				return  "0";
			}
			else if(num<0.000001&&num>-0.000001)
			{
				return  "0";
			}
			else
			return String.valueOf(num);
		}
	}
	/*
	 *将空转化为“-”
	 *
	 */
	public static String ifNull(Integer input)
	{
		if (input == null || input.SIZE <= 0 || input.equals("null"))
		{
			return "-";
		}
		else
		{
			return String.valueOf(input);
		}
	}
	/*
	 *将空转化为“-”
	 *
	 */
	public static String ifNull(Double input)
	{
		if (input == null || input.SIZE <= 0 || input.equals("null"))
		{
			return "-";
		}
		else
		{
			return String.valueOf(input);
		}
	}
	/*
	 *将空转化为“-”
	 *
	 */
	public static String ifNull(String input)
	{
		if (input == null)
		{
			return "-";
		}
		else
		{
			return input;
		}
	}
	/**
	 * 中心转化为文字
	 * @param zx
	 * @return
	 */
	public static String zxToString(Integer zx)
	{
		if(zx==null)
		{
			return "-";
		}
		else if(zx==0)
		{
			return "成都";
		}
		else if(zx==1)
		{
			return "武汉";
		}
		else
		{
			return "-";
		}
	}
	/**
	 * 中心转化为数字
	 * @param zx
	 * @return
	 */
	public static Integer zxToInteger(String zx)
	{
		if(zx==null)
		{
			return -1;
		}
		else if(zx.startsWith("成都"))
		{
			return 0;
		}
		else if(zx.startsWith("武汉"))
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	/**
	 * 人员性质转化为文字
	 * @param zx
	 * @return
	 */
	public static String xzToString(Integer xz)
	{
		if(xz==null)
		{
			return "-";
		}
		else if(xz==0)
		{
			return "专职生产人员";
		}
		else if(xz==1)
		{
			return "其他生产人员";
		}
		else if(xz==2)
		{
			return "分行班组";
		}
		else if(xz==3)
		{
			return "外包人员";
		}
		else if(xz==4)
		{
			return "外汇作业";
		}
		else if(xz==6)
		{
			return "（中级）外包";
		}
		else if(xz==7)
		{
			return "普通外包";
		}
		else
		{
			return "-";
		}
	}
	/**
	 * 人员性质转化为文字
	 * @param zx
	 * @return
	 */
	public static String xzStringToString(String xz)
	{
		if(xz==null)
		{
			return "-";
		}
		else if(xz.equals("0"))
		{
			return "专职生产人员";
		}
		else if(xz.equals("1"))
		{
			return "其他生产人员";
		}
		else if(xz.equals("2"))
		{
			return "分行班组";
		}
		else if(xz.equals("3"))
		{
			return "外包人员";
		}
		else if(xz.equals("4"))
		{
			return "外汇作业";
		}
		else if(xz.equals("6"))
		{
			return "（中级）外包";
		}
		else if(xz.equals("7"))
		{
			return "普通外包";
		}
		else
		{
			return "-";
		}
	}
	/**
	 * 人员性质转化为文字
	 * @param zx
	 * @return
	 */
	public static String xzintToShortString(Integer xz)
	{
		System.out.println(xz);
		if(xz==null)
		{
			return "-";
		}
		else if(xz==0)
		{
			return "专职";
		}
		else if(xz==1)
		{
			return "其他";
		}
		else if(xz==2)
		{
			return "分行班组";
		}
		else if(xz==3)
		{
			return "外包";
		}
		else if(xz==4)
		{
			return "外汇";
		}
		else if(xz==6)
		{
			return "（中级）外包";
		}
		else if(xz==7)
		{
			return "普通外包";
		}
		else
		{
			return "-";
		}
	}
	/**
	 * 人员性质转化为文字
	 * @param zx
	 * @return
	 */
	public static String xzToShortString(String xz)
	{
		System.out.println(xz);
		if(xz==null)
		{
			return "-";
		}
		else if(xz.equals("0"))
		{
			return "专职";
		}
		else if(xz.equals("1"))
		{
			return "其他";
		}
		else if(xz.equals("2"))
		{
			return "分行班组";
		}
		else if(xz.equals("3"))
		{
			return "外包";
		}
		else if(xz.equals("4"))
		{
			return "外汇";
		}
		else if(xz.equals("6"))
		{
			return "（中级）外包";
		}
		else if(xz.equals("7"))
		{
			return "普通外包";
		}
		else
		{
			return "-";
		}
	}
	/**
	 * 人员性质转化为数字
	 * @param zx
	 * @return
	 */
	public static Integer xzToInteger(String xz)
	{
		if(xz==null)
		{
			return -1;
		}
		else if(xz.compareTo("0")>=0&&xz.compareTo("9")<0)
		{
			return Integer.valueOf(xz);
		}
		else if(xz.startsWith("专职"))
		{
			return 0;
		}
		else if(xz.startsWith("其他")||xz.startsWith("非专职"))
		{
			return 1;
		}
		else if(xz.startsWith("分行"))
		{
			return 2;
		}
		else if(xz.startsWith("外汇"))
		{
			return 4;
		}
		else if(xz.startsWith("中级"))
		{
			return 6;
		}
		else if(xz.startsWith("普通"))
		{
			return 7;
		}
		else if(xz.contains("外包"))
		{
			return 3;
		}
		else
		{
			return -1;
		}
	}
//	/**
//	 * 分组转化为文字
//	 * @param zx
//	 * @return
//	 */
//	public static String teamToString1(Integer team)
//	{
//		if(team==null)
//		{
//			return "-";
//		}
//		else if(team>0&&team<4)
//		{
//			return "业务处理"+team+"组";
//		}
//		else if(team>3&&team<7)
//		{
//			team = team-3;
//			return "专业处理"+team+"组";
//		}
//		else if(team==7)
//		{
//			return "稽核业务团队";
//		}
//		else
//		{
//			return "-";
//		}
//	}
	/**
	 * position分组转化为文字(短)
	 * @param zx
	 * @return
	 */
	public static String posToTeamShort(String pos)
	{
		String result = "";
		if(pos.isEmpty())
		{
			return "-";
		}
		else if(pos.length()<5)
		{
			return "-";
		}
		else
		{
			String chu = pos.substring(2, 3);
			String zu = pos.substring(4, 5);
			if(chu.equals("3"))
			{
				result="业务"+zu;
			}
			else if(chu.equals("6"))
			{
				result+="专业"+zu;
			}
			else if(chu.equals("2"))
			{
				result+="稽核";
			}
		}
		return result;
	}
	/**
	 * position分组转化为文字
	 * @param zx
	 * @return
	 */
	public static String positionToTeam(String pos)
	{
		String result = "";
		if(pos==null)
		{
			return "-";
		}
		else if(pos.length()<5)
		{
			return "-";
		}
		else
		{
			String chu = pos.substring(2, 3);
			String zu = pos.substring(4, 5);
			if(chu.equals("3"))
			{
				result="业务处理"+zu+"组";
			}
			else if(chu.equals("6"))
			{
				result+="专业处理"+zu+"组";
			}
			else if(chu.equals("2"))
			{
				result+="稽核业务团队";
			}
		}
		return result;
	}
	/**
	 * 分组转化为文字
	 * @param zx
	 * @return
	 */
//	public static String teamToShortString(Integer team)
//	{
//		if(team==null)
//		{
//			return "-";
//		}
//		else if(team>0&&team<4)
//		{
//			return "业务"+team;
//		}
//		else if(team>3&&team<7)
//		{
//			team = team-3;
//			return "专业"+team;
//		}
//		else if(team==7)
//		{
//			return "稽核";
//		}
//		else
//		{
//			return "-";
//		}
//	}
	/**
	 * 分组中提取数字
	 * @param zx
	 * @return
	 */
	public static Integer teamToTnteger(String team)
	{
		if(team.contains("稽核"))
		{
			System.out.println("`111");
		}
		int result = -1;
		String str2 = "";
		if (team == null) {
			return -1;
		} else {
			team = team.trim();
			if (!"".equals(team)) {
				for (int i = 0; i < team.length(); i++) {
					if (team.charAt(i) >= 48 && team.charAt(i) <= 57) {
						str2 += team.charAt(i);
					}
				}
				if(!"".equals(str2))
				{
					result = Integer.parseInt(str2);
				}
				if(team.contains("稽核")||team.equals("A"))
				{
					result=1;
				}
				return result;
			}
			return 0;
		}
			
	}
	/**
	 * 分组转化为文字
	 * @param zx
	 * @return
	 */
	public static String schedeamToString(Integer team)
	{
		if(team==null)
		{
			return "-";
		}
		else if(team>0&&team<9)
		{
			return "值班"+team+"组";
		}
		else
		{
			return "-";
		}
	}
	/**
	 * 处室转化为描述
	 * @param s
	 * @return
	 */
	public static String cToName(String p)
	{
		char c='0';
		if(p==null)
		{
			return "-";
		}
		else if(p.length()>4)
		{
			c=p.charAt(2);
		}
		else if(p.length()==1)
		{
			c=p.charAt(0);
		}
		if(c=='1')
		{
			return "综合与生产管理处";
		}
		else if(c=='2')
		{
			return "合规与监督二处";
		}
		else if(c=='3')
		{
			return "通用业务二处";
		}
		else if(c=='4')
		{
			return "员工响应团队";
		}
		else if(c=='5')
		{
			return "研发支持二处";
		}
		else if(c=='6')
		{
			return "专业处理二处";
		}
		else
		{
			return "其他";
		}
	}
	/**
	 * 处室转化为数字
	 * @param s
	 * @return
	 */
	public static Integer cToInteger(String c)
	{
		if(c==null)
		{
			return -1;
		}
		if(c.contains("综合"))
		{
			return 1;
		}
		else if(c.contains("合规"))
		{
			return 2;
		}
		else if(c.contains("通用"))
		{
			return 3;
		}
		else if(c.contains("响应"))
		{
			return 4;
		}
		else if(c.contains("研发"))
		{
			return 5;
		}
		else if(c.contains("专业"))
		{
			return 6;
		}
		else
		{
			return 0;
		}
	}
	
	public static String zuoyezhiliang(Integer input)
	{
		if(input==null)
		{
			return "-";
		}
		else if(input==1)
		{
			return "-"; 
		}
		else if(input==2)
		{
			return "★";
		}
		else if(input==3)
		{
			return "★★";
		}
		else
		{
			return "-";
		}
	}
	/*根据itemcodee确定input为百分比或整数*/
	public static String DoubleAccordTo(Double input,String itemcode)
	{
		String result="";
		//Double i=input;
		if((!itemcode.contains("rmb")&&!itemcode.contains("zz")&&!itemcode.contains("fz"))&&(input==0.0))
		{
			result="-";	
		}else if(itemcode.startsWith("lv"))
		{
			result= String.valueOf(DoubleTo2new(input*100));
			if(input>0)
				result=result+"%";
		}else if(input==null||input.equals("null")||input.SIZE<1)
		{
			result="";	
		}
		
		else
			result= String.valueOf(DoubleTo0new(input));
		return result;
	}
	/**YYYYMMDD--->MMDD*/
	public static String eightStringToFour(String str)
	{
		if(str.length()>5)
		{
			return str.substring(4,8);
		}
		else
		{
			return str;
		}
	}
	
	public static String NoFontSize(String no)
	{
		if(no.length()>3)
		{
			return "10";
		}
		else
		{
			return "14";
		}
	}
	/**
	 * 除法运算分子非零判断
	 * @param fenmu
	 * @param fenzi
	 * @return
	 */
	public static double division(double fenzi,double fenmu)
	{
		if((fenzi<0.0000001)&&(fenzi>-0.0000001))
		{
			return 0.0;
		}else if(fenmu<0.0000001&&fenmu>-0.0000001)
		{
			return 0.0;
		}
		else
		{
			return fenzi/fenmu;
		}
	}
	/**
	 * 根据position得到组别
	 * @param position
	 * @return
	 */
//	public static String positionToTeam(String position)
//	{
//		String result = "";
//		if(position!=null&&position.length()>=5)
//		{
//			if(position.charAt(4)!='0')//业务处理人员
//			{
//				result=position.charAt(4)+"组";
//			}
//		}
//		return result;
//	}
	
	/**
	 * 00:00:00 --> 0.0
	 * 
	 * @param time
	 * @return
	 */
	public static double timeStringToDouble(String time)
	{
		double result = 0.0;
		if(time==null||time.length()==0)
		{
			result = 0.0;
		}
		else
		{
			double shi = Double.parseDouble(time.substring(0, 2));
			double fen = Double.parseDouble(time.substring(3, 5));
			double miao= Double.parseDouble(time.substring(6, 8));
			result = shi*60+fen+miao/60;
		}
		return DoubleTo2double(result);
	}
	/**
	 * 00:00:00 --> 0.0
	 * 
	 * @param time
	 * @return
	 */
	public static double timeStringToDoubleHour(String time)
	{
		double result = 0.0;
		if(time==null||time.length()==0)
		{
			result = 0.0;
		}
		else
		{
			double shi = Double.parseDouble(time.substring(0, 2));
			double fen = Double.parseDouble(time.substring(3, 5));
			double miao= Double.parseDouble(time.substring(6, 8));
			result = shi+fen/60+miao/3600;
		}
		return DoubleTo2double(result);
	}
	public static String PlateToName(Integer plate)
	{
		String name="其他";
		if(plate!=null)
		{
			if(plate==1)
			{
				name="通用业务";
			}
			else if(plate==2)
			{
				name="外汇业务";
			}
		}
		return name;
	}
	public static String NameToPlate(String name)
	{
		String plate="0";
		if(name!=null)
		{
			if(name.contains("通用"))
			{
				plate="1";
			}
			else if(name.contains("外汇"))
			{
				plate="2";
			}
		}
		return plate;
	}
	public static String RuleZlToString(Integer type)
	{
		String t="其他";
		if(type!=null)
		{
			if(type==1)
			{
				t="辅助资料";
			}
			else if(type==2)
			{
				t="附件";
			}
		}
		return t;
	}
	
	public static String StringToShort(String input)
	{
		String result=input;
		if(input!=null)
		{
			if(input.length()>34)
			{
				result=input.substring(0, 34)+"...";
			}
		}
		return result;
	}
	
	public static String scTypeToString(Integer type)
	{
		return Tld.PART[type-1];
	}
	
	public static String YesOrNo(Integer input)
	{
		String result ="";
		if(input==null)
		{
			result = "否";
		}
		else
		{
			if(input==1)
			{
				result = "是";
			}
			else
			{
				result = "否";
			}
		}
		return result;
	}
	public static String OPXZtoString(Integer input)
	{
		String result ="";
		if(input==null)
		{
			result = "无";
		}
		else
		{
			if(input==1)
			{
				result = "小组";
			}
			else if(input==2)
			{
				result = "人员来源";
			}
			else if(input==3)
			{
				result = "人员属性";
			}
			else
			{
				result = "无";
			}
		}
		return result;
	}
	/**
	 * 新一代编号前面带0 的转成标准格式
	 * @param newnumber
	 * @return
	 */
	public static String NewnumberToStandard(String newnumber)
	{
		String result ="00000000"+newnumber;
		result = result.substring(result.length()-8,result.length());
		return result;
	}
}

////


