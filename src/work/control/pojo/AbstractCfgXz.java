package work.control.pojo;
// default package



/**
 * AbstractCfgXz entity provides the base persistence definition of the CfgXz entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCfgXz  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer tnum;
     private Integer indx;
     private String type;
     private String cnum;
     private String content;
     private String detail;


    // Constructors

    /** default constructor */
    public AbstractCfgXz() {
    }

    
    /** full constructor */
    public AbstractCfgXz(Integer tnum, Integer indx, String type, String cnum, String content, String detail) {
        this.tnum = tnum;
        this.indx = indx;
        this.type = type;
        this.cnum = cnum;
        this.content = content;
        this.detail = detail;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTnum() {
        return this.tnum;
    }
    
    public void setTnum(Integer tnum) {
        this.tnum = tnum;
    }

    public Integer getIndx() {
        return this.indx;
    }
    
    public void setIndx(Integer indx) {
        this.indx = indx;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getCnum() {
        return this.cnum;
    }
    
    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
   








}