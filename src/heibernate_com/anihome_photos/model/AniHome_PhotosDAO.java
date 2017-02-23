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
//			//System.out.println("刪除的筆數=" + query.executeUpdate());
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
}
