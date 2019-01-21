package work.rulecase.pojo;
// default package



/**
 * RcCase entity. @author MyEclipse Persistence Tools
 */
public class RcCase extends AbstractRcCase implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public RcCase() {
    }

    
    /** full constructor */
    public RcCase(String renewdate, String plate, String pool, String part, String factor, String facAName, String facBName, String facCName, String facA, String facB, String facC, String picname, String rule, String exp, String renewexp, String remark) {
        super(renewdate, plate, pool, part, factor, facAName, facBName, facCName, facA, facB, facC, picname, rule, exp, renewexp, remark);        
    }
   
}
