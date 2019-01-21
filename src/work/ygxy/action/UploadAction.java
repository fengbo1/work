package work.ygxy.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

//文件上传Action
public class UploadAction extends ActionSupport {
	
	//String path1="C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/work";
	//String path2="C:\\Program Files\\Apache Software Foundation/Tomcat 7.0\\webapps\\work";
	String path1 = "D:/import/work/";
	
	//上传文件存放路径
	private final static String UPLOADDIR = "E:/upload/upload_ygxy";
	//上传文件集合
	private List<File> file;
	//上传文件名集合
	private List<String> fileFileName;
	//上传文件内容类型集合
	private List<String> fileContentType;

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String execute() throws Exception {
		
		
		String name1="";
		String filename="";
		if(file!=null)
		{
			for (int i = 0; i < file.size(); i++) 
			{
				//循环上传每个文件
				if (i==0){
				name1=uploadFile(i);
				}
				/*if (i==1){
					name2=uploadFile(i);
				}
				if (i==2){
					name3=uploadFile(i);
				}
				if (i==3){
					name4=uploadFile(i);
				}*/
			
			}
		}else{}
		
		;
		//解析文件名name1的excel文件 并按字段写入数据库
		boolean  a  = name1.matches("(.*)AgentView(.*)");
		boolean  b  = name1.matches("(.*)员工响应坐席工作情况日报(.*)");
		boolean  c  = name1.matches("(.*)员工响应主管工作情况日报(.*)");
		
		String file_k="";
		if (a==false&&b==true&&c==false){// 判断文件为员工响应坐席工作情况日报
			file_k="1";
		}else if(a==true&&b==false&&c==false){// 判断文件为AgentView*****视图
			file_k="2";
		}else if(a==false&&b==false&c==true){// 判断文件为员工响应主管工作情况日报
			file_k="3";
		}else if(a==false&&b==false&c==false){
			
		}
		
		RoleFileUploadAction rfu=new RoleFileUploadAction();
		
		rfu.loadRoleInfo(name1,file_k);
	
		delItems();//删除某些记录
		System.out.println(name1);
		return "success";
	}

	//执行上传功能
	public String uploadFile(int i) throws FileNotFoundException, IOException {
		try {
			
			
			
			InputStream in = new FileInputStream(file.get(i));
		
			String dir=path1;
			File uploadFile = new File(dir,this.getFileFileName().get(i));
			
			System.out.println("上传文件名:"+this.getFileFileName().get(i));
	
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			
			return this.getFileFileName().get(i);
			
		   
						
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally{}
		return null;
	}
	public String delItems()
	{
		//删除郭红梅记录
		Session session=HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	Query query;
    	
    	String hql1="delete from y_day where name='郭红梅'";
    	session.createSQLQuery(hql1).executeUpdate();    	
    	trans.commit();
    	session.flush();
    	session.clear(); 
    	session.close(); 
    	
    	return "";
	}
}