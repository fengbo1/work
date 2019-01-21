package work.rulecase.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import work.rulecase.pojo.RcRule;
import work.rulecase.pojo.RuleBean;
import work.util.ExportExcel;
import work.util.Tld;

public class ExpressRule {

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
		List<RuleBean> listrb = new ArrayList<RuleBean>();
		ExportExcel<RuleBean> ex = new ExportExcel<RuleBean>();
		String[] headers = {"板块","任务池","环节","适用范围",
				"要素","要素A名称","要素A内容","要素B名称","要素B内容",
				"要素C名称","要素C内容","规则内容","切片名称","录入说明","备注"
		};
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
    	try {
    		hql = "from RcRule";
    		List<RcRule> listrr = session.createQuery(hql).list();
    		for(int i=0;i<listrr.size();i++)
    		{
    			RcRule rr = listrr.get(i);
    			RuleBean rb = new RuleBean();
    			rb.setPlate(rr.getPlate());
    			rb.setPool(rr.getPool());
    			rb.setPart(rr.getPart());
    			rb.setArea(rr.getArea());
    			rb.setFactor(rr.getFactor());
    			rb.setFacAName(rr.getFacAName());
    			rb.setFacA(rr.getFacA());
    			rb.setFacBName(rr.getFacB());
    			rb.setFacB(rr.getFacB());
    			rb.setFacCName(rr.getFacC());
    			rb.setFacC(rr.getFacC());
    			rb.setRule(rr.getRule());
    			rb.setPicname(rr.getPicname());
    			rb.setExp(rr.getExp());
    			rb.setRemark(rr.getRemark());
    			listrb.add(rb);
    		}
    		filePath=Tld.downloadpath+"guizemingxi.xls";
    		Path = "guizemingxi.xls";
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
			ex.exportExcel("规则库",headers, listrb, out);
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
