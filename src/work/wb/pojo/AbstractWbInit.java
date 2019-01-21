package work.wb.pojo;
// default package



/**
 * AbstractWbInit entity provides the base persistence definition of the WbInit entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWbInit  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String no;
     private String name;
     private Integer step;
     private Integer ywl;
     private Double averTime;
     private Integer cc;
     private Integer hs;
     private Integer zlrxg;
     private Integer zyxcf;
     private String pool;
     private String remark1;
     private String remark2;
     private String remark3;


    // Constructors

    /** default constructor */
    public AbstractWbInit() {
    }

    
    /** full constructor */
    public AbstractWbInit(String no, String name, Integer step, Integer ywl, Double averTime, Integer cc, Integer hs, Integer zlrxg, Integer zyxcf, String pool, String remark1, String remark2, String remark3) {
        this.no = no;
        this.name = name;
        this.step = step;
        this.ywl = ywl;
        this.averTime = averTime;
        this.cc = cc;
        this.hs = hs;
        this.zlrxg = zlrxg;
        this.zyxcf = zyxcf;
        this.pool = pool;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
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

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getStep() {
        return this.step;
    }
    
    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getYwl() {
        return this.ywl;
    }
    
    public void setYwl(Integer ywl) {
        this.ywl = ywl;
    }

    public Double getAverTime() {
        return this.averTime;
    }
    
    public void setAverTime(Double averTime) {
        this.averTime = averTime;
    }

    public Integer getCc() {
        return this.cc;
    }
    
    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Integer getHs() {
        return this.hs;
    }
    
    public void setHs(Integer hs) {
        this.hs = hs;
    }

    public Integer getZlrxg() {
        return this.zlrxg;
    }
    
    public void setZlrxg(Integer zlrxg) {
        this.zlrxg = zlrxg;
    }

    public Integer getZyxcf() {
        return this.zyxcf;
    }
    
    public void setZyxcf(Integer zyxcf) {
        this.zyxcf = zyxcf;
    }

    public String getPool() {
        return this.pool;
    }
    
    public void setPool(String pool) {
        this.pool = pool;
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
   








}