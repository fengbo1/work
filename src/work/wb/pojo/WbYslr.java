package work.wb.pojo;

// default package



/**
 * WbYslr entity. @author MyEclipse Persistence Tools
 */
public class WbYslr extends AbstractWbYslr implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WbYslr() {
    }

    
    /** full constructor */
    public WbYslr(String corpcode, String corpname, Integer online, Double onlineZb, Double avertime, Integer cl, Double clZb, Double cc, Double hs, Double avevCl, Integer aboveNum, Double aboveZb, Double worktimeZb, String remark1, String remark2, String date, Double ccl, Double hsl, Integer aboveTime, Double aboveTimezb, Double worktime) {
        super(corpcode, corpname, online, onlineZb, avertime, cl, clZb, cc, hs, avevCl, aboveNum, aboveZb, worktimeZb, remark1, remark2, date, ccl, hsl, aboveTime, aboveTimezb, worktime);        
    }
   
}
