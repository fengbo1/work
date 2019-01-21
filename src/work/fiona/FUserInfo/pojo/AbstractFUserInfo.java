package work.fiona.FUserInfo.pojo;
// default package



/**
 * AbstractFUserInfo entity provides the base persistence definition of the FUserInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFUserInfo  implements java.io.Serializable {


    // Fields    

     private String no;
     private String name;
     private String username;
     private String password;
     private String role;
     private String tongji;
     private String position;
     private String permission;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractFUserInfo() {
    }

	/** minimal constructor */
    public AbstractFUserInfo(String no, String name) {
        this.no = no;
        this.name = name;
    }
    
    /** full constructor */
    public AbstractFUserInfo(String no, String name, String username, String password, String role, String tongji, String position, String permission, String remark1, String remark2) {
        this.no = no;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.tongji = tongji;
        this.position = position;
        this.permission = permission;
        this.remark1 = remark1;
        this.remark2 = remark2;
    }

   
    // Property accessors

    public String getNo() {
        return this.no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public String getTongji() {
        return this.tongji;
    }
    
    public void setTongji(String tongji) {
        this.tongji = tongji;
    }

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public String getPermission() {
        return this.permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }
    
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
   








}