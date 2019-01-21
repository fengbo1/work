package work.rulecase.pojo;
// default package



/**
 * AbstractRcZl entity provides the base persistence definition of the RcZl entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRcZl  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer type;
     private Integer plate;
     private String pool;
     private String date;
     private String zlname;
     private String filename;


    // Constructors

    /** default constructor */
    public AbstractRcZl() {
    }

    
    /** full constructor */
    public AbstractRcZl(Integer type, Integer plate, String pool, String date, String zlname, String filename) {
        this.type = type;
        this.plate = plate;
        this.pool = pool;
        this.date = date;
        this.zlname = zlname;
        this.filename = filename;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPlate() {
        return this.plate;
    }
    
    public void setPlate(Integer plate) {
        this.plate = plate;
    }

    public String getPool() {
        return this.pool;
    }
    
    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getZlname() {
        return this.zlname;
    }
    
    public void setZlname(String zlname) {
        this.zlname = zlname;
    }

    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
   








}