package work.hndetail.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hndetail.pojo.HnDetail;

/**
 	* A data access object (DAO) providing persistence and search support for HnDetail entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnDetail
  * @author MyEclipse Persistence Tools 
 */

public class HnDetailDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnDetailDAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String NO = "no";
	public static final String NAME = "name";
	public static final String ZX = "zx";
	public static final String XZ = "xz";
	public static final String TEAM = "team";
	public static final String LRXG = "lrxg";
	public static final String XL_LRXG = "xlLrxg";
	public static final String LJLRSC = "ljlrsc";
	public static final String LRSQ = "lrsq";
	public static final String XL_LRSQ = "xlLrsq";
	public static final String JHXG = "jhxg";
	public static final String XL_JHXG = "xlJhxg";
	public static final String JHSQ = "jhsq";
	public static final String XL_JHSQ = "xlJhsq";
	public static final String LJLR = "ljlr";
	public static final String LJJH = "ljjh";
	public static final String LJLR895 = "ljlr895";
	public static final String LJJH895 = "ljjh895";
	public static final String TP = "tp";
	public static final String LJTP = "ljtp";
	public static final String LRCC = "lrcc";
	public static final String JHCC = "jhcc";
	public static final String CX = "cx";
	public static final String LJCX = "ljcx";
	public static final String OUTPUT891 = "output891";
	public static final String OUTPUT895 = "output895";
	public static final String OUTPUT = "output";
	public static final String CCL891 = "ccl891";
	public static final String CXL891 = "cxl891";
	public static final String TPL891 = "tpl891";
	public static final String CCL895 = "ccl895";
	public static final String CXL895 = "cxl895";
	public static final String TPL895 = "tpl895";
	public static final String LJCL = "ljcl";
	public static final String LJYWL891 = "ljywl891";
	public static final String LJYWL895 = "ljywl895";
	public static final String LJRJCL = "ljrjcl";
	public static final String RJCLWCL = "rjclwcl";
	public static final String LJLRCC = "ljlrcc";
	public static final String LJJHCC = "ljjhcc";
	public static final String RJCCL891 = "rjccl891";
	public static final String RJCXL891 = "rjcxl891";
	public static final String RJTPL891 = "rjtpl891";
	public static final String RJCCL895 = "rjccl895";
	public static final String RJCXL895 = "rjcxl895";
	public static final String RJTPL895 = "rjtpl895";
	public static final String LJSXTS = "ljsxts";
	public static final String ONLINE = "online";
	public static final String ZYZL = "zyzl";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String REMARK4 = "remark4";
	public static final String REMARK5 = "remark5";
	public static final String QDLR = "qdlr";
	public static final String QDLRZ = "qdlrz";
	public static final String LJQDLR = "ljqdlr";
	public static final String LJQDLRZ = "ljqdlrz";
	public static final String QDLRZL = "qdlrzl";
	public static final String LJQDLRZL = "ljqdlrzl";
	public static final String PERCLTIME = "percltime";
	public static final String ZYCCL = "zyccl";



    
    public void save(HnDetail transientInstance) {
        log.debug("saving HnDetail instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnDetail persistentInstance) {
        log.debug("deleting HnDetail instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnDetail findById( java.lang.Integer id) {
        log.debug("getting HnDetail instance with id: " + id);
        try {
            HnDetail instance = (HnDetail) getSession()
                    .get("HnDetail", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnDetail instance) {
        log.debug("finding HnDetail instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnDetail")
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
      log.debug("finding HnDetail instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnDetail as model where model." 
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
	
	public List findByNo(Object no
	) {
		return findByProperty(NO, no
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByZx(Object zx
	) {
		return findByProperty(ZX, zx
		);
	}
	
	public List findByXz(Object xz
	) {
		return findByProperty(XZ, xz
		);
	}
	
	public List findByTeam(Object team
	) {
		return findByProperty(TEAM, team
		);
	}
	
	public List findByLrxg(Object lrxg
	) {
		return findByProperty(LRXG, lrxg
		);
	}
	
	public List findByXlLrxg(Object xlLrxg
	) {
		return findByProperty(XL_LRXG, xlLrxg
		);
	}
	
	public List findByLjlrsc(Object ljlrsc
	) {
		return findByProperty(LJLRSC, ljlrsc
		);
	}
	
	public List findByLrsq(Object lrsq
	) {
		return findByProperty(LRSQ, lrsq
		);
	}
	
	public List findByXlLrsq(Object xlLrsq
	) {
		return findByProperty(XL_LRSQ, xlLrsq
		);
	}
	
	public List findByJhxg(Object jhxg
	) {
		return findByProperty(JHXG, jhxg
		);
	}
	
	public List findByXlJhxg(Object xlJhxg
	) {
		return findByProperty(XL_JHXG, xlJhxg
		);
	}
	
	public List findByJhsq(Object jhsq
	) {
		return findByProperty(JHSQ, jhsq
		);
	}
	
	public List findByXlJhsq(Object xlJhsq
	) {
		return findByProperty(XL_JHSQ, xlJhsq
		);
	}
	
	public List findByLjlr(Object ljlr
	) {
		return findByProperty(LJLR, ljlr
		);
	}
	
	public List findByLjjh(Object ljjh
	) {
		return findByProperty(LJJH, ljjh
		);
	}
	
	public List findByLjlr895(Object ljlr895
	) {
		return findByProperty(LJLR895, ljlr895
		);
	}
	
	public List findByLjjh895(Object ljjh895
	) {
		return findByProperty(LJJH895, ljjh895
		);
	}
	
	public List findByTp(Object tp
	) {
		return findByProperty(TP, tp
		);
	}
	
	public List findByLjtp(Object ljtp
	) {
		return findByProperty(LJTP, ljtp
		);
	}
	
	public List findByLrcc(Object lrcc
	) {
		return findByProperty(LRCC, lrcc
		);
	}
	
	public List findByJhcc(Object jhcc
	) {
		return findByProperty(JHCC, jhcc
		);
	}
	
	public List findByCx(Object cx
	) {
		return findByProperty(CX, cx
		);
	}
	
	public List findByLjcx(Object ljcx
	) {
		return findByProperty(LJCX, ljcx
		);
	}
	
	public List findByOutput891(Object output891
	) {
		return findByProperty(OUTPUT891, output891
		);
	}
	
	public List findByOutput895(Object output895
	) {
		return findByProperty(OUTPUT895, output895
		);
	}
	
	public List findByOutput(Object output
	) {
		return findByProperty(OUTPUT, output
		);
	}
	
	public List findByCcl891(Object ccl891
	) {
		return findByProperty(CCL891, ccl891
		);
	}
	
	public List findByCxl891(Object cxl891
	) {
		return findByProperty(CXL891, cxl891
		);
	}
	
	public List findByTpl891(Object tpl891
	) {
		return findByProperty(TPL891, tpl891
		);
	}
	
	public List findByCcl895(Object ccl895
	) {
		return findByProperty(CCL895, ccl895
		);
	}
	
	public List findByCxl895(Object cxl895
	) {
		return findByProperty(CXL895, cxl895
		);
	}
	
	public List findByTpl895(Object tpl895
	) {
		return findByProperty(TPL895, tpl895
		);
	}
	
	public List findByLjcl(Object ljcl
	) {
		return findByProperty(LJCL, ljcl
		);
	}
	
	public List findByLjywl891(Object ljywl891
	) {
		return findByProperty(LJYWL891, ljywl891
		);
	}
	
	public List findByLjywl895(Object ljywl895
	) {
		return findByProperty(LJYWL895, ljywl895
		);
	}
	
	public List findByLjrjcl(Object ljrjcl
	) {
		return findByProperty(LJRJCL, ljrjcl
		);
	}
	
	public List findByRjclwcl(Object rjclwcl
	) {
		return findByProperty(RJCLWCL, rjclwcl
		);
	}
	
	public List findByLjlrcc(Object ljlrcc
	) {
		return findByProperty(LJLRCC, ljlrcc
		);
	}
	
	public List findByLjjhcc(Object ljjhcc
	) {
		return findByProperty(LJJHCC, ljjhcc
		);
	}
	
	public List findByRjccl891(Object rjccl891
	) {
		return findByProperty(RJCCL891, rjccl891
		);
	}
	
	public List findByRjcxl891(Object rjcxl891
	) {
		return findByProperty(RJCXL891, rjcxl891
		);
	}
	
	public List findByRjtpl891(Object rjtpl891
	) {
		return findByProperty(RJTPL891, rjtpl891
		);
	}
	
	public List findByRjccl895(Object rjccl895
	) {
		return findByProperty(RJCCL895, rjccl895
		);
	}
	
	public List findByRjcxl895(Object rjcxl895
	) {
		return findByProperty(RJCXL895, rjcxl895
		);
	}
	
	public List findByRjtpl895(Object rjtpl895
	) {
		return findByProperty(RJTPL895, rjtpl895
		);
	}
	
	public List findByLjsxts(Object ljsxts
	) {
		return findByProperty(LJSXTS, ljsxts
		);
	}
	
	public List findByOnline(Object online
	) {
		return findByProperty(ONLINE, online
		);
	}
	
	public List findByZyzl(Object zyzl
	) {
		return findByProperty(ZYZL, zyzl
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
	
	public List findByRemark4(Object remark4
	) {
		return findByProperty(REMARK4, remark4
		);
	}
	
	public List findByRemark5(Object remark5
	) {
		return findByProperty(REMARK5, remark5
		);
	}
	
	public List findByQdlr(Object qdlr
	) {
		return findByProperty(QDLR, qdlr
		);
	}
	
	public List findByQdlrz(Object qdlrz
	) {
		return findByProperty(QDLRZ, qdlrz
		);
	}
	
	public List findByLjqdlr(Object ljqdlr
	) {
		return findByProperty(LJQDLR, ljqdlr
		);
	}
	
	public List findByLjqdlrz(Object ljqdlrz
	) {
		return findByProperty(LJQDLRZ, ljqdlrz
		);
	}
	
	public List findByQdlrzl(Object qdlrzl
	) {
		return findByProperty(QDLRZL, qdlrzl
		);
	}
	
	public List findByLjqdlrzl(Object ljqdlrzl
	) {
		return findByProperty(LJQDLRZL, ljqdlrzl
		);
	}
	
	public List findByPercltime(Object percltime
	) {
		return findByProperty(PERCLTIME, percltime
		);
	}
	
	public List findByZyccl(Object zyccl
	) {
		return findByProperty(ZYCCL, zyccl
		);
	}
	

	public List findAll() {
		log.debug("finding all HnDetail instances");
		try {
			String queryString = "from HnDetail";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnDetail merge(HnDetail detachedInstance) {
        log.debug("merging HnDetail instance");
        try {
            HnDetail result = (HnDetail) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnDetail instance) {
        log.debug("attaching dirty HnDetail instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnDetail instance) {
        log.debug("attaching clean HnDetail instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public String updateWclByMonth(Session session,Double hncl,String month)
    {
    	log.debug("update rjwcl By Month");
    	String bdate = month + "01";
    	String edate = month + "31";
    	String sql = "update t_hn_detail set rjclwcl=CAST(ljrjcl/"+hncl+" AS DECIMAL(18,4)) where time>='"+bdate+"' and time<='"+edate+"'";
    	session.createSQLQuery(sql).executeUpdate();
    	return "success";
    }

    public List<HnDetail> findByTeamAndDate(String bdate,String idate,int team)
    {
    	log.debug("finding all Team instances");
    	try {
    		 String queryString = "from HnDetail as h where h.time>=:b and h.time<=:d and h.team=:t";//不论上不上线?
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("b",bdate);
             queryObject.setString("d",idate);
             queryObject.setInteger("t",team);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List<HnDetail> findByTeamAndDateAndZxAndXz(String bdate,String idate,int team)
    {
    	log.debug("finding all Team instances");
    	try {
    		 String queryString = "from HnDetail as h where h.time>=:b and h.time<=:d and h.team=:t and Zx=0 and Xz=0";//不论上不上线?
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("b",bdate);
             queryObject.setString("d",idate);
             queryObject.setInteger("t",team);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public HnDetail findByDateAndNo(String date,String no)
    {
    	log.info("find Hn891 by date and no desc");
    	try {
    		Query query;
    		String hql="from HnDetail as h where h.no=:n and h.time=:d";
    		query=getSession().createQuery(hql);
    		query.setString("n",no);
    		query.setString("d",date);
    		if(query.list().isEmpty())
    		{
    			return null;
    		}
    		else
    		return (HnDetail)query.list().get(0);
    	}catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }


    public List<HnDetail> findByFinalDateDesc(String no,String begindate,String enddate)
    {
    	log.info("find Hn891 by date desc");
    	try {
    		Query query;
    		String hql="from HnDetail as h where h.no=:n and h.time>=:bd and h.time<=:ed order by h.time desc";
    		query=getSession().createQuery(hql);
    		query.setString("n",no);
    		query.setString("bd",begindate);
    		query.setString("ed",enddate);
    		List l = query.list();
    		return l;
    	}catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    public List<HnDetail> findBykey(String time,int xz,int zx,int team,String key,int sequence)
    {
    	log.info("find Hn891 by date desc");
    	try {
    		Query query;
    		String hql = "from HnDetail as h where h.ljsxts>0 and h.time='"+time+"'";
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
    		hql = hql+" order by h.zyzl desc , h."+key;
    		if(sequence==1)
    		{
    			hql = hql+" desc";
    		}
    		hql = hql+" , h.output desc";
    		//String sqltemp = "from HnDetail as h where h.time='20150103' order by h.ljrjcl desc";
    		//hql="from HnDetail as h where h.time=:d and h.xz=:x and h.zx=:z and h.team=:t order by h.ljrjcl desc";
    		System.out.println(hql);
    		query=getSession().createQuery(hql);
    		List l = query.list();
    		return l;
    	}catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    public List<HnDetail> findBykey(String key)
    {
    	log.info("find Hn891 by date desc");
    	try {
    		Query query;
    		key = "ljrjcl";
    		String hql="from HnDetail as h where h.time=:d order by h."+key+" desc";
    		query=getSession().createQuery(hql);
    		query.setString("d","20150103");
    		//query.setString("ed",enddate);
    		List l = query.list();
    		return l;
    	}catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    public String findFinalDesc() {
    		log.debug("finding all HnDetail instances");
    		try {
    			String queryString = "select max(time) from t_hn_detail";
    	         String maxdate = getSession().createSQLQuery(queryString).uniqueResult().toString();
    	         if(maxdate!=null&&maxdate.length()==8)
    	         {
    	        	 return maxdate;
    	         }
    	         else
    	         {
    	        	 return "null";
    	         }
    			
    		} catch (RuntimeException re) {
    			log.error("find all failed", re);
    			throw re;
    		}
    	}
}