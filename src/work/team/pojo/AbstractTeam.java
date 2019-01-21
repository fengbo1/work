package work.team.pojo;
// default package



/**
 * AbstractTeam entity provides the base persistence definition of the Team entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeam  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String time;
     private String chu;
     private String team;
     private Double cl;
     private Double clrmb;
     private Double clwh;
     private Double cljh;
     private Double clsh;
     private Double cljy;
     private Double clfxq;
     private Double rjcl;
     private Double rjclrmb;
     private Double rjclwh;
     private Double rjcljh;
     private Double rjclsh;
     private Double rjcljy;
     private Double rjclfxq;
     private Double ccl;
     private Double cclrmb;
     private Double cclwh;
     private Double ccljy;
     private Double xl;
     private Double xlrmb;
     private Double xlwh;
     private Double xljh;
     private Double xlsh;
     private Double xljy;
     private Double perccl891;
     private Double pertpl891;
     private Double percxl891;
     private Double perccl895;
     private Double pertpl895;
     private Double percxl895;
     private String remark1;
     private String remark2;
     private String remark3;


    // Constructors

    /** default constructor */
    public AbstractTeam() {
    }

    
    /** full constructor */
    public AbstractTeam(String time, String chu, String team, Double cl, Double clrmb, Double clwh, Double cljh, Double clsh, Double cljy, Double clfxq, Double rjcl, Double rjclrmb, Double rjclwh, Double rjcljh, Double rjclsh, Double rjcljy, Double rjclfxq, Double ccl, Double cclrmb, Double cclwh, Double ccljy, Double xl, Double xlrmb, Double xlwh, Double xljh, Double xlsh, Double xljy, Double perccl891, Double pertpl891, Double percxl891, Double perccl895, Double pertpl895, Double percxl895, String remark1, String remark2, String remark3) {
        this.time = time;
        this.chu = chu;
        this.team = team;
        this.cl = cl;
        this.clrmb = clrmb;
        this.clwh = clwh;
        this.cljh = cljh;
        this.clsh = clsh;
        this.cljy = cljy;
        this.clfxq = clfxq;
        this.rjcl = rjcl;
        this.rjclrmb = rjclrmb;
        this.rjclwh = rjclwh;
        this.rjcljh = rjcljh;
        this.rjclsh = rjclsh;
        this.rjcljy = rjcljy;
        this.rjclfxq = rjclfxq;
        this.ccl = ccl;
        this.cclrmb = cclrmb;
        this.cclwh = cclwh;
        this.ccljy = ccljy;
        this.xl = xl;
        this.xlrmb = xlrmb;
        this.xlwh = xlwh;
        this.xljh = xljh;
        this.xlsh = xlsh;
        this.xljy = xljy;
        this.perccl891 = perccl891;
        this.pertpl891 = pertpl891;
        this.percxl891 = percxl891;
        this.perccl895 = perccl895;
        this.pertpl895 = pertpl895;
        this.percxl895 = percxl895;
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

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getChu() {
        return this.chu;
    }
    
    public void setChu(String chu) {
        this.chu = chu;
    }

    public String getTeam() {
        return this.team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }

    public Double getCl() {
        return this.cl;
    }
    
    public void setCl(Double cl) {
        this.cl = cl;
    }

    public Double getClrmb() {
        return this.clrmb;
    }
    
    public void setClrmb(Double clrmb) {
        this.clrmb = clrmb;
    }

    public Double getClwh() {
        return this.clwh;
    }
    
    public void setClwh(Double clwh) {
        this.clwh = clwh;
    }

    public Double getCljh() {
        return this.cljh;
    }
    
    public void setCljh(Double cljh) {
        this.cljh = cljh;
    }

    public Double getClsh() {
        return this.clsh;
    }
    
    public void setClsh(Double clsh) {
        this.clsh = clsh;
    }

    public Double getCljy() {
        return this.cljy;
    }
    
    public void setCljy(Double cljy) {
        this.cljy = cljy;
    }

    public Double getClfxq() {
        return this.clfxq;
    }
    
    public void setClfxq(Double clfxq) {
        this.clfxq = clfxq;
    }

    public Double getRjcl() {
        return this.rjcl;
    }
    
    public void setRjcl(Double rjcl) {
        this.rjcl = rjcl;
    }

    public Double getRjclrmb() {
        return this.rjclrmb;
    }
    
    public void setRjclrmb(Double rjclrmb) {
        this.rjclrmb = rjclrmb;
    }

    public Double getRjclwh() {
        return this.rjclwh;
    }
    
    public void setRjclwh(Double rjclwh) {
        this.rjclwh = rjclwh;
    }

    public Double getRjcljh() {
        return this.rjcljh;
    }
    
    public void setRjcljh(Double rjcljh) {
        this.rjcljh = rjcljh;
    }

    public Double getRjclsh() {
        return this.rjclsh;
    }
    
    public void setRjclsh(Double rjclsh) {
        this.rjclsh = rjclsh;
    }

    public Double getRjcljy() {
        return this.rjcljy;
    }
    
    public void setRjcljy(Double rjcljy) {
        this.rjcljy = rjcljy;
    }

    public Double getRjclfxq() {
        return this.rjclfxq;
    }
    
    public void setRjclfxq(Double rjclfxq) {
        this.rjclfxq = rjclfxq;
    }

    public Double getCcl() {
        return this.ccl;
    }
    
    public void setCcl(Double ccl) {
        this.ccl = ccl;
    }

    public Double getCclrmb() {
        return this.cclrmb;
    }
    
    public void setCclrmb(Double cclrmb) {
        this.cclrmb = cclrmb;
    }

    public Double getCclwh() {
        return this.cclwh;
    }
    
    public void setCclwh(Double cclwh) {
        this.cclwh = cclwh;
    }

    public Double getCcljy() {
        return this.ccljy;
    }
    
    public void setCcljy(Double ccljy) {
        this.ccljy = ccljy;
    }

    public Double getXl() {
        return this.xl;
    }
    
    public void setXl(Double xl) {
        this.xl = xl;
    }

    public Double getXlrmb() {
        return this.xlrmb;
    }
    
    public void setXlrmb(Double xlrmb) {
        this.xlrmb = xlrmb;
    }

    public Double getXlwh() {
        return this.xlwh;
    }
    
    public void setXlwh(Double xlwh) {
        this.xlwh = xlwh;
    }

    public Double getXljh() {
        return this.xljh;
    }
    
    public void setXljh(Double xljh) {
        this.xljh = xljh;
    }

    public Double getXlsh() {
        return this.xlsh;
    }
    
    public void setXlsh(Double xlsh) {
        this.xlsh = xlsh;
    }

    public Double getXljy() {
        return this.xljy;
    }
    
    public void setXljy(Double xljy) {
        this.xljy = xljy;
    }

    public Double getPerccl891() {
        return this.perccl891;
    }
    
    public void setPerccl891(Double perccl891) {
        this.perccl891 = perccl891;
    }

    public Double getPertpl891() {
        return this.pertpl891;
    }
    
    public void setPertpl891(Double pertpl891) {
        this.pertpl891 = pertpl891;
    }

    public Double getPercxl891() {
        return this.percxl891;
    }
    
    public void setPercxl891(Double percxl891) {
        this.percxl891 = percxl891;
    }

    public Double getPerccl895() {
        return this.perccl895;
    }
    
    public void setPerccl895(Double perccl895) {
        this.perccl895 = perccl895;
    }

    public Double getPertpl895() {
        return this.pertpl895;
    }
    
    public void setPertpl895(Double pertpl895) {
        this.pertpl895 = pertpl895;
    }

    public Double getPercxl895() {
        return this.percxl895;
    }
    
    public void setPercxl895(Double percxl895) {
        this.percxl895 = percxl895;
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