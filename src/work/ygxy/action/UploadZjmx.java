package work.ygxy.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.GeneralCheck;
import work.ygxy.dao.YZjmxDAO;
import work.ygxy.pojo.YZjmx;

public class UploadZjmx {

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
    
	public String execute() throws Exception
	{
		
		UserInfoDAO uidao = new UserInfoDAO();
		GeneralCheck check = new GeneralCheck();
		String realpath = "D:/import/work/";
		int nn=0;
		if ((file != null)&&(fileFileName.length()>0)) {
			File savefile = new File(new File(realpath), fileFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(file, savefile);
		} else {
			message="导入文件有误";
			return "success";
		}
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	delete(session,"y_zjmx");
    	try {
			Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(1);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
			YZjmxDAO yzdao = new YZjmxDAO();
			for (int i =1; i < nn; i++) {
				System.out.println(sheet.getCell(1, i).getContents().trim());
				UserInfo ui = uidao.findAllByName(sheet.getCell(1, i).getContents().trim());
				if(ui!=null)
				{
					YZjmx yz = new YZjmx();
					yz.setXh(check.IsNullInteger(sheet.getCell(0, i).getContents().trim()));
					yz.setName(sheet.getCell(1, i).getContents().trim());
					yz.setNo(ui.getNo891());
					yz.setGdnumber(sheet.getCell(2, i).getContents().trim());
					yz.setLzxh(check.IsNullInteger(sheet.getCell(3, i).getContents().trim()));
					yz.setDate(sheet.getCell(4, i).getContents().trim().substring(0, 10).replace("-",""));
					yz.setCjdf(check.IsNullInteger(sheet.getCell(5, i).getContents().trim()));
					yz.setZjrw(sheet.getCell(6, i).getContents().trim());
					yz.setFjdf(check.IsNullInteger(sheet.getCell(7, i).getContents().trim()));
					yzdao.merge(yz);
				}
			}
			trans.commit();
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
	         session.flush();
	         session.clear();
	         session.close();
		}
		message = "导入成功";
		return "success";
	}
	/*delete表*/
	public void delete(Session session, String table)
	{
		Query queryObject = session.createSQLQuery("truncate "+ table);
		queryObject.executeUpdate();
	}
}
