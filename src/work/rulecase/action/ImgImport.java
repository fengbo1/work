package work.rulecase.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import work.util.Tld;
import work.util.ZipUtil;

import com.opensymphony.xwork2.ActionContext;

/**
 * 上传图片，rar格式压缩
 * @author htzx
 *
 */
public class ImgImport {
	private static Logger logger = Logger.getLogger(ImgImport.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String rulecase;
    private String test;
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
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String execute() throws Exception{
		
		ZipUtil zu = new ZipUtil();
		String realpath = Tld.rulecasepath+rulecase+"/image/";
		message = "导入成功";
		if (file != null) {
			File savefile = new File(new File(realpath), fileFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(file, savefile);
		} else {
			ActionContext.getContext().put("message", "传入文件有误");
			message = "文件内容或格式有误";
		}
		if(fileFileName.endsWith("zip"))
		{
			zu.upzipFile(realpath+fileFileName,realpath);
		}
		return "success";
	}
}
