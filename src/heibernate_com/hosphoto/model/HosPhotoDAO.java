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
//			//System.out.println("刪除的筆數=" + query.executeUpdate());
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
}
