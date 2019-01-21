package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.SummaryDaily;
import work.util.GeneralCheck;

/**
 	* A data access object (DAO) providing persistence and search support for SummaryDaily entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .SummaryDaily
  * @author MyEclipse Persistence Tools 
 */

public class SummaryDailyDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SummaryDailyDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String ITEM_CODE = "itemCode";
	public static final String ITEM_NAME = "itemName";
	public static final String WH891 = "wh891";
	public static final String WH891_ZB = "wh891Zb";
	public static final String WH895 = "wh895";
	public static final String WH895_ZB = "wh895Zb";
	public static final String WH_REAL = "whReal";
	public static final String WH_REAL_ZB = "whRealZb";
	public static final String CD891 = "cd891";
	public static final String CD891_ZB = "cd891Zb";
	public static final String CD895 = "cd895";
	public static final String CD895_ZB = "cd895Zb";
	public static final String CD_REAL = "cdReal";
	public static final String CD_REAL_ZB = "cdRealZb";
	public static final String TOTAL891 = "total891";
	public static final String TOTAL895 = "total895";
	public static final String TOTAL_REAL = "totalReal";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String REMARK3 = "remark3";
	public static final String REMARK4 = "remark4";
	public static final String REMARK5 = "remark5";



    
    public void save(SummaryDaily transientInstance) {
        log.debug("saving SummaryDaily instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SummaryDaily persistentInstance) {
        log.debug("deleting SummaryDaily instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SummaryDaily findById( java.lang.Integer id) {
        log.debug("getting SummaryDaily instance with id: " + id);
        try {
            SummaryDaily instance = (SummaryDaily) getSession()
                    .get("SummaryDaily", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SummaryDaily instance) {
        log.debug("finding SummaryDaily instance by example");
        try {
            List results = getSession()
                    .createCriteria("SummaryDaily")
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
      log.debug("finding SummaryDaily instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SummaryDaily as model where model." 
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
	
	public List findByItemCode(Object itemCode
	) {
		return findByProperty(ITEM_CODE, itemCode
		);
	}
	
	public List findByItemName(Object itemName
	) {
		return findByProperty(ITEM_NAME, itemName
		);
	}
	
	public List findByWh891(Object wh891
	) {
		return findByProperty(WH891, wh891
		);
	}
	
	public List findByWh891Zb(Object wh891Zb
	) {
		return findByProperty(WH891_ZB, wh891Zb
		);
	}
	
	public List findByWh895(Object wh895
	) {
		return findByProperty(WH895, wh895
		);
	}
	
	public List findByWh895Zb(Object wh895Zb
	) {
		return findByProperty(WH895_ZB, wh895Zb
		);
	}
	
	public List findByWhReal(Object whReal
	) {
		return findByProperty(WH_REAL, whReal
		);
	}
	
	public List findByWhRealZb(Object whRealZb
	) {
		return findByProperty(WH_REAL_ZB, whRealZb
		);
	}
	
	public List findByCd891(Object cd891
	) {
		return findByProperty(CD891, cd891
		);
	}
	
	public List findByCd891Zb(Object cd891Zb
	) {
		return findByProperty(CD891_ZB, cd891Zb
		);
	}
	
	public List findByCd895(Object cd895
	) {
		return findByProperty(CD895, cd895
		);
	}
	
	public List findByCd895Zb(Object cd895Zb
	) {
		return findByProperty(CD895_ZB, cd895Zb
		);
	}
	
	public List findByCdReal(Object cdReal
	) {
		return findByProperty(CD_REAL, cdReal
		);
	}
	
	public List findByCdRealZb(Object cdRealZb
	) {
		return findByProperty(CD_REAL_ZB, cdRealZb
		);
	}
	
	public List findByTotal891(Object total891
	) {
		return findByProperty(TOTAL891, total891
		);
	}
	
	public List findByTotal895(Object total895
	) {
		return findByProperty(TOTAL895, total895
		);
	}
	
	public List findByTotalReal(Object totalReal
	) {
		return findByProperty(TOTAL_REAL, totalReal
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
	
	public List findByRemark4(Object remark4
	) {
		return findByProperty(REMARK4, remark4
		);
	}
	
	public List findByRemark5(Object remark5
	) {
		return findByProperty(REMARK5, remark5
		);
	}
	

	public List findAll() {
		log.debug("finding all SummaryDaily instances");
		try {
			String queryString = "from SummaryDaily";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SummaryDaily merge(SummaryDaily detachedInstance) {
        log.debug("merging SummaryDaily instance");
        try {
            SummaryDaily result = (SummaryDaily) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SummaryDaily instance) {
        log.debug("attaching dirty SummaryDaily instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SummaryDaily instance) {
        log.debug("attaching clean SummaryDaily instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /**
     * 根据代码、起始截止日期查询
     * @param item_code
     * @param bdate
     * @param edate
     * @return
     */
    public List findByItemcodeDate(String item_code,String bdate,String edate) {
        log.debug("from SummaryDaily where item_code= " + item_code
              + " and date=' " + bdate+"-"+edate+"'");
        try {
            List list=new ArrayList();
            String queryString = "from SummaryDaily where item_code= '" + item_code
              + "' and date>='" + bdate+"' and date<='"+edate+"' and total_real>0 order by date";
            Query queryObject = getSession().createQuery(queryString);
            System.out.println(queryString);
            list=queryObject.list();
    		 return list;
        } catch (RuntimeException re) {
           log.error("find by findByItemcodeDate failed", re);
           throw re;
        }
    	}
    
    /**
     * 根据代码、起始截止日期查询
     * @param item_code
     * @param bdate
     * @param edate
     * @return
     */
    public List findByItemcodeDate(String item_code1,String item_code2,String bdate,String edate) {
        try {
            List list=new ArrayList();
            String queryString = "from SummaryDaily where (item_code= '" + item_code1
              + "' or item_code= '" + item_code2+"') and date>='" + bdate+"' and date<='"+edate+"' and total_real>0 order by date";
            Query queryObject = getSession().createQuery(queryString);
            System.out.println(queryString);
            list=queryObject.list();
    		 return list;
        } catch (RuntimeException re) {
           log.error("find by findByItemcodeDate failed", re);
           throw re;
        }
    	}
    /**
     * 根据代码、起始截止日期查询
     * @param item_code
     * @param bdate
     * @param edate
     * @return
     */
    public List findByItemcodeDateWithoutCd891(String item_code,String bdate,String edate) {
        log.debug("from SummaryDaily where item_code= " + item_code
              + " and date=' " + bdate+"-"+edate+"'");
        try {
            List list=new ArrayList();
            String queryString = "from SummaryDaily where item_code= '" + item_code
              + "' and date>='" + bdate+"' and date<='"+edate+"' order by date";
            Query queryObject = getSession().createQuery(queryString);
            list=queryObject.list();
    		 return list;
        } catch (RuntimeException re) {
           log.error("find by findByItemcodeDate failed", re);
           throw re;
        }
    	}

    public SummaryDaily findByItemcodeDate(String item_code,String date) {
        log.debug("from SummaryDaily where item_code= " + item_code
              + " and date=' " + date+"'");
        try {
            List list=new ArrayList();
            SummaryDaily summary= new SummaryDaily();
            String queryString = "from SummaryDaily where item_code= '" + item_code
              + "' and date='" + date+"'";
            Query queryObject = getSession().createQuery(queryString);
            list=queryObject.list();
            if(list.size()>0)
            {
            	summary=(SummaryDaily) list.get(0);
            }
           
    		 return summary;
        } catch (RuntimeException re) {
           log.error("find by findByItemcodeDate failed", re);
           throw re;
        }
    	}
    /*统计不同表不同条件的合计数量*/
    public int countInt(String sqlplus,String table)
    {
        int count=0;
        String sql="";
      
        Object objtmp;
        Query query;
       
        GeneralCheck check =new GeneralCheck();
        try
    	{
    		
    		 sql="select count(*) from "+table+" "+ sqlplus;
    		 query=getSession().createSQLQuery(sql);
    		 objtmp=(Object)query.uniqueResult();
    		 count=check.IsNullInteger(objtmp);
    		 
    	}catch (Exception e) {
    				// TODO Auto-generated catch block
    		
    		e.printStackTrace();
    		log.error(e.toString());
    	}
    		 return count;
    }
    
    /*统计不同表不同栏位的合计数量*/
    public int countColumn(String column,String table,String sqlplus)
    {
        int count=0;
        String sql="";
        Object objtmp;
        Query query;
       
        GeneralCheck check =new GeneralCheck();
        try
    	{
    		 sql="select sum("+column+") from "+table+" "+ sqlplus;
    		 query=getSession().createSQLQuery(sql);
    		 objtmp=(Object)query.uniqueResult();
    		 count=check.IsNullInteger(objtmp);
    		 
    	}catch (Exception e) {
    				// TODO Auto-generated catch block
    		e.printStackTrace();
    		log.error(e.toString());
    	}
    		 return count;
    }

    public double countCDouble(String column,String table,String sqlplus)
    {
    	double count=0.0;
        String sql="";
        Object objtmp;
        GeneralCheck check =new GeneralCheck();
        try
    	{
    		 
    		 sql="select sum("+column+") from "+table+" "+ sqlplus;
    		 Query query=getSession().createSQLQuery(sql);
    		 objtmp=(Object)query.uniqueResult();
    		 count=check.IsNullDouble(objtmp);
    		 
    	}catch (Exception e) {
    				// TODO Auto-generated catch block
    		
    		e.printStackTrace();
    		log.error(e.toString());
    	}
    		 return count;
    }
    /*返回double*/
    public double countDouble(String sqlplus,String table)
    {
        double count=0.0;
        String sql="";
        
        Object objtmp;
        Query query;
       
        GeneralCheck check =new GeneralCheck();
        try
    	{			 
    		 sql="select count(*) from "+table+ " " +sqlplus;
    		 query=getSession().createSQLQuery(sql);
    		 objtmp=(Object)query.uniqueResult();
    		 count=check.IsNullDouble(objtmp);
    		 
    	}catch (Exception e) {
    				// TODO Auto-generated catch block
    		
    		e.printStackTrace();
    		log.error(e.toString());
    	}
    		 return count;
    }
}