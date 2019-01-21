package work.wb.pojo;
// default package



/**
 * AbstractWbYslr entity provides the base persistence definition of the WbYslr entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWbYslr  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String corpcode;
     private String corpname;
     private Integer online;
     private Double onlineZb;
     private Double avertime;
     private Integer cl;
     private Double clZb;
     private Double cc;
     private Double hs;
     private Double avevCl;
     private Integer aboveNum;
     private Double aboveZb;
     private Double worktimeZb;
     private String remark1;
     private String remark2;
     private String date;
     private Double ccl;
     private Double hsl;
     private Integer aboveTime;
     private Double aboveTimezb;
     private Double worktime;


    // Constructors

    /** default constructor */
    public AbstractWbYslr() {
    }

    
    /** full constructor */
    public AbstractWbYslr(String corpcode, String corpname, Integer online, Double onlineZb, Double avertime, Integer cl, Double clZb, Double cc, Double hs, Double avevCl, Integer aboveNum, Double aboveZb, Double worktimeZb, String remark1, String remark2, String date, Double ccl, Double hsl, Integer aboveTime, Double aboveTimezb, Double worktime) {
        this.corpcode = corpcode;
        this.corpname = corpname;
        this.online = online;
        this.onlineZb = onlineZb;
        this.avertime = avertime;
        this.cl = cl;
        this.clZb = clZb;
        this.cc = cc;
        this.hs = hs;
        this.avevCl = avevCl;
        this.aboveNum = aboveNum;
        this.aboveZb = aboveZb;
        this.worktimeZb = worktimeZb;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.date = date;
        this.ccl = ccl;
        this.hsl = hsl;
        this.aboveTime = aboveTime;
        this.aboveTimezb = aboveTimezb;
        this.worktime = worktime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorpcode() {
        return this.corpcode;
    }
    
    public void setCorpcode(String corpcode) {
        this.corpcode = corpcode;
    }

    public String getCorpname() {
        return this.corpname;
    }
    
    public void setCorpname(String corpname) {
        this.corpname = corpname;
    }

    public Integer getOnline() {
        return this.online;
    }
    
    public void setOnline(Integer online) {
        this.online = online;
    }

    public Double getOnlineZb() {
        return this.onlineZb;
    }
    
    public void setOnlineZb(Double onlineZb) {
        this.onlineZb = onlineZb;
    }

    public Double getAvertime() {
        return this.avertime;
    }
    
    public void setAvertime(Double avertime) {
        this.avertime = avertime;
    }

    public Integer getCl() {
        return this.cl;
    }
    
    public void setCl(Integer cl) {
        this.cl = cl;
    }

    public Double getClZb() {
        return this.clZb;
    }
    
    public void setClZb(Double clZb) {
        this.clZb = clZb;
    }

    public Double getCc() {
        return this.cc;
    }
    
    public void setCc(Double cc) {
        this.cc = cc;
    }

    public Double getHs() {
        return this.hs;
    }
    
    public void setHs(Double hs) {
        this.hs = hs;
    }

    public Double getAvevCl() {
        return this.avevCl;
    }
    
    public void setAvevCl(Double avevCl) {
        this.avevCl = avevCl;
    }

    public Integer getAboveNum() {
        return this.aboveNum;
    }
    
    public void setAboveNum(Integer aboveNum) {
        this.aboveNum = aboveNum;
    }

    public Double getAboveZb() {
        return this.aboveZb;
    }
    
    public void setAboveZb(Double aboveZb) {
        this.aboveZb = aboveZb;
    }

    public Double getWorktimeZb() {
        return this.worktimeZb;
    }
    
    public void setWorktimeZb(Double worktimeZb) {
        this.worktimeZb = worktimeZb;
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

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public Double getCcl() {
        return this.ccl;
    }
    
    public void setCcl(Double ccl) {
        this.ccl = ccl;
    }

    public Double getHsl() {
        return this.hsl;
    }
    
    public void setHsl(Double hsl) {
        this.hsl = hsl;
    }

    public Integer getAboveTime() {
        return this.aboveTime;
    }
    
    public void setAboveTime(Integer aboveTime) {
        this.aboveTime = aboveTime;
    }

    public Double getAboveTimezb() {
        return this.aboveTimezb;
    }
    
    public void setAboveTimezb(Double aboveTimezb) {
        this.aboveTimezb = aboveTimezb;
    }

    public Double getWorktime() {
        return this.worktime;
    }
    
    public void setWorktime(Double worktime) {
        this.worktime = worktime;
    }
   








}