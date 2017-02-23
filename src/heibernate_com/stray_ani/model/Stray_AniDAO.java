package heibernate_com.stray_ani.model;
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
public class Stray_AniDAO implements Stray_Ani_interface {
	private static final String GET_ALL_STMT = "from Stray_AniVO order by stray_Ani_Id";
	@Override
	public void insert(Stray_AniVO stray_aniVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stray_aniVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Stray_AniVO stray_aniVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stray_aniVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String stray_Ani_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Stray_AniVO where stray_Ani_Id=?");
//			query.setParameter(0, stray_Ani_Id);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Stray_AniVO stray_aniVO = new Stray_AniVO();
			stray_aniVO.setStray_Ani_Id(stray_Ani_Id);
			session.delete(stray_aniVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方stray_ani2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Stray_AniVO stray_aniVO = (Stray_AniVO) session.get(Stray_AniVO.class, stray_Ani_Id);
//			session.delete(stray_aniVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Stray_AniVO findByPrimaryKey(String stray_Ani_Id) {
		Stray_AniVO stray_aniVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			stray_aniVO = (Stray_AniVO) session.get(Stray_AniVO.class, stray_Ani_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return stray_aniVO;
	}
	@Override
	public List<Stray_AniVO> getAll() {
		List<Stray_AniVO> list = null;
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
