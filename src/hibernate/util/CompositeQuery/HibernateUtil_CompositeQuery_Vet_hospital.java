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
import heibernate_com.vet_hospital.model.Vet_hospitalVO;
public class HibernateUtil_CompositeQuery_Vet_hospital {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("hos_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_city".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_town".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_road".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_Eval".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		if ("hos_URL".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_StartTime".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_EndTime".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_Tel".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_Desc".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hos_Long".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("hos_Lat".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("hos_CreateTime".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("hos_visible".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		return query;
	}
	public static List<Vet_hospitalVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Vet_hospitalVO> list = null;
		try {
			Criteria query = session.createCriteria(Vet_hospitalVO.class);
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
			query.addOrder( Order.asc("hos_Id") );
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
//		map.put("hos_Id", new String[] { "7001" });	
//		map.put("hos_MemId", new String[] { "7001" });	
//		map.put("hos_name", new String[] { "7001" });	
//		map.put("hos_city", new String[] { "7001" });	
//		map.put("hos_town", new String[] { "7001" });	
//		map.put("hos_road", new String[] { "7001" });	
//		map.put("hos_Eval", new String[] { "7001" });	
//		map.put("hos_URL", new String[] { "7001" });	
//		map.put("hos_StartTime", new String[] { "7001" });	
//		map.put("hos_EndTime", new String[] { "7001" });	
//		map.put("hos_Tel", new String[] { "7001" });	
//		map.put("hos_Desc", new String[] { "7001" });	
//		map.put("hos_Long", new String[] { "7001" });	
//		map.put("hos_Lat", new String[] { "7001" });	
//		map.put("hos_CreateTime", new String[] { "7001" });	
//		map.put("hos_visible", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Vet_hospitalVO> list = getAllC(map);
		for (Vet_hospitalVO aEmp : list) {
			//System.out.print(aEmp.getHos_Id() + ",");
			//System.out.print(aEmp.getHos_MemId() + ",");
			//System.out.print(aEmp.getHos_name() + ",");
			//System.out.print(aEmp.getHos_city() + ",");
			//System.out.print(aEmp.getHos_town() + ",");
			//System.out.print(aEmp.getHos_road() + ",");
			//System.out.print(aEmp.getHos_Eval() + ",");
			//System.out.print(aEmp.getHos_URL() + ",");
			//System.out.print(aEmp.getHos_StartTime() + ",");
			//System.out.print(aEmp.getHos_EndTime() + ",");
			//System.out.print(aEmp.getHos_Tel() + ",");
			//System.out.print(aEmp.getHos_Desc() + ",");
			//System.out.print(aEmp.getHos_Long() + ",");
			//System.out.print(aEmp.getHos_Lat() + ",");
			//System.out.print(aEmp.getHos_CreateTime() + ",");
			//System.out.print(aEmp.getHos_visible() + ",");
			System.out.println();
		}
	}
}
