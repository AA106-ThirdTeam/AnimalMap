package heibernate_com.stray_ani_message.model;
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
public class Stray_Ani_messageDAO implements Stray_Ani_message_interface {
	private static final String GET_ALL_STMT = "from Stray_Ani_messageVO order by str_Ani_Mes_No";
	@Override
	public void insert(Stray_Ani_messageVO stray_ani_messageVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stray_ani_messageVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Stray_Ani_messageVO stray_ani_messageVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(stray_ani_messageVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String str_Ani_Mes_No) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Stray_Ani_messageVO where str_Ani_Mes_No=?");
//			query.setParameter(0, str_Ani_Mes_No);
//			System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Stray_Ani_messageVO stray_ani_messageVO = new Stray_Ani_messageVO();
			stray_ani_messageVO.setStr_Ani_Mes_No(str_Ani_Mes_No);
			session.delete(stray_ani_messageVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方stray_ani_message2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Stray_Ani_messageVO stray_ani_messageVO = (Stray_Ani_messageVO) session.get(Stray_Ani_messageVO.class, str_Ani_Mes_No);
//			session.delete(stray_ani_messageVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Stray_Ani_messageVO findByPrimaryKey(String str_Ani_Mes_No) {
		Stray_Ani_messageVO stray_ani_messageVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			stray_ani_messageVO = (Stray_Ani_messageVO) session.get(Stray_Ani_messageVO.class, str_Ani_Mes_No);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return stray_ani_messageVO;
	}
	@Override
	public List<Stray_Ani_messageVO> getAll() {
		List<Stray_Ani_messageVO> list = null;
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
