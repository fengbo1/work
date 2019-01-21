package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.HnWhzl;

/**
 	* A data access object (DAO) providing persistence and search support for HnWhzl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnWhzl
  * @author MyEclipse Persistence Tools 
 */

public class HnWhzlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnWhzlDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NAME = "name";
	public static final String NO = "no";
	public static final String CXLRMB = "cxlrmb";
	public static final String QDLD = "qdld";
	public static final String ZWDL = "zwdl";
	public static final String BHWH = "bhwh";
	public static final String CXLWH = "cxlwh";
	public static final String CXLJY = "cxljy";



    
    public void save(HnWhzl transientInstance) {
        log.debug("saving HnWhzl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnWhzl persistentInstance) {
        log.debug("deleting HnWhzl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnWhzl findById( java.lang.Integer id) {
        log.debug("getting HnWhzl instance with id: " + id);
        try {
            HnWhzl instance = (HnWhzl) getSession()
                    .get("HnWhzl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnWhzl instance) {
        log.debug("finding HnWhzl instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnWhzl")
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
      log.debug("finding HnWhzl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnWhzl as model where model." 
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
	
	public List findByCxlrmb(Object cxlrmb
	) {
		return findByProperty(CXLRMB, cxlrmb
		);
	}
	
	public List findByQdld(Object qdld
	) {
		return findByProperty(QDLD, qdld
		);
	}
	
	public List findByZwdl(Object zwdl
	) {
		return findByProperty(ZWDL, zwdl
		);
	}
	
	public List findByBhwh(Object bhwh
	) {
		return findByProperty(BHWH, bhwh
		);
	}
	
	public List findByCxlwh(Object cxlwh
	) {
		return findByProperty(CXLWH, cxlwh
		);
	}
	
	public List findByCxljy(Object cxljy
	) {
		return findByProperty(CXLJY, cxljy
		);
	}
	

	public List findAll() {
		log.debug("finding all HnWhzl instances");
		try {
			String queryString = "from HnWhzl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnWhzl merge(HnWhzl detachedInstance) {
        log.debug("merging HnWhzl instance");
        try {
            HnWhzl result = (HnWhzl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnWhzl instance) {
        log.debug("attaching dirty HnWhzl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnWhzl instance) {
        log.debug("attaching clean HnWhzl instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}