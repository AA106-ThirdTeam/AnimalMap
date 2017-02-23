package heibernate_com.emg_help.model;
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
public class Emg_HelpDAO implements Emg_Help_interface {
	private static final String GET_ALL_STMT = "from Emg_HelpVO order by emg_H_Id";
	@Override
	public void insert(Emg_HelpVO emg_helpVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(emg_helpVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Emg_HelpVO emg_helpVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(emg_helpVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String emg_H_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Emg_HelpVO where emg_H_Id=?");
//			query.setParameter(0, emg_H_Id);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Emg_HelpVO emg_helpVO = new Emg_HelpVO();
			emg_helpVO.setEmg_H_Id(emg_H_Id);
			session.delete(emg_helpVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方emg_help2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Emg_HelpVO emg_helpVO = (Emg_HelpVO) session.get(Emg_HelpVO.class, emg_H_Id);
//			session.delete(emg_helpVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Emg_HelpVO findByPrimaryKey(String emg_H_Id) {
		Emg_HelpVO emg_helpVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			emg_helpVO = (Emg_HelpVO) session.get(Emg_HelpVO.class, emg_H_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return emg_helpVO;
	}
	@Override
	public List<Emg_HelpVO> getAll() {
		List<Emg_HelpVO> list = null;
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
