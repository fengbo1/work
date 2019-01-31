package work.internal.action;

import java.io.File;
import java.io.FileInputStream;

import java.util.List;
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
import work.util.UploadUtil;
import work.util.YearSeason;
import work.wb.pojo.WbInit;
import work.wb.beans.BaseData;
import work.wb.dao.WbInitDAO;
import work.control.dao.FxqConfigDAO;
import work.control.dao.HnConfigDAO;
import work.control.dao.JiheConfigDAO;
import work.control.pojo.FxqConfig;
import work.control.pojo.HnConfig;
import work.control.pojo.JiheConfig;
import work.daily.dao.DailyStatusDAO;
import work.daily.pojo.DailyStatus;
import work.hn.action.ProduceSummary;
import work.hn.action.SummarySimple;
import work.hn.dao.HnFxqDAO;
import work.hn.dao.HnJianyaDAO;
import work.hn.dao.HnJiheDAO;
import work.hn.dao.HnWaihuiDAO;
import work.hn.dao.HnWhxlDAO;
import work.hn.dao.HnWhzlDAO;
import work.hn.dao.HnYcshDAO;
import work.hn.pojo.HnFxq;
import work.hn.pojo.HnJihe;
import work.hn.pojo.HnWhxl;
import work.hn.pojo.HnWhzl;
import work.hn.pojo.HnYcsh;
import work.hndetail.dao.HnDetailDAO;
import work.internal.beans.SplitFile;
import work.no.dao.NoDAO;
import work.no.dao.NoLogDAO;
import work.no.pojo.No;
import work.no.pojo.NoLog;
import work.online.dao.OnlineDAO;
import work.online.pojo.Online;
import work.pool.dao.PoolDAO;
import work.pool.pojo.Pool;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
/**
 * 文件上传与处理
 * @author htzx
 *
 */
public class Internal {
	private static Logger logger = Logger.getLogger(Internal.class);
	private String message;
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	/**
	 * 
	 * 文件上传和读取内容
	 * @return "success"执行成功
	 * @throws Exception
	 */
	public String execute() throws Exception {
        //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
	   String  realpath = Tld.uploadpath;
	   SplitFile splitfile=new SplitFile();
	   splitfile=FileSwitch(fileFileName);
	   String tmpdate=splitfile.getDate();
	   DailyStatusDAO dsdao = new DailyStatusDAO();
	   Operation operate = new Operation();
	   BaseData basedata = new BaseData();
	   String wbdate="";
	   String result = "success";
	   message = "";
       System.out.println(realpath);
       //新增一条DailyStatus记录
       if(splitfile.getDate().startsWith("20"))
       {
    	   dsdao.saveByTime(splitfile.getDate());
       }
        if (file != null) {
            File savefile = new File(new File(realpath), fileFileName);
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            FileUtils.copyFile(file, savefile);
        }
        else
        {
        	ActionContext.getContext().put("message", "传入文件有误");
        }
        /*根据文件名跳转不同表格*/
        if(splitfile.getType().equals("hn"))//针对于行内数据的操作
        {
        	if(splitfile.getPool().equalsIgnoreCase("whb"))//导入武汉报表,更新时长，查询等参数，更新快报—>日报标志位
        	 {
        		 message+= "日期："+splitfile.getDate()+fileReadwhbb(realpath+fileFileName,splitfile.getDate())+result;   
        		 dsdao.updateByTimeAndKey(tmpdate, "hnwhbb");
        	 }
        	 else if(splitfile.getPool().equalsIgnoreCase("onl"))//第一步导入上线人员表
        	 {
        		 message+=fileReadonline(realpath+fileFileName,splitfile.getDate());
        		 dsdao.updateByTimeAndKey(tmpdate, "hnonline");
        	 }
        	 else if(splitfile.getPool().equalsIgnoreCase("jhb"))//第二步导入稽核报表
        	 {
        		 message+=fileReadjhbb(splitfile.getDate(),realpath+fileFileName);
        		 dsdao.updateByTimeAndKey(tmpdate, "hnjihe");
//        		 DailyStatus ds = dsdao.findByTime(tmpdate);
//        		 if(ds!=null&&ds.getHnwhbb()!=null&&ds.getHnwhbb()==1)
//        		 {
//        			 operate.operateDetail(tmpdate);//如果已经导入武汉报表，重新计算明细表
//        			 produce.WhbbUpdate(tmpdate);
//        			 simple.WhbbUpdate(tmpdate);
//        		 }
        	 }
        	 else if(splitfile.getPool().equalsIgnoreCase("ycs"))//第三步导入远程集中授权审核
        	 {
        		 message+=fileReadycsh(splitfile.getDate(),realpath+fileFileName);
        		 dsdao.updateByTimeAndKey(tmpdate, "hnycsh");
        	 }
        	 else if(splitfile.getPool().equalsIgnoreCase("fxq"))//第三步导入反洗钱
        	 {
        		 message+=fileReadfxq(splitfile.getDate(),realpath+fileFileName);
        		 dsdao.updateByTimeAndKey(tmpdate, "hnfxq");
        	 }
        	 ////重点
        	 else if(splitfile.getPool().equalsIgnoreCase("x13"))//第四步导入卸数13
        	 {
        		 message+=fileReadhn(splitfile.getPool(),realpath+fileFileName);//读取卸数13
    			 message += operate.operateWaihui(splitfile.getDate());//计算外汇表
    			 message += operate.operateJianya(splitfile.getDate());//计算建亚表
    			 message += operate.operateHn891(splitfile.getDate());//计算891数据并存入891基础表
    			 message += operate.operateHn895(splitfile.getDate());//计算895数据并存入895基础表
    			 message += operate.operateDetail(splitfile.getDate());//计算明细表
    			 
    			 updateDaily(splitfile.getDate(),0);
    			 dsdao.updateByTimeAndKey(tmpdate, "hnx13");	 
        	 }
        	 else
        	 {
        		 message+="文件名格式有误（例如hn20150405-891）";
        	 }
        }else if(splitfile.getType().equals("wb"))/*计算外包基础数据表*/
        {
        	fileReadwb(splitfile.getPool(),realpath+fileFileName);
        	result = basedata.operateWb("891", tmpdate);//计算891数据并存入891基础表
        	try
        	{
        		if(result.equalsIgnoreCase("success"))
    		    {
        			message+="日期："+splitfile.getDate()+"891数据导入成功，基础数据表已生成!";
   				    updateDaily(splitfile.getDate(),1);
   				    dsdao.updateByTimeAndKey(tmpdate, "wb891");
    		    }
    		    else
    		    {
    		    	message+="日期："+splitfile.getDate()+"891数据导入失败，基础数据表未生成!"+result;
    		    }
   		    }catch (Exception e) {
   	     		e.printStackTrace();
   	    		logger.error("error date:"+wbdate+" errocode:"+e);
   		    }
        }
        else
        {
        	message+="文件名有误";
        }
        ActionContext.getContext().put("message", message);
		return "success";
	}
	/**
	 * 外包源数据导入
	 * 读取EXCEL文件，根据传入的type判别是891或是896任务池的数据
	 * @param type 文件任务池（891或896）
	 * @param filePath 文件路径
	 */

