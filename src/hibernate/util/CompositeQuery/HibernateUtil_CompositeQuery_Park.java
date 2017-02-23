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
import heibernate_com.park.model.ParkVO;
public class HibernateUtil_CompositeQuery_Park {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("park_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("park_title".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("park_content".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("park_pic".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adp_start_date".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("adp_upDate".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("adp_city".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("park_town".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("park_road".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("park_lon".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("park_lat".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		return query;
	}
	public static List<ParkVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ParkVO> list = null;
		try {
			Criteria query = session.createCriteria(ParkVO.class);
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
			query.addOrder( Order.asc("park_Id") );
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
//		map.put("park_Id", new String[] { "7001" });	
//		map.put("emp_No", new String[] { "7001" });	
//		map.put("park_title", new String[] { "7001" });	
//		map.put("park_content", new String[] { "7001" });	
//		map.put("park_pic", new String[] { "7001" });	
//		map.put("adp_start_date", new String[] { "7001" });	
//		map.put("adp_upDate", new String[] { "7001" });	
//		map.put("adp_city", new String[] { "7001" });	
//		map.put("park_town", new String[] { "7001" });	
//		map.put("park_road", new String[] { "7001" });	
//		map.put("park_lon", new String[] { "7001" });	
//		map.put("park_lat", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<ParkVO> list = getAllC(map);
		for (ParkVO aEmp : list) {
			//System.out.print(aEmp.getPark_Id() + ",");
			//System.out.print(aEmp.getEmp_No() + ",");
			//System.out.print(aEmp.getPark_title() + ",");
			//System.out.print(aEmp.getPark_content() + ",");
			//System.out.print(aEmp.getPark_pic() + ",");
			//System.out.print(aEmp.getAdp_start_date() + ",");
			//System.out.print(aEmp.getAdp_upDate() + ",");
			//System.out.print(aEmp.getAdp_city() + ",");
			//System.out.print(aEmp.getPark_town() + ",");
			//System.out.print(aEmp.getPark_road() + ",");
			//System.out.print(aEmp.getPark_lon() + ",");
			//System.out.print(aEmp.getPark_lat() + ",");
			System.out.println();
		}
	}
}
