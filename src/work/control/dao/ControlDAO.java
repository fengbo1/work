package work.control.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import ccb.hibernate.HibernateSessionFactory;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.control.pojo.Control;

/**
 	* A data access object (DAO) providing persistence and search support for Control entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Control
  * @author MyEclipse Persistence Tools 
 */

public class ControlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ControlDAO.class);
		//property constants
	public static final String _KBMSB891 = "KBmsb891";
	public static final String _KYXCF891 = "KYxcf891";
	public static final String _KLRXG891 = "KLrxg891";
	public static final String _KLRSQ891 = "KLrsq891";
	public static final String _KJHXG891 = "KJhxg891";
	public static final String _KJHSQ891 = "KJhsq891";
	public static final String _KSBYY891 = "KSbyy891";
	public static final String _KYXBZ891 = "KYxbz891";
	public static final String _KCSLR891 = "KCslr891";
	public static final String _KZYFS891 = "KZyfs891";
	public static final String _KBMSB895 = "KBmsb895";
	public static final String _KYXCF895 = "KYxcf895";
	public static final String _KLRXG895 = "KLrxg895";
	public static final String _KLRSQ895 = "KLrsq895";
	public static final String _KJHXG895 = "KJhxg895";
	public static final String _KJHSQ895 = "KJhsq895";
	public static final String _KSBYY895 = "KSbyy895";
	public static final String _KXYKY895 = "KXyky895";
	public static final String _FDATE = "FDate";
	public static final String T891 = "t891";
	public static final String T895 = "t895";
	public static final String _TOUTPUT = "TOutput";
	public static final String ZL_YJ = "zlYj";
	public static final String CL_ZB_LOW = "clZbLow";
	public static final String CL_ZB_HIGH = "clZbHigh";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String REMARK4 = "remark4";
	public static final String REMARK5 = "remark5";
	public static final String REMARK6 = "remark6";

	/**
	 * updateTime更新时间
	 * @param input
	 * @return
	 */
	public String updateTime(String input)
	{
		  Session session = HibernateSessionFactory.getSession();
	        Transaction trans=session.beginTransaction();
	      try {
	         String queryString = "update Control as model set model.FDate='"+input+"'";
	         session.createQuery(queryString).executeUpdate();
			 return "success";
	      } catch (RuntimeException re) {
	         throw re;
	      }finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}

    
    public void save(Control transientInstance) {
        log.debug("saving Control instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Control persistentInstance) {
        log.debug("deleting Control instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Control findById( java.lang.Integer id) {
        log.debug("getting Control instance with id: " + id);
        try {
            Control instance = (Control) getSession()
                    .get("Control", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Control instance) {
        log.debug("finding Control instance by example");
        try {
            List results = getSession()
                    .createCriteria("Control")
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
      log.debug("finding Control instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Control as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByKBmsb891(Object KBmsb891
	) {
		return findByProperty(_KBMSB891, KBmsb891
		);
	}
	
	public List findByKYxcf891(Object KYxcf891
	) {
		return findByProperty(_KYXCF891, KYxcf891
		);
	}
	
	public List findByKLrxg891(Object KLrxg891
	) {
		return findByProperty(_KLRXG891, KLrxg891
		);
	}
	
	public List findByKLrsq891(Object KLrsq891
	) {
		return findByProperty(_KLRSQ891, KLrsq891
		);
	}
	
	public List findByKJhxg891(Object KJhxg891
	) {
		return findByProperty(_KJHXG891, KJhxg891
		);
	}
	
	public List findByKJhsq891(Object KJhsq891
	) {
		return findByProperty(_KJHSQ891, KJhsq891
		);
	}
	
	public List findByKSbyy891(Object KSbyy891
	) {
		return findByProperty(_KSBYY891, KSbyy891
		);
	}
	
	public List findByKYxbz891(Object KYxbz891
	) {
		return findByProperty(_KYXBZ891, KYxbz891
		);
	}
	
	public List findByKCslr891(Object KCslr891
	) {
		return findByProperty(_KCSLR891, KCslr891
		);
	}
	
	public List findByKZyfs891(Object KZyfs891
	) {
		return findByProperty(_KZYFS891, KZyfs891
		);
	}
	
	public List findByKBmsb895(Object KBmsb895
	) {
		return findByProperty(_KBMSB895, KBmsb895
		);
	}
	
	public List findByKYxcf895(Object KYxcf895
	) {
		return findByProperty(_KYXCF895, KYxcf895
		);
	}
	
	public List findByKLrxg895(Object KLrxg895
	) {
		return findByProperty(_KLRXG895, KLrxg895
		);
	}
	
	public List findByKLrsq895(Object KLrsq895
	) {
		return findByProperty(_KLRSQ895, KLrsq895
		);
	}
	
	public List findByKJhxg895(Object KJhxg895
	) {
		return findByProperty(_KJHXG895, KJhxg895
		);
	}
	
	public List findByKJhsq895(Object KJhsq895
	) {
		return findByProperty(_KJHSQ895, KJhsq895
		);
	}
	
	public List findByKSbyy895(Object KSbyy895
	) {
		return findByProperty(_KSBYY895, KSbyy895
		);
	}
	
	public List findByKXyky895(Object KXyky895
	) {
		return findByProperty(_KXYKY895, KXyky895
		);
	}
	
	public List findByFDate(Object FDate
	) {
		return findByProperty(_FDATE, FDate
		);
	}
	
	public List findByT891(Object t891
	) {
		return findByProperty(T891, t891
		);
	}
	
	public List findByT895(Object t895
	) {
		return findByProperty(T895, t895
		);
	}
	
	public List findByTOutput(Object TOutput
	) {
		return findByProperty(_TOUTPUT, TOutput
		);
	}
	
	public List findByZlYj(Object zlYj
	) {
		return findByProperty(ZL_YJ, zlYj
		);
	}
	
	public List findByClZbLow(Object clZbLow
	) {
		return findByProperty(CL_ZB_LOW, clZbLow
		);
	}
	
	public List findByClZbHigh(Object clZbHigh
	) {
		return findByProperty(CL_ZB_HIGH, clZbHigh
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
	
	public List findByRemark6(Object remark6
	) {
		return findByProperty(REMARK6, remark6
		);
	}
	

	public List findAll() {
		log.debug("finding all Control instances");
		try {
			String queryString = "from Control";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Control merge(Control detachedInstance) {
        log.debug("merging Control instance");
        try {
            Control result = (Control) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Control instance) {
        log.debug("attaching dirty Control instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Control instance) {
        log.debug("attaching clean Control instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}