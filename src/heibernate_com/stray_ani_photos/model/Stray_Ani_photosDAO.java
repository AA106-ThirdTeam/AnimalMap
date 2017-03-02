package heibernate_com.stray_ani_photos.model;
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
public class Stray_Ani_photosDAO implements Stray_Ani_photos_interface {
	private static final String GET_ALL_STMT = "from Stray_Ani_photosVO order by str_Ani_Pic_No";
	@Override
	public void insert(Stray_Ani_photosVO stray_ani_photosVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stray_ani_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Stray_Ani_photosVO stray_ani_photosVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stray_ani_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String str_Ani_Pic_No) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Stray_Ani_photosVO where str_Ani_Pic_No=?");
//			query.setParameter(0, str_Ani_Pic_No);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Stray_Ani_photosVO stray_ani_photosVO = new Stray_Ani_photosVO();
			stray_ani_photosVO.setStr_Ani_Pic_No(str_Ani_Pic_No);
			session.delete(stray_ani_photosVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方stray_ani_photos2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Stray_Ani_photosVO stray_ani_photosVO = (Stray_Ani_photosVO) session.get(Stray_Ani_photosVO.class, str_Ani_Pic_No);
//			session.delete(stray_ani_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Stray_Ani_photosVO findByPrimaryKey(String str_Ani_Pic_No) {
		Stray_Ani_photosVO stray_ani_photosVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			stray_ani_photosVO = (Stray_Ani_photosVO) session.get(Stray_Ani_photosVO.class, str_Ani_Pic_No);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return stray_ani_photosVO;
	}
	@Override
	public List<Stray_Ani_photosVO> getAll() {
		List<Stray_Ani_photosVO> list = null;
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
    public List<Stray_Ani_photosVO> getAll(Map<String, String[]> map,boolean able_like) {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Stray_Ani_photosVO> list = null;
        try {
            Criteria query = session.createCriteria(Stray_Ani_photosVO.class);
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
            query.addOrder( Order.asc("str_Ani_Pic_No") );
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
		if ("str_Ani_Pic_No".equals(columnName)){    //用於varchar
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
		if ("stray_Ani_Pic".equals(columnName))    //用於byte[]
			query.add(Restrictions.eq(columnName, null)); 
		if ("stray_Pic_name".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("stray_Pic_nameEX".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("stray_Pic_time".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("stray_Pic_type".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		return query;
	}
}
