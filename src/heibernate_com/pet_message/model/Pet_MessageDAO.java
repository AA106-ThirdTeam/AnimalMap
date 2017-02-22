package heibernate_com.pet_message.model;
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
public class Pet_MessageDAO implements Pet_Message_interface {
	private static final String GET_ALL_STMT = "from Pet_MessageVO order by pet_Mes_No";
	@Override
	public void insert(Pet_MessageVO pet_messageVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(pet_messageVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Pet_MessageVO pet_messageVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(pet_messageVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String pet_Mes_No) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Pet_MessageVO where pet_Mes_No=?");
//			query.setParameter(0, pet_Mes_No);
//			//System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Pet_MessageVO pet_messageVO = new Pet_MessageVO();
			pet_messageVO.setPet_Mes_No(pet_Mes_No);
			session.delete(pet_messageVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方pet_message2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Pet_MessageVO pet_messageVO = (Pet_MessageVO) session.get(Pet_MessageVO.class, pet_Mes_No);
//			session.delete(pet_messageVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Pet_MessageVO findByPrimaryKey(String pet_Mes_No) {
		Pet_MessageVO pet_messageVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			pet_messageVO = (Pet_MessageVO) session.get(Pet_MessageVO.class, pet_Mes_No);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return pet_messageVO;
	}
	@Override
	public List<Pet_MessageVO> getAll() {
		List<Pet_MessageVO> list = null;
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
