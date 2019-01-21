package work.control.dao;
// default package

import ccb.dao.BaseHibernateDAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.control.pojo.NameValueBean;
import work.control.pojo.UserCfg;

/**
 	* A data access object (DAO) providing persistence and search support for UserCfg entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserCfg
  * @author MyEclipse Persistence Tools 
 */

public class UserCfgDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserCfgDAO.class);
		//property constants
	public static final String TYPE = "type";
	public static final String TYPEC = "typec";
	public static final String NUM = "num";
	public static final String NAME = "name";
	public static final String NAMEC = "namec";
	public static final String CONTENT = "content";
	public static final String CONTENTC = "contentc";
	public static final String CONTENTSC = "contentsc";



    
    public void save(UserCfg transientInstance) {
        log.debug("saving UserCfg instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserCfg persistentInstance) {
        log.debug("deleting UserCfg instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserCfg findById( java.lang.Integer id) {
        log.debug("getting UserCfg instance with id: " + id);
        try {
            UserCfg instance = (UserCfg) getSession()
                    .get("UserCfg", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserCfg instance) {
        log.debug("finding UserCfg instance by example");
        try {
            List results = getSession()
                    .createCriteria("UserCfg")
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
      log.debug("finding UserCfg instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserCfg as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByTypec(Object typec
	) {
		return findByProperty(TYPEC, typec
		);
	}
	
	public List findByNum(Object num
	) {
		return findByProperty(NUM, num
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNamec(Object namec
	) {
		return findByProperty(NAMEC, namec
		);
	}
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List findByContentc(Object contentc
	) {
		return findByProperty(CONTENTC, contentc
		);
	}
	
	public List findByContentsc(Object contentsc
	) {
		return findByProperty(CONTENTSC, contentsc
		);
	}
	

	public List findAll() {
		log.debug("finding all UserCfg instances");
		try {
			String queryString = "from UserCfg";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserCfg merge(UserCfg detachedInstance) {
        log.debug("merging UserCfg instance");
        try {
            UserCfg result = (UserCfg) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserCfg instance) {
        log.debug("attaching dirty UserCfg instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserCfg instance) {
        log.debug("attaching clean UserCfg instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public UserCfg findUcByTypeAndNum(String type,String num) {
		log.debug("finding all UserCfg instances");
		try {
			String queryString = "from UserCfg as uc where uc.type='"+type+"' and num='"+num+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return new UserCfg();
	         }
	         else
	         {
	        	 return (UserCfg) list.get(0);
	         }
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public List<NameValueBean> findIndexByTypeAndNum(String type,String num) {
		log.debug("finding all UserCfg instances");
		try {
			List<NameValueBean> listnv = new ArrayList<NameValueBean>();
			String queryString = "from UserCfg as uc where uc.type='"+type+"' and num='"+num+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<UserCfg> list = queryObject.list();
	         if(!list.isEmpty())
	         {
	        	 UserCfg uc = (UserCfg) list.get(0);
	        	 String[] content = uc.getContent().split("、");
	        	 String[] contentc = uc.getContentc().split("、");
	        	 for(int i=0;i<content.length;i++)
	        	 {
	        		 NameValueBean nvb = new NameValueBean();
	        		 nvb.setName(String.valueOf(i));
	        		 nvb.setValue(contentc[i]);
	        		 listnv.add(nvb);
	        	 }
	         }
			return listnv;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    //短的名字
    public List<NameValueBean> findScIndexByTypeAndNum(String type,String num) {
		log.debug("finding all UserCfg instances");
		try {
			List<NameValueBean> listnv = new ArrayList<NameValueBean>();
			String queryString = "from UserCfg as uc where uc.type='"+type+"' and num='"+num+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<UserCfg> list = queryObject.list();
	         if(!list.isEmpty())
	         {
	        	 UserCfg uc = (UserCfg) list.get(0);
	        	 String[] content = uc.getContent().split("、");
	        	 String[] contentsc = uc.getContentsc().split("、");
	        	 for(int i=0;i<content.length;i++)
	        	 {
	        		 NameValueBean nvb = new NameValueBean();
	        		 nvb.setName(String.valueOf(i));
	        		 nvb.setValue(contentsc[i]);
	        		 listnv.add(nvb);
	        	 }
	         }
			return listnv;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public List<NameValueBean> findAllByTypeAndNum(String type,String num) {
		log.debug("finding all UserCfg instances");
		try {
			List<NameValueBean> listnv = new ArrayList<NameValueBean>();
			String queryString = "from UserCfg as uc where uc.type='"+type+"' and num='"+num+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<UserCfg> list = queryObject.list();
	         if(!list.isEmpty())
	         {
	        	 UserCfg uc = (UserCfg) list.get(0);
	        	 String[] content = uc.getContent().split("、");
	        	 String[] contentc = uc.getContentc().split("、");
	        	 for(int i=0;i<content.length;i++)
	        	 {
	        		 NameValueBean nvb = new NameValueBean();
	        		 nvb.setName(content[i]);
	        		 nvb.setValue(contentc[i]);
	        		 listnv.add(nvb);
	        	 }
	         }
			return listnv;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public List<NameValueBean> findAllByTypeAndName(String type,String name) {
		log.debug("finding all UserCfg instances");
		try {
			List<NameValueBean> listnv = new ArrayList<NameValueBean>();
			String queryString = "from UserCfg as uc where uc.type='"+type+"' and name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<UserCfg> list = queryObject.list();
	         if(!list.isEmpty())
	         {
	        	 UserCfg uc = (UserCfg) list.get(0);
	        	 String[] content = uc.getContent().split("、");
	        	 String[] contentc = uc.getContentc().split("、");
	        	 for(int i=0;i<content.length;i++)
	        	 {
	        		 NameValueBean nvb = new NameValueBean();
	        		 nvb.setName(content[i]);
	        		 nvb.setValue(contentc[i]);
	        		 listnv.add(nvb);
	        	 }
	         }
			return listnv;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public String findAllByTypeNumIndC(String type,String num,int ind) {
		log.debug("finding all UserCfg instances");
		try {
			String queryString = "from UserCfg as uc where uc.type='"+type+"' and num='"+num+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<UserCfg> list = queryObject.list();
	         if(!list.isEmpty())
	         {
	        	 UserCfg uc = (UserCfg) list.get(0);
	        	 String[] contentc = uc.getContentc().split("、");
	        	 return contentc[ind];
	         }
	         else
	         {
	        	 return "";
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public String findAllByTypeNumIndSc(String type,String num,int ind) {
		log.debug("finding all UserCfg instances");
		try {
			String queryString = "from UserCfg as uc where uc.type='"+type+"' and num='"+num+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<UserCfg> list = queryObject.list();
	         if(!list.isEmpty())
	         {
	        	 UserCfg uc = (UserCfg) list.get(0);
	        	 String[] contentsc = uc.getContentsc().split("、");
	        	 return contentsc[ind];
	         }
	         else
	         {
	        	 return "";
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public List<UserCfg> findAllByType(String type) {
		log.debug("finding all UserCfg instances");
		try {
			String queryString = "from UserCfg where type='"+type+"' order by num";
	         Query queryObject = getSession().createQuery(queryString);
			 List<UserCfg> list = queryObject.list();
			 return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}