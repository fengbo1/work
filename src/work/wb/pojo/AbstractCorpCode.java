package work.wb.pojo;
// default package



/**
 * AbstractCorpCode entity provides the base persistence definition of the CorpCode entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCorpCode  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String no;
     private String name;
     private String status;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractCorpCode() {
    }

    
    /** full constructor */
    public AbstractCorpCode(String no, String name, String status, String remark1, String remark2) {
        this.no = no;
        this.name = name;
        this.status = status;
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

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
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