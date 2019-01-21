package work.rulecase.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.pojo.CaseBean;
import work.rulecase.pojo.RcCase;
import work.rulecase.pojo.RcRule;
import work.rulecase.pojo.RuleBean;
import work.util.ExportExcel;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class ExpressCase {
	private String Path;
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception 
    {
		String filePath="";
		String hql="";
		String result="success";
		List<CaseBean> listcb = new ArrayList<CaseBean>();
		ExportExcel<CaseBean> ex = new ExportExcel<CaseBean>();
		String[] headers = {"板块","任务池","环节",
				"要素","要素A名称","要素A内容","要素B名称","要素B内容",
				"要素C名称","要素C内容","规则内容","切片名称","录入说明","备注"
		};
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		hql = "from RcCase";
    		List<RcCase> listrc = session.createQuery(hql).list();
    		for(int i=0;i<listrc.size();i++)
    		{
    			RcCase rc = listrc.get(i);
    			CaseBean cb = new CaseBean();
    			cb.setPlate(rc.getPlate());
    			cb.setPool(rc.getPool());
    			cb.setPart(rc.getPart());
    			cb.setFactor(rc.getFactor());
    			cb.setFacAName(rc.getFacAName());
    			cb.setFacA(rc.getFacA());
    			cb.setFacBName(rc.getFacB());
    			cb.setFacB(rc.getFacB());
    			cb.setFacCName(rc.getFacC());
    			cb.setFacC(rc.getFacC());
    			cb.setRule(rc.getRule());
    			cb.setPicname(rc.getPicname());
    			cb.setExp(rc.getExp());
    			cb.setRemark(rc.getRemark());
    			listcb.add(cb);
    		}
    		filePath=Tld.downloadpath+"anlimingxi.xls";
    		Path = "anlimingxi.xls";
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			trans.rollback();
			e.printStackTrace();
		}finally{
			trans.commit();
	        session.flush();
	        session.clear();
	        session.close();
		}
		
		try {
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("案例库",headers, listcb, out);
			out.close();
		//	JOptionPane.showMessageDialog(null, "导出成功！");
			System.out.println("excel导出成功！");
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
		//	JOptionPane.showMessageDialog(null, "导出失败！请选择正确路径！");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
		
    }
}
