package work.hndetail.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import work.hn.dao.Hn891DAO;
import work.hn.dao.Hn895DAO;
import work.hn.dao.HnFxqDAO;
import work.hn.dao.HnJianyaDAO;
import work.hn.dao.HnJiheDAO;
import work.hn.dao.HnWaihuiDAO;
import work.hn.dao.HnYcshDAO;
import work.hn.pojo.Hn891;
import work.hn.pojo.Hn895;
import work.hn.pojo.HnFxq;
import work.hn.pojo.HnJianya;
import work.hn.pojo.HnJihe;
import work.hn.pojo.HnWaihui;
import work.hn.pojo.HnYcsh;
import work.hndetail.dao.HnDetailDAO;
import work.hndetail.pojo.HnDetail;
import work.hndetail.pojo.HnDetailExpress;
import work.no.dao.NoDAO;
import work.no.pojo.No;
import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.GeneralCheck;
import work.util.Tld;

public class HnNewDetailAction {

	private String no;
	private String date;
	private String name;
	private Hn891 hn891;
	private Hn895 hn895;
	private HnDetailExpress hd;
	private HnWaihui hw;
	private HnJihe jh;
	private HnYcsh hy;
	private HnJianya jy;
	private HnFxq fxq;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
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
	public Hn891 getHn891() {
		return hn891;
	}
	public void setHn891(Hn891 hn891) {
		this.hn891 = hn891;
	}
	public Hn895 getHn895() {
		return hn895;
	}
	public void setHn895(Hn895 hn895) {
		this.hn895 = hn895;
	}
	public HnWaihui getHw() {
		return hw;
	}
	public void setHw(HnWaihui hw) {
		this.hw = hw;
	}
	public HnJihe getJh() {
		return jh;
	}
	public void setJh(HnJihe jh) {
		this.jh = jh;
	}
	public HnYcsh getHy() {
		return hy;
	}
	public void setHy(HnYcsh hy) {
		this.hy = hy;
	}
	public HnDetailExpress getHd() {
		return hd;
	}
	public void setHd(HnDetailExpress hd) {
		this.hd = hd;
	}
	public HnJianya getJy() {
		return jy;
	}
	public void setJy(HnJianya jy) {
		this.jy = jy;
	}
	public HnFxq getFxq() {
		return fxq;
	}
	public void setFxq(HnFxq fxq) {
		this.fxq = fxq;
	}
	public String execute() throws Exception
	{
		ExpressReport er = new ExpressReport();
		Hn891DAO hn1dao = new Hn891DAO();
		Hn895DAO hn5dao = new Hn895DAO();
		NoDAO nodao = new NoDAO();
		GeneralCheck check = new GeneralCheck();
		HnWaihuiDAO whdao = new HnWaihuiDAO();
		HnDetailDAO hddao = new HnDetailDAO();
		HnJiheDAO jhdao = new HnJiheDAO();
		HnYcshDAO hydao = new HnYcshDAO();
		HnJianyaDAO jydao = new HnJianyaDAO();
		HnFxqDAO fxqdao = new HnFxqDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			HnDetail hdd = hddao.findByDateAndNo(date, no);
			hn891 = hn1dao.findByDateAndNo(date, no);
			hn895 = hn5dao.findByDateAndNo(date, no);
			hw = whdao.findAllByDateAndNo(date, no);
			jy = jydao.findAllByDateAndNo(date, no);
			
			
			List<No> list = nodao.findBy891No(no);
			if(!list.isEmpty())
			{
				No nnn = list.get(0);
				name=nnn.getName();
				jh = jhdao.findAllByDateAndName(date, nnn.getName());
				hy = hydao.findAllByDateAndName(date, nnn.getName());
				fxq = fxqdao.findAllByDateAndName(date, nnn.getName());
			}
			
			hd = new HnDetailExpress(); 
			hd.setNo(hdd.getNo());
			hd.setTime(hdd.getTime());
			hd.setName(hdd.getName());
			hd.setZx(Tld.zxToString(hdd.getZx()));
			hd.setXz(Tld.xzintToShortString(hdd.getXz()));
			hd.setTeam(Tld.posToTeamShort(hdd.getTeam()));
			hd.setPercltime(Tld.DoubleTo2(hdd.getPercltime()));
			hd.setZyccl(Tld.DoubleDoubleToPercentNew(hdd.getOutput(),hdd.getZyccl()));
			hd.setOutput891(er.hengToDouble(Tld.DoubleTo0(hdd.getOutput891())));
			hd.setOutput895(er.hengToDouble(Tld.DoubleTo0(hdd.getOutput895())));
			hd.setOutput(er.hengToInteger(Tld.DoubleTo0(hdd.getOutput())));
			hd.setCcl891(Tld.DoubleToPercentNew(check.IsNullInteger(hdd.getLrxg())+check.IsNullInteger(hdd.getJhxg()),hdd.getCcl891()));//
			hd.setCxl891(Tld.DoubleDoubleToPercentNew(hdd.getOutput891(),hdd.getCxl891()));
			hd.setTpl891(Tld.DoubleDoubleToPercentNew(hdd.getOutput891(),hdd.getTpl891()));
			hd.setCcl895(Tld.DoubleDoubleToPercentNew(hdd.getOutput895(),hdd.getCcl895()));//
			hd.setCxl895(Tld.DoubleDoubleToPercentNew(hdd.getOutput895(),hdd.getCxl895()));
			hd.setTpl895(Tld.DoubleDoubleToPercentNew(hdd.getOutput895(),hdd.getTpl895()));
			hd.setLjrjcl(er.hengToInteger(Tld.DoubleTo0(hdd.getLjrjcl())));
			hd.setRjclwcl(Tld.DoubleToPercentNew(check.IsNullInteger(hdd.getLjsxts()),hdd.getRjclwcl()));
			hd.setLjcl(er.hengToInteger(Tld.DoubleTo0(hdd.getLjcl())));
			hd.setRjccl891(Tld.DoubleToPercentNew(check.IsNullInteger(hdd.getLjlr())+check.IsNullInteger(hdd.getLjjh()),hdd.getRjccl891()));//
			hd.setRjcxl891(Tld.DoubleToPercentNew(hdd.getLjywl891(),hdd.getRjcxl891()));//
			hd.setRjtpl891(Tld.DoubleToPercentNew(hdd.getLjywl891(),hdd.getRjtpl891()));//
			hd.setRjccl895(Tld.DoubleToPercentNew(check.IsNullInteger(hdd.getLjlr895())+check.IsNullInteger(hdd.getLjjh895()),hdd.getRjccl895()));//
			hd.setRjcxl895(Tld.DoubleToPercentNew(hdd.getLjywl895(),hdd.getRjcxl895()));//
			hd.setRjtpl895(Tld.DoubleToPercentNew(hdd.getLjywl895(),hdd.getRjtpl895()));//
			hd.setLjqdlrzl(Tld.DoubleToPercentNew(check.IsNullInteger(hdd.getLjqdlr()),hdd.getLjqdlrzl()));
			hd.setLjsxts(er.hengToInteger(Tld.IntegerToString(hdd.getLjsxts())));
			hd.setLjlrcc(Tld.IntegerToString(hdd.getLjlrcc()));
			hd.setLjjhcc(Tld.IntegerToString(hdd.getLjjhcc()));
			hd.setZyzl(Tld.zuoyezhiliang(hdd.getZyzl()));
			hd.setOnline(er.hengToInteger(Tld.IntegerToString(hdd.getOnline())));
			
			
		//hd.setRemarkteam(Tld.IntegerToString(hdd.getTeam()));
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
