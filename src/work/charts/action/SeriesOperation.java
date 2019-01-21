package work.charts.action;

import java.util.List;

public class SeriesOperation {

	/**
	 * 根据图表参数转换成JSON格式字符串
	 * @param name 数据名称  必填
	 * @param type 展示类型（line/bar）  必填
	 * @param data 数据内容 double  必填
	 * @param smooth 是否是平滑曲线
	 * @param showdata 是否显示数据
	 * @param color 线条颜色   默认颜色：null
	 * @param dashed 是否是虚线
	 * @param bottom 标签是否在下面
	 * @return JSON格式字符串
	 */
	public static String toString(String name,String type,List<Double> data,boolean smooth,boolean showdata,String color,boolean dashed,boolean bottom) {
		
		String StrJson = "{name:\""+name+"\",type:\""+type+"\"";
		String strbottom = "";
		if(bottom)
		{
			strbottom = ",position:\"bottom\"";
		}
		if(smooth)
		{
			StrJson += ",smooth:true";
		}
		if(color!=null)
		{
			StrJson += ",itemStyle:{"
					+"normal: {"
					+"color: \""+color+"\"";
			if(dashed)
			{
				StrJson +=",lineStyle: {"        
						+"type: \"dotted\""
						+"}";
			}
			StrJson += "}}";
		}
		else
		{
			if(dashed)
			{
				StrJson += ",itemStyle:{"
					+"normal: {"
					+"lineStyle: {"        
					+"type: \"dashed\""
					+"}}}";
			}
		}
		if(data.size()>0)
		{
			StrJson += ",data:[";
			if(showdata)
			{
				for(int i=0;i<data.size();i++)
				{
					StrJson +="{value:"+data.get(i)+",itemStyle : { normal: {label : {show: true"+strbottom+"}}}}";
					if(i!=(data.size()-1))
					{
						StrJson +=",";
					}
				}	
			}
			else
			{
				for(int i=0;i<data.size();i++)
				{
					StrJson +="{value:"+data.get(i)+",symbol: 'none'}";
					if(i!=(data.size()-1))
					{
						StrJson +=",";
					}
				}
			}
			StrJson += "]";
		}
		StrJson += "}";
		System.out.println(StrJson);
		return StrJson;
	}
	
	/**
	 * 根据图表参数转换成JSON格式字符串,data数据类型为Integer
	 * @param name 数据名称  必填
	 * @param type 展示类型（line/bar）  必填
	 * @param data 数据内容 int  必填
	 * @param smooth 是否是平滑曲线
	 * @param showdata 是否显示数据
	 * @param color 线条颜色   默认颜色：null
	 * @param dashed 是否是虚线
	 * @param bottom 标签是否在下面
	 * @return JSON格式字符串
	 */
	public static String toStringInteger(String name,String type,List<Integer> data,boolean smooth,boolean showdata,String color,boolean dashed,boolean bottom) {
		
		String StrJson = "{name:\""+name+"\",type:\""+type+"\"";
		String strbottom = "";
		if(bottom)
		{
			strbottom = ",position:\"bottom\"";
		}
		if(smooth)
		{
			StrJson += ",smooth:true";
		}
		if(color!=null)
		{
			StrJson += ",itemStyle:{"
					+"normal: {"
					+"color: \""+color+"\"";
			if(dashed)
			{
				StrJson +=",lineStyle: {"        
						+"type: \"dashed\""
						+"}";
			}
			StrJson += "}}";
		}
		else
		{
			if(dashed)
			{
				StrJson += ",itemStyle:{"
					+"normal: {"
					+"lineStyle: {"        
					+"type: \"dashed\""
					+"}}}";
			}
		}
		if(data.size()>0)
		{
			StrJson += ",data:[";
			if(showdata)
			{
				for(int i=0;i<data.size();i++)
				{
					StrJson +="{value:"+data.get(i)+",itemStyle : { normal: {label : {show: true"+strbottom+"}}}}";
					if(i!=(data.size()-1))
					{
						StrJson +=",";
					}
				}	
			}
			else
			{
				for(int i=0;i<data.size();i++)
				{
					StrJson +="{value:"+data.get(i)+",symbol: 'none'}";
					if(i!=(data.size()-1))
					{
						StrJson +=",";
					}
				}
			}
			StrJson += "]";
		}
		StrJson += "}";
		System.out.println(StrJson);
		return StrJson;
	}
}
