package work.hndetail.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hndetail.pojo.HndetailLs;

/**
 	* A data access object (DAO) providing persistence and search support for HndetailLs entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HndetailLs
  * @author MyEclipse Persistence Tools 
 */

public class HndetailLsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HndetailLsDAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String NO = "no";
	public static final String NAME = "name";
	public static final String ZX = "zx";
	public static final String XZ = "xz";
	public static final String TEAM = "team";
	public static final String LRXG = "lrxg";
	public static final String XL_LRXG = "xlLrxg";
	public static final String LJLRSC = "ljlrsc";
	public static final String LRSQ = "lrsq";
	public static final String XL_LRSQ = "xlLrsq";
	public static final String JHXG = "jhxg";
	public static final String XL_JHXG = "xlJhxg";
	public static final String JHSQ = "jhsq";
	public static final String XL_JHSQ = "xlJhsq";
	public static final String LJLR = "ljlr";
	public static final String LJJH = "ljjh";
	public static final String LJLR895 = "ljlr895";
	public static final String LJJH895 = "ljjh895";
	public static final String TP = "tp";
	public static final String LJTP = "ljtp";
	public static final String LRCC = "lrcc";
	public static final String JHCC = "jhcc";
	public static final String CX = "cx";
	public static final String LJCX = "ljcx";
	public static final String OUTPUT891 = "output891";
	public static final String OUTPUT895 = "output895";
	public static final String OUTPUT = "output";
	public static final String CCL891 = "ccl891";
	public static final String CXL891 = "cxl891";
	public static final String TPL891 = "tpl891";
	public static final String CCL895 = "ccl895";
	public static final String CXL895 = "cxl895";
	public static final String TPL895 = "tpl895";
	public static final String LJCL = "ljcl";
	public static final String LJYWL891 = "ljywl891";
	public static final String LJYWL895 = "ljywl895";
	public static final String LJRJCL = "ljrjcl";
	public static final String RJCLWCL = "rjclwcl";
	public static final String LJLRCC = "ljlrcc";
	public static final String LJJHCC = "ljjhcc";
	public static final String RJCCL891 = "rjccl891";
	public static final String RJCXL891 = "rjcxl891";
	public static final String RJTPL891 = "rjtpl891";
	public static final String RJCCL895 = "rjccl895";
	public static final String RJCXL895 = "rjcxl895";
	public static final String RJTPL895 = "rjtpl895";
	public static final String LJSXTS = "ljsxts";
	public static final String ONLINE = "online";
	public static final String ZYZL = "zyzl";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String REMARK4 = "remark4";
	public static final String REMARK5 = "remark5";
	public static final String QDLR = "qdlr";
	public static final String QDLRZ = "qdlrz";
	public static final String LJQDLR = "ljqdlr";
	public static final String LJQDLRZ = "ljqdlrz";
	public static final String QDLRZL = "qdlrzl";
	public static final String LJQDLRZL = "ljqdlrzl";
	public static final String PERCLTIME = "percltime";
	public static final String ZYCCL = "zyccl";



    
    public void save(HndetailLs transientInstance) {
        log.debug("saving HndetailLs instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HndetailLs persistentInstance) {
        log.debug("deleting HndetailLs instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HndetailLs findById( java.lang.Integer id) {
        log.debug("getting HndetailLs instance with id: " + id);
        try {
            HndetailLs instance = (HndetailLs) getSession()
                    .get("HndetailLs", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HndetailLs instance) {
        log.debug("finding HndetailLs instance by example");
        try {
            List results = getSession()
                    .createCriteria("HndetailLs")
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
      log.debug("finding HndetailLs instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HndetailLs as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
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
	
	public List findByTeam(Object team
	) {
		return findByProperty(TEAM, team
		);
	}
	
	public List findByLrxg(Object lrxg
	) {
		return findByProperty(LRXG, lrxg
		);
	}
	
	public List findByXlLrxg(Object xlLrxg
	) {
		return findByProperty(XL_LRXG, xlLrxg
		);
	}
	
	public List findByLjlrsc(Object ljlrsc
	) {
		return findByProperty(LJLRSC, ljlrsc
		);
	}
	
	public List findByLrsq(Object lrsq
	) {
		return findByProperty(LRSQ, lrsq
		);
	}
	
	public List findByXlLrsq(Object xlLrsq
	) {
		return findByProperty(XL_LRSQ, xlLrsq
		);
	}
	
	public List findByJhxg(Object jhxg
	) {
		return findByProperty(JHXG, jhxg
		);
	}
	
	public List findByXlJhxg(Object xlJhxg
	) {
		return findByProperty(XL_JHXG, xlJhxg
		);
	}
	
	public List findByJhsq(Object jhsq
	) {
		return findByProperty(JHSQ, jhsq
		);
	}
	
	public List findByXlJhsq(Object xlJhsq
	) {
		return findByProperty(XL_JHSQ, xlJhsq
		);
	}
	
	public List findByLjlr(Object ljlr
	) {
		return findByProperty(LJLR, ljlr
		);
	}
	
	public List findByLjjh(Object ljjh
	) {
		return findByProperty(LJJH, ljjh
		);
	}
	
	public List findByLjlr895(Object ljlr895
	) {
		return findByProperty(LJLR895, ljlr895
		);
	}
	
	public List findByLjjh895(Object ljjh895
	) {
		return findByProperty(LJJH895, ljjh895
		);
	}
	
	public List findByTp(Object tp
	) {
		return findByProperty(TP, tp
		);
	}
	
	public List findByLjtp(Object ljtp
	) {
		return findByProperty(LJTP, ljtp
		);
	}
	
	public List findByLrcc(Object lrcc
	) {
		return findByProperty(LRCC, lrcc
		);
	}
	
	public List findByJhcc(Object jhcc
	) {
		return findByProperty(JHCC, jhcc
		);
	}
	
	public List findByCx(Object cx
	) {
		return findByProperty(CX, cx
		);
	}
	
	public List findByLjcx(Object ljcx
	) {
		return findByProperty(LJCX, ljcx
		);
	}
	
	public List findByOutput891(Object output891
	) {
		return findByProperty(OUTPUT891, output891
		);
	}
	
	public List findByOutput895(Object output895
	) {
		return findByProperty(OUTPUT895, output895
		);
	}
	
	public List findByOutput(Object output
	) {
		return findByProperty(OUTPUT, output
		);
	}
	
	public List findByCcl891(Object ccl891
	) {
		return findByProperty(CCL891, ccl891
		);
	}
	
	public List findByCxl891(Object cxl891
	) {
		return findByProperty(CXL891, cxl891
		);
	}
	
	public List findByTpl891(Object tpl891
	) {
		return findByProperty(TPL891, tpl891
		);
	}
	
	public List findByCcl895(Object ccl895
	) {
		return findByProperty(CCL895, ccl895
		);
	}
	
	public List findByCxl895(Object cxl895
	) {
		return findByProperty(CXL895, cxl895
		);
	}
	
	public List findByTpl895(Object tpl895
	) {
		return findByProperty(TPL895, tpl895
		);
	}
	
	public List findByLjcl(Object ljcl
	) {
		return findByProperty(LJCL, ljcl
		);
	}
	
	public List findByLjywl891(Object ljywl891
	) {
		return findByProperty(LJYWL891, ljywl891
		);
	}
	
	public List findByLjywl895(Object ljywl895
	) {
		return findByProperty(LJYWL895, ljywl895
		);
	}
	
	public List findByLjrjcl(Object ljrjcl
	) {
		return findByProperty(LJRJCL, ljrjcl
		);
	}
	
	public List findByRjclwcl(Object rjclwcl
	) {
		return findByProperty(RJCLWCL, rjclwcl
		);
	}
	
	public List findByLjlrcc(Object ljlrcc
	) {
		return findByProperty(LJLRCC, ljlrcc
		);
	}
	
	public List findByLjjhcc(Object ljjhcc
	) {
		return findByProperty(LJJHCC, ljjhcc
		);
	}
	
	public List findByRjccl891(Object rjccl891
	) {
		return findByProperty(RJCCL891, rjccl891
		);
	}
	
	public List findByRjcxl891(Object rjcxl891
	) {
		return findByProperty(RJCXL891, rjcxl891
		);
	}
	
	public List findByRjtpl891(Object rjtpl891
	) {
		return findByProperty(RJTPL891, rjtpl891
		);
	}
	
	public List findByRjccl895(Object rjccl895
	) {
		return findByProperty(RJCCL895, rjccl895
		);
	}
	
	public List findByRjcxl895(Object rjcxl895
	) {
		return findByProperty(RJCXL895, rjcxl895
		);
	}
	
	public List findByRjtpl895(Object rjtpl895
	) {
		return findByProperty(RJTPL895, rjtpl895
		);
	}
	
	public List findByLjsxts(Object ljsxts
	) {
		return findByProperty(LJSXTS, ljsxts
		);
	}
	
	public List findByOnline(Object online
	) {
		return findByProperty(ONLINE, online
		);
	}
	
	public List findByZyzl(Object zyzl
	) {
		return findByProperty(ZYZL, zyzl
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
	
	public List findByQdlr(Object qdlr
	) {
		return findByProperty(QDLR, qdlr
		);
	}
	
	public List findByQdlrz(Object qdlrz
	) {
		return findByProperty(QDLRZ, qdlrz
		);
	}
	
	public List findByLjqdlr(Object ljqdlr
	) {
		return findByProperty(LJQDLR, ljqdlr
		);
	}
	
	public List findByLjqdlrz(Object ljqdlrz
	) {
		return findByProperty(LJQDLRZ, ljqdlrz
		);
	}
	
	public List findByQdlrzl(Object qdlrzl
	) {
		return findByProperty(QDLRZL, qdlrzl
		);
	}
	
	public List findByLjqdlrzl(Object ljqdlrzl
	) {
		return findByProperty(LJQDLRZL, ljqdlrzl
		);
	}
	
	public List findByPercltime(Object percltime
	) {
		return findByProperty(PERCLTIME, percltime
		);
	}
	
	public List findByZyccl(Object zyccl
	) {
		return findByProperty(ZYCCL, zyccl
		);
	}
	

	public List findAll() {
		log.debug("finding all HndetailLs instances");
		try {
			String queryString = "from HndetailLs";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HndetailLs merge(HndetailLs detachedInstance) {
        log.debug("merging HndetailLs instance");
        try {
            HndetailLs result = (HndetailLs) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HndetailLs instance) {
        log.debug("attaching dirty HndetailLs instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HndetailLs instance) {
        log.debug("attaching clean HndetailLs instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllByDate(String date) {
    	log.debug("finding all HndetailLs instances");
    	try {
    		String queryString = "from HndetailLs as ls where ls.time='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}