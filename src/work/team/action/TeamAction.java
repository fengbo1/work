package work.team.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.daily.dao.DailyStatusDAO;
import work.team.pojo.Team;
import work.team.pojo.TeamBean;
import work.team.dao.TeamDAO;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class TeamAction extends ActionSupport {
	private String time;
	private String rmb;
	private String wh;
	private String jh;
	private String jy;
	private String fxq;
	private List<TeamBean> teamlist = new ArrayList<TeamBean>();
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRmb() {
		return rmb;
	}
	public void setRmb(String rmb) {
		this.rmb = rmb;
	}
	public List<TeamBean> getTeamlist() {
		return teamlist;
	}
	public String getWh() {
		return wh;
	}
	public void setWh(String wh) {
		this.wh = wh;
	}
	public String getJh() {
		return jh;
	}
	public void setJh(String jh) {
		this.jh = jh;
	}
	public String getJy() {
		return jy;
	}
	public void setJy(String jy) {
		this.jy = jy;
	}
	public String getFxq() {
		return fxq;
	}
	public void setFxq(String fxq) {
		this.fxq = fxq;
	}
	public void setTeamlist(List<TeamBean> teamlist) {
		this.teamlist = teamlist;
	}
	public String execute() throws Exception{
		String temptime = time.replace("-", "");
		TeamDAO tdao = new TeamDAO();
		List<Team>  list = new ArrayList<Team>();
		DailyStatusDAO dsdao = new DailyStatusDAO();
		if(temptime.equals("null"))
		{
			temptime = dsdao.findFinalWithHn();
			time = temptime;
		}
		else
		{
			time = temptime;
			tdao.countTeamToTemp(time, rmb, wh, jh, null, jy, fxq);
		}
		
		
		
		String sql1 = "select * from t_hn_team_t where time='"+temptime+"' and chu='3' and team='0'";
		String sql2 = "select * from t_hn_team_t where time='"+temptime+"' and chu='3' and team in ('1','2','3','4','5','6','7','8','9') order by rjcl desc";
		String sql3 = "select * from t_hn_team_t where time='"+temptime+"' and chu='6' and team='0'";
		String sql4 = "select * from t_hn_team_t where time='"+temptime+"' and chu='6' and team in ('1','2','3','4','5','6','7','8','9') order by rjcl desc";
		String sql5 = "select * from t_hn_team_t where time='"+temptime+"' and chu='2' and team='0'";
		String sql6 = "select * from t_hn_team_t where time='"+temptime+"' and chu='2' and team in ('1','2','3','4','5','6','7','8','9') order by rjcl desc";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<Team> listteam1 = session.createSQLQuery(sql1).addEntity(Team.class).list();
		list.addAll(listteam1);
		List<Team> listteam2 = session.createSQLQuery(sql2).addEntity(Team.class).list();
		list.addAll(listteam2);
		List<Team> listteam3 = session.createSQLQuery(sql3).addEntity(Team.class).list();
		list.addAll(listteam3);
		List<Team> listteam4 = session.createSQLQuery(sql4).addEntity(Team.class).list();
		list.addAll(listteam4);
		List<Team> listteam5 = session.createSQLQuery(sql5).addEntity(Team.class).list();
		list.addAll(listteam5);
		List<Team> listteam6 = session.createSQLQuery(sql6).addEntity(Team.class).list();
		list.addAll(listteam6);
		
		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		
		for(int i=0;i<list.size();i++)
		{
			TeamBean tb = new TeamBean();
			Team team = list.get(i);
			String chu = team.getChu();
			String t = team.getTeam();
			tb.setTime(team.getTime());
			if(chu.equals("3"))
			{
				if(t.equals("0"))
				{
					tb.setTeam("通用业务二处");
					tb.setBgcolor("1");
				}
				else
				{
					tb.setTeam("业务处理"+t+"组");
					tb.setBgcolor("2");
				}
			}
			else if(chu.equals("6"))
			{
				if(t.equals("0"))
				{
					tb.setTeam("专业处理二处");
					tb.setBgcolor("1");
				}
				else
				{
					tb.setTeam("专业处理"+t+"组");
					tb.setBgcolor("2");
				}
			}
			else if(chu.equals("2"))
			{
				if(t.equals("0"))
				{
					tb.setTeam("合规与监督二处");
					tb.setBgcolor("1");
				}
				else if(t.equals("1"))
				{
					tb.setTeam("稽核组");
					tb.setBgcolor("2");
				}
				else if(t.equals("2"))
				{
					tb.setTeam("反洗钱组");
					tb.setBgcolor("2");
				}
				else if(t.equals("3"))
				{
					tb.setTeam("柜面授权组");
					tb.setBgcolor("2");
				}
			}
			tb.setCl(Tld.DoubleTo0(team.getCl()));
			tb.setClrmb(Tld.DoubleTo0(team.getClrmb()));
			tb.setClwh(Tld.DoubleTo0(team.getClwh()));
			tb.setCljh(Tld.DoubleTo0(team.getCljh()));
			tb.setClsh(Tld.DoubleTo0(team.getClsh()));
			tb.setCljy(Tld.DoubleTo0(team.getCljy()));
			tb.setClfxq(Tld.DoubleTo0(team.getClfxq()));
			
			tb.setRjcl(Tld.DoubleTo0(team.getRjcl()));
			tb.setRjclrmb(Tld.DoubleTo0(team.getRjclrmb()));
			tb.setRjclwh(Tld.DoubleTo0(team.getRjclwh()));
			tb.setRjcljh(Tld.DoubleTo0(team.getRjcljh()));
			tb.setRjclsh(Tld.DoubleTo0(team.getRjclsh()));
			tb.setRjcljy(Tld.DoubleTo0(team.getRjcljy()));
			tb.setRjclfxq(Tld.DoubleTo0(team.getRjclfxq()));
			
			tb.setCcl(Tld.DoubleToPercentNew(team.getClrmb()+team.getClwh()+team.getCljy(),team.getCcl()));
			tb.setCclrmb(Tld.DoubleToPercentNew(team.getClrmb(),team.getCclrmb()));
			tb.setCclwh(Tld.DoubleToPercentNew(team.getClwh(),team.getCclwh()));
			tb.setCcljy(Tld.DoubleToPercentNew(team.getCljy(),team.getCcljy()));
			
			tb.setXl(Tld.DoubleTo2(team.getXl()));
			tb.setXlrmb(Tld.DoubleTo2(team.getXlrmb()));
			tb.setXlwh(Tld.DoubleTo2(team.getXlwh()));
			tb.setXljy(Tld.DoubleTo2(team.getXljy()));
			
			teamlist.add(tb);
		}
		if(time.length()==8)
		{
			time = time.substring(0, 4)+"-"+time.substring(4, 6)+"-"+time.substring(6, 8);
		}
		return "success";
	}
}
