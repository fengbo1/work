package work.hn.pojo;
// default package



/**
 * AbstractHnFxq entity provides the base persistence definition of the HnFxq entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHnFxq  implements java.io.Serializable {


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
     private Integer ywl;
     private Integer dekh;
     private Integer demx;
     private Integer kykh;
     private Integer kymx;


    // Constructors

    /** default constructor */
    public AbstractHnFxq() {
    }

    
    /** full constructor */
    public AbstractHnFxq(String date, String newnumber, String name, Integer zx, Integer xz, Integer sx, String pos, Double cl, Integer ywl, Integer dekh, Integer demx, Integer kykh, Integer kymx) {
        this.date = date;
        this.newnumber = newnumber;
        this.name = name;
        this.zx = zx;
        this.xz = xz;
        this.sx = sx;
        this.pos = pos;
        this.cl = cl;
        this.ywl = ywl;
        this.dekh = dekh;
        this.demx = demx;
        this.kykh = kykh;
        this.kymx = kymx;
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

    public Integer getYwl() {
        return this.ywl;
    }
    
    public void setYwl(Integer ywl) {
        this.ywl = ywl;
    }

    public Integer getDekh() {
        return this.dekh;
    }
    
    public void setDekh(Integer dekh) {
        this.dekh = dekh;
    }

    public Integer getDemx() {
        return this.demx;
    }
    
    public void setDemx(Integer demx) {
        this.demx = demx;
    }

    public Integer getKykh() {
        return this.kykh;
    }
    
    public void setKykh(Integer kykh) {
        this.kykh = kykh;
    }

    public Integer getKymx() {
        return this.kymx;
    }
    
    public void setKymx(Integer kymx) {
        this.kymx = kymx;
    }
   








}