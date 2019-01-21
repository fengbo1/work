package work.control.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.control.pojo.FxqConfig;

/**
 	* A data access object (DAO) providing persistence and search support for FxqConfig entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .FxqConfig
  * @author MyEclipse Persistence Tools 
 */

public class FxqConfigDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(FxqConfigDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String CENTER = "center";



    
    public void save(FxqConfig transientInstance) {
        log.debug("saving FxqConfig instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(FxqConfig persistentInstance) {
        log.debug("deleting FxqConfig instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public FxqConfig findById( java.lang.Integer id) {
        log.debug("getting FxqConfig instance with id: " + id);
        try {
            FxqConfig instance = (FxqConfig) getSession()
                    .get("FxqConfig", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(FxqConfig instance) {
        log.debug("finding FxqConfig instance by example");
        try {
            List results = getSession()
                    .createCriteria("FxqConfig")
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
      log.debug("finding FxqConfig instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from FxqConfig as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByCenter(Object center
	) {
		return findByProperty(CENTER, center
		);
	}
	

	public List findAll() {
		log.debug("finding all FxqConfig instances");
		try {
			String queryString = "from FxqConfig";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public FxqConfig merge(FxqConfig detachedInstance) {
        log.debug("merging FxqConfig instance");
        try {
            FxqConfig result = (FxqConfig) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(FxqConfig instance) {
        log.debug("attaching dirty FxqConfig instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(FxqConfig instance) {
        log.debug("attaching clean FxqConfig instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public FxqConfig findAllByName(String name) {
		log.debug("finding all FxqConfig instances");
		try {
			String queryString = "from FxqConfig as fc where fc.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<FxqConfig> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	 return list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}