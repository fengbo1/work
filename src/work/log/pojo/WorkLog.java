package work.log.pojo;
// default package



/**
 * WorkLog entity. @author MyEclipse Persistence Tools
 */
public class WorkLog extends AbstractWorkLog implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WorkLog() {
    }

    
    /** full constructor */
    public WorkLog(String time, String name, String ip, String operate, String detail, String remark1, String remark2, String remark3, String remark4, String remark5) {
        super(time, name, ip, operate, detail, remark1, remark2, remark3, remark4, remark5);        
    }
   
}
