package work.hndetail.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hndetail.pojo.HnNew;
import work.no.dao.NoDAO;
import work.no.pojo.No;

/**
 	* A data access object (DAO) providing persistence and search support for HnNew entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnNew
  * @author MyEclipse Persistence Tools 
 */

public class HnNewDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnNewDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NO = "no";
	public static final String NAME = "name";
	public static final String ZX = "zx";
	public static final String XZ = "xz";
	public static final String SX = "sx";
	public static final String POS = "pos";
	public static final String CL = "cl";
	public static final String CLRMB = "clrmb";
	public static final String CLWH = "clwh";
	public static final String CLJH = "cljh";
	public static final String CLSH = "clsh";
	public static final String CLJY = "cljy";
	public static final String CLFXQ = "clfxq";
	public static final String CCL = "ccl";
	public static final String CCLRMB_FZ = "cclrmbFz";
	public static final String CCLRMB_FM = "cclrmbFm";
	public static final String CCLRMB = "cclrmb";
	public static final String CCLWH_FZ = "cclwhFz";
	public static final String CCLWH_FM = "cclwhFm";
	public static final String CCLWH = "cclwh";
	public static final String CCLJH_FZ = "ccljhFz";
	public static final String CCLJH_FM = "ccljhFm";
	public static final String CCLJH = "ccljh";
	public static final String CCLSH_FZ = "cclshFz";
	public static final String CCLSH_FM = "cclshFm";
	public static final String CCLSH = "cclsh";
	public static final String CCLJY_FZ = "ccljyFz";
	public static final String CCLJY_FM = "ccljyFm";
	public static final String CCLJY = "ccljy";
	public static final String XL = "xl";
	public static final String XLRMB_FZ = "xlrmbFz";
	public static final String XLRMB_FM = "xlrmbFm";
	public static final String XLRMB = "xlrmb";
	public static final String XLWH_FZ = "xlwhFz";
	public static final String XLWH_FM = "xlwhFm";
	public static final String XLWH = "xlwh";
	public static final String XLJH_FZ = "xljhFz";
	public static final String XLJH_FM = "xljhFm";
	public static final String XLJH = "xljh";
	public static final String XLSH_FZ = "xlshFz";
	public static final String XLSH_FM = "xlshFm";
	public static final String XLSH = "xlsh";
	public static final String XLJY_FZ = "xljyFz";
	public static final String XLJY_FM = "xljyFm";
	public static final String XLJY = "xljy";
	public static final String TGLSH = "tglsh";
	public static final String SXRMB = "sxrmb";
	public static final String SXWH = "sxwh";
	public static final String SXJH = "sxjh";
	public static final String SXSH = "sxsh";
	public static final String SXJY = "sxjy";
	public static final String SXFXQ = "sxfxq";
	public static final String RJCL = "rjcl";
	public static final String RJCCL = "rjccl";
	public static final String RJXL = "rjxl";
	public static final String LJSX = "ljsx";



    
    public void save(HnNew transientInstance) {
        log.debug("saving HnNew instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnNew persistentInstance) {
        log.debug("deleting HnNew instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnNew findById( java.lang.Integer id) {
        log.debug("getting HnNew instance with id: " + id);
        try {
            HnNew instance = (HnNew) getSession()
                    .get("HnNew", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnNew instance) {
        log.debug("finding HnNew instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnNew")
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
      log.debug("finding HnNew instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnNew as model where model." 
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
	
	public List findByClrmb(Object clrmb
	) {
		return findByProperty(CLRMB, clrmb
		);
	}
	
	public List findByClwh(Object clwh
	) {
		return findByProperty(CLWH, clwh
		);
	}
	
	public List findByCljh(Object cljh
	) {
		return findByProperty(CLJH, cljh
		);
	}
	
	public List findByClsh(Object clsh
	) {
		return findByProperty(CLSH, clsh
		);
	}
	
	public List findByCljy(Object cljy
	) {
		return findByProperty(CLJY, cljy
		);
	}
	
	public List findByClfxq(Object clfxq
	) {
		return findByProperty(CLFXQ, clfxq
		);
	}
	
	public List findByCcl(Object ccl
	) {
		return findByProperty(CCL, ccl
		);
	}
	
	public List findByCclrmbFz(Object cclrmbFz
	) {
		return findByProperty(CCLRMB_FZ, cclrmbFz
		);
	}
	
	public List findByCclrmbFm(Object cclrmbFm
	) {
		return findByProperty(CCLRMB_FM, cclrmbFm
		);
	}
	
	public List findByCclrmb(Object cclrmb
	) {
		return findByProperty(CCLRMB, cclrmb
		);
	}
	
	public List findByCclwhFz(Object cclwhFz
	) {
		return findByProperty(CCLWH_FZ, cclwhFz
		);
	}
	
	public List findByCclwhFm(Object cclwhFm
	) {
		return findByProperty(CCLWH_FM, cclwhFm
		);
	}
	
	public List findByCclwh(Object cclwh
	) {
		return findByProperty(CCLWH, cclwh
		);
	}
	
	public List findByCcljhFz(Object ccljhFz
	) {
		return findByProperty(CCLJH_FZ, ccljhFz
		);
	}
	
	public List findByCcljhFm(Object ccljhFm
	) {
		return findByProperty(CCLJH_FM, ccljhFm
		);
	}
	
	public List findByCcljh(Object ccljh
	) {
		return findByProperty(CCLJH, ccljh
		);
	}
	
	public List findByCclshFz(Object cclshFz
	) {
		return findByProperty(CCLSH_FZ, cclshFz
		);
	}
	
	public List findByCclshFm(Object cclshFm
	) {
		return findByProperty(CCLSH_FM, cclshFm
		);
	}
	
	public List findByCclsh(Object cclsh
	) {
		return findByProperty(CCLSH, cclsh
		);
	}
	
	public List findByCcljyFz(Object ccljyFz
	) {
		return findByProperty(CCLJY_FZ, ccljyFz
		);
	}
	
	public List findByCcljyFm(Object ccljyFm
	) {
		return findByProperty(CCLJY_FM, ccljyFm
		);
	}
	
	public List findByCcljy(Object ccljy
	) {
		return findByProperty(CCLJY, ccljy
		);
	}
	
	public List findByXl(Object xl
	) {
		return findByProperty(XL, xl
		);
	}
	
	public List findByXlrmbFz(Object xlrmbFz
	) {
		return findByProperty(XLRMB_FZ, xlrmbFz
		);
	}
	
	public List findByXlrmbFm(Object xlrmbFm
	) {
		return findByProperty(XLRMB_FM, xlrmbFm
		);
	}
	
	public List findByXlrmb(Object xlrmb
	) {
		return findByProperty(XLRMB, xlrmb
		);
	}
	
	public List findByXlwhFz(Object xlwhFz
	) {
		return findByProperty(XLWH_FZ, xlwhFz
		);
	}
	
	public List findByXlwhFm(Object xlwhFm
	) {
		return findByProperty(XLWH_FM, xlwhFm
		);
	}
	
	public List findByXlwh(Object xlwh
	) {
		return findByProperty(XLWH, xlwh
		);
	}
	
	public List findByXljhFz(Object xljhFz
	) {
		return findByProperty(XLJH_FZ, xljhFz
		);
	}
	
	public List findByXljhFm(Object xljhFm
	) {
		return findByProperty(XLJH_FM, xljhFm
		);
	}
	
	public List findByXljh(Object xljh
	) {
		return findByProperty(XLJH, xljh
		);
	}
	
	public List findByXlshFz(Object xlshFz
	) {
		return findByProperty(XLSH_FZ, xlshFz
		);
	}
	
	public List findByXlshFm(Object xlshFm
	) {
		return findByProperty(XLSH_FM, xlshFm
		);
	}
	
	public List findByXlsh(Object xlsh
	) {
		return findByProperty(XLSH, xlsh
		);
	}
	
	public List findByXljyFz(Object xljyFz
	) {
		return findByProperty(XLJY_FZ, xljyFz
		);
	}
	
	public List findByXljyFm(Object xljyFm
	) {
		return findByProperty(XLJY_FM, xljyFm
		);
	}
	
	public List findByXljy(Object xljy
	) {
		return findByProperty(XLJY, xljy
		);
	}
	
	public List findByTglsh(Object tglsh
	) {
		return findByProperty(TGLSH, tglsh
		);
	}
	
	public List findBySxrmb(Object sxrmb
	) {
		return findByProperty(SXRMB, sxrmb
		);
	}
	
	public List findBySxwh(Object sxwh
	) {
		return findByProperty(SXWH, sxwh
		);
	}
	
	public List findBySxjh(Object sxjh
	) {
		return findByProperty(SXJH, sxjh
		);
	}
	
	public List findBySxsh(Object sxsh
	) {
		return findByProperty(SXSH, sxsh
		);
	}
	
	public List findBySxjy(Object sxjy
	) {
		return findByProperty(SXJY, sxjy
		);
	}
	
	public List findBySxfxq(Object sxfxq
	) {
		return findByProperty(SXFXQ, sxfxq
		);
	}
	
	public List findByRjcl(Object rjcl
	) {
		return findByProperty(RJCL, rjcl
		);
	}
	
	public List findByRjccl(Object rjccl
	) {
		return findByProperty(RJCCL, rjccl
		);
	}
	
	public List findByRjxl(Object rjxl
	) {
		return findByProperty(RJXL, rjxl
		);
	}
	
	public List findByLjsx(Object ljsx
	) {
		return findByProperty(LJSX, ljsx
		);
	}
	

	public List findAll() {
		log.debug("finding all HnNew instances");
		try {
			String queryString = "from HnNew";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnNew merge(HnNew detachedInstance) {
        log.debug("merging HnNew instance");
        try {
            HnNew result = (HnNew) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnNew instance) {
        log.debug("attaching dirty HnNew instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnNew instance) {
        log.debug("attaching clean HnNew instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public HnNew findAllByDateAndNo(String date,String no) {
    	log.debug("finding all HnNew instances");
    	try {
    		String pos = "";
    		NoDAO nodao = new NoDAO();
    		String queryString = "from HnNew as hn where hn.date='"+date+"' and hn.no='"+no+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 List listno = nodao.findBy891No(no);
    		 if(!listno.isEmpty())
    		 {
    			 pos = ((No)listno.get(0)).getPosition();
    		 }
    		 if(list.isEmpty())
    		 {
    			return new HnNew(date,no,"",0,0,0,pos,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,0,0,0,0,0,0.0,0.0,0.0,0); 
    		 }
    		 else
    		 {
    			 return (HnNew) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public HnNew findAllByDateAndName(String date,String name) {
    	log.debug("finding all HnNew instances");
    	try {
    		String queryString = "from HnNew as hn where hn.date='"+date+"' and hn.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			return new HnNew(date,"",name,0,0,0,"",0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,0,0,0,0,0,0.0,0.0,0.0,0); 
    		 }
    		 else
    		 {
    			 return (HnNew) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public String findMaxDate() {
    	log.debug("finding all HnNew instances");
    	try {
    		String sql = "select max(date) from t_hn_new";
    		Object obj = getSession().createSQLQuery(sql).uniqueResult();
    		if(obj==null)
    		{
    			return "";
    		}
    		else
    		{
    			return obj.toString();
    		}
    		 
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}