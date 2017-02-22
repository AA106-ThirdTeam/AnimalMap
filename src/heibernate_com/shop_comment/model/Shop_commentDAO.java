package heibernate_com.shop_comment.model;
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
public class Shop_commentDAO implements Shop_comment_interface {
	private static final String GET_ALL_STMT = "from Shop_commentVO order by shopComment_Id";
	@Override
	public void insert(Shop_commentVO shop_commentVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(shop_commentVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Shop_commentVO shop_commentVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(shop_commentVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String shopComment_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Shop_commentVO where shopComment_Id=?");
//			query.setParameter(0, shopComment_Id);
//			//System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Shop_commentVO shop_commentVO = new Shop_commentVO();
			shop_commentVO.setShopComment_Id(shopComment_Id);
			session.delete(shop_commentVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方shop_comment2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Shop_commentVO shop_commentVO = (Shop_commentVO) session.get(Shop_commentVO.class, shopComment_Id);
//			session.delete(shop_commentVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Shop_commentVO findByPrimaryKey(String shopComment_Id) {
		Shop_commentVO shop_commentVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			shop_commentVO = (Shop_commentVO) session.get(Shop_commentVO.class, shopComment_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return shop_commentVO;
	}
	@Override
	public List<Shop_commentVO> getAll() {
		List<Shop_commentVO> list = null;
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
}
