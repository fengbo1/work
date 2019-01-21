package work.control.action;

import java.io.File;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.JhsxDAO;
import work.control.pojo.Jhsx;
import work.hn.dao.HnJiheDAO;
import work.mycalendar.dao.MyCalendarDAO;
import work.mycalendar.pojo.MyCalendar;
import work.no.dao.NoDAO;
import work.util.GeneralCheck;
import work.util.UploadUtil;

import ccb.hibernate.HibernateSessionFactory;

public class ImportJhsx {
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
		GeneralCheck check = new GeneralCheck();
		JhsxDAO jdao = new JhsxDAO();
		MyCalendarDAO mcdao = new MyCalendarDAO();
		UploadUtil uu = new UploadUtil();
		String realpath = "D:/import/work/";
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
    	try {
    		org.apache.poi.ss.usermodel.Workbook workbook = null;
			// 获得第一个工作表对象
			workbook = uu.getWorkbook(realpath+fileFileName);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
			// 得到第一列第一行的单元格
			Row currentRow = sheet.getRow(2);
			String begindate = uu.getCellValue(currentRow.getCell(0), 0);
			String enddate = uu.getCellValue(currentRow.getCell(1), 0);
			List<MyCalendar> listmc = mcdao.findByBeginAndEnd(begindate, enddate, 2);
			if(!listmc.isEmpty()&&listmc.size()<30)
			{
				for(int i=0;i<listmc.size();i++)
				{
					MyCalendar mc = listmc.get(i);
					Jhsx j = jdao.findAllByDate(mc.getDate());
					j.setCdzwjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(2), 0)));
					j.setWhzwjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(3), 0)));
					j.setCdfzjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(4), 0)));
					j.setWhfzjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(5), 0)));
					j.setCdwhjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(6), 0)));
					j.setWhwhjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(7), 0)));
					j.setCdjhjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(8), 0)));
					j.setWhjhjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(9), 0)));
					j.setCdshjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(10), 0)));
					j.setWhshjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(11), 0)));
					j.setCdjyjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(12), 0)));
					j.setWhjyjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(13), 0)));
					jdao.merge(j);
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
		message = "导入成功";
		return "success";
	}
}
