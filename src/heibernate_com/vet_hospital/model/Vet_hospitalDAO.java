package heibernate_com.vet_hospital.model;
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
public class Vet_hospitalDAO implements Vet_hospital_interface {
	private static final String GET_ALL_STMT = "from Vet_hospitalVO order by hos_Id";
	@Override
	public void insert(Vet_hospitalVO vet_hospitalVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vet_hospitalVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Vet_hospitalVO vet_hospitalVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vet_hospitalVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String hos_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Vet_hospitalVO where hos_Id=?");
//			query.setParameter(0, hos_Id);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Vet_hospitalVO vet_hospitalVO = new Vet_hospitalVO();
			vet_hospitalVO.setHos_Id(hos_Id);
			session.delete(vet_hospitalVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方vet_hospital2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Vet_hospitalVO vet_hospitalVO = (Vet_hospitalVO) session.get(Vet_hospitalVO.class, hos_Id);
//			session.delete(vet_hospitalVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Vet_hospitalVO findByPrimaryKey(String hos_Id) {
		Vet_hospitalVO vet_hospitalVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vet_hospitalVO = (Vet_hospitalVO) session.get(Vet_hospitalVO.class, hos_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vet_hospitalVO;
	}
	@Override
	public List<Vet_hospitalVO> getAll() {
		List<Vet_hospitalVO> list = null;
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
