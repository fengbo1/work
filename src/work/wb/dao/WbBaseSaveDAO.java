package work.wb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.wb.pojo.WbBaseSave;

/**
 	* A data access object (DAO) providing persistence and search support for WbBaseSave entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WbBaseSave
  * @author MyEclipse Persistence Tools 
 */

public class WbBaseSaveDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WbBaseSaveDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NO = "no";
	public static final String NAME = "name";
	public static final String YSLR = "yslr";
	public static final String YSLR_TIME = "yslrTime";
	public static final String YSLR_CC = "yslrCc";
	public static final String YSLR_HS = "yslrHs";
	public static final String YSLR_ZY = "yslrZy";
	public static final String YSLR_ZL = "yslrZl";
	public static final String LRZC = "lrzc";
	public static final String LRZC_TIME = "lrzcTime";
	public static final String LRZC_CC = "lrzcCc";
	public static final String LRZC_HS = "lrzcHs";
	public static final String LRZC_ZL = "lrzcZl";
	public static final String FZYY = "fzyy";
	public static final String FZYY_TIME = "fzyyTime";
	public static final String FZYY_CC = "fzyyCc";
	public static final String FZYY_HS = "fzyyHs";
	public static final String WORK_YSLR = "workYslr";
	public static final String YSLR_CCL = "yslrCcl";
	public static final String YSLR_HSL = "yslrHsl";
	public static final String YSLR_ZYL = "yslrZyl";
	public static final String YSLR_ZLL = "yslrZll";
	public static final String LRZC_CCL = "lrzcCcl";
	public static final String LRZC_HSL = "lrzcHsl";
	public static final String FZYY_CCL = "fzyyCcl";
	public static final String FZYY_HSL = "fzyyHsl";
	public static final String LRZC_ZLL = "lrzcZll";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String WORK_FZYY = "workFzyy";
	public static final String WORK_LRZC = "workLrzc";
	public static final String WORK_TIME = "workTime";



    
    public void save(WbBaseSave transientInstance) {
        log.debug("saving WbBaseSave instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WbBaseSave persistentInstance) {
        log.debug("deleting WbBaseSave instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WbBaseSave findById( java.lang.Integer id) {
        log.debug("getting WbBaseSave instance with id: " + id);
        try {
            WbBaseSave instance = (WbBaseSave) getSession()
                    .get("WbBaseSave", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WbBaseSave instance) {
        log.debug("finding WbBaseSave instance by example");
        try {
            List results = getSession()
                    .createCriteria("WbBaseSave")
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
      log.debug("finding WbBaseSave instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WbBaseSave as model where model." 
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
	
	public List findByYslr(Object yslr
	) {
		return findByProperty(YSLR, yslr
		);
	}
	
	public List findByYslrTime(Object yslrTime
	) {
		return findByProperty(YSLR_TIME, yslrTime
		);
	}
	
	public List findByYslrCc(Object yslrCc
	) {
		return findByProperty(YSLR_CC, yslrCc
		);
	}
	
	public List findByYslrHs(Object yslrHs
	) {
		return findByProperty(YSLR_HS, yslrHs
		);
	}
	
	public List findByYslrZy(Object yslrZy
	) {
		return findByProperty(YSLR_ZY, yslrZy
		);
	}
	
	public List findByYslrZl(Object yslrZl
	) {
		return findByProperty(YSLR_ZL, yslrZl
		);
	}
	
	public List findByLrzc(Object lrzc
	) {
		return findByProperty(LRZC, lrzc
		);
	}
	
	public List findByLrzcTime(Object lrzcTime
	) {
		return findByProperty(LRZC_TIME, lrzcTime
		);
	}
	
	public List findByLrzcCc(Object lrzcCc
	) {
		return findByProperty(LRZC_CC, lrzcCc
		);
	}
	
	public List findByLrzcHs(Object lrzcHs
	) {
		return findByProperty(LRZC_HS, lrzcHs
		);
	}
	
	public List findByLrzcZl(Object lrzcZl
	) {
		return findByProperty(LRZC_ZL, lrzcZl
		);
	}
	
	public List findByFzyy(Object fzyy
	) {
		return findByProperty(FZYY, fzyy
		);
	}
	
	public List findByFzyyTime(Object fzyyTime
	) {
		return findByProperty(FZYY_TIME, fzyyTime
		);
	}
	
	public List findByFzyyCc(Object fzyyCc
	) {
		return findByProperty(FZYY_CC, fzyyCc
		);
	}
	
	public List findByFzyyHs(Object fzyyHs
	) {
		return findByProperty(FZYY_HS, fzyyHs
		);
	}
	
	public List findByWorkYslr(Object workYslr
	) {
		return findByProperty(WORK_YSLR, workYslr
		);
	}
	
	public List findByYslrCcl(Object yslrCcl
	) {
		return findByProperty(YSLR_CCL, yslrCcl
		);
	}
	
	public List findByYslrHsl(Object yslrHsl
	) {
		return findByProperty(YSLR_HSL, yslrHsl
		);
	}
	
	public List findByYslrZyl(Object yslrZyl
	) {
		return findByProperty(YSLR_ZYL, yslrZyl
		);
	}
	
	public List findByYslrZll(Object yslrZll
	) {
		return findByProperty(YSLR_ZLL, yslrZll
		);
	}
	
	public List findByLrzcCcl(Object lrzcCcl
	) {
		return findByProperty(LRZC_CCL, lrzcCcl
		);
	}
	
	public List findByLrzcHsl(Object lrzcHsl
	) {
		return findByProperty(LRZC_HSL, lrzcHsl
		);
	}
	
	public List findByFzyyCcl(Object fzyyCcl
	) {
		return findByProperty(FZYY_CCL, fzyyCcl
		);
	}
	
	public List findByFzyyHsl(Object fzyyHsl
	) {
		return findByProperty(FZYY_HSL, fzyyHsl
		);
	}
	
	public List findByLrzcZll(Object lrzcZll
	) {
		return findByProperty(LRZC_ZLL, lrzcZll
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
	
	public List findByWorkFzyy(Object workFzyy
	) {
		return findByProperty(WORK_FZYY, workFzyy
		);
	}
	
	public List findByWorkLrzc(Object workLrzc
	) {
		return findByProperty(WORK_LRZC, workLrzc
		);
	}
	
	public List findByWorkTime(Object workTime
	) {
		return findByProperty(WORK_TIME, workTime
		);
	}
	

	public List findAll() {
		log.debug("finding all WbBaseSave instances");
		try {
			String queryString = "from WbBaseSave";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WbBaseSave merge(WbBaseSave detachedInstance) {
        log.debug("merging WbBaseSave instance");
        try {
            WbBaseSave result = (WbBaseSave) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WbBaseSave instance) {
        log.debug("attaching dirty WbBaseSave instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WbBaseSave instance) {
        log.debug("attaching clean WbBaseSave instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}