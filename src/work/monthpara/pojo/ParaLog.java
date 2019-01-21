package work.monthpara.pojo;
// default package



/**
 * ParaLog entity. @author MyEclipse Persistence Tools
 */
public class ParaLog extends AbstractParaLog implements java.io.Serializable {

    // Constructors

    /** default constructor 
     * @param string7 
     * @param string6 
     * @param string5 
     * @param string4 
     * @param string3 
     * @param zlYj 
     * @param double1 
     * @param string2 
     * @param i 
     * @param string */
    public ParaLog() {
    }

    
    /** full constructor */
    public ParaLog(String month, Integer type, String para, String bef, String aft, String operator, String time, String remark, String remark1, String remark2) {
        super(month, type, para, bef, aft, operator, time, remark, remark1, remark2);        
    }
   
}
