package work.rulecase.pojo;
// default package



/**
 * AbstractRcRule entity provides the base persistence definition of the RcRule entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRcRule  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String renewdate;
     private String plate;
     private String pool;
     private String part;
     private String area;
     private String factor;
     private String facAName;
     private String facBName;
     private String facCName;
     private String facA;
     private String facB;
     private String facC;
     private String picname;
     private String rule;
     private String exp;
     private String renewexp;
     private String remark;
     private String fujian;


    // Constructors

    /** default constructor */
    public AbstractRcRule() {
    }

    
    /** full constructor */
    public AbstractRcRule(String renewdate, String plate, String pool, String part, String area, String factor, String facAName, String facBName, String facCName, String facA, String facB, String facC, String picname, String rule, String exp, String renewexp, String remark, String fujian) {
        this.renewdate = renewdate;
        this.plate = plate;
        this.pool = pool;
        this.part = part;
        this.area = area;
        this.factor = factor;
        this.facAName = facAName;
        this.facBName = facBName;
        this.facCName = facCName;
        this.facA = facA;
        this.facB = facB;
        this.facC = facC;
        this.picname = picname;
        this.rule = rule;
        this.exp = exp;
        this.renewexp = renewexp;
        this.remark = remark;
        this.fujian = fujian;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRenewdate() {
        return this.renewdate;
    }
    
    public void setRenewdate(String renewdate) {
        this.renewdate = renewdate;
    }

    public String getPlate() {
        return this.plate;
    }
    
    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPool() {
        return this.pool;
    }
    
    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getPart() {
        return this.part;
    }
    
    public void setPart(String part) {
        this.part = part;
    }

    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }

    public String getFactor() {
        return this.factor;
    }
    
    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getFacAName() {
        return this.facAName;
    }
    
    public void setFacAName(String facAName) {
        this.facAName = facAName;
    }

    public String getFacBName() {
        return this.facBName;
    }
    
    public void setFacBName(String facBName) {
        this.facBName = facBName;
    }

    public String getFacCName() {
        return this.facCName;
    }
    
    public void setFacCName(String facCName) {
        this.facCName = facCName;
    }

    public String getFacA() {
        return this.facA;
    }
    
    public void setFacA(String facA) {
        this.facA = facA;
    }

    public String getFacB() {
        return this.facB;
    }
    
    public void setFacB(String facB) {
        this.facB = facB;
    }

    public String getFacC() {
        return this.facC;
    }
    
    public void setFacC(String facC) {
        this.facC = facC;
    }

    public String getPicname() {
        return this.picname;
    }
    
    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getRule() {
        return this.rule;
    }
    
    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getExp() {
        return this.exp;
    }
    
    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getRenewexp() {
        return this.renewexp;
    }
    
    public void setRenewexp(String renewexp) {
        this.renewexp = renewexp;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFujian() {
        return this.fujian;
    }
    
    public void setFujian(String fujian) {
        this.fujian = fujian;
    }
   








}