	public String fileReadwb(String type,String filePath)
	{
		WbInitDAO wbdao=new WbInitDAO();
		Transaction trans = null;
		String result="success";
		String no ="";
		GeneralCheck check = new GeneralCheck();
		
		//GenericServiceImpl<WbInit> service=new GenericServiceImpl<WbInit>(WbInit.class.getName());
		/*truncate表*/
		truncate("t_wb_init");
		Session session = HibernateSessionFactory.getSession();
		try {
			POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream(filePath));   
			// 获得第一个工作表对象
			HSSFWorkbook wb = new HSSFWorkbook(fs);  
	    	trans=session.beginTransaction();
			int nn=0;
			HSSFSheet sheet = wb.getSheetAt(0);
			// 得到第一列第一行的单元格
			nn = sheet.getLastRowNum()+1;
			
				for (int i = 1; i < nn; i++) {
				WbInit wbinit = new WbInit();
				HSSFRow row = sheet.getRow(i);
				
				System.out.println(row.getCell(0).getStringCellValue());
				wbinit.setNo(check.IsNullString(row.getCell(0).getStringCellValue()));
				no=wbinit.getNo();
				wbinit.setPool(check.IsNullString(type));
				wbinit.setName(check.IsNullString(row.getCell(1).getStringCellValue()));
				wbinit.setStep(IsNullStep(row.getCell(2).getStringCellValue()));
				
				wbinit.setYwl(Integer.parseInt(row.getCell(3).getStringCellValue()));
				wbinit.setAverTime(Double.parseDouble(row.getCell(4).getStringCellValue()));
				wbinit.setCc(Integer.parseInt(row.getCell(5).getStringCellValue()));
				wbinit.setHs(Integer.parseInt(row.getCell(7).getStringCellValue()));
				wbinit.setZlrxg(Integer.parseInt(row.getCell(11).getStringCellValue()));
				wbinit.setZyxcf(Integer.parseInt(row.getCell(13).getStringCellValue()));
				wbdao.save(wbinit);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("error no:"+no+" errocode:"+e);
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return result;
	}
	/**
	 * 行内源数据导入
	 * 读取EXCEL文件，根据传入的type判别是891或是895任务池的数据
	 * @param type 文件任务池（891或895）
	 * @param filePath 文件路径
	 * @return
	 //jxl不能支持07格式
	public String fileReadhn(String type,String filePath) throws NumberFormatException{
		GeneralCheck check = new GeneralCheck();
		ArrayList<Pool> list = new ArrayList<Pool>();
		Transaction trans = null;
		truncate("pool");
    	Session session = HibernateSessionFactory.getSession();
		int nn=0;
		try {
			Workbook book = Workbook.getWorkbook(new File(filePath));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
        	trans=session.beginTransaction();
        	
        	PoolDAO pdao = new PoolDAO();
			for (int i = 1; i < nn; i++) {
				Pool pool = new Pool();
				String tempNo = check.IsNullString(sheet.getCell(0, i).getContents());
				pool.setNo("01"+tempNo.substring(2));
				pool.setPool(check.IsNullString(type));
				pool.setPart(partToInteger(sheet.getCell(1, i).getContents().trim()));
				pool.setNumber(Integer.parseInt(sheet.getCell(2, i).getContents()));
				pool.setError(Integer.parseInt(sheet.getCell(3, i).getContents()));
				pool.setErrorRate(Double.parseDouble(sheet.getCell(4, i).getContents()));
				pool.setOutput(Integer.parseInt(sheet.getCell(5, i).getContents()));
				pool.setSendBack(Integer.parseInt(sheet.getCell(6, i).getContents()));
				pool.setAverageTime(Double.parseDouble(sheet.getCell(7, i).getContents()));
				pdao.save(pool);
			    list.add(pool);
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
*/
	//使用poi方法读取
	public String fileReadhn(String type,String filePath) throws NumberFormatException{
		GeneralCheck check = new GeneralCheck();
		//ArrayList<Pool> list = new ArrayList<Pool>();
		String result = "";
		UploadUtil uu = new UploadUtil();
		
		truncate("pool");
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
		int nn=0;
		try {
			org.apache.poi.ss.usermodel.Workbook workbook = null;
			// 获得第一个工作表对象
			//Workbook wb
			workbook = uu.getWorkbook(filePath);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
			// 得到第一列第一行的单元格
			nn = sheet.getLastRowNum()+1;
        	
        	
        	PoolDAO pdao = new PoolDAO();
			for (int i = 1; i < nn; i++) {
				Pool pool = new Pool();
				//HSSFRow row = sheet.getRow(i);
				Row currentRow = sheet.getRow(i);
				String tempNo = check.IsNullString(uu.getCellValue(currentRow.getCell(0), 0));
				System.out.println("tempNo:"+tempNo);
				if(tempNo.endsWith("0101")||tempNo.endsWith("0105"))
				{
					
					pool.setNo(tempNo.substring(tempNo.length()-12));//123456780101
				}
				else
				{
					pool.setNo("01"+tempNo.substring(tempNo.length()-10));
				}
				String part = uu.getCellValue(currentRow.getCell(1), 0).trim();
				String code = uu.getCellValue(currentRow.getCell(2), 0).trim();
//				HnConfig hc = hcdao.findAllByCodeAndPart(code, part);
//				if(hc!=null)
//				{
					pool.setPart(part);
					pool.setCode(code);
//					pool.setType(hc.getType());
//					pool.setIntype(hc.getIntype());
					pool.setNumber(check.IsNullInteger(uu.getCellValue(currentRow.getCell(3), 0)));
					pool.setCc(check.IsNullInteger(uu.getCellValue(currentRow.getCell(4), 0)));
					pool.setTp(check.IsNullInteger(uu.getCellValue(currentRow.getCell(9), 0)));
					pool.setSc(uu.getCellValue(currentRow.getCell(10), 0));
					pool.setType(0);
					pool.setIntype(0);
					pdao.merge(pool);
//				}
			    //list.add(pool);
			}
			String sql = "update pool a,t_hn_config b set a.type=b.type,a.intype=b.intype where b.code like concat('%',a.code,'%') and b.part=a.part";
			session.createSQLQuery(sql).executeUpdate();
			sql = "from Pool where type=0";
			List<Pool> listp = session.createQuery(sql).list();
			for(int i=0;i<listp.size();i++)
			{
				Pool p = listp.get(i);
				result+="业务编码：";
				result+=p.getCode();
				result+=",业务环节：";
				result+=p.getPart();
				result+="查询不到<br/>";
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
		return result;
		
	//
//		String code = "";
//		HnWaihuiDAO hwdao = new HnWaihuiDAO();
//		GeneralCheck check = new GeneralCheck();
//		org.apache.poi.ss.usermodel.Workbook workbook = null;
//		UploadUtil uu = new UploadUtil();
//		String message = idate+"外汇表导入成功!";
//		Session session = HibernateSessionFactory.getSession();
//		Transaction trans = session.beginTransaction();
//		try {
//			truncateWithoutSession(session,"t_hn_waihui");
//			workbook = uu.getWorkbook(filePath);
//			// 获得第一个工作表对象
//			//HSSFWorkbook wb = new HSSFWorkbook(fs);  
//			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
//			// 得到第一列第四行的单元格
//			nn = sheet.getLastRowNum();
//			for (int i = 1; i < nn; i++) {
//				HnWaihui hw = new HnWaihui();
//				Row currentRow = sheet.getRow(i);// 当前行
//				String tempNo = uu.getCellValue(currentRow.getCell(0), 0);
//				System.out.println("tempNo:"+tempNo);
//				if(tempNo.endsWith("0101")||tempNo.endsWith("0105"))
//				{
//					
//					hw.setNo(tempNo.substring(tempNo.length()-12));//123456780101
//				}
//				else
//				{
//					hw.setNo("01"+tempNo.substring(tempNo.length()-10));
//				}
//				hw.setPart(partToInteger(uu.getCellValue(currentRow.getCell(1), 0)));
//				code=uu.getCellValue(currentRow.getCell(2), 0);
//				hw.setCode(code);
//				hw.setNum(Integer.parseInt(uu.getCellValue(currentRow.getCell(3), 0)));
//				hw.setCc(Integer.parseInt(uu.getCellValue(currentRow.getCell(4), 0)));
//				hw.setTp(Integer.parseInt(uu.getCellValue(currentRow.getCell(7), 0)));
//				hw.setDate(idate);
//				if(code.startsWith("6"))
//				{
//					hwdao.merge(hw);
//				}
//			}
//		}catch (Exception e) {
//			trans.rollback();//出错回滚
//			e.printStackTrace();
//		}finally{
//			trans.commit();
//			session.flush();
//			session.clear();
//			session.close();
//		}
//		return message;
	}
	//使用poi方法读取稽核报表
	/**
	 * 日期，路径
	 */
	public String fileReadjhbb(String date,String filePath) throws NumberFormatException{
		GeneralCheck check = new GeneralCheck();
		String sql = "";
		String result = "";
		String noweihu = "";
		HnJiheDAO jhdao = new HnJiheDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		HnConfigDAO hcdao = new HnConfigDAO();
		JiheConfigDAO jcdao = new JiheConfigDAO();
		UploadUtil uu = new UploadUtil();
		NoDAO nodao = new NoDAO();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
		int nn=0;
		try {
			sql = "delete from t_hn_jihe where date='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			HnConfig hc1 = hcdao.findAllByTypeAndPart(4, "发布问题");
			HnConfig hc2 = hcdao.findAllByTypeAndPart(4, "审核取消问题");
			HnConfig hc3 = hcdao.findAllByTypeAndPart(4, "直接取消问题");
			HnConfig hc4 = hcdao.findAllByTypeAndPart(4, "核对类质检");
			HnConfig hc5 = hcdao.findAllByTypeAndPart(4, "核对类稽核");
			HnConfig hc6 = hcdao.findAllByTypeAndPart(4, "分析性质检");
			HnConfig hc7 = hcdao.findAllByTypeAndPart(4, "分析性稽核");
			org.apache.poi.ss.usermodel.Workbook workbook = null;
			// 获得第一个工作表对象
			workbook = uu.getWorkbook(filePath);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
			// 得到第一列第一行的单元格
			nn = sheet.getLastRowNum()+1;
        	
			for (int i = 5; i < nn; i++) {
				Row currentRow = sheet.getRow(i);
				String newnum = check.IsNullString(uu.getCellValue(currentRow.getCell(2), 0));
				String name = check.IsNullString(uu.getCellValue(currentRow.getCell(4), 0));
				String role = check.IsNullString(uu.getCellValue(currentRow.getCell(0), 0));
				
				newnum = "00000000"+newnum;
				newnum = newnum.substring(newnum.length()-8,newnum.length());
				HnJihe jihe = jhdao.findAllByDateAndNo(date, newnum);
				No no = nodao.findAllByNewnumberAndHangnei(newnum);
				UserInfo ui = uidao.findAllByName(name);
				JiheConfig jc = jcdao.findAllByName(name);
				if(jc==null)
				{
					if(!result.contains(name))
					{
						result+=name;
						result+="、";
//						JiheConfig jctemp = new JiheConfig();
//						jctemp.setCenter("总行");
//						jctemp.setName(name);
//						jctemp.setNewnumber(newnum);
//						jcdao.merge(jctemp);
					}
				}
				else if(no!=null)
				{
					jihe.setDate(date);
					jihe.setNewnumber(newnum);
					if(jc.getCenter().contains("中心")||jc.getCenter().contains("总行"))
					{
						jihe.setName(name);
						jihe.setZx(no.getZx());
						jihe.setXz(1);
						if(ui!=null&&no.getXz()!=3)
						{
							
							jihe.setPos(ui.getPosition());
						}
						else
						{
							jihe.setPos("");
						}
						jihe.setRole(role);
						if(role.contains("核对"))
						{
							if(role.contains("质检"))
							{
								jihe.setHdlzj(check.IsNullInteger(uu.getCellValue(currentRow.getCell(8), 0).replace("-", "")));
							}
							else if(role.contains("稽核"))
							{
								jihe.setHdljh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(8), 0).replace("-", "")));
							}
						}
						else if(role.contains("分析"))
						{
							if(role.contains("质检"))
							{
								jihe.setFxxzj(check.IsNullInteger(uu.getCellValue(currentRow.getCell(8), 0).replace("-", "")));
							}
							else if(role.contains("稽核"))
							{
								jihe.setFxxjh(check.IsNullInteger(uu.getCellValue(currentRow.getCell(8), 0).replace("-", "")));
							}
						}
						else
						{
							jihe.setFbYs(jihe.getFbYs()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(29), 0).replace("-", "")));
							jihe.setFbJy(jihe.getFbJy()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(25), 0).replace("-", "")));
							jihe.setFbGf(jihe.getFbGf()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(26), 0).replace("-", "")));
							jihe.setFbYb(jihe.getFbYb()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(27), 0).replace("-", "")));
							jihe.setFbZd(jihe.getFbZd()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(28), 0).replace("-", "")));
							
							jihe.setShYs(jihe.getShYs()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(34), 0).replace("-", "")));
							jihe.setShJy(jihe.getShJy()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(30), 0).replace("-", "")));
							jihe.setShGf(jihe.getShGf()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(31), 0).replace("-", "")));
							jihe.setShYb(jihe.getShYb()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(32), 0).replace("-", "")));
							jihe.setShZd(jihe.getShZd()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(33), 0).replace("-", "")));
							
							jihe.setZjYs(jihe.getZjYs()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(39), 0).replace("-", "")));
							jihe.setZjJy(jihe.getZjJy()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(35), 0).replace("-", "")));
							jihe.setZjGf(jihe.getZjGf()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(36), 0).replace("-", "")));
							jihe.setZjYb(jihe.getZjYb()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(37), 0).replace("-", "")));
							jihe.setZjZd(jihe.getZjZd()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(38), 0).replace("-", "")));
						}
						//jihe.setZcjsl(check.IsNullInteger(uu.getCellValue(currentRow.getCell(10), 0).replace("-", "")));
						//jihe.setWdhcl(check.IsNullInteger(uu.getCellValue(currentRow.getCell(12), 0).replace("-", "")));
						
						
						jihe.setRemark(no.getSchedeam());
						//jihe.setRemark(check.IsNullInteger(uu.getCellValue(currentRow.getCell(18), 0)));
