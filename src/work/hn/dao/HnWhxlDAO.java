package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.HnWhxl;

/**
 	* A data access object (DAO) providing persistence and search support for HnWhxl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnWhxl
  * @author MyEclipse Persistence Tools 
 */

public class HnWhxlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnWhxlDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NAME = "name";
	public static final String NO = "no";
	public static final String PCT = "pct";
	public static final String PCTRMB = "pctrmb";
	public static final String BMSB891 = "bmsb891";
	public static final String YXCF891 = "yxcf891";
	public static final String LRXG891 = "lrxg891";
	public static final String LRSQ891 = "lrsq891";
	public static final String JHXG891 = "jhxg891";
	public static final String JHSQ891 = "jhsq891";
	public static final String SBYY891 = "sbyy891";
	public static final String YXBZ891 = "yxbz891";
	public static final String CSLR891 = "cslr891";
	public static final String ZYFS891 = "zyfs891";
	public static final String BMSB895 = "bmsb895";
	public static final String YXCF895 = "yxcf895";
	public static final String LRXG895 = "lrxg895";
	public static final String LRSQ895 = "lrsq895";
	public static final String JHXG895 = "jhxg895";
	public static final String JHSQ895 = "jhsq895";
	public static final String SBYY895 = "sbyy895";
	public static final String CSLR895 = "cslr895";
	public static final String ZYFS895 = "zyfs895";
	public static final String PJSH895 = "pjsh895";
	public static final String RLCS895 = "rlcs895";
	public static final String RLFS895 = "rlfs895";
	public static final String RLSB895 = "rlsb895";
	public static final String PCTWH = "pctwh";
	public static final String ZYCSWH = "zycswh";
	public static final String ZYFSWH = "zyfswh";
	public static final String LRXGWH = "lrxgwh";
	public static final String LRSQWH = "lrsqwh";
	public static final String JHXGWH = "jhxgwh";
	public static final String JHSQWH = "jhsqwh";
	public static final String PJCSWH = "pjcswh";
	public static final String PJFSWH = "pjfswh";
	public static final String SBYYWH = "sbyywh";
	public static final String DGHCCSWH = "dghccswh";
	public static final String DGHCFSWH = "dghcfswh";
	public static final String DGHRCSWH = "dghrcswh";
	public static final String DGHRFSWH = "dghrfswh";
	public static final String PCTJY = "pctjy";
	public static final String PJCSJY = "pjcsjy";
	public static final String PJFSJY = "pjfsjy";
	public static final String LRXGJY = "lrxgjy";
	public static final String LRSQJY = "lrsqjy";
	public static final String JHXGJY = "jhxgjy";
	public static final String JHSQJY = "jhsqjy";
	public static final String SBYYJY = "sbyyjy";
	public static final String CSLRJY = "cslrjy";
	public static final String ZYFSJY = "zyfsjy";



    
    public void save(HnWhxl transientInstance) {
        log.debug("saving HnWhxl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnWhxl persistentInstance) {
        log.debug("deleting HnWhxl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnWhxl findById( java.lang.Integer id) {
        log.debug("getting HnWhxl instance with id: " + id);
        try {
            HnWhxl instance = (HnWhxl) getSession()
                    .get("HnWhxl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnWhxl instance) {
        log.debug("finding HnWhxl instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnWhxl")
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
      log.debug("finding HnWhxl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnWhxl as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNo(Object no
	) {
		return findByProperty(NO, no
		);
	}
	
	public List findByPct(Object pct
	) {
		return findByProperty(PCT, pct
		);
	}
	
	public List findByPctrmb(Object pctrmb
	) {
		return findByProperty(PCTRMB, pctrmb
		);
	}
	
	public List findByBmsb891(Object bmsb891
	) {
		return findByProperty(BMSB891, bmsb891
		);
	}
	
	public List findByYxcf891(Object yxcf891
	) {
		return findByProperty(YXCF891, yxcf891
		);
	}
	
	public List findByLrxg891(Object lrxg891
	) {
		return findByProperty(LRXG891, lrxg891
		);
	}
	
	public List findByLrsq891(Object lrsq891
	) {
		return findByProperty(LRSQ891, lrsq891
		);
	}
	
	public List findByJhxg891(Object jhxg891
	) {
		return findByProperty(JHXG891, jhxg891
		);
	}
	
	public List findByJhsq891(Object jhsq891
	) {
		return findByProperty(JHSQ891, jhsq891
		);
	}
	
	public List findBySbyy891(Object sbyy891
	) {
		return findByProperty(SBYY891, sbyy891
		);
	}
	
	public List findByYxbz891(Object yxbz891
	) {
		return findByProperty(YXBZ891, yxbz891
		);
	}
	
	public List findByCslr891(Object cslr891
	) {
		return findByProperty(CSLR891, cslr891
		);
	}
	
	public List findByZyfs891(Object zyfs891
	) {
		return findByProperty(ZYFS891, zyfs891
		);
	}
	
	public List findByBmsb895(Object bmsb895
	) {
		return findByProperty(BMSB895, bmsb895
		);
	}
	
	public List findByYxcf895(Object yxcf895
	) {
		return findByProperty(YXCF895, yxcf895
		);
	}
	
	public List findByLrxg895(Object lrxg895
	) {
		return findByProperty(LRXG895, lrxg895
		);
	}
	
	public List findByLrsq895(Object lrsq895
	) {
		return findByProperty(LRSQ895, lrsq895
		);
	}
	
	public List findByJhxg895(Object jhxg895
	) {
		return findByProperty(JHXG895, jhxg895
		);
	}
	
	public List findByJhsq895(Object jhsq895
	) {
		return findByProperty(JHSQ895, jhsq895
		);
	}
	
	public List findBySbyy895(Object sbyy895
	) {
		return findByProperty(SBYY895, sbyy895
		);
	}
	
	public List findByCslr895(Object cslr895
	) {
		return findByProperty(CSLR895, cslr895
		);
	}
	
	public List findByZyfs895(Object zyfs895
	) {
		return findByProperty(ZYFS895, zyfs895
		);
	}
	
	public List findByPjsh895(Object pjsh895
	) {
		return findByProperty(PJSH895, pjsh895
		);
	}
	
	public List findByRlcs895(Object rlcs895
	) {
		return findByProperty(RLCS895, rlcs895
		);
	}
	
	public List findByRlfs895(Object rlfs895
	) {
		return findByProperty(RLFS895, rlfs895
		);
	}
	
	public List findByRlsb895(Object rlsb895
	) {
		return findByProperty(RLSB895, rlsb895
		);
	}
	
	public List findByPctwh(Object pctwh
	) {
		return findByProperty(PCTWH, pctwh
		);
	}
	
	public List findByZycswh(Object zycswh
	) {
		return findByProperty(ZYCSWH, zycswh
		);
	}
	
	public List findByZyfswh(Object zyfswh
	) {
		return findByProperty(ZYFSWH, zyfswh
		);
	}
	
	public List findByLrxgwh(Object lrxgwh
	) {
		return findByProperty(LRXGWH, lrxgwh
		);
	}
	
	public List findByLrsqwh(Object lrsqwh
	) {
		return findByProperty(LRSQWH, lrsqwh
		);
	}
	
	public List findByJhxgwh(Object jhxgwh
	) {
		return findByProperty(JHXGWH, jhxgwh
		);
	}
	
	public List findByJhsqwh(Object jhsqwh
	) {
		return findByProperty(JHSQWH, jhsqwh
		);
	}
	
	public List findByPjcswh(Object pjcswh
	) {
		return findByProperty(PJCSWH, pjcswh
		);
	}
	
	public List findByPjfswh(Object pjfswh
	) {
		return findByProperty(PJFSWH, pjfswh
		);
	}
	
	public List findBySbyywh(Object sbyywh
	) {
		return findByProperty(SBYYWH, sbyywh
		);
	}
	
	public List findByDghccswh(Object dghccswh
	) {
		return findByProperty(DGHCCSWH, dghccswh
		);
	}
	
	public List findByDghcfswh(Object dghcfswh
	) {
		return findByProperty(DGHCFSWH, dghcfswh
		);
	}
	
	public List findByDghrcswh(Object dghrcswh
	) {
		return findByProperty(DGHRCSWH, dghrcswh
		);
	}
	
	public List findByDghrfswh(Object dghrfswh
	) {
		return findByProperty(DGHRFSWH, dghrfswh
		);
	}
	
	public List findByPctjy(Object pctjy
	) {
		return findByProperty(PCTJY, pctjy
		);
	}
	
	public List findByPjcsjy(Object pjcsjy
	) {
		return findByProperty(PJCSJY, pjcsjy
		);
	}
	
	public List findByPjfsjy(Object pjfsjy
	) {
		return findByProperty(PJFSJY, pjfsjy
		);
	}
	
	public List findByLrxgjy(Object lrxgjy
	) {
		return findByProperty(LRXGJY, lrxgjy
		);
	}
	
	public List findByLrsqjy(Object lrsqjy
	) {
		return findByProperty(LRSQJY, lrsqjy
		);
	}
	
	public List findByJhxgjy(Object jhxgjy
	) {
		return findByProperty(JHXGJY, jhxgjy
		);
	}
	
	public List findByJhsqjy(Object jhsqjy
	) {
		return findByProperty(JHSQJY, jhsqjy
		);
	}
	
	public List findBySbyyjy(Object sbyyjy
	) {
		return findByProperty(SBYYJY, sbyyjy
		);
	}
	
	public List findByCslrjy(Object cslrjy
	) {
		return findByProperty(CSLRJY, cslrjy
		);
	}
	
	public List findByZyfsjy(Object zyfsjy
	) {
		return findByProperty(ZYFSJY, zyfsjy
		);
	}
	

	public List findAll() {
		log.debug("finding all HnWhxl instances");
		try {
			String queryString = "from HnWhxl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnWhxl merge(HnWhxl detachedInstance) {
        log.debug("merging HnWhxl instance");
        try {
            HnWhxl result = (HnWhxl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnWhxl instance) {
        log.debug("attaching dirty HnWhxl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnWhxl instance) {
        log.debug("attaching clean HnWhxl instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}