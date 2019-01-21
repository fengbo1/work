package work.control.pojo;

import java.util.List;

public class CfgXzBean {

	private int tnum;
	private String tid;
	private String type;
	private List<CfgXz> contents;
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<CfgXz> getContents() {
		return contents;
	}
	public void setContents(List<CfgXz> contents) {
		this.contents = contents;
	}
	
}
