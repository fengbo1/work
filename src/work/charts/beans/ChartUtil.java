package work.charts.beans;

public class ChartUtil {

	public static String xzToName(String xz)
	{
		String result="";
		if(xz.equals("4"))
		{
			result = "全体人员";
		}
		else if(xz.equals("0"))
		{
			result = "专职人员";
		}
		else if(xz.equals("3"))
		{
			result = "外包人员";
		}
		return result;
	}
	public static String keyToName(String key)
	{
		String result="";
		if(key.equals("percl"))
		{
			result = "人均折合产量（人民币）";
		}
		else if(key.equals("clzb"))
		{
			result = "折合产量占比（人民币）";
		}
		else if(key.equals("ccl"))
		{
			result = "人均作业差错率";
		}
		else if(key.equals("891ccl"))
		{
			result = "账务类人均修改差错率";
		}
		else if(key.equals("891tpl"))
		{
			result = "账务类人均退票率";
		}
		else if(key.equals("891cxl"))
		{
			result = "账务类人均查询率";
		}
		else if(key.equals("891wdl"))
		{
			result = "人均转网点率";
		}
		else if(key.equals("percltime"))
		{
			result = "单位产能作业时长";
		}
		else if(key.equals("895ccl"))
		{
			result = "非账务人均修改差错率";
		}
		else if(key.equals("895tpl"))
		{
			result = "非账务人均退票率";
		}
		else if(key.equals("895cxl"))
		{
			result = "非账务人均查询率";
		}
		return result;
	}
}
