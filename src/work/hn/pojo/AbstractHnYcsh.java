package work.hn.pojo;
// default package



/**
 * AbstractHnYcsh entity provides the base persistence definition of the HnYcsh entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHnYcsh  implements java.io.Serializable {


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
     private Integer num;
     private Integer sc;
     private Double pjsc;
     private Integer tg;
     private Double tgl;
     private Integer jj;
     private Double jjl;
     private Integer cx;
     private Double cxl;
     private Double zxsc;


    // Constructors

    /** default constructor */
    public AbstractHnYcsh() {
    }

    
    /** full constructor */
    public AbstractHnYcsh(String date, String newnumber, String name, Integer zx, Integer xz, Integer sx, String pos, Double cl, Integer num, Integer sc, Double pjsc, Integer tg, Double tgl, Integer jj, Double jjl, Integer cx, Double cxl, Double zxsc) {
        this.date = date;
        this.newnumber = newnumber;
        this.name = name;
        this.zx = zx;
        this.xz = xz;
        this.sx = sx;
        this.pos = pos;
        this.cl = cl;
        this.num = num;
        this.sc = sc;
        this.pjsc = pjsc;
        this.tg = tg;
        this.tgl = tgl;
        this.jj = jj;
        this.jjl = jjl;
        this.cx = cx;
        this.cxl = cxl;
        this.zxsc = zxsc;
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

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSc() {
        return this.sc;
    }
    
    public void setSc(Integer sc) {
        this.sc = sc;
    }

    public Double getPjsc() {
        return this.pjsc;
    }
    
    public void setPjsc(Double pjsc) {
        this.pjsc = pjsc;
    }

    public Integer getTg() {
        return this.tg;
    }
    
    public void setTg(Integer tg) {
        this.tg = tg;
    }

    public Double getTgl() {
        return this.tgl;
    }
    
    public void setTgl(Double tgl) {
        this.tgl = tgl;
    }

    public Integer getJj() {
        return this.jj;
    }
    
    public void setJj(Integer jj) {
        this.jj = jj;
    }

    public Double getJjl() {
        return this.jjl;
    }
    
    public void setJjl(Double jjl) {
        this.jjl = jjl;
    }

    public Integer getCx() {
        return this.cx;
    }
    
    public void setCx(Integer cx) {
        this.cx = cx;
    }

    public Double getCxl() {
        return this.cxl;
    }
    
    public void setCxl(Double cxl) {
        this.cxl = cxl;
    }

    public Double getZxsc() {
        return this.zxsc;
    }
    
    public void setZxsc(Double zxsc) {
        this.zxsc = zxsc;
    }
   








}