package work.control.pojo;

public class CfgXzShowBean {

	private int id;
	private int indx;
	private String type;
	private String content;
	private String detail;
	private int rowsp;//合并单元格的参数
	private int beijing;//表格背景2:1:0
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndx() {
		return indx;
	}
	public void setIndx(int indx) {
		this.indx = indx;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getRowsp() {
		return rowsp;
	}
	public void setRowsp(int rowsp) {
		this.rowsp = rowsp;
	}
	public int getBeijing() {
		return beijing;
	}
	public void setBeijing(int beijing) {
		this.beijing = beijing;
	}
}
