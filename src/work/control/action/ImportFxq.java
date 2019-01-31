package work.control.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.FxqConfigDAO;
import work.control.dao.JiheConfigDAO;
import work.control.pojo.FxqConfig;
import work.control.pojo.JiheConfig;
import work.rulecase.action.RuleImport;
import work.util.UploadUtil;
import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportFxq {
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
		FxqConfigDAO fcdao = new FxqConfigDAO();
		String realpath = "D:/import/work/";
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
//			sql = "truncate t_fxq_config";
//			session.createSQLQuery(sql).executeUpdate();
			for (int i = 1; i < nn; i++) {
				FxqConfig fc = new FxqConfig();
				Row currentRow = sheet.getRow(i);// 当前行
				if(currentRow!=null)
				{
					fc.setName(uu.getCellValue(currentRow.getCell(0), 0));
					fc.setNewnumber(uu.getCellValue(currentRow.getCell(1), 0));
					fc.setCenter(uu.getCellValue(currentRow.getCell(2), 0));
					fcdao.merge(fc);
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
