package work.no.action;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.no.dao.NoDAO;
import work.no.dao.NoLogDAO;
import work.no.pojo.No;
import work.no.pojo.NoLog;
import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.Tld;
import work.util.YearSeason;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class NoAdd extends ActionSupport{

	private String name;
	private int sex;
	private int zx;
	private int xz;
	private int xzwh;
	private int xzjh;
	private int xzsh;
	private int xzjy;
	private String newnumber;
	private String identity;
	private String tel;
	private String no891;
	private String no1;
	private int chu;
	private String key;
	private String oname;
	private String ono;
	private String message;
	private String flag;
	private String password;
	private String comedate;
	private int schedeam;
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
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String execute() throws Exception
	{
		YearSeason ys = new YearSeason();
		No no = new No(name,newnumber, sex, identity, tel,"0","0",zx, xz,xzwh,xzjh,xzsh,xzjy,comedate,no891, no891,no1, "00000000000000000000000000000000000000000000000000", chu, key, schedeam, "00000000000000000000000000000000000000000000000000",0, "", "");
		NoLog nl = new NoLog(name, no891+" "+no891,1,"新增记录","新增记录","新增记录",oname, ys.getDateTime(),"新增记录","","");
		NoDAO dao = new NoDAO();
		NoLogDAO nldao = new NoLogDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String position = "";
		List list = dao.findByNo891(no891);
		List list2 = dao.findAllByNewnumber(newnumber);
		List listui = uidao.findByNo891(no891);
		if(comedate!=null)
		{
			no.setComedate(comedate);
		}
		if(chu==9||chu==0)
		{
			position="99999";
		}
		else
		{
			position = "30"+chu+"0"+key;
		}
		no.setPosition(position);
		if((!list.isEmpty())&&((No)list.get(0)).getNo891().length()>1)
		{
			message = "已有行内891工号"+no891+";不能重复增加！";
		}
		else if((!list2.isEmpty())&&((No)list2.get(0)).getNo895().length()>1)
		{
			message = "已有新员工编号"+newnumber+";不能重复增加！";
		}
		else
		{
			dao.merge(no);
			
			message = "1条记录增加成功";
			nldao.save(nl);
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
	
	
}
