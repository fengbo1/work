package work.control.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import work.control.pojo.Jhsx;
import work.util.YearSeason;

public class JhsxAction{

	/**
	* 起始时间
	*/
	protected String beginDate;
	/**
	* 结束时间
	*/
	protected String endDate;
/**
* 获得默认的分页大小
*/
protected int pageSize = 15;

/**
* 总页数
*/
protected int totalPages = -1;

/**
* 当前页
*/
protected int currentPage = -1;

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

/**
* 列表数据
*/
private List<Jhsx> list;

private static final Log log = LogFactory.getLog(Jhsx.class);
	

	public String getBeginDate() {
	return beginDate;
}

public void setBeginDate(String beginDate) {
	this.beginDate = beginDate;
}

public String getEndDate() {
	return endDate;
}

public void setEndDate(String endDate) {
	this.endDate = endDate;
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

public List<Jhsx> getList() {
	return list;
}

public void setList(List<Jhsx> list) {
	this.list = list;
}

public static Log getLog() {
	return log;
}

	public String execute() throws Exception{
		Query query;
		YearSeason ys = new YearSeason();
		String hql = "from Jhsx as n where n.date<='"+ys.getStringDate()+"' order by n.date desc";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(hql).list().size();
			initPageProperties();
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
		return "success";
		
	}
	
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
