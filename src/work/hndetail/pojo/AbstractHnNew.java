package work.hndetail.pojo;
// default package



/**
 * AbstractHnNew entity provides the base persistence definition of the HnNew entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHnNew  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String no;
     private String name;
     private Integer zx;
     private Integer xz;
     private Integer sx;
     private String pos;
     private Double cl;
     private Double clrmb;
     private Double clwh;
     private Double cljh;
     private Double clsh;
     private Double cljy;
     private Double clfxq;
     private Double ccl;
     private Double cclrmbFz;
     private Double cclrmbFm;
     private Double cclrmb;
     private Double cclwhFz;
     private Double cclwhFm;
     private Double cclwh;
     private Double ccljhFz;
     private Double ccljhFm;
     private Double ccljh;
     private Double cclshFz;
     private Double cclshFm;
     private Double cclsh;
     private Double ccljyFz;
     private Double ccljyFm;
     private Double ccljy;
     private Double xl;
     private Double xlrmbFz;
     private Double xlrmbFm;
     private Double xlrmb;
     private Double xlwhFz;
     private Double xlwhFm;
     private Double xlwh;
     private Double xljhFz;
     private Double xljhFm;
     private Double xljh;
     private Double xlshFz;
     private Double xlshFm;
     private Double xlsh;
     private Double xljyFz;
     private Double xljyFm;
     private Double xljy;
     private Double tglsh;
     private Integer sxrmb;
     private Integer sxwh;
     private Integer sxjh;
     private Integer sxsh;
     private Integer sxjy;
     private Integer sxfxq;
     private Double rjcl;
     private Double rjccl;
     private Double rjxl;
     private Integer ljsx;


    // Constructors

    /** default constructor */
    public AbstractHnNew() {
    }

    
    /** full constructor */
    public AbstractHnNew(String date, String no, String name, Integer zx, Integer xz, Integer sx, String pos, Double cl, Double clrmb, Double clwh, Double cljh, Double clsh, Double cljy, Double clfxq, Double ccl, Double cclrmbFz, Double cclrmbFm, Double cclrmb, Double cclwhFz, Double cclwhFm, Double cclwh, Double ccljhFz, Double ccljhFm, Double ccljh, Double cclshFz, Double cclshFm, Double cclsh, Double ccljyFz, Double ccljyFm, Double ccljy, Double xl, Double xlrmbFz, Double xlrmbFm, Double xlrmb, Double xlwhFz, Double xlwhFm, Double xlwh, Double xljhFz, Double xljhFm, Double xljh, Double xlshFz, Double xlshFm, Double xlsh, Double xljyFz, Double xljyFm, Double xljy, Double tglsh, Integer sxrmb, Integer sxwh, Integer sxjh, Integer sxsh, Integer sxjy, Integer sxfxq, Double rjcl, Double rjccl, Double rjxl, Integer ljsx) {
        this.date = date;
        this.no = no;
        this.name = name;
        this.zx = zx;
        this.xz = xz;
        this.sx = sx;
        this.pos = pos;
        this.cl = cl;
        this.clrmb = clrmb;
        this.clwh = clwh;
        this.cljh = cljh;
        this.clsh = clsh;
        this.cljy = cljy;
        this.clfxq = clfxq;
        this.ccl = ccl;
        this.cclrmbFz = cclrmbFz;
        this.cclrmbFm = cclrmbFm;
        this.cclrmb = cclrmb;
        this.cclwhFz = cclwhFz;
        this.cclwhFm = cclwhFm;
        this.cclwh = cclwh;
        this.ccljhFz = ccljhFz;
        this.ccljhFm = ccljhFm;
        this.ccljh = ccljh;
        this.cclshFz = cclshFz;
        this.cclshFm = cclshFm;
        this.cclsh = cclsh;
        this.ccljyFz = ccljyFz;
        this.ccljyFm = ccljyFm;
        this.ccljy = ccljy;
        this.xl = xl;
        this.xlrmbFz = xlrmbFz;
        this.xlrmbFm = xlrmbFm;
        this.xlrmb = xlrmb;
        this.xlwhFz = xlwhFz;
        this.xlwhFm = xlwhFm;
        this.xlwh = xlwh;
        this.xljhFz = xljhFz;
        this.xljhFm = xljhFm;
        this.xljh = xljh;
        this.xlshFz = xlshFz;
        this.xlshFm = xlshFm;
        this.xlsh = xlsh;
        this.xljyFz = xljyFz;
        this.xljyFm = xljyFm;
        this.xljy = xljy;
        this.tglsh = tglsh;
        this.sxrmb = sxrmb;
        this.sxwh = sxwh;
        this.sxjh = sxjh;
        this.sxsh = sxsh;
        this.sxjy = sxjy;
        this.sxfxq = sxfxq;
        this.rjcl = rjcl;
        this.rjccl = rjccl;
        this.rjxl = rjxl;
        this.ljsx = ljsx;
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

    public Integer getSx() {
        return this.sx;
    }
    
    public void setSx(Integer sx) {
        this.sx = sx;
    }

    public String getPos() {
        return this.pos;
    }
    
    public void setPos(String pos) {
        this.pos = pos;
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

    public Double getCcl() {
        return this.ccl;
    }
    
    public void setCcl(Double ccl) {
        this.ccl = ccl;
    }

    public Double getCclrmbFz() {
        return this.cclrmbFz;
    }
    
    public void setCclrmbFz(Double cclrmbFz) {
        this.cclrmbFz = cclrmbFz;
    }

    public Double getCclrmbFm() {
        return this.cclrmbFm;
    }
    
    public void setCclrmbFm(Double cclrmbFm) {
        this.cclrmbFm = cclrmbFm;
    }

    public Double getCclrmb() {
        return this.cclrmb;
    }
    
    public void setCclrmb(Double cclrmb) {
        this.cclrmb = cclrmb;
    }

    public Double getCclwhFz() {
        return this.cclwhFz;
    }
    
    public void setCclwhFz(Double cclwhFz) {
        this.cclwhFz = cclwhFz;
    }

    public Double getCclwhFm() {
        return this.cclwhFm;
    }
    
    public void setCclwhFm(Double cclwhFm) {
        this.cclwhFm = cclwhFm;
    }

    public Double getCclwh() {
        return this.cclwh;
    }
    
    public void setCclwh(Double cclwh) {
        this.cclwh = cclwh;
    }

    public Double getCcljhFz() {
        return this.ccljhFz;
    }
    
    public void setCcljhFz(Double ccljhFz) {
        this.ccljhFz = ccljhFz;
    }

    public Double getCcljhFm() {
        return this.ccljhFm;
    }
    
    public void setCcljhFm(Double ccljhFm) {
        this.ccljhFm = ccljhFm;
    }

    public Double getCcljh() {
        return this.ccljh;
    }
    
    public void setCcljh(Double ccljh) {
        this.ccljh = ccljh;
    }

    public Double getCclshFz() {
        return this.cclshFz;
    }
    
    public void setCclshFz(Double cclshFz) {
        this.cclshFz = cclshFz;
    }

    public Double getCclshFm() {
        return this.cclshFm;
    }
    
    public void setCclshFm(Double cclshFm) {
        this.cclshFm = cclshFm;
    }

    public Double getCclsh() {
        return this.cclsh;
    }
    
    public void setCclsh(Double cclsh) {
        this.cclsh = cclsh;
    }

    public Double getCcljyFz() {
        return this.ccljyFz;
    }
    
    public void setCcljyFz(Double ccljyFz) {
        this.ccljyFz = ccljyFz;
    }

    public Double getCcljyFm() {
        return this.ccljyFm;
    }
    
    public void setCcljyFm(Double ccljyFm) {
        this.ccljyFm = ccljyFm;
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

    public Double getXlrmbFz() {
        return this.xlrmbFz;
    }
    
    public void setXlrmbFz(Double xlrmbFz) {
        this.xlrmbFz = xlrmbFz;
    }

    public Double getXlrmbFm() {
        return this.xlrmbFm;
    }
    
    public void setXlrmbFm(Double xlrmbFm) {
        this.xlrmbFm = xlrmbFm;
    }

    public Double getXlrmb() {
        return this.xlrmb;
    }
    
    public void setXlrmb(Double xlrmb) {
        this.xlrmb = xlrmb;
    }

    public Double getXlwhFz() {
        return this.xlwhFz;
    }
    
    public void setXlwhFz(Double xlwhFz) {
        this.xlwhFz = xlwhFz;
    }

    public Double getXlwhFm() {
        return this.xlwhFm;
    }
    
    public void setXlwhFm(Double xlwhFm) {
        this.xlwhFm = xlwhFm;
    }

    public Double getXlwh() {
        return this.xlwh;
    }
    
    public void setXlwh(Double xlwh) {
        this.xlwh = xlwh;
    }

    public Double getXljhFz() {
        return this.xljhFz;
    }
    
    public void setXljhFz(Double xljhFz) {
        this.xljhFz = xljhFz;
    }

    public Double getXljhFm() {
        return this.xljhFm;
    }
    
    public void setXljhFm(Double xljhFm) {
        this.xljhFm = xljhFm;
    }

    public Double getXljh() {
        return this.xljh;
    }
    
    public void setXljh(Double xljh) {
        this.xljh = xljh;
    }

    public Double getXlshFz() {
        return this.xlshFz;
    }
    
    public void setXlshFz(Double xlshFz) {
        this.xlshFz = xlshFz;
    }

    public Double getXlshFm() {
        return this.xlshFm;
    }
    
    public void setXlshFm(Double xlshFm) {
        this.xlshFm = xlshFm;
    }

    public Double getXlsh() {
        return this.xlsh;
    }
    
    public void setXlsh(Double xlsh) {
        this.xlsh = xlsh;
    }

    public Double getXljyFz() {
        return this.xljyFz;
    }
    
    public void setXljyFz(Double xljyFz) {
        this.xljyFz = xljyFz;
    }

    public Double getXljyFm() {
        return this.xljyFm;
    }
    
    public void setXljyFm(Double xljyFm) {
        this.xljyFm = xljyFm;
    }

    public Double getXljy() {
        return this.xljy;
    }
    
    public void setXljy(Double xljy) {
        this.xljy = xljy;
    }

    public Double getTglsh() {
        return this.tglsh;
    }
    
    public void setTglsh(Double tglsh) {
        this.tglsh = tglsh;
    }

    public Integer getSxrmb() {
        return this.sxrmb;
    }
    
    public void setSxrmb(Integer sxrmb) {
        this.sxrmb = sxrmb;
    }

    public Integer getSxwh() {
        return this.sxwh;
    }
    
    public void setSxwh(Integer sxwh) {
        this.sxwh = sxwh;
    }

    public Integer getSxjh() {
        return this.sxjh;
    }
    
    public void setSxjh(Integer sxjh) {
        this.sxjh = sxjh;
    }

    public Integer getSxsh() {
        return this.sxsh;
    }
    
    public void setSxsh(Integer sxsh) {
        this.sxsh = sxsh;
    }

    public Integer getSxjy() {
        return this.sxjy;
    }
    
    public void setSxjy(Integer sxjy) {
        this.sxjy = sxjy;
    }

    public Integer getSxfxq() {
        return this.sxfxq;
    }
    
    public void setSxfxq(Integer sxfxq) {
        this.sxfxq = sxfxq;
    }

    public Double getRjcl() {
        return this.rjcl;
    }
    
    public void setRjcl(Double rjcl) {
        this.rjcl = rjcl;
    }

    public Double getRjccl() {
        return this.rjccl;
    }
    
    public void setRjccl(Double rjccl) {
        this.rjccl = rjccl;
    }

    public Double getRjxl() {
        return this.rjxl;
    }
    
    public void setRjxl(Double rjxl) {
        this.rjxl = rjxl;
    }

    public Integer getLjsx() {
        return this.ljsx;
    }
    
    public void setLjsx(Integer ljsx) {
        this.ljsx = ljsx;
    }
   








}