package work.rulecase.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.dao.RcZlDAO;
import work.rulecase.pojo.RcZl;
import work.util.Tld;
import work.util.YearSeason;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class ZlImport {

	private static Logger logger = Logger.getLogger(ImgImport.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String zlname;
    private String rulecase;
    private int typetype;
    private int plate;
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
	public String getZlname() {
		return zlname;
	}
	public void setZlname(String zlname) {
		this.zlname = zlname;
	}
	public String getRulecase() {
		return rulecase;
	}
	public void setRulecase(String rulecase) {
		this.rulecase = rulecase;
	}
	public int getTypetype() {
		return typetype;
	}
	public void setTypetype(int typetype) {
		this.typetype = typetype;
	}
	public int getPlate() {
		return plate;
	}
	public void setPlate(int plate) {
		this.plate = plate;
	}
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
	public String execute() throws Exception{
		
		RcZlDAO rzdao = new RcZlDAO();
		YearSeason ys = new YearSeason();
		String realpath = Tld.rulecasepath+rulecase+"/doc/";
		message = "导入成功";
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			if (file != null) {
				File savefile = new File(new File(realpath), fileFileName);
				if (!savefile.getParentFile().exists())
					savefile.getParentFile().mkdirs();
				FileUtils.copyFile(file, savefile);
				RcZl rz = new RcZl();
				rz.setZlname(zlname);
				rz.setType(typetype);
				rz.setPlate(plate);
				rz.setPool(pool);
				rz.setFilename(fileFileName);
				rz.setDate(ys.getStringDate());
				rzdao.merge(rz);
			} else {
				ActionContext.getContext().put("message", "传入文件有误");
				message = "文件内容或格式有误";
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
