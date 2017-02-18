package heibernate_com.anihome_msg.model;
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
public class AniHome_MsgDAO implements AniHome_Msg_interface {
	private static final String GET_ALL_STMT = "from AniHome_MsgVO order by aniHome_Msg_Id";
	@Override
	public void insert(AniHome_MsgVO anihome_msgVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(anihome_msgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(AniHome_MsgVO anihome_msgVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(anihome_msgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(Integer aniHome_Msg_Id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete AniHome_MsgVO where aniHome_Msg_Id=?");
//			query.setParameter(0, aniHome_Msg_Id);
//			System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			AniHome_MsgVO anihome_msgVO = new AniHome_MsgVO();
			anihome_msgVO.setAniHome_Msg_Id(aniHome_Msg_Id);
			session.delete(anihome_msgVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方anihome_msg2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			AniHome_MsgVO anihome_msgVO = (AniHome_MsgVO) session.get(AniHome_MsgVO.class, aniHome_Msg_Id);
//			session.delete(anihome_msgVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public AniHome_MsgVO findByPrimaryKey(Integer aniHome_Msg_Id) {
		AniHome_MsgVO anihome_msgVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			anihome_msgVO = (AniHome_MsgVO) session.get(AniHome_MsgVO.class, aniHome_Msg_Id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return anihome_msgVO;
	}
	@Override
	public List<AniHome_MsgVO> getAll() {
		List<AniHome_MsgVO> list = null;
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
