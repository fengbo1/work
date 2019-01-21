package work.userinfo.pojo;
// default package



/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
public class UserInfo extends AbstractUserInfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UserInfo() {
    }

    
    /** full constructor */
    public UserInfo(String username, String password, String role, String position, String no891, String remark1, String remark2, String remark3, String remark4, String remark5, String remark6) {
        super(username, password, role, position, no891, remark1, remark2, remark3, remark4, remark5, remark6);        
    }
   
}
