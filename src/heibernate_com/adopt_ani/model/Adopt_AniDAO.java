package heibernate_com.adopt_ani.model;
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
public class Adopt_AniDAO implements Adopt_Ani_interface {
	private static final String GET_ALL_STMT = "from Adopt_AniVO order by adopt_Ani_Id";
	@Override
	public void insert(Adopt_AniVO adopt_aniVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adopt_aniVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Adopt_AniVO adopt_aniVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adopt_aniVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String adopt_Ani_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Adopt_AniVO where adopt_Ani_Id=?");
//			query.setParameter(0, adopt_Ani_Id);
//			//System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Adopt_AniVO adopt_aniVO = new Adopt_AniVO();
			adopt_aniVO.setAdopt_Ani_Id(adopt_Ani_Id);
			session.delete(adopt_aniVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方adopt_ani2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Adopt_AniVO adopt_aniVO = (Adopt_AniVO) session.get(Adopt_AniVO.class, adopt_Ani_Id);
//			session.delete(adopt_aniVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Adopt_AniVO findByPrimaryKey(String adopt_Ani_Id) {
		Adopt_AniVO adopt_aniVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			adopt_aniVO = (Adopt_AniVO) session.get(Adopt_AniVO.class, adopt_Ani_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return adopt_aniVO;
	}
	@Override
	public List<Adopt_AniVO> getAll() {
		List<Adopt_AniVO> list = null;
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
