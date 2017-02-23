package heibernate_com.joinlist.model;
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
import heibernate_com.pet_group.model.Pet_groupVO;
public class JoinListDAO implements JoinList_interface {
	private static final String GET_ALL_STMT = "from JoinListVO order by joinList_GrpId";
	@Override
	public void insert(JoinListVO joinlistVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(joinlistVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(JoinListVO joinlistVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(joinlistVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String joinList_GrpId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete JoinListVO where joinList_GrpId=?");
//			query.setParameter(0, joinList_GrpId);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			JoinListVO joinlistVO = new JoinListVO();
			Pet_groupVO pet_groupVO = new Pet_groupVO();
			pet_groupVO.setGrp_Id(joinList_GrpId);
			joinlistVO.setPet_groupVO(pet_groupVO);
			session.delete(joinlistVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方joinlist2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			JoinListVO joinlistVO = (JoinListVO) session.get(JoinListVO.class, joinList_GrpId);
//			session.delete(joinlistVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public JoinListVO findByPrimaryKey(String joinList_GrpId) {
		JoinListVO joinlistVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			joinlistVO = (JoinListVO) session.get(JoinListVO.class, joinList_GrpId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return joinlistVO;
	}
	@Override
	public List<JoinListVO> getAll() {
		List<JoinListVO> list = null;
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
    public List<JoinListVO> getAll(Map<String, String[]> map) {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<JoinListVO> list = null;
        try {
            Criteria query = session.createCriteria(JoinListVO.class);
            Set<String> keys = map.keySet();
            int count = 0;
            for (String key : keys) {
                String value = map.get(key)[0];
                if (value!=null && value.trim().length()!=0 && !"action".equals(key)) {
                    count++;                    
                    query = get_aCriteria_For_AnyDB(query, key, value,true);
                    System.out.println("有送出查詢資料的欄位數count = " + count);
                }
            }
            query.addOrder( Order.asc("joinList_GrpId") );
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
		return query;
	}
}
