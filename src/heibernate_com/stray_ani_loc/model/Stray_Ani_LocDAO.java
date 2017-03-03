package heibernate_com.stray_ani_loc.model;
/*
 Hibernate is providing a factory.getCurrentSession() method for retrieving the current session. A
 new session is opened for the first time of calling this method, and closed when the transaction is
 finished, no matter commit or rollback. But what does it mean by the “current session”? We need to
 tell Hibernate that it should be the session bound with the current thread.
 <hibernate-configuration>
 <session-factory>
 ...
 <property name="current_session_context_class">thread</property>
 ...
 </session-factory>
 </hibernate-configuration>
 */
import org.hibernate.*;
import hibernate.util.HibernateUtil;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
public class Stray_Ani_LocDAO implements Stray_Ani_Loc_interface {
	private static final String GET_ALL_STMT = "from Stray_Ani_LocVO order by str_Ani_Loc_No";
	@Override
	public void insert(Stray_Ani_LocVO stray_ani_locVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stray_ani_locVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Stray_Ani_LocVO stray_ani_locVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stray_ani_locVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String str_Ani_Loc_No) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Stray_Ani_LocVO where str_Ani_Loc_No=?");
//			query.setParameter(0, str_Ani_Loc_No);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Stray_Ani_LocVO stray_ani_locVO = new Stray_Ani_LocVO();
			stray_ani_locVO.setStr_Ani_Loc_No(str_Ani_Loc_No);
			session.delete(stray_ani_locVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方stray_ani_loc2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Stray_Ani_LocVO stray_ani_locVO = (Stray_Ani_LocVO) session.get(Stray_Ani_LocVO.class, str_Ani_Loc_No);
//			session.delete(stray_ani_locVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Stray_Ani_LocVO findByPrimaryKey(String str_Ani_Loc_No) {
		Stray_Ani_LocVO stray_ani_locVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			stray_ani_locVO = (Stray_Ani_LocVO) session.get(Stray_Ani_LocVO.class, str_Ani_Loc_No);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return stray_ani_locVO;
	}
	@Override
	public List<Stray_Ani_LocVO> getAll() {
		List<Stray_Ani_LocVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
    @Override
    public List<Stray_Ani_LocVO> getAll(Map<String, String[]> map,boolean able_like) {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Stray_Ani_LocVO> list = null;
        try {
            Criteria query = session.createCriteria(Stray_Ani_LocVO.class);
            Set<String> keys = map.keySet();
            int count = 0;
            for (String key : keys) {
                String value = map.get(key)[0];
                if (value!=null && value.trim().length()!=0 && !"action".equals(key)) {
                    count++;                    
                    query = get_aCriteria_For_AnyDB(query, key, value,able_like);
                    System.out.println("有送出查詢資料的欄位數count = " + count);
                }
            }
            query.addOrder( Order.asc("str_Ani_Loc_No") );
            list = query.list();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
        return list;
    }	    
    public List<Stray_Ani_LocVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Stray_Ani_LocVO> list = null;
        try {
        	String total_str = "from Stray_Ani_LocVO where ";
            Set<String> keys = map.keySet();
            int count = 0;
            for (String key : keys) {
                String value = map.get(key)[0];
                if (value!=null && value.trim().length()!=0 && !"action".equals(key)) {
                    count++;
                    System.out.println("value : " + value);
                    System.out.println("有送出查詢資料的欄位數count = " + count);
                    System.out.println(count );
                    System.out.println(keys.size() );
                    if (count == keys.size()) {
                    	total_str += key + " =  '" + value + "' ";
					}else{
						total_str += key + " =  '" + value + "' and ";
					}
                }
            }
            System.out.println(total_str);
            Query query = session.createQuery(total_str);           
            list = query.list();
            tx.commit();           
        } catch (RuntimeException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
        return list;
    }	    
	/*
	 *  1. 萬用複合查詢-可由客戶端隨意增減任何想查詢的欄位
	 *  2. 為了避免影響效能:
	 *        所以動態產生萬用SQL的部份,本範例無意採用MetaData的方式,也只針對個別的Table自行視需要而個別製作之
	 * */    
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value,boolean able_like) {
		if ("str_Ani_Loc_No".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("stray_Ani_Id".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("mem_Id".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("str_Ani_LocLat".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("str_Ani_LocLon".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		return query;
	}
}
