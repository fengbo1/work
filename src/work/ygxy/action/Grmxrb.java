package work.ygxy.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.daily.dao.DailyStatusDAO;
import work.daily.pojo.DailyStatus;
import work.hndetail.pojo.HnDetail;
import work.wb.dao.WbYslrDAO;
import work.wb.pojo.WbYslr;
import work.ygxy.dao.YgxyDAO;
import work.ygxy.pojo.Ygxy;

import com.opensymphony.xwork2.ActionContext;
import ccb.hibernate.HibernateSessionFactory;


public class Grmxrb  {

	public Grmxrb() {
		//super(WbDaily.class);
		// TODO Auto-generated constructor stub
	}
	private String  date;
	private String  name;
	private String  outcall;
	private String  sumontime;
	private String  avgincalltime;
	private String  avgafterworktime;
	private String avgworktime;
	private String  perrest;
	private String  avgoutcalltime;
	private String  ftSldhl;
	private String  ftFql;
    private String  ftTdwzjl;
    private String  ftTbjpl;
    private String  ftGdjll;
    private String  ftYjdfl;
    private String  ftYjdflv;
    private String  feDrjsl;
    private String  feYjpjclsc;
    private String  feTbjpl;
    private String  feGdjll;
    private String  feYjdfl;
    private String  feYjdflv;
    private String  steDrjsl;
    private String  steEjpjclsc;
    private String  steTpjpl;
    private String  steGdjll;
    private String  steEjdfl;
    private String  steEjdflv;
    private String  steZsjl;
    private String  steZsjlv;
	private List list;
	private String keyword;
	private String shunxu;
	
	
	

	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getOutcall() {
		return outcall;
	}



	public void setOutcall(String outcall) {
		this.outcall = outcall;
	}



	public String getSumontime() {
		return sumontime;
	}



	public void setSumontime(String sumontime) {
		this.sumontime = sumontime;
	}



	public String getAvgincalltime() {
		return avgincalltime;
	}



	public void setAvgincalltime(String avgincalltime) {
		this.avgincalltime = avgincalltime;
	}



	public String getAvgafterworktime() {
		return avgafterworktime;
	}



	public void setAvgafterworktime(String avgafterworktime) {
		this.avgafterworktime = avgafterworktime;
	}



	public String getAvgworktime() {
		return avgworktime;
	}



	public void setAvgworktime(String avgworktime) {
		this.avgworktime = avgworktime;
	}



	public String getPerrest() {
		return perrest;
	}



	public void setPerrest(String perrest) {
		this.perrest = perrest;
	}



	public String getAvgoutcalltime() {
		return avgoutcalltime;
	}



	public void setAvgoutcalltime(String avgoutcalltime) {
		this.avgoutcalltime = avgoutcalltime;
	}



	public String getFtSldhl() {
		return ftSldhl;
	}



	public void setFtSldhl(String ftSldhl) {
		this.ftSldhl = ftSldhl;
	}



	public String getFtFql() {
		return ftFql;
	}



	public void setFtFql(String ftFql) {
		this.ftFql = ftFql;
	}



	public String getFtTdwzjl() {
		return ftTdwzjl;
	}



	public void setFtTdwzjl(String ftTdwzjl) {
		this.ftTdwzjl = ftTdwzjl;
	}



	public String getFtTbjpl() {
		return ftTbjpl;
	}



	public void setFtTbjpl(String ftTbjpl) {
		this.ftTbjpl = ftTbjpl;
	}



	public String getFtGdjll() {
		return ftGdjll;
	}



	public void setFtGdjll(String ftGdjll) {
		this.ftGdjll = ftGdjll;
	}



	public String getFtYjdfl() {
		return ftYjdfl;
	}



	public void setFtYjdfl(String ftYjdfl) {
		this.ftYjdfl = ftYjdfl;
	}



	public String getFtYjdflv() {
		return ftYjdflv;
	}



	public void setFtYjdflv(String ftYjdflv) {
		this.ftYjdflv = ftYjdflv;
	}



	public String getFeDrjsl() {
		return feDrjsl;
	}



	public void setFeDrjsl(String feDrjsl) {
		this.feDrjsl = feDrjsl;
	}



	public String getFeYjpjclsc() {
		return feYjpjclsc;
	}



	public void setFeYjpjclsc(String feYjpjclsc) {
		this.feYjpjclsc = feYjpjclsc;
	}



	public String getFeTbjpl() {
		return feTbjpl;
	}



	public void setFeTbjpl(String feTbjpl) {
		this.feTbjpl = feTbjpl;
	}



	public String getFeGdjll() {
		return feGdjll;
	}



	public void setFeGdjll(String feGdjll) {
		this.feGdjll = feGdjll;
	}



	public String getFeYjdfl() {
		return feYjdfl;
	}



