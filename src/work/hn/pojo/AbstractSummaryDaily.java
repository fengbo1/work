package work.hn.pojo;
// default package



/**
 * AbstractSummaryDaily entity provides the base persistence definition of the SummaryDaily entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSummaryDaily  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String itemCode;
     private String itemName;
     private Double wh891;
     private Double wh891Zb;
     private Double wh895;
     private Double wh895Zb;
     private Double whReal;
     private Double whRealZb;
     private Double cd891;
     private Double cd891Zb;
     private Double cd895;
     private Double cd895Zb;
     private Double cdReal;
     private Double cdRealZb;
     private Double total891;
     private Double total895;
     private Double totalReal;
     private String remark1;
     private String remark2;
     private String remark3;
     private String remark4;
     private String remark5;


    // Constructors

    /** default constructor */
    public AbstractSummaryDaily() {
    }

    
    /** full constructor */
    public AbstractSummaryDaily(String date, String itemCode, String itemName, Double wh891, Double wh891Zb, Double wh895, Double wh895Zb, Double whReal, Double whRealZb, Double cd891, Double cd891Zb, Double cd895, Double cd895Zb, Double cdReal, Double cdRealZb, Double total891, Double total895, Double totalReal, String remark1, String remark2, String remark3, String remark4, String remark5) {
        this.date = date;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.wh891 = wh891;
        this.wh891Zb = wh891Zb;
        this.wh895 = wh895;
        this.wh895Zb = wh895Zb;
        this.whReal = whReal;
        this.whRealZb = whRealZb;
        this.cd891 = cd891;
        this.cd891Zb = cd891Zb;
        this.cd895 = cd895;
        this.cd895Zb = cd895Zb;
        this.cdReal = cdReal;
        this.cdRealZb = cdRealZb;
        this.total891 = total891;
        this.total895 = total895;
        this.totalReal = totalReal;
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

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getWh891() {
        return this.wh891;
    }
    
    public void setWh891(Double wh891) {
        this.wh891 = wh891;
    }

    public Double getWh891Zb() {
        return this.wh891Zb;
    }
    
    public void setWh891Zb(Double wh891Zb) {
        this.wh891Zb = wh891Zb;
    }

    public Double getWh895() {
        return this.wh895;
    }
    
    public void setWh895(Double wh895) {
        this.wh895 = wh895;
    }

    public Double getWh895Zb() {
        return this.wh895Zb;
    }
    
    public void setWh895Zb(Double wh895Zb) {
        this.wh895Zb = wh895Zb;
    }

    public Double getWhReal() {
        return this.whReal;
    }
    
    public void setWhReal(Double whReal) {
        this.whReal = whReal;
    }

    public Double getWhRealZb() {
        return this.whRealZb;
    }
    
    public void setWhRealZb(Double whRealZb) {
        this.whRealZb = whRealZb;
    }

    public Double getCd891() {
        return this.cd891;
    }
    
    public void setCd891(Double cd891) {
        this.cd891 = cd891;
    }

    public Double getCd891Zb() {
        return this.cd891Zb;
    }
    
    public void setCd891Zb(Double cd891Zb) {
        this.cd891Zb = cd891Zb;
    }

    public Double getCd895() {
        return this.cd895;
    }
    
    public void setCd895(Double cd895) {
        this.cd895 = cd895;
    }

    public Double getCd895Zb() {
        return this.cd895Zb;
    }
    
    public void setCd895Zb(Double cd895Zb) {
        this.cd895Zb = cd895Zb;
    }

    public Double getCdReal() {
        return this.cdReal;
    }
    
    public void setCdReal(Double cdReal) {
        this.cdReal = cdReal;
    }

    public Double getCdRealZb() {
        return this.cdRealZb;
    }
    
    public void setCdRealZb(Double cdRealZb) {
        this.cdRealZb = cdRealZb;
    }

    public Double getTotal891() {
        return this.total891;
    }
    
    public void setTotal891(Double total891) {
        this.total891 = total891;
    }

    public Double getTotal895() {
        return this.total895;
    }
    
    public void setTotal895(Double total895) {
        this.total895 = total895;
    }

    public Double getTotalReal() {
        return this.totalReal;
    }
    
    public void setTotalReal(Double totalReal) {
        this.totalReal = totalReal;
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