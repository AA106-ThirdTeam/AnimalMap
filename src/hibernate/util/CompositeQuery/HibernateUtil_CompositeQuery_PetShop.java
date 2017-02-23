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
import heibernate_com.petshop.model.PetShopVO;
public class HibernateUtil_CompositeQuery_PetShop {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("shop_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_city".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_town".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_road".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_Eval".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		if ("shop_URL".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_StartTime".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_EndTime".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_Tel".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_Desc".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shop_Long".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("shop_Lat".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("shop_CreateTime".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("shop_visible".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		return query;
	}
	public static List<PetShopVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<PetShopVO> list = null;
		try {
			Criteria query = session.createCriteria(PetShopVO.class);
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
			query.addOrder( Order.asc("shop_Id") );
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
//		map.put("shop_Id", new String[] { "7001" });	
//		map.put("shop_MemId", new String[] { "7001" });	
//		map.put("shop_name", new String[] { "7001" });	
//		map.put("shop_city", new String[] { "7001" });	
//		map.put("shop_town", new String[] { "7001" });	
//		map.put("shop_road", new String[] { "7001" });	
//		map.put("shop_Eval", new String[] { "7001" });	
//		map.put("shop_URL", new String[] { "7001" });	
//		map.put("shop_StartTime", new String[] { "7001" });	
//		map.put("shop_EndTime", new String[] { "7001" });	
//		map.put("shop_Tel", new String[] { "7001" });	
//		map.put("shop_Desc", new String[] { "7001" });	
//		map.put("shop_Long", new String[] { "7001" });	
//		map.put("shop_Lat", new String[] { "7001" });	
//		map.put("shop_CreateTime", new String[] { "7001" });	
//		map.put("shop_visible", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<PetShopVO> list = getAllC(map);
		for (PetShopVO aEmp : list) {
			//System.out.print(aEmp.getShop_Id() + ",");
			//System.out.print(aEmp.getShop_MemId() + ",");
			//System.out.print(aEmp.getShop_name() + ",");
			//System.out.print(aEmp.getShop_city() + ",");
			//System.out.print(aEmp.getShop_town() + ",");
			//System.out.print(aEmp.getShop_road() + ",");
			//System.out.print(aEmp.getShop_Eval() + ",");
			//System.out.print(aEmp.getShop_URL() + ",");
			//System.out.print(aEmp.getShop_StartTime() + ",");
			//System.out.print(aEmp.getShop_EndTime() + ",");
			//System.out.print(aEmp.getShop_Tel() + ",");
			//System.out.print(aEmp.getShop_Desc() + ",");
			//System.out.print(aEmp.getShop_Long() + ",");
			//System.out.print(aEmp.getShop_Lat() + ",");
			//System.out.print(aEmp.getShop_CreateTime() + ",");
			//System.out.print(aEmp.getShop_visible() + ",");
			System.out.println();
		}
	}
}
