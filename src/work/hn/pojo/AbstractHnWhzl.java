package work.hn.pojo;
// default package



/**
 * AbstractHnWhzl entity provides the base persistence definition of the HnWhzl entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHnWhzl  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String name;
     private String no;
     private Double cxlrmb;
     private Integer qdld;
     private Double zwdl;
     private Integer bhwh;
     private Double cxlwh;
     private Double cxljy;


    // Constructors

    /** default constructor */
    public AbstractHnWhzl() {
    }

    
    /** full constructor */
    public AbstractHnWhzl(String date, String name, String no, Double cxlrmb, Integer qdld, Double zwdl, Integer bhwh, Double cxlwh, Double cxljy) {
        this.date = date;
        this.name = name;
        this.no = no;
        this.cxlrmb = cxlrmb;
        this.qdld = qdld;
        this.zwdl = zwdl;
        this.bhwh = bhwh;
        this.cxlwh = cxlwh;
        this.cxljy = cxljy;
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

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return this.no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }

    public Double getCxlrmb() {
        return this.cxlrmb;
    }
    
    public void setCxlrmb(Double cxlrmb) {
        this.cxlrmb = cxlrmb;
    }

    public Integer getQdld() {
        return this.qdld;
    }
    
    public void setQdld(Integer qdld) {
        this.qdld = qdld;
    }

    public Double getZwdl() {
        return this.zwdl;
    }
    
    public void setZwdl(Double zwdl) {
        this.zwdl = zwdl;
    }

    public Integer getBhwh() {
        return this.bhwh;
    }
    
    public void setBhwh(Integer bhwh) {
        this.bhwh = bhwh;
    }

    public Double getCxlwh() {
        return this.cxlwh;
    }
    
    public void setCxlwh(Double cxlwh) {
        this.cxlwh = cxlwh;
    }

    public Double getCxljy() {
        return this.cxljy;
    }
    
    public void setCxljy(Double cxljy) {
        this.cxljy = cxljy;
    }
   








}