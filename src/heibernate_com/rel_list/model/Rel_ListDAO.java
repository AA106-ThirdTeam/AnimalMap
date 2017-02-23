package heibernate_com.rel_list.model;
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
import heibernate_com.mem.model.MemVO;
public class Rel_ListDAO implements Rel_List_interface {
	private static final String GET_ALL_STMT = "from Rel_ListVO order by rel_MemId";
	@Override
	public void insert(Rel_ListVO rel_listVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(rel_listVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Rel_ListVO rel_listVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(rel_listVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String rel_MemId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Rel_ListVO where rel_MemId=?");
//			query.setParameter(0, rel_MemId);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Rel_ListVO rel_listVO = new Rel_ListVO();
			MemVO memVO = new MemVO();
			memVO.setMem_Id(rel_MemId);
			rel_listVO.setMemVO(memVO);
			session.delete(rel_listVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方rel_list2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Rel_ListVO rel_listVO = (Rel_ListVO) session.get(Rel_ListVO.class, rel_MemId);
//			session.delete(rel_listVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Rel_ListVO findByPrimaryKey(String rel_MemId) {
		Rel_ListVO rel_listVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			rel_listVO = (Rel_ListVO) session.get(Rel_ListVO.class, rel_MemId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return rel_listVO;
	}
	@Override
	public List<Rel_ListVO> getAll() {
		List<Rel_ListVO> list = null;
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
