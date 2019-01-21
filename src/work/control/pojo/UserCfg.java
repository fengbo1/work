package work.control.pojo;
// default package



/**
 * UserCfg entity. @author MyEclipse Persistence Tools
 */
public class UserCfg extends AbstractUserCfg implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UserCfg() {
    }

    
    /** full constructor */
    public UserCfg(String type, String typec, String num, String name, String namec, String content, String contentc, String contentsc) {
        super(type, typec, num, name, namec, content, contentc, contentsc);        
    }
   
}
