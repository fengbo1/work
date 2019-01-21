package work.control.pojo;
// default package



/**
 * HnConfig entity. @author MyEclipse Persistence Tools
 */
public class HnConfig extends AbstractHnConfig implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public HnConfig() {
    }

    
    /** full constructor */
    public HnConfig(Integer type, String code, String part, Integer intype, String weig, Integer ord) {
        super(type, code, part, intype, weig, ord);        
    }
   
}
