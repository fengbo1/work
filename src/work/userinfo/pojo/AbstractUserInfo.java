package work.userinfo.pojo;
// default package



/**
 * AbstractUserInfo entity provides the base persistence definition of the UserInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserInfo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String username;
     private String password;
     private String role;
     private String position;
     private String no891;
     private String remark1;
     private String remark2;
     private String remark3;
     private String remark4;
     private String remark5;
     private String remark6;


    // Constructors

    /** default constructor */
    public AbstractUserInfo() {
    }

    
    /** full constructor */
    public AbstractUserInfo(String username, String password, String role, String position, String no891, String remark1, String remark2, String remark3, String remark4, String remark5, String remark6) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.position = position;
        this.no891 = no891;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.remark4 = remark4;
        this.remark5 = remark5;
        this.remark6 = remark6;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public String getNo891() {
        return this.no891;
    }
    
    public void setNo891(String no891) {
        this.no891 = no891;
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

    public String getRemark3() {
        return this.remark3;
    }
    
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return this.remark4;
    }
    
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return this.remark5;
    }
    
    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return this.remark6;
    }
    
    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }
   








}