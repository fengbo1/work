package work.online.pojo;
// default package



/**
 * AbstractOnline entity provides the base persistence definition of the Online entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOnline  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String time;
     private String no;


    // Constructors

    /** default constructor */
    public AbstractOnline() {
    }

    
    /** full constructor */
    public AbstractOnline(String time, String no) {
        this.time = time;
        this.no = no;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getNo() {
        return this.no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }
   








}