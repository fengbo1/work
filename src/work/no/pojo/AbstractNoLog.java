package work.no.pojo;
// default package



/**
 * AbstractNoLog entity provides the base persistence definition of the NoLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNoLog  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String no;
     private Integer type;
     private String para;
     private String bef;
     private String aft;
     private String operator;
     private String time;
     private String remark;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractNoLog() {
    }

    
    /** full constructor */
    public AbstractNoLog(String name, String no, Integer type, String para, String bef, String aft, String operator, String time, String remark, String remark1, String remark2) {
        this.name = name;
        this.no = no;
        this.type = type;
        this.para = para;
        this.bef = bef;
        this.aft = aft;
        this.operator = operator;
        this.time = time;
        this.remark = remark;
        this.remark1 = remark1;
        this.remark2 = remark2;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public String getPara() {
        return this.para;
    }
    
    public void setPara(String para) {
        this.para = para;
    }

    public String getBef() {
        return this.bef;
    }
    
    public void setBef(String bef) {
        this.bef = bef;
    }

    public String getAft() {
        return this.aft;
    }
    
    public void setAft(String aft) {
        this.aft = aft;
    }

    public String getOperator() {
        return this.operator;
    }
    
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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
   








}