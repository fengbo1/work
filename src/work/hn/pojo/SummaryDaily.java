package work.hn.pojo;
// default package



/**
 * SummaryDaily entity. @author MyEclipse Persistence Tools
 */
public class SummaryDaily extends AbstractSummaryDaily implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public SummaryDaily() {
    }

    
    /** full constructor */
    public SummaryDaily(String date, String itemCode, String itemName, Double wh891, Double wh891Zb, Double wh895, Double wh895Zb, Double whReal, Double whRealZb, Double cd891, Double cd891Zb, Double cd895, Double cd895Zb, Double cdReal, Double cdRealZb, Double total891, Double total895, Double totalReal, String remark1, String remark2, String remark3, String remark4, String remark5) {
        super(date, itemCode, itemName, wh891, wh891Zb, wh895, wh895Zb, whReal, whRealZb, cd891, cd891Zb, cd895, cd895Zb, cdReal, cdRealZb, total891, total895, totalReal, remark1, remark2, remark3, remark4, remark5);        
    }
   
}
