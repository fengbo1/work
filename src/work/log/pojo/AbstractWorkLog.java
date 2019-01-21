package work.log.pojo;
// default package



/**
 * AbstractWorkLog entity provides the base persistence definition of the WorkLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWorkLog  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String time;
     private String name;
     private String ip;
     private String operate;
     private String detail;
     private String remark1;
     private String remark2;
     private String remark3;
     private String remark4;
     private String remark5;


    // Constructors

    /** default constructor */
    public AbstractWorkLog() {
    }

    
    /** full constructor */
    public AbstractWorkLog(String time, String name, String ip, String operate, String detail, String remark1, String remark2, String remark3, String remark4, String remark5) {
        this.time = time;
        this.name = name;
        this.ip = ip;
        this.operate = operate;
        this.detail = detail;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.remark4 = remark4;
        this.remark5 = remark5;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperate() {
        return this.operate;
    }
    
    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }
    
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return this.remark3;
    }
    
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return this.remark4;
    }
    
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return this.remark5;
    }
    
    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }
   








}