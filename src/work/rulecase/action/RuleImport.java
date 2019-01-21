package work.rulecase.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import ccb.hibernate.HibernateSessionFactory;

import work.rulecase.dao.RcCaseDAO;
import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcCase;
import work.rulecase.pojo.RcRule;
import work.util.UploadUtil;
import work.util.YearSeason;

/**
 * 通用2003和2007
 * @author htzx
 *
 */
public class RuleImport {

	private static Logger logger = Logger.getLogger(RuleImport.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String rulecase;
    private String type;
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
	public String getRulecase() {
		return rulecase;
	}
	public void setRulecase(String rulecase) {
		this.rulecase = rulecase;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String execute() throws Exception{
		int nn=0;
		String plate = "";
		String temp = "";
		YearSeason ys = new YearSeason();
		RcRuleDAO rrdao = new RcRuleDAO();
		RcCaseDAO rcdao = new RcCaseDAO();
		String realpath = "D:/import/work/rulecase/";
		message = "导入成功";
		Workbook workbook = null;
		String date = ys.getStringDate();
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
			if(rulecase.equals("rule"))
			{
				if(type.equals("fugai"))//如果选择的是覆盖，先删除原表
				{
					String sql = "delete from t_rc_rule where plate in ('通用业务','外汇业务','建亚业务')";
					session.createSQLQuery(sql).executeUpdate();
				}
				for (int i = 1; i < nn; i++) {
					RcRule rr = new RcRule();
					Row currentRow = sheet.getRow(i);// 当前行
					if(currentRow!=null)
					{
						rr.setRenewdate(date);
						plate = uu.getCellValue(currentRow.getCell(0), 0);
						rr.setPlate(plate);
						rr.setPool(uu.getCellValue(currentRow.getCell(1), 0));
						rr.setPart(uu.getCellValue(currentRow.getCell(2), 0));
						rr.setArea(uu.getCellValue(currentRow.getCell(3), 0));
						rr.setFactor(uu.getCellValue(currentRow.getCell(4), 0));
						rr.setFacAName(uu.getCellValue(currentRow.getCell(5), 0));
						rr.setFacA(uu.getCellValue(currentRow.getCell(6), 0));
						rr.setFacBName(uu.getCellValue(currentRow.getCell(7), 0));
						rr.setFacB(uu.getCellValue(currentRow.getCell(8), 0));
						rr.setFacCName(uu.getCellValue(currentRow.getCell(9), 0));
						rr.setFacC(uu.getCellValue(currentRow.getCell(10), 0));
						rr.setRule(uu.getCellValue(currentRow.getCell(11), 0));
						rr.setPicname(uu.getCellValue(currentRow.getCell(12), 0));
						rr.setExp(uu.getCellValue(currentRow.getCell(13), 0));
						rr.setRemark(uu.getCellValue(currentRow.getCell(14), 0));
						if(plate!=null&&!plate.equals(""))
						rrdao.merge(rr);
					}
				}
			}
			else
			{
				if(type.equals("fugai"))//如果选择的是覆盖，先删除原表
				{
					String sql = "truncate t_rc_case";
					session.createSQLQuery(sql).executeUpdate();
				}
				for (int i = 1; i < nn; i++) {
					RcCase rc = new RcCase();
					Row currentRow = sheet.getRow(i);// 当前行
					if(currentRow!=null)
					{
						rc.setRenewdate(date);
						plate = uu.getCellValue(currentRow.getCell(0), 0);
						rc.setPlate(plate);
						rc.setPool(uu.getCellValue(currentRow.getCell(1), 0));
						temp = uu.getCellValue(currentRow.getCell(2), 0);
						rc.setPart(temp);
						rc.setFactor(uu.getCellValue(currentRow.getCell(3), 0));
						rc.setFacAName(uu.getCellValue(currentRow.getCell(4), 0));
						rc.setFacA(uu.getCellValue(currentRow.getCell(5), 0));
						rc.setFacBName(uu.getCellValue(currentRow.getCell(6), 0));
						rc.setFacB(uu.getCellValue(currentRow.getCell(7), 0));
						rc.setFacCName(uu.getCellValue(currentRow.getCell(8), 0));
						rc.setFacC(uu.getCellValue(currentRow.getCell(9), 0));
						rc.setRule(uu.getCellValue(currentRow.getCell(10), 0));
						rc.setPicname(uu.getCellValue(currentRow.getCell(11), 0));
						rc.setExp(uu.getCellValue(currentRow.getCell(12), 0));
						rc.setRemark(uu.getCellValue(currentRow.getCell(13), 0));
						if(plate!=null&&!plate.equals(""))
						rcdao.merge(rc);
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

