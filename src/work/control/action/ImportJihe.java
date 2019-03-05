package work.control.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import work.control.dao.JhsxDAO;
import work.control.dao.JiheConfigDAO;
import work.control.pojo.Jhsx;
import work.control.pojo.JiheConfig;
import work.mycalendar.dao.MyCalendarDAO;
import work.mycalendar.pojo.MyCalendar;
import work.rulecase.action.RuleImport;
import work.rulecase.dao.RcCaseDAO;
import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcCase;
import work.rulecase.pojo.RcRule;
import work.util.GeneralCheck;
import work.util.Tld;
import work.util.UploadUtil;
import work.util.YearSeason;
import ccb.hibernate.HibernateSessionFactory;

public class ImportJihe {
	private static Logger logger = Logger.getLogger(RuleImport.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception{
		int nn=0;
		String sql = "";
		JiheConfigDAO jcdao = new JiheConfigDAO();
		String realpath = Tld.uploadpath;
		message = "导入成功";
		Workbook workbook = null;
		UploadUtil uu = new UploadUtil();
		if (file != null) {
			File savefile = new File(new File(realpath), fileFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(file, savefile);
		} else {
			ActionContext.getContext().put("message", "传入文件有误");
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			
			workbook = uu.getWorkbook(realpath+fileFileName);
			Sheet sheet = workbook.getSheetAt(0);
			nn = sheet.getLastRowNum()+1;
//			sql = "truncate t_jihe_config";
//			session.createSQLQuery(sql).executeUpdate();
			for (int i = 1; i < nn; i++) {
				JiheConfig jc = new JiheConfig();
				Row currentRow = sheet.getRow(i);// 当前行
				if(currentRow!=null)
				{
					jc.setName(uu.getCellValue(currentRow.getCell(0), 0));
					//System.out.println("--"+jc.getName()+"--");
					jc.setNewnumber(uu.getCellValue(currentRow.getCell(1), 0));
					jc.setCenter(uu.getCellValue(currentRow.getCell(2), 0));
					jcdao.merge(jc);
					if(!uu.getCellValue(currentRow.getCell(3), 0).trim().equals(""))
					{
						sql = "update t_no set newnumber='"+uu.getCellValue(currentRow.getCell(1), 0)+"',schedeam='"+uu.getCellValue(currentRow.getCell(3), 0)+"' where name='"+uu.getCellValue(currentRow.getCell(0), 0)+"'";
						session.createSQLQuery(sql).executeUpdate();
					}
				}
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
}
