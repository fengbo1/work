package work.wb.pojo;
// default package



/**
 * AbstractWbBaseSave entity provides the base persistence definition of the WbBaseSave entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWbBaseSave  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String no;
     private String name;
     private Integer yslr;
     private Double yslrTime;
     private Integer yslrCc;
     private Integer yslrHs;
     private Integer yslrZy;
     private Integer yslrZl;
     private Integer lrzc;
     private Double lrzcTime;
     private Integer lrzcCc;
     private Integer lrzcHs;
     private Integer lrzcZl;
     private Integer fzyy;
     private Double fzyyTime;
     private Integer fzyyCc;
     private Integer fzyyHs;
     private Double workYslr;
     private Double yslrCcl;
     private Double yslrHsl;
     private Double yslrZyl;
     private Double yslrZll;
     private Double lrzcCcl;
     private Double lrzcHsl;
     private Double fzyyCcl;
     private Double fzyyHsl;
     private Double lrzcZll;
     private String remark1;
     private String remark2;
     private Double workFzyy;
     private Double workLrzc;
     private Double workTime;


    // Constructors

    /** default constructor */
    public AbstractWbBaseSave() {
    }

    
    /** full constructor */
    public AbstractWbBaseSave(String date, String no, String name, Integer yslr, Double yslrTime, Integer yslrCc, Integer yslrHs, Integer yslrZy, Integer yslrZl, Integer lrzc, Double lrzcTime, Integer lrzcCc, Integer lrzcHs, Integer lrzcZl, Integer fzyy, Double fzyyTime, Integer fzyyCc, Integer fzyyHs, Double workYslr, Double yslrCcl, Double yslrHsl, Double yslrZyl, Double yslrZll, Double lrzcCcl, Double lrzcHsl, Double fzyyCcl, Double fzyyHsl, Double lrzcZll, String remark1, String remark2, Double workFzyy, Double workLrzc, Double workTime) {
        this.date = date;
        this.no = no;
        this.name = name;
        this.yslr = yslr;
        this.yslrTime = yslrTime;
        this.yslrCc = yslrCc;
        this.yslrHs = yslrHs;
        this.yslrZy = yslrZy;
        this.yslrZl = yslrZl;
        this.lrzc = lrzc;
        this.lrzcTime = lrzcTime;
        this.lrzcCc = lrzcCc;
        this.lrzcHs = lrzcHs;
        this.lrzcZl = lrzcZl;
        this.fzyy = fzyy;
        this.fzyyTime = fzyyTime;
        this.fzyyCc = fzyyCc;
        this.fzyyHs = fzyyHs;
        this.workYslr = workYslr;
        this.yslrCcl = yslrCcl;
        this.yslrHsl = yslrHsl;
        this.yslrZyl = yslrZyl;
        this.yslrZll = yslrZll;
        this.lrzcCcl = lrzcCcl;
        this.lrzcHsl = lrzcHsl;
        this.fzyyCcl = fzyyCcl;
        this.fzyyHsl = fzyyHsl;
        this.lrzcZll = lrzcZll;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.workFzyy = workFzyy;
        this.workLrzc = workLrzc;
        this.workTime = workTime;
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

    public Integer getYslr() {
        return this.yslr;
    }
    
    public void setYslr(Integer yslr) {
        this.yslr = yslr;
    }

    public Double getYslrTime() {
        return this.yslrTime;
    }
    
    public void setYslrTime(Double yslrTime) {
        this.yslrTime = yslrTime;
    }

    public Integer getYslrCc() {
        return this.yslrCc;
    }
    
    public void setYslrCc(Integer yslrCc) {
        this.yslrCc = yslrCc;
    }

    public Integer getYslrHs() {
        return this.yslrHs;
    }
    
    public void setYslrHs(Integer yslrHs) {
        this.yslrHs = yslrHs;
    }

    public Integer getYslrZy() {
        return this.yslrZy;
    }
    
    public void setYslrZy(Integer yslrZy) {
        this.yslrZy = yslrZy;
    }

    public Integer getYslrZl() {
        return this.yslrZl;
    }
    
    public void setYslrZl(Integer yslrZl) {
        this.yslrZl = yslrZl;
    }

    public Integer getLrzc() {
        return this.lrzc;
    }
    
    public void setLrzc(Integer lrzc) {
        this.lrzc = lrzc;
    }

    public Double getLrzcTime() {
        return this.lrzcTime;
    }
    
    public void setLrzcTime(Double lrzcTime) {
        this.lrzcTime = lrzcTime;
    }

    public Integer getLrzcCc() {
        return this.lrzcCc;
    }
    
    public void setLrzcCc(Integer lrzcCc) {
        this.lrzcCc = lrzcCc;
    }

    public Integer getLrzcHs() {
        return this.lrzcHs;
    }
    
    public void setLrzcHs(Integer lrzcHs) {
        this.lrzcHs = lrzcHs;
    }

    public Integer getLrzcZl() {
        return this.lrzcZl;
    }
    
    public void setLrzcZl(Integer lrzcZl) {
        this.lrzcZl = lrzcZl;
    }

    public Integer getFzyy() {
        return this.fzyy;
    }
    
    public void setFzyy(Integer fzyy) {
        this.fzyy = fzyy;
    }

    public Double getFzyyTime() {
        return this.fzyyTime;
    }
    
    public void setFzyyTime(Double fzyyTime) {
        this.fzyyTime = fzyyTime;
    }

    public Integer getFzyyCc() {
        return this.fzyyCc;
    }
    
    public void setFzyyCc(Integer fzyyCc) {
        this.fzyyCc = fzyyCc;
    }

    public Integer getFzyyHs() {
        return this.fzyyHs;
    }
    
    public void setFzyyHs(Integer fzyyHs) {
        this.fzyyHs = fzyyHs;
    }

    public Double getWorkYslr() {
        return this.workYslr;
    }
    
    public void setWorkYslr(Double workYslr) {
        this.workYslr = workYslr;
    }

    public Double getYslrCcl() {
        return this.yslrCcl;
    }
    
    public void setYslrCcl(Double yslrCcl) {
        this.yslrCcl = yslrCcl;
    }

    public Double getYslrHsl() {
        return this.yslrHsl;
    }
    
    public void setYslrHsl(Double yslrHsl) {
        this.yslrHsl = yslrHsl;
    }

    public Double getYslrZyl() {
        return this.yslrZyl;
    }
    
    public void setYslrZyl(Double yslrZyl) {
        this.yslrZyl = yslrZyl;
    }

    public Double getYslrZll() {
        return this.yslrZll;
    }
    
    public void setYslrZll(Double yslrZll) {
        this.yslrZll = yslrZll;
    }

    public Double getLrzcCcl() {
        return this.lrzcCcl;
    }
    
    public void setLrzcCcl(Double lrzcCcl) {
        this.lrzcCcl = lrzcCcl;
    }

    public Double getLrzcHsl() {
        return this.lrzcHsl;
    }
    
    public void setLrzcHsl(Double lrzcHsl) {
        this.lrzcHsl = lrzcHsl;
    }

    public Double getFzyyCcl() {
        return this.fzyyCcl;
    }
    
    public void setFzyyCcl(Double fzyyCcl) {
        this.fzyyCcl = fzyyCcl;
    }

    public Double getFzyyHsl() {
        return this.fzyyHsl;
    }
    
    public void setFzyyHsl(Double fzyyHsl) {
        this.fzyyHsl = fzyyHsl;
    }

    public Double getLrzcZll() {
        return this.lrzcZll;
    }
    
    public void setLrzcZll(Double lrzcZll) {
        this.lrzcZll = lrzcZll;
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

    public Double getWorkFzyy() {
        return this.workFzyy;
    }
    
    public void setWorkFzyy(Double workFzyy) {
        this.workFzyy = workFzyy;
    }

    public Double getWorkLrzc() {
        return this.workLrzc;
    }
    
    public void setWorkLrzc(Double workLrzc) {
        this.workLrzc = workLrzc;
    }

    public Double getWorkTime() {
        return this.workTime;
    }
    
    public void setWorkTime(Double workTime) {
        this.workTime = workTime;
    }
   








}