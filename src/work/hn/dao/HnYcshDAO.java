package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.HnYcsh;

/**
 	* A data access object (DAO) providing persistence and search support for HnYcsh entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnYcsh
  * @author MyEclipse Persistence Tools 
 */

public class HnYcshDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnYcshDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NEWNUMBER = "newnumber";
	public static final String NAME = "name";
	public static final String ZX = "zx";
	public static final String XZ = "xz";
	public static final String SX = "sx";
	public static final String POS = "pos";
	public static final String CL = "cl";
	public static final String NUM = "num";
	public static final String SC = "sc";
	public static final String PJSC = "pjsc";
	public static final String TG = "tg";
	public static final String TGL = "tgl";
	public static final String JJ = "jj";
	public static final String JJL = "jjl";
	public static final String CX = "cx";
	public static final String CXL = "cxl";
	public static final String ZXSC = "zxsc";



    
    public void save(HnYcsh transientInstance) {
        log.debug("saving HnYcsh instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnYcsh persistentInstance) {
        log.debug("deleting HnYcsh instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnYcsh findById( java.lang.Integer id) {
        log.debug("getting HnYcsh instance with id: " + id);
        try {
            HnYcsh instance = (HnYcsh) getSession()
                    .get("HnYcsh", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnYcsh instance) {
        log.debug("finding HnYcsh instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnYcsh")
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
      log.debug("finding HnYcsh instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnYcsh as model where model." 
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
	
	public List findByNum(Object num
	) {
		return findByProperty(NUM, num
		);
	}
	
	public List findBySc(Object sc
	) {
		return findByProperty(SC, sc
		);
	}
	
	public List findByPjsc(Object pjsc
	) {
		return findByProperty(PJSC, pjsc
		);
	}
	
	public List findByTg(Object tg
	) {
		return findByProperty(TG, tg
		);
	}
	
	public List findByTgl(Object tgl
	) {
		return findByProperty(TGL, tgl
		);
	}
	
	public List findByJj(Object jj
	) {
		return findByProperty(JJ, jj
		);
	}
	
	public List findByJjl(Object jjl
	) {
		return findByProperty(JJL, jjl
		);
	}
	
	public List findByCx(Object cx
	) {
		return findByProperty(CX, cx
		);
	}
	
	public List findByCxl(Object cxl
	) {
		return findByProperty(CXL, cxl
		);
	}
	
	public List findByZxsc(Object zxsc
	) {
		return findByProperty(ZXSC, zxsc
		);
	}
	

	public List findAll() {
		log.debug("finding all HnYcsh instances");
		try {
			String queryString = "from HnYcsh";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnYcsh merge(HnYcsh detachedInstance) {
        log.debug("merging HnYcsh instance");
        try {
            HnYcsh result = (HnYcsh) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnYcsh instance) {
        log.debug("attaching dirty HnYcsh instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnYcsh instance) {
        log.debug("attaching clean HnYcsh instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllByDate(String date) {
		log.debug("finding all HnYcsh instances");
		try {
			String queryString = "from HnYcsh as hy where hy.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public HnYcsh findAllByDateAndName(String date,String name) {
		log.debug("finding all HnYcsh instances");
		try {
			String queryString = "from HnYcsh as hy where hy.date='"+date+"' and hy.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return new HnYcsh();
			 }
			 else
			 {
				 return (HnYcsh)list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public HnYcsh findAllByDateAndNameNull(String date,String name) {
		log.debug("finding all HnYcsh instances");
		try {
			String queryString = "from HnYcsh as hy where hy.date='"+date+"' and hy.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				 return (HnYcsh)list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}