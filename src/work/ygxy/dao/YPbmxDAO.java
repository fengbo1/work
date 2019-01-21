package work.ygxy.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.ygxy.pojo.YPbmx;

/**
 	* A data access object (DAO) providing persistence and search support for YPbmx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .YPbmx
  * @author MyEclipse Persistence Tools 
 */

public class YPbmxDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(YPbmxDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NAME = "name";
	public static final String NO = "no";
	public static final String IFSB = "ifsb";
	public static final String IFLH = "iflh";
	public static final String IFGD = "ifgd";
	public static final String TYPE = "type";



    
    public void save(YPbmx transientInstance) {
        log.debug("saving YPbmx instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(YPbmx persistentInstance) {
        log.debug("deleting YPbmx instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public YPbmx findById( java.lang.Integer id) {
        log.debug("getting YPbmx instance with id: " + id);
        try {
            YPbmx instance = (YPbmx) getSession()
                    .get("YPbmx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(YPbmx instance) {
        log.debug("finding YPbmx instance by example");
        try {
            List results = getSession()
                    .createCriteria("YPbmx")
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
      log.debug("finding YPbmx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from YPbmx as model where model." 
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
	
	public List findByIfsb(Object ifsb
	) {
		return findByProperty(IFSB, ifsb
		);
	}
	
	public List findByIflh(Object iflh
	) {
		return findByProperty(IFLH, iflh
		);
	}
	
	public List findByIfgd(Object ifgd
	) {
		return findByProperty(IFGD, ifgd
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	

	public List findAll() {
		log.debug("finding all YPbmx instances");
		try {
			String queryString = "from YPbmx";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public YPbmx merge(YPbmx detachedInstance) {
        log.debug("merging YPbmx instance");
        try {
            YPbmx result = (YPbmx) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(YPbmx instance) {
        log.debug("attaching dirty YPbmx instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(YPbmx instance) {
        log.debug("attaching clean YPbmx instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
	 
    public YPbmx findAllByDateAndName(String date,String name) {
		log.debug("finding all YPbmx instances");
		try {
			String queryString = "from YPbmx as yp where yp.date='"+date+"' and yp.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<YPbmx> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return new YPbmx(date,name,"",0,0,0,0);
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