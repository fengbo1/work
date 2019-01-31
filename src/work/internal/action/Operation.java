package work.internal.action;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import work.hndetail.dao.HdTempDAO;
import ccb.hibernate.HibernateSessionFactory;
import work.hndetail.dao.HndetailLsDAO;
import work.control.dao.HnConfigDAO;
import work.control.pojo.HnConfig;
import work.control.pojo.Xishu;
import work.daily.dao.DailyStatusDAO;
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
import work.hndetail.dao.HnNewDAO;
import work.monthpara.dao.MonthParaDAO;
import work.no.dao.NoDAO;
import work.no.pojo.No;
import work.online.dao.OnlineDAO;
import work.percl.dao.PerclDAO;
import work.percl.pojo.Percl;
import work.pool.dao.PoolDAO;
import work.pool.pojo.Pool;
import work.team.dao.TeamDAO;
import work.team.pojo.Team;
import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.util.GeneralCheck;
import work.util.Tld;
import work.util.YearSeason;
import work.hndetail.pojo.*;

public class Operation {

	private static Logger logger = Logger.getLogger(Operation.class);
	/**
	 * 对行内891数据进行处理并存入数据库
	 * @param listPool
	 * @param type
	 * @param date
	 * @return
	 */
	public String operateHn891(String date){
		
		System.out.println("operateHn891");
		String result="success";
		String failed="";
		YearSeason ys = new YearSeason();
		//String old1monthdate = ys.getLastFiveDate(String.valueOf(date));
		NoDAO nodao = new NoDAO();
		HnNewDAO hndao = new HnNewDAO();
		Hn891DAO dao891 = new Hn891DAO();
		PoolDAO pooldao = new PoolDAO();
		HnConfigDAO hcdao = new HnConfigDAO();
		GeneralCheck check =new GeneralCheck();
		Query query;
		Transaction trans = null;
    	Session session = HibernateSessionFactory.getSession();
		try {
			trans=session.beginTransaction();
			ArrayList<String> listno = new ArrayList<String>();
			//删除基础数据表中日期date的891数据
			String sqltemp = "delete from hn891 where time='"+date+"'";
			session.createSQLQuery(sqltemp).executeUpdate();
			//sqltemp = "delete from hn891_ls where time<'"+old1monthdate+"' or time='"+date+"'";
			sqltemp = "truncate hn891_ls";
			session.createSQLQuery(sqltemp).executeUpdate();
			String sql = "select distinct no from Pool where intype=1";//查找Pool中891唯一的no list
			query = session.createSQLQuery(sql);
			listno=(ArrayList<String>) query.list();
			
			
			//保存折算系数
			Xishu xs = hcdao.getConfigByType(1);
			for(int i=0;i<listno.size();i++)
			{
				//int flag = 0;//判断操作者是否只做了8项业务
				//int flag2 = 0;//判断是否做了外汇业务
				String noall = listno.get(i);
				String tempno = "";
				int tpl = 0;//全环节退票量
				int rwl = 0;//全环节任务总量
				double sumxl = 0.0;//效率之和
				if(noall.endsWith("0101")||noall.endsWith("0105"))
				{
					tempno = noall.substring(0,8);
				}
				else
				{
					tempno = listno.get(i).substring(listno.get(i).length()-3);
				}
				System.out.println("no:"+tempno+"-"+noall);
				ArrayList<Pool> listpool = (ArrayList<Pool>) pooldao.findAllByNoAndIntype(listno.get(i),1);
				Hn891 hn891 = new Hn891("","","",0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,
						0.0,0,0.0,0,0.0,0,0,0.0,0.0,0,0.0,0.0,0,0.0,0.0,0,0.0,0,0,"","","","","");
				//Hn891 hn891 = new Hn891();
				for(int j=0;j<listpool.size();j++)
				{
					Pool poolJ = listpool.get(j);
					String code = poolJ.getCode();
					String part = poolJ.getPart();
					//1:版面识别 2：人工影像拆分 3：录入修改 4：录入修改授权 5：检核修改 6：检核授权 7失败原因分析 8发布失败处理
					if(part.equals(Tld.RMB_ZW[0]))
					{
						hn891.setBmsb(hn891.getBmsb()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_ZW[1]))
					{
						hn891.setYxcf(hn891.getYxcf()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}	
					else if(part.equals(Tld.RMB_ZW[2]))
					{
						hn891.setLrxg(hn891.getLrxg()+poolJ.getNumber());
						hn891.setLrcc(hn891.getLrcc()+poolJ.getCc());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_ZW[3]))
					{
						hn891.setLrsq(hn891.getLrsq()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_ZW[4]))
					{
						hn891.setJhxg(hn891.getJhxg()+poolJ.getNumber());
						hn891.setJhcc(hn891.getJhcc()+poolJ.getCc());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_ZW[5]))
					{
						hn891.setJhsq(hn891.getJhsq()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					
					else if(part.equals(Tld.RMB_ZW[6]))
					{
						hn891.setSbyy(hn891.getSbyy()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_ZW[7]))
					{
						hn891.setYxbz(hn891.getYxbz()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_ZW[8]))
					{
						hn891.setCslr(hn891.getCslr()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_ZW[9]))
					{
						hn891.setZyfs(hn891.getZyfs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
				}
				if(nodao.findByNo891(tempno).size()<1)
				{
					logger.info("891工号"+tempno+"在员工信息表中查询不到");
					failed+="<br/>891工号"+tempno+"在员工信息表中查询不到";
				}
				else//检查工号存在不//如果做了8项业务,则保存
				{
					No no = (No) nodao.findByNo891(tempno).get(0);
					
					hn891.setTime(date);
					hn891.setNo(tempno);
					hn891.setName(no.getName());
					hn891.setZx(no.getZx());
					hn891.setXz(no.getXz());
					
					
					Double temp = check.mul(hn891.getBmsb(),xs.getXs1())
					+check.mul(hn891.getYxcf(),xs.getXs2())
					+check.mul(hn891.getLrxg(),xs.getXs3())
					+check.mul(hn891.getLrsq(),xs.getXs4())
					+check.mul(hn891.getJhxg(),xs.getXs5())
					+check.mul(hn891.getJhsq(),xs.getXs6())
					+check.mul(hn891.getSbyy(),xs.getXs7())
					+check.mul(hn891.getYxbz(),xs.getXs8())
					+check.mul(hn891.getCslr(),xs.getXs9())
					+check.mul(hn891.getZyfs(),xs.getXs10());
					//+check.IsNullInteger(hn891.getSbcl())*control.getKSbcl891()
					hn891.setZhcl(check.DoubleTo2(temp));
					hn891.setLrtp(tpl);
					hn891.setYwl(rwl);
					hn891.setSumxl(sumxl);
					hn891.setLrtpl(check.DoubleTo4(division(tpl,rwl)));//退票量除以业务量
					if((check.mul(hn891.getLrxg(),xs.getXs3())+check.mul(hn891.getJhxg(),xs.getXs5()))<0.000001)
					{
						hn891.setCcl(0.0);
						//hn891.setLrtpl(0.0);
					}
					else
					{
						hn891.setCcl(check.DoubleTo4((check.mul(hn891.getLrcc(),xs.getXs3())+check.mul(hn891.getJhcc(),xs.getXs5()))
								/(check.mul(hn891.getLrxg(),xs.getXs3())+check.mul(hn891.getJhxg(),xs.getXs5()))));
					}	
					dao891.save(hn891);
//					if(temp<1)//上线标志置0
//					{
//						sql="delete from t_hn_online where time='"+date+"' and no='"+hn891.getNo()+"'";
//					}
					
					//
				}
			}
			
			sql = "insert into hn891_ls(time,no,name,bmsb,xl_bmsb,yxcf,xl_yxcf,lrxg,xl_lrxg,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,sbyy,xl_sbyy,yxbz,xl_yxbz,cslr,xl_cslr,zyfs,xl_zyfs,lrcc,jhcc,lrccl,jhccl,lrtp,lrtpl,ccl,cx,cxl,zhcl,ywl,sumxl,zx,xz,remark1,remark2,remark3,remark4,remark5) select time,no,name,bmsb,xl_bmsb,yxcf,xl_yxcf,lrxg,xl_lrxg,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,sbyy,xl_sbyy,yxbz,xl_yxbz,cslr,xl_cslr,zyfs,xl_zyfs,lrcc,jhcc,lrccl,jhccl,lrtp,lrtpl,ccl,cx,cxl,zhcl,ywl,sumxl,zx,xz,remark1,remark2,remark3,remark4,remark5 from hn891 where time='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update hn891_ls set lrccl=CAST(lrcc/lrxg AS DECIMAL(18,4)) where time='"+date+"' and lrcc>0";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update hn891_ls set jhccl=CAST(jhcc/jhxg AS DECIMAL(18,4)) where time='"+date+"' and jhcc>0";
			session.createSQLQuery(sql).executeUpdate();
			if(failed.length()>1){return failed;};
		} catch (Exception e) {
			// TODO Auto-generated catch block
			trans.rollback();
			e.printStackTrace();
			logger.error(e);
		}finally{
			trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return result;
	}

	/**
	 * 对行内895数据进行处理并存入数据库
	 * @param listPool
	 * @param type
	 * @param date
	 * @return
	 */
	public String operateHn895(String date){
		System.out.println("operateHn895");
		String result="success";
		String failed="";
		YearSeason ys = new YearSeason();
//		String old1monthdate = ys.getLastFiveDate(String.valueOf(date));
		GeneralCheck check = new GeneralCheck();
		NoDAO nodao = new NoDAO();
		Hn895DAO dao895 = new Hn895DAO();
		PoolDAO pooldao = new PoolDAO();
		Query query;
		Transaction trans = null;
		HnConfigDAO hcdao = new HnConfigDAO();
    	Session session = HibernateSessionFactory.getSession();
		try {
			trans=session.beginTransaction();
			ArrayList<String> listno = new ArrayList<String>();
			//删除基础数据表中日期date的895数据
			String sqltemp = "delete from hn895 where time='"+date+"'";
			session.createSQLQuery(sqltemp).executeUpdate();
//			sqltemp = "delete from hn895_ls where time<'"+old1monthdate+"' or time='"+date+"'";
			sqltemp = "truncate hn895_ls";
			session.createSQLQuery(sqltemp).executeUpdate();
			String sql = "select distinct no from Pool where intype=2";//查找Pool中895唯一的no list
			query = session.createQuery(sql);
			Xishu xs = hcdao.getConfigByType(2);
			listno=(ArrayList<String>) query.list();
			for(int i=0;i<listno.size();i++)
			{
				//int flag = 0;//判断操作者是否只做了8项业务
				String noall = listno.get(i);
				String tempno = "";
				int tpl = 0;//全环节退票量
				int rwl = 0;//全环节任务总量
				double sumxl = 0.0;//全环节效率之和
				if(noall.endsWith("0101")||noall.endsWith("0105"))
				{
					tempno = noall.substring(0,8);
				}
				else
				{
					tempno = listno.get(i).substring(listno.get(i).length()-3);
				}
				System.out.println("no:"+tempno);
				ArrayList<Pool> listpool = (ArrayList<Pool>) pooldao.findAllByNoAndIntype(listno.get(i),2);
				Hn895 hn895 = new Hn895("","","",0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0,
						0,0.0,0.0,0,0.0,0.0,0,0.0,0.0,0,0.0,0,0);
				for(int j=0;j<listpool.size();j++)
				{
					Pool poolJ = listpool.get(j);
					String code = poolJ.getCode();
					String part = poolJ.getPart();
					//1:版面识别 2：人工影像拆分 3：录入修改 4：录入修改授权 5：检核修改 6：检核授权 7失败原因分析
					if(part.equals(Tld.RMB_FZW[0]))
					{
						hn895.setBmsb(hn895.getBmsb()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[1]))
					{
						hn895.setYxcf(hn895.getYxcf()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}	
					else if(part.equals(Tld.RMB_FZW[2]))
					{
						hn895.setLrxg(hn895.getLrxg()+poolJ.getNumber());
						hn895.setLrcc(hn895.getLrcc()+poolJ.getCc());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[3]))
					{
						hn895.setLrsq(hn895.getLrsq()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[4]))
					{
						hn895.setJhxg(hn895.getJhxg()+poolJ.getNumber());
						hn895.setJhcc(hn895.getJhcc()+poolJ.getCc());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[5]))
					{
						hn895.setJhsq(hn895.getJhsq()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[6]))
					{
						hn895.setSbyy(hn895.getSbyy()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[7]))
					{
						hn895.setCslr(hn895.getCslr()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[8]))
					{
						hn895.setZyfs(hn895.getZyfs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[9]))
					{
						hn895.setShsh(hn895.getShsh()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[10]))
					{
						hn895.setSbyy(hn895.getSbyy()+poolJ.getNumber());//商户失败处理记在失败原因分析里面
				//		hn895.setShsb(hn895.getShsb()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[11]))
					{
						hn895.setRlcs(hn895.getRlcs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[12]))
					{
						hn895.setRlfs(hn895.getRlfs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[13]))
					{
						hn895.setRlsb(hn895.getRlsb()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[14]))
					{
						hn895.setKdfh(hn895.getKdfh()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.RMB_FZW[15]))
					{
						hn895.setFyhd(hn895.getFyhd()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
				}
				if(nodao.findByNo891(tempno).size()<1)
				{
					logger.info("工号"+tempno+"在员工信息表中查询不到");
					failed+="<br/>895工号"+tempno+"在员工信息表中查询不到";
				}else//检查工号存在不//如果做了8项业务,则保存
				{
					No no = (No) nodao.findByNo891(tempno).get(0);
					hn895.setTime(date);
					hn895.setNo(tempno);
					hn895.setName(no.getName());
					hn895.setZx(no.getZx());
					hn895.setXz(no.getXz());
					Double temp = check.mul(hn895.getBmsb(),xs.getXs1())
					+check.mul(hn895.getYxcf(),xs.getXs2())
					+check.mul(hn895.getLrxg(),xs.getXs3())
					+check.mul(hn895.getLrsq(),xs.getXs4())
					+check.mul(hn895.getJhxg(),xs.getXs5())
					+check.mul(hn895.getJhsq(),xs.getXs6())
					+check.mul(hn895.getSbyy(),xs.getXs7())
					+check.mul(hn895.getCslr(),xs.getXs8())
					+check.mul(hn895.getZyfs(),xs.getXs9())
					+check.mul(hn895.getShsh(),xs.getXs10())
					+check.mul(hn895.getShsb(),xs.getXs11())
					+check.mul(hn895.getRlcs(),xs.getXs12())
					+check.mul(hn895.getRlfs(),xs.getXs13())
					+check.mul(hn895.getRlsb(),xs.getXs14())
					+check.mul(hn895.getKdfh(),xs.getXs15())
					+check.mul(hn895.getFyhd(),xs.getXs16());
					hn895.setZhcl(check.DoubleTo2(temp));
					hn895.setLrtp(tpl);
					hn895.setYwl(rwl);
					hn895.setSumxl(sumxl);
					hn895.setLrtpl(check.DoubleTo4(division(tpl,rwl)));
					if((check.mul(hn895.getLrxg(),xs.getXs3())+check.mul(hn895.getJhxg(),xs.getXs5()))<0.000001)
					{
						hn895.setCcl(0.0);
						//hn895.setLrtpl(0.0);
					}
					else
					{
						hn895.setCcl(check.DoubleTo4((check.mul(hn895.getLrcc(),xs.getXs3())+check.mul(hn895.getJhcc(),xs.getXs5()))
						/(check.mul(hn895.getLrxg(),xs.getXs3())+check.mul(hn895.getJhxg(),xs.getXs5()))));
					}
					dao895.merge(hn895);
				}
			}
			sql = "insert into hn895_ls(time,no,name,bmsb,xl_bmsb,yxcf,xl_yxcf,lrxg,xl_lrxg,lrsq,xl_lrsq,jhxg,xl_jhxg," +
					"jhsq,xl_jhsq,sbyy,xl_sbyy,cslr,xl_cslr,zyfs,xl_zyfs,shsh,xl_shsh,shsb,xl_shsb,rlcs,xl_rlcs,rlfs,xl_rlfs," +
					"rlsb,xl_rlsb,kdfh,xl_kdfh,fyhd,xl_fyhd,lrcc,jhcc,lrccl,jhccl,lrtp,lrtpl,ccl,cx,cxl,zhcl,ywl,sumxl,zx,xz) select time,no,name,bmsb," +
					"xl_bmsb,yxcf,xl_yxcf,lrxg,xl_lrxg,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,sbyy,xl_sbyy,cslr,xl_cslr,zyfs," +
					"xl_zyfs,shsh,xl_shsh,shsb,xl_shsb,rlcs,xl_rlcs,rlfs,xl_rlfs,rlsb,xl_rlsb,kdfh,xl_kdfh,fyhd,xl_fyhd,lrcc,jhcc,lrccl,jhccl,lrtp,lrtpl," +
					"ccl,cx,cxl,zhcl,ywl,sumxl,zx,xz from hn895 where time='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update hn895_ls set lrccl=CAST(lrcc/lrxg AS DECIMAL(18,4)) where time='"+date+"' and lrcc>0";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update hn895_ls set jhccl=CAST(jhcc/jhxg AS DECIMAL(18,4)) where time='"+date+"' and jhcc>0";
			session.createSQLQuery(sql).executeUpdate();
			if(failed.length()>1){return failed;};
		} catch (Exception e) {
			// TODO Auto-generated catch block
			trans.rollback();
			e.printStackTrace();
			logger.error(e);
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return result;
	}
	/**
	 * 对行内外汇数据进行处理并存入数据库
	 * @param listPool
	 * @param type
	 * @param date
	 * @return
	 */
	public String operateWaihui(String date){
		System.out.println("operateWaihui");
		String result="success";
		String failed="";
		YearSeason ys = new YearSeason();
		//String old1monthdate = ys.getLastFiveDate(date);
		GeneralCheck check = new GeneralCheck();
		NoDAO nodao = new NoDAO();
		HnWaihuiDAO whdao = new HnWaihuiDAO();
		PoolDAO pooldao = new PoolDAO();
		Query query;
		Transaction trans = null;
		HnConfigDAO hcdao = new HnConfigDAO();
    	Session session = HibernateSessionFactory.getSession();
		try {
			trans=session.beginTransaction();
			ArrayList<String> listno = new ArrayList<String>();
			//删除基础数据表中日期date的895数据
			String sqltemp = "delete from t_hn_waihui where date='"+date+"'";
			session.createSQLQuery(sqltemp).executeUpdate();
//			sqltemp = "delete from t_hn_waihui_ls where date<'"+old1monthdate+"' or date='"+date+"'";
			sqltemp = "truncate t_hn_waihui_ls";
			session.createSQLQuery(sqltemp).executeUpdate();
			String sql = "select distinct no from Pool where intype=3";//查找Pool中waihui唯一的no list
			query = session.createQuery(sql);
			Xishu xs = hcdao.getConfigByType(3);
			HnConfig dgcs = hcdao.findAllByCodeAndPart("601001","外汇业务初审");
			HnConfig dgfs = hcdao.findAllByCodeAndPart("601001","外汇业务复审");
			listno=(ArrayList<String>) query.list();
			for(int i=0;i<listno.size();i++)
			{
				//int flag = 0;//判断操作者是否只做了8项业务
				String noall = listno.get(i);
				String tempno = "";
				int tpl = 0;//全环节退票量
				int rwl = 0;//全环节任务总量
				double sumxl = 0.0;//全环节效率之和
				if(noall.endsWith("0101")||noall.endsWith("0105"))
				{
					tempno = noall.substring(0,8);
				}
				else
				{
					tempno = listno.get(i).substring(listno.get(i).length()-3);
				}
				System.out.println("no:"+tempno);
				ArrayList<Pool> listpool = (ArrayList<Pool>) pooldao.findAllByNoAndIntype(listno.get(i),3);
				HnWaihui wh = new HnWaihui("-","-","-",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0.0,0,0.0,0.0,0.0,0,0.0);
				double tmpsum = 0.0;
				String weigh = "0.0";
				for(int j=0;j<listpool.size();j++)
				{
					Pool poolJ = listpool.get(j);
					String code = poolJ.getCode();
					String part = poolJ.getPart();
					//按环节和业务编码计算折合产量
					weigh = hcdao.findWeightByCodeAndPart(code, part);
					tmpsum+=check.mul(poolJ.getNumber(),weigh);
					//1:"外汇业务初审",2"外汇业务复审",3"录入修改",4"录入修改授权",5"检核修改",6"检核修改授权",7"记账失败人工异常处理",8"外汇票据初审"
					if(part.equals(Tld.WAIHUI[0]))
					{
						if(dgcs.getCode().contains(code))//如果是对公的外汇初审
						{
							wh.setDgcs(wh.getDgcs()+poolJ.getNumber());
						}
						else
						{
							wh.setZycs(wh.getZycs()+poolJ.getNumber());
						}
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[1]))
					{
						if(dgfs.getCode().contains(code))//如果是对公的外汇复审
						{
							wh.setDgfs(wh.getDgfs()+poolJ.getNumber());
						}
						else
						{
							wh.setZyfs(wh.getZyfs()+poolJ.getNumber());
						}
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}	
					else if(part.equals(Tld.WAIHUI[2]))
					{
						wh.setLrxg(wh.getLrxg()+poolJ.getNumber());
						wh.setLrcc(wh.getLrcc()+poolJ.getCc());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[3]))
					{
						wh.setLrsq(wh.getLrsq()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[4]))
					{
						wh.setJhxg(wh.getJhxg()+poolJ.getNumber());
						wh.setJhcc(wh.getJhcc()+poolJ.getCc());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[5]))
					{
						wh.setJhsq(wh.getJhsq()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[6]))
					{
						wh.setSbyy(wh.getSbyy()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[7]))
					{
						wh.setPjcs(wh.getPjcs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[8]))
					{
						wh.setPjfs(wh.getPjfs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[9]))
					{
						wh.setHrcs(wh.getHrcs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.WAIHUI[10]))
					{
						wh.setHrfs(wh.getHrfs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					
				}
				if(nodao.findByNo891(tempno).size()<1)
				{
					logger.info("工号"+tempno+"在员工信息表中查询不到");
					failed+="<br/>895工号"+tempno+"在员工信息表中查询不到";
				}else//检查工号存在不//如果做了8项业务,则保存
				{
					No no = (No) nodao.findByNo891(tempno).get(0);
					wh.setDate(date);
					wh.setNo(tempno);
					wh.setName(no.getName());
					wh.setZx(no.getZx());
					wh.setXz(no.getXzwh());
//					Double temp = check.mul(wh.getZycs(),xs.getXs1())
//					+check.mul(wh.getZyfs(),xs.getXs2())
//					+check.mul(wh.getLrxg(),xs.getXs3())
//					+check.mul(wh.getLrsq(),xs.getXs4())
//					+check.mul(wh.getJhxg(),xs.getXs5())
//					+check.mul(wh.getJhsq(),xs.getXs6())
//					+check.mul(wh.getSbyy(),xs.getXs7())
//					+check.mul(wh.getPjcs(),xs.getXs8())
//					+check.mul(wh.getPjfs(),xs.getXs9())
//					+check.mul(wh.getHrcs(),xs.getXs10())
//					+check.mul(wh.getHrfs(),xs.getXs11());
					wh.setZhcl(check.DoubleTo2(tmpsum));
					wh.setTp(tpl);
					wh.setYwl(rwl);
					wh.setSumxl(sumxl);
					wh.setTplv(check.DoubleTo4(division(tpl,rwl)));
//					if((check.mul(wh.getLrxg(),xs.getXs3())+check.mul(wh.getJhxg(),xs.getXs5()))<0.000001)
//					{
//						wh.setCclv(0.0);
//						//wh.setLrtpl(0.0);
//					}
//					else
//					{
//						wh.setCcl(check.DoubleTo4((check.mul(wh.getLrcc(),xs.getXs3())+check.mul(wh.getJhcc(),xs.getXs5()))
//						/(check.mul(wh.getLrxg(),xs.getXs3())+check.mul(wh.getJhxg(),xs.getXs5()))));
//					}
					whdao.merge(wh);
				}
			}
			sql = "insert into t_hn_waihui_ls(date, no, name, zx, xz,zycs, zyfs, lrxg, lrsq, jhxg, jhsq," +
					" pjcs, pjfs, sbyy,dgcs,dgfs,hrcs,hrfs,xlzycs, xlzyfs, xllrxg, xllrsq, xljhxg, xljhsq, xlpjcs," +
					" xlpjfs, xlsbyy,xldgcs,xldgfs,xlhrcs,xlhrfs, lrcc, lclv, jhcc, jclv, tp, tplv, cx, cxlv, zhcl, ywl," +
					" sumxl,ccl,percl,bh,bhl) select date, no, name, zx, xz,zycs, zyfs, lrxg, lrsq, jhxg," +
					" jhsq, pjcs, pjfs, sbyy,dgcs,dgfs,hrcs,hrfs,xlzycs, xlzyfs, xllrxg, xllrsq, xljhxg, xljhsq, xlpjcs," +
					" xlpjfs, xlsbyy,xldgcs,xldgfs,xlhrcs,xlhrfs, lrcc, lclv, jhcc, jclv, tp, tplv, cx, cxlv, zhcl, ywl," +
					" sumxl,ccl,percl,bh,bhl from t_hn_waihui where date='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_waihui_ls set lclv=CAST(lrcc/lrxg AS DECIMAL(18,4)),jclv=CAST(jhcc/jhxg AS DECIMAL(18,4)),tplv=CAST(tp/ywl AS DECIMAL(18,4)),ccl=CAST((lrcc*"+xs.getXs3()+"+jhcc*"+xs.getXs5()+")/(lrxg*"+xs.getXs3()+"+jhxg*"+xs.getXs5()+") AS DECIMAL(18,4)),percl=CAST(sumxl/ywl AS DECIMAL(18,4)),bhl=CAST(bh/zyfs AS DECIMAL(18,4))";
			session.createSQLQuery(sql).executeUpdate();
			sql = "delete from t_hn_waihui where date='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "insert into t_hn_waihui(date, no, name, zx, xz,zycs, zyfs, lrxg, lrsq, jhxg, jhsq, pjcs, pjfs," +
					" sbyy,dgcs,dgfs,hrcs,hrfs,xlzycs, xlzyfs, xllrxg, xllrsq, xljhxg, xljhsq, xlpjcs, xlpjfs, xlsbyy,xldgcs,xldgfs,xlhrcs," +
					"xlhrfs, lrcc, lclv, jhcc, jclv, tp, tplv, cx, cxlv, zhcl, ywl, sumxl,ccl,percl,bh,bhl ) select" +
					" date, no, name, zx, xz,zycs, zyfs, lrxg, lrsq, jhxg, jhsq, pjcs, pjfs, sbyy,dgcs,dgfs,hrcs,hrfs,xlzycs," +
					" xlzyfs, xllrxg, xllrsq, xljhxg, xljhsq, xlpjcs, xlpjfs, xlsbyy,xldgcs,xldgfs,xlhrcs,xlhrfs, lrcc, lclv, jhcc," +
					" jclv, tp, tplv, cx, cxlv, zhcl, ywl, sumxl,ccl,percl,bh,bhl from t_hn_waihui_ls where date='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			if(failed.length()>1){return failed;};
		} catch (Exception e) {
			// TODO Auto-generated catch block
			trans.rollback();
			e.printStackTrace();
			logger.error(e);
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return result;
	}
	
	/**
	 * 对行内建亚数据进行处理并存入数据库
	 * @param listPool
	 * @param type
	 * @param date
	 * @return
	 */
	public String operateJianya(String date){
		System.out.println("operateJianYa");
		String result="success";
		String failed="";
		GeneralCheck check = new GeneralCheck();
		NoDAO nodao = new NoDAO();
		HnJianyaDAO jydao = new HnJianyaDAO();
		PoolDAO pooldao = new PoolDAO();
		Query query;
		Transaction trans = null;
		HnConfigDAO hcdao = new HnConfigDAO();
    	Session session = HibernateSessionFactory.getSession();
		try {
			trans=session.beginTransaction();
			ArrayList<String> listno = new ArrayList<String>();
			//删除基础数据表中日期date的895数据
			String sqltemp = "delete from t_hn_jianya where date='"+date+"'";
			session.createSQLQuery(sqltemp).executeUpdate();
			//sqltemp = "truncate table t_hn_waihui_ls";
			//session.createSQLQuery(sqltemp).executeUpdate();
			String sql = "select distinct no from Pool where intype=6";//查找Pool中jianya唯一的no list
			query = session.createQuery(sql);
			Xishu xs = hcdao.getConfigByType(6);
			listno=(ArrayList<String>) query.list();
			for(int i=0;i<listno.size();i++)
			{
				String noall = listno.get(i);
				String tempno = "";
				int tpl = 0;//全环节退票量
				int rwl = 0;//全环节任务总量
				double sumxl = 0.0;//全环节效率之和
				if(noall.endsWith("0101")||noall.endsWith("0105"))
				{
					tempno = noall.substring(0,8);
				}
				else
				{
					tempno = listno.get(i).substring(listno.get(i).length()-3);
				}
				System.out.println("no:"+tempno);
				ArrayList<Pool> listpool = (ArrayList<Pool>) pooldao.findAllByNoAndIntype(listno.get(i),6);
				HnJianya jy = new HnJianya("-","-","-",0,0,0,0,0,0,0,0,0,0,0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,0.0,0,0.0,0,0.0,0,0.0,0.0,0,0.0,0.0,0.0);
				for(int j=0;j<listpool.size();j++)
				{
					Pool poolJ = listpool.get(j);
					String code = poolJ.getCode();
					String part = poolJ.getPart();
					//1"录入修改",2"录入修改授权",3"检核修改",4"检核修改授权",5"海外票据初审",6"海外票据复审",7"失败原因分析"
					if(part.equals(Tld.JIANYA[0]))
					{
						jy.setLrxg(jy.getLrxg()+poolJ.getNumber());
						jy.setLrcc(jy.getLrcc()+poolJ.getCc());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.JIANYA[1]))
					{
						jy.setLrsq(jy.getLrsq()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.JIANYA[2]))
					{
						jy.setJhxg(jy.getJhxg()+poolJ.getNumber());
						jy.setJhcc(jy.getJhcc()+poolJ.getCc());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.JIANYA[3]))
					{
						jy.setJhsq(jy.getJhsq()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.JIANYA[4]))
					{
						jy.setPjcs(jy.getPjcs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.JIANYA[5]))
					{
						jy.setPjfs(jy.getPjfs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.JIANYA[6]))
					{
						jy.setSbyy(jy.getSbyy()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.JIANYA[7]))
					{
						jy.setCslr(jy.getCslr()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
					else if(part.equals(Tld.JIANYA[8]))
					{
						jy.setZyfs(jy.getZyfs()+poolJ.getNumber());
						rwl+=poolJ.getNumber();
						tpl+=poolJ.getTp();
					}
				}
				if(nodao.findByNo891(tempno).size()<1)
				{
					logger.info("工号"+tempno+"在员工信息表中查询不到");
					failed+="<br/>895工号"+tempno+"在员工信息表中查询不到";
				}else//检查工号存在不//如果做了8项业务,则保存
				{
					No no = (No) nodao.findByNo891(tempno).get(0);
					jy.setDate(date);
					jy.setNo(tempno);
					jy.setName(no.getName());
					jy.setZx(no.getZx());
					jy.setXz(no.getXzjy());
					Double temp = check.mul(jy.getLrxg(),xs.getXs1())
					+check.mul(jy.getLrsq(),xs.getXs2())
					+check.mul(jy.getJhxg(),xs.getXs3())
					+check.mul(jy.getJhsq(),xs.getXs4())
					+check.mul(jy.getPjcs(),xs.getXs5())
					+check.mul(jy.getPjfs(),xs.getXs6())
					+check.mul(jy.getSbyy(),xs.getXs7())
					+check.mul(jy.getCslr(),xs.getXs8())
					+check.mul(jy.getZyfs(),xs.getXs9());
					jy.setZhcl(check.DoubleTo2(temp));
					jy.setTp(tpl);
					jy.setYwl(rwl);
					jy.setSumxl(sumxl);
					jy.setTplv(check.DoubleTo4(division(tpl,rwl)));
					jydao.merge(jy);
				}
			}
			sql = "update t_hn_jianya set lclv=CAST(lrcc/lrxg AS DECIMAL(18,4)),jclv=CAST(jhcc/jhxg AS DECIMAL(18,4)),tplv=CAST(tp/ywl AS DECIMAL(18,4)),ccl=CAST((lrcc+jhcc)/(lrxg+jhxg) AS DECIMAL(18,4)),percl=CAST(sumxl/zhcl AS DECIMAL(18,4)) where date='"+date+"'";
			session.createSQLQuery(sql).executeUpdate();
			if(failed.length()>1){return failed;};
		} catch (Exception e) {
			// TODO Auto-generated catch block
			trans.rollback();
			e.printStackTrace();
			logger.error(e);
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return result;
	}
	/**
	 * 根据传入的日期计算从该日期到最新日期的操作员作业指标明细数据
	 * 
	 * <br/>调用 computeDetail(int idate,int fdate)
	 * @see computeDetail
	 * @param date
	 * @return String 
	 */
	public String operateDetail(String date)
	{
		System.out.println("operateDetail");
		String result = "";
		String finald = "";
		HnDetailDAO hddao = new HnDetailDAO();
		DailyStatusDAO dsdao = new DailyStatusDAO();
		
		int finaldate;
		int importdate;
		finald = hddao.findFinalDesc();
		if(!ifDateLegal(date))
		{
			result = "输入的date不合规";
		}
		else if(finald.equalsIgnoreCase("null"))//如果首次导入
		{
			//计算importdate日报表
			importdate = Integer.parseInt(date);
			result = computeDetail(importdate,importdate);
		}
		else//如果control中date为空
		{
			if(dsdao.findFinalWithHn().equals("00000000"))//如果control中final为空，则使用hndetail的最新日期为finaldate
			{
				finaldate = Integer.parseInt(finald);
				importdate = Integer.parseInt(date);
			}
			else
			{
				finaldate = Integer.parseInt(dsdao.findFinalWithHn());
				importdate = Integer.parseInt(date);
			}
			result = computeDetail(importdate,finaldate);
		}
		return result;
	}
	/**
	 * 计算日报表的核心计算
	 * 
	 * @param idate
	 * @param fdate
	 * @return
	 */
	public String computeDetail(int idate,int fdate)
	{
		System.out.println("computeDetail");
		String result = "日期："+idate+"日报表成功生成!";
		YearSeason ys = new YearSeason();
		int today = ys.getIntegerDate();
		
		int bdate = (idate/100)*100+1;
		//int lastimportdate = -1;
		String stridate = String.valueOf(idate);
//		String old1monthdate = ys.getLastFiveDate(stridate);
		MonthParaDAO mpdao = new MonthParaDAO();
		//ControlDAO cdao = new ControlDAO();
		GeneralCheck check = new GeneralCheck();
		Double hncl = mpdao.findHnclByMonth(idate/100);
		logger.error("bdate:"+bdate+"-today:"+today+"-idate:"+idate+"-fdate:"+fdate);
		if(idate>=today)
		{
			result = "请确认导入的日期！导入日期应该早于今日！";
		}
		else
		{
			//Control control = (Control) cdao.findAll().get(0);//取参数
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	try {
	    		//////////////先删除数据库中导入日期的数据////////////////////////////
	    		String sqltemp = "delete from t_hn_detail where time='"+idate+"'";
				session.createSQLQuery(sqltemp).executeUpdate();
//				sqltemp = "delete from t_hn_detail_ls where time<'"+old1monthdate+"' or time='"+idate+"'";
				sqltemp = "truncate t_hn_detail_ls";
				session.createSQLQuery(sqltemp).executeUpdate();
				sqltemp = "delete from t_hn_new where date='"+idate+"'";
				session.createSQLQuery(sqltemp).executeUpdate();
	    	}catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			}finally{
				 trans.commit();
		         session.flush();
		         session.clear();
		         session.close();
			}
			//导入全量工号
			insertAllNoToDetail(idate);
			System.out.println(1);
			//更新上线情况
			updateOnlineToDetail(idate);
			System.out.println(2);
			//更新891详细数据
			updateHn891ToDetail(idate);
			System.out.println(3);
			//更新895详细数据
			updateHn895ToDetail(idate);
			System.out.println(4);
			updateQdlrLs(idate);
			//更新hndetail
			lsToHndetail(idate);
			System.out.println(5);
			//计算累计值并存储到temp表hn
			updateDetailToTemp(bdate,idate);
			System.out.println(6);
			//将计算后的数值存入detail表ls
			updateTempToDetail(idate,hncl);
			System.out.println(7);
			//计算是否达标
			countZyzl(mpdao,check,String.valueOf(bdate), stridate);
			System.out.println(8);
			deleteHndetail(stridate);
			lsToHndetail(idate);
			lsToHnnew(stridate);
			lsToHnnew2(stridate);
			System.out.println(9);
			//计算分组统计
			countTeam(stridate);	
		}
		return result;
	}
	/**
	 * 更新渠道录入到临时表
	 * @param idate
	 * @return
	 */
	public String updateQdlrLs(int idate)
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			String sql = "update t_hn_detail_ls set online=0 where xz=4 and output<1 and time='"+idate+"'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_hn_detail_ls a,t_hn_whxl b set a.percltime=b.pctrmb where a.time=b.date and a.no=b.no";
			session.createSQLQuery(sql).executeUpdate();
//			sql = "update t_hn_waihui_ls a,t_hn_whxl b set a.percl=b.pctwh where a.d=b.date and a.no=b.no";
//			session.createSQLQuery(sql).executeUpdate();
//			sql = "update t_hn_detail_ls a,t_hn_whzl b set a.qdlrzl=b.zwdl where a.time=b.date and a.no=b.no";
//			session.createSQLQuery(sql).executeUpdate();
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
	/**
	 * 导入全量工号表
	 * @param session
	 * @return
	 */
	public String insertAllNoToDetail(int time)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		String sql = "insert into t_hn_detail_ls(no,time,name,zx,xz,team,lrxg,xl_lrxg," +
    				"ljlrsc,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,ljlr,ljjh,ljlr895,ljjh895,tp,ljtp,lrcc," +
    				"jhcc,cx,ljcx,output891,output895,output,ccl891,cxl891,tpl891," +
    				"ccl895,cxl895,tpl895,ljcl,ljywl891,ljywl895,ljrjcl,rjclwcl,ljlrcc,ljjhcc,rjccl891,rjcxl891," +
    				"rjtpl891,rjccl895,rjcxl895,rjtpl895,ljsxts,online,zyzl,remark1,remark2," +
    				"remark3,remark4,remark5,qdlr,qdlrz,ljqdlr,ljqdlrz,qdlrzl,ljqdlrzl,percltime,zyccl)" +
    				" SELECT distinct no891,'"+time+"',name,zx,xz,position,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0," +
    				"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'0','0','0','0','0'," +
    				"0,0,0,0,0,0,0,0 from t_no where xz!=3";
    		session.createSQLQuery(sql).executeUpdate();
    		sql = "insert into t_hn_new(date,no,name,zx,xz,pos,cl,clrmb,clwh,cljh,clsh,cljy,ccl,cclrmb," +
    				"cclwh,ccljh,cclsh,ccljy,xl,xlrmb,xlwh,xljh,xlsh,xljy) SELECT '"+time+"',no891,name," +
    						"zx,xz,position,0,0,0,0,0,0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0 " +
    						"from t_no where xz!=3";//t_hn_new
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
	/**
	 * 更新上线情况(耗时长)
	 * @param session
	 * @param time
	 * @return
	 */
	public String updateOnlineToDetail(int time)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		String sql = "update t_hn_detail_ls a, t_hn_online b set a.online=1 " +
    				"where a.no=b.no and a.time='"+time+"' and b.time='"+time+"'";
    		session.createSQLQuery(sql).executeUpdate();
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
	/**
	 * 更新891详细数据
	 * @param session
	 * @param time
	 * @return
	 */
	public String updateHn891ToDetail(int time)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		String sql = "update t_hn_detail_ls a, hn891_ls b set a.lrxg=b.lrxg,a.xl_lrxg=b.xl_lrxg," +
    				"a.lrsq=b.lrsq,a.xl_lrsq=b.xl_lrsq,a.jhxg=b.jhxg,a.xl_jhxg=b.xl_jhxg,a.jhsq=b.jhsq," +
    				"a.xl_jhsq=b.xl_jhsq,a.tp=b.lrtp,a.lrcc=b.lrcc,a.jhcc=b.jhcc,a.cx=b.cx," +
    				"a.output891=b.zhcl,a.output=a.output895+b.zhcl,a.ccl891=b.ccl,a.cxl891=b.cxl," +
    				"a.tpl891=b.lrtpl where a.time='"+time+"' and b.time='"+time+"' and a.no=b.no";
    		session.createSQLQuery(sql).executeUpdate();
//    		sql = "update t_hn_detail_ls set online=0 where output<1 and time='"+time+"'";
//    		session.createSQLQuery(sql).executeUpdate();
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
	/**
	 * 更新895详细数据(耗时长)
	 * @param session
	 * @param time
	 * @return
	 */
	public String updateHn895ToDetail(int time)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		String sql = "update t_hn_detail_ls a, hn895_ls b set a.output895=b.zhcl," +
    				"a.output=a.output891+b.zhcl,a.ccl895=b.ccl,a.cxl895=b.cxl,a.tpl895=b.lrtpl" +
    				" where a.time='"+time+"' and b.time='"+time+"' and a.no=b.no;";
    		session.createSQLQuery(sql).executeUpdate();
    		sql = "update t_hn_detail_ls set online=0 where output<1 and time='"+time+"'";
    		session.createSQLQuery(sql).executeUpdate();
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
	/**
	 * 计算累计值并存储到temp表
	 * @param session
	 * @param time
	 * @return
	 */
	public String updateDetailToTemp(int bdate, int idate)
	{
		String sql = "";
		//YearSeason ys = new YearSeason();
		//String old1monthdate = ys.getLastFiveDate(String.valueOf(idate));
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	//String truncate = "delete from t_hn_detail_temp where time<'"+old1monthdate+"' or time='"+idate+"'";
    	String truncate = "truncate t_hn_detail_temp";
    	session.createSQLQuery(truncate).executeUpdate();
		//truncate = "delete from hn891_temp where time<'"+old1monthdate+"' or time='"+idate+"'";
    	truncate = "truncate hn891_temp";
    	session.createSQLQuery(truncate).executeUpdate();
		//truncate = "delete from hn895_temp where time<'"+old1monthdate+"' or time='"+idate+"'";
    	truncate = "truncate hn895_temp";
    	session.createSQLQuery(truncate).executeUpdate();
		//hndetail累计
		//sql = "insert into t_hn_detail_temp (time,no,ljlrsc,ljlr,ljjh,ljtp,ljcx,ljcl,ljlrcc,ljjhcc,ljsxts,ljqdlr,ljqdlrz) SELECT '"+idate+"',no,sum(IFNULL(xl_lrxg,0)),sum(IFNULL(lrxg,0)),sum(IFNULL(jhxg,0)),sum(IFNULL(tp,0)),sum(IFNULL(cx,0)),sum(IFNULL(output,0)),sum(IFNULL(lrcc,0)),sum(IFNULL(jhcc,0)),sum(IFNULL(online,0)),sum(IFNULL(qdlr,0)),sum(IFNULL(qdlrz,0)) from t_hn_detail where time >='"+bdate+"' and time<='"+idate+"' group by no";
		//session.createSQLQuery(sql).executeUpdate();
		sql = "insert into t_hn_detail_temp (time,no,team,ljlrsc,lrxg891,jhxg891,lrcc891,jhcc891," +
				"cx891,tp891,sumxl891,ywl891,output891,lrxg895,jhxg895,lrcc895,jhcc895," +
				"cx895,tp895,sumxl895,ywl895,output895,ljlr891,ljjh891,ljtp891,ljcx891," +
				"ljlr895,ljjh895,ljtp895,ljcx895,ljcl,ljlrcc891,ljjhcc891,ljlrcc895,ljjhcc895," +
				"ljywl891,ljywl895,online,ljsxts,ljqdlr,ljqdlrz) SELECT '"+idate+"',no,team,0.0,0,0,0,0,0,0," +
				"0.0,0,0.0,0,0,0,0,0,0,0.0,0,0.0,0,0,0,0,0,0,0,0," +
				"sum(IFNULL(output,0)),0,0,0,0,0,0,0,sum(IFNULL(online,0)),sum(IFNULL(qdlr,0))," +
				"sum(IFNULL(qdlrz,0)) from t_hn_detail where time >='"+bdate+"' and time<='"+idate+"' group by no";
		session.createSQLQuery(sql).executeUpdate();
//		//更新online
		sql = "update t_hn_detail_temp a,t_hn_detail_ls b set a.online=b.online where a.no=b.no and a.time=b.time";
		session.createSQLQuery(sql).executeUpdate();
		//891累计
		sql = "insert into hn891_temp (no,time,ljlrsc,ljlr,ljjh,ljtp,ljcx,ljlrcc,ljjhcc,ljywl) select no,'"+idate+"',sum(IFNULL(xl_lrxg,0))," +
				"sum(IFNULL(lrxg,0)),sum(IFNULL(jhxg,0)),sum(IFNULL(lrtp,0)),sum(IFNULL(cx,0)),sum(IFNULL(lrcc,0))," +
				"sum(IFNULL(jhcc,0)),sum(IFNULL(ywl,0)) from hn891 where time>='"+bdate+"' and time<='"+idate+"' group by no";
		session.createSQLQuery(sql).executeUpdate();
		
		sql = "update t_hn_detail_temp a,hn891_temp b set a.ljlrsc=b.ljlrsc,a.ljlr891=b.ljlr,a.ljjh891=b.ljjh," +
				"a.ljtp891=b.ljtp,a.ljcx891=b.ljcx,a.ljlrcc891=b.ljlrcc,a.ljjhcc891=b.ljjhcc,a.ljywl891=b.ljywl " +
				"where a.no=b.no and a.time=b.time and b.time='"+idate+"'";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_temp a,hn891_ls b set " +
				"a.lrxg891=b.lrxg,a.jhxg891=b.jhxg,a.lrcc891=b.lrcc,a.jhcc891=b.jhcc," +
				"a.cx891=b.cx,a.tp891=b.lrtp,a.sumxl891=b.sumxl,a.ywl891=b.ywl,a.output891=b.zhcl" +
				" where a.no=b.no and a.time=b.time";
		session.createSQLQuery(sql).executeUpdate();
		sql = "insert into hn895_temp (no,time,ljlr,ljjh,ljtp,ljcx,ljlrcc,ljjhcc,ljywl) select no,'"+idate+"'," +
		"sum(IFNULL(lrxg,0)),sum(IFNULL(jhxg,0)),sum(IFNULL(lrtp,0)),sum(IFNULL(cx,0)),sum(IFNULL(lrcc,0))," +
		"sum(IFNULL(jhcc,0)),sum(IFNULL(ywl,0)) from hn895 where time>='"+bdate+"' and time<='"+idate+"' group by no";
		session.createSQLQuery(sql).executeUpdate();

		sql = "update t_hn_detail_temp a,hn895_temp b set a.ljlr895=b.ljlr,a.ljjh895=b.ljjh," +
		"a.ljtp895=b.ljtp,a.ljcx895=b.ljcx,a.ljlrcc895=b.ljlrcc,a.ljjhcc895=b.ljjhcc,a.ljywl895=b.ljywl " +
				"where a.no=b.no and a.time=b.time and b.time='"+idate+"'";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_temp a,hn895_ls b set " +
				"a.lrxg895=b.lrxg,a.jhxg895=b.jhxg,a.lrcc895=b.lrcc,a.jhcc895=b.jhcc," +
				"a.cx895=b.cx,a.tp895=b.lrtp,a.sumxl895=b.sumxl,a.ywl895=b.ywl,a.output895=b.zhcl" +
				" where a.no=b.no and a.time=b.time";
		session.createSQLQuery(sql).executeUpdate();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		//String sql = "update t_hn_detail_temp a,t_hn_detail b set a.ljlrsc=sum(b.xl_lrxg),a.ljlr=sum(b.lrxg),a.ljjh=sum(b.jhxg),a.ljtp=sum(b.tp),a.ljcx=sum(b.cx),a.ljcl=sum(b.output),a.ljlrcc=sum(b.lrcc),a.ljjhcc=sum(b.jhcc),a.ljsxts=sum(b.online) where b.time >='"+bdate+"' and b.time<='"+idate+"' and a.no=b.no group by b.no";
		return "success";
	}
	
	/**
	 * 将计算后的数值存入detail表(耗时长)
	 * @param session
	 * @param idate
	 * @param clzb
	 * @param klrxg
	 * @param kjhxg
	 * @return
	 */
	
	public String updateTempToDetail(int idate,double clzb)
	{
		HnConfigDAO hcdao = new HnConfigDAO();
		Xishu xs891 = hcdao.getConfigByType(1);
		Xishu xs895 = hcdao.getConfigByType(2);
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		//String sql1 = "select (b.ljlrcc*"+klrxg+"+b.ljjhcc*"+kjhxg+")/(b.ljlr*"+klrxg+"+b.ljjh*"+kjhxg+")";
    		//累计上线天数大于0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              修改
    		String sql = "update t_hn_detail_ls a,t_hn_detail_temp b set a.ljlrsc=b.ljlrsc," +
    				"a.ljlr=b.ljlr891,a.ljjh=b.ljjh891,a.ljlr895=b.ljlr895," +
    				"a.ljjh895=b.ljjh895,a.ljtp=b.ljtp891,a.ljcx=b.ljcx891," +
    				"a.ljcl=b.ljcl,a.ljywl891=b.ljywl891,a.ljywl895=b.ljywl895," +
    				"a.ljlrcc=b.ljlrcc891,a.ljjhcc=b.ljjhcc891," +
    				"a.ljrjcl=CAST(b.ljcl/b.ljsxts AS DECIMAL(18,0))," +
    				"a.rjclwcl=CAST(CAST(b.ljcl/b.ljsxts AS DECIMAL(18,0))/"+clzb+" AS DECIMAL(18,4))," +
    				"a.rjccl891=CAST((b.ljlrcc891*"+xs891.getXs3()+"+b.ljjhcc891*"+xs891.getXs5()+")/(b.ljlr891*"+xs891.getXs3()+"+b.ljjh891*"+xs891.getXs5()+") AS DECIMAL(18,4))," +
    				"a.rjccl895=CAST((b.ljlrcc895*"+xs895.getXs3()+"+b.ljjhcc895*"+xs895.getXs5()+")/(b.ljlr895*"+xs895.getXs3()+"+b.ljjh895*"+xs895.getXs5()+") AS DECIMAL(18,4))," +
    				"a.rjcxl891=CAST(b.ljcx891/b.ljywl891 AS DECIMAL(18,4))," +
    				"a.rjcxl895=CAST(b.ljcx895/b.ljywl895 AS DECIMAL(18,4))," +
    				"a.rjtpl891=CAST(b.ljtp891/b.ljywl891 AS DECIMAL(18,4))," +
    				"a.rjtpl895=CAST(b.ljtp895/b.ljywl895 AS DECIMAL(18,4))," +
    				"a.ljsxts=b.ljsxts,a.ljqdlr=b.ljqdlr,a.ljqdlrz=b.ljqdlrz," +
    				"a.ljqdlrzl=CAST(b.ljqdlrz/b.ljqdlr AS DECIMAL(18,4))," +
    				"a.zyccl=CAST((b.lrcc891*"+xs891.getXs3()+"+b.jhcc891*"+xs891.getXs5()+"+b.lrcc895*"+xs895.getXs3()+"+b.jhcc895*"+xs895.getXs5()+")" +
    				"/(b.lrxg891*"+xs891.getXs3()+"+b.jhxg891*"+xs891.getXs5()+"+b.lrxg895*"+xs895.getXs3()+"+b.jhxg895*"+xs895.getXs5()+") AS DECIMAL(18,4)) "+
    				"where a.time='"+idate+"' and b.time='"+idate+"' and b.ljsxts>0 and a.no=b.no";
    		System.out.println(sql);
    		session.createSQLQuery(sql).executeUpdate();
    		//累计上线天数为0
    		sql = "update t_hn_detail_ls a,t_hn_detail_temp b set a.ljlrsc=b.ljlrsc," +
    				"a.ljlr=b.ljlr891,a.ljjh=b.ljjh891,a.ljlr895=b.ljlr895," +
    				"a.ljjh895=b.ljjh895,a.ljtp=b.ljtp891,a.ljcx=b.ljcx891,a.ljcl=b.ljcl," +
    				"a.ljywl891=b.ljywl891,a.ljywl895=b.ljywl895,a.ljlrcc=b.ljlrcc891," +
    				"a.ljjhcc=b.ljjhcc891,a.ljrjcl=0,a.rjclwcl=null," +
    				"a.rjccl891=CAST((b.ljlrcc891*"+xs891.getXs3()+"+b.ljjhcc891*"+xs891.getXs5()+")/(b.ljlr891*"+xs891.getXs3()+"+b.ljjh891*"+xs891.getXs5()+") AS DECIMAL(18,4))," +
    				"a.rjccl895=CAST((b.ljlrcc895*"+xs895.getXs3()+"+b.ljjhcc895*"+xs895.getXs5()+")/(b.ljlr895*"+xs895.getXs3()+"+b.ljjh895*"+xs895.getXs5()+") AS DECIMAL(18,4))," +
    				"a.rjcxl891=CAST(b.ljcx891/b.ljywl891 AS DECIMAL(18,4))," +
    				"a.rjcxl895=CAST(b.ljcx895/b.ljywl895 AS DECIMAL(18,4))," +
    				"a.rjtpl891=CAST(b.ljtp891/b.ljywl891 AS DECIMAL(18,4))," +
    				"a.rjtpl895=CAST(b.ljtp895/b.ljywl895 AS DECIMAL(18,4))," +
    				"a.ljsxts=b.ljsxts,a.ljqdlr=b.ljqdlr,a.ljqdlrz=b.ljqdlrz," +
    				"a.ljqdlrzl=CAST(b.ljqdlrz/b.ljqdlr AS DECIMAL(18,4))," +
    				"a.zyccl=CAST((b.lrcc891*"+xs891.getXs3()+"+b.jhcc891*"+xs891.getXs5()+"+b.lrcc895*"+xs895.getXs3()+"+b.jhcc895*"+xs895.getXs5()+")" +
    				"/(b.lrxg891*"+xs891.getXs3()+"+b.jhxg891*"+xs891.getXs5()+"+b.lrxg895*"+xs895.getXs3()+"+b.jhxg895*"+xs895.getXs5()+") AS DECIMAL(18,4)) "+
    				"where a.time='"+idate+"' and b.time='"+idate+"' and b.ljsxts=0 and a.no=b.no";
    		session.createSQLQuery(sql).executeUpdate();
    		
    		
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
	
	/**
	 * 计算作业质量(目前使用的)
	 * @param check
	 * @param control
	 * @param session
	 * @param idate
	 * @return
	 */
	public String countZyzl(MonthParaDAO mpdao,GeneralCheck check,String bdate,String idate)
	{
		HnDetailDAO hddao = new HnDetailDAO();
		double cl=0.0;
		int j=0;
		double percl=0.0;
		String sql = "";
		PerclDAO pdao = new PerclDAO();
		Object objcl = null;
		Object objol = null;
		Percl per = new Percl();
//		String sql = "select * from t_hn_detail where time>='"+bdate+"' and time<='"+idate+"' and xz =0";//分别计算每一天的人员属性与产量情况
//		String sql2 = "select * from t_hn_detail_ls where time='"+idate+"'";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
//		List<HnDetail> listhd = (List<HnDetail>)session.createSQLQuery(sql).addEntity(HnDetail.class).list();
//		List<HnDetail> listhdupdate = (List<HnDetail>)session.createSQLQuery(sql2).addEntity(HnDetail.class).list();
		sql = "select sum(output) from t_hn_detail where time>='"+bdate+"' and time<='"+idate+"' and xz =0";
		objcl=session.createSQLQuery(sql).uniqueResult();
		if(objcl!=null)
		{
			cl = Double.parseDouble(objcl.toString());
		}
		sql = "select sum(online) from t_hn_detail where time>='"+bdate+"' and time<='"+idate+"' and xz =0";
		objol=session.createSQLQuery(sql).uniqueResult();
		if(objol!=null)
		{
			j = Integer.parseInt(objol.toString());
		}
		if(j==0)
		{
			percl = 0.0;
		}
		else
		{
			percl = cl/j;
		}
		System.out.println("percl:"+percl);
		double cmp_ccl=mpdao.findHnzlByMonth(Integer.parseInt(idate.substring(0,6)));
		sql = "update t_hn_detail_ls set zyzl=1 where time='"+idate+"' and xz=0";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_ls set zyzl=zyzl+1 where time='"+idate+"' and xz=0 and ljsxts>0 and rjccl891<='"+cmp_ccl+"'";//要改
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_ls set zyzl=zyzl+1 where time='"+idate+"' and xz=0 and ljrjcl>='"+percl+"'";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_ls set zyzl=-1 where time='"+idate+"' and xz=0 and ljsxts=0";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_ls set tpl891=null where time='"+idate+"' and online!=1 and (tp=null or tp=0)";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_ls set ccl891=null where time='"+idate+"' and online!=1 and (lrcc=null or lrcc=0)";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_ls set cxl891=null where time='"+idate+"' and online!=1 and (cx=null or cx=0)";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_ls set qdlrzl=null where time='"+idate+"' and online!=1 and (qdlrz=null or qdlrz=0)";
		session.createSQLQuery(sql).executeUpdate();
		sql = "update t_hn_detail_ls set tpl891=0.0 where time='"+idate+"' and online=1 and tpl891=null";
		session.createSQLQuery(sql).executeUpdate();
		if(pdao.findByTime(idate)==null)
		{
			per.setSumljcl(check.DoubleToInteger0(cl));
			per.setSumljsxts(j);
			per.setPercl(check.DoubleTo4(percl));
			per.setTime(idate);
			pdao.merge(per);
		}
		else
		{
			per = pdao.findByTime(idate);
			per.setSumljcl(check.DoubleToInteger0(cl));
			per.setSumljsxts(j);
			per.setPercl(check.DoubleTo4(percl));
			pdao.merge(per);
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
	/**
	 * 计算分组统计表(20170116改为计算当日数据)
	 * （20171120增加外汇、建亚、稽核、远程审核等数据）
	 * @param date
	 * @return
	 */
	public String countTeam(String idate)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		String sql = "";
    	String bdate = idate.substring(0, 6)+"01";	
		String sqldel = "delete Team t where t.time='"+idate+"'";
		session.createQuery(sqldel).executeUpdate();
		sql = "truncate t_hn_team_temp";
		session.createQuery(sqldel).executeUpdate();
		for(int i=2;i<7;i++)
		{
			if(i!=4&&i!=5)
			{
				sql = "insert into t_hn_team(time,chu,team,cl,clrmb,clwh,cljh," +
				"clsh,cljy,clfxq,rjcl,rjclrmb,rjclwh,rjcljh,rjclsh,rjcljy,rjclfxq," +
				"ccl,cclrmb,cclwh,ccljy,xl,xlrmb,xlwh,xljh,xlsh,xljy,perccl891," +
				"pertpl891,percxl891,perccl895,pertpl895," +
				"percxl895,remark1,remark2,remark3) select '"+idate+"','"+i+"'," +
				"'0',CAST(sum(clrmb+clwh+cljh+clsh+cljy+clfxq)/sum(sx) AS DECIMAL(18,0))," +
				"CAST(sum(clrmb)/sum(sxrmb) AS DECIMAL(18,0))," +
				"CAST(sum(clwh)/sum(sxwh) AS DECIMAL(18,0))," +
				"CAST(sum(cljh)/sum(sxjh) AS DECIMAL(18,0))," +
				"CAST(sum(clsh)/sum(sxsh) AS DECIMAL(18,0))," +
				"CAST(sum(cljy)/sum(sxjy) AS DECIMAL(18,0))," +
				"CAST(sum(clfxq)/sum(sxfxq) AS DECIMAL(18,0))," +
				"0.0,0.0,0.0,0.0,0.0,0.0,0.0," +
				"CAST(sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz)/sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) AS DECIMAL(18,4))," +
				"CAST(sum(cclrmb_fz)/sum(cclrmb_fm) AS DECIMAL(18,4))," +
				"CAST(sum(cclwh_fz)/sum(cclwh_fm) AS DECIMAL(18,4))," +
				"CAST(sum(ccljy_fz)/sum(ccljy_fm) AS DECIMAL(18,4))," +
				"CAST(sum(xlrmb_fz+xlwh_fz+xljh_fz+xlsh_fz+xljy_fz)/sum(xlrmb_fm+xlwh_fm+xljh_fm+xlsh_fm+xljy_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlrmb_fz)/sum(xlrmb_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlwh_fz)/sum(xlwh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xljh_fz)/sum(xljh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlsh_fz)/sum(xlsh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xljy_fz)/sum(xljy_fm) AS DECIMAL(18,2)),0.0,0.0,0.0,0.0,0.0,0.0," +
				"'0','0','0' from t_hn_new where date='"+idate+"' and zx=0 and xz!=3 and pos like '__"+i+"__' and mid(pos,5,1) in ('1','2','3','4','5','6','7','8','9','A','B')";
				session.createSQLQuery(sql).executeUpdate();
				
				sql = "insert into t_hn_team(time,chu,team,cl,clrmb,clwh,cljh," +
				"clsh,cljy,clfxq,rjcl,rjclrmb,rjclwh,rjcljh,rjclsh,rjcljy,rjclfxq," +
				"ccl,cclrmb,cclwh,ccljy,xl,xlrmb,xlwh,xljh,xlsh,xljy,perccl891," +
				"pertpl891,percxl891,perccl895,pertpl895," +
				"percxl895,remark1,remark2,remark3) select '"+idate+"','"+i+"'," +
				"mid(pos,5,1),CAST(sum(clrmb+clwh+cljh+clsh+cljy)/sum(sx) AS DECIMAL(18,0))," +
				"CAST(sum(clrmb)/sum(sxrmb) AS DECIMAL(18,0))," +
				"CAST(sum(clwh)/sum(sxwh) AS DECIMAL(18,0))," +
				"CAST(sum(cljh)/sum(sxjh) AS DECIMAL(18,0))," +
				"CAST(sum(clsh)/sum(sxsh) AS DECIMAL(18,0))," +
				"CAST(sum(cljy)/sum(sxjy) AS DECIMAL(18,0))," +
				"CAST(sum(clfxq)/sum(sxfxq) AS DECIMAL(18,0))," +
				"0.0,0.0,0.0,0.0,0.0,0.0,0.0," +
				"CAST(sum(cclrmb_fz+cclwh_fz+ccljh_fz+cclsh_fz+ccljy_fz)/sum(cclrmb_fm+cclwh_fm+ccljh_fm+cclsh_fm+ccljy_fm) AS DECIMAL(18,4))," +
				"CAST(sum(cclrmb_fz)/sum(cclrmb_fm) AS DECIMAL(18,4))," +
				"CAST(sum(cclwh_fz)/sum(cclwh_fm) AS DECIMAL(18,4))," +
				"CAST(sum(ccljy_fz)/sum(ccljy_fm) AS DECIMAL(18,4))," +
				"CAST(sum(xlrmb_fz+xlwh_fz+xljh_fz+xlsh_fz+xljy_fz)/sum(xlrmb_fm+xlwh_fm+xljh_fm+xlsh_fm+xljy_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlrmb_fz)/sum(xlrmb_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlwh_fz)/sum(xlwh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xljh_fz)/sum(xljh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlsh_fz)/sum(xlsh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xljy_fz)/sum(xljy_fm) AS DECIMAL(18,2)),0.0,0.0,0.0,0.0,0.0,0.0," +
				"'0','0','0' from t_hn_new where date='"+idate+"' and zx=0 and xz!=3 and pos like '__"+i+"__' and mid(pos,5,1) in ('1','2','3','4','5','6','7','8','9','A','B') group by mid(pos,5,1)";
				session.createSQLQuery(sql).executeUpdate();
					
				sql = "insert into t_hn_team_temp(time,chu,team,rjcl," +
				"rjclrmb,rjclwh,rjcljh,rjclsh,rjcljy,rjclfxq) select '"+idate+"','"+i+"'," +
				"'0',CAST(sum(clrmb+clwh+cljh+clsh+cljy+clfxq)/sum(sx) AS DECIMAL(18,0))," +
				"CAST(sum(clrmb)/sum(sxrmb) AS DECIMAL(18,0))," +
				"CAST(sum(clwh)/sum(sxwh) AS DECIMAL(18,0))," +
				"CAST(sum(cljh)/sum(sxjh) AS DECIMAL(18,0))," +
				"CAST(sum(clsh)/sum(sxsh) AS DECIMAL(18,0))," +
				"CAST(sum(cljy)/sum(sxjy) AS DECIMAL(18,0))," +
				"CAST(sum(clfxq)/sum(sxfxq) AS DECIMAL(18,0))" +
				" from t_hn_new where date>='"+bdate+"' and date<='"+idate+"' and zx=0 and xz!=3 and pos like '__"+i+"__' and mid(pos,5,1) in ('1','2','3','4','5','6','7','8','9','A','B')";	
				session.createSQLQuery(sql).executeUpdate();
				
				sql = "insert into t_hn_team_temp(time,chu,team,rjcl," +
				"rjclrmb,rjclwh,rjcljh,rjclsh,rjcljy,rjclfxq) select '"+idate+"','"+i+"'," +
				"mid(pos,5,1),CAST(sum(clrmb+clwh+cljh+clsh+cljy+clfxq)/sum(sx) AS DECIMAL(18,0))," +
				"CAST(sum(clrmb)/sum(sxrmb) AS DECIMAL(18,0))," +
				"CAST(sum(clwh)/sum(sxwh) AS DECIMAL(18,0))," +
				"CAST(sum(cljh)/sum(sxjh) AS DECIMAL(18,0))," +
				"CAST(sum(clsh)/sum(sxsh) AS DECIMAL(18,0))," +
				"CAST(sum(cljy)/sum(sxjy) AS DECIMAL(18,0))," +
				"CAST(sum(clfxq)/sum(sxfxq) AS DECIMAL(18,0))" +
				" from t_hn_new where date>='"+bdate+"' and date<='"+idate+"' and zx=0 and xz!=3 and pos like '__"+i+"__' and mid(pos,5,1) in ('1','2','3','4','5','6','7','8','9','A','B') group by mid(pos,5,1)";	
				session.createSQLQuery(sql).executeUpdate();
					
			}
		}
		sql = "update t_hn_team a,t_hn_team_temp b set a.rjcl=b.rjcl," +
				"a.rjclrmb=b.rjclrmb,a.rjclwh=b.rjclwh,a.rjcljh=b.rjcljh," +
				"a.rjclsh=b.rjclsh,a.rjcljy=b.rjcljy,a.rjclfxq=b.rjclfxq " +
				"where a.time=b.time and a.chu=b.chu and a.team=b.team";
		session.createSQLQuery(sql).executeUpdate();

		sql = "update t_hn_team set rjcl=IFNULL(rjcl,0),rjclrmb=IFNULL(rjclrmb,0)," +
		"rjclwh=IFNULL(rjclwh,0),rjcljh=IFNULL(rjcljh,0),rjclsh=IFNULL(rjclsh,0)," +
		"rjcljy=IFNULL(rjcljy,0),rjclfxq=IFNULL(rjclfxq,0),cl=IFNULL(cl,0)," +
		"clrmb=IFNULL(clrmb,0),clwh=IFNULL(clwh,0),cljh=IFNULL(cljh,0),clsh=IFNULL(clsh,0)," +
		"cljy=IFNULL(cljy,0),ccl=IFNULL(ccl,0),cclrmb=IFNULL(cclrmb,0),cclwh=IFNULL(cclwh,0)," +
		"ccljy=IFNULL(ccljy,0),xl=IFNULL(xl,0)," +
		"xlrmb=IFNULL(xlrmb,0),xlwh=IFNULL(xlwh,0),xljh=IFNULL(xljh,0),xlsh=IFNULL(xlsh,0),xljy=IFNULL(xljy,0)";
		session.createSQLQuery(sql).executeUpdate();
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
	

	/**
	 * 临时表到明细表
	 * @return
	 */
	public String lsToHndetail(int time)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
		String sql = "insert into t_hn_detail(time,no,name,zx,xz,team,lrxg,xl_lrxg,ljlrsc," +
				"lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,ljlr,ljjh,ljlr895,ljjh895,tp,ljtp,lrcc,jhcc,cx,ljcx," +
				"output891,output895,output,ccl891,cxl891,tpl891,ccl895,cxl895,tpl895,ljcl," +
				"ljywl891,ljywl895,ljrjcl,rjclwcl,ljlrcc,ljjhcc,rjccl891,rjcxl891,rjtpl891,rjccl895,rjcxl895," +
				"rjtpl895,ljsxts,online,zyzl,remark1,remark2,remark3,remark4,remark5,qdlr," +
				"qdlrz,ljqdlr,ljqdlrz,qdlrzl,ljqdlrzl,percltime,zyccl) select time,no,name," +
				"zx,xz,team,lrxg,xl_lrxg,ljlrsc,lrsq,xl_lrsq,jhxg,xl_jhxg,jhsq,xl_jhsq,ljlr," +
				"ljjh,ljlr895,ljjh895,tp,ljtp,lrcc,jhcc,cx,ljcx,output891,output895,output,ccl891,cxl891,tpl891," +
				"ccl895,cxl895,tpl895,ljcl,ljywl891,ljywl895,ljrjcl,rjclwcl,ljlrcc,ljjhcc,rjccl891,rjcxl891," +
				"rjtpl891,rjccl895,rjcxl895,rjtpl895,ljsxts,online,zyzl,remark1,remark2,remark3," +
				"remark4,remark5,qdlr,qdlrz,ljqdlr,ljqdlrz,qdlrzl,ljqdlrzl,percltime,zyccl from t_hn_detail_ls where time='"+time+"'";
		session.createSQLQuery(sql).executeUpdate();
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
	/**
	 * 明细表删除
	 * @return
	 */
	public String deleteHndetail(String idate)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
		String sql = "delete from t_hn_detail where time='"+idate+"'";
		session.createSQLQuery(sql).executeUpdate();
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

	/**
	 * ls表到hnnew表
	 * @param date
	 * @return
	 */
	public String lsToHnnew(String date)
	{
		GeneralCheck check =new GeneralCheck();
		HnConfigDAO hcdao = new HnConfigDAO();
		HndetailLsDAO lsdao = new HndetailLsDAO();
		HnWaihuiDAO whdao = new HnWaihuiDAO();
		HdTempDAO htdao = new HdTempDAO();
		HnJiheDAO jhdao = new HnJiheDAO();
		HnYcshDAO hydao = new HnYcshDAO();
		HnNewDAO hndao = new HnNewDAO();
		HnJianyaDAO jydao = new HnJianyaDAO();
		HnFxqDAO fxqdao = new HnFxqDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		Xishu xs891 = hcdao.getConfigByType(1);
    		Xishu xs895 = hcdao.getConfigByType(2);
    		Xishu xswh = hcdao.getConfigByType(3);
    		Xishu xsjy = hcdao.getConfigByType(6);
    		
    		List<HndetailLs> listrmb = lsdao.findAllByDate(date);
    		List<HnWaihui> listwh = whdao.findAllByDate(date);
    		List<HnJihe> listjh = jhdao.findAllByDate(date);
    		List<HnYcsh> listhy = hydao.findAllByDate(date);
    		List<HnJianya> listjy = jydao.findAllByDate(date);
    		List<HnFxq> listfxq = fxqdao.findAllByDate(date);
    	//人民币
    	for(int i=0;i<listrmb.size();i++)
    	{
    		HndetailLs ls = listrmb.get(i);
    		HdTemp ht = htdao.findAllByDateAndNo(date, ls.getNo());
//    		List<UserInfo> listui = uidao.findAllByNo891(ls.getNo());
    		HnNew hn = hndao.findAllByDateAndNo(date,ls.getNo());
    		hn.setName(ls.getName());
    		hn.setZx(ls.getZx());
    		hn.setXz(ls.getXz());
    		System.out.println(ls.getNo());
//    		if(!listui.isEmpty())
//    		{
//    			hn.setPos(listui.get(0).getPosition());
//    		}
    		if(ls.getName().equals("李曦"))
    		{
    			System.out.println("111");
    		}
    		hn.setClrmb(ls.getOutput());
    		hn.setCclrmbFz(check.mul(ht.getLrcc891(),xs891.getXs3())+check.mul(ht.getJhcc891(),xs891.getXs5())+check.mul(ht.getLrcc895(),xs895.getXs3())+check.mul(ht.getJhcc895(),xs895.getXs5()));
    		hn.setCclrmbFm(check.mul(ht.getLrxg891(),xs891.getXs3())+check.mul(ht.getJhxg891(),xs891.getXs5())+check.mul(ht.getLrxg895(),xs895.getXs3())+check.mul(ht.getJhxg895(),xs895.getXs5()));
    		hn.setXlrmbFz(ht.getSumxl891()+ht.getSumxl895());
    		hn.setXlrmbFm(ht.getOutput891()+ht.getOutput895());
    		hn.setSxrmb(ls.getOnline());
    		if(ls.getOutput()<1)
    		{
    			hn.setSxrmb(0);
    		}
    		hndao.merge(hn);
    	}
    	//外汇
    	for(int i=0;i<listwh.size();i++)
    	{
    		HnWaihui wh = listwh.get(i);
    		System.out.println("外汇："+wh.getName());
    		HnNew hn = hndao.findAllByDateAndNo(date,wh.getNo());
    		//System.out.println("whid"+wh.getId()+"date"+date+"no"+wh.getNo()+"lrxg"+wh.getLrxg()+"jhxg"+wh.getJhxg()+"xs3"+xswh.getXs3()+"xs5"+xswh.getXs5());
    		hn.setClwh(wh.getZhcl());
    		hn.setCclwhFz(check.mul(wh.getLrcc(),xswh.getXs3())+check.mul(wh.getJhcc(),xswh.getXs5()));
    		hn.setCclwhFm(check.mul(wh.getLrxg(),xswh.getXs3())+check.mul(wh.getJhxg(),xswh.getXs5()));
    		hn.setXlwhFz(wh.getSumxl());
    		hn.setXlwhFm(wh.getZhcl());
    		if(wh.getZhcl()>0)
    		{
    			hn.setSxwh(1);
    		}
    		else
    		{
    			hn.setSxwh(0);
    		}
    		hndao.merge(hn);
    	}
    	//稽核
    	for(int i=0;i<listjh.size();i++)
    	{
    		HnJihe jh = listjh.get(i);
    		HnNew hn = hndao.findAllByDateAndName(date,jh.getName());
    		hn.setCljh(jh.getCl());
    		if(jh.getCl()>0)
    		{
    			hn.setSxjh(1);
    		}
    		else
    		{
    			hn.setSxjh(0);
    		}
    		hndao.merge(hn);
    	}
    	//远程身份审核
    	for(int i=0;i<listhy.size();i++)
    	{
    		HnYcsh hy = listhy.get(i);
    		HnNew hn = hndao.findAllByDateAndName(date,hy.getName());
    		hn.setXlshFz((double)hy.getSc());
    		hn.setXlshFm(hy.getCl());
    		hn.setTglsh(hy.getTgl());
    		hn.setClsh(hy.getCl());
    		if(hy.getCl()>0)
    		{
    			hn.setSxsh(1);
    		}
    		else
    		{
    			hn.setSxsh(0);
    		}
    		hndao.merge(hn);
    	}
    	//建亚
    	for(int i=0;i<listjy.size();i++)
    	{
    		HnJianya jy = listjy.get(i);
    		HnNew hn = hndao.findAllByDateAndNo(date,jy.getNo());
    		hn.setCljy(jy.getZhcl());
    		hn.setCcljyFz(check.mul(jy.getLrcc(),xsjy.getXs1())+check.mul(jy.getJhcc(),xsjy.getXs3()));
    		hn.setCcljyFm(check.mul(jy.getLrxg(),xsjy.getXs1())+check.mul(jy.getJhxg(),xsjy.getXs3()));
    		hn.setXljyFz(jy.getSumxl());
    		hn.setXljyFm(jy.getZhcl());
    		if(jy.getZhcl()>0)
    		{
    			hn.setSxjy(1);
    		}
    		else
    		{
    			hn.setSxjy(0);
    		}
    		hndao.merge(hn);
    	}
    	//反洗钱
    	for(int i=0;i<listfxq.size();i++)
    	{
    		HnFxq fxq = listfxq.get(i);
    		HnNew hn = hndao.findAllByDateAndNo(date,fxq.getNewnumber());
    		hn.setClfxq(fxq.getCl());
    		if(fxq.getCl()>0)
    		{
    			hn.setSxfxq(1);
    		}
    		else
    		{
    			hn.setSxfxq(0);
    		}
    		hndao.merge(hn);
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
	public String lsToHnnew2(String date)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		String sql="update t_hn_new a,t_hn_detail_ls b set a.xlrmb=b.percltime where a.no=b.no and a.date='"+date+"' and b.time='"+date+"'";
    		session.createSQLQuery(sql).executeUpdate();
    		sql="update t_hn_new set xlrmb_fz=CAST(xlrmb_fm*xlrmb AS DECIMAL(18,2)) where date='"+date+"'";
    		session.createSQLQuery(sql).executeUpdate();
    		sql = "update t_hn_new set sx=(if((sxrmb+sxwh+sxjh+sxsh+sxjy+sxfxq)>0,1,0))," +
    		"xz=(if((clwh+cljh+clsh+cljy)>0,0,xz))" +
			",cl=(clrmb+clwh+cljh+clsh+cljy+clfxq)," +
			"ccl=CAST((cclrmb_fz+cclwh_fz+ccljy_fz)/(cclrmb_fm+cclwh_fm+ccljy_fm) AS DECIMAL(18,4))," +
			"xl=CAST((xlrmb_fz+xlwh_fz+xljy_fz+xlsh_fz)/(xlrmb_fm+xlwh_fm+xljy_fm+xlsh_fm) AS DECIMAL(18,2))," +
			"cclrmb=CAST(cclrmb_fz/cclrmb_fm AS DECIMAL(18,4))," +
			"cclwh=CAST(cclwh_fz/cclwh_fm AS DECIMAL(18,4))," +
			"ccljy=CAST(ccljy_fz/ccljy_fm AS DECIMAL(18,4))," +
			//"xlrmb=CAST(xlrmb_fz/xlrmb_fm AS DECIMAL(18,2))," +
			"xlwh=CAST(xlwh_fz/xlwh_fm AS DECIMAL(18,2))," +
			"xljy=CAST(xljy_fz/xljy_fm AS DECIMAL(18,2))," +
			"xlsh=CAST(xlsh_fz/xlsh_fm AS DECIMAL(18,2)) where date='"+date+"'";
	session.createSQLQuery(sql).executeUpdate();
	//累计到temp
	sql = "delete from t_hn_new_temp where date='"+date+"'";
	session.createSQLQuery(sql).executeUpdate();
	sql = "insert into t_hn_new_temp(date,no,name,zx,sumcl,sumsx,sumccfz,sumccfm,sumxlfz,sumxlfm)" +
			" SELECT '"+date+"',no,name,zx,sum(cl),sum(sx),sum(cclrmb_fz+cclwh_fz+ccljh_fz+ccljh_fz+cclsh_fz+ccljy_fz)" +
					",sum(cclrmb_fm+cclwh_fm+ccljh_fm+ccljh_fm+cclsh_fm+ccljy_fm)" +
					",sum(xlrmb_fz+xlwh_fz+xljh_fz+xljh_fz+xlsh_fz+xljy_fz)" +
					",sum(xlrmb_fm+xlwh_fm+xljh_fm+xljh_fm+xlsh_fm+xljy_fm)" +
					" from t_hn_new where date>='"+date.substring(0, 6)+"01' and date<='"+date+"' group by no";
	session.createSQLQuery(sql).executeUpdate();
	//计算日均
	sql = "update t_hn_new a,t_hn_new_temp b set a.ljsx=b.sumsx" +
			",a.rjcl=CAST(b.sumcl/b.sumsx AS DECIMAL(18,2))" +
			",a.rjccl=CAST(b.sumccfz/b.sumccfm AS DECIMAL(18,4))" +
			",a.rjxl=CAST(b.sumxlfz/b.sumxlfm AS DECIMAL(18,2))" +
			" where a.no=b.no and a.date=b.date and a.date='"+date+"'";
	session.createSQLQuery(sql).executeUpdate();
	
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
	/**
	 * 判断输入的date是否合规
	 * @param date
	 * @return
	 */
	public boolean ifDateLegal(String date)
	{
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6));
		if(date.length()!=8)
		{
			logger.error("输入的date长度不合规");
			System.out.println("输入的date长度不合规");
			return false;
		}
		else if(year<2010)
		{
			logger.error("输入的date，year不合规");
			System.out.println("输入的date，year不合规");
			return false;
		}
		else if((month<1)&&(month>13))
		{
			logger.error("输入的date，month不合规");
			System.out.println("输入的date，month不合规");
			return false;
		}
		else if((day<1)&&(day>31))
		{
			logger.error("输入的date，day不合规");
			System.out.println("输入的date，day不合规");
			return false;
		}
		else
			return true;
		
	}
//	/**
//	 * 判断指定日期和任务池是否有数据
//	 * @param pool
//	 * @param time
//	 * @return
//	 */
//	public boolean ifHnNull(String pool,String time)
//	{
//		Hn891DAO dao891 =new Hn891DAO();
//		Hn895DAO dao895 =new Hn895DAO();
//		
//		if(pool.equalsIgnoreCase("891"))
//		{
//			ArrayList<Hn891> list = (ArrayList<Hn891>) dao891.findByDate(time);
//			if(list.size()<1)
//			{
//				return false;
//			}
//			else
//			{
//				return true;
//			}
//		}
//		else if(pool.equalsIgnoreCase("895"))
//		{
//			ArrayList<Hn895> list = (ArrayList<Hn895>)dao895.findByDate(time);
//			if(list.size()<1)
//			{
//				return false;
//			}
//			else
//			{
//				return true;
//			}
//		}
//		else
//		{
//			return false;
//		}
//	}
	
	public boolean ifNullNew(String pool,String time)
	{
		String sql = "";
		int num = 0;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		if(pool.equalsIgnoreCase("891"))
		{
			sql = "select count(*) from hn891_ls where time='"+time+"'";
		}
		else if(pool.equalsIgnoreCase("895"))
		{
			sql = "select count(*) from hn895_ls where time='"+time+"'";
		}
		else
		{
//			sql = "";
		}
		num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
		 trans.commit();
         session.flush();
         session.clear();
         session.close();
         if(num==0)
 		{
 			return false;
 		}
 		else
 		{
 			return true;
 		}
	}
	
	public String trans895to891(String no)
	{
		NoDAO nodao = new NoDAO();
		return ((No)nodao.findBy895No(no).get(0)).getNo891();
	}
	/**
	 * 对EXCEL中空数据进行处理
	 * @param String input
	 * @return 空：true，非空：false
	 */
	public boolean IsNullString(String input) {
		if (input.trim() == null || input.trim().length() <= 0 || input.trim().equals("null"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * 除法运算分子非零判断
	 * @param fenmu
	 * @param fenzi
	 * @return
	 */
	public double division(double fenzi,double fenmu)
	{
		if((fenzi<0.0000001)&&(fenzi>-0.0000001))
		{
			return 0.0;
		}else if(fenmu<0.0000001&&fenmu>-0.0000001)
		{
			return 0.0;
		}
		else
		{
			return fenzi/fenmu;
		}
	}
	
}
