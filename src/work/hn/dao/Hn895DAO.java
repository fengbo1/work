package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.Hn895;

/**
 	* A data access object (DAO) providing persistence and search support for Hn895 entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Hn895
  * @author MyEclipse Persistence Tools 
 */

public class Hn895DAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(Hn895DAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String NO = "no";
	public static final String NAME = "name";
	public static final String BMSB = "bmsb";
	public static final String XL_BMSB = "xlBmsb";
	public static final String YXCF = "yxcf";
	public static final String XL_YXCF = "xlYxcf";
	public static final String LRXG = "lrxg";
	public static final String XL_LRXG = "xlLrxg";
	public static final String LRSQ = "lrsq";
	public static final String XL_LRSQ = "xlLrsq";
	public static final String JHXG = "jhxg";
	public static final String XL_JHXG = "xlJhxg";
	public static final String JHSQ = "jhsq";
	public static final String XL_JHSQ = "xlJhsq";
	public static final String SBYY = "sbyy";
	public static final String XL_SBYY = "xlSbyy";
	public static final String CSLR = "cslr";
	public static final String XL_CSLR = "xlCslr";
	public static final String ZYFS = "zyfs";
	public static final String XL_ZYFS = "xlZyfs";
	public static final String SHSH = "shsh";
	public static final String XL_SHSH = "xlShsh";
	public static final String SHSB = "shsb";
	public static final String XL_SHSB = "xlShsb";
	public static final String RLCS = "rlcs";
	public static final String XL_RLCS = "xlRlcs";
	public static final String RLFS = "rlfs";
	public static final String XL_RLFS = "xlRlfs";
	public static final String RLSB = "rlsb";
	public static final String XL_RLSB = "xlRlsb";
	public static final String KDFH = "kdfh";
	public static final String XL_KDFH = "xlKdfh";
	public static final String FYHD = "fyhd";
	public static final String XL_FYHD = "xlFyhd";
	public static final String LRCC = "lrcc";
	public static final String JHCC = "jhcc";
	public static final String LRCCL = "lrccl";
	public static final String JHCCL = "jhccl";
	public static final String LRTP = "lrtp";
	public static final String LRTPL = "lrtpl";
	public static final String CCL = "ccl";
	public static final String CX = "cx";
	public static final String CXL = "cxl";
	public static final String ZHCL = "zhcl";
	public static final String YWL = "ywl";
	public static final String SUMXL = "sumxl";
	public static final String ZX = "zx";
	public static final String XZ = "xz";



    
    public void save(Hn895 transientInstance) {
        log.debug("saving Hn895 instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Hn895 persistentInstance) {
        log.debug("deleting Hn895 instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Hn895 findById( java.lang.Integer id) {
        log.debug("getting Hn895 instance with id: " + id);
        try {
            Hn895 instance = (Hn895) getSession()
                    .get("Hn895", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Hn895 instance) {
        log.debug("finding Hn895 instance by example");
        try {
            List results = getSession()
                    .createCriteria("Hn895")
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
      log.debug("finding Hn895 instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Hn895 as model where model." 
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
	
	public List findByBmsb(Object bmsb
	) {
		return findByProperty(BMSB, bmsb
		);
	}
	
	public List findByXlBmsb(Object xlBmsb
	) {
		return findByProperty(XL_BMSB, xlBmsb
		);
	}
	
	public List findByYxcf(Object yxcf
	) {
		return findByProperty(YXCF, yxcf
		);
	}
	
	public List findByXlYxcf(Object xlYxcf
	) {
		return findByProperty(XL_YXCF, xlYxcf
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
	
	public List findBySbyy(Object sbyy
	) {
		return findByProperty(SBYY, sbyy
		);
	}
	
	public List findByXlSbyy(Object xlSbyy
	) {
		return findByProperty(XL_SBYY, xlSbyy
		);
	}
	
	public List findByCslr(Object cslr
	) {
		return findByProperty(CSLR, cslr
		);
	}
	
	public List findByXlCslr(Object xlCslr
	) {
		return findByProperty(XL_CSLR, xlCslr
		);
	}
	
	public List findByZyfs(Object zyfs
	) {
		return findByProperty(ZYFS, zyfs
		);
	}
	
	public List findByXlZyfs(Object xlZyfs
	) {
		return findByProperty(XL_ZYFS, xlZyfs
		);
	}
	
	public List findByShsh(Object shsh
	) {
		return findByProperty(SHSH, shsh
		);
	}
	
	public List findByXlShsh(Object xlShsh
	) {
		return findByProperty(XL_SHSH, xlShsh
		);
	}
	
	public List findByShsb(Object shsb
	) {
		return findByProperty(SHSB, shsb
		);
	}
	
	public List findByXlShsb(Object xlShsb
	) {
		return findByProperty(XL_SHSB, xlShsb
		);
	}
	
	public List findByRlcs(Object rlcs
	) {
		return findByProperty(RLCS, rlcs
		);
	}
	
	public List findByXlRlcs(Object xlRlcs
	) {
		return findByProperty(XL_RLCS, xlRlcs
		);
	}
	
	public List findByRlfs(Object rlfs
	) {
		return findByProperty(RLFS, rlfs
		);
	}
	
	public List findByXlRlfs(Object xlRlfs
	) {
		return findByProperty(XL_RLFS, xlRlfs
		);
	}
	
	public List findByRlsb(Object rlsb
	) {
		return findByProperty(RLSB, rlsb
		);
	}
	
	public List findByXlRlsb(Object xlRlsb
	) {
		return findByProperty(XL_RLSB, xlRlsb
		);
	}
	
	public List findByKdfh(Object kdfh
	) {
		return findByProperty(KDFH, kdfh
		);
	}
	
	public List findByXlKdfh(Object xlKdfh
	) {
		return findByProperty(XL_KDFH, xlKdfh
		);
	}
	
	public List findByFyhd(Object fyhd
	) {
		return findByProperty(FYHD, fyhd
		);
	}
	
	public List findByXlFyhd(Object xlFyhd
	) {
		return findByProperty(XL_FYHD, xlFyhd
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
	
	public List findByLrccl(Object lrccl
	) {
		return findByProperty(LRCCL, lrccl
		);
	}
	
	public List findByJhccl(Object jhccl
	) {
		return findByProperty(JHCCL, jhccl
		);
	}
	
	public List findByLrtp(Object lrtp
	) {
		return findByProperty(LRTP, lrtp
		);
	}
	
	public List findByLrtpl(Object lrtpl
	) {
		return findByProperty(LRTPL, lrtpl
		);
	}
	
	public List findByCcl(Object ccl
	) {
		return findByProperty(CCL, ccl
		);
	}
	
	public List findByCx(Object cx
	) {
		return findByProperty(CX, cx
		);
	}
	
	public List findByCxl(Object cxl
	) {
		return findByProperty(CXL, cxl
		);
	}
	
	public List findByZhcl(Object zhcl
	) {
		return findByProperty(ZHCL, zhcl
		);
	}
	
	public List findByYwl(Object ywl
	) {
		return findByProperty(YWL, ywl
		);
	}
	
	public List findBySumxl(Object sumxl
	) {
		return findByProperty(SUMXL, sumxl
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
	

	public List findAll() {
		log.debug("finding all Hn895 instances");
		try {
			String queryString = "from Hn895";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Hn895 merge(Hn895 detachedInstance) {
        log.debug("merging Hn895 instance");
        try {
            Hn895 result = (Hn895) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Hn895 instance) {
        log.debug("attaching dirty Hn895 instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Hn895 instance) {
        log.debug("attaching clean Hn895 instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List<Hn895> findBykey(String time,int xz,int zx,String key,int sequence)
    {
    	log.info("find Hn895 by date desc");
    	try {
    		Query query;
    		String hql = "from Hn895 as h where h.time='"+time+"'";
    		if(xz!=9)
    		{
    			if(xz==5)
    			{
    				hql = hql+" and h.xz in (0,1,2,4)";
    			}
    			else
    			{
    				hql = hql+" and h.xz="+xz;
    			}	
    		}
    		if(zx!=2)
    		{
    			if(zx==3)
    			{
    				hql = hql+" and h.zx in (0,1)";
    			}
    			else
    			{
    				hql = hql+" and h.zx="+zx;
    			}
    		}
    		hql = hql+" order by h."+key;
    		if(sequence==1)
    		{
    			hql = hql+" desc";
    		}
    		System.out.println(hql);
    		query=getSession().createQuery(hql);
    		List l = query.list();
    		return l;
    	}catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
//    public List findByDate(String date)
//    {
//    	log.info("find Hn895 by date");
//    	try {
//    		Session session=HibernateSessionFactory.getSession();
//    		Transaction trans=session.beginTransaction();
//    		Query query;
//    		String hql="from Hn895 as h where h.time=:t";
//    		query=session.createQuery(hql);
//    		query.setString("t",date);
//    		List l = query.list();
//    		trans.commit();
//    		session.flush();
//    		session.close();
//    		return l;
//    		
//    	}catch (RuntimeException re) {
//            log.error("find by example failed", re);
//            throw re;
//        }
//    }
    public Hn895 findByDateAndNo(String date,String no)
    {
    	log.info("find Hn895 by date");
    	try {
    		Query query;
    		String hql="from Hn895 as h where h.time='"+date+"' and h.no='"+no+"'";
    		query=getSession().createQuery(hql);
    		List l = query.list();
    		if(l.isEmpty())
    		{
    			Hn895 h = new Hn895();
    			return h;
    		}
    		else
    		{
    			return (Hn895) l.get(0);
    		}
    		
    	}catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
    /**
     * 根据传入的工号，起始和截止日期以日期倒叙返回期间的数据
     * @param no
     * @param begindate
     * @param enddate
     * @return
     */
    public List<Hn895> findByDateDesc(String no,String begindate,String enddate)
    {
    	
    	log.info("find Hn895 by date desc");
    	try {
    		Query query;
    		String hql="from Hn895 as h where h.no=:n and h.time>=:bd and h.time<=:ed order by h.time desc";
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
}