package work.monthpara.pojo;
// default package



/**
 * MonthPara entity. @author MyEclipse Persistence Tools
 */
public class MonthPara extends AbstractMonthPara implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MonthPara() {
    }

    
    /** full constructor */
    public MonthPara(String month, Double hnCl, Double hnZl, Double wbCl, Double TBz, Double clYj, Double zlYj, Double xlYj, String remark1, String remark2, String remark3) {
        super(month, hnCl, hnZl, wbCl, TBz, clYj, zlYj, xlYj, remark1, remark2, remark3);        
    }
   
}
