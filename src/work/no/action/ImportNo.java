package work.no.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import work.internal.action.Internal;
import work.no.dao.NoDAO;
import work.no.dao.NoLogDAO;
import work.no.pojo.No;
import work.no.pojo.NoLog;
import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.Tld;
import work.util.YearSeason;

import ccb.hibernate.HibernateSessionFactory;

public class ImportNo {
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String oname;
    
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

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String execute() throws Exception
	{
		NoExpress ne = new NoExpress();
		UserInfoDAO uidao = new UserInfoDAO();
		NoLogDAO nldao = new NoLogDAO();
		YearSeason ys = new YearSeason();
    	int nn=0;
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
		ne.express(realpath+ys.getDateTime()+"backup.xls", "",2);
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	delete(session,"t_no");
		try {
			
			Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
			
        	NoDAO nodao = new NoDAO();
        	for (int i = 1; i < nn; i++) {
        		No no = new No();
        		//int team = Tld.teamToTnteger(sheet.getCell(19, i).getContents().trim());
        		int chu = Tld.cToInteger(sheet.getCell(18, i).getContents().trim());
        		String newn = sheet.getCell(2, i).getContents().trim();
        		newn=Tld.NewnumberToStandard(newn);
        		String no891 = sheet.getCell(15, i).getContents().trim();
        		if(no891.length()>4)
        		{
        			no891=Tld.NewnumberToStandard(no891);
        		}
        		no.setName(sheet.getCell(1, i).getContents().trim());
        		no.setNewnumber(newn);
        		no.setSex(NoUtil.SexToInteger(sheet.getCell(3, i).getContents().trim()));
        		no.setIdentity(sheet.getCell(4, i).getContents().trim());
        		no.setTel(sheet.getCell(5, i).getContents().trim());
        		no.setRole(sheet.getCell(6, i).getContents().trim());
        		
        		no.setZx(Tld.zxToInteger(sheet.getCell(8, i).getContents().trim()));
        		no.setXz(Tld.xzToInteger(sheet.getCell(9, i).getContents().trim()));
        		if(!sheet.getCell(10, i).getContents().trim().isEmpty())
        			no.setXzwh(Integer.valueOf(sheet.getCell(10, i).getContents().trim()));
        		if(!sheet.getCell(11, i).getContents().trim().isEmpty())
        			no.setXzjh(Integer.valueOf(sheet.getCell(11, i).getContents().trim()));
        		if(!sheet.getCell(12, i).getContents().trim().isEmpty())
        			no.setXzsh(Integer.valueOf(sheet.getCell(12, i).getContents().trim()));
        		if(!sheet.getCell(13, i).getContents().trim().isEmpty())
        			no.setXzjy(Integer.valueOf(sheet.getCell(13, i).getContents().trim()));
        		no.setComedate(sheet.getCell(14, i).getContents().trim());
        		no.setNo891(no891);
        		no.setNo895(no891);
        		no.setNo1(sheet.getCell(16, i).getContents().trim());
        		no.setNo2(sheet.getCell(17, i).getContents().trim());
        		no.setChu(chu);
        		no.setTeam(sheet.getCell(19, i).getContents().trim());
        		no.setSource(sheet.getCell(20, i).getContents().trim());
        		no.setSchedeam(1);
        		System.out.println(no.getNo891());
        		if((no.getName()==null)||(no.getSex()==null)||(no.getZx()==null)||(no.getXz()==null)||((no.getNo891()+no.getNo895()).length()<3))
        		{
        			int j=i+1;
        			message="导入失败，第"+j+"行数据中姓名、性别、中心、性质、工号为必填项,请补充要素后重新导入";
        			trans.rollback();
        			//NoLog nl = new NoLog("导入失败","导入失败",0,"导入失败","导入失败","导入失败","导入失败", ys.getDateTime(),"导入失败，第"+j+"行数据中姓名、性别、中心、性质、工号为必填项,请补充要素后重新导入", "", "");
        			//nldao.saveWithTrans(nl);
        			return "failed";
        		}
        		if(no.getName().equals("李倩"))
        		{
        			System.out.println("11");
        		}
//        		if((team>0)&&(uidao.findAllByNo891(no.getNo891()).size()>0))
//        		{
//        			System.out.println("----"+team);
//        			UserInfo ui = (UserInfo) uidao.findByNo891(no.getNo891()).get(0);
//        			String tempp = "31"+String.valueOf(chu)+"0"+String.valueOf(team);
//        			ui.setPosition(tempp);
//        			no.setPosition(tempp);
//            		//更新user_info 的组别
//            		uidao.merge(ui);
//        		}
        		if(!sheet.getCell(7, i).getContents().trim().isEmpty())
        		{
        			no.setPosition(sheet.getCell(7, i).getContents().trim());
        			if(uidao.findAllByNo891(no.getNo891()).size()>0)
        			{
        				UserInfo ui = (UserInfo) uidao.findByNo891(no.getNo891()).get(0);
        				no.setPosition(sheet.getCell(7, i).getContents().trim());
        				ui.setPosition(sheet.getCell(7, i).getContents().trim());
                		//更新user_info 的组别
                		uidao.merge(ui);
        			}
        		}
        		nodao.merge(no);
        	}
        	NoLog no = new NoLog("批量导入","批量导入",0,"批量导入","批量导入","批量导入",oname, ys.getDateTime(),"导入成功", "", "");
        	nldao.save(no);
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
		Query queryObject = session.createSQLQuery("delete from "+ table);
		queryObject.executeUpdate();
	}
	
}
