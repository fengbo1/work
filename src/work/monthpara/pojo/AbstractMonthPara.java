package work.monthpara.pojo;
// default package



/**
 * AbstractMonthPara entity provides the base persistence definition of the MonthPara entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMonthPara  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String month;
     private Double hnCl;
     private Double hnZl;
     private Double wbCl;
     private Double TBz;
     private Double clYj;
     private Double zlYj;
     private Double xlYj;
     private String remark1;
     private String remark2;
     private String remark3;


    // Constructors

    /** default constructor */
    public AbstractMonthPara() {
    }

    
    /** full constructor */
    public AbstractMonthPara(String month, Double hnCl, Double hnZl, Double wbCl, Double TBz, Double clYj, Double zlYj, Double xlYj, String remark1, String remark2, String remark3) {
        this.month = month;
        this.hnCl = hnCl;
        this.hnZl = hnZl;
        this.wbCl = wbCl;
        this.TBz = TBz;
        this.clYj = clYj;
        this.zlYj = zlYj;
        this.xlYj = xlYj;
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

    public String getMonth() {
        return this.month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }

    public Double getHnCl() {
        return this.hnCl;
    }
    
    public void setHnCl(Double hnCl) {
        this.hnCl = hnCl;
    }

    public Double getHnZl() {
        return this.hnZl;
    }
    
    public void setHnZl(Double hnZl) {
        this.hnZl = hnZl;
    }

    public Double getWbCl() {
        return this.wbCl;
    }
    
    public void setWbCl(Double wbCl) {
        this.wbCl = wbCl;
    }

    public Double getTBz() {
        return this.TBz;
    }
    
    public void setTBz(Double TBz) {
        this.TBz = TBz;
    }

    public Double getClYj() {
        return this.clYj;
    }
    
    public void setClYj(Double clYj) {
        this.clYj = clYj;
    }

    public Double getZlYj() {
        return this.zlYj;
    }
    
    public void setZlYj(Double zlYj) {
        this.zlYj = zlYj;
    }

    public Double getXlYj() {
        return this.xlYj;
    }
    
    public void setXlYj(Double xlYj) {
        this.xlYj = xlYj;
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