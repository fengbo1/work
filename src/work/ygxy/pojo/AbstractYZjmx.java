package work.ygxy.pojo;
// default package



/**
 * AbstractYZjmx entity provides the base persistence definition of the YZjmx entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYZjmx  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer xh;
     private String name;
     private String no;
     private String gdnumber;
     private Integer lzxh;
     private String date;
     private Integer cjdf;
     private String zjrw;
     private Integer fjdf;


    // Constructors

    /** default constructor */
    public AbstractYZjmx() {
    }

    
    /** full constructor */
    public AbstractYZjmx(Integer xh, String name, String no, String gdnumber, Integer lzxh, String date, Integer cjdf, String zjrw, Integer fjdf) {
        this.xh = xh;
        this.name = name;
        this.no = no;
        this.gdnumber = gdnumber;
        this.lzxh = lzxh;
        this.date = date;
        this.cjdf = cjdf;
        this.zjrw = zjrw;
        this.fjdf = fjdf;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXh() {
        return this.xh;
    }
    
    public void setXh(Integer xh) {
        this.xh = xh;
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

    public String getGdnumber() {
        return this.gdnumber;
    }
    
    public void setGdnumber(String gdnumber) {
        this.gdnumber = gdnumber;
    }

    public Integer getLzxh() {
        return this.lzxh;
    }
    
    public void setLzxh(Integer lzxh) {
        this.lzxh = lzxh;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCjdf() {
        return this.cjdf;
    }
    
    public void setCjdf(Integer cjdf) {
        this.cjdf = cjdf;
    }

    public String getZjrw() {
        return this.zjrw;
    }
    
    public void setZjrw(String zjrw) {
        this.zjrw = zjrw;
    }

    public Integer getFjdf() {
        return this.fjdf;
    }
    
    public void setFjdf(Integer fjdf) {
        this.fjdf = fjdf;
    }
   








}