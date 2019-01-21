package work.log.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.log.pojo.WorkLog;

/**
 	* A data access object (DAO) providing persistence and search support for WorkLog entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WorkLog
  * @author MyEclipse Persistence Tools 
 */

public class WorkLogDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WorkLogDAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String NAME = "name";
	public static final String IP = "ip";
	public static final String OPERATE = "operate";
	public static final String DETAIL = "detail";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String REMARK4 = "remark4";
	public static final String REMARK5 = "remark5";



    
    public void save(Session session,WorkLog transientInstance) {
        log.debug("saving WorkLog instance");
        try {
        	session.save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WorkLog persistentInstance) {
        log.debug("deleting WorkLog instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WorkLog findById( java.lang.Integer id) {
        log.debug("getting WorkLog instance with id: " + id);
        try {
            WorkLog instance = (WorkLog) getSession()
                    .get("WorkLog", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WorkLog instance) {
        log.debug("finding WorkLog instance by example");
        try {
            List results = getSession()
                    .createCriteria("WorkLog")
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
      log.debug("finding WorkLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WorkLog as model where model." 
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
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByIp(Object ip
	) {
		return findByProperty(IP, ip
		);
	}
	
	public List findByOperate(Object operate
	) {
		return findByProperty(OPERATE, operate
		);
	}
	
	public List findByDetail(Object detail
	) {
		return findByProperty(DETAIL, detail
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
	
	public List findByRemark4(Object remark4
	) {
		return findByProperty(REMARK4, remark4
		);
	}
	
	public List findByRemark5(Object remark5
	) {
		return findByProperty(REMARK5, remark5
		);
	}
	

	public List findAll() {
		log.debug("finding all WorkLog instances");
		try {
			String queryString = "from WorkLog";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WorkLog merge(WorkLog detachedInstance) {
        log.debug("merging WorkLog instance");
        try {
            WorkLog result = (WorkLog) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WorkLog instance) {
        log.debug("attaching dirty WorkLog instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WorkLog instance) {
        log.debug("attaching clean WorkLog instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}