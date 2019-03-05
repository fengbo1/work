package work.rulecase.action.hegui;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import work.rulecase.pojo.RcRule;
import work.rulecase.pojo.RuleHgBean;
import work.util.YearSeason;
import ccb.hibernate.HibernateSessionFactory;

public class HeGuiAction {

	private String role;
	private int zhuan;
	private String pool;//审核标准、分行差异、印鉴不符
	private String bz;//在用标志：生效、失效
	private String factor;//适用范围，总行，分行
	private String word;//关键字
	private List<String> listfac;
	private List<RuleHgBean> list;
	private int pageSize = 13;
	private int totalPages = -1;
	private int currentPage = -1;
	private int previousPage = 1;
	private int nextPage = 1;
	private int firstPage = 1;
	private int lastPage = 1;
	private long totalRows = -1;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getZhuan() {
		return zhuan;
	}
	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public List<String> getListfac() {
		return listfac;
	}
	public void setListfac(List<String> listfac) {
		this.listfac = listfac;
	}
	public List<RuleHgBean> getList() {
		return list;
	}
	public void setList(List<RuleHgBean> list) {
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
public String execute() throws Exception{
		HeGuiCode hgc = new HeGuiCode();
		YearSeason ys = new YearSeason();
		String sql = "";
		if(word!=null&&zhuan==1)
		{
			factor = new String(factor.getBytes("ISO8859-1"),"UTF-8");
			word = new String(word.getBytes("ISO8859-1"),"UTF-8");
		}
		if(pool==null)
		{
			pool="1";
		}
		if(factor==null)
		{
			factor="all";
		}
		if(bz==null)
		{
			bz="1";
		}
		list = new ArrayList<RuleHgBean>();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		sql = "update t_rc_rule set fac_a='0' where fac_c!='' and length(fac_c)=10 and fac_c<'"+ys.getStdStringDate()+"'";
		session.createSQLQuery(sql).executeUpdate();
		
		sql = "select distinct(factor) from t_rc_rule where plate='合规业务' and pool='"+pool+"' order by pool";
		if(pool.equals("1"))//审核标准
		{
			listfac = new ArrayList<String>();
			sql = "from RcRule where plate='合规业务' and pool='1'";
			if(!word.trim().equals(""))
			{
				sql += " and (part like '%"+word+"%'" +
				" or area like '%"+word+"%'" +
				" or remark like '%"+word+"%'" +
				" or rule like '%"+word+"%'" +
				" or exp like '%"+word+"%'" +
				" or facB like '%"+word+"%'" +
				" or facC like '%"+word+"%'" +
				" or fujian like '%"+word+"%')";
			}
			if(bz.equals("9"))
			{
				sql+=" order by renewdate desc";
			}
			else
			{
				if(bz.equals("0"))
				{
					sql+=" and facA='0'";
				}
				else
				{
					sql+=" and facA!='0'";
				}
				
			}
		}
		else
		{
			listfac = session.createSQLQuery(sql).list();
			sql = "from RcRule where plate='合规业务' and pool='"+pool+"'";
			if(!factor.equals("all"))
			{
				sql += " and factor='"+factor+"'";
			}
			if(!word.trim().equals(""))
			{
				sql += " and (part like'%"+word+"%'" +
				" or area like'%"+word+"%'" +
				" or remark like'%"+word+"%'" +
				" or rule like'%"+word+"%'" +
				" or exp like'%"+word+"%'" +
				" or factor like'%"+word+"%'" +
				" or facB like'%"+word+"%'" +
				" or facC like'%"+word+"%'" +
				" or fujian like'%"+word+"%')";
			}
			if(bz.equals("9"))
			{
				sql+=" order by renewdate desc";
			}
			else
			{
				if(bz.equals("0"))
				{
					sql+=" and facA='0'";
				}
				else
				{
					sql+=" and facA!='0'";
				}
			}
		}
		if(!sql.equals(""))
		{
			System.out.println(sql);
			Query query = session.createQuery(sql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(sql).list().size();
			initPageProperties();
			List<RcRule> listrr=query.list();
			for(int i=0;i<listrr.size();i++)
			{
				RcRule rr = listrr.get(i);
				RuleHgBean rhb = new RuleHgBean();
				rhb.setId(rr.getId());
				rhb.setRenewdate(rr.getRenewdate());
				rhb.setPlate(rr.getPlate());
				rhb.setPool(hgc.poolToGongneng(rr.getPool()));
				rhb.setPart(rr.getPart());
				rhb.setArea(rr.getArea());
				if(rr.getPool().equals("1"))
				{
					sql = "from RcRule where plate='合规业务' and part='"+rr.getPart()+"' and pool='2' and facA='1'";
					List<RcRule> listtmp = session.createQuery(sql).list();
					rhb.setFactor(listtmp);
				}
				if(rr.getPool().equals("2"))
				{
					rhb.setFujian(rr.getFactor());
				}
				if(rr.getPool().equals("3"))
				{
					rhb.setFujian(rr.getFujian());
				}
				rhb.setFacA(hgc.zaiyongToString(rr.getFacA()));
				rhb.setFacB(rr.getFacB());
				rhb.setFacC(rr.getFacC());
				rhb.setRule(rr.getRule());
				rhb.setExp(rr.getExp());
				rhb.setRenewexp(rr.getRenewexp());
				rhb.setRemark(rr.getRemark());
				
				list.add(rhb);
			}
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success"+pool;
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
