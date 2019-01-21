package work.hn.pojo;
// default package



/**
 * AbstractSummary entity provides the base persistence definition of the Summary entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSummary  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jg;
     private String type;
     private Double clDay;
     private Double clAver;
     private Double clDayRmb;
     private Double clDayWh;
     private Double clDayJh;
     private Double clDaySh;
     private Double clDayJy;
     private Double clDayFxq;
     private Double percltimeDay;
     private Double percltimeAver;
     private Double zycclDay;
     private Double zycclAver;
     private Double zytplDay;
     private Double zytplAver;
     private Double zycxlDay;
     private Double zycxlAver;
     private Double cc891Day;
     private Double cc891Aver;
     private Double tp891Day;
     private Double tp891Aver;
     private Double cx891Day;
     private Double cx891Aver;
     private Double cc895Day;
     private Double cc895Aver;
     private Double tp895Day;
     private Double tp895Aver;
     private Double cx895Day;
     private Double cx895Aver;
     private Double zwd;
     private Double ljzwd;
     private String date;


    // Constructors

    /** default constructor */
    public AbstractSummary() {
    }

    
    /** full constructor */
    public AbstractSummary(String jg, String type, Double clDay, Double clAver, Double clDayRmb, Double clDayWh, Double clDayJh, Double clDaySh, Double clDayJy, Double clDayFxq, Double percltimeDay, Double percltimeAver, Double zycclDay, Double zycclAver, Double zytplDay, Double zytplAver, Double zycxlDay, Double zycxlAver, Double cc891Day, Double cc891Aver, Double tp891Day, Double tp891Aver, Double cx891Day, Double cx891Aver, Double cc895Day, Double cc895Aver, Double tp895Day, Double tp895Aver, Double cx895Day, Double cx895Aver, Double zwd, Double ljzwd, String date) {
        this.jg = jg;
        this.type = type;
        this.clDay = clDay;
        this.clAver = clAver;
        this.clDayRmb = clDayRmb;
        this.clDayWh = clDayWh;
        this.clDayJh = clDayJh;
        this.clDaySh = clDaySh;
        this.clDayJy = clDayJy;
        this.clDayFxq = clDayFxq;
        this.percltimeDay = percltimeDay;
        this.percltimeAver = percltimeAver;
        this.zycclDay = zycclDay;
        this.zycclAver = zycclAver;
        this.zytplDay = zytplDay;
        this.zytplAver = zytplAver;
        this.zycxlDay = zycxlDay;
        this.zycxlAver = zycxlAver;
        this.cc891Day = cc891Day;
        this.cc891Aver = cc891Aver;
        this.tp891Day = tp891Day;
        this.tp891Aver = tp891Aver;
        this.cx891Day = cx891Day;
        this.cx891Aver = cx891Aver;
        this.cc895Day = cc895Day;
        this.cc895Aver = cc895Aver;
        this.tp895Day = tp895Day;
        this.tp895Aver = tp895Aver;
        this.cx895Day = cx895Day;
        this.cx895Aver = cx895Aver;
        this.zwd = zwd;
        this.ljzwd = ljzwd;
        this.date = date;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getJg() {
        return this.jg;
    }
    
    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public Double getClDay() {
        return this.clDay;
    }
    
    public void setClDay(Double clDay) {
        this.clDay = clDay;
    }

    public Double getClAver() {
        return this.clAver;
    }
    
    public void setClAver(Double clAver) {
        this.clAver = clAver;
    }

    public Double getClDayRmb() {
        return this.clDayRmb;
    }
    
    public void setClDayRmb(Double clDayRmb) {
        this.clDayRmb = clDayRmb;
    }

    public Double getClDayWh() {
        return this.clDayWh;
    }
    
    public void setClDayWh(Double clDayWh) {
        this.clDayWh = clDayWh;
    }

    public Double getClDayJh() {
        return this.clDayJh;
    }
    
    public void setClDayJh(Double clDayJh) {
        this.clDayJh = clDayJh;
    }

    public Double getClDaySh() {
        return this.clDaySh;
    }
    
    public void setClDaySh(Double clDaySh) {
        this.clDaySh = clDaySh;
    }

    public Double getClDayJy() {
        return this.clDayJy;
    }
    
    public void setClDayJy(Double clDayJy) {
        this.clDayJy = clDayJy;
    }

    public Double getClDayFxq() {
        return this.clDayFxq;
    }
    
    public void setClDayFxq(Double clDayFxq) {
        this.clDayFxq = clDayFxq;
    }

    public Double getPercltimeDay() {
        return this.percltimeDay;
    }
    
    public void setPercltimeDay(Double percltimeDay) {
        this.percltimeDay = percltimeDay;
    }

    public Double getPercltimeAver() {
        return this.percltimeAver;
    }
    
    public void setPercltimeAver(Double percltimeAver) {
        this.percltimeAver = percltimeAver;
    }

    public Double getZycclDay() {
        return this.zycclDay;
    }
    
    public void setZycclDay(Double zycclDay) {
        this.zycclDay = zycclDay;
    }

    public Double getZycclAver() {
        return this.zycclAver;
    }
    
    public void setZycclAver(Double zycclAver) {
        this.zycclAver = zycclAver;
    }

    public Double getZytplDay() {
        return this.zytplDay;
    }
    
    public void setZytplDay(Double zytplDay) {
        this.zytplDay = zytplDay;
    }

    public Double getZytplAver() {
        return this.zytplAver;
    }
    
    public void setZytplAver(Double zytplAver) {
        this.zytplAver = zytplAver;
    }

    public Double getZycxlDay() {
        return this.zycxlDay;
    }
    
    public void setZycxlDay(Double zycxlDay) {
        this.zycxlDay = zycxlDay;
    }

    public Double getZycxlAver() {
        return this.zycxlAver;
    }
    
    public void setZycxlAver(Double zycxlAver) {
        this.zycxlAver = zycxlAver;
    }

    public Double getCc891Day() {
        return this.cc891Day;
    }
    
    public void setCc891Day(Double cc891Day) {
        this.cc891Day = cc891Day;
    }

    public Double getCc891Aver() {
        return this.cc891Aver;
    }
    
    public void setCc891Aver(Double cc891Aver) {
        this.cc891Aver = cc891Aver;
    }

    public Double getTp891Day() {
        return this.tp891Day;
    }
    
    public void setTp891Day(Double tp891Day) {
        this.tp891Day = tp891Day;
    }

    public Double getTp891Aver() {
        return this.tp891Aver;
    }
    
    public void setTp891Aver(Double tp891Aver) {
        this.tp891Aver = tp891Aver;
    }

    public Double getCx891Day() {
        return this.cx891Day;
    }
    
    public void setCx891Day(Double cx891Day) {
        this.cx891Day = cx891Day;
    }

    public Double getCx891Aver() {
        return this.cx891Aver;
    }
    
    public void setCx891Aver(Double cx891Aver) {
        this.cx891Aver = cx891Aver;
    }

    public Double getCc895Day() {
        return this.cc895Day;
    }
    
    public void setCc895Day(Double cc895Day) {
        this.cc895Day = cc895Day;
    }

    public Double getCc895Aver() {
        return this.cc895Aver;
    }
    
    public void setCc895Aver(Double cc895Aver) {
        this.cc895Aver = cc895Aver;
    }

    public Double getTp895Day() {
        return this.tp895Day;
    }
    
    public void setTp895Day(Double tp895Day) {
        this.tp895Day = tp895Day;
    }

    public Double getTp895Aver() {
        return this.tp895Aver;
    }
    
    public void setTp895Aver(Double tp895Aver) {
        this.tp895Aver = tp895Aver;
    }

    public Double getCx895Day() {
        return this.cx895Day;
    }
    
    public void setCx895Day(Double cx895Day) {
        this.cx895Day = cx895Day;
    }

    public Double getCx895Aver() {
        return this.cx895Aver;
    }
    
    public void setCx895Aver(Double cx895Aver) {
        this.cx895Aver = cx895Aver;
    }

    public Double getZwd() {
        return this.zwd;
    }
    
    public void setZwd(Double zwd) {
        this.zwd = zwd;
    }

    public Double getLjzwd() {
        return this.ljzwd;
    }
    
    public void setLjzwd(Double ljzwd) {
        this.ljzwd = ljzwd;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
   








}