package work.pool.pojo;
// default package



/**
 * Pool entity. @author MyEclipse Persistence Tools
 */
public class Pool extends AbstractPool implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Pool() {
    }

    
    /** full constructor */
    public Pool(String no, Integer type, Integer intype, String part, String code, Integer number, Integer cc, Integer tp, String sc) {
        super(no, type, intype, part, code, number, cc, tp, sc);        
    }
   
}
