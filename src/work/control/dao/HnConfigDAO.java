package work.control.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.control.pojo.HnConfig;
import work.control.pojo.Xishu;
import work.util.Tld;

/**
 	* A data access object (DAO) providing persistence and search support for HnConfig entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .HnConfig
  * @author MyEclipse Persistence Tools 
 */

public class HnConfigDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(HnConfigDAO.class);
		//property constants
	public static final String TYPE = "type";
	public static final String CODE = "code";
	public static final String PART = "part";
	public static final String INTYPE = "intype";
	public static final String WEIG = "weig";
	public static final String ORD = "ord";



    
    public void save(HnConfig transientInstance) {
        log.debug("saving HnConfig instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HnConfig persistentInstance) {
        log.debug("deleting HnConfig instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HnConfig findById( java.lang.Integer id) {
        log.debug("getting HnConfig instance with id: " + id);
        try {
            HnConfig instance = (HnConfig) getSession()
                    .get("HnConfig", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(HnConfig instance) {
        log.debug("finding HnConfig instance by example");
        try {
            List results = getSession()
                    .createCriteria("HnConfig")
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
      log.debug("finding HnConfig instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HnConfig as model where model." 
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
	
	public List findByCode(Object code
	) {
		return findByProperty(CODE, code
		);
	}
	
	public List findByPart(Object part
	) {
		return findByProperty(PART, part
		);
	}
	
	public List findByIntype(Object intype
	) {
		return findByProperty(INTYPE, intype
		);
	}
	
	public List findByWeig(Object weig
	) {
		return findByProperty(WEIG, weig
		);
	}
	
	public List findByOrd(Object ord
	) {
		return findByProperty(ORD, ord
		);
	}
	

	public List findAll() {
		log.debug("finding all HnConfig instances");
		try {
			String queryString = "from HnConfig";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HnConfig merge(HnConfig detachedInstance) {
        log.debug("merging HnConfig instance");
        try {
            HnConfig result = (HnConfig) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HnConfig instance) {
        log.debug("attaching dirty HnConfig instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HnConfig instance) {
        log.debug("attaching clean HnConfig instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public HnConfig findAllByCode(String code) {
    	log.debug("finding all HnConfig instances");
    	try {
    		String queryString = "from HnConfig as hc where hc.code='"+code+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (HnConfig) list.get(0);
    		 }
             
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public HnConfig findAllById(int id) {
    	log.debug("finding all HnConfig instances");
    	try {
    		String queryString = "from HnConfig as hc where hc.id='"+id+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (HnConfig) list.get(0);
    		 }
             
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 根据业务编码和环节查询
     * @param code
     * @param part
     * @return
     */
    public HnConfig findAllByCodeAndPart(String code,String part) {
    	log.debug("finding all HnConfig instances");
    	try {
    		String queryString = "from HnConfig as hc where hc.code like '%"+code+"%' and hc.part='"+part+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (HnConfig) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 根据业务种类和环节查询
     * @param code
     * @param part
     * @return
     */
    public HnConfig findAllByTypeAndPart(int type,String part) {
    	log.debug("finding all HnConfig instances");
    	try {
    		String queryString = "from HnConfig as hc where hc.type='"+type+"' and hc.part='"+part+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 HnConfig hc = new HnConfig();
    			 hc.setWeig("0.0");
    			 return hc;
    		 }
    		 else
    		 {
    			 return (HnConfig) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public Xishu getConfigByType(int type)
    {
    	HnConfigDAO hcdao = new HnConfigDAO();
    	HnConfig hc = null;
    	Xishu xs = new Xishu();
    	int size = 0;
    	if(type==1)//891
    	{
    		size = Tld.RMB_ZW.length;
    		if(size>0)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[0]);
				if(hc!=null)
					xs.setXs1(hc.getWeig());
			}
    		if(size>1)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[1]);
				if(hc!=null)
					xs.setXs2(hc.getWeig());
			}
    		if(size>2)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[2]);
				if(hc!=null)
					xs.setXs3(hc.getWeig());
			}
    		if(size>3)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[3]);
				if(hc!=null)
					xs.setXs4(hc.getWeig());
			}
    		if(size>4)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[4]);
				if(hc!=null)
					xs.setXs5(hc.getWeig());
			}
    		if(size>5)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[5]);
				if(hc!=null)
					xs.setXs6(hc.getWeig());
			}
    		if(size>6)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[6]);
				if(hc!=null)
					xs.setXs7(hc.getWeig());
			}
    		if(size>7)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[7]);
				if(hc!=null)
					xs.setXs8(hc.getWeig());
			}
    		if(size>8)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[8]);
				if(hc!=null)
					xs.setXs9(hc.getWeig());
			}
    		if(size>9)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[9]);
				if(hc!=null)
					xs.setXs10(hc.getWeig());
			}
    		if(size>10)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[10]);
				if(hc!=null)
					xs.setXs11(hc.getWeig());
			}
    		if(size>11)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[11]);
				if(hc!=null)
					xs.setXs12(hc.getWeig());
			}
    		if(size>12)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[12]);
				if(hc!=null)
					xs.setXs13(hc.getWeig());
			}
    		if(size>13)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[13]);
				if(hc!=null)
					xs.setXs14(hc.getWeig());
			}
    		if(size>14)
			{
				hc = hcdao.findAllByTypeAndPart(1,Tld.RMB_ZW[14]);
				if(hc!=null)
					xs.setXs15(hc.getWeig());
			}
    	}	
    	else if(type==2)//895
    	{
    		size = Tld.RMB_FZW.length;
    		if(size>0)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[0]);
				if(hc!=null)
					xs.setXs1(hc.getWeig());
			}
    		if(size>1)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[1]);
				if(hc!=null)
					xs.setXs2(hc.getWeig());
			}
    		if(size>2)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[2]);
				if(hc!=null)
					xs.setXs3(hc.getWeig());
			}
    		if(size>3)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[3]);
				if(hc!=null)
					xs.setXs4(hc.getWeig());
			}
    		if(size>4)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[4]);
				if(hc!=null)
					xs.setXs5(hc.getWeig());
			}
    		if(size>5)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[5]);
				if(hc!=null)
					xs.setXs6(hc.getWeig());
			}
    		if(size>6)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[6]);
				if(hc!=null)
					xs.setXs7(hc.getWeig());
			}
    		if(size>7)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[7]);
				if(hc!=null)
					xs.setXs8(hc.getWeig());
			}
    		if(size>8)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[8]);
				if(hc!=null)
					xs.setXs9(hc.getWeig());
			}
    		if(size>9)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[9]);
				if(hc!=null)
					xs.setXs10(hc.getWeig());
			}
    		if(size>10)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[10]);
				if(hc!=null)
					xs.setXs11(hc.getWeig());
			}
    		if(size>11)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[11]);
				if(hc!=null)
					xs.setXs12(hc.getWeig());
			}
    		if(size>12)
			{
				hc = hcdao.findAllByTypeAndPart(2,Tld.RMB_FZW[12]);
				if(hc!=null)
					xs.setXs13(hc.getWeig());
			}
    	}
    	
    	else if(type==3)//外汇
    	{
    		size = Tld.WAIHUI.length;
    		if(size>0)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[0]);
				if(hc!=null)
					xs.setXs1(hc.getWeig());
			}
    		if(size>1)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[1]);
				if(hc!=null)
					xs.setXs2(hc.getWeig());
			}
    		if(size>2)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[2]);
				if(hc!=null)
					xs.setXs3(hc.getWeig());
			}
    		if(size>3)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[3]);
				if(hc!=null)
					xs.setXs4(hc.getWeig());
			}
    		if(size>4)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[4]);
				if(hc!=null)
					xs.setXs5(hc.getWeig());
			}
    		if(size>5)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[5]);
				if(hc!=null)
					xs.setXs6(hc.getWeig());
			}
    		if(size>6)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[6]);
				if(hc!=null)
					xs.setXs7(hc.getWeig());
			}
    		if(size>7)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[7]);
				if(hc!=null)
					xs.setXs8(hc.getWeig());
			}
    		if(size>8)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[8]);
				if(hc!=null)
					xs.setXs9(hc.getWeig());
			}
    		if(size>9)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[9]);
				if(hc!=null)
					xs.setXs10(hc.getWeig());
			}
    		if(size>10)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[10]);
				if(hc!=null)
					xs.setXs11(hc.getWeig());
			}
    		if(size>11)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[11]);
				if(hc!=null)
					xs.setXs12(hc.getWeig());
			}
    		if(size>12)
			{
				hc = hcdao.findAllByTypeAndPart(3,Tld.WAIHUI[12]);
    			xs.setXs13(hc.getWeig());
			}
    	}
    	else if(type==6)//建亚
    	{
    		size = Tld.JIANYA.length;
    		if(size>0)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[0]);
				if(hc!=null)
    			xs.setXs1(hc.getWeig());
			}
    		if(size>1)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[1]);
				if(hc!=null)
    			xs.setXs2(hc.getWeig());
			}
    		if(size>2)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[2]);
				if(hc!=null)
    			xs.setXs3(hc.getWeig());
			}
    		if(size>3)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[3]);
				if(hc!=null)
    			xs.setXs4(hc.getWeig());
			}
    		if(size>4)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[4]);
				if(hc!=null)
    			xs.setXs5(hc.getWeig());
			}
    		if(size>5)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[5]);
				if(hc!=null)
    			xs.setXs6(hc.getWeig());
			}
    		if(size>6)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[6]);
				if(hc!=null)
    			xs.setXs7(hc.getWeig());
			}
    		if(size>7)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[7]);
				if(hc!=null)
    			xs.setXs8(hc.getWeig());
			}
    		if(size>8)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[8]);
				if(hc!=null)
    			xs.setXs9(hc.getWeig());
			}
    		if(size>9)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[9]);
				if(hc!=null)
    			xs.setXs10(hc.getWeig());
			}
    		if(size>10)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[10]);
				if(hc!=null)
    			xs.setXs11(hc.getWeig());
			}
    		if(size>11)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[11]);
				if(hc!=null)
    			xs.setXs12(hc.getWeig());
			}
    		if(size>12)
			{
				hc = hcdao.findAllByTypeAndPart(6,Tld.JIANYA[12]);
				if(hc!=null)
    			xs.setXs13(hc.getWeig());
			}
    	}
    	return xs;
    }
}