package work.rulecase.action.hegui;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import work.rulecase.dao.RcRuleDAO;
import work.rulecase.pojo.RcRule;
import work.util.YearSeason;

import ccb.hibernate.HibernateSessionFactory;

public class RuleHgUpdate {
	private int id;
	private String part;
	private String area;
	private String factor;
	private String fac_a;
	private String fac_b;
	private String fac_c;
	private String rule;
	private String exp;
	private String remark;
	private String renewexp;
	private String fujian;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public String getFac_a() {
		return fac_a;
	}
	public void setFac_a(String facA) {
		fac_a = facA;
	}
	public String getFac_b() {
		return fac_b;
	}
	public void setFac_b(String facB) {
		fac_b = facB;
	}
	public String getFac_c() {
		return fac_c;
	}
	public void setFac_c(String facC) {
		fac_c = facC;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRenewexp() {
		return renewexp;
	}
	public void setRenewexp(String renewexp) {
		this.renewexp = renewexp;
	}
	public String getFujian() {
		return fujian;
	}
	public void setFujian(String fujian) {
		this.fujian = fujian;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception{
		String hql = "";
		message = "修改成功";
		RcRuleDAO rrdao = new RcRuleDAO();
		YearSeason ys = new YearSeason();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from RcRule as rr where rr.id="+id;
			List<RcRule> list = session.createQuery(hql).list();
			if(!list.isEmpty())
			{
				RcRule rr = list.get(0);
				rr.setPart(part);
				rr.setArea(area);
				rr.setFactor(factor);
				rr.setFacA(fac_a);
				rr.setFacB(fac_b);
				rr.setFacC(fac_c);
				rr.setRenewdate(ys.getStringDate());
				rr.setRule(rule);
				rr.setExp(exp);
				rr.setRemark(remark);
				rr.setRenewexp(renewexp);
				rr.setFujian(fujian);
				rrdao.merge(rr);
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
