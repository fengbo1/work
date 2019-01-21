package work.charts.beans;

import java.util.List;

public class Series {
	
	public String name; /*数据名 */
	public String type; /*图表类型line/bar等 */
	public String data;/*数值 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Series(String name, String type, String data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}
	
	

}
