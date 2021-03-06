package work.wb.pojo;
// default package



/**
 * AbstractWbLrzc entity provides the base persistence definition of the WbLrzc entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWbLrzc  implements java.io.Serializable {


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
     private Double ccl;
     private Double hs;
     private Double hsl;
     private Double avevCl;
     private String date;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractWbLrzc() {
    }

    
    /** full constructor */
    public AbstractWbLrzc(String corpcode, String corpname, Integer online, Double onlineZb, Double avertime, Integer cl, Double clZb, Double cc, Double ccl, Double hs, Double hsl, Double avevCl, String date, String remark1, String remark2) {
        this.corpcode = corpcode;
        this.corpname = corpname;
        this.online = online;
        this.onlineZb = onlineZb;
        this.avertime = avertime;
        this.cl = cl;
        this.clZb = clZb;
        this.cc = cc;
        this.ccl = ccl;
        this.hs = hs;
        this.hsl = hsl;
        this.avevCl = avevCl;
        this.date = date;
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

    public Double getCcl() {
        return this.ccl;
    }
    
    public void setCcl(Double ccl) {
        this.ccl = ccl;
    }

    public Double getHs() {
        return this.hs;
    }
    
    public void setHs(Double hs) {
        this.hs = hs;
    }

    public Double getHsl() {
        return this.hsl;
    }
    
    public void setHsl(Double hsl) {
        this.hsl = hsl;
    }

    public Double getAvevCl() {
        return this.avevCl;
    }
    
    public void setAvevCl(Double avevCl) {
        this.avevCl = avevCl;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
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