package work.hn.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import work.hn.pojo.Summary;
import work.util.GeneralCheck;

/**
 	* A data access object (DAO) providing persistence and search support for Summary entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Summary
  * @author MyEclipse Persistence Tools 
 */

public class SummaryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SummaryDAO.class);
		//property constants
	public static final String JG = "jg";
	public static final String TYPE = "type";
	public static final String CL_DAY = "clDay";
	public static final String CL_AVER = "clAver";
	public static final String CL_DAY_RMB = "clDayRmb";
	public static final String CL_DAY_WH = "clDayWh";
	public static final String CL_DAY_JH = "clDayJh";
	public static final String CL_DAY_SH = "clDaySh";
	public static final String CL_DAY_JY = "clDayJy";
	public static final String CL_DAY_FXQ = "clDayFxq";
	public static final String PERCLTIME_DAY = "percltimeDay";
	public static final String PERCLTIME_AVER = "percltimeAver";
	public static final String ZYCCL_DAY = "zycclDay";
	public static final String ZYCCL_AVER = "zycclAver";
	public static final String ZYTPL_DAY = "zytplDay";
	public static final String ZYTPL_AVER = "zytplAver";
	public static final String ZYCXL_DAY = "zycxlDay";
	public static final String ZYCXL_AVER = "zycxlAver";
	public static final String CC891_DAY = "cc891Day";
	public static final String CC891_AVER = "cc891Aver";
	public static final String TP891_DAY = "tp891Day";
	public static final String TP891_AVER = "tp891Aver";
	public static final String CX891_DAY = "cx891Day";
	public static final String CX891_AVER = "cx891Aver";
	public static final String CC895_DAY = "cc895Day";
	public static final String CC895_AVER = "cc895Aver";
	public static final String TP895_DAY = "tp895Day";
	public static final String TP895_AVER = "tp895Aver";
	public static final String CX895_DAY = "cx895Day";
	public static final String CX895_AVER = "cx895Aver";
	public static final String ZWD = "zwd";
	public static final String LJZWD = "ljzwd";
	public static final String DATE = "date";



    
    public void save(Summary transientInstance) {
        log.debug("saving Summary instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Summary persistentInstance) {
        log.debug("deleting Summary instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Summary findById( java.lang.Integer id) {
        log.debug("getting Summary instance with id: " + id);
        try {
            Summary instance = (Summary) getSession()
                    .get("Summary", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Summary instance) {
        log.debug("finding Summary instance by example");
        try {
            List results = getSession()
                    .createCriteria("Summary")
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
      log.debug("finding Summary instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Summary as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByJg(Object jg
	) {
		return findByProperty(JG, jg
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByClDay(Object clDay
	) {
		return findByProperty(CL_DAY, clDay
		);
	}
	
	public List findByClAver(Object clAver
	) {
		return findByProperty(CL_AVER, clAver
		);
	}
	
	public List findByClDayRmb(Object clDayRmb
	) {
		return findByProperty(CL_DAY_RMB, clDayRmb
		);
	}
	
	public List findByClDayWh(Object clDayWh
	) {
		return findByProperty(CL_DAY_WH, clDayWh
		);
	}
	
	public List findByClDayJh(Object clDayJh
	) {
		return findByProperty(CL_DAY_JH, clDayJh
		);
	}
	
	public List findByClDaySh(Object clDaySh
	) {
		return findByProperty(CL_DAY_SH, clDaySh
		);
	}
	
	public List findByClDayJy(Object clDayJy
	) {
		return findByProperty(CL_DAY_JY, clDayJy
		);
	}
	
	public List findByClDayFxq(Object clDayFxq
	) {
		return findByProperty(CL_DAY_FXQ, clDayFxq
		);
	}
	
	public List findByPercltimeDay(Object percltimeDay
	) {
		return findByProperty(PERCLTIME_DAY, percltimeDay
		);
	}
	
	public List findByPercltimeAver(Object percltimeAver
	) {
		return findByProperty(PERCLTIME_AVER, percltimeAver
		);
	}
	
	public List findByZycclDay(Object zycclDay
	) {
		return findByProperty(ZYCCL_DAY, zycclDay
		);
	}
	
	public List findByZycclAver(Object zycclAver
	) {
		return findByProperty(ZYCCL_AVER, zycclAver
		);
	}
	
	public List findByZytplDay(Object zytplDay
	) {
		return findByProperty(ZYTPL_DAY, zytplDay
		);
	}
	
	public List findByZytplAver(Object zytplAver
	) {
		return findByProperty(ZYTPL_AVER, zytplAver
		);
	}
	
	public List findByZycxlDay(Object zycxlDay
	) {
		return findByProperty(ZYCXL_DAY, zycxlDay
		);
	}
	
	public List findByZycxlAver(Object zycxlAver
	) {
		return findByProperty(ZYCXL_AVER, zycxlAver
		);
	}
	
	public List findByCc891Day(Object cc891Day
	) {
		return findByProperty(CC891_DAY, cc891Day
		);
	}
	
	public List findByCc891Aver(Object cc891Aver
	) {
		return findByProperty(CC891_AVER, cc891Aver
		);
	}
	
	public List findByTp891Day(Object tp891Day
	) {
		return findByProperty(TP891_DAY, tp891Day
		);
	}
	
	public List findByTp891Aver(Object tp891Aver
	) {
		return findByProperty(TP891_AVER, tp891Aver
		);
	}
	
	public List findByCx891Day(Object cx891Day
	) {
		return findByProperty(CX891_DAY, cx891Day
		);
	}
	
	public List findByCx891Aver(Object cx891Aver
	) {
		return findByProperty(CX891_AVER, cx891Aver
		);
	}
	
	public List findByCc895Day(Object cc895Day
	) {
		return findByProperty(CC895_DAY, cc895Day
		);
	}
	
	public List findByCc895Aver(Object cc895Aver
	) {
		return findByProperty(CC895_AVER, cc895Aver
		);
	}
	
	public List findByTp895Day(Object tp895Day
	) {
		return findByProperty(TP895_DAY, tp895Day
		);
	}
	
	public List findByTp895Aver(Object tp895Aver
	) {
		return findByProperty(TP895_AVER, tp895Aver
		);
	}
	
	public List findByCx895Day(Object cx895Day
	) {
		return findByProperty(CX895_DAY, cx895Day
		);
	}
	
	public List findByCx895Aver(Object cx895Aver
	) {
		return findByProperty(CX895_AVER, cx895Aver
		);
	}
	
	public List findByZwd(Object zwd
	) {
		return findByProperty(ZWD, zwd
		);
	}
	
	public List findByLjzwd(Object ljzwd
	) {
		return findByProperty(LJZWD, ljzwd
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	

	public List findAll() {
		log.debug("finding all Summary instances");
		try {
			String queryString = "from Summary";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Summary merge(Summary detachedInstance) {
        log.debug("merging Summary instance");
        try {
            Summary result = (Summary) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Summary instance) {
        log.debug("attaching dirty Summary instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Summary instance) {
        log.debug("attaching clean Summary instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
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
    /*统计不同表double栏位的合计数量*/
    public int countColumnd(String column,String table,String sqlplus)
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
    		 count=check.DoubleToInteger0(check.IsNullDouble(objtmp));
    		 
    	}catch (Exception e) {
    				// TODO Auto-generated catch block
    		e.printStackTrace();
    		log.error(e.toString());
    	}
    		 return count;
    }
    /*统计不同表不同栏位的最大值int*/
    public int countMax(String column,String table,String sqlplus)
    {
        int count=0;
        String sql="";
        
        Object objtmp;
        Query query;
       
        GeneralCheck check =new GeneralCheck();
        try
    	{
    		 sql="select max("+column+") from "+table+" "+ sqlplus;
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
    /*统计不同表不同栏位的最小值int*/
    public int countMin(String column,String table,String sqlplus)
    {
        int count=0;
        String sql="";
        
        Object objtmp;
        Query query;
       
        GeneralCheck check =new GeneralCheck();
        try
    	{
    		 sql="select min("+column+") from "+table+" "+ sqlplus;
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

    /*统计不同表不同栏位的最大值double*/
    public double countMaxd(String column,String table,String sqlplus)
    {
        double count=0;
        String sql="";
        
        Object objtmp;
        Query query;
       
        GeneralCheck check =new GeneralCheck();
        try
    	{
    		 sql="select max("+column+") from "+table+" "+ sqlplus;
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
    /*统计不同表不同栏位的最小值int*/
    public double countMind(String column,String table,String sqlplus)
    {
        double count=0;
        String sql="";
        
        Object objtmp;
        Query query;
       
        GeneralCheck check =new GeneralCheck();
        try
    	{
    		 sql="select min("+column+") from "+table+" "+ sqlplus;
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
    public List findByJgTypeDate(String jg,String type,String bdate,String edate) {
    	log.debug("finding all Summary instances");
    	try {
    		String queryString = "from Summary as s where s.jg='"+jg+"' and s.type='"+type+"' and s.date>='"+bdate+"' and s.date<='"+edate+"' order by s.date";
    		Query queryObject = getSession().createQuery(queryString);
    		return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}