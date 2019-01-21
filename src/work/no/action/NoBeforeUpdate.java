package work.no.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import work.control.dao.CfgXzDAO;
import work.control.dao.UserCfgDAO;
import work.control.pojo.CfgXz;
import work.control.pojo.NameValueBean;
import work.no.dao.NoDAO;
import work.no.pojo.No;
import work.no.pojo.NoLog;

public class NoBeforeUpdate {

	private int id;
	private String chu;
	private String zhi;
	private String chuteam;
	private String team;
	private int schedeam;
	private int xz;
	private int xzwh;
	private int xzjh;
	private int xzsh;
	private int xzjy;
	private List<NameValueBean> listnv;
	private No entity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String getZhi() {
		return zhi;
	}
	public void setZhi(String zhi) {
		this.zhi = zhi;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getChuteam() {
		return chuteam;
	}
	public void setChuteam(String chuteam) {
		this.chuteam = chuteam;
	}
	public No getEntity() {
		return entity;
	}
	public void setEntity(No entity) {
		this.entity = entity;
	}
	public int getSchedeam() {
		return schedeam;
	}
	public void setSchedeam(int schedeam) {
		this.schedeam = schedeam;
	}
	public int getXz() {
		return xz;
	}
	public void setXz(int xz) {
		this.xz = xz;
	}
	public int getXzwh() {
		return xzwh;
	}
	public void setXzwh(int xzwh) {
		this.xzwh = xzwh;
	}
	public int getXzjh() {
		return xzjh;
	}
	public void setXzjh(int xzjh) {
		this.xzjh = xzjh;
	}
	public int getXzsh() {
		return xzsh;
	}
	public void setXzsh(int xzsh) {
		this.xzsh = xzsh;
	}
	public int getXzjy() {
		return xzjy;
	}
	public void setXzjy(int xzjy) {
		this.xzjy = xzjy;
	}
	public List<NameValueBean> getListnv() {
		return listnv;
	}
	public void setListnv(List<NameValueBean> listnv) {
		this.listnv = listnv;
	}
	public String execute() throws Exception
	{
		zhi = "0";
		chu = "0";
		chuteam = "0";
		schedeam =1;
		xz = 1;
		xzwh = 1;
		xzjh = 1;
		xzsh = 1;
		xzjy = 1;
		NoDAO nodao = new NoDAO();
		UserCfgDAO ucdao = new UserCfgDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		entity = nodao.findById(id);
		if(entity.getPosition()!=null)
		{
			String position=entity.getPosition();
			if(position.length()>4)
			{
				zhi = position.substring(0, 1);
				chu = position.substring(2, 3);
				chuteam = position.substring(4, 5);
				listnv = ucdao.findIndexByTypeAndNum("chu",chu);
			}
		}
		if(entity.getSchedeam()!=null)
		{
			schedeam = entity.getSchedeam();
		}
		if(entity.getTeam()!=null)
		{
			team = entity.getTeam();
		}
		if(entity.getXz()!=null)
		{
			xz = entity.getXz();
		}
		if(entity.getXzwh()!=null)
		{
			xzwh = entity.getXzwh();
		}
		if(entity.getXzjh()!=null)
		{
			xzjh = entity.getXzjh();
		}
		if(entity.getXzsh()!=null)
		{
			xzsh = entity.getXzsh();
		}
		if(entity.getXzjy()!=null)
		{
			xzjy = entity.getXzjy();
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
