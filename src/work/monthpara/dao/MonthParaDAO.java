package work.monthpara.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.monthpara.pojo.MonthPara;
import work.util.YearSeason;

/**
 	* A data access object (DAO) providing persistence and search support for MonthPara entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .MonthPara
  * @author MyEclipse Persistence Tools 
 */

public class MonthParaDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MonthParaDAO.class);
		//property constants
	public static final String MONTH = "month";
	public static final String HN_CL = "hnCl";
	public static final String HN_ZL = "hnZl";
	public static final String WB_CL = "wbCl";
	public static final String _TBZ = "TBz";
	public static final String CL_YJ = "clYj";
	public static final String ZL_YJ = "zlYj";
	public static final String XL_YJ = "xlYj";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";



    
    public void save(MonthPara transientInstance) {
        log.debug("saving MonthPara instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MonthPara persistentInstance) {
        log.debug("deleting MonthPara instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MonthPara findById( java.lang.Integer id) {
        log.debug("getting MonthPara instance with id: " + id);
        try {
            MonthPara instance = (MonthPara) getSession()
                    .get("MonthPara", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(MonthPara instance) {
        log.debug("finding MonthPara instance by example");
        try {
            List results = getSession()
                    .createCriteria("MonthPara")
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
      log.debug("finding MonthPara instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MonthPara as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMonth(Object month
	) {
		return findByProperty(MONTH, month
		);
	}
	
	public List findByHnCl(Object hnCl
	) {
		return findByProperty(HN_CL, hnCl
		);
	}
	
	public List findByHnZl(Object hnZl
	) {
		return findByProperty(HN_ZL, hnZl
		);
	}
	
	public List findByWbCl(Object wbCl
	) {
		return findByProperty(WB_CL, wbCl
		);
	}
	
	public List findByTBz(Object TBz
	) {
		return findByProperty(_TBZ, TBz
		);
	}
	
	public List findByClYj(Object clYj
	) {
		return findByProperty(CL_YJ, clYj
		);
	}
	
	public List findByZlYj(Object zlYj
	) {
		return findByProperty(ZL_YJ, zlYj
		);
	}
	
	public List findByXlYj(Object xlYj
	) {
		return findByProperty(XL_YJ, xlYj
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
	

	public List findAll() {
		log.debug("finding all MonthPara instances");
		try {
			String queryString = "from MonthPara";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public Double findHnclByMonth(int month) {
		log.debug("finding 行内目标产量 by 月份 instances");
		//YearSeason ys = new YearSeason();
		//String month = "";
		try {
			 String queryString = "from MonthPara as mp where mp.month<='"+month+"' order by mp.month desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<MonthPara> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return 0.0;
	         }
	         else
	         {
	        	 MonthPara mp = list.get(0);
		         return mp.getHnCl(); 
	         }
	         
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public Double findHnzlByMonth(int month) {
		log.debug("finding 行内目标产量 by 月份 instances");
		//YearSeason ys = new YearSeason();
		//String month = "";
		try {
			 String queryString = "from MonthPara as mp where mp.month<='"+month+"' order by mp.month desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<MonthPara> list = queryObject.list();
	         MonthPara mp = list.get(0);
	         return mp.getHnZl();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public String findAllDescByMonth() {
		log.debug("finding all MonthPara instances");
		YearSeason ys = new YearSeason();
		String month = "";
		try {
			 String queryString = "from MonthPara as mp order by mp.month desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<MonthPara> list = queryObject.list();
	         if(list==null||list.isEmpty())
	         {
	        	 month = ys.getThisMonth();
	         }
	         else
	         {
	        	 String monthtemp = list.get(0).getMonth();
	        	 month = ys.getNextMonth(monthtemp);
	         }
	        	 return month;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public MonthPara merge(MonthPara detachedInstance) {
        log.debug("merging MonthPara instance");
        try {
            MonthPara result = (MonthPara) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MonthPara instance) {
        log.debug("attaching dirty MonthPara instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MonthPara instance) {
        log.debug("attaching clean MonthPara instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}