package work.hn.pojo;
// default package



/**
 * AbstractHnWaihui entity provides the base persistence definition of the HnWaihui entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHnWaihui  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String no;
     private String name;
     private Integer zx;
     private Integer xz;
     private Integer zycs;
     private Integer zyfs;
     private Integer lrxg;
     private Integer lrsq;
     private Integer jhxg;
     private Integer jhsq;
     private Integer pjcs;
     private Integer pjfs;
     private Integer sbyy;
     private Integer dgcs;
     private Integer dgfs;
     private Integer hrcs;
     private Integer hrfs;
     private Double xlzycs;
     private Double xlzyfs;
     private Double xllrxg;
     private Double xllrsq;
     private Double xljhxg;
     private Double xljhsq;
     private Double xlpjcs;
     private Double xlpjfs;
     private Double xlsbyy;
     private Double xldgcs;
     private Double xldgfs;
     private Double xlhrcs;
     private Double xlhrfs;
     private Integer lrcc;
     private Double lclv;
     private Integer jhcc;
     private Double jclv;
     private Integer tp;
     private Double tplv;
     private Integer cx;
     private Double cxlv;
     private Double zhcl;
     private Integer ywl;
     private Double sumxl;
     private Double ccl;
     private Double percl;
     private Integer bh;
     private Double bhl;


    // Constructors

    /** default constructor */
    public AbstractHnWaihui() {
    }

    
    /** full constructor */
    public AbstractHnWaihui(String date, String no, String name, Integer zx, Integer xz, Integer zycs, Integer zyfs, Integer lrxg, Integer lrsq, Integer jhxg, Integer jhsq, Integer pjcs, Integer pjfs, Integer sbyy, Integer dgcs, Integer dgfs, Integer hrcs, Integer hrfs, Double xlzycs, Double xlzyfs, Double xllrxg, Double xllrsq, Double xljhxg, Double xljhsq, Double xlpjcs, Double xlpjfs, Double xlsbyy, Double xldgcs, Double xldgfs, Double xlhrcs, Double xlhrfs, Integer lrcc, Double lclv, Integer jhcc, Double jclv, Integer tp, Double tplv, Integer cx, Double cxlv, Double zhcl, Integer ywl, Double sumxl, Double ccl, Double percl, Integer bh, Double bhl) {
        this.date = date;
        this.no = no;
        this.name = name;
        this.zx = zx;
        this.xz = xz;
        this.zycs = zycs;
        this.zyfs = zyfs;
        this.lrxg = lrxg;
        this.lrsq = lrsq;
        this.jhxg = jhxg;
        this.jhsq = jhsq;
        this.pjcs = pjcs;
        this.pjfs = pjfs;
        this.sbyy = sbyy;
        this.dgcs = dgcs;
        this.dgfs = dgfs;
        this.hrcs = hrcs;
        this.hrfs = hrfs;
        this.xlzycs = xlzycs;
        this.xlzyfs = xlzyfs;
        this.xllrxg = xllrxg;
        this.xllrsq = xllrsq;
        this.xljhxg = xljhxg;
        this.xljhsq = xljhsq;
        this.xlpjcs = xlpjcs;
        this.xlpjfs = xlpjfs;
        this.xlsbyy = xlsbyy;
        this.xldgcs = xldgcs;
        this.xldgfs = xldgfs;
        this.xlhrcs = xlhrcs;
        this.xlhrfs = xlhrfs;
        this.lrcc = lrcc;
        this.lclv = lclv;
        this.jhcc = jhcc;
        this.jclv = jclv;
        this.tp = tp;
        this.tplv = tplv;
        this.cx = cx;
        this.cxlv = cxlv;
        this.zhcl = zhcl;
        this.ywl = ywl;
        this.sumxl = sumxl;
        this.ccl = ccl;
        this.percl = percl;
        this.bh = bh;
        this.bhl = bhl;
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

    public Integer getZx() {
        return this.zx;
    }
    
    public void setZx(Integer zx) {
        this.zx = zx;
    }

    public Integer getXz() {
        return this.xz;
    }
    
    public void setXz(Integer xz) {
        this.xz = xz;
    }

    public Integer getZycs() {
        return this.zycs;
    }
    
    public void setZycs(Integer zycs) {
        this.zycs = zycs;
    }

    public Integer getZyfs() {
        return this.zyfs;
    }
    
    public void setZyfs(Integer zyfs) {
        this.zyfs = zyfs;
    }

    public Integer getLrxg() {
        return this.lrxg;
    }
    
    public void setLrxg(Integer lrxg) {
        this.lrxg = lrxg;
    }

    public Integer getLrsq() {
        return this.lrsq;
    }
    
    public void setLrsq(Integer lrsq) {
        this.lrsq = lrsq;
    }

    public Integer getJhxg() {
        return this.jhxg;
    }
    
    public void setJhxg(Integer jhxg) {
        this.jhxg = jhxg;
    }

    public Integer getJhsq() {
        return this.jhsq;
    }
    
    public void setJhsq(Integer jhsq) {
        this.jhsq = jhsq;
    }

    public Integer getPjcs() {
        return this.pjcs;
    }
    
    public void setPjcs(Integer pjcs) {
        this.pjcs = pjcs;
    }

    public Integer getPjfs() {
        return this.pjfs;
    }
    
    public void setPjfs(Integer pjfs) {
        this.pjfs = pjfs;
    }

    public Integer getSbyy() {
        return this.sbyy;
    }
    
    public void setSbyy(Integer sbyy) {
        this.sbyy = sbyy;
    }

    public Integer getDgcs() {
        return this.dgcs;
    }
    
    public void setDgcs(Integer dgcs) {
        this.dgcs = dgcs;
    }

    public Integer getDgfs() {
        return this.dgfs;
    }
    
    public void setDgfs(Integer dgfs) {
        this.dgfs = dgfs;
    }

    public Integer getHrcs() {
        return this.hrcs;
    }
    
    public void setHrcs(Integer hrcs) {
        this.hrcs = hrcs;
    }

    public Integer getHrfs() {
        return this.hrfs;
    }
    
    public void setHrfs(Integer hrfs) {
        this.hrfs = hrfs;
    }

    public Double getXlzycs() {
        return this.xlzycs;
    }
    
    public void setXlzycs(Double xlzycs) {
        this.xlzycs = xlzycs;
    }

    public Double getXlzyfs() {
        return this.xlzyfs;
    }
    
    public void setXlzyfs(Double xlzyfs) {
        this.xlzyfs = xlzyfs;
    }

    public Double getXllrxg() {
        return this.xllrxg;
    }
    
    public void setXllrxg(Double xllrxg) {
        this.xllrxg = xllrxg;
    }

    public Double getXllrsq() {
        return this.xllrsq;
    }
    
    public void setXllrsq(Double xllrsq) {
        this.xllrsq = xllrsq;
    }

    public Double getXljhxg() {
        return this.xljhxg;
    }
    
    public void setXljhxg(Double xljhxg) {
        this.xljhxg = xljhxg;
    }

    public Double getXljhsq() {
        return this.xljhsq;
    }
    
    public void setXljhsq(Double xljhsq) {
        this.xljhsq = xljhsq;
    }

    public Double getXlpjcs() {
        return this.xlpjcs;
    }
    
    public void setXlpjcs(Double xlpjcs) {
        this.xlpjcs = xlpjcs;
    }

    public Double getXlpjfs() {
        return this.xlpjfs;
    }
    
    public void setXlpjfs(Double xlpjfs) {
        this.xlpjfs = xlpjfs;
    }

    public Double getXlsbyy() {
        return this.xlsbyy;
    }
    
    public void setXlsbyy(Double xlsbyy) {
        this.xlsbyy = xlsbyy;
    }

    public Double getXldgcs() {
        return this.xldgcs;
    }
    
    public void setXldgcs(Double xldgcs) {
        this.xldgcs = xldgcs;
    }

    public Double getXldgfs() {
        return this.xldgfs;
    }
    
    public void setXldgfs(Double xldgfs) {
        this.xldgfs = xldgfs;
    }

    public Double getXlhrcs() {
        return this.xlhrcs;
    }
    
    public void setXlhrcs(Double xlhrcs) {
        this.xlhrcs = xlhrcs;
    }

    public Double getXlhrfs() {
        return this.xlhrfs;
    }
    
    public void setXlhrfs(Double xlhrfs) {
        this.xlhrfs = xlhrfs;
    }

    public Integer getLrcc() {
        return this.lrcc;
    }
    
    public void setLrcc(Integer lrcc) {
        this.lrcc = lrcc;
    }

    public Double getLclv() {
        return this.lclv;
    }
    
    public void setLclv(Double lclv) {
        this.lclv = lclv;
    }

    public Integer getJhcc() {
        return this.jhcc;
    }
    
    public void setJhcc(Integer jhcc) {
        this.jhcc = jhcc;
    }

    public Double getJclv() {
        return this.jclv;
    }
    
    public void setJclv(Double jclv) {
        this.jclv = jclv;
    }

    public Integer getTp() {
        return this.tp;
    }
    
    public void setTp(Integer tp) {
        this.tp = tp;
    }

    public Double getTplv() {
        return this.tplv;
    }
    
    public void setTplv(Double tplv) {
        this.tplv = tplv;
    }

    public Integer getCx() {
        return this.cx;
    }
    
    public void setCx(Integer cx) {
        this.cx = cx;
    }

    public Double getCxlv() {
        return this.cxlv;
    }
    
    public void setCxlv(Double cxlv) {
        this.cxlv = cxlv;
    }

    public Double getZhcl() {
        return this.zhcl;
    }
    
    public void setZhcl(Double zhcl) {
        this.zhcl = zhcl;
    }

    public Integer getYwl() {
        return this.ywl;
    }
    
    public void setYwl(Integer ywl) {
        this.ywl = ywl;
    }

    public Double getSumxl() {
        return this.sumxl;
    }
    
    public void setSumxl(Double sumxl) {
        this.sumxl = sumxl;
    }

    public Double getCcl() {
        return this.ccl;
    }
    
    public void setCcl(Double ccl) {
        this.ccl = ccl;
    }

    public Double getPercl() {
        return this.percl;
    }
    
    public void setPercl(Double percl) {
        this.percl = percl;
    }

    public Integer getBh() {
        return this.bh;
    }
    
    public void setBh(Integer bh) {
        this.bh = bh;
    }

    public Double getBhl() {
        return this.bhl;
    }
    
    public void setBhl(Double bhl) {
        this.bhl = bhl;
    }
   








}