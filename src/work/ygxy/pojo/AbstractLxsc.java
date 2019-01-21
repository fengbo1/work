package work.ygxy.pojo;
// default package



/**
 * AbstractLxsc entity provides the base persistence definition of the Lxsc entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLxsc  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String name;
     private String reason;
     private Double shichang;
     private Integer youxiao;


    // Constructors

    /** default constructor */
    public AbstractLxsc() {
    }

    
    /** full constructor */
    public AbstractLxsc(String date, String name, String reason, Double shichang, Integer youxiao) {
        this.date = date;
        this.name = name;
        this.reason = reason;
        this.shichang = shichang;
        this.youxiao = youxiao;
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

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getShichang() {
        return this.shichang;
    }
    
    public void setShichang(Double shichang) {
        this.shichang = shichang;
    }

    public Integer getYouxiao() {
        return this.youxiao;
    }
    
    public void setYouxiao(Integer youxiao) {
        this.youxiao = youxiao;
    }
   








}