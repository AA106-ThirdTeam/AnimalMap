package heibernate_com.orders.model;
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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
public class OrdersDAO implements Orders_interface {
	private static final String GET_ALL_STMT = "from OrdersVO order by orders_no";
	@Override
	public void insert(OrdersVO ordersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ordersVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void update(OrdersVO ordersVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ordersVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public void delete(String orders_no) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete OrdersVO where orders_no=?");
//			query.setParameter(0, orders_no);
//			////System.out.println("刪除的筆數=" + query.executeUpdate());
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			OrdersVO ordersVO = new OrdersVO();
			ordersVO.setOrders_no(orders_no);
			session.delete(ordersVO);
//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方orders2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			OrdersVO ordersVO = (OrdersVO) session.get(OrdersVO.class, orders_no);
//			session.delete(ordersVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	@Override
	public OrdersVO findByPrimaryKey(String orders_no) {
		OrdersVO ordersVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ordersVO = (OrdersVO) session.get(OrdersVO.class, orders_no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return ordersVO;
	}
	@Override
	public List<OrdersVO> getAll() {
		List<OrdersVO> list = null;
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
    @Override
    public List<OrdersVO> getAll(Map<String, String[]> map,boolean able_like) {        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<OrdersVO> list = null;
        try {
            Criteria query = session.createCriteria(OrdersVO.class);
            Set<String> keys = map.keySet();
            int count = 0;
            for (String key : keys) {
                String value = map.get(key)[0];
                if (value!=null && value.trim().length()!=0 && !"action".equals(key)) {
                    count++;                    
                    query = get_aCriteria_For_AnyDB(query, key, value,able_like);
                    System.out.println("有送出查詢資料的欄位數count = " + count);
                }
            }
            query.addOrder( Order.asc("orders_no") );
            list = query.list();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
        return list;
    }	    
	/*
	 *  1. 萬用複合查詢-可由客戶端隨意增減任何想查詢的欄位
	 *  2. 為了避免影響效能:
	 *        所以動態產生萬用SQL的部份,本範例無意採用MetaData的方式,也只針對個別的Table自行視需要而個別製作之
	 * */    
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value,boolean able_like) {
		if ("orders_no".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("mem_Id".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("orders_receiver".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("post_no".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("post_adp_city".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("post_town".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("post_road".equals(columnName)){    //用於varchar
			if(able_like){
				query.add(Restrictions.like(columnName, "%"+value+"%"));
			}else{
				query.add(Restrictions.eq(columnName, value)); 
			}
		}	
		if ("orders_phone".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		if ("collect_mode_no".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		if ("orders_date".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("orders_ship_date".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("orders_total".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		if ("orders_status".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		if ("orders_credit".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		return query;
	}
}
