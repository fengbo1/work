package work.hndetail.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hndetail.pojo.HdTemp;

/**
 	* A data access object (DAO) providing persistence and search support for HdTemp entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HdTemp
  * @author MyEclipse Persistence Tools 
 */

public class HdTempDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HdTempDAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String NO = "no";
	public static final String TEAM = "team";
	public static final String LJLRSC = "ljlrsc";
	public static final String LRXG891 = "lrxg891";
	public static final String JHXG891 = "jhxg891";
	public static final String LRCC891 = "lrcc891";
	public static final String JHCC891 = "jhcc891";
	public static final String CX891 = "cx891";
	public static final String TP891 = "tp891";
	public static final String SUMXL891 = "sumxl891";
	public static final String YWL891 = "ywl891";
	public static final String OUTPUT891 = "output891";
	public static final String LRXG895 = "lrxg895";
	public static final String JHXG895 = "jhxg895";
	public static final String LRCC895 = "lrcc895";
	public static final String JHCC895 = "jhcc895";
	public static final String CX895 = "cx895";
	public static final String TP895 = "tp895";
	public static final String SUMXL895 = "sumxl895";
	public static final String YWL895 = "ywl895";
	public static final String OUTPUT895 = "output895";
	public static final String LJLR891 = "ljlr891";
	public static final String LJJH891 = "ljjh891";
	public static final String LJTP891 = "ljtp891";
	public static final String LJCX891 = "ljcx891";
	public static final String LJLR895 = "ljlr895";
	public static final String LJJH895 = "ljjh895";
	public static final String LJTP895 = "ljtp895";
	public static final String LJCX895 = "ljcx895";
	public static final String LJCL = "ljcl";
	public static final String LJLRCC891 = "ljlrcc891";
	public static final String LJJHCC891 = "ljjhcc891";
	public static final String LJLRCC895 = "ljlrcc895";
	public static final String LJJHCC895 = "ljjhcc895";
	public static final String LJYWL891 = "ljywl891";
	public static final String LJYWL895 = "ljywl895";
	public static final String ONLINE = "online";
	public static final String LJSXTS = "ljsxts";
	public static final String LJQDLR = "ljqdlr";
	public static final String LJQDLRZ = "ljqdlrz";



    
    public void save(HdTemp transientInstance) {
        log.debug("saving HdTemp instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HdTemp persistentInstance) {
        log.debug("deleting HdTemp instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HdTemp findById( java.lang.Integer id) {
        log.debug("getting HdTemp instance with id: " + id);
        try {
            HdTemp instance = (HdTemp) getSession()
                    .get("HdTemp", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HdTemp instance) {
        log.debug("finding HdTemp instance by example");
        try {
            List results = getSession()
                    .createCriteria("HdTemp")
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
      log.debug("finding HdTemp instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HdTemp as model where model." 
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
	
	public List findByTeam(Object team
	) {
		return findByProperty(TEAM, team
		);
	}
	
	public List findByLjlrsc(Object ljlrsc
	) {
		return findByProperty(LJLRSC, ljlrsc
		);
	}
	
	public List findByLrxg891(Object lrxg891
	) {
		return findByProperty(LRXG891, lrxg891
		);
	}
	
	public List findByJhxg891(Object jhxg891
	) {
		return findByProperty(JHXG891, jhxg891
		);
	}
	
	public List findByLrcc891(Object lrcc891
	) {
		return findByProperty(LRCC891, lrcc891
		);
	}
	
	public List findByJhcc891(Object jhcc891
	) {
		return findByProperty(JHCC891, jhcc891
		);
	}
	
	public List findByCx891(Object cx891
	) {
		return findByProperty(CX891, cx891
		);
	}
	
	public List findByTp891(Object tp891
	) {
		return findByProperty(TP891, tp891
		);
	}
	
	public List findBySumxl891(Object sumxl891
	) {
		return findByProperty(SUMXL891, sumxl891
		);
	}
	
	public List findByYwl891(Object ywl891
	) {
		return findByProperty(YWL891, ywl891
		);
	}
	
	public List findByOutput891(Object output891
	) {
		return findByProperty(OUTPUT891, output891
		);
	}
	
	public List findByLrxg895(Object lrxg895
	) {
		return findByProperty(LRXG895, lrxg895
		);
	}
	
	public List findByJhxg895(Object jhxg895
	) {
		return findByProperty(JHXG895, jhxg895
		);
	}
	
	public List findByLrcc895(Object lrcc895
	) {
		return findByProperty(LRCC895, lrcc895
		);
	}
	
	public List findByJhcc895(Object jhcc895
	) {
		return findByProperty(JHCC895, jhcc895
		);
	}
	
	public List findByCx895(Object cx895
	) {
		return findByProperty(CX895, cx895
		);
	}
	
	public List findByTp895(Object tp895
	) {
		return findByProperty(TP895, tp895
		);
	}
	
	public List findBySumxl895(Object sumxl895
	) {
		return findByProperty(SUMXL895, sumxl895
		);
	}
	
	public List findByYwl895(Object ywl895
	) {
		return findByProperty(YWL895, ywl895
		);
	}
	
	public List findByOutput895(Object output895
	) {
		return findByProperty(OUTPUT895, output895
		);
	}
	
	public List findByLjlr891(Object ljlr891
	) {
		return findByProperty(LJLR891, ljlr891
		);
	}
	
	public List findByLjjh891(Object ljjh891
	) {
		return findByProperty(LJJH891, ljjh891
		);
	}
	
	public List findByLjtp891(Object ljtp891
	) {
		return findByProperty(LJTP891, ljtp891
		);
	}
	
	public List findByLjcx891(Object ljcx891
	) {
		return findByProperty(LJCX891, ljcx891
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
	
	public List findByLjtp895(Object ljtp895
	) {
		return findByProperty(LJTP895, ljtp895
		);
	}
	
	public List findByLjcx895(Object ljcx895
	) {
		return findByProperty(LJCX895, ljcx895
		);
	}
	
	public List findByLjcl(Object ljcl
	) {
		return findByProperty(LJCL, ljcl
		);
	}
	
	public List findByLjlrcc891(Object ljlrcc891
	) {
		return findByProperty(LJLRCC891, ljlrcc891
		);
	}
	
	public List findByLjjhcc891(Object ljjhcc891
	) {
		return findByProperty(LJJHCC891, ljjhcc891
		);
	}
	
	public List findByLjlrcc895(Object ljlrcc895
	) {
		return findByProperty(LJLRCC895, ljlrcc895
		);
	}
	
	public List findByLjjhcc895(Object ljjhcc895
	) {
		return findByProperty(LJJHCC895, ljjhcc895
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
	
	public List findByOnline(Object online
	) {
		return findByProperty(ONLINE, online
		);
	}
	
	public List findByLjsxts(Object ljsxts
	) {
		return findByProperty(LJSXTS, ljsxts
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
	

	public List findAll() {
		log.debug("finding all HdTemp instances");
		try {
			String queryString = "from HdTemp";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HdTemp merge(HdTemp detachedInstance) {
        log.debug("merging HdTemp instance");
        try {
            HdTemp result = (HdTemp) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HdTemp instance) {
        log.debug("attaching dirty HdTemp instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HdTemp instance) {
        log.debug("attaching clean HdTemp instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public HdTemp findAllByDateAndNo(String date,String no) {
		log.debug("finding all HdTemp instances");
		try {
			String queryString = "from HdTemp as ht where ht.time='"+date+"' and ht.no='"+no+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				 return (HdTemp) list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}