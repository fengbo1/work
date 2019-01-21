package work.rulecase.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.rulecase.pojo.RcCase;

/**
 	* A data access object (DAO) providing persistence and search support for RcCase entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .RcCase
  * @author MyEclipse Persistence Tools 
 */

public class RcCaseDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(RcCaseDAO.class);
		//property constants
	public static final String RENEWDATE = "renewdate";
	public static final String PLATE = "plate";
	public static final String POOL = "pool";
	public static final String PART = "part";
	public static final String FACTOR = "factor";
	public static final String FAC_ANAME = "facAName";
	public static final String FAC_BNAME = "facBName";
	public static final String FAC_CNAME = "facCName";
	public static final String FAC_A = "facA";
	public static final String FAC_B = "facB";
	public static final String FAC_C = "facC";
	public static final String PICNAME = "picname";
	public static final String RULE = "rule";
	public static final String EXP = "exp";
	public static final String RENEWEXP = "renewexp";
	public static final String REMARK = "remark";



    
    public void save(RcCase transientInstance) {
        log.debug("saving RcCase instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RcCase persistentInstance) {
        log.debug("deleting RcCase instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RcCase findById( java.lang.Integer id) {
        log.debug("getting RcCase instance with id: " + id);
        try {
            RcCase instance = (RcCase) getSession()
                    .get("RcCase", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(RcCase instance) {
        log.debug("finding RcCase instance by example");
        try {
            List results = getSession()
                    .createCriteria("RcCase")
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
      log.debug("finding RcCase instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RcCase as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRenewdate(Object renewdate
	) {
		return findByProperty(RENEWDATE, renewdate
		);
	}
	
	public List findByPlate(Object plate
	) {
		return findByProperty(PLATE, plate
		);
	}
	
	public List findByPool(Object pool
	) {
		return findByProperty(POOL, pool
		);
	}
	
	public List findByPart(Object part
	) {
		return findByProperty(PART, part
		);
	}
	
	public List findByFactor(Object factor
	) {
		return findByProperty(FACTOR, factor
		);
	}
	
	public List findByFacAName(Object facAName
	) {
		return findByProperty(FAC_ANAME, facAName
		);
	}
	
	public List findByFacBName(Object facBName
	) {
		return findByProperty(FAC_BNAME, facBName
		);
	}
	
	public List findByFacCName(Object facCName
	) {
		return findByProperty(FAC_CNAME, facCName
		);
	}
	
	public List findByFacA(Object facA
	) {
		return findByProperty(FAC_A, facA
		);
	}
	
	public List findByFacB(Object facB
	) {
		return findByProperty(FAC_B, facB
		);
	}
	
	public List findByFacC(Object facC
	) {
		return findByProperty(FAC_C, facC
		);
	}
	
	public List findByPicname(Object picname
	) {
		return findByProperty(PICNAME, picname
		);
	}
	
	public List findByRule(Object rule
	) {
		return findByProperty(RULE, rule
		);
	}
	
	public List findByExp(Object exp
	) {
		return findByProperty(EXP, exp
		);
	}
	
	public List findByRenewexp(Object renewexp
	) {
		return findByProperty(RENEWEXP, renewexp
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all RcCase instances");
		try {
			String queryString = "from RcCase";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RcCase merge(RcCase detachedInstance) {
        log.debug("merging RcCase instance");
        try {
            RcCase result = (RcCase) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RcCase instance) {
        log.debug("attaching dirty RcCase instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RcCase instance) {
        log.debug("attaching clean RcCase instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}