package work.rulecase.action.hegui;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.Transaction;
import work.rulecase.action.RuleImport;
import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcRule;
import work.util.Tld;
import work.util.UploadUtil;
import work.util.YearSeason;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class RuleHgImport {
	private static Logger logger = Logger.getLogger(RuleImport.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String type;
    private String pool;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
	public String execute() throws Exception{
		int nn=0;
		String zy = "";
		YearSeason ys = new YearSeason();
		RcRuleDAO rrdao = new RcRuleDAO();
		String realpath = Tld.uploadpath+"rulecase/";
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
			if(type.equals("fugai"))//如果选择的是覆盖，先删除原表
			{
				if(pool.equals("shbz"))
				{
					String sql = "delete from t_rc_rule where plate='合规业务' and pool='1'";
					session.createSQLQuery(sql).executeUpdate();
				}
				else if(pool.equals("fhcy"))
				{
					String sql = "delete from t_rc_rule where plate='合规业务' and pool='2'";
					session.createSQLQuery(sql).executeUpdate();
				}
				else if(pool.equals("yjbf"))
				{
					String sql = "delete from t_rc_rule where plate='合规业务' and pool='3'";
					session.createSQLQuery(sql).executeUpdate();
				}
				
			}
			for (int i = 1; i < nn; i++) {
				RcRule rr = new RcRule();
				Row currentRow = sheet.getRow(i);// 当前行
				if(currentRow!=null)
				{
					rr.setRenewdate(date);
					rr.setPlate("合规业务");
					if(pool.equals("shbz"))
					{
						rr.setPool("1");
						rr.setPart(uu.getCellValue(currentRow.getCell(0), 0));
						rr.setArea(uu.getCellValue(currentRow.getCell(1), 0));
						rr.setRemark(uu.getCellValue(currentRow.getCell(2), 0));
						rr.setRule(uu.getCellValue(currentRow.getCell(3), 0));
						rr.setFacB(uu.getCellValue(currentRow.getCell(5), 0));
						rr.setFacC(uu.getCellValue(currentRow.getCell(6), 0));
						zy = uu.getCellValue(currentRow.getCell(7), 0).trim();
					}
					else if(pool.equals("fhcy"))
					{
						rr.setPool("2");
						rr.setPart(uu.getCellValue(currentRow.getCell(0), 0));
						rr.setArea(uu.getCellValue(currentRow.getCell(1), 0));
						rr.setRemark(uu.getCellValue(currentRow.getCell(2), 0));
						rr.setRule(uu.getCellValue(currentRow.getCell(3), 0));
						rr.setExp(uu.getCellValue(currentRow.getCell(4), 0));
						rr.setFactor(uu.getCellValue(currentRow.getCell(5), 0));
						rr.setFacB(uu.getCellValue(currentRow.getCell(6), 0));
						rr.setFacC(uu.getCellValue(currentRow.getCell(7), 0));
						zy = uu.getCellValue(currentRow.getCell(8), 0).trim();
						
					}
					else if(pool.equals("yjbf"))
					{
						rr.setPool("3");
						rr.setFactor(uu.getCellValue(currentRow.getCell(1), 0));
						rr.setPart(uu.getCellValue(currentRow.getCell(2), 0));
						rr.setArea(uu.getCellValue(currentRow.getCell(3), 0));
						rr.setFacC(uu.getCellValue(currentRow.getCell(4), 0));
						rr.setFacB(uu.getCellValue(currentRow.getCell(5), 0));
						rr.setFujian(uu.getCellValue(currentRow.getCell(6), 0));
						rr.setRule(uu.getCellValue(currentRow.getCell(7), 0));
						rr.setExp(uu.getCellValue(currentRow.getCell(8), 0));
						rr.setRemark(uu.getCellValue(currentRow.getCell(9), 0));
						zy="在用";
					}
					
					if(zy.equals("在用"))
					{
						rr.setFacA("1");
					}
					else
					{
						rr.setFacA("0");
					}
					
					if(zy!=null&&!zy.equals(""))
					rrdao.merge(rr);
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
