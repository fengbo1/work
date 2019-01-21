package work.ygxy.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.ygxy.pojo.YZjmx;

/**
 	* A data access object (DAO) providing persistence and search support for YZjmx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .YZjmx
  * @author MyEclipse Persistence Tools 
 */

public class YZjmxDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(YZjmxDAO.class);
		//property constants
	public static final String XH = "xh";
	public static final String NAME = "name";
	public static final String NO = "no";
	public static final String GDNUMBER = "gdnumber";
	public static final String LZXH = "lzxh";
	public static final String DATE = "date";
	public static final String CJDF = "cjdf";
	public static final String ZJRW = "zjrw";
	public static final String FJDF = "fjdf";



    
    public void save(YZjmx transientInstance) {
        log.debug("saving YZjmx instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(YZjmx persistentInstance) {
        log.debug("deleting YZjmx instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public YZjmx findById( java.lang.Integer id) {
        log.debug("getting YZjmx instance with id: " + id);
        try {
            YZjmx instance = (YZjmx) getSession()
                    .get("YZjmx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(YZjmx instance) {
        log.debug("finding YZjmx instance by example");
        try {
            List results = getSession()
                    .createCriteria("YZjmx")
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
      log.debug("finding YZjmx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from YZjmx as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByXh(Object xh
	) {
		return findByProperty(XH, xh
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
	
	public List findByGdnumber(Object gdnumber
	) {
		return findByProperty(GDNUMBER, gdnumber
		);
	}
	
	public List findByLzxh(Object lzxh
	) {
		return findByProperty(LZXH, lzxh
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByCjdf(Object cjdf
	) {
		return findByProperty(CJDF, cjdf
		);
	}
	
	public List findByZjrw(Object zjrw
	) {
		return findByProperty(ZJRW, zjrw
		);
	}
	
	public List findByFjdf(Object fjdf
	) {
		return findByProperty(FJDF, fjdf
		);
	}
	

	public List findAll() {
		log.debug("finding all YZjmx instances");
		try {
			String queryString = "from YZjmx";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public YZjmx merge(YZjmx detachedInstance) {
        log.debug("merging YZjmx instance");
        try {
            YZjmx result = (YZjmx) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(YZjmx instance) {
        log.debug("attaching dirty YZjmx instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(YZjmx instance) {
        log.debug("attaching clean YZjmx instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}