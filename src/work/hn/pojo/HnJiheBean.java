package work.hn.pojo;

public class HnJiheBean {
	 private Integer id;
     private String date;
     private String newnumber;
     private String name;
     private String zx;
     private String cl;
     //private String role;
     //private String ywl;
     private String hdlzj;
//     private String hdljh;
     private String fxxzj;
     private String fxxjh;
     
     private String wt;
     private String fb;
     private String sh;
     private String zj;
//     private String fbYs;
//     private String fbJy;
//     private String fbGf;
//     private String fbYb;
//     private String fbZd;
//     private String shYs;
//     private String shJy;
//     private String shGf;
//     private String shYb;
//     private String shZd;
//     private String zjYs;
//     private String zjJy;
//     private String zjGf;
//     private String zjYb;
//     private String zjZd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZx() {
		return zx;
	}
	public void setZx(String zx) {
		this.zx = zx;
	}
	public String getCl() {
		return cl;
	}
	public void setCl(String cl) {
		this.cl = cl;
	}

	public String getHdlzj() {
		return hdlzj;
	}
	public void setHdlzj(String hdlzj) {
		this.hdlzj = hdlzj;
	}
	public String getFb() {
		return fb;
	}
	public void setFb(String fb) {
		this.fb = fb;
	}
	public String getSh() {
		return sh;
	}
	public void setSh(String sh) {
		this.sh = sh;
	}
	public String getZj() {
		return zj;
	}
	public void setZj(String zj) {
		this.zj = zj;
	}
	public String getFxxzj() {
		return fxxzj;
	}
	public void setFxxzj(String fxxzj) {
		this.fxxzj = fxxzj;
	}
	public String getFxxjh() {
		return fxxjh;
	}
	public void setFxxjh(String fxxjh) {
		this.fxxjh = fxxjh;
	}
	
	public String getWt() {
		return wt;
	}
	public void setWt(String wt) {
		this.wt = wt;
	}
	
	public HnJiheBean(Integer id, String date, String newnumber, String name,
			String zx, String cl, String hdlzj, String fxxzj, String fxxjh,
			String wt, String fb, String sh, String zj) {
		super();
		this.id = id;
		this.date = date;
		this.newnumber = newnumber;
		this.name = name;
		this.zx = zx;
		this.cl = cl;
		this.hdlzj = hdlzj;
		this.fxxzj = fxxzj;
		this.fxxjh = fxxjh;
		this.wt = wt;
		this.fb = fb;
		this.sh = sh;
		this.zj = zj;
	}
	public HnJiheBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
