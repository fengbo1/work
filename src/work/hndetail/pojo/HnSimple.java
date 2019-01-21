package work.hndetail.pojo;

public class HnSimple {

	private String no;
	private int ljlr;//累计录入修改量
	private int ljjh;//累计检核修改量
	private int dtlr;//当天录入量
	private int dtjh;//当天检核量
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getLjlr() {
		return ljlr;
	}
	public void setLjlr(int ljlr) {
		this.ljlr = ljlr;
	}
	public int getLjjh() {
		return ljjh;
	}
	public void setLjjh(int ljjh) {
		this.ljjh = ljjh;
	}
	public int getDtlr() {
		return dtlr;
	}
	public void setDtlr(int dtlr) {
		this.dtlr = dtlr;
	}
	public int getDtjh() {
		return dtjh;
	}
	public void setDtjh(int dtjh) {
		this.dtjh = dtjh;
	}
	
	
}
