package work.hn.pojo;
// default package



/**
 * AbstractHnJihe entity provides the base persistence definition of the HnJihe entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHnJihe  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String newnumber;
     private String name;
     private Integer zx;
     private Integer xz;
     private Integer sx;
     private String pos;
     private Double cl;
     private String role;
     private Integer ywl;
     private Integer hdlzj;
     private Integer hdljh;
     private Integer fxxzj;
     private Integer fxxjh;
     private Integer fbYs;
     private Integer fbJy;
     private Integer fbGf;
     private Integer fbYb;
     private Integer fbZd;
     private Integer shYs;
     private Integer shJy;
     private Integer shGf;
     private Integer shYb;
     private Integer shZd;
     private Integer zjYs;
     private Integer zjJy;
     private Integer zjGf;
     private Integer zjYb;
     private Integer zjZd;
     private Integer remark;


    // Constructors

    /** default constructor */
    public AbstractHnJihe() {
    }

    
    /** full constructor */
    public AbstractHnJihe(String date, String newnumber, String name, Integer zx, Integer xz, Integer sx, String pos, Double cl, String role, Integer ywl, Integer hdlzj, Integer hdljh, Integer fxxzj, Integer fxxjh, Integer fbYs, Integer fbJy, Integer fbGf, Integer fbYb, Integer fbZd, Integer shYs, Integer shJy, Integer shGf, Integer shYb, Integer shZd, Integer zjYs, Integer zjJy, Integer zjGf, Integer zjYb, Integer zjZd, Integer remark) {
        this.date = date;
        this.newnumber = newnumber;
        this.name = name;
        this.zx = zx;
        this.xz = xz;
        this.sx = sx;
        this.pos = pos;
        this.cl = cl;
        this.role = role;
        this.ywl = ywl;
        this.hdlzj = hdlzj;
        this.hdljh = hdljh;
        this.fxxzj = fxxzj;
        this.fxxjh = fxxjh;
        this.fbYs = fbYs;
        this.fbJy = fbJy;
        this.fbGf = fbGf;
        this.fbYb = fbYb;
        this.fbZd = fbZd;
        this.shYs = shYs;
        this.shJy = shJy;
        this.shGf = shGf;
        this.shYb = shYb;
        this.shZd = shZd;
        this.zjYs = zjYs;
        this.zjJy = zjJy;
        this.zjGf = zjGf;
        this.zjYb = zjYb;
        this.zjZd = zjZd;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getZx() {
        return this.zx;
    }
    
    public void setZx(Integer zx) {
        this.zx = zx;
    }

    public Integer getXz() {
        return this.xz;
    }
    
    public void setXz(Integer xz) {
        this.xz = xz;
    }

    public Integer getSx() {
        return this.sx;
    }
    
    public void setSx(Integer sx) {
        this.sx = sx;
    }

    public String getPos() {
        return this.pos;
    }
    
    public void setPos(String pos) {
        this.pos = pos;
    }

    public Double getCl() {
        return this.cl;
    }
    
    public void setCl(Double cl) {
        this.cl = cl;
    }

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public Integer getYwl() {
        return this.ywl;
    }
    
    public void setYwl(Integer ywl) {
        this.ywl = ywl;
    }

    public Integer getHdlzj() {
        return this.hdlzj;
    }
    
    public void setHdlzj(Integer hdlzj) {
        this.hdlzj = hdlzj;
    }

    public Integer getHdljh() {
        return this.hdljh;
    }
    
    public void setHdljh(Integer hdljh) {
        this.hdljh = hdljh;
    }

    public Integer getFxxzj() {
        return this.fxxzj;
    }
    
    public void setFxxzj(Integer fxxzj) {
        this.fxxzj = fxxzj;
    }

    public Integer getFxxjh() {
        return this.fxxjh;
    }
    
    public void setFxxjh(Integer fxxjh) {
        this.fxxjh = fxxjh;
    }

    public Integer getFbYs() {
        return this.fbYs;
    }
    
    public void setFbYs(Integer fbYs) {
        this.fbYs = fbYs;
    }

    public Integer getFbJy() {
        return this.fbJy;
    }
    
    public void setFbJy(Integer fbJy) {
        this.fbJy = fbJy;
    }

    public Integer getFbGf() {
        return this.fbGf;
    }
    
    public void setFbGf(Integer fbGf) {
        this.fbGf = fbGf;
    }

    public Integer getFbYb() {
        return this.fbYb;
    }
    
    public void setFbYb(Integer fbYb) {
        this.fbYb = fbYb;
    }

    public Integer getFbZd() {
        return this.fbZd;
    }
    
    public void setFbZd(Integer fbZd) {
        this.fbZd = fbZd;
    }

    public Integer getShYs() {
        return this.shYs;
    }
    
    public void setShYs(Integer shYs) {
        this.shYs = shYs;
    }

    public Integer getShJy() {
        return this.shJy;
    }
    
    public void setShJy(Integer shJy) {
        this.shJy = shJy;
    }

    public Integer getShGf() {
        return this.shGf;
    }
    
    public void setShGf(Integer shGf) {
        this.shGf = shGf;
    }

    public Integer getShYb() {
        return this.shYb;
    }
    
    public void setShYb(Integer shYb) {
        this.shYb = shYb;
    }

    public Integer getShZd() {
        return this.shZd;
    }
    
    public void setShZd(Integer shZd) {
        this.shZd = shZd;
    }

    public Integer getZjYs() {
        return this.zjYs;
    }
    
    public void setZjYs(Integer zjYs) {
        this.zjYs = zjYs;
    }

    public Integer getZjJy() {
        return this.zjJy;
    }
    
    public void setZjJy(Integer zjJy) {
        this.zjJy = zjJy;
    }

    public Integer getZjGf() {
        return this.zjGf;
    }
    
    public void setZjGf(Integer zjGf) {
        this.zjGf = zjGf;
    }

    public Integer getZjYb() {
        return this.zjYb;
    }
    
    public void setZjYb(Integer zjYb) {
        this.zjYb = zjYb;
    }

    public Integer getZjZd() {
        return this.zjZd;
    }
    
    public void setZjZd(Integer zjZd) {
        this.zjZd = zjZd;
    }

    public Integer getRemark() {
        return this.remark;
    }
    
    public void setRemark(Integer remark) {
        this.remark = remark;
    }
   








}