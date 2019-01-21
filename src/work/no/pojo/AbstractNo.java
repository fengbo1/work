package work.no.pojo;
// default package



/**
 * AbstractNo entity provides the base persistence definition of the No entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String newnumber;
     private Integer sex;
     private String identity;
     private String tel;
     private String role;
     private String position;
     private Integer zx;
     private Integer xz;
     private Integer xzwh;
     private Integer xzjh;
     private Integer xzsh;
     private Integer xzjy;
     private String comedate;
     private String no891;
     private String no895;
     private String no1;
     private String no2;
     private Integer chu;
     private String team;
     private Integer schedeam;
     private String source;
     private Integer company;
     private String changewb;
     private String remark1;


    // Constructors

    /** default constructor */
    public AbstractNo() {
    }

    
    /** full constructor */
    public AbstractNo(String name, String newnumber, Integer sex, String identity, String tel, String role, String position, Integer zx, Integer xz, Integer xzwh, Integer xzjh, Integer xzsh, Integer xzjy, String comedate, String no891, String no895, String no1, String no2, Integer chu, String team, Integer schedeam, String source, Integer company, String changewb, String remark1) {
        this.name = name;
        this.newnumber = newnumber;
        this.sex = sex;
        this.identity = identity;
        this.tel = tel;
        this.role = role;
        this.position = position;
        this.zx = zx;
        this.xz = xz;
        this.xzwh = xzwh;
        this.xzjh = xzjh;
        this.xzsh = xzsh;
        this.xzjy = xzjy;
        this.comedate = comedate;
        this.no891 = no891;
        this.no895 = no895;
        this.no1 = no1;
        this.no2 = no2;
        this.chu = chu;
        this.team = team;
        this.schedeam = schedeam;
        this.source = source;
        this.company = company;
        this.changewb = changewb;
        this.remark1 = remark1;
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

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdentity() {
        return this.identity;
    }
    
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
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

    public Integer getZx() {
        return this.zx;
    }
    
    public void setZx(Integer zx) {
        this.zx = zx;
    }

    public Integer getXz() {
        return this.xz;
    }
    
    public void setXz(Integer xz) {
        this.xz = xz;
    }

    public Integer getXzwh() {
        return this.xzwh;
    }
    
    public void setXzwh(Integer xzwh) {
        this.xzwh = xzwh;
    }

    public Integer getXzjh() {
        return this.xzjh;
    }
    
    public void setXzjh(Integer xzjh) {
        this.xzjh = xzjh;
    }

    public Integer getXzsh() {
        return this.xzsh;
    }
    
    public void setXzsh(Integer xzsh) {
        this.xzsh = xzsh;
    }

    public Integer getXzjy() {
        return this.xzjy;
    }
    
    public void setXzjy(Integer xzjy) {
        this.xzjy = xzjy;
    }

    public String getComedate() {
        return this.comedate;
    }
    
    public void setComedate(String comedate) {
        this.comedate = comedate;
    }

    public String getNo891() {
        return this.no891;
    }
    
    public void setNo891(String no891) {
        this.no891 = no891;
    }

    public String getNo895() {
        return this.no895;
    }
    
    public void setNo895(String no895) {
        this.no895 = no895;
    }

    public String getNo1() {
        return this.no1;
    }
    
    public void setNo1(String no1) {
        this.no1 = no1;
    }

    public String getNo2() {
        return this.no2;
    }
    
    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public Integer getChu() {
        return this.chu;
    }
    
    public void setChu(Integer chu) {
        this.chu = chu;
    }

    public String getTeam() {
        return this.team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getSchedeam() {
        return this.schedeam;
    }
    
    public void setSchedeam(Integer schedeam) {
        this.schedeam = schedeam;
    }

    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }

    public Integer getCompany() {
        return this.company;
    }
    
    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getChangewb() {
        return this.changewb;
    }
    
    public void setChangewb(String changewb) {
        this.changewb = changewb;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
   








}