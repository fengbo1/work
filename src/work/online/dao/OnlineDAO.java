package work.online.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.online.pojo.Online;

/**
 	* A data access object (DAO) providing persistence and search support for Online entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Online
  * @author MyEclipse Persistence Tools 
 */

public class OnlineDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OnlineDAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String NO = "no";



    
    public void save(Online transientInstance) {
        log.debug("saving Online instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Online persistentInstance) {
        log.debug("deleting Online instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Online findById( java.lang.Integer id) {
        log.debug("getting Online instance with id: " + id);
        try {
            Online instance = (Online) getSession()
                    .get("Online", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Online instance) {
        log.debug("finding Online instance by example");
        try {
            List results = getSession()
                    .createCriteria("Online")
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
      log.debug("finding Online instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Online as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
		);
	}
	
	public List findByNo(Object no
	) {
		return findByProperty(NO, no
		);
	}
	

	public List findAll() {
		log.debug("finding all Online instances");
		try {
			String queryString = "from Online";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 根据日期工号判断员工是否上线
	 * @param time
	 * @param no
	 * @return 上线，返回1，没上线，返回0
	 */
	public boolean isOnline(String time,String no)
	{
		log.debug("finding all Online instances");
		try {
			String queryString = "from Online as ol where ol.time='"+time+"' and ol.no='"+no+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list==null||list.isEmpty()||list.size()==0)
	        	 return false;
	         else
	        	 return true;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Online merge(Online detachedInstance) {
        log.debug("merging Online instance");
        try {
            Online result = (Online) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Online instance) {
        log.debug("attaching dirty Online instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Online instance) {
        log.debug("attaching clean Online instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}