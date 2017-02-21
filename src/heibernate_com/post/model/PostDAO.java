package heibernate_com.post.model;
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
public class PostDAO implements Post_interface {
	private static final String GET_ALL_STMT = "from PostVO order by post_Id";
	@Override
	public void insert(PostVO postVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(postVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(PostVO postVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(postVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String post_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete PostVO where post_Id=?");
//			query.setParameter(0, post_Id);
//			System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			PostVO postVO = new PostVO();
			postVO.setPost_Id(post_Id);
			session.delete(postVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方post2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			PostVO postVO = (PostVO) session.get(PostVO.class, post_Id);
//			session.delete(postVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public PostVO findByPrimaryKey(String post_Id) {
		PostVO postVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			postVO = (PostVO) session.get(PostVO.class, post_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return postVO;
	}
	@Override
	public List<PostVO> getAll() {
		List<PostVO> list = null;
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
