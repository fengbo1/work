package work.rulecase.pojo;
// default package



/**
 * RcZl entity. @author MyEclipse Persistence Tools
 */
public class RcZl extends AbstractRcZl implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public RcZl() {
    }

    
    /** full constructor */
    public RcZl(Integer type, Integer plate, String pool, String date, String zlname, String filename) {
        super(type, plate, pool, date, zlname, filename);        
    }
   
}
