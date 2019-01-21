package work.daily.pojo;
// default package



/**
 * DailyStatus entity. @author MyEclipse Persistence Tools
 */
public class DailyStatus extends AbstractDailyStatus implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public DailyStatus() {
    }

    
    /** full constructor */
    public DailyStatus(String time, Integer hnQuick, Integer wbBase, Integer status, Integer hnSummaryQuick, Integer hnSummaryDaily, Integer hnDaily, Integer wbDaily, Integer hnonline, Integer hn891, Integer hn895, Integer hnx13, Integer hnjihe, Integer hnycsh, Integer hnfxq, Integer hnwhbb, Integer wb891, Integer wb895, Integer wb896, Integer wbjiagong) {
        super(time, hnQuick, wbBase, status, hnSummaryQuick, hnSummaryDaily, hnDaily, wbDaily, hnonline, hn891, hn895, hnx13, hnjihe, hnycsh, hnfxq, hnwhbb, wb891, wb895, wb896, wbjiagong);        
    }
   
}
