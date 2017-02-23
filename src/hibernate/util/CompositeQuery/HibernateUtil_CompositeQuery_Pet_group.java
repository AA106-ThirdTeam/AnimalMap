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
import heibernate_com.pet_group.model.Pet_groupVO;
public class HibernateUtil_CompositeQuery_Pet_group {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("grp_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_city".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_Addr".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_road".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_StartTime".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_EndTime".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_Desc".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_Long".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("grp_Lat".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("grp_CreateTime".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("grp_visible".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("grp_photo".equals(columnName))    //用於byte[]
			query.add(Restrictions.eq(columnName, null)); 
		return query;
	}
	public static List<Pet_groupVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Pet_groupVO> list = null;
		try {
			Criteria query = session.createCriteria(Pet_groupVO.class);
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
			query.addOrder( Order.asc("grp_Id") );
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
//		map.put("grp_Id", new String[] { "7001" });	
//		map.put("grp_MemId", new String[] { "7001" });	
//		map.put("grp_name", new String[] { "7001" });	
//		map.put("grp_city", new String[] { "7001" });	
//		map.put("grp_Addr", new String[] { "7001" });	
//		map.put("grp_road", new String[] { "7001" });	
//		map.put("grp_StartTime", new String[] { "7001" });	
//		map.put("grp_EndTime", new String[] { "7001" });	
//		map.put("grp_Desc", new String[] { "7001" });	
//		map.put("grp_Long", new String[] { "7001" });	
//		map.put("grp_Lat", new String[] { "7001" });	
//		map.put("grp_CreateTime", new String[] { "7001" });	
//		map.put("grp_visible", new String[] { "7001" });	
//		map.put("grp_photo", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Pet_groupVO> list = getAllC(map);
		for (Pet_groupVO aEmp : list) {
			//System.out.print(aEmp.getGrp_Id() + ",");
			//System.out.print(aEmp.getGrp_MemId() + ",");
			//System.out.print(aEmp.getGrp_name() + ",");
			//System.out.print(aEmp.getGrp_city() + ",");
			//System.out.print(aEmp.getGrp_Addr() + ",");
			//System.out.print(aEmp.getGrp_road() + ",");
			//System.out.print(aEmp.getGrp_StartTime() + ",");
			//System.out.print(aEmp.getGrp_EndTime() + ",");
			//System.out.print(aEmp.getGrp_Desc() + ",");
			//System.out.print(aEmp.getGrp_Long() + ",");
			//System.out.print(aEmp.getGrp_Lat() + ",");
			//System.out.print(aEmp.getGrp_CreateTime() + ",");
			//System.out.print(aEmp.getGrp_visible() + ",");
			//System.out.print(aEmp.getGrp_photo() + ",");
			System.out.println();
		}
	}
}
