package work.control.pojo;
// default package



/**
 * AbstractHnConfig entity provides the base persistence definition of the HnConfig entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHnConfig  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer type;
     private String code;
     private String part;
     private Integer intype;
     private String weig;
     private Integer ord;


    // Constructors

    /** default constructor */
    public AbstractHnConfig() {
    }

    
    /** full constructor */
    public AbstractHnConfig(Integer type, String code, String part, Integer intype, String weig, Integer ord) {
        this.type = type;
        this.code = code;
        this.part = part;
        this.intype = intype;
        this.weig = weig;
        this.ord = ord;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getPart() {
        return this.part;
    }
    
    public void setPart(String part) {
        this.part = part;
    }

    public Integer getIntype() {
        return this.intype;
    }
    
    public void setIntype(Integer intype) {
        this.intype = intype;
    }

    public String getWeig() {
        return this.weig;
    }
    
    public void setWeig(String weig) {
        this.weig = weig;
    }

    public Integer getOrd() {
        return this.ord;
    }
    
    public void setOrd(Integer ord) {
        this.ord = ord;
    }
   








}