package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.HnFxq;
import work.hn.pojo.HnYcsh;

/**
 	* A data access object (DAO) providing persistence and search support for HnFxq entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnFxq
  * @author MyEclipse Persistence Tools 
 */

public class HnFxqDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnFxqDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NEWNUMBER = "newnumber";
	public static final String NAME = "name";
	public static final String ZX = "zx";
	public static final String XZ = "xz";
	public static final String SX = "sx";
	public static final String POS = "pos";
	public static final String CL = "cl";
	public static final String YWL = "ywl";
	public static final String DEKH = "dekh";
	public static final String DEMX = "demx";
	public static final String KYKH = "kykh";
	public static final String KYMX = "kymx";



    
    public void save(HnFxq transientInstance) {
        log.debug("saving HnFxq instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnFxq persistentInstance) {
        log.debug("deleting HnFxq instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnFxq findById( java.lang.Integer id) {
        log.debug("getting HnFxq instance with id: " + id);
        try {
            HnFxq instance = (HnFxq) getSession()
                    .get("HnFxq", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnFxq instance) {
        log.debug("finding HnFxq instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnFxq")
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
      log.debug("finding HnFxq instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnFxq as model where model." 
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
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByZx(Object zx
	) {
		return findByProperty(ZX, zx
		);
	}
	
	public List findByXz(Object xz
	) {
		return findByProperty(XZ, xz
		);
	}
	
	public List findBySx(Object sx
	) {
		return findByProperty(SX, sx
		);
	}
	
	public List findByPos(Object pos
	) {
		return findByProperty(POS, pos
		);
	}
	
	public List findByCl(Object cl
	) {
		return findByProperty(CL, cl
		);
	}
	
	public List findByYwl(Object ywl
	) {
		return findByProperty(YWL, ywl
		);
	}
	
	public List findByDekh(Object dekh
	) {
		return findByProperty(DEKH, dekh
		);
	}
	
	public List findByDemx(Object demx
	) {
		return findByProperty(DEMX, demx
		);
	}
	
	public List findByKykh(Object kykh
	) {
		return findByProperty(KYKH, kykh
		);
	}
	
	public List findByKymx(Object kymx
	) {
		return findByProperty(KYMX, kymx
		);
	}
	

	public List findAll() {
		log.debug("finding all HnFxq instances");
		try {
			String queryString = "from HnFxq";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnFxq merge(HnFxq detachedInstance) {
        log.debug("merging HnFxq instance");
        try {
            HnFxq result = (HnFxq) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnFxq instance) {
        log.debug("attaching dirty HnFxq instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnFxq instance) {
        log.debug("attaching clean HnFxq instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllByDate(String date) {
		log.debug("finding all HnFxq instances");
		try {
			String queryString = "from HnFxq as f where f.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public HnFxq findAllByDateAndName(String date,String name) {
		log.debug("finding all HnFxq instances");
		try {
			String queryString = "from HnFxq as f where f.date='"+date+"' and f.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return new HnFxq();
			 }
			 else
			 {
				 return (HnFxq)list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public HnFxq findAllByDateAndNewnumber(String date,String newnumber) {
		log.debug("finding all HnFxq instances");
		try {
			String queryString = "from HnFxq as f where f.date='"+date+"' and f.newnumber='"+newnumber+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 HnFxq hf = new HnFxq();
				 hf.setDate(date);
				 hf.setNewnumber(newnumber);
				 hf.setDekh(0);
				 hf.setDemx(0);
				 hf.setKykh(0);
				 hf.setKymx(0);
				 return hf;
			 }
			 else
			 {
				 return (HnFxq)list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}