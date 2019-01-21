package work.ygxy.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.ygxy.pojo.Lxsc;
import work.ygxy.pojo.YPbmx;

/**
 	* A data access object (DAO) providing persistence and search support for Lxsc entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Lxsc
  * @author MyEclipse Persistence Tools 
 */

public class LxscDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(LxscDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NAME = "name";
	public static final String REASON = "reason";
	public static final String SHICHANG = "shichang";
	public static final String YOUXIAO = "youxiao";



    
    public void save(Lxsc transientInstance) {
        log.debug("saving Lxsc instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Lxsc persistentInstance) {
        log.debug("deleting Lxsc instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Lxsc findById( java.lang.Integer id) {
        log.debug("getting Lxsc instance with id: " + id);
        try {
            Lxsc instance = (Lxsc) getSession()
                    .get("Lxsc", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Lxsc instance) {
        log.debug("finding Lxsc instance by example");
        try {
            List results = getSession()
                    .createCriteria("Lxsc")
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
      log.debug("finding Lxsc instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Lxsc as model where model." 
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
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
		);
	}
	
	public List findByShichang(Object shichang
	) {
		return findByProperty(SHICHANG, shichang
		);
	}
	
	public List findByYouxiao(Object youxiao
	) {
		return findByProperty(YOUXIAO, youxiao
		);
	}
	

	public List findAll() {
		log.debug("finding all Lxsc instances");
		try {
			String queryString = "from Lxsc";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Lxsc merge(Lxsc detachedInstance) {
        log.debug("merging Lxsc instance");
        try {
            Lxsc result = (Lxsc) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Lxsc instance) {
        log.debug("attaching dirty Lxsc instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Lxsc instance) {
        log.debug("attaching clean Lxsc instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public Lxsc findAllByDateAndName(String date,String name) {
		log.debug("finding all Lxsc instances");
		try {
			String queryString = "from Lxsc as l where l.date='"+date+"' and l.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<Lxsc> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return new Lxsc(date,name,"",0.0,0);
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