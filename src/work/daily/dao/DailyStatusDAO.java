package work.daily.dao;
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

import work.daily.pojo.DailyStatus;

/**
 	* A data access object (DAO) providing persistence and search support for DailyStatus entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .DailyStatus
  * @author MyEclipse Persistence Tools 
 */

public class DailyStatusDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(DailyStatusDAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String HN_QUICK = "hnQuick";
	public static final String WB_BASE = "wbBase";
	public static final String STATUS = "status";
	public static final String HN_SUMMARY_QUICK = "hnSummaryQuick";
	public static final String HN_SUMMARY_DAILY = "hnSummaryDaily";
	public static final String HN_DAILY = "hnDaily";
	public static final String WB_DAILY = "wbDaily";
	public static final String HNONLINE = "hnonline";
	public static final String HN891 = "hn891";
	public static final String HN895 = "hn895";
	public static final String HNX13 = "hnx13";
	public static final String HNJIHE = "hnjihe";
	public static final String HNYCSH = "hnycsh";
	public static final String HNFXQ = "hnfxq";
	public static final String HNWHBB = "hnwhbb";
	public static final String WB891 = "wb891";
	public static final String WB895 = "wb895";
	public static final String WB896 = "wb896";
	public static final String WBJIAGONG = "wbjiagong";



    
    public void save(DailyStatus transientInstance) {
        log.debug("saving DailyStatus instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(DailyStatus persistentInstance) {
        log.debug("deleting DailyStatus instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public DailyStatus findById( java.lang.Integer id) {
        log.debug("getting DailyStatus instance with id: " + id);
        try {
            DailyStatus instance = (DailyStatus) getSession()
                    .get("DailyStatus", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(DailyStatus instance) {
        log.debug("finding DailyStatus instance by example");
        try {
            List results = getSession()
                    .createCriteria("DailyStatus")
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
      log.debug("finding DailyStatus instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from DailyStatus as model where model." 
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
	
	public List findByHnQuick(Object hnQuick
	) {
		return findByProperty(HN_QUICK, hnQuick
		);
	}
	
	public List findByWbBase(Object wbBase
	) {
		return findByProperty(WB_BASE, wbBase
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findByHnSummaryQuick(Object hnSummaryQuick
	) {
		return findByProperty(HN_SUMMARY_QUICK, hnSummaryQuick
		);
	}
	
	public List findByHnSummaryDaily(Object hnSummaryDaily
	) {
		return findByProperty(HN_SUMMARY_DAILY, hnSummaryDaily
		);
	}
	
	public List findByHnDaily(Object hnDaily
	) {
		return findByProperty(HN_DAILY, hnDaily
		);
	}
	
	public List findByWbDaily(Object wbDaily
	) {
		return findByProperty(WB_DAILY, wbDaily
		);
	}
	
	public List findByHnonline(Object hnonline
	) {
		return findByProperty(HNONLINE, hnonline
		);
	}
	
	public List findByHn891(Object hn891
	) {
		return findByProperty(HN891, hn891
		);
	}
	
	public List findByHn895(Object hn895
	) {
		return findByProperty(HN895, hn895
		);
	}
	
	public List findByHnx13(Object hnx13
	) {
		return findByProperty(HNX13, hnx13
		);
	}
	
	public List findByHnjihe(Object hnjihe
	) {
		return findByProperty(HNJIHE, hnjihe
		);
	}
	
	public List findByHnycsh(Object hnycsh
	) {
		return findByProperty(HNYCSH, hnycsh
		);
	}
	
	public List findByHnfxq(Object hnfxq
	) {
		return findByProperty(HNFXQ, hnfxq
		);
	}
	
	public List findByHnwhbb(Object hnwhbb
	) {
		return findByProperty(HNWHBB, hnwhbb
		);
	}
	
	public List findByWb891(Object wb891
	) {
		return findByProperty(WB891, wb891
		);
	}
	
	public List findByWb895(Object wb895
	) {
		return findByProperty(WB895, wb895
		);
	}
	
	public List findByWb896(Object wb896
	) {
		return findByProperty(WB896, wb896
		);
	}
	
	public List findByWbjiagong(Object wbjiagong
	) {
		return findByProperty(WBJIAGONG, wbjiagong
		);
	}
	

	public List findAll() {
		log.debug("finding all DailyStatus instances");
		try {
			String queryString = "from DailyStatus";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public DailyStatus merge(DailyStatus detachedInstance) {
        log.debug("merging DailyStatus instance");
        try {
            DailyStatus result = (DailyStatus) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(DailyStatus instance) {
        log.debug("attaching dirty DailyStatus instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(DailyStatus instance) {
        log.debug("attaching clean DailyStatus instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllOrderByDateDesc() {
		log.debug("finding all DailyStatus instances");
		try {
			String queryString = "from DailyStatus order by time desc";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public DailyStatus findNew(int i) {
		log.debug("finding all DailyStatus instances");
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
			String queryString = "from DailyStatus as ds order by ds.time desc";
	         Query queryObject = session.createQuery(queryString);
	         List<DailyStatus> list = queryObject.list();
	         if(list.isEmpty()||list.size()<0)
	         {
	        	 return null;
	         }
	         else
	         {
	        	 return list.get(i-1);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}

	public String findFinalWithHn() {
		log.debug("finding all DailyStatus instances");
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
			String queryString = "from DailyStatus as ds where ds.hnQuick>0 order by ds.time desc";
	         Query queryObject = session.createQuery(queryString);
	         List<DailyStatus> list = queryObject.list();
	         if(list.isEmpty()||list.size()<0)
	         {
	        	 //return "0000-00-00";
	        	 return "00000000";
	         }
	         else
	         {
	        	 String time = list.get(0).getTime();
	        	// time.substring(0, 4)+"-"+time.substring(4, 6)+"-"+time.substring(6, 8); 
	        	 return time;
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}
	public String findFinalWithHnWithsession(Session session) {
		log.debug("finding all DailyStatus instances");
		
			String queryString = "from DailyStatus as ds where ds.hnQuick>0 order by ds.time desc";
	         Query queryObject = session.createQuery(queryString);
	         List<DailyStatus> list = queryObject.list();
	         if(list.isEmpty()||list.size()<0)
	         {
	        	 return "0000-00-00";
	         }
	         else
	         {
	        	 String time = list.get(0).getTime();
	        	// time.substring(0, 4)+"-"+time.substring(4, 6)+"-"+time.substring(6, 8); 
	        	 return time;
	         }
		
	}

	/**
	 * 返回外包最新日期
	 * @return
	 */
	public String findFinalWithWb() {
		log.debug("finding all DailyStatus instances");
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
			String queryString = "from DailyStatus as ds where ds.wbDaily>=1 order by ds.time desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<DailyStatus> list = queryObject.list();
	         if(list.isEmpty()||list.size()<0)
	         {
	        	 return "00000000";
	         }
	         else
	         {
	        	 return list.get(0).getTime(); 
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}
	/**
	 * 返回汇总最新日期
	 * @return
	 */
	public String findSummary() {
		log.debug("finding all DailyStatus instances");
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
			 String queryString = "from DailyStatus as ds where ds.hnSummaryDaily>=1 order by ds.time desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<DailyStatus> list = queryObject.list();
	         if(list.isEmpty()||list.size()<0)
	         {
	        	 return "00000000";
	         }
	         else
	         {
	        	 return list.get(0).getTime(); 
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}

	/**
	 * 返回汇总简报最新日期
	 * @return
	 */
	public String findSummarySimple() {
		log.debug("finding all DailyStatus instances");
		Session session = HibernateSessionFactory.getSession();
	    Transaction trans=session.beginTransaction();
		try {
			 String queryString = "from DailyStatus as ds where ds.hnSummarySimple>=1 order by ds.time desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<DailyStatus> list = queryObject.list();
	         if(list.isEmpty()||list.size()<0)
	         {
	        	 return "00000000";
	         }
	         else
	         {
	        	 return list.get(0).getTime(); 
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
	}
	public String saveByTime(String time)
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			DailyStatus ds = findByTime(time);
			DailyStatusDAO dsdao = new DailyStatusDAO();
			if(ds==null)
			{
				ds = new DailyStatus(time, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				dsdao.save(ds);
			}
			}catch (RuntimeException re) {
			re.printStackTrace();
			trans.rollback();
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
		return "success";
	}
	public String updateByTimeAndKey(String time,String key){
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			String sql = "update t_daily_status set "+key+"=1 where time='"+time+"'";
			session.createSQLQuery(sql).executeUpdate();
		}catch (RuntimeException re) {
			re.printStackTrace();
			trans.rollback();
			throw re;
		}finally{
	    	  trans.commit();
	          session.flush();
	          session.clear();
	          session.close();
	      }
		return "success";
		
	}
	public String updateByTimeAndKey(Session session,String time,String key){
		try {
			String sql = "update t_daily_status set "+key+"=1 where time='"+time+"'";
			session.createSQLQuery(sql).executeUpdate();
		}catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
		return "success";
		
	}
	public DailyStatus findByTime(String time) {
		log.debug("finding all DailyStatus instances");
		try {
			String queryString = "from DailyStatus as ds where time='"+time+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list==null||list.isEmpty()||list.size()<=0)
	        	 return null;
	         else
			 return (DailyStatus) queryObject.list().get(0);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}