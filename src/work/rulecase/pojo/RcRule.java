package work.rulecase.pojo;
// default package



/**
 * RcRule entity. @author MyEclipse Persistence Tools
 */
public class RcRule extends AbstractRcRule implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public RcRule() {
    }

    
    /** full constructor */
    public RcRule(String renewdate, String plate, String pool, String part, String area, String factor, String facAName, String facBName, String facCName, String facA, String facB, String facC, String picname, String rule, String exp, String renewexp, String remark, String fujian) {
        super(renewdate, plate, pool, part, area, factor, facAName, facBName, facCName, facA, facB, facC, picname, rule, exp, renewexp, remark, fujian);        
    }
   
}
