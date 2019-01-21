package work.control.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.control.pojo.JiheConfig;

/**
 	* A data access object (DAO) providing persistence and search support for JiheConfig entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .JiheConfig
  * @author MyEclipse Persistence Tools 
 */

public class JiheConfigDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JiheConfigDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String CENTER = "center";



    
    public void save(JiheConfig transientInstance) {
        log.debug("saving JiheConfig instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(JiheConfig persistentInstance) {
        log.debug("deleting JiheConfig instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public JiheConfig findById( java.lang.Integer id) {
        log.debug("getting JiheConfig instance with id: " + id);
        try {
            JiheConfig instance = (JiheConfig) getSession()
                    .get("JiheConfig", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(JiheConfig instance) {
        log.debug("finding JiheConfig instance by example");
        try {
            List results = getSession()
                    .createCriteria("JiheConfig")
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
      log.debug("finding JiheConfig instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JiheConfig as model where model." 
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
		log.debug("finding all JiheConfig instances");
		try {
			String queryString = "from JiheConfig";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public JiheConfig merge(JiheConfig detachedInstance) {
        log.debug("merging JiheConfig instance");
        try {
            JiheConfig result = (JiheConfig) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(JiheConfig instance) {
        log.debug("attaching dirty JiheConfig instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(JiheConfig instance) {
        log.debug("attaching clean JiheConfig instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
     * 
     * @param newnumber
     * @return
     */
	public JiheConfig findAllByNewnumber(String newnumber) {
		log.debug("finding all JiheConfig instances");
		try {
			String queryString = "from JiheConfig as jc where jc.newnumber='"+newnumber+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				 return (JiheConfig) list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
     * 
     * @param newnumber
     * @return
     */
	public JiheConfig findAllByName(String name) {
		log.debug("finding all JiheConfig instances");
		try {
			String queryString = "from JiheConfig as jc where jc.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				 return (JiheConfig) list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}