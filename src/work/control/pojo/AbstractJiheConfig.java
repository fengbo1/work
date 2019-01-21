package work.control.pojo;
// default package



/**
 * AbstractJiheConfig entity provides the base persistence definition of the JiheConfig entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJiheConfig  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String newnumber;
     private String center;


    // Constructors

    /** default constructor */
    public AbstractJiheConfig() {
    }

    
    /** full constructor */
    public AbstractJiheConfig(String name, String newnumber, String center) {
        this.name = name;
        this.newnumber = newnumber;
        this.center = center;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getCenter() {
        return this.center;
    }
    
    public void setCenter(String center) {
        this.center = center;
    }
   








}