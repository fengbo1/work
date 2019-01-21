package work.no.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import work.no.dao.NoDAO;
import work.no.dao.NoLogDAO;
import work.no.pojo.No;
import work.no.pojo.NoLog;
import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.YearSeason;

public class NoToUpdate {

	private int id;
	private String ono;//操作者工号
	private String oname;
	private String name;
	private String newnumber;
	private int sex;
	private int zx;
	private int xz;
	private int xzwh;
	private int xzjh;
	private int xzsh;
	private int xzjy;
	private String identity;
	private String tel;
	private String no891;
	private String no1;
	private String no2;
	private int zhi;
	private int chu;
	private String key;
	private String comedate;
	private int schedeam;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}


	public String getOname() {
		return oname;
	}


	public void setOname(String oname) {
		this.oname = oname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public int getZx() {
		return zx;
	}


	public void setZx(int zx) {
		this.zx = zx;
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
	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getNo891() {
		return no891;
	}


	public void setNo891(String no891) {
		this.no891 = no891;
	}

	public String getNo1() {
		return no1;
	}
	public void setNo1(String no1) {
		this.no1 = no1;
	}
	public String getNo2() {
		return no2;
	}
	public void setNo2(String no2) {
		this.no2 = no2;
	}
	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getComedate() {
		return comedate;
	}

	public void setComedate(String comedate) {
		this.comedate = comedate;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public int getSchedeam() {
		return schedeam;
	}
	public void setSchedeam(int schedeam) {
		this.schedeam = schedeam;
	}
	public int getZhi() {
		return zhi;
	}
	public void setZhi(int zhi) {
		this.zhi = zhi;
	}
	public String execute() throws Exception
	{
		NoDAO nodao = new NoDAO();
		String para ="";
		String bef = "";
		String aft = "";
		UserInfoDAO uidao = new UserInfoDAO();
		NoLogDAO nldao = new NoLogDAO();
		No noold = nodao.findById(id);
		YearSeason ys = new YearSeason();
		No no = new No();
		NoLog nl = new NoLog();
		no.setId(id);
		no.setChu(chu);
		no.setIdentity(identity);
		no.setName(name);
		no.setNewnumber(newnumber);
		no.setNo891(no891);
		no.setNo1(no1);
		no.setNo2(no2);
		no.setSex(sex);
		no.setTeam(key);
		
		no.setTel(tel);
		no.setZx(zx);
		no.setXz(xz);
		no.setXzwh(xzwh);
		no.setXzjh(xzjh);
		no.setXzsh(xzsh);
		no.setXzjy(xzjy);
		no.setSchedeam(schedeam);
		nl.setName(name);
		nl.setOperator(oname);
		nl.setNo(no891);
		nl.setType(1);
		nl.setTime(ys.getDateTime());
		if(comedate!=null)
		{
			no.setComedate(comedate);
		}
		if(chu!=noold.getChu())
		{
			para+="|处室";
			bef+="|";
			aft+="|";
			bef+=noold.getChu();
			aft+=chu;
		}
		if(!identity.equalsIgnoreCase(noold.getIdentity()))
		{
			para+="|身份证号";
			bef+="|";
			aft+="|";
			bef+=noold.getIdentity();
			aft+=identity;
		}
		if(!name.equalsIgnoreCase(noold.getName()))
		{
			para+="|姓名";
			bef+="|";
			aft+="|";
			bef+=noold.getName();
			aft+=name;
		}
		if(!no891.equalsIgnoreCase(noold.getNo891()))
		{
			para+="|891工号";
			bef+="|";
			aft+="|";
			bef+=noold.getNo891();
			aft+=no891;
		}
		if(sex!=noold.getSex())
		{
			para+="|性别";
			bef+="|";
			aft+="|";
			bef+=noold.getSex();
			aft+=sex;
		}
		if(key!=noold.getTeam())
		{
			para+="|分组";
			bef+="|";
			aft+="|";
			bef+=noold.getTeam();
			aft+=key;
		}
		if(zx!=noold.getZx())
		{
			para+="|中心";
			bef+="|";
			aft+="|";
			bef+=noold.getZx();
			aft+=zx;
		}
		nl.setPara(para);
		nl.setBef(bef);
		nl.setAft(aft);
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		if(chu==9||chu==0)
		{
			no.setPosition("99999");
		}
		else
		{
			no.setPosition(zhi+"0"+chu+"0"+key);
			if(zhi==4)
			{
				no.setRole("10");
			}
			else if(zhi==1)
			{
				no.setRole("7");
			}
		}
		nodao.merge(no);
		nldao.save(nl);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
