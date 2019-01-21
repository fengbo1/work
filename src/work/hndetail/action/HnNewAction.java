package work.hndetail.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.daily.dao.DailyStatusDAO;
import work.hndetail.dao.HnNewDAO;
import work.hndetail.pojo.HnNew;
import work.percl.dao.PerclDAO;
import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.GeneralCheck;
import ccb.hibernate.HibernateSessionFactory;

public class HnNewAction {
	private String date;
	private String temptime;
	private int xz;//人员性质
	private int zx;//所属中心
	private int team;//分组
	private int sequence;
	private int percl;
	private String key;//关键字名称
	private String keytb;
	private String keyword;
	private String strtemp;
	private int zhuan;
	private String name;
	private List<HnNew> list;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTemptime() {
		return temptime;
	}
	public void setTemptime(String temptime) {
		this.temptime = temptime;
	}
	public int getXz() {
		return xz;
	}
	public void setXz(int xz) {
		this.xz = xz;
	}
	public int getZx() {
		return zx;
	}
	public void setZx(int zx) {
		this.zx = zx;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public int getPercl() {
		return percl;
	}
	public void setPercl(int percl) {
		this.percl = percl;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKeytb() {
		return keytb;
	}
	public void setKeytb(String keytb) {
		this.keytb = keytb;
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
	public List<HnNew> getList() {
		return list;
	}
	public void setList(List<HnNew> list) {
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String execute() throws Exception
	{
		String hql = "";
		PerclDAO pdao = new PerclDAO();
		HnNewDAO hndao = new HnNewDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		GeneralCheck check = new GeneralCheck();
		DailyStatusDAO dsdao = new DailyStatusDAO();
		temptime = date.replace("-", "");
		
		if(temptime.equals("null"))
		{
			temptime = dsdao.findFinalWithHn();
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from HnNew as hn where hn.date='"+temptime+"' and hn.cl>0";
			if(temptime.length()==8)
			{
				date = temptime.substring(0, 4)+"-"+temptime.substring(4, 6)+"-"+temptime.substring(6, 8);
			}
			if(name!=null&&zhuan==1)
			{
				name = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			UserInfo ui = uidao.findAllByName(name);
			if(keyword!=null)
			{
				hql +=" and (hn.no like '%"+keyword+"%' or hn.name like '%"+keyword+"%')";
				if(team!=0&&zx==0)
				{
					if(ui!=null&&team!=0&&zx==0)
					{
						String pos = ui.getPosition();
						char zhi = pos.charAt(0);
						char chu = pos.charAt(2);
						char zu = pos.charAt(4);
						char role = ui.getRole().charAt(0);
						if(zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9')
						{
							
						}
						else if(zhi=='2')
						{
							hql+=" and hn.pos like '__"+chu+"__'";
						}
						else if(zhi=='3')
						{
							hql+=" and hn.no='"+ui.getNo891()+"'";
						}
						else if(zhi=='4')
						{
							hql+=" and hn.pos like '__"+chu+"_"+zu+"'";
						}
					}
					else
					{
						hql+=" and hn.name='"+name+"'";
					}
				}
			}
			else if(ui!=null)
			{
				String pos = ui.getPosition();
				char zhi = pos.charAt(0);
				char chu = pos.charAt(2);
				char zu = pos.charAt(4);
				char role = ui.getRole().charAt(0);
				if(zhi=='0'||zhi=='1'||role=='6'||role=='7'||role=='9')
				{
					
				}
				else if(zhi=='2')
				{
					hql+=" and hn.pos like '__"+chu+"__'";
				}
				else if(zhi=='3')
				{
					hql+=" and hn.no='"+ui.getNo891()+"'";
				}
				else if(zhi=='4')
				{
					hql+=" and hn.pos like '__"+chu+"_"+zu+"'";
				}
			}
			else
			{
				hql+=" and hn.name='"+name+"'";
			}
			if(zx!=2)
			{
//				if(zx==3)
//				{
//					hql = hql+" and hn.zx=0";
//					xz = 5;
//				}
//				else if(zx==4)
//				{
//					hql = hql+" and hn.zx=1";
//					xz = 5;
//				}
//				else
//				{
					hql = hql+" and hn.zx="+zx;
//				}
			}
			if(xz!=5)
			{
//				if(xz==5)
//				{
//					hql = hql+" and hn.xz in (0,1,2)";
//				}
//				else
//				{
					hql = hql+" and hn.xz="+xz;
//				}	
			}
			if(team!=0)
			{
				hql = hql+" and hn.pos like '____"+team+"'";
			}
			hql = hql+" order by";
			if(!key.equals("wu"))
			{
				hql = hql+" hn."+key;
				if(sequence==1)
				{
					hql = hql+" desc";
				}
				hql = hql+",";
			}
			
			hql = hql+" hn.rjcl desc";
			System.out.println(hql);
			list = session.createQuery(hql).list();
			
			if(!list.isEmpty())
			{
				percl = check.DoubleToInteger0(pdao.findPercl(temptime));
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
}
