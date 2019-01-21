package work.ygxy.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.userinfo.dao.UserInfoDAO;
import work.userinfo.pojo.UserInfo;
import work.ygxy.pojo.Ygxy;

/**
 	* A data access object (DAO) providing persistence and search support for Ygxy entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Ygxy
  * @author MyEclipse Persistence Tools 
 */

public class YgxyDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(YgxyDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String NAME = "name";
	public static final String POSITION = "position";
	public static final String FT_DLSC = "ftDlsc";
	public static final String FT_XXLV = "ftXxlv";
	public static final String FT_YDDH = "ftYddh";
	public static final String FT_PJYDSC = "ftPjydsc";
	public static final String FT_PJSHSC = "ftPjshsc";
	public static final String FT_HCDHS = "ftHcdhs";
	public static final String FT_PJHCSC = "ftPjhcsc";
	public static final String FT_PJCLSC = "ftPjclsc";
	public static final String FT_PJCLSCD = "ftPjclscd";
	public static final String FT_SJL = "ftSjl";
	public static final String FT_FEIQL = "ftFeiql";
	public static final String FT_FANGQL = "ftFangql";
	public static final String FT_TDWZJL = "ftTdwzjl";
	public static final String FT_TBJPL = "ftTbjpl";
	public static final String FT_GDJLL = "ftGdjll";
	public static final String FT_YJDFL = "ftYjdfl";
	public static final String FT_YJDFLV = "ftYjdflv";
	public static final String FE_DRJSL = "feDrjsl";
	public static final String FE_YJPJCLSC = "feYjpjclsc";
	public static final String FE_YJPJCLSCD = "feYjpjclscd";
	public static final String FE_SJL = "feSjl";
	public static final String FE_FANGQL = "feFangql";
	public static final String FE_TBJPL = "feTbjpl";
	public static final String FE_GDJLL = "feGdjll";
	public static final String FE_YJDFL = "feYjdfl";
	public static final String FE_YJDFLV = "feYjdflv";
	public static final String STE_DRJSL = "steDrjsl";
	public static final String STE_EJPJCLSC = "steEjpjclsc";
	public static final String STE_EJPJCLSCD = "steEjpjclscd";
	public static final String STE_NBZJL = "steNbzjl";
	public static final String STE_FANGQL = "steFangql";
	public static final String STE_TPJPL = "steTpjpl";
	public static final String STE_GDJLL = "steGdjll";
	public static final String STE_EJDFL = "steEjdfl";
	public static final String STE_EJDFLV = "steEjdflv";
	public static final String STE_ZSJL = "steZsjl";
	public static final String STE_ZSJLV = "steZsjlv";
	public static final String GZSC = "gzsc";
	public static final String LXSC = "lxsc";
	public static final String GDL = "gdl";
	public static final String ZYSC = "zysc";
	public static final String XYQQZSL = "xyqqzsl";



    
    public void save(Ygxy transientInstance) {
        log.debug("saving Ygxy instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Ygxy persistentInstance) {
        log.debug("deleting Ygxy instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Ygxy findById( java.lang.Integer id) {
        log.debug("getting Ygxy instance with id: " + id);
        try {
            Ygxy instance = (Ygxy) getSession()
                    .get("Ygxy", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Ygxy instance) {
        log.debug("finding Ygxy instance by example");
        try {
            List results = getSession()
                    .createCriteria("Ygxy")
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
      log.debug("finding Ygxy instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Ygxy as model where model." 
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
	
	public List findByFtDlsc(Object ftDlsc
	) {
		return findByProperty(FT_DLSC, ftDlsc
		);
	}
	
	public List findByFtXxlv(Object ftXxlv
	) {
		return findByProperty(FT_XXLV, ftXxlv
		);
	}
	
	public List findByFtYddh(Object ftYddh
	) {
		return findByProperty(FT_YDDH, ftYddh
		);
	}
	
	public List findByFtPjydsc(Object ftPjydsc
	) {
		return findByProperty(FT_PJYDSC, ftPjydsc
		);
	}
	
	public List findByFtPjshsc(Object ftPjshsc
	) {
		return findByProperty(FT_PJSHSC, ftPjshsc
		);
	}
	
	public List findByFtHcdhs(Object ftHcdhs
	) {
		return findByProperty(FT_HCDHS, ftHcdhs
		);
	}
	
	public List findByFtPjhcsc(Object ftPjhcsc
	) {
		return findByProperty(FT_PJHCSC, ftPjhcsc
		);
	}
	
	public List findByFtPjclsc(Object ftPjclsc
	) {
		return findByProperty(FT_PJCLSC, ftPjclsc
		);
	}
	
	public List findByFtPjclscd(Object ftPjclscd
	) {
		return findByProperty(FT_PJCLSCD, ftPjclscd
		);
	}
	
	public List findByFtSjl(Object ftSjl
	) {
		return findByProperty(FT_SJL, ftSjl
		);
	}
	
	public List findByFtFeiql(Object ftFeiql
	) {
		return findByProperty(FT_FEIQL, ftFeiql
		);
	}
	
	public List findByFtFangql(Object ftFangql
	) {
		return findByProperty(FT_FANGQL, ftFangql
		);
	}
	
	public List findByFtTdwzjl(Object ftTdwzjl
	) {
		return findByProperty(FT_TDWZJL, ftTdwzjl
		);
	}
	
	public List findByFtTbjpl(Object ftTbjpl
	) {
		return findByProperty(FT_TBJPL, ftTbjpl
		);
	}
	
	public List findByFtGdjll(Object ftGdjll
	) {
		return findByProperty(FT_GDJLL, ftGdjll
		);
	}
	
	public List findByFtYjdfl(Object ftYjdfl
	) {
		return findByProperty(FT_YJDFL, ftYjdfl
		);
	}
	
	public List findByFtYjdflv(Object ftYjdflv
	) {
		return findByProperty(FT_YJDFLV, ftYjdflv
		);
	}
	
	public List findByFeDrjsl(Object feDrjsl
	) {
		return findByProperty(FE_DRJSL, feDrjsl
		);
	}
	
	public List findByFeYjpjclsc(Object feYjpjclsc
	) {
		return findByProperty(FE_YJPJCLSC, feYjpjclsc
		);
	}
	
	public List findByFeYjpjclscd(Object feYjpjclscd
	) {
		return findByProperty(FE_YJPJCLSCD, feYjpjclscd
		);
	}
	
	public List findByFeSjl(Object feSjl
	) {
		return findByProperty(FE_SJL, feSjl
		);
	}
	
	public List findByFeFangql(Object feFangql
	) {
		return findByProperty(FE_FANGQL, feFangql
		);
	}
	
	public List findByFeTbjpl(Object feTbjpl
	) {
		return findByProperty(FE_TBJPL, feTbjpl
		);
	}
	
	public List findByFeGdjll(Object feGdjll
	) {
		return findByProperty(FE_GDJLL, feGdjll
		);
	}
	
	public List findByFeYjdfl(Object feYjdfl
	) {
		return findByProperty(FE_YJDFL, feYjdfl
		);
	}
	
	public List findByFeYjdflv(Object feYjdflv
	) {
		return findByProperty(FE_YJDFLV, feYjdflv
		);
	}
	
	public List findBySteDrjsl(Object steDrjsl
	) {
		return findByProperty(STE_DRJSL, steDrjsl
		);
	}
	
	public List findBySteEjpjclsc(Object steEjpjclsc
	) {
		return findByProperty(STE_EJPJCLSC, steEjpjclsc
		);
	}
	
	public List findBySteEjpjclscd(Object steEjpjclscd
	) {
		return findByProperty(STE_EJPJCLSCD, steEjpjclscd
		);
	}
	
	public List findBySteNbzjl(Object steNbzjl
	) {
		return findByProperty(STE_NBZJL, steNbzjl
		);
	}
	
	public List findBySteFangql(Object steFangql
	) {
		return findByProperty(STE_FANGQL, steFangql
		);
	}
	
	public List findBySteTpjpl(Object steTpjpl
	) {
		return findByProperty(STE_TPJPL, steTpjpl
		);
	}
	
	public List findBySteGdjll(Object steGdjll
	) {
		return findByProperty(STE_GDJLL, steGdjll
		);
	}
	
	public List findBySteEjdfl(Object steEjdfl
	) {
		return findByProperty(STE_EJDFL, steEjdfl
		);
	}
	
	public List findBySteEjdflv(Object steEjdflv
	) {
		return findByProperty(STE_EJDFLV, steEjdflv
		);
	}
	
	public List findBySteZsjl(Object steZsjl
	) {
		return findByProperty(STE_ZSJL, steZsjl
		);
	}
	
	public List findBySteZsjlv(Object steZsjlv
	) {
		return findByProperty(STE_ZSJLV, steZsjlv
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
	
	public List findByGdl(Object gdl
	) {
		return findByProperty(GDL, gdl
		);
	}
	
	public List findByZysc(Object zysc
	) {
		return findByProperty(ZYSC, zysc
		);
	}
	
	public List findByXyqqzsl(Object xyqqzsl
	) {
		return findByProperty(XYQQZSL, xyqqzsl
		);
	}
	

	public List findAll() {
		log.debug("finding all Ygxy instances");
		try {
			String queryString = "from Ygxy";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Ygxy merge(Ygxy detachedInstance) {
        log.debug("merging Ygxy instance");
        try {
            Ygxy result = (Ygxy) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Ygxy instance) {
        log.debug("attaching dirty Ygxy instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Ygxy instance) {
        log.debug("attaching clean Ygxy instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public Ygxy findAllByDateAndName(String date,String name) {
		log.debug("finding all Ygxy instances");
		try {
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui = uidao.findAllByName(name);
			String queryString = "from Ygxy as l where l.date='"+date+"' and l.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<Ygxy> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return new Ygxy(date,name,ui.getPosition(),"",0.0,0,"","",0,"","",0.0,0,0,0,0,0,0,0,0.0,0,"",0.0,0,0,0,0,0,0.0,0,"",0.0,0,0,0,0,0,0.0,0,0.0,0.0,0.0,0.0,0.0,0.0);
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
    public List findAllByBegindateAndEnddate(String begindate,String enddate) {
		log.debug("finding all Ygxy instances");
		try {
			String queryString = "from Ygxy as y where y.date>="+begindate+" and y.date<="+enddate;
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}