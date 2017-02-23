/*
 *  1. 萬用複合查詢-可由客戶端隨意增減任何想查詢的欄位
 *  2. 為了避免影響效能:
 *        所以動態產生萬用SQL的部份,本範例無意採用MetaData的方式,也只針對個別的Table自行視需要而個別製作之
 * */
package hibernate.util.CompositeQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import hibernate.util.HibernateUtil;
import java.util.*;
import heibernate_com.orders.model.OrdersVO;
public class HibernateUtil_CompositeQuery_Orders {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("orders_no".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("orders_receiver".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("post_no".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("post_adp_city".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("post_town".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("post_road".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
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
	public static List<OrdersVO> getAllC(Map<String, String[]> map) {
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
					query = get_aCriteria_For_AnyDB(query, key, value);
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
	public static void main(String argv[]) {
		// 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
		Map<String, String[]> map = new TreeMap<String, String[]>();
//		map.put("orders_no", new String[] { "7001" });	
//		map.put("mem_Id", new String[] { "7001" });	
//		map.put("orders_receiver", new String[] { "7001" });	
//		map.put("post_no", new String[] { "7001" });	
//		map.put("post_adp_city", new String[] { "7001" });	
//		map.put("post_town", new String[] { "7001" });	
//		map.put("post_road", new String[] { "7001" });	
//		map.put("orders_phone", new String[] { "7001" });	
//		map.put("collect_mode_no", new String[] { "7001" });	
//		map.put("orders_date", new String[] { "7001" });	
//		map.put("orders_ship_date", new String[] { "7001" });	
//		map.put("orders_total", new String[] { "7001" });	
//		map.put("orders_status", new String[] { "7001" });	
//		map.put("orders_credit", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<OrdersVO> list = getAllC(map);
		for (OrdersVO aEmp : list) {
			//System.out.print(aEmp.getOrders_no() + ",");
			//System.out.print(aEmp.getMem_Id() + ",");
			//System.out.print(aEmp.getOrders_receiver() + ",");
			//System.out.print(aEmp.getPost_no() + ",");
			//System.out.print(aEmp.getPost_adp_city() + ",");
			//System.out.print(aEmp.getPost_town() + ",");
			//System.out.print(aEmp.getPost_road() + ",");
			//System.out.print(aEmp.getOrders_phone() + ",");
			//System.out.print(aEmp.getCollect_mode_no() + ",");
			//System.out.print(aEmp.getOrders_date() + ",");
			//System.out.print(aEmp.getOrders_ship_date() + ",");
			//System.out.print(aEmp.getOrders_total() + ",");
			//System.out.print(aEmp.getOrders_status() + ",");
			//System.out.print(aEmp.getOrders_credit() + ",");
			System.out.println();
		}
	}
}
