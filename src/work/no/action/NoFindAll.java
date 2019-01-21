package work.no.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import work.hndetail.pojo.HnDetail;
import work.no.pojo.No;
import work.userinfo.dao.UserInfoDAO;

public class NoFindAll {
	private static final Log log = LogFactory.getLog(No.class);
	private List<No> list = new ArrayList<No>();
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 14;

	/**
	* 总页数
	*/
	private int totalPages = -1;

	/**
	* 当前页
	*/
	private int currentPage = -1;

	/**
	* 上一页
	*/
	private int previousPage = 1;

	/**
	* 下一页
	*/
	private int nextPage = 1;
	/**
	* 第一页
	*/
	private int firstPage = 1;
	/**
	* 最后一页
	*/
	private int lastPage = 1;
	/**
	* 总记录条数
	*/
	private long totalRows = -1;
	private int zx;
	private int chu;
	private String show;
	private String keyword;
	private String strtemp;
	private int zhuan;
	public List<No> getList() {
		return list;
	}


	public void setList(List<No> list) {
		this.list = list;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPreviousPage() {
		return previousPage;
	}


	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}


	public int getNextPage() {
		return nextPage;
	}


	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}


	public int getFirstPage() {
		return firstPage;
	}


	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}


	public int getLastPage() {
		return lastPage;
	}


	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}


	public long getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}


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


	public String getStrtemp() {
		return strtemp;
	}


	public void setStrtemp(String strtemp) {
		this.strtemp = strtemp;
	}


	public int getZhuan() {
		return zhuan;
	}


	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}


	public String getShow() {
		return show;
	}


	public void setShow(String show) {
		this.show = show;
	}


	public String execute() throws Exception
	{
		Query query;
		UserInfoDAO uidao = new UserInfoDAO();
		List<No> listtemp = new ArrayList<No>();
		String hql = "from No as n where";
		if(zx==2)
		{
			hql+=" n.zx in (0,1)";
		}
		else
		{
			hql+=" n.zx="+zx;
		}
		if(chu!=0)
		{
			hql+=" and n.chu="+chu;
		}
		if(keyword!=null&&zhuan==1)
		{
			strtemp = new String(keyword.getBytes("ISO8859-1"),"UTF-8");
		}
		else
		{
			strtemp = keyword;
		}
		System.out.println("keyword:"+strtemp);
		if(strtemp!=null)
			{
				hql +=" and (n.name like '%"+strtemp+"%' or n.no891 like '%"+strtemp+"%' or n.newnumber like '%"+strtemp+"%' or n.no1 like '%"+strtemp+"%' or n.no2 like '%"+strtemp+"%')";
			}
		System.out.println(hql);
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(hql).list().size();
			initPageProperties();
			listtemp = query.list();
			for(int i=0;i<listtemp.size();i++)
			{
				No no = listtemp.get(i);
				if(!uidao.findByNo891(no.getNo891()).isEmpty())
				{
					no.setRemark1("1");
				}
				list.add(no);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
	}
	
	
	/**
	 * 初始化页面属性<br>
	 * 必须在已获得totalRows值之后再调用该函数<br>
	 * 调用方式为：<br>
	 * 
	 * 给totalRows赋值<br>
	 * 调用initPageProperties(form)方法<br>
	 * 给list赋值<br>
	 * 调用initAttribute(request)方法<br>
	 * 
	 * 该方法在调用查询语句之前调用<br>
	 * pageSize为系统默认的分页的大小，如要更改pageSize，应在掉用setPageSize方法后再调用该方法<br>
	 * 
	 * 
	 */
	protected void initPageProperties() {

		if (totalRows == -1) {
			log.error("没有初始化totalRows参数！");
		}

		firstPage = 1;
		
		currentPage = currentPage <= 1 ? 1 : currentPage;

		totalPages = (totalRows % pageSize == 0) ? ((int) (totalRows / pageSize))
				: ((int) (totalRows / pageSize + 1));

		currentPage = currentPage >= totalPages ? totalPages : currentPage;

		previousPage = currentPage > 1 ? currentPage - 1 : 1;

		nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

		lastPage = totalPages;
	}
	
}

