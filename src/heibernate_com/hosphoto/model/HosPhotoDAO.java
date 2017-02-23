package heibernate_com.hosphoto.model;
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
public class HosPhotoDAO implements HosPhoto_interface {
	private static final String GET_ALL_STMT = "from HosPhotoVO order by hosPhoto_Id";
	@Override
	public void insert(HosPhotoVO hosphotoVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(hosphotoVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(HosPhotoVO hosphotoVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(hosphotoVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String hosPhoto_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete HosPhotoVO where hosPhoto_Id=?");
//			query.setParameter(0, hosPhoto_Id);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			HosPhotoVO hosphotoVO = new HosPhotoVO();
			hosphotoVO.setHosPhoto_Id(hosPhoto_Id);
			session.delete(hosphotoVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方hosphoto2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			HosPhotoVO hosphotoVO = (HosPhotoVO) session.get(HosPhotoVO.class, hosPhoto_Id);
//			session.delete(hosphotoVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public HosPhotoVO findByPrimaryKey(String hosPhoto_Id) {
		HosPhotoVO hosphotoVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			hosphotoVO = (HosPhotoVO) session.get(HosPhotoVO.class, hosPhoto_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return hosphotoVO;
	}
	@Override
	public List<HosPhotoVO> getAll() {
		List<HosPhotoVO> list = null;
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
    public List<HosPhotoVO> getAll(Map<String, String[]> map) {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<HosPhotoVO> list = null;
        try {
            Criteria query = session.createCriteria(HosPhotoVO.class);
            Set<String> keys = map.keySet();
            int count = 0;
            for (String key : keys) {
                String value = map.get(key)[0];
                if (value!=null && value.trim().length()!=0 && !"action".equals(key)) {
                    count++;                    
                    query = get_aCriteria_For_AnyDB(query, key, value);
                    System.out.println("有送出查詢資料的欄位數count = " + count);
                }
            }
            query.addOrder( Order.asc("hosPhoto_Id") );
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
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("hosPhoto_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hosPhoto_photo".equals(columnName))    //用於byte[]
			query.add(Restrictions.eq(columnName, null)); 
		if ("isDisp_HosPhoto".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hosPhoto_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hosPhoto_extent".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		return query;
	}
}
