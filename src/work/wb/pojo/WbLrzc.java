package work.wb.pojo;

// default package



/**
 * WbLrzc entity. @author MyEclipse Persistence Tools
 */
public class WbLrzc extends AbstractWbLrzc implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WbLrzc() {
    }

    
    /** full constructor */
    public WbLrzc(String corpcode, String corpname, Integer online, Double onlineZb, Double avertime, Integer cl, Double clZb, Double cc, Double ccl, Double hs, Double hsl, Double avevCl, String date, String remark1, String remark2) {
        super(corpcode, corpname, online, onlineZb, avertime, cl, clZb, cc, ccl, hs, hsl, avevCl, date, remark1, remark2);        
    }
   
}
