package work.rulecase.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcCase;
import work.util.Tld;
import ccb.hibernate.HibernateSessionFactory;

public class CaseSelect {
	private int mg;
	private String word;
	private String key;
	private String pool;
	private String plate;
	private String part;
	private String factor;
	private String imagepath;
	private List<String> list;
	private List<RcCase> listrc;
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 13;

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
	public int getMg() {
		return mg;
	}
	public void setMg(int mg) {
		this.mg = mg;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public List<RcCase> getListrc() {
		return listrc;
	}
	public void setListrc(List<RcCase> listrc) {
		this.listrc = listrc;
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
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String execute() throws Exception{
		RcRuleDAO rrdao = new RcRuleDAO();
		String sql = "";
		String hql = "";
		imagepath =Tld.imagepath+"rulecase/rule/image/";
		plate = new String(plate.getBytes("ISO8859-1"),"UTF-8");
		word = new String(word.getBytes("ISO8859-1"),"UTF-8");
		part = new String(part.getBytes("ISO8859-1"),"UTF-8");
		factor = new String(factor.getBytes("ISO8859-1"),"UTF-8");
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		if(pool.equals("qxz")&&word.equals(""))
		{
			hql = "from RcCase as rc where 1=0";
		}
		else if(!pool.equals("qxz")||(!part.equals("qxz")&&!part.equals(""))||(!factor.equals("qxz")&&!factor.equals(""))||!word.trim().equals(""))
		{
			hql = "from RcCase as rc where 1=1 and plate='"+plate+"'";
		}
		else
		{
			hql = "from RcCase as rc where 1=0";
		}
		if(!pool.equals("qxz"))
		{
			hql += " and rc.pool='"+pool+"'";
			if(!key.equals("pool")&&!part.equals("")&&!part.equals("qxz"))
			{
				hql += " and rc.part='"+part+"'";
				if(!key.equals("part")&&!factor.equals("")&&!factor.equals("qxz"))
				{
					hql += " and rc.factor='"+factor+"'";
				}
			}
		}
		if(!word.trim().equals(""))
		{
			String[] wd = word.split(" ");
			for(int i=0;i<wd.length;i++)
			{
				String tempwd = wd[i].trim();
				if(!tempwd.equals(""))
				{
					hql+=" and (rc.factor like '%"+tempwd+"%' or rc.facA like '%"+tempwd+"%' " +
							"or rc.part like '%"+tempwd+"%' or rc.area like '%"+tempwd+"%' " +
							"or rc.rule like '%"+tempwd+"%' or rc.exp like '%"+tempwd+"%' " +
							"or rc.remark like '%"+tempwd+"%')";
				}
			}
		}
		if(key.equals("pool"))
		{
			sql="select distinct(part) from t_rc_case where pool='"+pool+"' and plate='"+plate+"'";
		}
		else if(key.equals("part"))
		{
			sql="select distinct(factor) from t_rc_case where pool='"+pool+"' and part='"+part+"' and plate='"+plate+"'";
		}
		hql +=" order by rc.plate,rc.pool,rc.part,rc.factor desc";
		System.out.println(hql);
//		if(key.equals("pool"))
//		{
//			sql="select distinct(part) from t_rc_case where pool='"+pool+"' and plate='"+plate+"'";
//			if(pool.equals("qxz"))
//			{
//				//hql = "from RcCase as rr where rr.plate='"+plate+"' order by rr.renewdate desc";
//			}
//			else
//			{
//				hql = "from RcCase as rr where rr.plate='"+plate+"' and rr.pool='"+pool+"' order by rr.renewdate desc";
//			}
//		}
//		else if(key.equals("part"))
//		{
//			part = new String(part.getBytes("ISO8859-1"),"UTF-8");
//			sql="select distinct(factor) from t_rc_case where pool='"+pool+"' and part='"+part+"' and plate='"+plate+"'";
//			if(part.equals("qxz"))
//			{
//				hql = "from RcCase as rr where rr.plate='"+plate+"' and rr.pool='"+pool+"' order by rr.renewdate desc";
//			}
//			else
//			{
//				hql = "from RcCase as rr where rr.plate='"+plate+"' and rr.pool='"+pool+"' and rr.part='"+part+"' order by rr.renewdate desc";
//			}
//		}
//		else if(key.equals("factor"))
//		{
//			part = new String(part.getBytes("ISO8859-1"),"UTF-8");
//			factor = new String(factor.getBytes("ISO8859-1"),"UTF-8");
//			if(factor.equals("qxz"))
//			{
//				hql = "from RcCase as rr where rr.plate='"+plate+"' and rr.pool='"+pool+"' and rr.part='"+part+"' order by rr.renewdate desc";
//			}
//			else
//			{
//				hql = "from RcCase as rr where rr.plate='"+plate+"' and rr.pool='"+pool+"' and rr.part='"+part+"' and rr.factor='"+factor+"' order by rr.renewdate desc";
//			}
//		}
//		System.out.println(hql);
		if(!sql.equals(""))
		list = session.createSQLQuery(sql).list();
		if(!hql.equals(""))
		{
			Query query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(hql).list().size();
			initPageProperties();
			listrc=query.list();
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
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
			//log.error("没有初始化totalRows参数！");
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
