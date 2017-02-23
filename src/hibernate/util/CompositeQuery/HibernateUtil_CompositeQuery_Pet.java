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
import heibernate_com.pet.model.PetVO;
public class HibernateUtil_CompositeQuery_Pet {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("pet_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_type".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_gender".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_heal".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_Vac".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_color".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_body".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_age".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_Neu".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_chip".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_birth".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("pet_status".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_CreDATE".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("pet_city".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_town".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_road".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("pet_FinLat".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("pet_FinLon".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		return query;
	}
	public static List<PetVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<PetVO> list = null;
		try {
			Criteria query = session.createCriteria(PetVO.class);
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
			query.addOrder( Order.asc("pet_Id") );
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
//		map.put("pet_Id", new String[] { "7001" });	
//		map.put("mem_Id", new String[] { "7001" });	
//		map.put("pet_name", new String[] { "7001" });	
//		map.put("pet_type", new String[] { "7001" });	
//		map.put("pet_gender", new String[] { "7001" });	
//		map.put("pet_heal", new String[] { "7001" });	
//		map.put("pet_Vac", new String[] { "7001" });	
//		map.put("pet_color", new String[] { "7001" });	
//		map.put("pet_body", new String[] { "7001" });	
//		map.put("pet_age", new String[] { "7001" });	
//		map.put("pet_Neu", new String[] { "7001" });	
//		map.put("pet_chip", new String[] { "7001" });	
//		map.put("pet_birth", new String[] { "7001" });	
//		map.put("pet_status", new String[] { "7001" });	
//		map.put("pet_CreDATE", new String[] { "7001" });	
//		map.put("pet_city", new String[] { "7001" });	
//		map.put("pet_town", new String[] { "7001" });	
//		map.put("pet_road", new String[] { "7001" });	
//		map.put("pet_FinLat", new String[] { "7001" });	
//		map.put("pet_FinLon", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<PetVO> list = getAllC(map);
		for (PetVO aEmp : list) {
			//System.out.print(aEmp.getPet_Id() + ",");
			//System.out.print(aEmp.getMem_Id() + ",");
			//System.out.print(aEmp.getPet_name() + ",");
			//System.out.print(aEmp.getPet_type() + ",");
			//System.out.print(aEmp.getPet_gender() + ",");
			//System.out.print(aEmp.getPet_heal() + ",");
			//System.out.print(aEmp.getPet_Vac() + ",");
			//System.out.print(aEmp.getPet_color() + ",");
			//System.out.print(aEmp.getPet_body() + ",");
			//System.out.print(aEmp.getPet_age() + ",");
			//System.out.print(aEmp.getPet_Neu() + ",");
			//System.out.print(aEmp.getPet_chip() + ",");
			//System.out.print(aEmp.getPet_birth() + ",");
			//System.out.print(aEmp.getPet_status() + ",");
			//System.out.print(aEmp.getPet_CreDATE() + ",");
			//System.out.print(aEmp.getPet_city() + ",");
			//System.out.print(aEmp.getPet_town() + ",");
			//System.out.print(aEmp.getPet_road() + ",");
			//System.out.print(aEmp.getPet_FinLat() + ",");
			//System.out.print(aEmp.getPet_FinLon() + ",");
			System.out.println();
		}
	}
}
