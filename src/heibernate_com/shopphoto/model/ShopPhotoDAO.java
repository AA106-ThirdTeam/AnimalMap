package heibernate_com.shopphoto.model;
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
public class ShopPhotoDAO implements ShopPhoto_interface {
	private static final String GET_ALL_STMT = "from ShopPhotoVO order by shopPhoto_Id";
	@Override
	public void insert(ShopPhotoVO shopphotoVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(shopphotoVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(ShopPhotoVO shopphotoVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(shopphotoVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String shopPhoto_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete ShopPhotoVO where shopPhoto_Id=?");
//			query.setParameter(0, shopPhoto_Id);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			ShopPhotoVO shopphotoVO = new ShopPhotoVO();
			shopphotoVO.setShopPhoto_Id(shopPhoto_Id);
			session.delete(shopphotoVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方shopphoto2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			ShopPhotoVO shopphotoVO = (ShopPhotoVO) session.get(ShopPhotoVO.class, shopPhoto_Id);
//			session.delete(shopphotoVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public ShopPhotoVO findByPrimaryKey(String shopPhoto_Id) {
		ShopPhotoVO shopphotoVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			shopphotoVO = (ShopPhotoVO) session.get(ShopPhotoVO.class, shopPhoto_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return shopphotoVO;
	}
	@Override
	public List<ShopPhotoVO> getAll() {
		List<ShopPhotoVO> list = null;
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
