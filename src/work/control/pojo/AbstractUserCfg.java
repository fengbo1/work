package work.control.pojo;
// default package



/**
 * AbstractUserCfg entity provides the base persistence definition of the UserCfg entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserCfg  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String type;
     private String typec;
     private String num;
     private String name;
     private String namec;
     private String content;
     private String contentc;
     private String contentsc;


    // Constructors

    /** default constructor */
    public AbstractUserCfg() {
    }

    
    /** full constructor */
    public AbstractUserCfg(String type, String typec, String num, String name, String namec, String content, String contentc, String contentsc) {
        this.type = type;
        this.typec = typec;
        this.num = num;
        this.name = name;
        this.namec = namec;
        this.content = content;
        this.contentc = contentc;
        this.contentsc = contentsc;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getTypec() {
        return this.typec;
    }
    
    public void setTypec(String typec) {
        this.typec = typec;
    }

    public String getNum() {
        return this.num;
    }
    
    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNamec() {
        return this.namec;
    }
    
    public void setNamec(String namec) {
        this.namec = namec;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getContentc() {
        return this.contentc;
    }
    
    public void setContentc(String contentc) {
        this.contentc = contentc;
    }

    public String getContentsc() {
        return this.contentsc;
    }
    
    public void setContentsc(String contentsc) {
        this.contentsc = contentsc;
    }
   








}