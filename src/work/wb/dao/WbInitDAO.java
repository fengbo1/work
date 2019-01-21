package work.wb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.wb.pojo.WbInit;

/**
 	* A data access object (DAO) providing persistence and search support for WbInit entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WbInit
  * @author MyEclipse Persistence Tools 
 */

public class WbInitDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WbInitDAO.class);
		//property constants
	public static final String NO = "no";
	public static final String NAME = "name";
	public static final String STEP = "step";
	public static final String YWL = "ywl";
	public static final String AVER_TIME = "averTime";
	public static final String CC = "cc";
	public static final String HS = "hs";
	public static final String ZLRXG = "zlrxg";
	public static final String ZYXCF = "zyxcf";
	public static final String POOL = "pool";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";



    
    public void save(WbInit transientInstance) {
        log.debug("saving WbInit instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WbInit persistentInstance) {
        log.debug("deleting WbInit instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WbInit findById( java.lang.Integer id) {
        log.debug("getting WbInit instance with id: " + id);
        try {
            WbInit instance = (WbInit) getSession()
                    .get("WbInit", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WbInit instance) {
        log.debug("finding WbInit instance by example");
        try {
            List results = getSession()
                    .createCriteria("WbInit")
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
      log.debug("finding WbInit instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WbInit as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
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
	
	public List findByStep(Object step
	) {
		return findByProperty(STEP, step
		);
	}
	
	public List findByYwl(Object ywl
	) {
		return findByProperty(YWL, ywl
		);
	}
	
	public List findByAverTime(Object averTime
	) {
		return findByProperty(AVER_TIME, averTime
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
	
	public List findByZlrxg(Object zlrxg
	) {
		return findByProperty(ZLRXG, zlrxg
		);
	}
	
	public List findByZyxcf(Object zyxcf
	) {
		return findByProperty(ZYXCF, zyxcf
		);
	}
	
	public List findByPool(Object pool
	) {
		return findByProperty(POOL, pool
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
		log.debug("finding all WbInit instances");
		try {
			String queryString = "from WbInit";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WbInit merge(WbInit detachedInstance) {
        log.debug("merging WbInit instance");
        try {
            WbInit result = (WbInit) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WbInit instance) {
        log.debug("attaching dirty WbInit instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WbInit instance) {
        log.debug("attaching clean WbInit instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}