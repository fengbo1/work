package work.no.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.no.pojo.No;

/**
 	* A data access object (DAO) providing persistence and search support for No entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .No
  * @author MyEclipse Persistence Tools 
 */

public class NoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(NoDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String SEX = "sex";
	public static final String IDENTITY = "identity";
	public static final String TEL = "tel";
	public static final String ROLE = "role";
	public static final String POSITION = "position";
	public static final String ZX = "zx";
	public static final String XZ = "xz";
	public static final String XZWH = "xzwh";
	public static final String XZJH = "xzjh";
	public static final String XZSH = "xzsh";
	public static final String XZJY = "xzjy";
	public static final String COMEDATE = "comedate";
	public static final String NO891 = "no891";
	public static final String NO895 = "no895";
	public static final String NO1 = "no1";
	public static final String NO2 = "no2";
	public static final String CHU = "chu";
	public static final String TEAM = "team";
	public static final String SCHEDEAM = "schedeam";
	public static final String SOURCE = "source";
	public static final String COMPANY = "company";
	public static final String CHANGEWB = "changewb";
	public static final String REMARK1 = "remark1";



    
    public void save(No transientInstance) {
        log.debug("saving No instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(No persistentInstance) {
        log.debug("deleting No instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public No findById( java.lang.Integer id) {
        log.debug("getting No instance with id: " + id);
        try {
            No instance = (No) getSession()
                    .get("No", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(No instance) {
        log.debug("finding No instance by example");
        try {
            List results = getSession()
                    .createCriteria("No")
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
      log.debug("finding No instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from No as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findBySex(Object sex
	) {
		return findByProperty(SEX, sex
		);
	}
	
	public List findByIdentity(Object identity
	) {
		return findByProperty(IDENTITY, identity
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findByRole(Object role
	) {
		return findByProperty(ROLE, role
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
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
	
	public List findByXzwh(Object xzwh
	) {
		return findByProperty(XZWH, xzwh
		);
	}
	
	public List findByXzjh(Object xzjh
	) {
		return findByProperty(XZJH, xzjh
		);
	}
	
	public List findByXzsh(Object xzsh
	) {
		return findByProperty(XZSH, xzsh
		);
	}
	
	public List findByXzjy(Object xzjy
	) {
		return findByProperty(XZJY, xzjy
		);
	}
	
	public List findByComedate(Object comedate
	) {
		return findByProperty(COMEDATE, comedate
		);
	}
	
	public List findByNo891(Object no891
	) {
		return findByProperty(NO891, no891
		);
	}
	
	public List findByNo895(Object no895
	) {
		return findByProperty(NO895, no895
		);
	}
	
	public List findByNo1(Object no1
	) {
		return findByProperty(NO1, no1
		);
	}
	
	public List findByNo2(Object no2
	) {
		return findByProperty(NO2, no2
		);
	}
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	
	public List findByTeam(Object team
	) {
		return findByProperty(TEAM, team
		);
	}
	
	public List findBySchedeam(Object schedeam
	) {
		return findByProperty(SCHEDEAM, schedeam
		);
	}
	
	public List findBySource(Object source
	) {
		return findByProperty(SOURCE, source
		);
	}
	
	public List findByCompany(Object company
	) {
		return findByProperty(COMPANY, company
		);
	}
	
	public List findByChangewb(Object changewb
	) {
		return findByProperty(CHANGEWB, changewb
		);
	}
	
	public List findByRemark1(Object remark1
	) {
		return findByProperty(REMARK1, remark1
		);
	}
	

	public List findAll() {
		log.debug("finding all No instances");
		try {
			String queryString = "from No";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public No merge(No detachedInstance) {
        log.debug("merging No instance");
        try {
            No result = (No) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(No instance) {
        log.debug("attaching dirty No instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(No instance) {
        log.debug("attaching clean No instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public No findAllByNameAndHangnei(String name) {
    	log.debug("finding all No instances");
    	try {
    		String queryString = "from No as n where n.name='"+name+"' and xz!=3";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (No)list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List<No> findAllHangnei() {
    	log.debug("finding all No instances");
    	try {
    		String queryString = "from No as n where n.xz!=3";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 return list;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public No findById(int id) {
    	log.debug("finding all No instances");
    	try {
    		String queryString = "from No as n where n.id="+id;
             Query queryObject = getSession().createQuery(queryString);
    		 return (No) queryObject.list().get(0);
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findBy895No(String no){
    	log.debug("finding all No instances");
    	try {
    		String queryString = "from No as n where n.no895='"+no+"'";
             Query queryObject = getSession().createQuery(queryString);
             
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findBy891No(String no){
    	log.debug("finding all No instances");
    	try {
    		String queryString = "from No as n where n.no891='"+no+"'";
             Query queryObject = getSession().createQuery(queryString);
             
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllByNewnumber(String newnumber) {
    	log.debug("finding all No instances");
    	try {
    		String queryString = "from No as n where n.newnumber='"+newnumber+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public No findAllByNewnumberAndHangnei(String newnumber) {
    	log.debug("finding all No instances");
    	try {
    		String queryString = "from No as n where n.newnumber='"+newnumber+"' and n.xz!=3";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (No)list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}