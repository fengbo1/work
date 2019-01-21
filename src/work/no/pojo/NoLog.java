package work.no.pojo;
// default package



/**
 * NoLog entity. @author MyEclipse Persistence Tools
 */
public class NoLog extends AbstractNoLog implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public NoLog() {
    }

    
    /** full constructor */
    public NoLog(String name, String no, Integer type, String para, String bef, String aft, String operator, String time, String remark, String remark1, String remark2) {
        super(name, no, type, para, bef, aft, operator, time, remark, remark1, remark2);        
    }
   
}
