package heibernate_com.second_prodmsg.model;
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
public class Second_ProdMsgDAO implements Second_ProdMsg_interface {
	private static final String GET_ALL_STMT = "from Second_ProdMsgVO order by second_ProdMsg_Id";
	@Override
	public void insert(Second_ProdMsgVO second_prodmsgVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(second_prodmsgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Second_ProdMsgVO second_prodmsgVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(second_prodmsgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String second_ProdMsg_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Second_ProdMsgVO where second_ProdMsg_Id=?");
//			query.setParameter(0, second_ProdMsg_Id);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Second_ProdMsgVO second_prodmsgVO = new Second_ProdMsgVO();
			second_prodmsgVO.setSecond_ProdMsg_Id(second_ProdMsg_Id);
			session.delete(second_prodmsgVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方second_prodmsg2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Second_ProdMsgVO second_prodmsgVO = (Second_ProdMsgVO) session.get(Second_ProdMsgVO.class, second_ProdMsg_Id);
//			session.delete(second_prodmsgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Second_ProdMsgVO findByPrimaryKey(String second_ProdMsg_Id) {
		Second_ProdMsgVO second_prodmsgVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			second_prodmsgVO = (Second_ProdMsgVO) session.get(Second_ProdMsgVO.class, second_ProdMsg_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return second_prodmsgVO;
	}
	@Override
	public List<Second_ProdMsgVO> getAll() {
		List<Second_ProdMsgVO> list = null;
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
