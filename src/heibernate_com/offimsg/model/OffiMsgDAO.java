package heibernate_com.offimsg.model;
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
public class OffiMsgDAO implements OffiMsg_interface {
	private static final String GET_ALL_STMT = "from OffiMsgVO order by offiMsg_Id";
	@Override
	public void insert(OffiMsgVO offimsgVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(offimsgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(OffiMsgVO offimsgVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(offimsgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String offiMsg_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete OffiMsgVO where offiMsg_Id=?");
//			query.setParameter(0, offiMsg_Id);
//			System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			OffiMsgVO offimsgVO = new OffiMsgVO();
			offimsgVO.setOffiMsg_Id(offiMsg_Id);
			session.delete(offimsgVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方offimsg2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			OffiMsgVO offimsgVO = (OffiMsgVO) session.get(OffiMsgVO.class, offiMsg_Id);
//			session.delete(offimsgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public OffiMsgVO findByPrimaryKey(String offiMsg_Id) {
		OffiMsgVO offimsgVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			offimsgVO = (OffiMsgVO) session.get(OffiMsgVO.class, offiMsg_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return offimsgVO;
	}
	@Override
	public List<OffiMsgVO> getAll() {
		List<OffiMsgVO> list = null;
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
