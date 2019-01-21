package work.control.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.control.pojo.Jhsx;

/**
 	* A data access object (DAO) providing persistence and search support for Jhsx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Jhsx
  * @author MyEclipse Persistence Tools 
 */

public class JhsxDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JhsxDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String CDZWSJ = "cdzwsj";
	public static final String CDZWJH = "cdzwjh";
	public static final String CDFZSJ = "cdfzsj";
	public static final String CDFZJH = "cdfzjh";
	public static final String CDWHSJ = "cdwhsj";
	public static final String CDWHJH = "cdwhjh";
	public static final String CDJHSJ = "cdjhsj";
	public static final String CDJHJH = "cdjhjh";
	public static final String CDSHSJ = "cdshsj";
	public static final String CDSHJH = "cdshjh";
	public static final String CDJYSJ = "cdjysj";
	public static final String CDJYJH = "cdjyjh";
	public static final String WHZWSJ = "whzwsj";
	public static final String WHZWJH = "whzwjh";
	public static final String WHFZSJ = "whfzsj";
	public static final String WHFZJH = "whfzjh";
	public static final String WHWHSJ = "whwhsj";
	public static final String WHWHJH = "whwhjh";
	public static final String WHJHSJ = "whjhsj";
	public static final String WHJHJH = "whjhjh";
	public static final String WHSHSJ = "whshsj";
	public static final String WHSHJH = "whshjh";
	public static final String WHJYSJ = "whjysj";
	public static final String WHJYJH = "whjyjh";
	public static final String OPERATOR = "operator";



    
    public void save(Jhsx transientInstance) {
        log.debug("saving Jhsx instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Jhsx persistentInstance) {
        log.debug("deleting Jhsx instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Jhsx findById( java.lang.Integer id) {
        log.debug("getting Jhsx instance with id: " + id);
        try {
            Jhsx instance = (Jhsx) getSession()
                    .get("Jhsx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Jhsx instance) {
        log.debug("finding Jhsx instance by example");
        try {
            List results = getSession()
                    .createCriteria("Jhsx")
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
      log.debug("finding Jhsx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Jhsx as model where model." 
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
	
	public List findByCdzwsj(Object cdzwsj
	) {
		return findByProperty(CDZWSJ, cdzwsj
		);
	}
	
	public List findByCdzwjh(Object cdzwjh
	) {
		return findByProperty(CDZWJH, cdzwjh
		);
	}
	
	public List findByCdfzsj(Object cdfzsj
	) {
		return findByProperty(CDFZSJ, cdfzsj
		);
	}
	
	public List findByCdfzjh(Object cdfzjh
	) {
		return findByProperty(CDFZJH, cdfzjh
		);
	}
	
	public List findByCdwhsj(Object cdwhsj
	) {
		return findByProperty(CDWHSJ, cdwhsj
		);
	}
	
	public List findByCdwhjh(Object cdwhjh
	) {
		return findByProperty(CDWHJH, cdwhjh
		);
	}
	
	public List findByCdjhsj(Object cdjhsj
	) {
		return findByProperty(CDJHSJ, cdjhsj
		);
	}
	
	public List findByCdjhjh(Object cdjhjh
	) {
		return findByProperty(CDJHJH, cdjhjh
		);
	}
	
	public List findByCdshsj(Object cdshsj
	) {
		return findByProperty(CDSHSJ, cdshsj
		);
	}
	
	public List findByCdshjh(Object cdshjh
	) {
		return findByProperty(CDSHJH, cdshjh
		);
	}
	
	public List findByCdjysj(Object cdjysj
	) {
		return findByProperty(CDJYSJ, cdjysj
		);
	}
	
	public List findByCdjyjh(Object cdjyjh
	) {
		return findByProperty(CDJYJH, cdjyjh
		);
	}
	
	public List findByWhzwsj(Object whzwsj
	) {
		return findByProperty(WHZWSJ, whzwsj
		);
	}
	
	public List findByWhzwjh(Object whzwjh
	) {
		return findByProperty(WHZWJH, whzwjh
		);
	}
	
	public List findByWhfzsj(Object whfzsj
	) {
		return findByProperty(WHFZSJ, whfzsj
		);
	}
	
	public List findByWhfzjh(Object whfzjh
	) {
		return findByProperty(WHFZJH, whfzjh
		);
	}
	
	public List findByWhwhsj(Object whwhsj
	) {
		return findByProperty(WHWHSJ, whwhsj
		);
	}
	
	public List findByWhwhjh(Object whwhjh
	) {
		return findByProperty(WHWHJH, whwhjh
		);
	}
	
	public List findByWhjhsj(Object whjhsj
	) {
		return findByProperty(WHJHSJ, whjhsj
		);
	}
	
	public List findByWhjhjh(Object whjhjh
	) {
		return findByProperty(WHJHJH, whjhjh
		);
	}
	
	public List findByWhshsj(Object whshsj
	) {
		return findByProperty(WHSHSJ, whshsj
		);
	}
	
	public List findByWhshjh(Object whshjh
	) {
		return findByProperty(WHSHJH, whshjh
		);
	}
	
	public List findByWhjysj(Object whjysj
	) {
		return findByProperty(WHJYSJ, whjysj
		);
	}
	
	public List findByWhjyjh(Object whjyjh
	) {
		return findByProperty(WHJYJH, whjyjh
		);
	}
	
	public List findByOperator(Object operator
	) {
		return findByProperty(OPERATOR, operator
		);
	}
	

	public List findAll() {
		log.debug("finding all Jhsx instances");
		try {
			String queryString = "from Jhsx";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Jhsx merge(Jhsx detachedInstance) {
        log.debug("merging Jhsx instance");
        try {
            Jhsx result = (Jhsx) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Jhsx instance) {
        log.debug("attaching dirty Jhsx instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Jhsx instance) {
        log.debug("attaching clean Jhsx instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public Jhsx findAllByDate(String date) {
		log.debug("finding all Jhsx instances");
		try {
			String queryString = "from Jhsx as j where j.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<Jhsx> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 Jhsx j = new Jhsx();
	        	 j.setDate(date);
	        	 return j;
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