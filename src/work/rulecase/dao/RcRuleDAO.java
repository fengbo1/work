package work.rulecase.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.rulecase.pojo.RcRule;

/**
 	* A data access object (DAO) providing persistence and search support for RcRule entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .RcRule
  * @author MyEclipse Persistence Tools 
 */

public class RcRuleDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(RcRuleDAO.class);
		//property constants
	public static final String RENEWDATE = "renewdate";
	public static final String PLATE = "plate";
	public static final String POOL = "pool";
	public static final String PART = "part";
	public static final String AREA = "area";
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
	public static final String FUJIAN = "fujian";



    
    public void save(RcRule transientInstance) {
        log.debug("saving RcRule instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RcRule persistentInstance) {
        log.debug("deleting RcRule instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RcRule findById( java.lang.Integer id) {
        log.debug("getting RcRule instance with id: " + id);
        try {
            RcRule instance = (RcRule) getSession()
                    .get("RcRule", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(RcRule instance) {
        log.debug("finding RcRule instance by example");
        try {
            List results = getSession()
                    .createCriteria("RcRule")
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
      log.debug("finding RcRule instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RcRule as model where model." 
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
	
	public List findByArea(Object area
	) {
		return findByProperty(AREA, area
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
	
	public List findByFujian(Object fujian
	) {
		return findByProperty(FUJIAN, fujian
		);
	}
	

	public List findAll() {
		log.debug("finding all RcRule instances");
		try {
			String queryString = "from RcRule";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RcRule merge(RcRule detachedInstance) {
        log.debug("merging RcRule instance");
        try {
            RcRule result = (RcRule) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RcRule instance) {
        log.debug("attaching dirty RcRule instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RcRule instance) {
        log.debug("attaching clean RcRule instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
	public RcRule findAllById(int id) {
		log.debug("finding all RcRule instances");
		try {
			String queryString = "from RcRule where id='"+id+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<RcRule> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
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