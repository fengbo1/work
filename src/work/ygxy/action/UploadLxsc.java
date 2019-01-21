package work.ygxy.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.GeneralCheck;
import work.ygxy.dao.LxscDAO;
import work.ygxy.dao.YPbmxDAO;
import work.ygxy.dao.YgxyDAO;
import work.ygxy.pojo.Lxsc;
import work.ygxy.pojo.YPbmx;
import work.ygxy.pojo.Ygxy;
import ccb.hibernate.HibernateSessionFactory;

/**
 * 导入离线时长表
 * @author htzx
 *
 */
public class UploadLxsc {

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
			//GeneralCheck check = new GeneralCheck();
			LxscDAO lxscdao = new LxscDAO();
			YgxyDAO ygxydao = new YgxyDAO();
			for (int i =1; i < nn; i++) {
				Lxsc lxsc = lxscdao.findAllByDateAndName(sheet.getCell(0, i).getContents().trim(), sheet.getCell(1, i).getContents().trim());
				UserInfo ui = uidao.findAllByName(sheet.getCell(1, i).getContents().trim());
				lxsc.setDate(sheet.getCell(0, i).getContents().trim());
				lxsc.setName(sheet.getCell(1, i).getContents().trim());
				lxsc.setReason(sheet.getCell(2, i).getContents().trim());
				lxsc.setShichang(Double.parseDouble(sheet.getCell(3, i).getContents().trim()));
				lxsc.setYouxiao(Integer.parseInt(sheet.getCell(4, i).getContents().trim()));
				lxscdao.merge(lxsc);
				//更新员工响应日报表
				Ygxy ygxy = ygxydao.findAllByDateAndName(lxsc.getDate(),lxsc.getName());
				if(lxsc.getYouxiao()==1)
				{
					ygxy.setLxsc(lxsc.getShichang());
				}
				else
				{
					ygxy.setLxsc(0.0);
				}
				ygxydao.merge(ygxy);
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
