package work.ygxy.pojo;
// default package



/**
 * AbstractYPbmx entity provides the base persistence definition of the YPbmx entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYPbmx  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String name;
     private String no;
     private Integer ifsb;
     private Integer iflh;
     private Integer ifgd;
     private Integer type;


    // Constructors

    /** default constructor */
    public AbstractYPbmx() {
    }

    
    /** full constructor */
    public AbstractYPbmx(String date, String name, String no, Integer ifsb, Integer iflh, Integer ifgd, Integer type) {
        this.date = date;
        this.name = name;
        this.no = no;
        this.ifsb = ifsb;
        this.iflh = iflh;
        this.ifgd = ifgd;
        this.type = type;
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

    public Integer getIfsb() {
        return this.ifsb;
    }
    
    public void setIfsb(Integer ifsb) {
        this.ifsb = ifsb;
    }

    public Integer getIflh() {
        return this.iflh;
    }
    
    public void setIflh(Integer iflh) {
        this.iflh = iflh;
    }

    public Integer getIfgd() {
        return this.ifgd;
    }
    
    public void setIfgd(Integer ifgd) {
        this.ifgd = ifgd;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
   








}