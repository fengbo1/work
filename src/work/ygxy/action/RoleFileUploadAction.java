package work.ygxy.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import work.userinfo.pojo.UserInfo;
import work.util.Tld;
import work.ygxy.dao.YgxyDAO;
import work.ygxy.pojo.Ygxy;



import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;
public class RoleFileUploadAction extends ActionSupport{
/**
	 * 把Excele表读出的数据，组装成一个List,统一导入数据库
	 * @param uploadFileFileName
	 */
	//String path1="C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/work";
	//String path2="C:\\Program Files\\Apache Software Foundation/Tomcat 7.0\\webapps\\work";
	String path1 = "D:/import/work/";
	public void loadRoleInfo(String uploadFileFileName,String file_k){
		String directory = path1; 
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		File target = new File(directory,uploadFileFileName);
		//List roleList = new ArrayList();
		//ArrayList<Upload> roleList = new ArrayList();
		
		if (file_k.equals("2")){//AgentView*****视图
		try{		
			
			Ygxy yy=new Ygxy();
			Ygxy yyy=new Ygxy();
			FileInputStream fi = new FileInputStream(target);
			Workbook wb = new HSSFWorkbook(fi);
			Sheet sheet = wb.getSheetAt(0);
			int[] arr={5,6,10,17,18,19,20,23};
			int[] brr={0,3,3,3,3,3,3,3};
			int rowNum = sheet.getLastRowNum()+1;			
			for(int i=0;(i*21)+5<rowNum;i++){
				for(int j=0;j<8;j++){
					String ccellValue = null;
					SimpleDateFormat sdff = null;
					sdff = new SimpleDateFormat("yyyyMMdd");
					Row rrow=sheet.getRow(4);
					Cell ccell = rrow.getCell(3);
					ccellValue = String.valueOf(ccell.getDateCellValue());							
					ccellValue = sdff.format(ccell.getDateCellValue());  
					yy.setDate(ccellValue);
					
					
					Row row = sheet.getRow(arr[j]+(i*21));					
					//int cellNum = row.getLastCellNum();
					Cell cell = row.getCell(brr[j]);
					System.out.println("("+(arr[j]+(i*21)+1)+","+(brr[j]+1)+")");
					String cellValue = null;
					int intcellValue = 0;
					double doublecellValue = 0.0;
					SimpleDateFormat sdf = null;
					sdf = new SimpleDateFormat("HH:mm:ss");
					/*
					switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
						case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
						case 1 : cellValue = cell.getStringCellValue(); break;
						case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
						case 3 : cellValue = ""; break;
						case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
						case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
					}
					*/
					switch(j){//通过列数来判断对应插如的字段
						case 0 : {
							cellValue = cell.getStringCellValue();
							cellValue=cellValue.substring(8, (cellValue.length()-1));
							yy.setName(cellValue);break;
						}
						case 1 : {
							intcellValue=(int)cell.getNumericCellValue();							
							//yy.setOutcall(cellValue);
							yy.setFtHcdhs(intcellValue);//呼出电话数
						}break;
						case 2 : {							
							cellValue = String.valueOf(cell.getDateCellValue());							
							cellValue = sdf.format(cell.getDateCellValue());  
							//yy.setSumontime(cellValue);
							yy.setFtDlsc(cellValue);
						}break;
						case 3 : {
							cellValue = String.valueOf(cell.getDateCellValue());							
							cellValue = sdf.format(cell.getDateCellValue());
							//yy.setAvgincalltime(cellValue);
							yy.setFtPjydsc(cellValue);
						}break;
						case 4 : {
							cellValue = String.valueOf(cell.getDateCellValue());							
							cellValue = sdf.format(cell.getDateCellValue());  
							//yy.setAvgoutcalltime(cellValue);
							yy.setFtPjhcsc(cellValue);
						}break;
						case 5 : {
							cellValue=String.valueOf((int)cell.getNumericCellValue());	
							cellValue=change(Integer.parseInt(cellValue));
							//yy.setAvgafterworktime(cellValue);
							yy.setFtPjshsc(cellValue);
						}break;
						case 6 : {
							cellValue = String.valueOf(cell.getDateCellValue());							
							cellValue = sdf.format(cell.getDateCellValue());  
							//yy.setAvgworktime(cellValue);
							yy.setFtPjclsc(cellValue);
							yy.setFtPjclscd(Tld.timeStringToDouble(cellValue));
						}break;
						case 7 : {
							doublecellValue=cell.getNumericCellValue();	
							//yy.setPerrest(cellValue);
							yy.setFtXxlv(doublecellValue);
						}break;
						
					}
				yy.setPosition(findpositionbyname(yy.getName()));
				}		
				
				int idd=findidbydatename(yy.getDate(),yy.getName());		
				if (idd!=0){
					
					yyy=findbyid(idd);
					//yyy.setId(idd);
					yyy.setName(yy.getName());
					yyy.setFtHcdhs(yy.getFtHcdhs());
					yyy.setFtDlsc(yy.getFtDlsc());
					yyy.setFtPjydsc(yy.getFtPjydsc());
					yyy.setFtPjhcsc(yy.getFtPjhcsc());
					yyy.setFtPjshsc(yy.getFtPjshsc());
					yyy.setFtPjclsc(yy.getFtPjclsc());
					yyy.setFtPjclscd(yy.getFtPjclscd());
					yyy.setFtXxlv(yy.getFtXxlv());
					yyy.setPosition(yy.getPosition());
				}else if(idd==0){
					yyy=yy;
				}
				Session se;
				Transaction tr;
				se = HibernateSessionFactory.getSession();
				tr = se.beginTransaction();
				
				try{
				
					if(idd==0){
						YgxyDAO dao=new YgxyDAO();
						yy.setFeDrjsl(yto0(yy.getFeDrjsl()));
						yy.setFeYjdfl(yto0(yy.getFeYjdfl()));
						yy.setSteDrjsl(yto0(yy.getSteDrjsl()));
						yy.setSteEjdfl(yto0(yy.getSteEjdfl()));
						yy=countGdlAndGzsc(dao,yy);
						dao.merge(yy);
						System.out.println("已导入"+yy.getName()+yy.getPosition());
					}
					if(idd!=0){
				YgxyDAO dao=new YgxyDAO();
				yyy.setFeDrjsl(yto0(yyy.getFeDrjsl()));
				yyy.setFeYjdfl(yto0(yyy.getFeYjdfl()));
				yyy.setSteDrjsl(yto0(yyy.getSteDrjsl()));
				yyy.setSteEjdfl(yto0(yyy.getSteEjdfl()));
				yyy=countGdlAndGzsc(dao,yyy);
				dao.merge(yyy);
				System.out.println("已导入"+yyy.getName()+yyy.getPosition());
					}
		
					//计算响应折算量
					
				}
				finally{
					tr.commit();
					se.flush();
					se.clear();
					se.close();}
			
			
			}

			}			
			catch(IOException e){
			e.printStackTrace();
			}
		}
		if (file_k.equals("1")){//员工响应坐席工作情况日报
			try{		
				Ygxy yyy=new Ygxy();
				Ygxy yy=new Ygxy();
				FileInputStream fi = new FileInputStream(target);
				Workbook wb = new HSSFWorkbook(fi);
				Sheet sheet = wb.getSheetAt(0);				
				int[] brr={3,28,13,19,22,16,5,8,20,23,17,4,10,25,11,26};
				int rowNum = sheet.getLastRowNum()+1;			
				for(int i=5;i<rowNum-5;i++){
					for(int j=0;j<16;j++){
						String ccellValue = null;
						SimpleDateFormat sdff = null;
						sdff = new SimpleDateFormat("yyyyMMdd");
						Row rrow=sheet.getRow(5);
						Cell ccell = rrow.getCell(1);
						//ccellValue = String.valueOf(ccell.getDateCellValue());							
						ccellValue = String.valueOf(ccell.getStringCellValue());	
						//ccellValue = sdff.format(ccell.getDateCellValue());  
						
						yy.setDate(ccellValue);
						
						
						Row row = sheet.getRow(i);					
						int cellNum = row.getLastCellNum();
						Cell cell = row.getCell(brr[j]);
						System.out.println("("+(i+1)+","+(brr[j]+1)+")");
						String cellValue = null;
						int intcellvalue = 0;
						double doublecellvalue= 0.0;
						SimpleDateFormat sdf = null;
						sdf = new SimpleDateFormat("HH:mm:ss");
						switch(j){//通过列数来判断对应插如的字段
							case 0 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
								case 1 : cellValue = cell.getStringCellValue(); break;
								case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
								case 3 : cellValue = ""; break;
								case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
								case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
							}
								//cellValue = cell.getStringCellValue();								
								yy.setName(cellValue);break;
							}
							case 1 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFtFeiql(intcellvalue);
							}break;
							case 2 : {	
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFtTdwzjl(intcellvalue);
							}break;
							case 3 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFtTbjpl(intcellvalue);
							}break;
							case 4 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFtGdjll(intcellvalue);
							}break;
							case 5 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFtYjdfl(intcellvalue);
							}break;
							case 6 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFeDrjsl(intcellvalue);
							}break;
							case 7 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : cellValue = String.valueOf(cell.getNumericCellValue()); break;
								case 1 : cellValue = cell.getStringCellValue(); break;
								case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
								case 3 : cellValue = ""; break;
								case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
								case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());	
								double tempnumber=Double.parseDouble(cellValue)*60;								
								cellValue=change((int)tempnumber);
								
								yy.setFeYjpjclsc(cellValue);//?
								yy.setFeYjpjclscd(Tld.timeStringToDouble(cellValue));
							}break;
							case 8 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFeTbjpl(intcellvalue);
							}break;
							case 9 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFeGdjll(intcellvalue);
							}break;
							case 10 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFeYjdfl(intcellvalue);
							}break;
							case 11 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFtYddh(intcellvalue);
							}break;
							case 12 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFtSjl(intcellvalue);
							}break;
							case 13 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFtFangql(intcellvalue);
							}break;
							case 14 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFeSjl(intcellvalue);
							}break;
							case 15 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setFeFangql(intcellvalue);
							}break;
						}
						if(yy.getFtYddh()!=null&&yy.getFtYddh()!=0&&yy.getFtYjdfl()!=null){//电话一级答复率计算
						double temp=((double)yy.getFtYjdfl())/(double)yy.getFtYddh()*100;
						
						BigDecimal b=new BigDecimal(temp);  
						double f1 =b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 
						//String cells=f1+"";						
						yy.setFtYjdflv(f1);
						}
						
						if(yy.getFeDrjsl()!=null&&yy.getFeDrjsl()!=0&&yy.getFeYjdfl()!=null){//电子工单一级答复率计算
						double temp=((double)yy.getFeYjdfl())/((double)yy.getFeDrjsl())*100;
						BigDecimal b=new BigDecimal(temp);  
						double f1 =b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 
						//String cells=f1+"";						
						yy.setFeYjdflv(f1);
							}
						yy.setPosition(findpositionbyname(yy.getName()));
					}
					int idd=0;
					idd=findidbydatename(yy.getDate(),yy.getName());		
					if (idd!=0){
						yyy=findbyid(idd);
						//yyy.setId(idd);
						yyy.setName(yy.getName());
						yyy.setFtFeiql(yy.getFtFeiql());
						yyy.setFtTdwzjl(yy.getFtTdwzjl());
						yyy.setFtTbjpl(yy.getFtTbjpl());
						yyy.setFtGdjll(yy.getFtGdjll());
						yyy.setFtYjdfl(yy.getFtYjdfl());
						yyy.setFeDrjsl(yy.getFeDrjsl());
						yyy.setFeYjpjclsc(yy.getFeYjpjclsc());
						yyy.setFeYjpjclscd(yy.getFeYjpjclscd());
						yyy.setFeTbjpl(yy.getFeTbjpl());
						yyy.setFeGdjll(yy.getFeGdjll());
						yyy.setFeYjdfl(yy.getFeYjdfl());
						yyy.setFtYddh(yy.getFtYddh());
						yyy.setFtYjdflv(yy.getFtYjdflv());
						yyy.setFeYjdflv(yy.getFeYjdflv());
						yyy.setPosition(yy.getPosition());
						yyy.setFtSjl(yy.getFtSjl());
						yyy.setFtFangql(yy.getFtFangql());
						yyy.setFeSjl(yy.getFeSjl());
						yyy.setFeFangql(yy.getFeFangql());
					}
					else if(idd==0){
						yyy=yy;
					}
					Session se;
					Transaction tr;
					se = HibernateSessionFactory.getSession();
					tr = se.beginTransaction();
					
					try{
						if(idd==0){
							YgxyDAO dao=new YgxyDAO();						
							yy.setFeDrjsl(yto0(yy.getFeDrjsl()));
							yy.setFeYjdfl(yto0(yy.getFeYjdfl()));
							yy.setSteDrjsl(yto0(yy.getSteDrjsl()));
							yy.setSteEjdfl(yto0(yy.getSteEjdfl()));
							yy=countGdlAndGzsc(dao,yy);
							dao.merge(yy);
						}
						if(idd!=0){
					YgxyDAO dao=new YgxyDAO();
					yyy.setFeDrjsl(yto0(yyy.getFeDrjsl()));
					yyy.setFeYjdfl(yto0(yyy.getFeYjdfl()));
					yyy.setSteDrjsl(yto0(yyy.getSteDrjsl()));
					yyy.setSteEjdfl(yto0(yyy.getSteEjdfl()));
					yyy=countGdlAndGzsc(dao,yyy);
					dao.merge(yyy);
						}
				
					}
					finally{
						tr.commit();
						se.flush();
						se.clear();
						se.close();}
				
				
				}

				}			
				catch(IOException e){
				e.printStackTrace();
				}
			}
		if (file_k.equals("3")){//员工响应主管工作情况日报
			try{		
				Ygxy yyy=new Ygxy();
				Ygxy yy=new Ygxy();
				FileInputStream fi = new FileInputStream(target);
				Workbook wb = new HSSFWorkbook(fi);
				Sheet sheet = wb.getSheetAt(0);				
				int[] brr={4,7,10,28,31,25,16,13,34};
				int rowNum = sheet.getLastRowNum()+1;			
				for(int i=5;i<rowNum-5;i++){
					for(int j=0;j<9;j++){
						String ccellValue = null;
						SimpleDateFormat sdff = null;
						sdff = new SimpleDateFormat("yyyyMMdd");
						Row rrow=sheet.getRow(5);
						Cell ccell = rrow.getCell(2);
						//ccellValue = String.valueOf(ccell.getDateCellValue());							
						ccellValue = String.valueOf(ccell.getStringCellValue());	
						//ccellValue = sdff.format(ccell.getDateCellValue());  
						
						yy.setDate(ccellValue);
						
						
						Row row = sheet.getRow(i);					
						int cellNum = row.getLastCellNum();
						Cell cell = row.getCell(brr[j]);
						System.out.println("("+(i+1)+","+(brr[j]+1)+")");
						String cellValue = null;
						int intcellvalue = 0;
						double doublecellvalue= 0.0;
						SimpleDateFormat sdf = null;
						sdf = new SimpleDateFormat("HH:mm:ss");
						switch(j){//通过列数来判断对应插如的字段
							case 0 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
								case 1 : cellValue = cell.getStringCellValue(); break;
								case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
								case 3 : cellValue = ""; break;
								case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
								case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
							}
								//cellValue = cell.getStringCellValue();								
								yy.setName(cellValue);break;
							}
							case 1 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setSteDrjsl(intcellvalue);
							}break;
							case 2 : {	
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : cellValue = String.valueOf(cell.getNumericCellValue()); break;
								case 1 : cellValue = cell.getStringCellValue(); break;
								case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
								case 3 : cellValue = ""; break;
								case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
								case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								
								double tempnumber=Double.parseDouble(cellValue)*60;
								
								cellValue=change((int)tempnumber);
								
								yy.setSteEjpjclsc(cellValue);
								yy.setSteEjpjclscd(Tld.timeStringToDouble(cellValue));
							}break;
							case 3 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setSteTpjpl(intcellvalue);//退补截屏量
							}break;
							case 4 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setSteGdjll(intcellvalue);
							}break;
							case 5 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setSteEjdfl(intcellvalue);
							}break;
							case 6 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setSteZsjl(intcellvalue);
							}break;			
							case 7 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setSteNbzjl(intcellvalue);
							}break;	
							case 8 : {
								switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
								case 0 : intcellvalue = (int)cell.getNumericCellValue(); break;
								case 1 : intcellvalue = Integer.parseInt(cell.getStringCellValue()); break;
								case 2 : intcellvalue = Integer.parseInt(String.valueOf(cell.getDateCellValue())); break;
								case 3 : intcellvalue = 0; break;
								case 4 : intcellvalue = Integer.parseInt(String.valueOf(cell.getBooleanCellValue())); break;
								case 5 : intcellvalue = Integer.parseInt(String.valueOf(cell.getErrorCellValue())); break;
							}
								//cellValue=String.valueOf((int)cell.getNumericCellValue());							
								yy.setSteFangql(intcellvalue);
							}break;	
						}
						if(yy.getSteDrjsl()!=null&&yy.getSteDrjsl()!=0&&yy.getSteEjdfl()!=null){
							double temp=((double)yy.getSteEjdfl())/((double)yy.getSteDrjsl())*100;
							BigDecimal b=new BigDecimal(temp);  
							double f1 =b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 
							//String cells=f1+"";						
							yy.setSteEjdflv(f1);
							}
						if(yy.getSteDrjsl()!=null&&yy.getSteDrjsl()!=0&&yy.getSteZsjl()!=null){
							double temp=((double)yy.getSteZsjl())/((double)yy.getSteDrjsl())*100;
							BigDecimal b=new BigDecimal(temp);  
							double f1 =b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 
							//String cells=f1+"";					
							yy.setSteZsjlv(f1);
							}
						yy.setPosition(findpositionbyname(yy.getName()));
					}
					int idd=0;
					idd=findidbydatename(yy.getDate(),yy.getName());		
					if (idd!=0){
						yyy=findbyid(idd);
						//yyy.setId(idd);
						yyy.setName(yy.getName());
						yyy.setSteDrjsl(yy.getSteDrjsl());
						yyy.setSteEjpjclsc(yy.getSteEjpjclsc());
						yyy.setSteEjpjclscd(yy.getSteEjpjclscd());
						yyy.setSteTpjpl(yy.getSteTpjpl());
						yyy.setSteGdjll(yy.getSteGdjll());
						yyy.setSteEjdfl(yy.getSteEjdfl());
						yyy.setSteZsjl(yy.getSteZsjl());
						yyy.setSteEjdflv(yy.getSteEjdflv());
						yyy.setSteZsjlv(yy.getSteZsjlv());
						yyy.setPosition(yy.getPosition());
						yyy.setSteNbzjl(yy.getSteNbzjl());
						yyy.setSteFangql(yy.getSteFangql());
					}
					else if(idd==0){
						yyy=yy;
					}
					Session se;
					Transaction tr;
					se = HibernateSessionFactory.getSession();
					tr = se.beginTransaction();
					
					try{
						if(idd==0){
							YgxyDAO dao=new YgxyDAO();	
							yy.setFeDrjsl(yto0(yy.getFeDrjsl()));
							yy.setFeYjdfl(yto0(yy.getFeYjdfl()));
							yy.setSteDrjsl(yto0(yy.getSteDrjsl()));
							yy.setSteEjdfl(yto0(yy.getSteEjdfl()));
							yy=countGdlAndGzsc(dao,yy);
							dao.merge(yy);
						}
						if(idd!=0){
					YgxyDAO dao=new YgxyDAO();
					yyy.setFeDrjsl(yto0(yyy.getFeDrjsl()));
					yyy.setFeYjdfl(yto0(yyy.getFeYjdfl()));
					yyy.setSteDrjsl(yto0(yyy.getSteDrjsl()));
					yyy.setSteEjdfl(yto0(yyy.getSteEjdfl()));
					yyy=countGdlAndGzsc(dao,yyy);
					dao.merge(yyy);
						}
				
					}
					finally{
						tr.commit();
						se.flush();
						se.clear();
						se.close();}
				
				
				}

				}			
				catch(IOException e){
				e.printStackTrace();
				}
			}
	}
    public Integer findidbydatename(String date,String name) {
    	List<Ygxy> l=new ArrayList<Ygxy>();
    	Session session=HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	Query query;
    	
    	String hql1="from Ygxy as a where a.date=:nd and a.name=:na ";
    	query=session.createQuery(hql1);
    	query.setString("nd",date);
    	query.setString("na",name);
    	
    	l = query.list();          
    
    	trans.commit();
    	session.flush();
    	session.close();    	
    	if (l.size()==0){
    		return 0;
    	}
    	return l.get(0).getId();
    	
    }
    public String findzubyname(String name) {
    	List<UserInfo> l=new ArrayList<UserInfo>();
    	String zu="";
    	Session session=HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	Query query;
    	
    	String hql1="from UserInfo as a where a.username=:nd";
    	query=session.createQuery(hql1);
    	query.setString("nd",name);
    	
    	l = query.list();
    	if (l.size()>0){
    	 zu=l.get(0).getPosition().substring(4, 5);
    	}if (l.size()<1){
    	 zu="空";
    	}
    	trans.commit();
    	session.flush();
    	session.close();    	
    	return zu;
    	
    }
    public String findpositionbyname(String name) {
    	List<UserInfo> l=new ArrayList<UserInfo>();
    	String position="";
    	Session session=HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	Query query;
    	
    	String hql1="from UserInfo as a where a.username=:nd";
    	query=session.createQuery(hql1);
    	query.setString("nd",name);
    	
    	l = query.list();
    	if (l.size()>0){
    		position=l.get(0).getPosition();
    	}if (l.size()<1){
    		position="40300";
    	}
    	trans.commit();
    	session.flush();
    	session.close();    	
    	return position;
    	
    }
    public Ygxy findbyid(int id) {
    	List<Ygxy> l=new ArrayList<Ygxy>();
    	Session session=HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	Query query;
    	
    	String hql1="from Ygxy as a where a.id=:nd";
    	query=session.createQuery(hql1);    	
    	query.setLong("nd", id);
    	
    	l = query.list();          
    
    	trans.commit();
    	session.flush();
    	session.clear(); 
    	session.close(); 
    	return l.get(0);
    }
    public String yto0(String str) {
    	if(str==null){
    		str="0";
    	}
    	return str;
    }
    public int yto0(Integer str) {
    	if(str==null){
    		str=0;
    	}
    	return str;
    }
    public static String change(int second){  
        int h = 0;  
        int d = 0;  
        int s = 0;  
        String ss="";
        String dd="";
        String hh="";
        int temp = second%3600;  
             if(second>3600){  
               h= second/3600;  
                    if(temp!=0){  
               if(temp>60){  
               d = temp/60;  
            if(temp%60!=0){  
               s = temp%60;  
            }  
            }else{  
               s = temp;  
            }  
           }  
          }else{  
              d = second/60;  
           if(second%60!=0){  
              s = second%60;  
           }  
          }  
             if(d<10){
            	  dd="0"+d;
             }else if(d>=10){
            	   dd=d+"";
             }
             if(s<10){
             	  ss="0"+s;
              }else if(s>=10){
             	   ss=s+"";
              }
             if(h<10){
           	  hh="0"+h;
            }else if(h>=10){
           	   hh=h+"";
            }
            
         return hh+":"+dd+":"+ss;  
       }
    /**
     * 计算工单折算量和工作时长
     * @param ygxydao
     * @param ygxy
     * @return
     */
    public Ygxy countGdlAndGzsc(YgxyDAO ygxydao,Ygxy ygxy)
    {
    	
    	double result = 0.0;
    	
    	result = yto0(ygxy.getFtYjdfl())*1.0+yto0(ygxy.getFeYjdfl())*1.0
    			+yto0(ygxy.getFtGdjll())*1.0+yto0(ygxy.getFeGdjll())*1.0
    			+yto0(ygxy.getSteEjdfl())*1.45+yto0(ygxy.getSteGdjll())*1.45
    			+yto0(ygxy.getFtSjl())*0.8+yto0(ygxy.getFeSjl())*0.8
    			+yto0(ygxy.getFtTdwzjl())*0.8+yto0(ygxy.getSteNbzjl())*0.8
    			+yto0(ygxy.getFtTbjpl())*0.7+yto0(ygxy.getFeTbjpl())*0.7
    			+yto0(ygxy.getSteTpjpl())*0.7+yto0(ygxy.getSteZsjl())*0.8;

    	ygxy.setGzsc(Tld.timeStringToDoubleHour(ygxy.getFtDlsc()));
    	ygxy.setGdl(result);
    	return ygxy;
    }
}
