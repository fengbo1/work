package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.HnJihe;

/**
 	* A data access object (DAO) providing persistence and search support for HnJihe entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnJihe
  * @author MyEclipse Persistence Tools 
 */

public class HnJiheDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnJiheDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NEWNUMBER = "newnumber";
	public static final String NAME = "name";
	public static final String ZX = "zx";
	public static final String XZ = "xz";
	public static final String SX = "sx";
	public static final String POS = "pos";
	public static final String CL = "cl";
	public static final String ROLE = "role";
	public static final String YWL = "ywl";
	public static final String HDLZJ = "hdlzj";
	public static final String HDLJH = "hdljh";
	public static final String FXXZJ = "fxxzj";
	public static final String FXXJH = "fxxjh";
	public static final String FB_YS = "fbYs";
	public static final String FB_JY = "fbJy";
	public static final String FB_GF = "fbGf";
	public static final String FB_YB = "fbYb";
	public static final String FB_ZD = "fbZd";
	public static final String SH_YS = "shYs";
	public static final String SH_JY = "shJy";
	public static final String SH_GF = "shGf";
	public static final String SH_YB = "shYb";
	public static final String SH_ZD = "shZd";
	public static final String ZJ_YS = "zjYs";
	public static final String ZJ_JY = "zjJy";
	public static final String ZJ_GF = "zjGf";
	public static final String ZJ_YB = "zjYb";
	public static final String ZJ_ZD = "zjZd";
	public static final String REMARK = "remark";



    
    public void save(HnJihe transientInstance) {
        log.debug("saving HnJihe instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnJihe persistentInstance) {
        log.debug("deleting HnJihe instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnJihe findById( java.lang.Integer id) {
        log.debug("getting HnJihe instance with id: " + id);
        try {
            HnJihe instance = (HnJihe) getSession()
                    .get("HnJihe", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnJihe instance) {
        log.debug("finding HnJihe instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnJihe")
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
      log.debug("finding HnJihe instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnJihe as model where model." 
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
	
	public List findByRole(Object role
	) {
		return findByProperty(ROLE, role
		);
	}
	
	public List findByYwl(Object ywl
	) {
		return findByProperty(YWL, ywl
		);
	}
	
	public List findByHdlzj(Object hdlzj
	) {
		return findByProperty(HDLZJ, hdlzj
		);
	}
	
	public List findByHdljh(Object hdljh
	) {
		return findByProperty(HDLJH, hdljh
		);
	}
	
	public List findByFxxzj(Object fxxzj
	) {
		return findByProperty(FXXZJ, fxxzj
		);
	}
	
	public List findByFxxjh(Object fxxjh
	) {
		return findByProperty(FXXJH, fxxjh
		);
	}
	
	public List findByFbYs(Object fbYs
	) {
		return findByProperty(FB_YS, fbYs
		);
	}
	
	public List findByFbJy(Object fbJy
	) {
		return findByProperty(FB_JY, fbJy
		);
	}
	
	public List findByFbGf(Object fbGf
	) {
		return findByProperty(FB_GF, fbGf
		);
	}
	
	public List findByFbYb(Object fbYb
	) {
		return findByProperty(FB_YB, fbYb
		);
	}
	
	public List findByFbZd(Object fbZd
	) {
		return findByProperty(FB_ZD, fbZd
		);
	}
	
	public List findByShYs(Object shYs
	) {
		return findByProperty(SH_YS, shYs
		);
	}
	
	public List findByShJy(Object shJy
	) {
		return findByProperty(SH_JY, shJy
		);
	}
	
	public List findByShGf(Object shGf
	) {
		return findByProperty(SH_GF, shGf
		);
	}
	
	public List findByShYb(Object shYb
	) {
		return findByProperty(SH_YB, shYb
		);
	}
	
	public List findByShZd(Object shZd
	) {
		return findByProperty(SH_ZD, shZd
		);
	}
	
	public List findByZjYs(Object zjYs
	) {
		return findByProperty(ZJ_YS, zjYs
		);
	}
	
	public List findByZjJy(Object zjJy
	) {
		return findByProperty(ZJ_JY, zjJy
		);
	}
	
	public List findByZjGf(Object zjGf
	) {
		return findByProperty(ZJ_GF, zjGf
		);
	}
	
	public List findByZjYb(Object zjYb
	) {
		return findByProperty(ZJ_YB, zjYb
		);
	}
	
	public List findByZjZd(Object zjZd
	) {
		return findByProperty(ZJ_ZD, zjZd
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all HnJihe instances");
		try {
			String queryString = "from HnJihe";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnJihe merge(HnJihe detachedInstance) {
        log.debug("merging HnJihe instance");
        try {
            HnJihe result = (HnJihe) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnJihe instance) {
        log.debug("attaching dirty HnJihe instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnJihe instance) {
        log.debug("attaching clean HnJihe instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public List findAllByDate(String date) {
		log.debug("finding all HnJihe instances");
		try {
			String queryString = "from HnJihe as jh where jh.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public HnJihe findAllByDateAndNo(String date,String no) {
		log.debug("finding all HnJihe instances");
		try {
			String queryString = "from HnJihe as jh where jh.date='"+date+"' and jh.newnumber='"+no+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return new HnJihe(date, no, "", 0, 0, 0, "", 0.0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	         }
	         else
	         {
	        	 return (HnJihe) list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public HnJihe findAllByDateAndNameNull(String date,String name) {
		log.debug("finding all HnJihe instances");
		try {
			String queryString = "from HnJihe as jh where jh.date='"+date+"' and jh.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	 return (HnJihe) list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public HnJihe findAllByDateAndName(String date,String name) {
		log.debug("finding all HnJihe instances");
		try {
			String queryString = "from HnJihe as jh where jh.date='"+date+"' and jh.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return new HnJihe();
	         }
	         else
	         {
	        	 return (HnJihe) list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}