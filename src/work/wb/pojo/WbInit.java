package work.wb.pojo;

// default package



/**
 * WbInit entity. @author MyEclipse Persistence Tools
 */
public class WbInit extends AbstractWbInit implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WbInit() {
    }

    
    /** full constructor */
    public WbInit(String no, String name, Integer step, Integer ywl, Double averTime, Integer cc, Integer hs, Integer zlrxg, Integer zyxcf, String pool, String remark1, String remark2, String remark3) {
        super(no, name, step, ywl, averTime, cc, hs, zlrxg, zyxcf, pool, remark1, remark2, remark3);        
    }
   
}
