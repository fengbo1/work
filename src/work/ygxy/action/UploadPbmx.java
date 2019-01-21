package work.ygxy.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.GeneralCheck;
import work.util.Tld;
import work.ygxy.dao.YPbmxDAO;
import work.ygxy.dao.YZjmxDAO;
import work.ygxy.dao.YgxyDAO;
import work.ygxy.pojo.YPbmx;
import work.ygxy.pojo.YZjmx;
import work.ygxy.pojo.Ygxy;
import ccb.hibernate.HibernateSessionFactory;

public class UploadPbmx {

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
    	try {
			Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
			YPbmxDAO ypdao = new YPbmxDAO();
			YgxyDAO ygxydao = new YgxyDAO();
			GeneralCheck check = new GeneralCheck();
			for (int i =1; i < nn; i++) {
				YPbmx yp = ypdao.findAllByDateAndName(sheet.getCell(0, i).getContents().trim(), sheet.getCell(1, i).getContents().trim());
				UserInfo ui = uidao.findAllByName(sheet.getCell(1, i).getContents().trim());
				System.out.println(sheet.getCell(1, i).getContents().trim());
				yp.setDate(sheet.getCell(0, i).getContents().trim());
				yp.setName(sheet.getCell(1, i).getContents().trim());
				yp.setNo(ui.getNo891());
				yp.setIfsb(check.IsNullInteger(sheet.getCell(2, i).getContents().trim()));
				yp.setIflh(check.IsNullInteger(sheet.getCell(3, i).getContents().trim()));
				yp.setIfgd(check.IsNullInteger(sheet.getCell(4, i).getContents().trim()));
				yp.setType(check.IsNullInteger(sheet.getCell(5, i).getContents().trim()));
				ypdao.merge(yp);
				
				//更新员工响应日报表
				Ygxy ygxy = ygxydao.findAllByDateAndName(yp.getDate(),yp.getName());
				if(yp.getIfsb()==1)
				{
					if(yp.getIfgd()==1)//如果做了工单
					{
						if(yp.getIflh()==1)//有例会
						{
							ygxy.setGzsc(6.25);
						}
						else
						{
							ygxy.setGzsc(6.75);
						}
					}
//					else
//					{
//						ygxy.setGzsc(Tld.timeStringToDouble(ygxy.getFtDlsc()));
//					}
					ygxy.setZysc(check.IsNullDouble(ygxy.getGzsc())-check.IsNullDouble(ygxy.getLxsc()));
					ygxy.setXyqqzsl(check.DoubleTo2(check.division(ygxy.getGdl(),ygxy.getZysc())));
					ygxydao.merge(ygxy);
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
}
