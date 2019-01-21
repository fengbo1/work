package work.ygxy.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.ygxy.pojo.YgxyQuarter;

/**
 	* A data access object (DAO) providing persistence and search support for YgxyQuarter entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .YgxyQuarter
  * @author MyEclipse Persistence Tools 
 */

public class YgxyQuarterDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(YgxyQuarterDAO.class);
		//property constants
	public static final String YEAR = "year";
	public static final String QUARTER = "quarter";
	public static final String NAME = "name";
	public static final String POSITION = "position";
	public static final String GZSC = "gzsc";
	public static final String LXSC = "lxsc";
	public static final String ZYSC = "zysc";
	public static final String GDL = "gdl";
	public static final String XYQQZSL = "xyqqzsl";
	public static final String FTCLZSC = "ftclzsc";
	public static final String FTYDDH = "ftyddh";
	public static final String FTPJCLSC = "ftpjclsc";
	public static final String FECLZSC = "feclzsc";
	public static final String FEJSL = "fejsl";
	public static final String FEPJCLSC = "fepjclsc";
	public static final String STECLZSC = "steclzsc";
	public static final String STEJSL = "stejsl";
	public static final String STEPJCLSC = "stepjclsc";
	public static final String ZJZF = "zjzf";
	public static final String ZJTS = "zjts";
	public static final String ZJDF = "zjdf";



    
    public void save(YgxyQuarter transientInstance) {
        log.debug("saving YgxyQuarter instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(YgxyQuarter persistentInstance) {
        log.debug("deleting YgxyQuarter instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public YgxyQuarter findById( java.lang.Integer id) {
        log.debug("getting YgxyQuarter instance with id: " + id);
        try {
            YgxyQuarter instance = (YgxyQuarter) getSession()
                    .get("YgxyQuarter", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(YgxyQuarter instance) {
        log.debug("finding YgxyQuarter instance by example");
        try {
            List results = getSession()
                    .createCriteria("YgxyQuarter")
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
      log.debug("finding YgxyQuarter instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from YgxyQuarter as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
		);
	}
	
	public List findByQuarter(Object quarter
	) {
		return findByProperty(QUARTER, quarter
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByGzsc(Object gzsc
	) {
		return findByProperty(GZSC, gzsc
		);
	}
	
	public List findByLxsc(Object lxsc
	) {
		return findByProperty(LXSC, lxsc
		);
	}
	
	public List findByZysc(Object zysc
	) {
		return findByProperty(ZYSC, zysc
		);
	}
	
	public List findByGdl(Object gdl
	) {
		return findByProperty(GDL, gdl
		);
	}
	
	public List findByXyqqzsl(Object xyqqzsl
	) {
		return findByProperty(XYQQZSL, xyqqzsl
		);
	}
	
	public List findByFtclzsc(Object ftclzsc
	) {
		return findByProperty(FTCLZSC, ftclzsc
		);
	}
	
	public List findByFtyddh(Object ftyddh
	) {
		return findByProperty(FTYDDH, ftyddh
		);
	}
	
	public List findByFtpjclsc(Object ftpjclsc
	) {
		return findByProperty(FTPJCLSC, ftpjclsc
		);
	}
	
	public List findByFeclzsc(Object feclzsc
	) {
		return findByProperty(FECLZSC, feclzsc
		);
	}
	
	public List findByFejsl(Object fejsl
	) {
		return findByProperty(FEJSL, fejsl
		);
	}
	
	public List findByFepjclsc(Object fepjclsc
	) {
		return findByProperty(FEPJCLSC, fepjclsc
		);
	}
	
	public List findBySteclzsc(Object steclzsc
	) {
		return findByProperty(STECLZSC, steclzsc
		);
	}
	
	public List findByStejsl(Object stejsl
	) {
		return findByProperty(STEJSL, stejsl
		);
	}
	
	public List findByStepjclsc(Object stepjclsc
	) {
		return findByProperty(STEPJCLSC, stepjclsc
		);
	}
	
	public List findByZjzf(Object zjzf
	) {
		return findByProperty(ZJZF, zjzf
		);
	}
	
	public List findByZjts(Object zjts
	) {
		return findByProperty(ZJTS, zjts
		);
	}
	
	public List findByZjdf(Object zjdf
	) {
		return findByProperty(ZJDF, zjdf
		);
	}
	

	public List findAll() {
		log.debug("finding all YgxyQuarter instances");
		try {
			String queryString = "from YgxyQuarter";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public YgxyQuarter merge(YgxyQuarter detachedInstance) {
        log.debug("merging YgxyQuarter instance");
        try {
            YgxyQuarter result = (YgxyQuarter) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(YgxyQuarter instance) {
        log.debug("attaching dirty YgxyQuarter instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(YgxyQuarter instance) {
        log.debug("attaching clean YgxyQuarter instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}