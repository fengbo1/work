package work.daily.pojo;
// default package



/**
 * AbstractDailyStatus entity provides the base persistence definition of the DailyStatus entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDailyStatus  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String time;
     private Integer hnQuick;
     private Integer wbBase;
     private Integer status;
     private Integer hnSummaryQuick;
     private Integer hnSummaryDaily;
     private Integer hnDaily;
     private Integer wbDaily;
     private Integer hnonline;
     private Integer hn891;
     private Integer hn895;
     private Integer hnx13;
     private Integer hnjihe;
     private Integer hnycsh;
     private Integer hnfxq;
     private Integer hnwhbb;
     private Integer wb891;
     private Integer wb895;
     private Integer wb896;
     private Integer wbjiagong;


    // Constructors

    /** default constructor */
    public AbstractDailyStatus() {
    }

    
    /** full constructor */
    public AbstractDailyStatus(String time, Integer hnQuick, Integer wbBase, Integer status, Integer hnSummaryQuick, Integer hnSummaryDaily, Integer hnDaily, Integer wbDaily, Integer hnonline, Integer hn891, Integer hn895, Integer hnx13, Integer hnjihe, Integer hnycsh, Integer hnfxq, Integer hnwhbb, Integer wb891, Integer wb895, Integer wb896, Integer wbjiagong) {
        this.time = time;
        this.hnQuick = hnQuick;
        this.wbBase = wbBase;
        this.status = status;
        this.hnSummaryQuick = hnSummaryQuick;
        this.hnSummaryDaily = hnSummaryDaily;
        this.hnDaily = hnDaily;
        this.wbDaily = wbDaily;
        this.hnonline = hnonline;
        this.hn891 = hn891;
        this.hn895 = hn895;
        this.hnx13 = hnx13;
        this.hnjihe = hnjihe;
        this.hnycsh = hnycsh;
        this.hnfxq = hnfxq;
        this.hnwhbb = hnwhbb;
        this.wb891 = wb891;
        this.wb895 = wb895;
        this.wb896 = wb896;
        this.wbjiagong = wbjiagong;
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

    public Integer getHnQuick() {
        return this.hnQuick;
    }
    
    public void setHnQuick(Integer hnQuick) {
        this.hnQuick = hnQuick;
    }

    public Integer getWbBase() {
        return this.wbBase;
    }
    
    public void setWbBase(Integer wbBase) {
        this.wbBase = wbBase;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHnSummaryQuick() {
        return this.hnSummaryQuick;
    }
    
    public void setHnSummaryQuick(Integer hnSummaryQuick) {
        this.hnSummaryQuick = hnSummaryQuick;
    }

    public Integer getHnSummaryDaily() {
        return this.hnSummaryDaily;
    }
    
    public void setHnSummaryDaily(Integer hnSummaryDaily) {
        this.hnSummaryDaily = hnSummaryDaily;
    }

    public Integer getHnDaily() {
        return this.hnDaily;
    }
    
    public void setHnDaily(Integer hnDaily) {
        this.hnDaily = hnDaily;
    }

    public Integer getWbDaily() {
        return this.wbDaily;
    }
    
    public void setWbDaily(Integer wbDaily) {
        this.wbDaily = wbDaily;
    }

    public Integer getHnonline() {
        return this.hnonline;
    }
    
    public void setHnonline(Integer hnonline) {
        this.hnonline = hnonline;
    }

    public Integer getHn891() {
        return this.hn891;
    }
    
    public void setHn891(Integer hn891) {
        this.hn891 = hn891;
    }

    public Integer getHn895() {
        return this.hn895;
    }
    
    public void setHn895(Integer hn895) {
        this.hn895 = hn895;
    }

    public Integer getHnx13() {
        return this.hnx13;
    }
    
    public void setHnx13(Integer hnx13) {
        this.hnx13 = hnx13;
    }

    public Integer getHnjihe() {
        return this.hnjihe;
    }
    
    public void setHnjihe(Integer hnjihe) {
        this.hnjihe = hnjihe;
    }

    public Integer getHnycsh() {
        return this.hnycsh;
    }
    
    public void setHnycsh(Integer hnycsh) {
        this.hnycsh = hnycsh;
    }

    public Integer getHnfxq() {
        return this.hnfxq;
    }
    
    public void setHnfxq(Integer hnfxq) {
        this.hnfxq = hnfxq;
    }

    public Integer getHnwhbb() {
        return this.hnwhbb;
    }
    
    public void setHnwhbb(Integer hnwhbb) {
        this.hnwhbb = hnwhbb;
    }

    public Integer getWb891() {
        return this.wb891;
    }
    
    public void setWb891(Integer wb891) {
        this.wb891 = wb891;
    }

    public Integer getWb895() {
        return this.wb895;
    }
    
    public void setWb895(Integer wb895) {
        this.wb895 = wb895;
    }

    public Integer getWb896() {
        return this.wb896;
    }
    
    public void setWb896(Integer wb896) {
        this.wb896 = wb896;
    }

    public Integer getWbjiagong() {
        return this.wbjiagong;
    }
    
    public void setWbjiagong(Integer wbjiagong) {
        this.wbjiagong = wbjiagong;
    }
   








}