package work.ygxy.pojo;
// default package



/**
 * AbstractYgxyQuarter entity provides the base persistence definition of the YgxyQuarter entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYgxyQuarter  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer year;
     private Integer quarter;
     private String name;
     private String position;
     private Double gzsc;
     private Double lxsc;
     private Double zysc;
     private Double gdl;
     private Double xyqqzsl;
     private Double ftclzsc;
     private Integer ftyddh;
     private Double ftpjclsc;
     private Double feclzsc;
     private Integer fejsl;
     private Double fepjclsc;
     private Double steclzsc;
     private Integer stejsl;
     private Double stepjclsc;
     private Double zjzf;
     private Integer zjts;
     private Double zjdf;


    // Constructors

    /** default constructor */
    public AbstractYgxyQuarter() {
    }

    
    /** full constructor */
    public AbstractYgxyQuarter(Integer year, Integer quarter, String name, String position, Double gzsc, Double lxsc, Double zysc, Double gdl, Double xyqqzsl, Double ftclzsc, Integer ftyddh, Double ftpjclsc, Double feclzsc, Integer fejsl, Double fepjclsc, Double steclzsc, Integer stejsl, Double stepjclsc, Double zjzf, Integer zjts, Double zjdf) {
        this.year = year;
        this.quarter = quarter;
        this.name = name;
        this.position = position;
        this.gzsc = gzsc;
        this.lxsc = lxsc;
        this.zysc = zysc;
        this.gdl = gdl;
        this.xyqqzsl = xyqqzsl;
        this.ftclzsc = ftclzsc;
        this.ftyddh = ftyddh;
        this.ftpjclsc = ftpjclsc;
        this.feclzsc = feclzsc;
        this.fejsl = fejsl;
        this.fepjclsc = fepjclsc;
        this.steclzsc = steclzsc;
        this.stejsl = stejsl;
        this.stepjclsc = stepjclsc;
        this.zjzf = zjzf;
        this.zjts = zjts;
        this.zjdf = zjdf;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return this.quarter;
    }
    
    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public Double getGzsc() {
        return this.gzsc;
    }
    
    public void setGzsc(Double gzsc) {
        this.gzsc = gzsc;
    }

    public Double getLxsc() {
        return this.lxsc;
    }
    
    public void setLxsc(Double lxsc) {
        this.lxsc = lxsc;
    }

    public Double getZysc() {
        return this.zysc;
    }
    
    public void setZysc(Double zysc) {
        this.zysc = zysc;
    }

    public Double getGdl() {
        return this.gdl;
    }
    
    public void setGdl(Double gdl) {
        this.gdl = gdl;
    }

    public Double getXyqqzsl() {
        return this.xyqqzsl;
    }
    
    public void setXyqqzsl(Double xyqqzsl) {
        this.xyqqzsl = xyqqzsl;
    }

    public Double getFtclzsc() {
        return this.ftclzsc;
    }
    
    public void setFtclzsc(Double ftclzsc) {
        this.ftclzsc = ftclzsc;
    }

    public Integer getFtyddh() {
        return this.ftyddh;
    }
    
    public void setFtyddh(Integer ftyddh) {
        this.ftyddh = ftyddh;
    }

    public Double getFtpjclsc() {
        return this.ftpjclsc;
    }
    
    public void setFtpjclsc(Double ftpjclsc) {
        this.ftpjclsc = ftpjclsc;
    }

    public Double getFeclzsc() {
        return this.feclzsc;
    }
    
    public void setFeclzsc(Double feclzsc) {
        this.feclzsc = feclzsc;
    }

    public Integer getFejsl() {
        return this.fejsl;
    }
    
    public void setFejsl(Integer fejsl) {
        this.fejsl = fejsl;
    }

    public Double getFepjclsc() {
        return this.fepjclsc;
    }
    
    public void setFepjclsc(Double fepjclsc) {
        this.fepjclsc = fepjclsc;
    }

    public Double getSteclzsc() {
        return this.steclzsc;
    }
    
    public void setSteclzsc(Double steclzsc) {
        this.steclzsc = steclzsc;
    }

    public Integer getStejsl() {
        return this.stejsl;
    }
    
    public void setStejsl(Integer stejsl) {
        this.stejsl = stejsl;
    }

    public Double getStepjclsc() {
        return this.stepjclsc;
    }
    
    public void setStepjclsc(Double stepjclsc) {
        this.stepjclsc = stepjclsc;
    }

    public Double getZjzf() {
        return this.zjzf;
    }
    
    public void setZjzf(Double zjzf) {
        this.zjzf = zjzf;
    }

    public Integer getZjts() {
        return this.zjts;
    }
    
    public void setZjts(Integer zjts) {
        this.zjts = zjts;
    }

    public Double getZjdf() {
        return this.zjdf;
    }
    
    public void setZjdf(Double zjdf) {
        this.zjdf = zjdf;
    }
   








}