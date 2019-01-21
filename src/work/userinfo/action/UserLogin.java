package work.userinfo.action;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.ControlDAO;
import work.control.pojo.Control;
import work.log.action.LogOperation;
import work.no.pojo.No;
import work.team.dao.TeamDAO;
import work.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport implements ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private Session h_session;
    private Transaction trans;
    private String hql;
    private Query query;
    private String bt;
    private String et;
    private int errNum = 0;
    private int restNum;
    Timestamp d = new Timestamp(System.currentTimeMillis());
    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Session getSession() {
		return h_session;
	}


	public void setSession(Session h_session) {
		this.h_session = h_session;
	}


	public Transaction getTrans() {
		return trans;
	}


	public void setTrans(Transaction trans) {
		this.trans = trans;
	}


	public String getHql() {
		return hql;
	}


	public void setHql(String hql) {
		this.hql = hql;
	}


	public String getBt() {
		return bt;
	}


	public void setBt(String bt) {
		this.bt = bt;
	}


	public String getEt() {
		return et;
	}


	public void setEt(String et) {
		this.et = et;
	}


	public Query getQuery() {
		return query;
	}


	public void setQuery(Query query) {
		this.query = query;
	}
     public void setServletResponse(HttpServletResponse response)
       {
       }

	public String execute() throws Exception
	{
	/*固定写法*/
			TeamDAO teamdao = new TeamDAO();
		  LogOperation lo = new LogOperation();
		  ControlDAO condao = new ControlDAO();
		  //上线时取消
		  //username=new String(username.getBytes("ISO8859-1"),"UTF-8");//
		  int views = 0;//访问量统计
		  Control control = (Control) condao.findAll().get(0);
		  h_session=HibernateSessionFactory.getSession();
		  trans=h_session.beginTransaction();
		  
		  et = teamdao.findMaxDate();
			if(et.substring(4, 6).equals("01"))
			{
				bt = String.valueOf((Integer.parseInt(et.substring(0, 4))-1))+"12"+et.substring(6, 8);
			}
			else
			{
				bt = et.substring(0, 4)+String.valueOf((Integer.parseInt(et.substring(4, 6))-1))+et.substring(6, 8);
				if(bt.length()==7)
				{
					bt=bt.substring(0, 4)+"0"+bt.substring(4, 7);
				}
			}
			bt=bt.substring(0, 4)+"-"+bt.substring(4, 6)+"-"+bt.substring(6, 8);
			et=et.substring(0, 4)+"-"+et.substring(4, 6)+"-"+et.substring(6, 8);
		  
		  hql="from No where name='"+username+"' and position!='99999'";
		  query=h_session.createQuery(hql);

          List l=query.list();
         
     	  if((l==null)||(l.size()<=0))
     	  {
     		  this.addFieldError("用户","用户不存在!");
			  return "false";
     	  }
     	  else 
     	  {
     		 No u=(No)(l.get(0));
     		  id=u.getId();
     		  username = this.getUsername();
     		  password = this.getPassword();
     		  System.out.print("username:"+username);
     		  System.out.print("time1"+d);
        	  ActionContext.getContext().getSession().put("username",u.getName());
        	  ActionContext.getContext().getSession().put("role",u.getRole());
        	  ActionContext.getContext().getSession().put("position",u.getPosition());
        	  ActionContext.getContext().getSession().put("zhi",u.getPosition().substring(0,1));//30303
        	  ActionContext.getContext().getSession().put("chu",u.getPosition().substring(2,3));//30303
        	  ActionContext.getContext().getSession().put("zu",u.getPosition().substring(4,5));//30303
        	  ActionContext.getContext().getSession().put("no891",u.getNo891());
        	  ActionContext.getContext().getSession().put("id",id);
        	  //访问量统计
        	  if(control.getRemark1()==null)
        	  {
        		  control.setRemark1("1");
        	  }
        	  else
        	  {
        		  views = Integer.parseInt(control.getRemark1());
        		  views+=1;
        		  control.setRemark1(String.valueOf(views));
        	  }
        	  ActionContext.getContext().getSession().put("views",views);
        	  condao.merge(control);
        	  trans.commit();
        	  h_session.flush();
        	  h_session.clear();
        	  h_session.close();
        	  //lo.addLog(u.getUsername(),"登陆了生产信息管理工具",u.getNo891());
        	  return "success";
     	  }
     	 
	}
}
