package work.rulecase.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcRule;
import work.util.FileOperation;
import work.util.Tld;
import work.util.YearSeason;
import work.util.ZipUtil;
import ccb.hibernate.HibernateSessionFactory;

public class RuleAdd {
	private String plate;
	private String pool;
	private String part;
	private String area;
	private String factor;
	private String facA;
	private String facB;
	private String facC;
	private String facAName;
	private String facBName;
	private String facCName;
	private String rule;
	private String exp;
	private String remark;
	private String renewexp;
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getFacA() {
		return facA;
	}

	public void setFacA(String facA) {
		this.facA = facA;
	}

	public String getFacB() {
		return facB;
	}

	public void setFacB(String facB) {
		this.facB = facB;
	}

	public String getFacC() {
		return facC;
	}

	public void setFacC(String facC) {
		this.facC = facC;
	}

	public String getFacAName() {
		return facAName;
	}

	public void setFacAName(String facAName) {
		this.facAName = facAName;
	}

	public String getFacBName() {
		return facBName;
	}

	public void setFacBName(String facBName) {
		this.facBName = facBName;
	}

	public String getFacCName() {
		return facCName;
	}

	public void setFacCName(String facCName) {
		this.facCName = facCName;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRenewexp() {
		return renewexp;
	}

	public void setRenewexp(String renewexp) {
		this.renewexp = renewexp;
	}

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
		
		String realpath = Tld.rulecasepath+"rule/image/";
		message = "新增成功";
		RcRuleDAO rrdao = new RcRuleDAO();
		YearSeason ys = new YearSeason();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
				RcRule rr = new RcRule();
				rr.setPlate(plate);
				rr.setPool(pool);
				rr.setPart(part);
				rr.setArea(area);
				rr.setFactor(factor);
				rr.setFacA(facA);
				rr.setFacB(facB);
				rr.setFacC(facC);
				rr.setFacAName(facAName);
				rr.setFacBName(facBName);
				rr.setFacCName(facCName);
				rr.setRenewdate(ys.getStringDate());
				rr.setRule(rule);
				rr.setExp(exp);
				rr.setRemark(remark);
				rr.setRenewexp(renewexp);
				if(file!=null)
				{
					rr.setPicname(fileFileName);
				}
				else
				{
					rr.setPicname("");
				}
				rrdao.merge(rr);
		}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		if (file != null) {
			File savefile = new File(new File(realpath), fileFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(file, savefile);
		}
		return "success";
	}
}
