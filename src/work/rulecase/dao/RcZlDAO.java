package work.rulecase.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.rulecase.pojo.RcZl;

/**
 	* A data access object (DAO) providing persistence and search support for RcZl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .RcZl
  * @author MyEclipse Persistence Tools 
 */

public class RcZlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(RcZlDAO.class);
		//property constants
	public static final String TYPE = "type";
	public static final String PLATE = "plate";
	public static final String POOL = "pool";
	public static final String DATE = "date";
	public static final String ZLNAME = "zlname";
	public static final String FILENAME = "filename";



    
    public void save(RcZl transientInstance) {
        log.debug("saving RcZl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RcZl persistentInstance) {
        log.debug("deleting RcZl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RcZl findById( java.lang.Integer id) {
        log.debug("getting RcZl instance with id: " + id);
        try {
            RcZl instance = (RcZl) getSession()
                    .get("RcZl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(RcZl instance) {
        log.debug("finding RcZl instance by example");
        try {
            List results = getSession()
                    .createCriteria("RcZl")
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
      log.debug("finding RcZl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RcZl as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByPlate(Object plate
	) {
		return findByProperty(PLATE, plate
		);
	}
	
	public List findByPool(Object pool
	) {
		return findByProperty(POOL, pool
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByZlname(Object zlname
	) {
		return findByProperty(ZLNAME, zlname
		);
	}
	
	public List findByFilename(Object filename
	) {
		return findByProperty(FILENAME, filename
		);
	}
	

	public List findAll() {
		log.debug("finding all RcZl instances");
		try {
			String queryString = "from RcZl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RcZl merge(RcZl detachedInstance) {
        log.debug("merging RcZl instance");
        try {
            RcZl result = (RcZl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RcZl instance) {
        log.debug("attaching dirty RcZl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RcZl instance) {
        log.debug("attaching clean RcZl instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}