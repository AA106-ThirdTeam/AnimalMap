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
import heibernate_com.pet_photos.model.Pet_PhotosVO;
public class HibernateUtil_CompositeQuery_Pet_Photos {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("pet_Pic_No".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_Pic".equals(columnName))    //用於byte[]
			query.add(Restrictions.eq(columnName, null)); 
		if ("pet_Pic_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_Pic_nameEX".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_Pic_time".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("pet_Pic_type".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		return query;
	}
	public static List<Pet_PhotosVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Pet_PhotosVO> list = null;
		try {
			Criteria query = session.createCriteria(Pet_PhotosVO.class);
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
			query.addOrder( Order.asc("pet_Pic_No") );
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
//		map.put("pet_Pic_No", new String[] { "7001" });	
//		map.put("pet_Id", new String[] { "7001" });	
//		map.put("mem_Id", new String[] { "7001" });	
//		map.put("pet_Pic", new String[] { "7001" });	
//		map.put("pet_Pic_name", new String[] { "7001" });	
//		map.put("pet_Pic_nameEX", new String[] { "7001" });	
//		map.put("pet_Pic_time", new String[] { "7001" });	
//		map.put("pet_Pic_type", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Pet_PhotosVO> list = getAllC(map);
		for (Pet_PhotosVO aEmp : list) {
			//System.out.print(aEmp.getPet_Pic_No() + ",");
			//System.out.print(aEmp.getPet_Id() + ",");
			//System.out.print(aEmp.getMem_Id() + ",");
			//System.out.print(aEmp.getPet_Pic() + ",");
			//System.out.print(aEmp.getPet_Pic_name() + ",");
			//System.out.print(aEmp.getPet_Pic_nameEX() + ",");
			//System.out.print(aEmp.getPet_Pic_time() + ",");
			//System.out.print(aEmp.getPet_Pic_type() + ",");
			System.out.println();
		}
	}
}
