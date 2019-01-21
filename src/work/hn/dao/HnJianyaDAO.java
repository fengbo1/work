package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.HnJianya;

/**
 	* A data access object (DAO) providing persistence and search support for HnJianya entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnJianya
  * @author MyEclipse Persistence Tools 
 */

public class HnJianyaDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnJianyaDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NO = "no";
	public static final String NAME = "name";
	public static final String ZX = "zx";
	public static final String XZ = "xz";
	public static final String LRXG = "lrxg";
	public static final String LRSQ = "lrsq";
	public static final String JHXG = "jhxg";
	public static final String JHSQ = "jhsq";
	public static final String PJCS = "pjcs";
	public static final String PJFS = "pjfs";
	public static final String SBYY = "sbyy";
	public static final String XLLRXG = "xllrxg";
	public static final String XLLRSQ = "xllrsq";
	public static final String XLJHXG = "xljhxg";
	public static final String XLJHSQ = "xljhsq";
	public static final String XLPJCS = "xlpjcs";
	public static final String XLPJFS = "xlpjfs";
	public static final String XLSBYY = "xlsbyy";
	public static final String LRCC = "lrcc";
	public static final String LCLV = "lclv";
	public static final String JHCC = "jhcc";
	public static final String JCLV = "jclv";
	public static final String TP = "tp";
	public static final String TPLV = "tplv";
	public static final String CX = "cx";
	public static final String CXLV = "cxlv";
	public static final String ZHCL = "zhcl";
	public static final String YWL = "ywl";
	public static final String SUMXL = "sumxl";
	public static final String CCL = "ccl";
	public static final String PERCL = "percl";



    
    public void save(HnJianya transientInstance) {
        log.debug("saving HnJianya instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnJianya persistentInstance) {
        log.debug("deleting HnJianya instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnJianya findById( java.lang.Integer id) {
        log.debug("getting HnJianya instance with id: " + id);
        try {
            HnJianya instance = (HnJianya) getSession()
                    .get("HnJianya", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnJianya instance) {
        log.debug("finding HnJianya instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnJianya")
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
      log.debug("finding HnJianya instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnJianya as model where model." 
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
	
	public List findByNo(Object no
	) {
		return findByProperty(NO, no
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
	
	public List findByLrxg(Object lrxg
	) {
		return findByProperty(LRXG, lrxg
		);
	}
	
	public List findByLrsq(Object lrsq
	) {
		return findByProperty(LRSQ, lrsq
		);
	}
	
	public List findByJhxg(Object jhxg
	) {
		return findByProperty(JHXG, jhxg
		);
	}
	
	public List findByJhsq(Object jhsq
	) {
		return findByProperty(JHSQ, jhsq
		);
	}
	
	public List findByPjcs(Object pjcs
	) {
		return findByProperty(PJCS, pjcs
		);
	}
	
	public List findByPjfs(Object pjfs
	) {
		return findByProperty(PJFS, pjfs
		);
	}
	
	public List findBySbyy(Object sbyy
	) {
		return findByProperty(SBYY, sbyy
		);
	}
	
	public List findByXllrxg(Object xllrxg
	) {
		return findByProperty(XLLRXG, xllrxg
		);
	}
	
	public List findByXllrsq(Object xllrsq
	) {
		return findByProperty(XLLRSQ, xllrsq
		);
	}
	
	public List findByXljhxg(Object xljhxg
	) {
		return findByProperty(XLJHXG, xljhxg
		);
	}
	
	public List findByXljhsq(Object xljhsq
	) {
		return findByProperty(XLJHSQ, xljhsq
		);
	}
	
	public List findByXlpjcs(Object xlpjcs
	) {
		return findByProperty(XLPJCS, xlpjcs
		);
	}
	
	public List findByXlpjfs(Object xlpjfs
	) {
		return findByProperty(XLPJFS, xlpjfs
		);
	}
	
	public List findByXlsbyy(Object xlsbyy
	) {
		return findByProperty(XLSBYY, xlsbyy
		);
	}
	
	public List findByLrcc(Object lrcc
	) {
		return findByProperty(LRCC, lrcc
		);
	}
	
	public List findByLclv(Object lclv
	) {
		return findByProperty(LCLV, lclv
		);
	}
	
	public List findByJhcc(Object jhcc
	) {
		return findByProperty(JHCC, jhcc
		);
	}
	
	public List findByJclv(Object jclv
	) {
		return findByProperty(JCLV, jclv
		);
	}
	
	public List findByTp(Object tp
	) {
		return findByProperty(TP, tp
		);
	}
	
	public List findByTplv(Object tplv
	) {
		return findByProperty(TPLV, tplv
		);
	}
	
	public List findByCx(Object cx
	) {
		return findByProperty(CX, cx
		);
	}
	
	public List findByCxlv(Object cxlv
	) {
		return findByProperty(CXLV, cxlv
		);
	}
	
	public List findByZhcl(Object zhcl
	) {
		return findByProperty(ZHCL, zhcl
		);
	}
	
	public List findByYwl(Object ywl
	) {
		return findByProperty(YWL, ywl
		);
	}
	
	public List findBySumxl(Object sumxl
	) {
		return findByProperty(SUMXL, sumxl
		);
	}
	
	public List findByCcl(Object ccl
	) {
		return findByProperty(CCL, ccl
		);
	}
	
	public List findByPercl(Object percl
	) {
		return findByProperty(PERCL, percl
		);
	}
	

	public List findAll() {
		log.debug("finding all HnJianya instances");
		try {
			String queryString = "from HnJianya";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnJianya merge(HnJianya detachedInstance) {
        log.debug("merging HnJianya instance");
        try {
            HnJianya result = (HnJianya) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnJianya instance) {
        log.debug("attaching dirty HnJianya instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnJianya instance) {
        log.debug("attaching clean HnJianya instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllByDate(String date) {
		log.debug("finding all HnJianya instances");
		try {
			String queryString = "from HnJianya as jy where jy.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public HnJianya findAllByDateAndNo(String date,String no) {
		log.debug("finding all HnJianya instances");
		try {
			String queryString = "from HnJianya as jy where jy.date='"+date+"' and jy.no='"+no+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return new HnJianya();
			 }
			 else
			 {
				 return (HnJianya) list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public HnJianya findAllByDateAndNameNull(String date,String name) {
		log.debug("finding all HnJianya instances");
		try {
			String queryString = "from HnJianya as jy where jy.date='"+date+"' and jy.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				 return (HnJianya) list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}