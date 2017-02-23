package heibernate_com.emp_purview.model;
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
import heibernate_com.emp.model.EmpVO;
public class Emp_purviewDAO implements Emp_purview_interface {
	private static final String GET_ALL_STMT = "from Emp_purviewVO order by emp_No";
	@Override
	public void insert(Emp_purviewVO emp_purviewVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(emp_purviewVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(Emp_purviewVO emp_purviewVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(emp_purviewVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String emp_No) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete Emp_purviewVO where emp_No=?");
//			query.setParameter(0, emp_No);
//			//System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Emp_purviewVO emp_purviewVO = new Emp_purviewVO();
			EmpVO empVO = new EmpVO();
			empVO.setEmp_No(emp_No);
			emp_purviewVO.setEmpVO(empVO);
			session.delete(emp_purviewVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方emp_purview2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			Emp_purviewVO emp_purviewVO = (Emp_purviewVO) session.get(Emp_purviewVO.class, emp_No);
//			session.delete(emp_purviewVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public Emp_purviewVO findByPrimaryKey(String emp_No) {
		Emp_purviewVO emp_purviewVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			emp_purviewVO = (Emp_purviewVO) session.get(Emp_purviewVO.class, emp_No);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return emp_purviewVO;
	}
	@Override
	public List<Emp_purviewVO> getAll() {
		List<Emp_purviewVO> list = null;
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