	public void setFeYjdfl(String feYjdfl) {
		this.feYjdfl = feYjdfl;
	}



	public String getFeYjdflv() {
		return feYjdflv;
	}



	public void setFeYjdflv(String feYjdflv) {
		this.feYjdflv = feYjdflv;
	}



	public String getSteDrjsl() {
		return steDrjsl;
	}



	public void setSteDrjsl(String steDrjsl) {
		this.steDrjsl = steDrjsl;
	}



	public String getSteEjpjclsc() {
		return steEjpjclsc;
	}



	public void setSteEjpjclsc(String steEjpjclsc) {
		this.steEjpjclsc = steEjpjclsc;
	}



	public String getSteTpjpl() {
		return steTpjpl;
	}



	public void setSteTpjpl(String steTpjpl) {
		this.steTpjpl = steTpjpl;
	}



	public String getSteGdjll() {
		return steGdjll;
	}



	public void setSteGdjll(String steGdjll) {
		this.steGdjll = steGdjll;
	}



	public String getSteEjdfl() {
		return steEjdfl;
	}



	public void setSteEjdfl(String steEjdfl) {
		this.steEjdfl = steEjdfl;
	}



	public String getSteEjdflv() {
		return steEjdflv;
	}



	public void setSteEjdflv(String steEjdflv) {
		this.steEjdflv = steEjdflv;
	}



	public String getSteZsjl() {
		return steZsjl;
	}



	public void setSteZsjl(String steZsjl) {
		this.steZsjl = steZsjl;
	}



	public String getSteZsjlv() {
		return steZsjlv;
	}



	public void setSteZsjlv(String steZsjlv) {
		this.steZsjlv = steZsjlv;
	}



	public List getList() {
		return list;
	}



	public void setList(List list) {
		this.list = list;
	}



	public void setShunxu(String shunxu) {
		this.shunxu = shunxu;
	}



	public String getShunxu() {
		return shunxu;
	}


	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String message="success";		
 		List<Ygxy> list =new ArrayList<Ygxy>();		
		//String date= request.getParameter("date");
		// keyword= request.getParameter("keyword");
		//String shunxu= request.getParameter("shunxu");
		if(keyword==null){keyword="ft_yjdfl+0";}
		if(shunxu==null){shunxu="desc";}		
		if(date!=null&&!date.equals("")){		//
		
		//date=date.replace("-", "");
		}else if(date==null||date.equals("")){
			date=findmaxdate();
		}
		list = findbydate(date,keyword,shunxu);		
      
       this.setList(list);
        ActionContext.getContext().put("message", message);
		return "success";
	}
    public  List<Ygxy> findbydate(String date,String keyword,String shunxu) {
    	List<Ygxy> l=new ArrayList<Ygxy>();
    	date=date.replace("-", "");
    	String hql1="from Ygxy as a where a.date=:nd order by locate('-1',fe_drjsl-1),"+" "+keyword+" "+shunxu;
    	Session session=HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	Query query;    
    	if(keyword.equals("ft_sldhl+0")||keyword.equals("ft_yjdfl+0")){   	
    	 hql1="from Ygxy as a where a.date=:nd order by locate('00:00:00',ft_dlsc),"+" "+keyword+" "+shunxu;
    	}
    	if(keyword.equals("fe_yjdfl+0")){   	
       	 hql1="from Ygxy as a where a.date=:nd order by locate('-1',fe_yjdfl-1),"+" "+keyword+" "+shunxu;
       	}
    	if(keyword.equals("ste_drjsl+0")){   	
          	 hql1="from Ygxy as a where a.date=:nd order by locate('-1',ste_drjsl-1),"+" "+keyword+" "+shunxu;
        }
    	if(keyword.equals("fe_drjsl+0")){   	
         	 hql1="from Ygxy as a where a.date=:nd order by locate('-1',fe_drjsl-1),"+" "+keyword+" "+shunxu;
       }
    	if(keyword.equals("ste_ejdfl+0")){   	
        	 hql1="from Ygxy as a where a.date=:nd order by locate('-1',ste_ejdfl-1),"+" "+keyword+" "+shunxu;
      }
    	
    	query=session.createQuery(hql1);    	
    	query.setString("nd", date);    	
    	l = query.list();   
    	trans.commit();
    	session.flush();
    	session.clear(); 
    	session.close(); 
    	return l;    	
    }  public  String findmaxdate() {
    	String date="";
    	Session session=HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	Query query;
    	
    	String hql1="select max(date) from Ygxy";
    	query=session.createQuery(hql1);    	
    		
    	List l = query.list();
    	date =(String) l.get(0);
    	trans.commit();
    	session.flush();
    	session.clear(); 
    	session.close(); 
    	return date;
    	
    }
}
