package work.hndetail.pojo;
// default package



/**
 * AbstractHnDetail entity provides the base persistence definition of the HnDetail entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHnDetail  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String time;
     private String no;
     private String name;
     private Integer zx;
     private Integer xz;
     private String team;
     private Integer lrxg;
     private Double xlLrxg;
     private Double ljlrsc;
     private Integer lrsq;
     private Double xlLrsq;
     private Integer jhxg;
     private Double xlJhxg;
     private Integer jhsq;
     private Double xlJhsq;
     private Integer ljlr;
     private Integer ljjh;
     private Integer ljlr895;
     private Integer ljjh895;
     private Integer tp;
     private Integer ljtp;
     private Integer lrcc;
     private Integer jhcc;
     private Integer cx;
     private Integer ljcx;
     private Double output891;
     private Double output895;
     private Double output;
     private Double ccl891;
     private Double cxl891;
     private Double tpl891;
     private Double ccl895;
     private Double cxl895;
     private Double tpl895;
     private Double ljcl;
     private Integer ljywl891;
     private Integer ljywl895;
     private Double ljrjcl;
     private Double rjclwcl;
     private Integer ljlrcc;
     private Integer ljjhcc;
     private Double rjccl891;
     private Double rjcxl891;
     private Double rjtpl891;
     private Double rjccl895;
     private Double rjcxl895;
     private Double rjtpl895;
     private Integer ljsxts;
     private Integer online;
     private Integer zyzl;
     private String remark1;
     private String remark2;
     private String remark3;
     private String remark4;
     private String remark5;
     private Integer qdlr;
     private Integer qdlrz;
     private Integer ljqdlr;
     private Integer ljqdlrz;
     private Double qdlrzl;
     private Double ljqdlrzl;
     private Double percltime;
     private Double zyccl;


    // Constructors

    /** default constructor */
    public AbstractHnDetail() {
    }

    
    /** full constructor */
    public AbstractHnDetail(String time, String no, String name, Integer zx, Integer xz, String team, Integer lrxg, Double xlLrxg, Double ljlrsc, Integer lrsq, Double xlLrsq, Integer jhxg, Double xlJhxg, Integer jhsq, Double xlJhsq, Integer ljlr, Integer ljjh, Integer ljlr895, Integer ljjh895, Integer tp, Integer ljtp, Integer lrcc, Integer jhcc, Integer cx, Integer ljcx, Double output891, Double output895, Double output, Double ccl891, Double cxl891, Double tpl891, Double ccl895, Double cxl895, Double tpl895, Double ljcl, Integer ljywl891, Integer ljywl895, Double ljrjcl, Double rjclwcl, Integer ljlrcc, Integer ljjhcc, Double rjccl891, Double rjcxl891, Double rjtpl891, Double rjccl895, Double rjcxl895, Double rjtpl895, Integer ljsxts, Integer online, Integer zyzl, String remark1, String remark2, String remark3, String remark4, String remark5, Integer qdlr, Integer qdlrz, Integer ljqdlr, Integer ljqdlrz, Double qdlrzl, Double ljqdlrzl, Double percltime, Double zyccl) {
        this.time = time;
        this.no = no;
        this.name = name;
        this.zx = zx;
        this.xz = xz;
        this.team = team;
        this.lrxg = lrxg;
        this.xlLrxg = xlLrxg;
        this.ljlrsc = ljlrsc;
        this.lrsq = lrsq;
        this.xlLrsq = xlLrsq;
        this.jhxg = jhxg;
        this.xlJhxg = xlJhxg;
        this.jhsq = jhsq;
        this.xlJhsq = xlJhsq;
        this.ljlr = ljlr;
        this.ljjh = ljjh;
        this.ljlr895 = ljlr895;
        this.ljjh895 = ljjh895;
        this.tp = tp;
        this.ljtp = ljtp;
        this.lrcc = lrcc;
        this.jhcc = jhcc;
        this.cx = cx;
        this.ljcx = ljcx;
        this.output891 = output891;
        this.output895 = output895;
        this.output = output;
        this.ccl891 = ccl891;
        this.cxl891 = cxl891;
        this.tpl891 = tpl891;
        this.ccl895 = ccl895;
        this.cxl895 = cxl895;
        this.tpl895 = tpl895;
        this.ljcl = ljcl;
        this.ljywl891 = ljywl891;
        this.ljywl895 = ljywl895;
        this.ljrjcl = ljrjcl;
        this.rjclwcl = rjclwcl;
        this.ljlrcc = ljlrcc;
        this.ljjhcc = ljjhcc;
        this.rjccl891 = rjccl891;
        this.rjcxl891 = rjcxl891;
        this.rjtpl891 = rjtpl891;
        this.rjccl895 = rjccl895;
        this.rjcxl895 = rjcxl895;
        this.rjtpl895 = rjtpl895;
        this.ljsxts = ljsxts;
        this.online = online;
        this.zyzl = zyzl;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.remark4 = remark4;
        this.remark5 = remark5;
        this.qdlr = qdlr;
        this.qdlrz = qdlrz;
        this.ljqdlr = ljqdlr;
        this.ljqdlrz = ljqdlrz;
        this.qdlrzl = qdlrzl;
        this.ljqdlrzl = ljqdlrzl;
        this.percltime = percltime;
        this.zyccl = zyccl;
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

    public String getTeam() {
        return this.team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getLrxg() {
        return this.lrxg;
    }
    
    public void setLrxg(Integer lrxg) {
        this.lrxg = lrxg;
    }

    public Double getXlLrxg() {
        return this.xlLrxg;
    }
    
    public void setXlLrxg(Double xlLrxg) {
        this.xlLrxg = xlLrxg;
    }

    public Double getLjlrsc() {
        return this.ljlrsc;
    }
    
    public void setLjlrsc(Double ljlrsc) {
        this.ljlrsc = ljlrsc;
    }

    public Integer getLrsq() {
        return this.lrsq;
    }
    
    public void setLrsq(Integer lrsq) {
        this.lrsq = lrsq;
    }

    public Double getXlLrsq() {
        return this.xlLrsq;
    }
    
    public void setXlLrsq(Double xlLrsq) {
        this.xlLrsq = xlLrsq;
    }

    public Integer getJhxg() {
        return this.jhxg;
    }
    
    public void setJhxg(Integer jhxg) {
        this.jhxg = jhxg;
    }

    public Double getXlJhxg() {
        return this.xlJhxg;
    }
    
    public void setXlJhxg(Double xlJhxg) {
        this.xlJhxg = xlJhxg;
    }

    public Integer getJhsq() {
        return this.jhsq;
    }
    
    public void setJhsq(Integer jhsq) {
        this.jhsq = jhsq;
    }

    public Double getXlJhsq() {
        return this.xlJhsq;
    }
    
    public void setXlJhsq(Double xlJhsq) {
        this.xlJhsq = xlJhsq;
    }

    public Integer getLjlr() {
        return this.ljlr;
    }
    
    public void setLjlr(Integer ljlr) {
        this.ljlr = ljlr;
    }

    public Integer getLjjh() {
        return this.ljjh;
    }
    
    public void setLjjh(Integer ljjh) {
        this.ljjh = ljjh;
    }

    public Integer getLjlr895() {
        return this.ljlr895;
    }
    
    public void setLjlr895(Integer ljlr895) {
        this.ljlr895 = ljlr895;
    }

    public Integer getLjjh895() {
        return this.ljjh895;
    }
    
    public void setLjjh895(Integer ljjh895) {
        this.ljjh895 = ljjh895;
    }

    public Integer getTp() {
        return this.tp;
    }
    
    public void setTp(Integer tp) {
        this.tp = tp;
    }

    public Integer getLjtp() {
        return this.ljtp;
    }
    
    public void setLjtp(Integer ljtp) {
        this.ljtp = ljtp;
    }

    public Integer getLrcc() {
        return this.lrcc;
    }
    
    public void setLrcc(Integer lrcc) {
        this.lrcc = lrcc;
    }

    public Integer getJhcc() {
        return this.jhcc;
    }
    
    public void setJhcc(Integer jhcc) {
        this.jhcc = jhcc;
    }

    public Integer getCx() {
        return this.cx;
    }
    
    public void setCx(Integer cx) {
        this.cx = cx;
    }

    public Integer getLjcx() {
        return this.ljcx;
    }
    
    public void setLjcx(Integer ljcx) {
        this.ljcx = ljcx;
    }

    public Double getOutput891() {
        return this.output891;
    }
    
    public void setOutput891(Double output891) {
        this.output891 = output891;
    }

    public Double getOutput895() {
        return this.output895;
    }
    
    public void setOutput895(Double output895) {
        this.output895 = output895;
    }

    public Double getOutput() {
        return this.output;
    }
    
    public void setOutput(Double output) {
        this.output = output;
    }

    public Double getCcl891() {
        return this.ccl891;
    }
    
    public void setCcl891(Double ccl891) {
        this.ccl891 = ccl891;
    }

    public Double getCxl891() {
        return this.cxl891;
    }
    
    public void setCxl891(Double cxl891) {
        this.cxl891 = cxl891;
    }

    public Double getTpl891() {
        return this.tpl891;
    }
    
    public void setTpl891(Double tpl891) {
        this.tpl891 = tpl891;
    }

    public Double getCcl895() {
        return this.ccl895;
    }
    
    public void setCcl895(Double ccl895) {
        this.ccl895 = ccl895;
    }

    public Double getCxl895() {
        return this.cxl895;
    }
    
    public void setCxl895(Double cxl895) {
        this.cxl895 = cxl895;
    }

    public Double getTpl895() {
        return this.tpl895;
    }
    
    public void setTpl895(Double tpl895) {
        this.tpl895 = tpl895;
    }

    public Double getLjcl() {
        return this.ljcl;
    }
    
    public void setLjcl(Double ljcl) {
        this.ljcl = ljcl;
    }

    public Integer getLjywl891() {
        return this.ljywl891;
    }
    
    public void setLjywl891(Integer ljywl891) {
        this.ljywl891 = ljywl891;
    }

    public Integer getLjywl895() {
        return this.ljywl895;
    }
    
    public void setLjywl895(Integer ljywl895) {
        this.ljywl895 = ljywl895;
    }

    public Double getLjrjcl() {
        return this.ljrjcl;
    }
    
    public void setLjrjcl(Double ljrjcl) {
        this.ljrjcl = ljrjcl;
    }

    public Double getRjclwcl() {
        return this.rjclwcl;
    }
    
    public void setRjclwcl(Double rjclwcl) {
        this.rjclwcl = rjclwcl;
    }

    public Integer getLjlrcc() {
        return this.ljlrcc;
    }
    
    public void setLjlrcc(Integer ljlrcc) {
        this.ljlrcc = ljlrcc;
    }

    public Integer getLjjhcc() {
        return this.ljjhcc;
    }
    
    public void setLjjhcc(Integer ljjhcc) {
        this.ljjhcc = ljjhcc;
    }

    public Double getRjccl891() {
        return this.rjccl891;
    }
    
    public void setRjccl891(Double rjccl891) {
        this.rjccl891 = rjccl891;
    }

    public Double getRjcxl891() {
        return this.rjcxl891;
    }
    
    public void setRjcxl891(Double rjcxl891) {
        this.rjcxl891 = rjcxl891;
    }

    public Double getRjtpl891() {
        return this.rjtpl891;
    }
    
    public void setRjtpl891(Double rjtpl891) {
        this.rjtpl891 = rjtpl891;
    }

    public Double getRjccl895() {
        return this.rjccl895;
    }
    
    public void setRjccl895(Double rjccl895) {
        this.rjccl895 = rjccl895;
    }

    public Double getRjcxl895() {
        return this.rjcxl895;
    }
    
    public void setRjcxl895(Double rjcxl895) {
        this.rjcxl895 = rjcxl895;
    }

    public Double getRjtpl895() {
        return this.rjtpl895;
    }
    
    public void setRjtpl895(Double rjtpl895) {
        this.rjtpl895 = rjtpl895;
    }

    public Integer getLjsxts() {
        return this.ljsxts;
    }
    
    public void setLjsxts(Integer ljsxts) {
        this.ljsxts = ljsxts;
    }

    public Integer getOnline() {
        return this.online;
    }
    
    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getZyzl() {
        return this.zyzl;
    }
    
    public void setZyzl(Integer zyzl) {
        this.zyzl = zyzl;
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

    public Integer getQdlr() {
        return this.qdlr;
    }
    
    public void setQdlr(Integer qdlr) {
        this.qdlr = qdlr;
    }

    public Integer getQdlrz() {
        return this.qdlrz;
    }
    
    public void setQdlrz(Integer qdlrz) {
        this.qdlrz = qdlrz;
    }

    public Integer getLjqdlr() {
        return this.ljqdlr;
    }
    
    public void setLjqdlr(Integer ljqdlr) {
        this.ljqdlr = ljqdlr;
    }

    public Integer getLjqdlrz() {
        return this.ljqdlrz;
    }
    
    public void setLjqdlrz(Integer ljqdlrz) {
        this.ljqdlrz = ljqdlrz;
    }

    public Double getQdlrzl() {
        return this.qdlrzl;
    }
    
    public void setQdlrzl(Double qdlrzl) {
        this.qdlrzl = qdlrzl;
    }

    public Double getLjqdlrzl() {
        return this.ljqdlrzl;
    }
    
    public void setLjqdlrzl(Double ljqdlrzl) {
        this.ljqdlrzl = ljqdlrzl;
    }

    public Double getPercltime() {
        return this.percltime;
    }
    
    public void setPercltime(Double percltime) {
        this.percltime = percltime;
    }

    public Double getZyccl() {
        return this.zyccl;
    }
    
    public void setZyccl(Double zyccl) {
        this.zyccl = zyccl;
    }
   








}