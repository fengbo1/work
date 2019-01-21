package work.wb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.wb.pojo.WbYslr;

/**
 	* A data access object (DAO) providing persistence and search support for WbYslr entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WbYslr
  * @author MyEclipse Persistence Tools 
 */

public class WbYslrDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WbYslrDAO.class);
		//property constants
	public static final String CORPCODE = "corpcode";
	public static final String CORPNAME = "corpname";
	public static final String ONLINE = "online";
	public static final String ONLINE_ZB = "onlineZb";
	public static final String AVERTIME = "avertime";
	public static final String CL = "cl";
	public static final String CL_ZB = "clZb";
	public static final String CC = "cc";
	public static final String HS = "hs";
	public static final String AVEV_CL = "avevCl";
	public static final String ABOVE_NUM = "aboveNum";
	public static final String ABOVE_ZB = "aboveZb";
	public static final String WORKTIME_ZB = "worktimeZb";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String DATE = "date";
	public static final String CCL = "ccl";
	public static final String HSL = "hsl";
	public static final String ABOVE_TIME = "aboveTime";
	public static final String ABOVE_TIMEZB = "aboveTimezb";
	public static final String WORKTIME = "worktime";



    
    public void save(WbYslr transientInstance) {
        log.debug("saving WbYslr instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WbYslr persistentInstance) {
        log.debug("deleting WbYslr instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WbYslr findById( java.lang.Integer id) {
        log.debug("getting WbYslr instance with id: " + id);
        try {
            WbYslr instance = (WbYslr) getSession()
                    .get("WbYslr", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WbYslr instance) {
        log.debug("finding WbYslr instance by example");
        try {
            List results = getSession()
                    .createCriteria("WbYslr")
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
      log.debug("finding WbYslr instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WbYslr as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCorpcode(Object corpcode
	) {
		return findByProperty(CORPCODE, corpcode
		);
	}
	
	public List findByCorpname(Object corpname
	) {
		return findByProperty(CORPNAME, corpname
		);
	}
	
	public List findByOnline(Object online
	) {
		return findByProperty(ONLINE, online
		);
	}
	
	public List findByOnlineZb(Object onlineZb
	) {
		return findByProperty(ONLINE_ZB, onlineZb
		);
	}
	
	public List findByAvertime(Object avertime
	) {
		return findByProperty(AVERTIME, avertime
		);
	}
	
	public List findByCl(Object cl
	) {
		return findByProperty(CL, cl
		);
	}
	
	public List findByClZb(Object clZb
	) {
		return findByProperty(CL_ZB, clZb
		);
	}
	
	public List findByCc(Object cc
	) {
		return findByProperty(CC, cc
		);
	}
	
	public List findByHs(Object hs
	) {
		return findByProperty(HS, hs
		);
	}
	
	public List findByAvevCl(Object avevCl
	) {
		return findByProperty(AVEV_CL, avevCl
		);
	}
	
	public List findByAboveNum(Object aboveNum
	) {
		return findByProperty(ABOVE_NUM, aboveNum
		);
	}
	
	public List findByAboveZb(Object aboveZb
	) {
		return findByProperty(ABOVE_ZB, aboveZb
		);
	}
	
	public List findByWorktimeZb(Object worktimeZb
	) {
		return findByProperty(WORKTIME_ZB, worktimeZb
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
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByCcl(Object ccl
	) {
		return findByProperty(CCL, ccl
		);
	}
	
	public List findByHsl(Object hsl
	) {
		return findByProperty(HSL, hsl
		);
	}
	
	public List findByAboveTime(Object aboveTime
	) {
		return findByProperty(ABOVE_TIME, aboveTime
		);
	}
	
	public List findByAboveTimezb(Object aboveTimezb
	) {
		return findByProperty(ABOVE_TIMEZB, aboveTimezb
		);
	}
	
	public List findByWorktime(Object worktime
	) {
		return findByProperty(WORKTIME, worktime
		);
	}
	

	public List findAll() {
		log.debug("finding all WbYslr instances");
		try {
			String queryString = "from WbYslr";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WbYslr merge(WbYslr detachedInstance) {
        log.debug("merging WbYslr instance");
        try {
            WbYslr result = (WbYslr) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WbYslr instance) {
        log.debug("attaching dirty WbYslr instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WbYslr instance) {
        log.debug("attaching clean WbYslr instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}