//						double cl1 = check.mul((jihe.getFbYs()+jihe.getFbJy()+jihe.getFbGf()+jihe.getFbYb()+jihe.getFbZd()),hc1.getWeig())
//						+check.mul((jihe.getShYs()+jihe.getShJy()+jihe.getShGf()+jihe.getShYb()+jihe.getShZd()),hc2.getWeig())
//						+check.mul((jihe.getZjYs()+jihe.getZjJy()+jihe.getZjGf()+jihe.getZjYb()+jihe.getZjZd()),hc3.getWeig());
//						
//						jihe.setCl(jihe.getCl()+check.division(cl1, no.getSchedeam())+check.mul((jihe.getZyl()),hc4.getWeig()));
//						if(jihe.getCl()>0)
//						{
//							jihe.setSx(1);
//						}
						jhdao.merge(jihe);
					}
				}
				else
				{
					noweihu+=name;
					noweihu+="、";
				}
			}
			sql = "update t_hn_jihe set cl=(CAST(((fb_ys+fb_jy+fb_gf+fb_yb+fb_zd)*"+hc1.getWeig()+"+(sh_ys+sh_jy+sh_gf+sh_yb+sh_zd)*"
			+hc2.getWeig()+"+(zj_ys+zj_jy+zj_gf+zj_yb+zj_zd)*"+hc3.getWeig()+")/IFNULL(remark,1) AS DECIMAL(18,4))+hdlzj*"+hc4.getWeig()
			+"+hdljh*"+hc5.getWeig()+"+fxxzj*"+hc6.getWeig()+"+fxxjh*"+hc7.getWeig()+"),ywl=(fb_ys+fb_jy+fb_gf+fb_yb+fb_zd+" +
					"sh_ys+sh_jy+sh_gf+sh_yb+sh_zd+zj_ys+zj_jy+zj_gf+zj_yb+zj_zd+hdlzj+hdljh+fxxzj+fxxjh) where date='"+date+"'";
			System.out.println(sql);
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_jihe set sx=if(ywl>0,1,0)";
			System.out.println(sql);
			session.createSQLQuery(sql).executeUpdate();
			if(result.length()>1)
			{
				result="稽核人员未查到下列人员【"+result+"】";
				result+="人员工号表未查到下列人员【"+noweihu+"】";
			}
			else
			{
				result+="导入成功";
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
		return result;
	}
	
	/**
	 * 远程审核
	 * 日期，路径
	 */
	public String fileReadycsh(String date,String filePath) throws NumberFormatException{
		GeneralCheck check = new GeneralCheck();
		String sql = "";
		String result = "";
		UserInfoDAO uidao = new UserInfoDAO();
		HnConfigDAO hcdao = new HnConfigDAO();
		UploadUtil uu = new UploadUtil();
		NoDAO nodao = new NoDAO();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
		int nn=0;
		try {
			sql = "delete from t_hn_ycsh where date='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			org.apache.poi.ss.usermodel.Workbook workbook = null;
			// 获得第一个工作表对象
			workbook = uu.getWorkbook(filePath);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
			// 得到第一列第一行的单元格
			nn = sheet.getLastRowNum()+1;
        	HnYcshDAO hydao = new HnYcshDAO();
			for (int i = 1; i < nn; i++) {
				HnYcsh hy = new HnYcsh();
				Row currentRow = sheet.getRow(i);
				String newnum = check.IsNullString(uu.getCellValue(currentRow.getCell(0), 0));
				String name = check.IsNullString(uu.getCellValue(currentRow.getCell(1), 0));
				newnum = "00000000"+newnum;
				newnum = newnum.substring(newnum.length()-8,newnum.length());
				No no = nodao.findAllByNewnumberAndHangnei(newnum);
				UserInfo ui = uidao.findAllByName(name);
				if(no!=null)
				{
					HnConfig hc1 = hcdao.findAllByTypeAndPart(5, "业务审核通过笔数");
					HnConfig hc2 = hcdao.findAllByTypeAndPart(5, "业务审核拒绝笔数");
					HnConfig hc3 = hcdao.findAllByTypeAndPart(5, "业务审核撤销笔数");
					hy.setDate(date);
					hy.setNewnumber(newnum);
					hy.setName(name);
					hy.setZx(no.getZx());
					hy.setXz(1);
					if(ui!=null&&no.getXz()!=3)
					{
						hy.setPos(ui.getPosition());
					}
					else
					{
						hy.setPos("");
					}
					hy.setNum(check.IsNullInteger(uu.getCellValue(currentRow.getCell(2), 0)));//授权总笔数
					hy.setSc(check.DoubleToInteger0(check.IsNullDouble(uu.getCellValue(currentRow.getCell(19), 0))));
					hy.setPjsc(check.IsNullDouble(uu.getCellValue(currentRow.getCell(36), 0)));
					hy.setTg(check.IsNullInteger(uu.getCellValue(currentRow.getCell(37), 0)));
					hy.setTgl(check.IsNullDouble(uu.getCellValue(currentRow.getCell(38), 0)));
					hy.setJj(check.IsNullInteger(uu.getCellValue(currentRow.getCell(39), 0)));
					hy.setJjl(check.IsNullDouble(uu.getCellValue(currentRow.getCell(40), 0)));
					hy.setCx(check.IsNullInteger(uu.getCellValue(currentRow.getCell(41), 0)));
					hy.setCxl(check.IsNullDouble(uu.getCellValue(currentRow.getCell(42), 0)));
					hy.setZxsc(check.DoubleTo2(check.IsNullDouble(uu.getCellValue(currentRow.getCell(43), 0))/3600));
					hy.setCl(check.mul(hy.getTg(),hc1.getWeig())+check.mul(hy.getJj(),hc2.getWeig())+check.mul(hy.getCx(),hc3.getWeig()));
					if(hy.getCl()>0)
					{
						hy.setSx(1);
					}
					hydao.merge(hy);
				}
				else 
				{
					result+=name;
					result+="、";
				}
			}
			if(result.length()>1)
			{
				result+="未查到";
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
		return result;
	}
	
	/**
	 * 反洗钱
	 * 日期，路径
	 */
	public String fileReadfxq(String date,String filePath) throws NumberFormatException{
		GeneralCheck check = new GeneralCheck();
		String sql = "";
		String result = "";
		String noweihu = "";
		HnFxqDAO hfdao = new HnFxqDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		HnConfigDAO hcdao = new HnConfigDAO();
		FxqConfigDAO fcdao = new FxqConfigDAO();
		UploadUtil uu = new UploadUtil();
		NoDAO nodao = new NoDAO();
    	Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
		int nn=0;
		try {
			sql = "delete from t_hn_fxq where date='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			org.apache.poi.ss.usermodel.Workbook workbook = null;
			// 获得第一个工作表对象
			workbook = uu.getWorkbook(filePath);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
			// 得到第一列第一行的单元格
			nn = sheet.getLastRowNum()+1;
			for (int i = 3; i < nn; i++) {
				
				Row currentRow = sheet.getRow(i);
				String newnum = check.IsNullString(uu.getCellValue(currentRow.getCell(4), 0));
				String name = check.IsNullString(uu.getCellValue(currentRow.getCell(5), 0));
				newnum = "00000000"+newnum;
				newnum = newnum.substring(newnum.length()-8,newnum.length());
				No no = nodao.findAllByNewnumberAndHangnei(newnum);
				UserInfo ui = uidao.findAllByName(name);
				FxqConfig fc = fcdao.findAllByName(name);
				if(fc==null)
				{
					if(!result.contains(name))
					{
						result+=name;
						result+="、";
						FxqConfig fctemp = new FxqConfig();
						fctemp.setCenter("分行");
						fctemp.setName(name);
						fctemp.setNewnumber(newnum);
						fcdao.merge(fctemp);
					}
				}
				else if(no!=null)
				{
					HnFxq hf = hfdao.findAllByDateAndNewnumber(date, no.getNo891());
					HnConfig hc1 = hcdao.findAllByTypeAndPart(7, "大额交易客户信息");
					HnConfig hc2 = hcdao.findAllByTypeAndPart(7, "大额交易交易明细");
					HnConfig hc3 = hcdao.findAllByTypeAndPart(7, "可疑交易客户信息");
					HnConfig hc4 = hcdao.findAllByTypeAndPart(7, "可疑交易交易明细");
					//hf.setDate(date);
					//hf.setNewnumber(no.getNo891());
					hf.setName(name);
					hf.setZx(no.getZx());
					hf.setXz(1);
					if(ui!=null&&no.getXz()!=3)
					{
						hf.setPos(ui.getPosition());
					}
					else
					{
						hf.setPos("");
					}
					hf.setDekh(hf.getDekh()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(7), 0)));//大额交易客户信息
					hf.setDemx(hf.getDemx()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(8), 0)));//大额交易交易明细
					hf.setKykh(hf.getKykh()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(9), 0)));//可疑交易客户信息
					hf.setKymx(hf.getKymx()+check.IsNullInteger(uu.getCellValue(currentRow.getCell(10), 0)));//可疑交易交易明细
					hf.setYwl(hf.getDekh()+hf.getDemx()+hf.getKykh()+hf.getKymx());
					hf.setCl(check.mul(hf.getDekh(),hc1.getWeig())+check.mul(hf.getDemx(),hc2.getWeig())+check.mul(hf.getKykh(),hc3.getWeig())+check.mul(hf.getKymx(),hc4.getWeig()));
					if(hf.getCl()>0)
					{
						hf.setSx(1);
					}
					hfdao.merge(hf);
				}
				else 
				{
					noweihu+=name;
					noweihu+="、";
				}
			}
			if(result.length()>1)
			{
				result="反洗钱人员未查到下列人员【"+result+"】";
				result+="<br/>人员工号表未查到下列人员【"+noweihu+"】";
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
		return result;
	}
	/**
	 * sheet4 中各环节效率、查询率、渠道落地业务
	 * 导入武汉报表,更新时长，查询等参数，更新快报—>日报标志位
	 * @param filePath
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	
	public String fileReadwhbb(String filePath,String idate) throws Exception
	{
		int nxl=0;
		int nzl=0;
		String message = "导入成功,录入时长、查询率等数据已更新";
		GeneralCheck check = new GeneralCheck();
		Operation operate = new Operation();
		HnDetailDAO hddao = new HnDetailDAO();
		HnWhxlDAO xldao = new HnWhxlDAO();
		HnWhzlDAO zldao = new HnWhzlDAO();
		NoDAO nodao = new NoDAO();
		ProduceSummary produce=new ProduceSummary();
		SummarySimple simple=new SummarySimple();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		truncateWithoutSession(session,"t_hn_whxl");
		truncateWithoutSession(session,"t_hn_whzl");
		if(hddao.findByTime(idate)==null||hddao.findByTime(idate).isEmpty()||hddao.findByTime(idate).size()==0)
		{
			message = "请先导入基础数据表之后再导入此表!"; 
		}
		Workbook book = Workbook.getWorkbook(new FileInputStream(filePath));
		try {
			// 获得第三个工作表对象(20160901之后，应该是第四个工作表)
			Sheet sheetxl = book.getSheet(2);
			Sheet sheetzl = book.getSheet(3);
			//效率
			nxl = sheetxl.getRows();
			for (int i = 4; i < nxl; i++) {
				String no = check.IsNullString(sheetxl.getCell(1, i).getContents());
				String name = check.IsNullString(sheetxl.getCell(2, i).getContents());
				System.out.println("工号:"+no);
				//List<No> listno = nodao.findByNo891(no); 
				No notmp = nodao.findAllByNewnumberAndHangnei(no); 
				if(notmp!=null)
				{
					HnWhxl xl = new HnWhxl();
					//保存武汉效率
					xl.setDate(idate);
					xl.setNo(notmp.getNo891());
					System.out.println(no);
					xl.setName(name);
					xl.setPct(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(3, i))));
					xl.setPctrmb(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(4, i))));
					xl.setBmsb891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(5, i))));
					xl.setYxcf891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(6, i))));
					xl.setLrxg891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(7, i))));
					xl.setLrsq891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(8, i))));
					xl.setJhxg891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(9, i))));
					xl.setJhsq891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(10, i))));
					xl.setSbyy891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(11, i))));
					xl.setYxbz891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(12, i))));
					xl.setCslr891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(13, i))));
					xl.setZyfs891(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(14, i))));
					xl.setBmsb895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(15, i))));
					xl.setYxcf895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(16, i))));
					xl.setLrxg895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(17, i))));
					xl.setLrsq895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(18, i))));
					xl.setJhxg895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(19, i))));
					xl.setJhsq895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(20, i))));
					xl.setSbyy895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(21, i))));
					xl.setCslr895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(22, i))));
					xl.setZyfs895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(23, i))));
					xl.setPjsh895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(24, i))));
					xl.setRlcs895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(25, i))));
					xl.setRlfs895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(26, i))));
					xl.setRlsb895(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(27, i))));
					xl.setPctwh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(28, i))));
					xl.setZycswh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(29, i))));
					xl.setZyfswh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(30, i))));
					xl.setLrxgwh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(31, i))));
					xl.setLrsqwh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(32, i))));
					xl.setJhxgwh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(33, i))));
					xl.setJhsqwh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(34, i))));
					xl.setPjcswh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(35, i))));
					xl.setPjfswh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(36, i))));
					xl.setSbyywh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(37, i))));
					xl.setDghccswh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(38, i))));
					xl.setDghcfswh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(39, i))));
					xl.setDghrcswh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(40, i))));
					xl.setDghrfswh(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(41, i))));
					xl.setPctjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(42, i))));
					xl.setPjcsjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(43, i))));
					xl.setPjfsjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(44, i))));
					xl.setLrxgjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(45, i))));
					xl.setLrsqjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(46, i))));
					xl.setJhxgjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(47, i))));
					xl.setJhsqjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(48, i))));
					xl.setSbyyjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(49, i))));
					xl.setCslrjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(50, i))));
					xl.setZyfsjy(check.DoubleTo2(check.IsCellDouble(sheetxl.getCell(51, i))));
					xldao.merge(xl);
				}
			}
			nzl = sheetzl.getRows();
			for (int i = 4; i < nzl; i++) {
				String no = check.IsNullString(sheetzl.getCell(1, i).getContents());
				System.out.println("工号:"+no);
				//List<No> listno = nodao.findByNo891(no); 
				List<No> listnonew = nodao.findAllByNewnumber(no); 
				if(listnonew.size()>0)
				{
					HnWhzl zl = new HnWhzl();
					//保存武汉效率
					zl.setDate(idate);
					zl.setNo(listnonew.get(0).getNo891());
					System.out.println(no);
					zl.setName(check.IsNullString(sheetzl.getCell(2, i).getContents()));
					zl.setCxlrmb(check.DoubleTo4(check.IsCellDouble(sheetzl.getCell(12, i))));
					zl.setQdld(check.IsCellInteger(sheetzl.getCell(13, i)));
					zl.setZwdl(check.DoubleTo4(check.IsCellDouble(sheetzl.getCell(14, i))));
					zl.setBhwh(check.IsCellInteger(sheetzl.getCell(17, i))+check.IsCellInteger(sheetzl.getCell(18, i))+check.IsCellInteger(sheetzl.getCell(19, i)));
					zl.setCxlwh(check.DoubleTo4(check.IsCellDouble(sheetzl.getCell(21, i))));
					zl.setCxljy(check.DoubleTo4(check.IsCellDouble(sheetzl.getCell(25, i))));
					zldao.merge(zl);
				}
			}
			//891
			String sql = "update hn891_ls a,t_hn_whxl b set a.xl_bmsb=b.bmsb891,a.xl_yxcf=b.yxcf891,a.xl_lrxg=b.lrxg891,a.xl_lrsq=b.lrsq891,a.xl_jhxg=b.jhxg891,a.xl_jhsq=b.jhsq891,a.xl_sbyy=b.sbyy891,a.xl_yxbz=b.yxbz891,a.xl_cslr=b.cslr891,a.xl_zyfs=b.zyfs891 where a.no=b.no and a.time=b.date";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update hn891_ls a,t_hn_whzl b set a.cxl=b.cxlrmb where a.no=b.no and a.time=b.date";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update hn891_ls set sumxl=(bmsb*xl_bmsb+yxcf*xl_yxcf+lrxg*xl_lrxg+lrsq*xl_lrsq+jhxg*xl_jhxg+jhsq*xl_jhsq+sbyy*xl_sbyy+yxbz*xl_yxbz+cslr*xl_cslr+zyfs*xl_zyfs),cx=CAST(ywl*cxl AS DECIMAL(18,0))";
			session.createSQLQuery(sql).executeUpdate();
			//895
			sql = "update hn895_ls a,t_hn_whxl b set a.xl_bmsb=b.bmsb895,a.xl_yxcf=b.yxcf895,a.xl_lrxg=b.lrxg895,a.xl_lrsq=b.lrsq895,a.xl_jhxg=b.jhxg895,a.xl_jhsq=b.jhsq895,a.xl_sbyy=b.sbyy895,a.xl_cslr=b.cslr895,a.xl_zyfs=b.zyfs895,a.xl_shsh=b.pjsh895,a.xl_rlcs=b.rlcs895,a.xl_rlfs=b.rlfs895,a.xl_rlsb=b.rlsb895 where a.no=b.no and a.time=b.date";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update hn895_ls a,t_hn_whzl b set a.cxl=b.cxlrmb where a.no=b.no and a.time=b.date";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update hn895_ls set sumxl=(bmsb*xl_bmsb+yxcf*xl_yxcf+lrxg*xl_lrxg+lrsq*xl_lrsq+jhxg*xl_jhxg+jhsq*xl_jhsq+sbyy*xl_sbyy+cslr*xl_cslr+zyfs*xl_zyfs+shsh*xl_shsh+shsb*xl_shsb+rlcs*xl_rlcs+rlfs*xl_rlfs+rlsb*xl_rlsb),cx=CAST(ywl*cxl AS DECIMAL(18,0))";
			session.createSQLQuery(sql).executeUpdate();
			//waihui
			sql = "update t_hn_waihui_ls a,t_hn_whxl b set a.xlzycs=b.zycswh,a.xlzyfs=b.zyfswh,a.xllrxg=b.lrxgwh,a.xllrsq=b.lrsqwh,a.xljhxg=b.jhxgwh,a.xljhsq=b.jhsqwh,a.xlpjcs=b.pjcswh,a.xlpjfs=b.pjfswh,a.xlsbyy=b.sbyywh,a.xldgcs=b.dghccswh,a.xldgfs=b.dghcfswh,a.xlhrcs=b.dghrcswh,a.xlhrfs=b.dghrfswh where a.no=b.no and a.date=b.date";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_waihui_ls a,t_hn_whzl b set a.cxlv=b.cxlwh,a.bh=b.bhwh where a.no=b.no and a.date=b.date";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_waihui_ls set sumxl=(zycs*xlzycs+zyfs*xlzyfs+lrxg*xllrxg+lrsq*xllrsq+jhxg*xljhxg+jhsq*xljhsq+pjcs*xlpjcs+pjfs*xlpjfs+sbyy*xlsbyy+dgcs*xldgcs+dgfs*xldgfs+hrcs*xlhrcs+hrfs*xlhrfs),cx=CAST(cxlv*ywl AS DECIMAL(18,0)) where date='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_waihui_ls set percl=CAST(sumxl/zhcl AS DECIMAL(18,2)),bhl=CAST(bh/zyfs AS DECIMAL(18,4))";
			session.createSQLQuery(sql).executeUpdate();
			
			//t_hn_detail
			sql = "update t_hn_detail_ls a,t_hn_whzl b set a.qdlr=b.qdld,a.qdlrzl=b.zwdl where a.no=b.no and a.time=b.date";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_detail_ls set qdlrz=CAST(qdlr*qdlrzl AS DECIMAL(18,0))";
			session.createSQLQuery(sql).executeUpdate();
			
			sql = "delete from hn891 where time='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "delete from hn895 where time='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "delete from t_hn_waihui where date='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
//			sql = "delete from t_hn_detail where time='"+idate+"'";
//			session.createSQLQuery(sql).executeUpdate();
			
			sql = "insert into hn891(time,no,name,bmsb,xl_bmsb,yxcf,xl_yxcf,lrxg,xl_lrxg,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,sbyy,xl_sbyy,yxbz,xl_yxbz,cslr,xl_cslr,zyfs,xl_zyfs,lrcc,jhcc,lrccl,jhccl,lrtp,lrtpl,ccl,cx,cxl,zhcl,ywl,sumxl,zx,xz,remark1,remark2,remark3,remark4,remark5) select time,no,name,bmsb,xl_bmsb,yxcf,xl_yxcf,lrxg,xl_lrxg,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,sbyy,xl_sbyy,yxbz,xl_yxbz,cslr,xl_cslr,zyfs,xl_zyfs,lrcc,jhcc,lrccl,jhccl,lrtp,lrtpl,ccl,cx,cxl,zhcl,ywl,sumxl,zx,xz,remark1,remark2,remark3,remark4,remark5 from hn891_ls where time='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "insert into hn895(time,no,name,bmsb,xl_bmsb,yxcf,xl_yxcf,lrxg,xl_lrxg,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,sbyy,xl_sbyy,cslr,xl_cslr,zyfs,xl_zyfs,shsh,xl_shsh,shsb,xl_shsb,rlcs,xl_rlcs,rlfs,xl_rlfs,rlsb,xl_rlsb,lrcc,jhcc,lrccl,jhccl,lrtp,lrtpl,ccl,cx,cxl,zhcl,ywl,sumxl,zx,xz) select time,no,name,bmsb,xl_bmsb,yxcf,xl_yxcf,lrxg,xl_lrxg,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,sbyy,xl_sbyy,cslr,xl_cslr,zyfs,xl_zyfs,shsh,xl_shsh,shsb,xl_shsb,rlcs,xl_rlcs,rlfs,xl_rlfs,rlsb,xl_rlsb,lrcc,jhcc,lrccl,jhccl,lrtp,lrtpl,ccl,cx,cxl,zhcl,ywl,sumxl,zx,xz from hn895_ls where time='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "insert into t_hn_waihui(date,no,name,zx,xz,zycs,zyfs,lrxg,lrsq,jhxg,jhsq,pjcs,pjfs,sbyy,hrcs,hrfs,xlzycs,xlzyfs,xllrxg,xllrsq,xljhxg,xljhsq,xlpjcs,xlpjfs,xlsbyy,xlhrcs,xlhrfs,lrcc,lclv,jhcc,jclv,tp,tplv,cx,cxlv,zhcl,ywl,sumxl,ccl,percl,bh,bhl) select date,no,name,zx,xz,zycs,zyfs,lrxg,lrsq,jhxg,jhsq,pjcs,pjfs,sbyy,hrcs,hrfs,xlzycs,xlzyfs,xllrxg,xllrsq,xljhxg,xljhsq,xlpjcs,xlpjfs,xlsbyy,xlhrcs,xlhrfs,lrcc,lclv,jhcc,jclv,tp,tplv,cx,cxlv,zhcl,ywl,sumxl,ccl,percl,bh,bhl from t_hn_waihui_ls where date='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
//			sql = "insert  into t_hn_detail(time,no,name,zx,xz,team,lrxg,xl_lrxg,ljlrsc,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,ljlr,ljjh,ljlr895,ljjh895,tp,ljtp,lrcc,jhcc,cx,ljcx,output891,output895,output,ccl891,cxl891,tpl891,ccl895,cxl895,tpl895,ljcl,ljywl891,ljywl895,ljrjcl,rjclwcl,ljlrcc,ljjhcc,rjccl891,rjcxl891,rjtpl891,rjccl895,rjcxl895,rjtpl895,ljsxts,online,zyzl,remark1,remark2,remark3,remark4,remark5,qdlr,qdlrz,ljqdlr,ljqdlrz,qdlrzl,ljqdlrzl,percltime,zyccl) select time,no,name,zx,xz,team,lrxg,xl_lrxg,ljlrsc,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,ljlr,ljjh,ljlr895,ljjh895,tp,ljtp,lrcc,jhcc,cx,ljcx,output891,output895,output,ccl891,cxl891,tpl891,ccl895,cxl895,tpl895,ljcl,ljywl891,ljywl895,ljrjcl,rjclwcl,ljlrcc,ljjhcc,rjccl891,rjcxl891,rjtpl891,rjccl895,rjcxl895,rjtpl895,ljsxts,online,zyzl,remark1,remark2,remark3,remark4,remark5,qdlr,qdlrz,ljqdlr,ljqdlrz,qdlrzl,ljqdlrzl,percltime,zyccl from t_hn_detail_ls where time='"+idate+"'";
//			session.createSQLQuery(sql).executeUpdate();
			
			sql = "update t_hn_jianya a,t_hn_whxl b set a.xlpjcs=b.pjcsjy,a.xlpjfs=b.pjfsjy,a.xllrxg=b.lrxgjy,a.xllrsq=b.lrsqjy where a.date=b.date and a.no=b.no";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_jianya a,t_hn_whzl b set a.cxlv=b.cxljy where a.date=b.date and a.no=b.no";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_jianya set sumxl=(pjcs*xlpjcs+pjfs*xlpjfs+lrxg*xllrxg+lrsq*xllrsq),cx=CAST(cxlv*ywl AS DECIMAL(18,0)) where date='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
		}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
	//	message+=updateNo(idate);
		operate.operateDetail(idate);
		updateDaily(idate,3);
		/*计算汇总表和汇总简表*/
		produce.WhbbUpdate(idate);
		simple.WhbbUpdate(idate);
		book.close();
		return message;
	}
	/**
	 * 读取员工上线表
	 * @param filePath
	 * @param idate
	 * @return
	 */
	public String fileReadonline(String filePath,String idate)
	{
		int nn=0;
		String failed = "";
		YearSeason ys = new YearSeason();
		String old1monthdate = ys.getLastMonthDate(String.valueOf(idate));
		DailyStatusDAO dsdao = new DailyStatusDAO();
		String message = idate+"导入成功,员工上线表已经更新!";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
//			String sql = "delete from t_hn_online where time<'"+old1monthdate+"' or time='"+idate+"'";
//			session.createSQLQuery(sql).executeUpdate();
			truncateWithoutSession(session,"t_hn_online");
			POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream(filePath));   
			// 获得第一个工作表对象
			HSSFWorkbook wb = new HSSFWorkbook(fs);  
			HSSFSheet sheet = wb.getSheetAt(0);
			// 得到第一列第四行的单元格
			nn = sheet.getLastRowNum()+1;
			OnlineDAO odao = new OnlineDAO();
			NoDAO nodao = new NoDAO();
			for (int i = 0; i < nn; i++) {
				Online ol = new Online();
				HSSFRow row = sheet.getRow(i);
				String no = "";
				if(row!=null&&row.getCell(0)!=null)
				{
					if(row.getCell(0).getCellType()==0)//数字
					{
						no = String.valueOf(row.getCell(0).getNumericCellValue()).replace(".", "").split("E")[0];
					}
					else if(row.getCell(0).getCellType()==1)//字符串
					{
						no = row.getCell(0).getStringCellValue().trim();
					}
					row.getCell(0).getCellType();
					System.out.println(no);
					if(no.length()>6)
					{
						no="00000".substring(0,(12-no.length()))+no;
						if(no.startsWith("01000"))//旧工号
						{
							String tempno = "";
							if(no.contains("895"))//010000895M79
							{
								if(nodao.findBy895No(no.substring(9, 12)).isEmpty())
								{
									//message = "导入失败，没有查询到895工号"+no.substring(9, 12);
									failed+="<br/>895工号"+no.substring(9, 12)+"在员工信息表中查询不到";
								}
								else
								{
									No no895 = (No)nodao.findBy895No(no.substring(9, 12)).get(0);
									tempno = no895.getNo891();
								}
								
							}
							else if(no.contains("891"))
							{
								if(nodao.findBy891No(no.substring(9, 12)).isEmpty())
								{
									//message = "导入失败，没有查询到895工号"+no.substring(9, 12);
									failed+="<br/>891工号"+no.substring(9, 12)+"在员工信息表中查询不到";
								}
								else
								{
									tempno = no.substring(9, 12);
								}
							}
							else
							{
								tempno = no.substring(9, 12);
								
							}
							ol.setNo(tempno);
							ol.setTime(idate);
							odao.save(ol);
						}
						else if(no.endsWith("0101")||no.endsWith("0105"))//新工号123456780101/123456780105
						{
							String tempno = "";
//							no = "00000000"+no;
//							no = no.substring(no.length()-12,no.length());
							if(no.endsWith("0105"))//123456780105
							{
								if(nodao.findBy895No(no.substring(0, 8)).isEmpty())
								{
									//message = "导入失败，没有查询到895工号"+no.substring(9, 12);
									failed+="<br/>895工号"+no.substring(0,8)+"在员工信息表中查询不到";
								}
								else
								{
									No no895 = (No)nodao.findBy895No(no.substring(0,8)).get(0);
									tempno = no895.getNo891();
								}
								
							}
							else if(no.endsWith("0101"))
							{
								if(nodao.findBy891No(no.substring(0, 8)).isEmpty())
								{
									//message = "导入失败，没有查询到895工号"+no.substring(9, 12);
									failed+="<br/>891工号"+no.substring(0, 8)+"在员工信息表中查询不到";
								}
								else
								{
									tempno = no.substring(0, 8);
								}
							}
							else//新工号123456780101/123456780105
							{
								tempno = no.substring(0, 8);
							}
							ol.setNo(tempno);
							ol.setTime(idate);
							odao.save(ol);
						}
						
					}
					
				}
				}
			if(failed.length()>1){return failed;}
			if(failed.length()<1)
			{
				dsdao.updateByTimeAndKey(session,idate, "hnonline");
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
		return message;
	}

	/**
	 * 根据日期判断是否导入员工上线信息表
	 * @param time
	 * @return
	 */
	public boolean ifImportOnline(String time)
	{
		OnlineDAO odao = new OnlineDAO();
		boolean result=false;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List list = odao.findByTime(time);
		if(list==null||list.isEmpty()||list.size()<=0)
			result=false;
		else
			result=true;
		trans.commit();
		session.flush();
		session.clear();
		return result;
	}
	
	/**
	 * 对EXCEL中空数据进行处理
	 * @param String input
	 * @return
	 */

	/**
	 *外包表格 对操作环节处理
	 */
	public int IsNullStep(String input)
	{
		int i=0;
		if(input.trim().equals("一次录入")){
			i=1;
		}else if(input.trim().equals("二次录入"))
		{
			i=2;
		}else if(input.trim().equals("人工辅助验印"))
		{
			i=3;
		}else if(input.trim().equals("录入仲裁"))
		{
		    i=4;
		}
		return i;
	}
	/**
	 * 根据文件名跳转sample:hn20150103-891.docx
	 */
	public SplitFile FileSwitch(String filename){
		
		
		SplitFile splitfile=new SplitFile();
		
		splitfile.setType(filename.substring(0,2));
		if (filename.length() > 9)
			splitfile.setDate(filename.substring(2, 10));
		else
			splitfile.setDate("null");
		if (filename.length() > 13)
			splitfile.setPool(filename.substring(11, 14));
		else
			splitfile.setPool("null");
		
		return splitfile;
		
	}
	/**
	 * 将中文操作环节转换成英文
	 * @param part 1:版面识别 2：人工影像拆分 3：录入修改
	 * 			   4：录入修改授权 5：检核修改 6：检核授权
	 *     		   7：失败原因分析 8：单位账户影像标注录入角色
	 *     		   9：初审录入10：专业复审11信用卡预检
	 * @return
	 */
	public int partToInteger(String part){
		if(part.trim().contains("外汇"))
		{
			return 99;
		}
		else if(part.trim().contains("版面识别"))
		{
			return 1;
		}
		else if(part.trim().contains("影像拆分"))
		{
			return 2;
		}
		else if(part.trim().equals("录入修改"))
		{
			return 3;
		}
		else if(part.trim().contains("录入")&&part.trim().contains("授权"))
		{
			return 4;
		}
		else if(part.trim().equals("检核修改"))
		{
			return 5;
		}
		else if(part.trim().contains("检核")&&part.trim().contains("授权"))
		{
			return 6;
		}
		else if(part.trim().equals("记账失败人工异常处理"))
		{
			return 7;
		}
		else if(part.trim().contains("影像标注"))
		{
			return 8;
		}
		else if(part.trim().contains("初审录入"))
		{
			return 9;
		}
		else if(part.trim().contains("专业复审"))
		{
			return 10;
		}
		else if(part.trim().contains("信用卡预检"))
		{
			return 11;
		}
		else
		{
			return 0;
		}
	}
	/*truncate表*/
	public void truncate(String table)
	{
		Session truncate_session = HibernateSessionFactory.getSession();
		Transaction tran=truncate_session.beginTransaction();
		Query queryObject = truncate_session.createSQLQuery("truncate "+ table);
		queryObject.executeUpdate();
		tran.commit();
		truncate_session.flush();
		truncate_session.clear();
		truncate_session.close();
	}
	/*truncate表*/
	public void truncateWithoutSession(Session session,String table)
	{
		session.createSQLQuery("truncate "+ table).executeUpdate();
	}
	/**
	 * 传入导入日期，修改Daily报表生成情况表
	 * @param idate 日报表生成日期 
	 * @param pool 0：行内或者1：外包，3:武汉数据
	 */
	public void updateDaily(String idate,int pool)
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			 DailyStatusDAO dsdao = new DailyStatusDAO();
			 DailyStatus ds = dsdao.findByTime(idate);
			 if(pool==0)
			 {
				 if(ds==null)
				 {
					 DailyStatus temp = new DailyStatus();
					 temp.setTime(idate);
					 temp.setHnQuick(1);
					 temp.setWbDaily(0);
					 dsdao.merge(temp);
				 }
				 else
				 {
					 ds.setHnQuick(2);
					 dsdao.merge(ds);
				 }
			 }
			 else if(pool==1)
			 {
				 if(ds==null)
				 {
					 DailyStatus temp = new DailyStatus();
					 temp.setTime(idate);
					 temp.setWbDaily(1);
					 temp.setHnQuick(0);
					 dsdao.merge(temp);
				 }
				 else
				 {
					 ds.setWbDaily(2);
					 dsdao.merge(ds);
				 }
			 }
			 else if(pool==3)//武汉数据导入后修改日报标志位
			 {
				 ds.setHnDaily(1);
				 dsdao.merge(ds);
			 }
			
		} catch (RuntimeException re) {
			re.printStackTrace();
			trans.rollback();
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}
	/**
	 * 根据武汉报表更新t_no,hn891,hn895,t_hn_detail人员性质
	 * @param date
	 * @return
	 */
	public String updateNo(String date)
	{
		NoLogDAO nldao = new NoLogDAO();
		YearSeason ys = new YearSeason();
		//update t_no a,t_wh_ywl b set a.xz=b.xz where a.no891=b.no;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			String sql1 = "select a.no from t_wh_zlxl a,t_no b where a.no=b.no891 and a.xz<>b.xz"; //返回人员性质有变化的人
			String sql = "update t_no a,t_wh_zlxl b set a.xz=b.xz,a.zx=b.zx where a.no891=b.no";//更新t_no人员性质
//			String sql2 = "select a.no from t_wh_zlxl a,t_no b where a.no=b.no891 and b.xz!=4 and a.team like '%外汇%'";//更新外汇信息
//			String sql3 = "update t_no a,t_wh_zlxl b set a.xz=4 where a.no891=b.no and b.team like '%外汇%'";
			//String sql2 = "update hn891 a,t_wh_ywl b set a.xz=b.xz,a.zx=b.zx where a.no=b.no and a.time='"+date+"'";//更新891人员性质
			//String sql3 = "update hn895 a,t_wh_ywl b set a.xz=b.xz,a.zx=b.zx where a.no=b.no and a.time='"+date+"'";//更新895人员性质
			//String sql4 = "update t_hn_detail a,t_wh_ywl b set a.xz=b.xz,a.zx=b.zx where a.no=b.no and a.time='"+date+"'";//更新hn_detail人员性质
			String result="";
			List<String> list = session.createSQLQuery(sql1).list();
//			List<String> list2 = session.createSQLQuery(sql2).list();
			for(int i=0;i<list.size();i++)
			{
				result+="、"+list.get(i);
			}
//			for(int i=0;i<list2.size();i++)
//			{
//				result+="、"+list2.get(i);
//			}
			if(result.length()>1)
			{
				session.createSQLQuery(sql).executeUpdate();
				//session.createSQLQuery(sql2).executeUpdate();
//				session.createSQLQuery(sql3).executeUpdate();
				//session.createSQLQuery(sql4).executeUpdate();
				NoLog nl = new NoLog("见备注","见备注", 1,"自动更新", "自动更新","自动更新","导入武汉报表", ys.getDateTime(), result+"员工性质已更新","","");
				nldao.save(nl);
				result+="员工性质已更新";
			}
			
			return result;
		}catch (RuntimeException re) {
			re.printStackTrace();
			trans.rollback();
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}
}
