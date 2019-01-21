


package work.hndetail.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import work.daily.dao.DailyStatusDAO;
import work.hn.pojo.Hn891;
import work.hndetail.pojo.HnDetail;
import work.hndetail.pojo.HnDetailExpress;
import work.hndetail.pojo.HnSimple;
import work.percl.dao.PerclDAO;
import work.util.GeneralCheck;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;
/**
 * 页面展示用
 * @author htzx
 *
 */
public class ExpressReport {

	private String time;//时间
	private String temptime;
	private String type;//快报，日报
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
	private List<HnDetailExpress> list = new ArrayList<HnDetailExpress>();
	


	public String getTime() {
		return time;
	}


	public String getTemptime() {
		return temptime;
	}


	public void setTemptime(String temptime) {
		this.temptime = temptime;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}

	public List<HnDetailExpress> getList() {
		return list;
	}


	public void setList(List<HnDetailExpress> list) {
		this.list = list;
	}


	public int getSequence() {
		return sequence;
	}


	public void setSequence(int sequence) {
		this.sequence = sequence;
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

	public int getPercl() {
		return percl;
	}


	public void setPercl(int percl) {
		this.percl = percl;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		String message="success";
		Integer hndaily= 0;
		PerclDAO pdao = new PerclDAO();
		DailyStatusDAO dsdao = new DailyStatusDAO();
		temptime = time.replace("-", "");
		if(temptime.equals("null"))
		{
			temptime = dsdao.findFinalWithHn();
		}
		String hql = "from HnDetail as h where (h.ljcl>0 or h.ljcx>0 or h.ljtp>0) and h.time='"+temptime+"'";
		List<HnDetail> listhd = new ArrayList<HnDetail>();
		GeneralCheck check = new GeneralCheck();
		//DailyStatusDAO dsdao = new DailyStatusDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		//String sql = "from Hndetail as hd where hd.temptime=:t order by hd."+key+" desc";
		System.out.println(temptime);
		if(getTime()==null||temptime.isEmpty()||temptime.length()<1)
		{
			 ActionContext.getContext().put("message", "请选择正确的日期！");
			 return "error";
		}
		//String temptime = time.replace("-", "");
		System.out.println(time+"-->"+temptime);
		//time = temptime;
		if(temptime.length()==8)
		{
			time = temptime.substring(0, 4)+"-"+temptime.substring(4, 6)+"-"+temptime.substring(6, 8);
		}
		
		if(dsdao.findByTime(temptime)!=null)
		{
			hndaily = dsdao.findByTime(temptime).getHnDaily();
		}
		
		if(hndaily==null||hndaily!=1)
		{
			type = "quick";
		}
		else
		{
			type = "daily";
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
		try {
			Query query;
			if(keyword!=null)
			hql +=" and (h.no like '%"+strtemp+"%' or h.name like '%"+strtemp+"%')";
			if(zx!=2)
			{
				if(zx==3)
				{
					hql = hql+" and h.zx=0";
					xz = 5;
				}
				else if(zx==4)
				{
					hql = hql+" and h.zx=1";
					xz = 5;
				}
				else
				{
					hql = hql+" and h.zx="+zx;
				}
			}
			if(xz!=4)
			{
				if(xz==5)
				{
					hql = hql+" and h.xz in (0,1,2)";
				}
				else
				{
					hql = hql+" and h.xz="+xz;
				}	
			}
			if(team!=0)
			{
				hql = hql+" and h.team="+team;
			}
			if(key.equals("wu"))
			{
				hql = hql+" order by h.zyzl desc , h.ljrjcl";
			}
			else
			{
				hql = hql+" order by h."+key;
			}
			if(sequence==1)
			{
				hql = hql+" desc";
			}
			hql = hql+" , h.output desc";
			//String sqltemp = "from HnDetail as h where h.time='20150103' order by h.ljrjcl desc";
			//hql="from HnDetail as h where h.time=:d and h.xz=:x and h.zx=:z and h.team=:t order by h.ljrjcl desc";
			System.out.println(hql);
			query=session.createQuery(hql);
			listhd = query.list();
		}catch (RuntimeException re) {
	        throw re;
	    }
		if(!listhd.isEmpty())
		//percl = check.DoubleToInteger0(Double.parseDouble(listhd.get(0).getRemark5()));
		percl = check.DoubleToInteger0(pdao.findPercl(temptime));
		for(int i=0;i<listhd.size();i++)
        {
        	HnDetail hd = listhd.get(i);
        	HnDetailExpress hde = new HnDetailExpress();
        	
        	//HnSimple hs = getHn891Simple(session,hd.getTime(),hd.getNo());
			hde.setId(i+1);
			hde.setNo(hd.getNo());
			hde.setTime(hd.getTime());
			hde.setName(hd.getName());
			hde.setZx(Tld.zxToString(hd.getZx()));
			hde.setXz(Tld.xzintToShortString(hd.getXz()));
			hde.setTeam(Tld.posToTeamShort(hd.getTeam()));
			hde.setPercltime(Tld.DoubleTo2(hd.getPercltime()));
			hde.setZyccl(Tld.DoubleDoubleToPercentNew(hd.getOutput(),hd.getZyccl()));
			hde.setOutput891(hengToDouble(Tld.DoubleTo0(hd.getOutput891())));
			hde.setOutput895(hengToDouble(Tld.DoubleTo0(hd.getOutput895())));
			hde.setOutput(hengToInteger(Tld.DoubleTo0(hd.getOutput())));
			hde.setCcl891(Tld.DoubleToPercentNew(check.IsNullInteger(hd.getLrxg())+check.IsNullInteger(hd.getJhxg()),hd.getCcl891()));//
			hde.setCxl891(Tld.DoubleDoubleToPercentNew(hd.getOutput891(),hd.getCxl891()));
			hde.setTpl891(Tld.DoubleDoubleToPercentNew(hd.getOutput891(),hd.getTpl891()));
			hde.setCcl895(Tld.DoubleDoubleToPercentNew(hd.getOutput895(),hd.getCcl895()));//
			hde.setCxl895(Tld.DoubleDoubleToPercentNew(hd.getOutput895(),hd.getCxl895()));
			hde.setTpl895(Tld.DoubleDoubleToPercentNew(hd.getOutput895(),hd.getTpl895()));
			hde.setLjrjcl(hengToInteger(Tld.DoubleTo0(hd.getLjrjcl())));
			hde.setRjclwcl(Tld.DoubleToPercentNew(check.IsNullInteger(hd.getLjsxts()),hd.getRjclwcl()));
			hde.setLjcl(hengToInteger(Tld.DoubleTo0(hd.getLjcl())));
			hde.setRjccl891(Tld.DoubleToPercentNew(check.IsNullInteger(hd.getLjlr())+check.IsNullInteger(hd.getLjjh()),hd.getRjccl891()));//
			hde.setRjcxl891(Tld.DoubleToPercentNew(hd.getLjywl891(),hd.getRjcxl891()));//
			hde.setRjtpl891(Tld.DoubleToPercentNew(hd.getLjywl891(),hd.getRjtpl891()));//
			hde.setRjccl895(Tld.DoubleToPercentNew(check.IsNullInteger(hd.getLjlr895())+check.IsNullInteger(hd.getLjjh895()),hd.getRjccl895()));//
			hde.setRjcxl895(Tld.DoubleToPercentNew(hd.getLjywl895(),hd.getRjcxl895()));//
			hde.setRjtpl895(Tld.DoubleToPercentNew(hd.getLjywl895(),hd.getRjtpl895()));//
			hde.setLjqdlrzl(Tld.DoubleToPercentNew(check.IsNullInteger(hd.getLjqdlr()),hd.getLjqdlrzl()));
			hde.setLjsxts(hengToInteger(Tld.IntegerToString(hd.getLjsxts())));
			hde.setZyzl(Tld.zuoyezhiliang(hd.getZyzl()));
			hde.setOnline(hengToInteger(Tld.IntegerToString(hd.getOnline())));
			
			
			//hde.setRemarkteam(Tld.IntegerToString(hd.getTeam()));
			list.add(hde);
        }
		trans.commit();
        session.flush();
        session.clear();
        session.close();
        
        ActionContext.getContext().put("message", message);
		return "success";
	}
	
	/**
	 * 
	 * @param session
	 * @param btime
	 * @param etime
	 * @param no
	 * @return
	 */
	public HnSimple getHn891Simple(Session session,String etime,String no)
	{
		GeneralCheck check = new GeneralCheck();
		String btime =etime.substring(0,6)+"01";
		String sqlcdtemp = "select * from hn891 where time<='"+etime+"' and time>='"+btime+"' and no='"+no+"' order by time desc";
		Query querycdtemp = session.createSQLQuery(sqlcdtemp).addEntity(Hn891.class);
		List<Hn891> list891 = new ArrayList<Hn891>();
		HnSimple hs = new HnSimple();
		list891 = (List<Hn891>)querycdtemp.list();
		int ljlr = 0;
		int ljjh = 0;
		for(int i=0;i<list891.size();i++)
		{
			ljlr+=check.IsNullInteger(list891.get(i).getLrxg());
			ljjh+=check.IsNullInteger(list891.get(i).getJhxg());
		}
		hs.setNo(no);
		hs.setLjlr(ljlr);
		hs.setLjjh(ljjh);
		if(list891.size()>0)
		{
			hs.setDtlr(check.IsNullInteger(list891.get(0).getLrxg()));
			hs.setDtjh(check.IsNullInteger(list891.get(0).getJhxg()));
		}
		else
		{
			hs.setDtlr(0);
			hs.setDtjh(0);
		}
		
		return hs;
	}
	public String hengToInteger(String input)
	{
		if(input.equals("-"))
		{
			return "0";
		}
		else
			return input;
	}
	public String hengToDouble(String input)
	{
		if(input.equals("-"))
		{
			return "0.0";
		}
		else
			return input;
	}
	public String zeroToHeng(String input)
	{
		if(input==null)
		{
			return "-";
		}
		else if(input.equals("0.0"))
		{
			return "-";
		}
		else
			return input;
	}
	public String zeroToHeng(Integer a,Double b)
	{
		if(a==null)
		{
			return "-";
		}
		else if(a==0)
		{
			return "-";
		}
		else
		{
			if(b==null)
				return "-";
			else
			return String.valueOf(Tld.DoubleToPercent(b));
		}
	}
	
}
