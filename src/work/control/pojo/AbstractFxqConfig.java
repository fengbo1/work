package work.control.pojo;
// default package



/**
 * AbstractFxqConfig entity provides the base persistence definition of the FxqConfig entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFxqConfig  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String newnumber;
     private String center;


    // Constructors

    /** default constructor */
    public AbstractFxqConfig() {
    }

    
    /** full constructor */
    public AbstractFxqConfig(String name, String newnumber, String center) {
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