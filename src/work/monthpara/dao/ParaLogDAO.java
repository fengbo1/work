package work.monthpara.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.monthpara.pojo.ParaLog;

/**
 	* A data access object (DAO) providing persistence and search support for ParaLog entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ParaLog
  * @author MyEclipse Persistence Tools 
 */

public class ParaLogDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ParaLogDAO.class);
		//property constants
	public static final String MONTH = "month";
	public static final String TYPE = "type";
	public static final String PARA = "para";
	public static final String BEF = "bef";
	public static final String AFT = "aft";
	public static final String OPERATOR = "operator";
	public static final String TIME = "time";
	public static final String REMARK = "remark";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";



    
    public void save(ParaLog transientInstance) {
        log.debug("saving ParaLog instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ParaLog persistentInstance) {
        log.debug("deleting ParaLog instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ParaLog findById( java.lang.Integer id) {
        log.debug("getting ParaLog instance with id: " + id);
        try {
            ParaLog instance = (ParaLog) getSession()
                    .get("ParaLog", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ParaLog instance) {
        log.debug("finding ParaLog instance by example");
        try {
            List results = getSession()
                    .createCriteria("ParaLog")
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
      log.debug("finding ParaLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ParaLog as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMonth(Object month
	) {
		return findByProperty(MONTH, month
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByPara(Object para
	) {
		return findByProperty(PARA, para
		);
	}
	
	public List findByBef(Object bef
	) {
		return findByProperty(BEF, bef
		);
	}
	
	public List findByAft(Object aft
	) {
		return findByProperty(AFT, aft
		);
	}
	
	public List findByOperator(Object operator
	) {
		return findByProperty(OPERATOR, operator
		);
	}
	
	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
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
	

	public List findAll() {
		log.debug("finding all ParaLog instances");
		try {
			String queryString = "from ParaLog";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ParaLog merge(ParaLog detachedInstance) {
        log.debug("merging ParaLog instance");
        try {
            ParaLog result = (ParaLog) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ParaLog instance) {
        log.debug("attaching dirty ParaLog instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ParaLog instance) {
        log.debug("attaching clean ParaLog instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}