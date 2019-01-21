package work.fiona.FUserInfo.pojo;
// default package



/**
 * FUserInfo entity. @author MyEclipse Persistence Tools
 */
public class FUserInfo extends AbstractFUserInfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public FUserInfo() {
    }

	/** minimal constructor */
    public FUserInfo(String no, String name) {
        super(no, name);        
    }
    
    /** full constructor */
    public FUserInfo(String no, String name, String username, String password, String role, String tongji, String position, String permission, String remark1, String remark2) {
        super(no, name, username, password, role, tongji, position, permission, remark1, remark2);        
    }
   
}
