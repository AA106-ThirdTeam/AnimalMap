package heibernate_com.second_prodphotos.model;
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
public class Second_ProdPhotosDAO implements Second_ProdPhotos_interface {
	private static final String GET_ALL_STMT = "from Second_ProdPhotosVO order by second_ProdPhotos_Id";
	@Override
	public void insert(Second_ProdPhotosVO second_prodphotosVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(second_prodphotosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Second_ProdPhotosVO second_prodphotosVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(second_prodphotosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String second_ProdPhotos_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Second_ProdPhotosVO where second_ProdPhotos_Id=?");
//			query.setParameter(0, second_ProdPhotos_Id);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Second_ProdPhotosVO second_prodphotosVO = new Second_ProdPhotosVO();
			second_prodphotosVO.setSecond_ProdPhotos_Id(second_ProdPhotos_Id);
			session.delete(second_prodphotosVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方second_prodphotos2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Second_ProdPhotosVO second_prodphotosVO = (Second_ProdPhotosVO) session.get(Second_ProdPhotosVO.class, second_ProdPhotos_Id);
//			session.delete(second_prodphotosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Second_ProdPhotosVO findByPrimaryKey(String second_ProdPhotos_Id) {
		Second_ProdPhotosVO second_prodphotosVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			second_prodphotosVO = (Second_ProdPhotosVO) session.get(Second_ProdPhotosVO.class, second_ProdPhotos_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return second_prodphotosVO;
	}
	@Override
	public List<Second_ProdPhotosVO> getAll() {
		List<Second_ProdPhotosVO> list = null;
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
