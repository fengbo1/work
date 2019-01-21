package work.pool.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.pool.pojo.Pool;

/**
 	* A data access object (DAO) providing persistence and search support for Pool entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Pool
  * @author MyEclipse Persistence Tools 
 */

public class PoolDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PoolDAO.class);
		//property constants
	public static final String NO = "no";
	public static final String TYPE = "type";
	public static final String INTYPE = "intype";
	public static final String PART = "part";
	public static final String CODE = "code";
	public static final String NUMBER = "number";
	public static final String CC = "cc";
	public static final String TP = "tp";
	public static final String SC = "sc";



    
    public void save(Pool transientInstance) {
        log.debug("saving Pool instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Pool persistentInstance) {
        log.debug("deleting Pool instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Pool findById( java.lang.Integer id) {
        log.debug("getting Pool instance with id: " + id);
        try {
            Pool instance = (Pool) getSession()
                    .get("Pool", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Pool instance) {
        log.debug("finding Pool instance by example");
        try {
            List results = getSession()
                    .createCriteria("Pool")
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
      log.debug("finding Pool instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Pool as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNo(Object no
	) {
		return findByProperty(NO, no
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByIntype(Object intype
	) {
		return findByProperty(INTYPE, intype
		);
	}
	
	public List findByPart(Object part
	) {
		return findByProperty(PART, part
		);
	}
	
	public List findByCode(Object code
	) {
		return findByProperty(CODE, code
		);
	}
	
	public List findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	
	public List findByCc(Object cc
	) {
		return findByProperty(CC, cc
		);
	}
	
	public List findByTp(Object tp
	) {
		return findByProperty(TP, tp
		);
	}
	
	public List findBySc(Object sc
	) {
		return findByProperty(SC, sc
		);
	}
	

	public List findAll() {
		log.debug("finding all Pool instances");
		try {
			String queryString = "from Pool";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Pool merge(Pool detachedInstance) {
        log.debug("merging Pool instance");
        try {
            Pool result = (Pool) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Pool instance) {
        log.debug("attaching dirty Pool instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Pool instance) {
        log.debug("attaching clean Pool instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
     * 根据工号，所属业务种类查询所有
     * @param no
     * @param type
     * @return
     */
    public List findAllByNoAndIntype(String no,int type) {
		log.debug("finding all Pool instances");
		try {
			String queryString = "from Pool as p where p.no='"+no+"' and p.intype='"+type+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}