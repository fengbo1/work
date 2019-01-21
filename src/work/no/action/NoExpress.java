package work.no.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.hndetail.pojo.HnDetailExpress;
import work.no.pojo.No;
import work.no.pojo.NoBean;
import work.util.ExportExcel;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;

public class NoExpress {

	private List<No> list;
	private int zx;
	private int chu;
	private String keyword;
	private String Path;
	public int getZx() {
		return zx;
	}

	public void setZx(int zx) {
		this.zx = zx;
	}

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public List<No> getList() {
		return list;
	}

	public void setList(List<No> list) {
		this.list = list;
	}
	
	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String execute() throws Exception{
		String filePath = "";
		String strtemp = new String(keyword.getBytes("ISO8859-1"),"UTF-8");
		filePath=Tld.downloadpath+"yuangongxinxi.xls";
		return express(filePath,strtemp,zx);
	}
	
	public String express(String filePath,String strtemp,int zx) throws UnsupportedEncodingException
	{
		
		ExportExcel<NoBean> ex = new ExportExcel<NoBean>();
		String[] headers = { "序号","姓名","新一代编号","性别", "身份证号",
				"联系电话","角色","position", "所在中心","人民币业务性质",
				"外汇业务性质","稽核业务性质","远程审核业务性质","建亚业务性质",
				"来中心日期","cost工号","工号1","工号2","处室","团队","来源"
		};
        
        Path = "yuangongxinxi.xls";
       //数据库条件查询
		
		Query query;
		String hql = "from No as n where";
		if(zx==2)
		{
			hql+=" n.zx in (0,1)";
		}
		else if(zx==1||zx==0)
		{
			hql+=" n.zx="+zx;
		}
		if(chu!=0)
		{
			hql+=" and n.chu="+chu;
		}
		
		System.out.println(hql);
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		//list转存
		List<NoBean> listno = new ArrayList<NoBean>();
		for(int i=0;i<list.size();i++)
		{
			NoBean nb = new NoBean();
			No no = list.get(i);
			nb.setId(i+1);
			nb.setName(no.getName());
			nb.setNewnumber(no.getNewnumber());
			nb.setSex(NoUtil.IntegerToSex(no.getSex()));
			nb.setIdentity(no.getIdentity());
			nb.setTel(no.getTel());
			nb.setRole(no.getRole());
			nb.setPosition(no.getPosition());
			nb.setZx(Tld.zxToString(no.getZx()));
			nb.setXz(String.valueOf(no.getXz()));
			nb.setXzwh(String.valueOf(no.getXzwh()));
			nb.setXzjh(String.valueOf(no.getXzjh()));
			nb.setXzsh(String.valueOf(no.getXzsh()));
			nb.setXzjy(String.valueOf(no.getXzjy()));
			nb.setComedate(no.getComedate());
			nb.setNo891(no.getNo891());
			nb.setNo1(no.getNo1());
			nb.setNo2(no.getNo2());
			nb.setChu(Tld.cToName(no.getPosition()));
			nb.setTeam(String.valueOf(no.getTeam()));
			nb.setSource(no.getSource());
			listno.add(nb);
		}
		//导出
		 try {
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, listno, out);
				out.close();
				System.out.println("excel导出成功！");
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return "success";
	}
	
}
