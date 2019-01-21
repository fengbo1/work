package work.control.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.control.pojo.CfgXz;

/**
 	* A data access object (DAO) providing persistence and search support for CfgXz entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .CfgXz
  * @author MyEclipse Persistence Tools 
 */

public class CfgXzDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CfgXzDAO.class);
		//property constants
	public static final String TNUM = "tnum";
	public static final String INDX = "indx";
	public static final String TYPE = "type";
	public static final String CNUM = "cnum";
	public static final String CONTENT = "content";
	public static final String DETAIL = "detail";



    
    public void save(CfgXz transientInstance) {
        log.debug("saving CfgXz instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CfgXz persistentInstance) {
        log.debug("deleting CfgXz instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CfgXz findById( java.lang.Integer id) {
        log.debug("getting CfgXz instance with id: " + id);
        try {
            CfgXz instance = (CfgXz) getSession()
                    .get("CfgXz", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CfgXz instance) {
        log.debug("finding CfgXz instance by example");
        try {
            List results = getSession()
                    .createCriteria("CfgXz")
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
      log.debug("finding CfgXz instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CfgXz as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTnum(Object tnum
	) {
		return findByProperty(TNUM, tnum
		);
	}
	
	public List findByIndx(Object indx
	) {
		return findByProperty(INDX, indx
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByCnum(Object cnum
	) {
		return findByProperty(CNUM, cnum
		);
	}
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List findByDetail(Object detail
	) {
		return findByProperty(DETAIL, detail
		);
	}
	

	public List findAll() {
		log.debug("finding all CfgXz instances");
		try {
			String queryString = "from CfgXz";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CfgXz merge(CfgXz detachedInstance) {
        log.debug("merging CfgXz instance");
        try {
            CfgXz result = (CfgXz) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CfgXz instance) {
        log.debug("attaching dirty CfgXz instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CfgXz instance) {
        log.debug("attaching clean CfgXz instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllByType(int type) {
		log.debug("finding all CfgXz instances");
		try {
			String queryString = "from CfgXz as cx where cx.type='"+type+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public String findAllByTnumAndCnum(int tnum,char cnum) {
		log.debug("finding all CfgXz instances");
		try {
			String queryString = "from CfgXz as cx where cx.tnum='"+tnum+"' and cx.cnum='"+cnum+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<CfgXz> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return "";
	         }
	         else
	         {
	        	 return list.get(0).getContent();
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public String findAllByZDYAndCnum(int cnum) {
		log.debug("finding all CfgXz instances");
		try {
			String queryString = "from CfgXz as cx where cx.tnum='0' and cx.cnum='"+cnum+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<CfgXz> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return "";
	         }
	         else
	         {
	        	 return list.get(0).getContent();
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public List findAllByIndx(int indx) {
		log.debug("finding all CfgXz instances");
		try {
			String queryString = "from CfgXz as cx where cx.indx='"+indx+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public CfgXz findAllById(int id) {
		log.debug("finding all CfgXz instances");
		try {
			String queryString = "from CfgXz where id='"+id+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				 return (CfgXz) list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}