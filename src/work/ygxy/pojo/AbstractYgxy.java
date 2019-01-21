package work.ygxy.pojo;
// default package



/**
 * AbstractYgxy entity provides the base persistence definition of the Ygxy entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYgxy  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String name;
     private String position;
     private String ftDlsc;
     private Double ftXxlv;
     private Integer ftYddh;
     private String ftPjydsc;
     private String ftPjshsc;
     private Integer ftHcdhs;
     private String ftPjhcsc;
     private String ftPjclsc;
     private Double ftPjclscd;
     private Integer ftSjl;
     private Integer ftFeiql;
     private Integer ftFangql;
     private Integer ftTdwzjl;
     private Integer ftTbjpl;
     private Integer ftGdjll;
     private Integer ftYjdfl;
     private Double ftYjdflv;
     private Integer feDrjsl;
     private String feYjpjclsc;
     private Double feYjpjclscd;
     private Integer feSjl;
     private Integer feFangql;
     private Integer feTbjpl;
     private Integer feGdjll;
     private Integer feYjdfl;
     private Double feYjdflv;
     private Integer steDrjsl;
     private String steEjpjclsc;
     private Double steEjpjclscd;
     private Integer steNbzjl;
     private Integer steFangql;
     private Integer steTpjpl;
     private Integer steGdjll;
     private Integer steEjdfl;
     private Double steEjdflv;
     private Integer steZsjl;
     private Double steZsjlv;
     private Double gzsc;
     private Double lxsc;
     private Double gdl;
     private Double zysc;
     private Double xyqqzsl;


    // Constructors

    /** default constructor */
    public AbstractYgxy() {
    }

    
    /** full constructor */
    public AbstractYgxy(String date, String name, String position, String ftDlsc, Double ftXxlv, Integer ftYddh, String ftPjydsc, String ftPjshsc, Integer ftHcdhs, String ftPjhcsc, String ftPjclsc, Double ftPjclscd, Integer ftSjl, Integer ftFeiql, Integer ftFangql, Integer ftTdwzjl, Integer ftTbjpl, Integer ftGdjll, Integer ftYjdfl, Double ftYjdflv, Integer feDrjsl, String feYjpjclsc, Double feYjpjclscd, Integer feSjl, Integer feFangql, Integer feTbjpl, Integer feGdjll, Integer feYjdfl, Double feYjdflv, Integer steDrjsl, String steEjpjclsc, Double steEjpjclscd, Integer steNbzjl, Integer steFangql, Integer steTpjpl, Integer steGdjll, Integer steEjdfl, Double steEjdflv, Integer steZsjl, Double steZsjlv, Double gzsc, Double lxsc, Double gdl, Double zysc, Double xyqqzsl) {
        this.date = date;
        this.name = name;
        this.position = position;
        this.ftDlsc = ftDlsc;
        this.ftXxlv = ftXxlv;
        this.ftYddh = ftYddh;
        this.ftPjydsc = ftPjydsc;
        this.ftPjshsc = ftPjshsc;
        this.ftHcdhs = ftHcdhs;
        this.ftPjhcsc = ftPjhcsc;
        this.ftPjclsc = ftPjclsc;
        this.ftPjclscd = ftPjclscd;
        this.ftSjl = ftSjl;
        this.ftFeiql = ftFeiql;
        this.ftFangql = ftFangql;
        this.ftTdwzjl = ftTdwzjl;
        this.ftTbjpl = ftTbjpl;
        this.ftGdjll = ftGdjll;
        this.ftYjdfl = ftYjdfl;
        this.ftYjdflv = ftYjdflv;
        this.feDrjsl = feDrjsl;
        this.feYjpjclsc = feYjpjclsc;
        this.feYjpjclscd = feYjpjclscd;
        this.feSjl = feSjl;
        this.feFangql = feFangql;
        this.feTbjpl = feTbjpl;
        this.feGdjll = feGdjll;
        this.feYjdfl = feYjdfl;
        this.feYjdflv = feYjdflv;
        this.steDrjsl = steDrjsl;
        this.steEjpjclsc = steEjpjclsc;
        this.steEjpjclscd = steEjpjclscd;
        this.steNbzjl = steNbzjl;
        this.steFangql = steFangql;
        this.steTpjpl = steTpjpl;
        this.steGdjll = steGdjll;
        this.steEjdfl = steEjdfl;
        this.steEjdflv = steEjdflv;
        this.steZsjl = steZsjl;
        this.steZsjlv = steZsjlv;
        this.gzsc = gzsc;
        this.lxsc = lxsc;
        this.gdl = gdl;
        this.zysc = zysc;
        this.xyqqzsl = xyqqzsl;
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

    public String getFtDlsc() {
        return this.ftDlsc;
    }
    
    public void setFtDlsc(String ftDlsc) {
        this.ftDlsc = ftDlsc;
    }

    public Double getFtXxlv() {
        return this.ftXxlv;
    }
    
    public void setFtXxlv(Double ftXxlv) {
        this.ftXxlv = ftXxlv;
    }

    public Integer getFtYddh() {
        return this.ftYddh;
    }
    
    public void setFtYddh(Integer ftYddh) {
        this.ftYddh = ftYddh;
    }

    public String getFtPjydsc() {
        return this.ftPjydsc;
    }
    
    public void setFtPjydsc(String ftPjydsc) {
        this.ftPjydsc = ftPjydsc;
    }

    public String getFtPjshsc() {
        return this.ftPjshsc;
    }
    
    public void setFtPjshsc(String ftPjshsc) {
        this.ftPjshsc = ftPjshsc;
    }

    public Integer getFtHcdhs() {
        return this.ftHcdhs;
    }
    
    public void setFtHcdhs(Integer ftHcdhs) {
        this.ftHcdhs = ftHcdhs;
    }

    public String getFtPjhcsc() {
        return this.ftPjhcsc;
    }
    
    public void setFtPjhcsc(String ftPjhcsc) {
        this.ftPjhcsc = ftPjhcsc;
    }

    public String getFtPjclsc() {
        return this.ftPjclsc;
    }
    
    public void setFtPjclsc(String ftPjclsc) {
        this.ftPjclsc = ftPjclsc;
    }

    public Double getFtPjclscd() {
        return this.ftPjclscd;
    }
    
    public void setFtPjclscd(Double ftPjclscd) {
        this.ftPjclscd = ftPjclscd;
    }

    public Integer getFtSjl() {
        return this.ftSjl;
    }
    
    public void setFtSjl(Integer ftSjl) {
        this.ftSjl = ftSjl;
    }

    public Integer getFtFeiql() {
        return this.ftFeiql;
    }
    
    public void setFtFeiql(Integer ftFeiql) {
        this.ftFeiql = ftFeiql;
    }

    public Integer getFtFangql() {
        return this.ftFangql;
    }
    
    public void setFtFangql(Integer ftFangql) {
        this.ftFangql = ftFangql;
    }

    public Integer getFtTdwzjl() {
        return this.ftTdwzjl;
    }
    
    public void setFtTdwzjl(Integer ftTdwzjl) {
        this.ftTdwzjl = ftTdwzjl;
    }

    public Integer getFtTbjpl() {
        return this.ftTbjpl;
    }
    
    public void setFtTbjpl(Integer ftTbjpl) {
        this.ftTbjpl = ftTbjpl;
    }

    public Integer getFtGdjll() {
        return this.ftGdjll;
    }
    
    public void setFtGdjll(Integer ftGdjll) {
        this.ftGdjll = ftGdjll;
    }

    public Integer getFtYjdfl() {
        return this.ftYjdfl;
    }
    
    public void setFtYjdfl(Integer ftYjdfl) {
        this.ftYjdfl = ftYjdfl;
    }

    public Double getFtYjdflv() {
        return this.ftYjdflv;
    }
    
    public void setFtYjdflv(Double ftYjdflv) {
        this.ftYjdflv = ftYjdflv;
    }

    public Integer getFeDrjsl() {
        return this.feDrjsl;
    }
    
    public void setFeDrjsl(Integer feDrjsl) {
        this.feDrjsl = feDrjsl;
    }

    public String getFeYjpjclsc() {
        return this.feYjpjclsc;
    }
    
    public void setFeYjpjclsc(String feYjpjclsc) {
        this.feYjpjclsc = feYjpjclsc;
    }

    public Double getFeYjpjclscd() {
        return this.feYjpjclscd;
    }
    
    public void setFeYjpjclscd(Double feYjpjclscd) {
        this.feYjpjclscd = feYjpjclscd;
    }

    public Integer getFeSjl() {
        return this.feSjl;
    }
    
    public void setFeSjl(Integer feSjl) {
        this.feSjl = feSjl;
    }

    public Integer getFeFangql() {
        return this.feFangql;
    }
    
    public void setFeFangql(Integer feFangql) {
        this.feFangql = feFangql;
    }

    public Integer getFeTbjpl() {
        return this.feTbjpl;
    }
    
    public void setFeTbjpl(Integer feTbjpl) {
        this.feTbjpl = feTbjpl;
    }

    public Integer getFeGdjll() {
        return this.feGdjll;
    }
    
    public void setFeGdjll(Integer feGdjll) {
        this.feGdjll = feGdjll;
    }

    public Integer getFeYjdfl() {
        return this.feYjdfl;
    }
    
    public void setFeYjdfl(Integer feYjdfl) {
        this.feYjdfl = feYjdfl;
    }

    public Double getFeYjdflv() {
        return this.feYjdflv;
    }
    
    public void setFeYjdflv(Double feYjdflv) {
        this.feYjdflv = feYjdflv;
    }

    public Integer getSteDrjsl() {
        return this.steDrjsl;
    }
    
    public void setSteDrjsl(Integer steDrjsl) {
        this.steDrjsl = steDrjsl;
    }

    public String getSteEjpjclsc() {
        return this.steEjpjclsc;
    }
    
    public void setSteEjpjclsc(String steEjpjclsc) {
        this.steEjpjclsc = steEjpjclsc;
    }

    public Double getSteEjpjclscd() {
        return this.steEjpjclscd;
    }
    
    public void setSteEjpjclscd(Double steEjpjclscd) {
        this.steEjpjclscd = steEjpjclscd;
    }

    public Integer getSteNbzjl() {
        return this.steNbzjl;
    }
    
    public void setSteNbzjl(Integer steNbzjl) {
        this.steNbzjl = steNbzjl;
    }

    public Integer getSteFangql() {
        return this.steFangql;
    }
    
    public void setSteFangql(Integer steFangql) {
        this.steFangql = steFangql;
    }

    public Integer getSteTpjpl() {
        return this.steTpjpl;
    }
    
    public void setSteTpjpl(Integer steTpjpl) {
        this.steTpjpl = steTpjpl;
    }

    public Integer getSteGdjll() {
        return this.steGdjll;
    }
    
    public void setSteGdjll(Integer steGdjll) {
        this.steGdjll = steGdjll;
    }

    public Integer getSteEjdfl() {
        return this.steEjdfl;
    }
    
    public void setSteEjdfl(Integer steEjdfl) {
        this.steEjdfl = steEjdfl;
    }

    public Double getSteEjdflv() {
        return this.steEjdflv;
    }
    
    public void setSteEjdflv(Double steEjdflv) {
        this.steEjdflv = steEjdflv;
    }

    public Integer getSteZsjl() {
        return this.steZsjl;
    }
    
    public void setSteZsjl(Integer steZsjl) {
        this.steZsjl = steZsjl;
    }

    public Double getSteZsjlv() {
        return this.steZsjlv;
    }
    
    public void setSteZsjlv(Double steZsjlv) {
        this.steZsjlv = steZsjlv;
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

    public Double getGdl() {
        return this.gdl;
    }
    
    public void setGdl(Double gdl) {
        this.gdl = gdl;
    }

    public Double getZysc() {
        return this.zysc;
    }
    
    public void setZysc(Double zysc) {
        this.zysc = zysc;
    }

    public Double getXyqqzsl() {
        return this.xyqqzsl;
    }
    
    public void setXyqqzsl(Double xyqqzsl) {
        this.xyqqzsl = xyqqzsl;
    }
   








}