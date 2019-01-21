package work.control.pojo;
// default package



/**
 * AbstractJhsx entity provides the base persistence definition of the Jhsx entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJhsx  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private Integer cdzwsj;
     private Integer cdzwjh;
     private Integer cdfzsj;
     private Integer cdfzjh;
     private Integer cdwhsj;
     private Integer cdwhjh;
     private Integer cdjhsj;
     private Integer cdjhjh;
     private Integer cdshsj;
     private Integer cdshjh;
     private Integer cdjysj;
     private Integer cdjyjh;
     private Integer whzwsj;
     private Integer whzwjh;
     private Integer whfzsj;
     private Integer whfzjh;
     private Integer whwhsj;
     private Integer whwhjh;
     private Integer whjhsj;
     private Integer whjhjh;
     private Integer whshsj;
     private Integer whshjh;
     private Integer whjysj;
     private Integer whjyjh;
     private String operator;


    // Constructors

    /** default constructor */
    public AbstractJhsx() {
    }

    
    /** full constructor */
    public AbstractJhsx(String date, Integer cdzwsj, Integer cdzwjh, Integer cdfzsj, Integer cdfzjh, Integer cdwhsj, Integer cdwhjh, Integer cdjhsj, Integer cdjhjh, Integer cdshsj, Integer cdshjh, Integer cdjysj, Integer cdjyjh, Integer whzwsj, Integer whzwjh, Integer whfzsj, Integer whfzjh, Integer whwhsj, Integer whwhjh, Integer whjhsj, Integer whjhjh, Integer whshsj, Integer whshjh, Integer whjysj, Integer whjyjh, String operator) {
        this.date = date;
        this.cdzwsj = cdzwsj;
        this.cdzwjh = cdzwjh;
        this.cdfzsj = cdfzsj;
        this.cdfzjh = cdfzjh;
        this.cdwhsj = cdwhsj;
        this.cdwhjh = cdwhjh;
        this.cdjhsj = cdjhsj;
        this.cdjhjh = cdjhjh;
        this.cdshsj = cdshsj;
        this.cdshjh = cdshjh;
        this.cdjysj = cdjysj;
        this.cdjyjh = cdjyjh;
        this.whzwsj = whzwsj;
        this.whzwjh = whzwjh;
        this.whfzsj = whfzsj;
        this.whfzjh = whfzjh;
        this.whwhsj = whwhsj;
        this.whwhjh = whwhjh;
        this.whjhsj = whjhsj;
        this.whjhjh = whjhjh;
        this.whshsj = whshsj;
        this.whshjh = whshjh;
        this.whjysj = whjysj;
        this.whjyjh = whjyjh;
        this.operator = operator;
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

    public Integer getCdzwsj() {
        return this.cdzwsj;
    }
    
    public void setCdzwsj(Integer cdzwsj) {
        this.cdzwsj = cdzwsj;
    }

    public Integer getCdzwjh() {
        return this.cdzwjh;
    }
    
    public void setCdzwjh(Integer cdzwjh) {
        this.cdzwjh = cdzwjh;
    }

    public Integer getCdfzsj() {
        return this.cdfzsj;
    }
    
    public void setCdfzsj(Integer cdfzsj) {
        this.cdfzsj = cdfzsj;
    }

    public Integer getCdfzjh() {
        return this.cdfzjh;
    }
    
    public void setCdfzjh(Integer cdfzjh) {
        this.cdfzjh = cdfzjh;
    }

    public Integer getCdwhsj() {
        return this.cdwhsj;
    }
    
    public void setCdwhsj(Integer cdwhsj) {
        this.cdwhsj = cdwhsj;
    }

    public Integer getCdwhjh() {
        return this.cdwhjh;
    }
    
    public void setCdwhjh(Integer cdwhjh) {
        this.cdwhjh = cdwhjh;
    }

    public Integer getCdjhsj() {
        return this.cdjhsj;
    }
    
    public void setCdjhsj(Integer cdjhsj) {
        this.cdjhsj = cdjhsj;
    }

    public Integer getCdjhjh() {
        return this.cdjhjh;
    }
    
    public void setCdjhjh(Integer cdjhjh) {
        this.cdjhjh = cdjhjh;
    }

    public Integer getCdshsj() {
        return this.cdshsj;
    }
    
    public void setCdshsj(Integer cdshsj) {
        this.cdshsj = cdshsj;
    }

    public Integer getCdshjh() {
        return this.cdshjh;
    }
    
    public void setCdshjh(Integer cdshjh) {
        this.cdshjh = cdshjh;
    }

    public Integer getCdjysj() {
        return this.cdjysj;
    }
    
    public void setCdjysj(Integer cdjysj) {
        this.cdjysj = cdjysj;
    }

    public Integer getCdjyjh() {
        return this.cdjyjh;
    }
    
    public void setCdjyjh(Integer cdjyjh) {
        this.cdjyjh = cdjyjh;
    }

    public Integer getWhzwsj() {
        return this.whzwsj;
    }
    
    public void setWhzwsj(Integer whzwsj) {
        this.whzwsj = whzwsj;
    }

    public Integer getWhzwjh() {
        return this.whzwjh;
    }
    
    public void setWhzwjh(Integer whzwjh) {
        this.whzwjh = whzwjh;
    }

    public Integer getWhfzsj() {
        return this.whfzsj;
    }
    
    public void setWhfzsj(Integer whfzsj) {
        this.whfzsj = whfzsj;
    }

    public Integer getWhfzjh() {
        return this.whfzjh;
    }
    
    public void setWhfzjh(Integer whfzjh) {
        this.whfzjh = whfzjh;
    }

    public Integer getWhwhsj() {
        return this.whwhsj;
    }
    
    public void setWhwhsj(Integer whwhsj) {
        this.whwhsj = whwhsj;
    }

    public Integer getWhwhjh() {
        return this.whwhjh;
    }
    
    public void setWhwhjh(Integer whwhjh) {
        this.whwhjh = whwhjh;
    }

    public Integer getWhjhsj() {
        return this.whjhsj;
    }
    
    public void setWhjhsj(Integer whjhsj) {
        this.whjhsj = whjhsj;
    }

    public Integer getWhjhjh() {
        return this.whjhjh;
    }
    
    public void setWhjhjh(Integer whjhjh) {
        this.whjhjh = whjhjh;
    }

    public Integer getWhshsj() {
        return this.whshsj;
    }
    
    public void setWhshsj(Integer whshsj) {
        this.whshsj = whshsj;
    }

    public Integer getWhshjh() {
        return this.whshjh;
    }
    
    public void setWhshjh(Integer whshjh) {
        this.whshjh = whshjh;
    }

    public Integer getWhjysj() {
        return this.whjysj;
    }
    
    public void setWhjysj(Integer whjysj) {
        this.whjysj = whjysj;
    }

    public Integer getWhjyjh() {
        return this.whjyjh;
    }
    
    public void setWhjyjh(Integer whjyjh) {
        this.whjyjh = whjyjh;
    }

    public String getOperator() {
        return this.operator;
    }
    
    public void setOperator(String operator) {
        this.operator = operator;
    }
   








}