package heibernate_com.anihome_photos.model;
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
public class AniHome_PhotosDAO implements AniHome_Photos_interface {
	private static final String GET_ALL_STMT = "from AniHome_PhotosVO order by aniHome_Photos_Id";
	@Override
	public void insert(AniHome_PhotosVO anihome_photosVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(anihome_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(AniHome_PhotosVO anihome_photosVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(anihome_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String aniHome_Photos_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete AniHome_PhotosVO where aniHome_Photos_Id=?");
//			query.setParameter(0, aniHome_Photos_Id);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			AniHome_PhotosVO anihome_photosVO = new AniHome_PhotosVO();
			anihome_photosVO.setAniHome_Photos_Id(aniHome_Photos_Id);
			session.delete(anihome_photosVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方anihome_photos2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			AniHome_PhotosVO anihome_photosVO = (AniHome_PhotosVO) session.get(AniHome_PhotosVO.class, aniHome_Photos_Id);
//			session.delete(anihome_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public AniHome_PhotosVO findByPrimaryKey(String aniHome_Photos_Id) {
		AniHome_PhotosVO anihome_photosVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			anihome_photosVO = (AniHome_PhotosVO) session.get(AniHome_PhotosVO.class, aniHome_Photos_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return anihome_photosVO;
	}
	@Override
	public List<AniHome_PhotosVO> getAll() {
		List<AniHome_PhotosVO> list = null;
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
    public List<AniHome_PhotosVO> getAll(Map<String, String[]> map,boolean able_like) {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<AniHome_PhotosVO> list = null;
        try {
            Criteria query = session.createCriteria(AniHome_PhotosVO.class);
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
            query.addOrder( Order.asc("aniHome_Photos_Id") );
            list = query.list();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
        return list;
    }	    
    public List<AniHome_PhotosVO> getAll_ver02(Map<String, String[]> map,boolean able_like) {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<AniHome_PhotosVO> list = null;
        try {
        	String total_str = "from AniHome_PhotosVO where ";
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
		if ("aniHome_Photos_Id".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("aniHome_Id".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("aniHome_Photos_pic".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		return query;
	}
}
