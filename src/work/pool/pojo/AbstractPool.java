package work.pool.pojo;
// default package



/**
 * AbstractPool entity provides the base persistence definition of the Pool entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPool  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String no;
     private Integer type;
     private Integer intype;
     private String part;
     private String code;
     private Integer number;
     private Integer cc;
     private Integer tp;
     private String sc;


    // Constructors

    /** default constructor */
    public AbstractPool() {
    }

    
    /** full constructor */
    public AbstractPool(String no, Integer type, Integer intype, String part, String code, Integer number, Integer cc, Integer tp, String sc) {
        this.no = no;
        this.type = type;
        this.intype = intype;
        this.part = part;
        this.code = code;
        this.number = number;
        this.cc = cc;
        this.tp = tp;
        this.sc = sc;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return this.no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIntype() {
        return this.intype;
    }
    
    public void setIntype(Integer intype) {
        this.intype = intype;
    }

    public String getPart() {
        return this.part;
    }
    
    public void setPart(String part) {
        this.part = part;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCc() {
        return this.cc;
    }
    
    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Integer getTp() {
        return this.tp;
    }
    
    public void setTp(Integer tp) {
        this.tp = tp;
    }

    public String getSc() {
        return this.sc;
    }
    
    public void setSc(String sc) {
        this.sc = sc;
    }
   








}