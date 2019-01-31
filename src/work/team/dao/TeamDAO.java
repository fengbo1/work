package work.team.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import ccb.hibernate.HibernateSessionFactory;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.team.pojo.Team;
import work.util.YearSeason;

/**
 	* A data access object (DAO) providing persistence and search support for Team entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Team
  * @author MyEclipse Persistence Tools 
 */

public class TeamDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TeamDAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String CHU = "chu";
	public static final String TEAM = "team";
	public static final String CL = "cl";
	public static final String CLRMB = "clrmb";
	public static final String CLWH = "clwh";
	public static final String CLJH = "cljh";
	public static final String CLSH = "clsh";
	public static final String CLJY = "cljy";
	public static final String CLFXQ = "clfxq";
	public static final String RJCL = "rjcl";
	public static final String RJCLRMB = "rjclrmb";
	public static final String RJCLWH = "rjclwh";
	public static final String RJCLJH = "rjcljh";
	public static final String RJCLSH = "rjclsh";
	public static final String RJCLJY = "rjcljy";
	public static final String RJCLFXQ = "rjclfxq";
	public static final String CCL = "ccl";
	public static final String CCLRMB = "cclrmb";
	public static final String CCLWH = "cclwh";
	public static final String CCLJY = "ccljy";
	public static final String XL = "xl";
	public static final String XLRMB = "xlrmb";
	public static final String XLWH = "xlwh";
	public static final String XLJH = "xljh";
	public static final String XLSH = "xlsh";
	public static final String XLJY = "xljy";
	public static final String PERCCL891 = "perccl891";
	public static final String PERTPL891 = "pertpl891";
	public static final String PERCXL891 = "percxl891";
	public static final String PERCCL895 = "perccl895";
	public static final String PERTPL895 = "pertpl895";
	public static final String PERCXL895 = "percxl895";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";



    
    public void save(Team transientInstance) {
        log.debug("saving Team instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Team persistentInstance) {
        log.debug("deleting Team instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Team findById( java.lang.Integer id) {
        log.debug("getting Team instance with id: " + id);
        try {
            Team instance = (Team) getSession()
                    .get("Team", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Team instance) {
        log.debug("finding Team instance by example");
        try {
            List results = getSession()
                    .createCriteria("Team")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Team instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Team as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
		);
	}
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	
	public List findByTeam(Object team
	) {
		return findByProperty(TEAM, team
		);
	}
	
	public List findByCl(Object cl
	) {
		return findByProperty(CL, cl
		);
	}
	
	public List findByClrmb(Object clrmb
	) {
		return findByProperty(CLRMB, clrmb
		);
	}
	
	public List findByClwh(Object clwh
	) {
		return findByProperty(CLWH, clwh
		);
	}
	
	public List findByCljh(Object cljh
	) {
		return findByProperty(CLJH, cljh
		);
	}
	
	public List findByClsh(Object clsh
	) {
		return findByProperty(CLSH, clsh
		);
	}
	
	public List findByCljy(Object cljy
	) {
		return findByProperty(CLJY, cljy
		);
	}
	
	public List findByClfxq(Object clfxq
	) {
		return findByProperty(CLFXQ, clfxq
		);
	}
	
	public List findByRjcl(Object rjcl
	) {
		return findByProperty(RJCL, rjcl
		);
	}
	
	public List findByRjclrmb(Object rjclrmb
	) {
		return findByProperty(RJCLRMB, rjclrmb
		);
	}
	
	public List findByRjclwh(Object rjclwh
	) {
		return findByProperty(RJCLWH, rjclwh
		);
	}
	
	public List findByRjcljh(Object rjcljh
	) {
		return findByProperty(RJCLJH, rjcljh
		);
	}
	
	public List findByRjclsh(Object rjclsh
	) {
		return findByProperty(RJCLSH, rjclsh
		);
	}
	
	public List findByRjcljy(Object rjcljy
	) {
		return findByProperty(RJCLJY, rjcljy
		);
	}
	
	public List findByRjclfxq(Object rjclfxq
	) {
		return findByProperty(RJCLFXQ, rjclfxq
		);
	}
	
	public List findByCcl(Object ccl
	) {
		return findByProperty(CCL, ccl
		);
	}
	
	public List findByCclrmb(Object cclrmb
	) {
		return findByProperty(CCLRMB, cclrmb
		);
	}
	
	public List findByCclwh(Object cclwh
	) {
		return findByProperty(CCLWH, cclwh
		);
	}
	
	public List findByCcljy(Object ccljy
	) {
		return findByProperty(CCLJY, ccljy
		);
	}
	
	public List findByXl(Object xl
	) {
		return findByProperty(XL, xl
		);
	}
	
	public List findByXlrmb(Object xlrmb
	) {
		return findByProperty(XLRMB, xlrmb
		);
	}
	
	public List findByXlwh(Object xlwh
	) {
		return findByProperty(XLWH, xlwh
		);
	}
	
	public List findByXljh(Object xljh
	) {
		return findByProperty(XLJH, xljh
		);
	}
	
	public List findByXlsh(Object xlsh
	) {
		return findByProperty(XLSH, xlsh
		);
	}
	
	public List findByXljy(Object xljy
	) {
		return findByProperty(XLJY, xljy
		);
	}
	
	public List findByPerccl891(Object perccl891
	) {
		return findByProperty(PERCCL891, perccl891
		);
	}
	
	public List findByPertpl891(Object pertpl891
	) {
		return findByProperty(PERTPL891, pertpl891
		);
	}
	
	public List findByPercxl891(Object percxl891
	) {
		return findByProperty(PERCXL891, percxl891
		);
	}
	
	public List findByPerccl895(Object perccl895
	) {
		return findByProperty(PERCCL895, perccl895
		);
	}
	
	public List findByPertpl895(Object pertpl895
	) {
		return findByProperty(PERTPL895, pertpl895
		);
	}
	
	public List findByPercxl895(Object percxl895
	) {
		return findByProperty(PERCXL895, percxl895
		);
	}
	
	public List findByRemark1(Object remark1
	) {
		return findByProperty(REMARK1, remark1
		);
	}
	
	public List findByRemark2(Object remark2
	) {
		return findByProperty(REMARK2, remark2
		);
	}
	
	public List findByRemark3(Object remark3
	) {
		return findByProperty(REMARK3, remark3
		);
	}
	

	public List findAll() {
		log.debug("finding all Team instances");
		try {
			String queryString = "from Team";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Team merge(Team detachedInstance) {
        log.debug("merging Team instance");
        try {
            Team result = (Team) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Team instance) {
        log.debug("attaching dirty Team instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Team instance) {
        log.debug("attaching clean Team instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllByBegindateAndEnddate(String bdate,String edate) {
    	log.debug("finding all Team instances");
    	try {
    		String queryString = "from Team as t where t.time>='"+bdate+"' and t.time<='"+edate+"' order by t.time";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public String findMaxDate() {
    	log.debug("finding all Team instances");
    	try {
    		YearSeason ys = new YearSeason();
    		String queryString = "from Team as t order by t.time desc";
             Query queryObject = getSession().createQuery(queryString);
             List<Team> list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return ys.getStringDate();
    		 }
    		 else
    		 {
    			 return list.get(0).getTime();
    		 }
             
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public String findNamesByZDY(String type,int indx,String key,Session session )
    {
    	String result = "";
    	String sql = "";
    	int L1 = indx-1;
		int R1 = indx+1;
		if(type.equals("zdy"))
		{
			sql = "select name from t_no where source=concat(mid(source,1,"+L1+"),'"+1+"',mid(source,"+R1+",49)) and position!='99999'";
		}
		else if(type.equals("sx"))
		{
			sql = "select name from t_no where no2=concat(mid(source,1,"+L1+"),'"+key+"',mid(source,"+R1+",49)) and position!='99999'";
		}
		List<String> lists = session.createSQLQuery(sql).list();
		for(int i=0;i<lists.size();i++)
		{
			result +="'";
			String s = lists.get(i);
			result +=s;
			result +="'";
			result +=",";
		}
		if(result.length()>1)
		{
			result = result.substring(0, result.length()-1);
		}
		else
		{
			result = "''";
		}
    	return result;
    }
    
    /**
	 * 计算分组统计表到【临时表】t_hn_team_t
	 * （20171120增加外汇、建亚、稽核、远程审核等数据）
	 * @param date
	 * @return
	 */
	public String countTeamToTemp(String idate,String rmb,String wh,String jh,String sh,String jy,String fxq)
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		String rmbs = "0,0,0,0,0,0";
    		String whs = "0,0,0,0,0,0";
    		String jhs = "0,0,0,0,0,0";
    		String shs = "0,0,0,0,0,0";
    		String jys = "0,0,0,0,0,0";
    		String fxqs = "0,0,0,0,0,0";
    		if(rmb!=null&&rmb.equals("rmb"))
    		{
    			rmbs = "clrmb,sxrmb,cclrmb_fz,cclrmb_fm,xlrmb_fz,xlrmb_fm";
    		}
    		if(wh!=null&&wh.equals("wh"))
    		{
    			whs = "clwh,sxwh,cclwh_fz,cclwh_fm,xlwh_fz,xlwh_fm";
    		}
    		if(jh!=null&&jh.equals("jh"))
    		{
    			jhs = "cljh,sxjh,ccljh_fz,ccljh_fm,xljh_fz,xljh_fm";
    		}
    		if(sh!=null&&sh.equals("sh"))
    		{
    			shs = "clsh,sxsh,cclsh_fz,cclsh_fm,xlsh_fz,xlsh_fm";
    		}
    		if(jy!=null&&jy.equals("jy"))
    		{
    			jys = "cljy,sxjy,ccljy_fz,ccljy_fm,xljy_fz,xljy_fm";
    		}
    		if(fxq!=null&&fxq.equals("fxq"))
    		{
    			fxqs = "clfxq,sxfxq,cclfxq_fz,cclfxq_fm,xlfxq_fz,xlfxq_fm";
    		}
    		
    	String sql = "";
    	String bdate = idate.substring(0, 6)+"01";	
		sql = "truncate t_hn_team_t";
		session.createSQLQuery(sql).executeUpdate();
		sql = "truncate t_hn_team_temp";
		session.createSQLQuery(sql).executeUpdate();
		for(int i=2;i<7;i++)
		{
			if(i!=4&&i!=5)
			{
				sql = "insert into t_hn_team_t(time,chu,team,cl,clrmb,clwh,cljh," +
				"clsh,cljy,clfxq,rjcl,rjclrmb,rjclwh,rjcljh,rjclsh,rjcljy,rjclfxq," +
				"ccl,cclrmb,cclwh,ccljy,xl,xlrmb,xlwh,xljh,xlsh,xljy,perccl891," +
				"pertpl891,percxl891,perccl895,pertpl895," +
				"percxl895,remark1,remark2,remark3) select '"+idate+"','"+i+"'," +
				"'0',CAST(sum(IFNULL("+rmbs.split(",")[0]+",0)+IFNULL("+whs.split(",")[0]+",0)+IFNULL("+jhs.split(",")[0]+",0)+IFNULL("+shs.split(",")[0]+",0)+IFNULL("+jys.split(",")[0]+",0)+IFNULL("+fxqs.split(",")[0]+",0))/sum(if((IFNULL("+rmbs.split(",")[1]+",0)+IFNULL("+whs.split(",")[1]+",0)+IFNULL("+jhs.split(",")[1]+",0)+IFNULL("+shs.split(",")[1]+",0)+IFNULL("+jys.split(",")[1]+",0)+IFNULL("+fxqs.split(",")[1]+",0))>0,1,0)) AS DECIMAL(18,0))," +
				"CAST(sum(clrmb)/sum(sxrmb) AS DECIMAL(18,0))," +
				"CAST(sum(clwh)/sum(sxwh) AS DECIMAL(18,0))," +
				"CAST(sum(cljh)/sum(sxjh) AS DECIMAL(18,0))," +
				"CAST(sum(clsh)/sum(sxsh) AS DECIMAL(18,0))," +
				"CAST(sum(cljy)/sum(sxjy) AS DECIMAL(18,0))," +
				"CAST(sum(clfxq)/sum(sxfxq) AS DECIMAL(18,0))," +
				"0.0,0.0,0.0,0.0,0.0,0.0,0.0," +
				"CAST(sum(IFNULL("+rmbs.split(",")[2]+",0)+IFNULL("+whs.split(",")[2]+",0)+IFNULL("+jhs.split(",")[2]+",0)+IFNULL("+shs.split(",")[2]+",0)+IFNULL("+jys.split(",")[2]+",0))/sum(IFNULL("+rmbs.split(",")[3]+",0)+IFNULL("+whs.split(",")[3]+",0)+IFNULL("+jhs.split(",")[3]+",0)+IFNULL("+shs.split(",")[3]+",0)+IFNULL("+jys.split(",")[3]+",0)) AS DECIMAL(18,4))," +
				"CAST(sum(cclrmb_fz)/sum(cclrmb_fm) AS DECIMAL(18,4))," +
				"CAST(sum(cclwh_fz)/sum(cclwh_fm) AS DECIMAL(18,4))," +
				"CAST(sum(ccljy_fz)/sum(ccljy_fm) AS DECIMAL(18,4))," +
				"CAST(sum(IFNULL("+rmbs.split(",")[4]+",0)+IFNULL("+whs.split(",")[4]+",0)+IFNULL("+jhs.split(",")[4]+",0)+IFNULL("+shs.split(",")[4]+",0)+IFNULL("+jys.split(",")[4]+",0))/sum(IFNULL("+rmbs.split(",")[5]+",0)+IFNULL("+whs.split(",")[5]+",0)+IFNULL("+jhs.split(",")[5]+",0)+IFNULL("+shs.split(",")[5]+",0)+IFNULL("+jys.split(",")[5]+",0)) AS DECIMAL(18,2))," +
				"CAST(sum(xlrmb_fz)/sum(xlrmb_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlwh_fz)/sum(xlwh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xljh_fz)/sum(xljh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlsh_fz)/sum(xlsh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xljy_fz)/sum(xljy_fm) AS DECIMAL(18,2)),0.0,0.0,0.0,0.0,0.0,0.0," +
				"'0','0','0' from t_hn_new where date='"+idate+"' and zx=0 and xz!=3 and pos like '__"+i+"__' and mid(pos,5,1) in ('1','2','3','4','5','6','7','8','9','A','B')";
				session.createSQLQuery(sql).executeUpdate();
				
				sql = "insert into t_hn_team_t(time,chu,team,cl,clrmb,clwh,cljh," +
				"clsh,cljy,clfxq,rjcl,rjclrmb,rjclwh,rjcljh,rjclsh,rjcljy,rjclfxq," +
				"ccl,cclrmb,cclwh,ccljy,xl,xlrmb,xlwh,xljh,xlsh,xljy,perccl891," +
				"pertpl891,percxl891,perccl895,pertpl895," +
				"percxl895,remark1,remark2,remark3) select '"+idate+"','"+i+"'," +
				"mid(pos,5,1),CAST(sum(IFNULL("+rmbs.split(",")[0]+",0)+IFNULL("+whs.split(",")[0]+",0)+IFNULL("+jhs.split(",")[0]+",0)+IFNULL("+shs.split(",")[0]+",0)+IFNULL("+jys.split(",")[0]+",0)+IFNULL("+fxqs.split(",")[0]+",0))/sum(if((IFNULL("+rmbs.split(",")[1]+",0)+IFNULL("+whs.split(",")[1]+",0)+IFNULL("+jhs.split(",")[1]+",0)+IFNULL("+shs.split(",")[1]+",0)+IFNULL("+jys.split(",")[1]+",0)+IFNULL("+fxqs.split(",")[1]+",0))>0,1,0)) AS DECIMAL(18,0))," +
				"CAST(sum(clrmb)/sum(sxrmb) AS DECIMAL(18,0))," +
				"CAST(sum(clwh)/sum(sxwh) AS DECIMAL(18,0))," +
				"CAST(sum(cljh)/sum(sxjh) AS DECIMAL(18,0))," +
				"CAST(sum(clsh)/sum(sxsh) AS DECIMAL(18,0))," +
				"CAST(sum(cljy)/sum(sxjy) AS DECIMAL(18,0))," +
				"CAST(sum(clfxq)/sum(sxfxq) AS DECIMAL(18,0))," +
				"0.0,0.0,0.0,0.0,0.0,0.0,0.0," +
				"CAST(sum(IFNULL("+rmbs.split(",")[2]+",0)+IFNULL("+whs.split(",")[2]+",0)+IFNULL("+jhs.split(",")[2]+",0)+IFNULL("+shs.split(",")[2]+",0)+IFNULL("+jys.split(",")[2]+",0))/sum(IFNULL("+rmbs.split(",")[3]+",0)+IFNULL("+whs.split(",")[3]+",0)+IFNULL("+jhs.split(",")[3]+",0)+IFNULL("+shs.split(",")[3]+",0)+IFNULL("+jys.split(",")[3]+",0)) AS DECIMAL(18,4))," +
				"CAST(sum(cclrmb_fz)/sum(cclrmb_fm) AS DECIMAL(18,4))," +
				"CAST(sum(cclwh_fz)/sum(cclwh_fm) AS DECIMAL(18,4))," +
				"CAST(sum(ccljy_fz)/sum(ccljy_fm) AS DECIMAL(18,4))," +
				"CAST(sum(IFNULL("+rmbs.split(",")[4]+",0)+IFNULL("+whs.split(",")[4]+",0)+IFNULL("+jhs.split(",")[4]+",0)+IFNULL("+shs.split(",")[4]+",0)+IFNULL("+jys.split(",")[4]+",0))/sum(IFNULL("+rmbs.split(",")[5]+",0)+IFNULL("+whs.split(",")[5]+",0)+IFNULL("+jhs.split(",")[5]+",0)+IFNULL("+shs.split(",")[5]+",0)+IFNULL("+jys.split(",")[5]+",0)) AS DECIMAL(18,2))," +
				"CAST(sum(xlrmb_fz)/sum(xlrmb_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlwh_fz)/sum(xlwh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xljh_fz)/sum(xljh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xlsh_fz)/sum(xlsh_fm) AS DECIMAL(18,2))," +
				"CAST(sum(xljy_fz)/sum(xljy_fm) AS DECIMAL(18,2)),0.0,0.0,0.0,0.0,0.0,0.0," +
				"'0','0','0' from t_hn_new where date='"+idate+"' and zx=0 and xz!=3 and pos like '__"+i+"__' and mid(pos,5,1) in ('1','2','3','4','5','6','7','8','9','A','B') group by mid(pos,5,1)";
				session.createSQLQuery(sql).executeUpdate();
					
				sql = "insert into t_hn_team_temp(time,chu,team,rjcl," +
				"rjclrmb,rjclwh,rjcljh,rjclsh,rjcljy,rjclfxq) select '"+idate+"','"+i+"'," +
				"'0',CAST(sum(IFNULL("+rmbs.split(",")[0]+",0)+IFNULL("+whs.split(",")[0]+",0)+IFNULL("+jhs.split(",")[0]+",0)+IFNULL("+shs.split(",")[0]+",0)+IFNULL("+jys.split(",")[0]+",0)+IFNULL("+fxqs.split(",")[0]+",0))/sum(if((IFNULL("+rmbs.split(",")[1]+",0)+IFNULL("+whs.split(",")[1]+",0)+IFNULL("+jhs.split(",")[1]+",0)+IFNULL("+shs.split(",")[1]+",0)+IFNULL("+jys.split(",")[1]+",0)+IFNULL("+fxqs.split(",")[1]+",0))>0,1,0)) AS DECIMAL(18,0))," +
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
				"mid(pos,5,1),CAST(sum(IFNULL("+rmbs.split(",")[0]+",0)+IFNULL("+whs.split(",")[0]+",0)+IFNULL("+jhs.split(",")[0]+",0)+IFNULL("+shs.split(",")[0]+",0)+IFNULL("+jys.split(",")[0]+",0)+IFNULL("+fxqs.split(",")[0]+",0))/sum(if((IFNULL("+rmbs.split(",")[1]+",0)+IFNULL("+whs.split(",")[1]+",0)+IFNULL("+jhs.split(",")[1]+",0)+IFNULL("+shs.split(",")[1]+",0)+IFNULL("+jys.split(",")[1]+",0)+IFNULL("+fxqs.split(",")[1]+",0))>0,1,0)) AS DECIMAL(18,0))," +
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
		sql = "update t_hn_team_t a,t_hn_team_temp b set a.rjcl=b.rjcl," +
				"a.rjclrmb=b.rjclrmb,a.rjclwh=b.rjclwh,a.rjcljh=b.rjcljh," +
				"a.rjclsh=b.rjclsh,a.rjcljy=b.rjcljy,a.rjclfxq=b.rjclfxq " +
				"where a.time=b.time and a.chu=b.chu and a.team=b.team";
		session.createSQLQuery(sql).executeUpdate();

		sql = "update t_hn_team_t set rjcl=IFNULL(rjcl,0),rjclrmb=IFNULL(rjclrmb,0)," +
		"rjclwh=IFNULL(rjclwh,0),rjcljh=IFNULL(rjcljh,0),rjclsh=IFNULL(rjclsh,0)," +
		"rjcljy=IFNULL(rjcljy,0),rjclfxq=IFNULL(rjclfxq,0),cl=IFNULL(cl,0)," +
		"clrmb=IFNULL(clrmb,0),clwh=IFNULL(clwh,0),cljh=IFNULL(cljh,0),clsh=IFNULL(clsh,0)," +
		"cljy=IFNULL(cljy,0),ccl=IFNULL(ccl,0),cclrmb=IFNULL(cclrmb,0),cclwh=IFNULL(cclwh,0)," +
		"ccljy=IFNULL(ccljy,0),xl=IFNULL(xl,0),xlrmb=IFNULL(xlrmb,0),xlwh=IFNULL(xlwh,0)," +
		"xljh=IFNULL(xljh,0),xlsh=IFNULL(xlsh,0),xljy=IFNULL(xljy,0)";
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
}