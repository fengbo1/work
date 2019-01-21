package work.hn.action;

import java.io.File;

import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import work.hn.dao.SummaryDailyDAO;
import work.hn.pojo.SummaryDaily;
import work.util.GeneralCheck;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 汇总表导入
 * @author htzx
 *
 */
public class SummaryImport {

	
	public String execute() throws Exception
	{
		int nn=0;
		GeneralCheck check = new GeneralCheck();
		String realpath = "D:/import/work/summary.xls";
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	truncate(session,"t_daily_summary");
    	try {
    		Workbook book = Workbook.getWorkbook(new File(realpath));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
			SummaryDailyDAO sdao = new SummaryDailyDAO();
			for (int i = 1; i < nn; i++) {
				SummaryDaily summary = new SummaryDaily();
				summary.setDate(sheet.getCell(1, i).getContents().trim());
				summary.setItemCode(sheet.getCell(2, i).getContents().trim());
				summary.setItemName(sheet.getCell(3, i).getContents().trim());
				if(sheet.getCell(4, i).getType()==CellType.NUMBER)
				{
					summary.setWh891(check.DoubleTo4(((NumberCell)sheet.getCell(4, i)).getValue()));
				}
				else
				{
					summary.setWh891(check.IsNullDouble((sheet.getCell(4, i)).getContents()));
				}
				if(sheet.getCell(5, i).getType()==CellType.NUMBER)
				{
					summary.setWh891Zb(check.DoubleTo4(((NumberCell)sheet.getCell(5, i)).getValue()));
				}
				else
				{
					summary.setWh891Zb(check.IsNullDouble((sheet.getCell(5, i)).getContents()));
				}
				if(sheet.getCell(6, i).getType()==CellType.NUMBER)
				{
					summary.setWh895(check.DoubleTo4(((NumberCell)sheet.getCell(6, i)).getValue()));
				}
				else
				{
					summary.setWh895(check.IsNullDouble((sheet.getCell(6, i)).getContents()));
				}
				if(sheet.getCell(7, i).getType()==CellType.NUMBER)
				{
					summary.setWh895Zb(check.DoubleTo4(((NumberCell)sheet.getCell(7, i)).getValue()));
				}
				else
				{
					summary.setWh895Zb(check.IsNullDouble((sheet.getCell(7, i)).getContents()));
				}
				summary.setWhReal(check.IsNullDouble(sheet.getCell(8, i).getContents()));
				if(sheet.getCell(9, i).getType()==CellType.NUMBER)
				{
					summary.setWhRealZb(check.DoubleTo4(((NumberCell)sheet.getCell(9, i)).getValue()));
				}
				else
				{
					summary.setWhRealZb(check.IsNullDouble((sheet.getCell(9, i)).getContents()));
				}
				if(sheet.getCell(10, i).getType()==CellType.NUMBER)
				{
					summary.setCd891(check.DoubleTo4(((NumberCell)sheet.getCell(10, i)).getValue()));
				}
				else
				{
					summary.setCd891(check.IsNullDouble((sheet.getCell(10, i)).getContents()));
				}
				if(sheet.getCell(11, i).getType()==CellType.NUMBER)
				{
					summary.setCd891Zb(check.DoubleTo4(((NumberCell)sheet.getCell(11, i)).getValue()));
				}
				else
				{
					summary.setCd891Zb(check.IsNullDouble((sheet.getCell(11, i)).getContents()));
				}
				if(sheet.getCell(12, i).getType()==CellType.NUMBER)
				{
					summary.setCd895(check.DoubleTo4(((NumberCell)sheet.getCell(12, i)).getValue()));
				}
				else
				{
					summary.setCd895(check.IsNullDouble((sheet.getCell(12, i)).getContents()));
				}
				if(sheet.getCell(13, i).getType()==CellType.NUMBER)
				{
					summary.setCd895Zb(check.DoubleTo4(((NumberCell)sheet.getCell(13, i)).getValue()));
				}
				else
				{
					summary.setCd895Zb(check.IsNullDouble((sheet.getCell(13, i)).getContents()));
				}
				summary.setCdReal(check.IsNullDouble(sheet.getCell(14, i).getContents()));
				if(sheet.getCell(15, i).getType()==CellType.NUMBER)
				{
					summary.setCdRealZb(check.DoubleTo4(((NumberCell)sheet.getCell(15, i)).getValue()));
				}
				else
				{
					summary.setCdRealZb(check.IsNullDouble((sheet.getCell(15, i)).getContents()));
				}
				if(sheet.getCell(16, i).getType()==CellType.NUMBER)
				{
					summary.setTotal891(check.DoubleTo4(((NumberCell)sheet.getCell(16, i)).getValue()));
				}
				else
				{
					summary.setTotal891(check.IsNullDouble((sheet.getCell(16, i)).getContents()));
				}
				if(sheet.getCell(17, i).getType()==CellType.NUMBER)
				{
					summary.setTotal895(check.DoubleTo4(((NumberCell)sheet.getCell(17, i)).getValue()));
				}
				else
				{
					summary.setTotal895(check.IsNullDouble((sheet.getCell(17, i)).getContents()));
				}
				summary.setTotalReal(check.IsNullDouble(sheet.getCell(18, i).getContents()));
				sdao.merge(summary);
			}
			
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		
		return "success";
	}
	/*truncate表*/
	public void truncate(Session truncate_session, String table)
	{
		Query queryObject = truncate_session.createSQLQuery("truncate "+ table);
		queryObject.executeUpdate();
	}
}
