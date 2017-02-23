package heibernate_com.adopt_ani_photos.model;
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
public class Adopt_Ani_photosDAO implements Adopt_Ani_photos_interface {
	private static final String GET_ALL_STMT = "from Adopt_Ani_photosVO order by ado_Ani_Pic_No";
	@Override
	public void insert(Adopt_Ani_photosVO adopt_ani_photosVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adopt_ani_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Adopt_Ani_photosVO adopt_ani_photosVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adopt_ani_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String ado_Ani_Pic_No) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Adopt_Ani_photosVO where ado_Ani_Pic_No=?");
//			query.setParameter(0, ado_Ani_Pic_No);
//			//System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Adopt_Ani_photosVO adopt_ani_photosVO = new Adopt_Ani_photosVO();
			adopt_ani_photosVO.setAdo_Ani_Pic_No(ado_Ani_Pic_No);
			session.delete(adopt_ani_photosVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方adopt_ani_photos2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Adopt_Ani_photosVO adopt_ani_photosVO = (Adopt_Ani_photosVO) session.get(Adopt_Ani_photosVO.class, ado_Ani_Pic_No);
//			session.delete(adopt_ani_photosVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Adopt_Ani_photosVO findByPrimaryKey(String ado_Ani_Pic_No) {
		Adopt_Ani_photosVO adopt_ani_photosVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			adopt_ani_photosVO = (Adopt_Ani_photosVO) session.get(Adopt_Ani_photosVO.class, ado_Ani_Pic_No);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return adopt_ani_photosVO;
	}
	@Override
	public List<Adopt_Ani_photosVO> getAll() {
		List<Adopt_Ani_photosVO> list = null;
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
