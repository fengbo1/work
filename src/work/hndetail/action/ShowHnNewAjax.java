package work.hndetail.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.dao.UserCfgDAO;
import work.control.pojo.UserCfg;
import work.daily.dao.DailyStatusDAO;
import work.hndetail.pojo.HnNew;
import work.util.Tld;

import ccb.hibernate.HibernateSessionFactory;

public class ShowHnNewAjax {

	private String date;
	private String paras;
	private String parts;
	private String choice;
	private List<String> listteam;
	private List<HnNew> list;
	private HnNew hn;//平均值
	private String pos;
	private String role;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getParas() {
		return paras;
	}
	public void setParas(String paras) {
		this.paras = paras;
	}
	public String getParts() {
		return parts;
	}
	public void setParts(String parts) {
		this.parts = parts;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public List<String> getListteam() {
		return listteam;
	}
	public void setListteam(List<String> listteam) {
		this.listteam = listteam;
	}
	public List<HnNew> getList() {
		return list;
	}
	public void setList(List<HnNew> list) {
		this.list = list;
	}
	public HnNew getHn() {
		return hn;
	}
	public void setHn(HnNew hn) {
		this.hn = hn;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String execute() throws Exception
	{
		int j=0;
		hn=new HnNew();
		String chu = "";
		String names = "";//查询名单
		String position = "_____";
		UserCfgDAO ucdao = new UserCfgDAO();
		paras=new String(paras.getBytes("ISO8859-1"),"UTF-8");
		DailyStatusDAO dsdao = new DailyStatusDAO();
		String cfgxz = Tld.cfgxz;
		String cfgqz = Tld.cfgxz;
		String byorder = "";
		String sequence = "";
		listteam = new ArrayList<String>();
		String hql = "select * from t_hn_new as hn where hn.cl>0";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
//			if(parts!=null)
//			{
//				hql +=" and (0";
//				for(int i=0;i<parts.length();i++)
//				{
//					if(parts.charAt(i)=='1')
//					{
//						hql +="+if(hn."+Tld.PARTE[i]+" is NULL,0,hn."+Tld.PARTE[i]+")";
//					}
//				}
//				hql +=")>0";
//			}
			if(parts!=null)
			{
				for(int i=0;i<parts.length();i++)
				{
					if(parts.charAt(i)=='1')
					{
						hql +=" and hn."+Tld.PARTE[i]+">0";
					}
				}
			}
			if(!paras.isEmpty()&&paras.length()>0)
			{
				String[] parass = paras.split("￠");
				String[] choices = choice.replace("choice", "").split(",");
				for(int i=0;i<parass.length;i++)
				{
					String nv = parass[i];
					String name = "";
					String value = "";
					if(!nv.endsWith(","))
					{
						name = nv.split(",")[0];
						value = nv.split(",")[1];
						
						if(name.equals("chu"))
						{
							chu = value;
							if(!chu.equals("all"))
								position=position.substring(0, 2)+chu+position.substring(3,5);
						}
						else if(name.equals("team"))
						{
							if(!value.equals("all"))
								position=position.substring(0, 4)+value;
						}
						else if(name.equals("date")&&value.length()>7)
						{
							date=value.replace("-", "");
							hql+=" and hn.date='"+date+"'";
						}
						else if(name.equals("word"))
						{
							hql+=" and (hn.name like '%"+value+"%' or hn.no like '%"+value+"%')";
						}
						else if(name.equals("zx")&&!value.equals("all"))
						{
							hql=hql+" and hn.zx="+value;
						}
						else if(name.equals("zhibiao"))
						{
							byorder=" order by case when hn.ljsx='0' then 1 else 0 end, hn."+value;
						}
						else if(name.equals("sequence")&&value.equals("1"))
						{
							sequence = " desc";
						}
						else if(name.equals("qz")&&!value.equals("all"))
						{
							int pos = Integer.valueOf(value);
							int L = pos-1;
							int R = pos+1;
							cfgqz = cfgqz.substring(0,L)+"1"+cfgqz.substring(pos,cfgxz.length());
						}
						else if(name.contains("choice"))
						{
							if(!value.equals("all"))
							{
								int pos = Integer.valueOf(choices[j]);
								int L = pos-1;
								int R = pos+1;
								cfgxz = cfgxz.substring(0,L)+value.substring(0, 1)+cfgxz.substring(pos,cfgxz.length());
							}
							j++;
						}
					}
					else if(nv.startsWith("date")){
						date = dsdao.findFinalWithHnWithsession(session);
						hql+=" and hn.date='"+date+"'";
					}
					else{
						System.out.println(nv);
					}
				}
				if(pos==null||pos.length()<5||role==null||role.length()<1)
				{
					hql+=" and 1=0";
				}
				else
				{
					if(pos.startsWith("0")||pos.startsWith("1")||pos.startsWith("2")||role.equals("6")||role.equals("7")||role.equals("9"))
					{
						
					}
					else if(pos.startsWith("3"))
					{
						hql+=" and hn.pos like '__"+pos.substring(2, 3)+"_"+pos.substring(4, 5)+"'";
					}
					else if(pos.startsWith("4"))
					{
						hql+=" and hn.pos like '__"+pos.substring(2, 3)+"__'";
					}
					else
					{
						hql+=" and 1=0";
					}
				}
				hql+=" and hn.no in (select no891 from t_no where no2 like '"+cfgxz+"' and source like '"+cfgqz+"' and position like '"+position+"')";
				hql+=byorder;
				hql+=sequence;
				hql+=",hn.rjcl desc,hn.rjxl";
				System.out.println(hql);
				list = session.createSQLQuery(hql).addEntity(HnNew.class).list();
				if(paras.contains("key,chu")&&!chu.equals("all"))//如果是查询处室
				{
					UserCfg uc = ucdao.findUcByTypeAndNum("chu", chu);
					String[] strtemp = uc.getContentsc().split("、");
					for(int i=0;i<strtemp.length;i++)
					{
						listteam.add(strtemp[i]);
					}
				}
				for(int i=0;i<list.size();i++)
				{
					names+="'";
					names+=list.get(i).getName();
					names+="'";
					if((i+1)<list.size())
					{
						names+=",";
					}
				}
				if(list.size()>1)
				{
//					
					//日均产量
					hql = "select if(sum(cl)/sum(sx) is NULL,0,sum(cl)/sum(sx)) from t_hn_new where name in ("+names+") and date>='"+date.substring(0, 6)+"01' and date<='"+date+"'"; 
					hn.setRjcl(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					//日均差错率
					hql = "SELECT if(sum(cclrmb_fz+cclwh_fz+ccljh_fz+ccljh_fz+cclsh_fz+ccljy_fz)/sum(cclrmb_fm+cclwh_fm+ccljh_fm+ccljh_fm+cclsh_fm+ccljy_fm) is NULL,0,sum(cclrmb_fz+cclwh_fz+ccljh_fz+ccljh_fz+cclsh_fz+ccljy_fz)/sum(cclrmb_fm+cclwh_fm+ccljh_fm+ccljh_fm+cclsh_fm+ccljy_fm)) from t_hn_new where name in ("+names+") and date>='"+date.substring(0, 6)+"01' and date<='"+date+"'"; 
					hn.setRjccl(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					//日均效率
					hql = "SELECT if(sum(xlrmb_fz+xlwh_fz+xljh_fz+xljh_fz+xlsh_fz+xljy_fz)/sum(xlrmb_fm+xlwh_fm+xljh_fm+xljh_fm+xlsh_fm+xljy_fm) is NULL,0,sum(xlrmb_fz+xlwh_fz+xljh_fz+xljh_fz+xlsh_fz+xljy_fz)/sum(xlrmb_fm+xlwh_fm+xljh_fm+xljh_fm+xlsh_fm+xljy_fm)) from t_hn_new where name in ("+names+") and date>='"+date.substring(0, 6)+"01' and date<='"+date+"'"; 
					hn.setRjxl(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					//
					hql = "select if(sum(cl)/count(*) is NULL,0,sum(cl)/count(*)) from t_hn_new where name in ("+names+") and sx>0 and date='"+date+"'"; 
					hn.setCl(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(clrmb)/count(*) is NULL,0,sum(clrmb)/count(*)) from t_hn_new where name in ("+names+") and sxrmb>0 and date='"+date+"'"; 
					hn.setClrmb(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(clwh)/count(*) is NULL,0,sum(clwh)/count(*)) from t_hn_new where name in ("+names+") and clwh>0 and date='"+date+"'"; 
					hn.setClwh(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(cljh)/count(*) is NULL,0,sum(cljh)/count(*)) from t_hn_new where name in ("+names+") and cljh>0 and date='"+date+"'"; 
					hn.setCljh(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(clsh)/count(*) is NULL,0,sum(clsh)/count(*)) from t_hn_new where name in ("+names+") and clsh>0 and date='"+date+"'"; 
					hn.setClsh(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(cljy)/count(*) is NULL,0,sum(cljy)/count(*)) from t_hn_new where name in ("+names+") and cljy>0 and date='"+date+"'"; 
					hn.setCljy(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(clfxq)/count(*) is NULL,0,sum(clfxq)/count(*)) from t_hn_new where name in ("+names+") and clfxq>0 and date='"+date+"'"; 
					hn.setClfxq(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(cclrmb_fz+cclwh_fz+ccljh_fz+ccljh_fz+cclsh_fz+ccljy_fz)/sum(cclrmb_fm+cclwh_fm+ccljh_fm+ccljh_fm+cclsh_fm+ccljy_fm) is NULL,0,sum(cclrmb_fz+cclwh_fz+ccljh_fz+ccljh_fz+cclsh_fz+ccljy_fz)/sum(cclrmb_fm+cclwh_fm+ccljh_fm+ccljh_fm+cclsh_fm+ccljy_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setCcl(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(cclrmb_fz)/sum(cclrmb_fm) is NULL,0,sum(cclrmb_fz)/sum(cclrmb_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setCclrmb(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(cclwh_fz)/sum(cclwh_fm) is NULL,0,sum(cclwh_fz)/sum(cclwh_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setCclwh(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(ccljh_fz)/sum(ccljh_fm) is NULL,0,sum(ccljh_fz)/sum(ccljh_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setCcljh(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(ccljy_fz)/sum(ccljy_fm) is NULL,0,sum(ccljy_fz)/sum(ccljy_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setCcljy(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(xlrmb_fz+xlwh_fz+xljh_fz+xljh_fz+xlsh_fz+xljy_fz)/sum(xlrmb_fm+xlwh_fm+xljh_fm+xljh_fm+xlsh_fm+xljy_fm) is NULL,0,sum(xlrmb_fz+xlwh_fz+xljh_fz+xljh_fz+xlsh_fz+xljy_fz)/sum(xlrmb_fm+xlwh_fm+xljh_fm+xljh_fm+xlsh_fm+xljy_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setXl(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(xlrmb_fz)/sum(xlrmb_fm) is NULL,0,sum(xlrmb_fz)/sum(xlrmb_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setXlrmb(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(xlwh_fz)/sum(xlwh_fm) is NULL,0,sum(xlwh_fz)/sum(xlwh_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setXlwh(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(xljh_fz)/sum(xljh_fm) is NULL,0,sum(xljh_fz)/sum(xljh_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setXljh(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(xlsh_fz)/sum(xlsh_fm) is NULL,0,sum(xlsh_fz)/sum(xlsh_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setXlsh(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
					hql = "SELECT if(sum(xljy_fz)/sum(xljy_fm) is NULL,0,sum(xljy_fz)/sum(xljy_fm)) from t_hn_new where name in ("+names+") and date='"+date+"'"; 
					hn.setXljy(Double.valueOf(session.createSQLQuery(hql).uniqueResult().toString()));
					
				}
				
				date = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8);
				
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
