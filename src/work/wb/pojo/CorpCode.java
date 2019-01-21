package work.wb.pojo;

// default package



/**
 * CorpCode entity. @author MyEclipse Persistence Tools
 */
public class CorpCode extends AbstractCorpCode implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public CorpCode() {
    }

    
    /** full constructor */
    public CorpCode(String no, String name, String status, String remark1, String remark2) {
        super(no, name, status, remark1, remark2);        
    }
   
}
