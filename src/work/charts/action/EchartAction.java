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
import work.charts.beans.Series;

public class EchartAction {

	
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		List<String> legendList = new ArrayList<String>();//数据分组  
		List<String> categoryList = new ArrayList<String>();//横坐标  
		List<String> slist = new ArrayList<String>();
		List<Double> clist = new ArrayList<Double>();
		List<Double> wlist = new ArrayList<Double>();
		Map map = new HashMap();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*加载数据*/
		legendList.add("成都中心");
		legendList.add("武汉中心");
		categoryList.add("一季度");
		categoryList.add("二季度");
		categoryList.add("三季度");
		categoryList.add("四季度");
		clist.add(1.5);
		clist.add(2.5);
		clist.add(3.0);
		clist.add(6.3);
		wlist.add(3.1);
		wlist.add(3.4);
		wlist.add(5.1);
		wlist.add(1.1);
		//slist.add("{name:\"成都中心\",type:\"line\",data:[1.5,2.1,3,4]}");
		//slist.add("{name:\"武汉中心\",type:\"line\",data:[3.09,1,2,5]}");
		slist.add(SeriesOperation.toString("成都中心","line", clist, false,true,"red",true,false));
		slist.add(SeriesOperation.toString("武汉中心","line", wlist, true,false,null,false,false));
		map.put("legend", legendList);
		map.put("category", categoryList);
		map.put("series", slist);
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
