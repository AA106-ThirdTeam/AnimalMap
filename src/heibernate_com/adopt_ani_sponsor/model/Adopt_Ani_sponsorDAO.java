package heibernate_com.adopt_ani_sponsor.model;
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
public class Adopt_Ani_sponsorDAO implements Adopt_Ani_sponsor_interface {
	private static final String GET_ALL_STMT = "from Adopt_Ani_sponsorVO order by ado_Ani_Spo_No";
	@Override
	public void insert(Adopt_Ani_sponsorVO adopt_ani_sponsorVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adopt_ani_sponsorVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Adopt_Ani_sponsorVO adopt_ani_sponsorVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adopt_ani_sponsorVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String ado_Ani_Spo_No) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Adopt_Ani_sponsorVO where ado_Ani_Spo_No=?");
//			query.setParameter(0, ado_Ani_Spo_No);
//			//System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Adopt_Ani_sponsorVO adopt_ani_sponsorVO = new Adopt_Ani_sponsorVO();
			adopt_ani_sponsorVO.setAdo_Ani_Spo_No(ado_Ani_Spo_No);
			session.delete(adopt_ani_sponsorVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方adopt_ani_sponsor2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Adopt_Ani_sponsorVO adopt_ani_sponsorVO = (Adopt_Ani_sponsorVO) session.get(Adopt_Ani_sponsorVO.class, ado_Ani_Spo_No);
//			session.delete(adopt_ani_sponsorVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Adopt_Ani_sponsorVO findByPrimaryKey(String ado_Ani_Spo_No) {
		Adopt_Ani_sponsorVO adopt_ani_sponsorVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			adopt_ani_sponsorVO = (Adopt_Ani_sponsorVO) session.get(Adopt_Ani_sponsorVO.class, ado_Ani_Spo_No);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return adopt_ani_sponsorVO;
	}
	@Override
	public List<Adopt_Ani_sponsorVO> getAll() {
		List<Adopt_Ani_sponsorVO> list = null;
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
