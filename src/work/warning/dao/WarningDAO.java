package work.warning.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.control.pojo.Control;
import work.daily.pojo.DailyStatus;
import work.hn.pojo.SummaryDaily;
import ccb.hibernate.HibernateSessionFactory;

public class WarningDAO {
	
public String findbigtime(){
		
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();
		String bigtime="";		
	    try {  	
                  
            String hql = "select max(time) from DailyStatus where hnSummaryDaily>0";// 条件查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            bigtime =  (String) q.list().get(0);            
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        } finally {
        	
        	trans.commit();
	        session.flush();
	        session.clear();
	        session.close();         
        }
        return bigtime;		
	}
public String findbigtime_bbzt(){
	
	Session session = HibernateSessionFactory.getSession();
	Transaction trans = session.beginTransaction();
	String bigtime="";		
    try {  	
              
        String hql = "select max(time) from DailyStatus ";// 条件查询HQL语句
        Query q = session.createQuery(hql);// 执行查询操作
        bigtime =  (String) q.list().get(0);            
    } catch (HibernateException e) {
        e.printStackTrace();
        System.out.println("查询失败");
    } finally {
    	
    	trans.commit();
        session.flush();
        session.clear();
        session.close();         
    }
    return bigtime;		
}
	public List findcl(String time){
	
		List <SummaryDaily> mylist=new ArrayList<SummaryDaily>();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();			
	    try {
          
            String hql = "from SummaryDaily sd where sd.date='"+time+"' and sd.itemCode='zhcl' ";// 条件查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            mylist = q.list();           
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        } finally {
        	
        	trans.commit();
	        session.flush();
	        session.clear();
	        session.close();   
        }
        return mylist;		
	}
	public List findclByDate(String bdate,String edate){
		
		List <SummaryDaily> mylist=new ArrayList<SummaryDaily>();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();			
	    try {
          
            String hql = "from SummaryDaily sd where sd.date>='"+bdate+"' and sd.date<='"+edate+"' and sd.itemCode='zhcl' ";// 条件查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            mylist = q.list();           
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        } finally {
        	
        	trans.commit();
	        session.flush();
	        session.clear();
	        session.close();   
        }
        return mylist;		
	}
	public List findrs(String time){
		
		List <SummaryDaily> mylist=new ArrayList<SummaryDaily>();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();		 				
	    try {
            
            String hql = "from SummaryDaily sd where sd.date='"+time+"' and sd.itemCode='rs' ";// 条件查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            mylist = q.list();           
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        } finally {
        	

        	trans.commit();
	        session.flush();
	        session.clear();
	        session.close();        
        }
        return mylist;		
	}
	/**
	 * 统计累计值
	 * @param keyword 关键字 wh_real,cd_real
	 * @param begindate 起始日期
	 * @param enddate 截止日期
	 * @return
	 */
	public int findrs(String keyword,String begindate,String enddate){
		
		int result = 0;
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();		 				
	    try {
            
            String sql = "select sum("+keyword+") from t_daily_summary where date>='"+begindate+"' and date<='"+enddate+"' and item_code='rs' ";// 条件查询HQL语句
            String temp = session.createSQLQuery(sql).uniqueResult().toString().replace(".0", "");
            result = Integer.valueOf(temp);
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        } finally {
        	

        	trans.commit();
	        session.flush();
	        session.clear();
	        session.close();        
        }
        return result;		
	}
	
     public List findlv(String time){
		
		List <SummaryDaily> mylist=new ArrayList<SummaryDaily>();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();		
	    try {
           
            String hql = "from SummaryDaily sd where sd.date='"+time+"' and sd.itemCode='lv_zyccl'";// 条件查询HQL语句
            Query q = session.createQuery(hql);// 执行查询操作
            mylist = q.list();           
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("查询失败");
        } finally {
        	
        	trans.commit();
	        session.flush();
	        session.clear();
	        session.close(); 
        }
        return mylist;		
	}
     
     public List findyj(){
 		
 		List <Control> mylist=new ArrayList<Control>();
 		Session session = HibernateSessionFactory.getSession();
    	Transaction trans = session.beginTransaction();			
 	    try {
            
             String hql = "from Control cl   ";// 条件查询HQL语句
             Query q = session.createQuery(hql);// 执行查询操作
             mylist = q.list();           
         } catch (HibernateException e) {
             e.printStackTrace();
             System.out.println("查询失败");
         } finally {
         	
        	trans.commit();
 	        session.flush();
 	        session.clear();
 	        session.close();  
         }
         return mylist;		
         
 	}
     public List findbbzt(String time){//报表状态
  		
  		List <DailyStatus> mylist=new ArrayList<DailyStatus>();
  		Session session = HibernateSessionFactory.getSession();
     	Transaction trans = session.beginTransaction();			
  	    try {
             
              String hql = "from DailyStatus ds where time='"+time+"'";// 条件查询HQL语句
              Query q = session.createQuery(hql);// 执行查询操作
              mylist = q.list();           
          } catch (HibernateException e) {
              e.printStackTrace();
              System.out.println("查询失败");
          } finally {
          	
         	trans.commit();
  	        session.flush();
  	        session.clear();
  	        session.close();  
          }
          return mylist;	
     }
}
