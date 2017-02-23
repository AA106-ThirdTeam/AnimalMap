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
import heibernate_com.adopt_ani.model.Adopt_AniVO;
public class HibernateUtil_CompositeQuery_Adopt_Ani {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("adopt_Ani_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_type".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_gender".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_heal".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_Vac".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_color".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_body".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_age".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_Neu".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_chip".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_date".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("adopt_Ani_status".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_CreDate".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("adopt_Ani_FinLat".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("adopt_Ani_FinLon".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("adopt_Ani_city".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_town".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_road".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("adopt_Ani_like".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		return query;
	}
	public static List<Adopt_AniVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Adopt_AniVO> list = null;
		try {
			Criteria query = session.createCriteria(Adopt_AniVO.class);
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
			query.addOrder( Order.asc("adopt_Ani_Id") );
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
//		map.put("adopt_Ani_Id", new String[] { "7001" });	
//		map.put("mem_Id", new String[] { "7001" });	
//		map.put("adopt_Ani_name", new String[] { "7001" });	
//		map.put("adopt_Ani_type", new String[] { "7001" });	
//		map.put("adopt_Ani_gender", new String[] { "7001" });	
//		map.put("adopt_Ani_heal", new String[] { "7001" });	
//		map.put("adopt_Ani_Vac", new String[] { "7001" });	
//		map.put("adopt_Ani_color", new String[] { "7001" });	
//		map.put("adopt_Ani_body", new String[] { "7001" });	
//		map.put("adopt_Ani_age", new String[] { "7001" });	
//		map.put("adopt_Ani_Neu", new String[] { "7001" });	
//		map.put("adopt_Ani_chip", new String[] { "7001" });	
//		map.put("adopt_Ani_date", new String[] { "7001" });	
//		map.put("adopt_Ani_status", new String[] { "7001" });	
//		map.put("adopt_Ani_CreDate", new String[] { "7001" });	
//		map.put("adopt_Ani_FinLat", new String[] { "7001" });	
//		map.put("adopt_Ani_FinLon", new String[] { "7001" });	
//		map.put("adopt_Ani_city", new String[] { "7001" });	
//		map.put("adopt_Ani_town", new String[] { "7001" });	
//		map.put("adopt_Ani_road", new String[] { "7001" });	
//		map.put("adopt_Ani_like", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Adopt_AniVO> list = getAllC(map);
		for (Adopt_AniVO aEmp : list) {
			//System.out.print(aEmp.getAdopt_Ani_Id() + ",");
			//System.out.print(aEmp.getMem_Id() + ",");
			//System.out.print(aEmp.getAdopt_Ani_name() + ",");
			//System.out.print(aEmp.getAdopt_Ani_type() + ",");
			//System.out.print(aEmp.getAdopt_Ani_gender() + ",");
			//System.out.print(aEmp.getAdopt_Ani_heal() + ",");
			//System.out.print(aEmp.getAdopt_Ani_Vac() + ",");
			//System.out.print(aEmp.getAdopt_Ani_color() + ",");
			//System.out.print(aEmp.getAdopt_Ani_body() + ",");
			//System.out.print(aEmp.getAdopt_Ani_age() + ",");
			//System.out.print(aEmp.getAdopt_Ani_Neu() + ",");
			//System.out.print(aEmp.getAdopt_Ani_chip() + ",");
			//System.out.print(aEmp.getAdopt_Ani_date() + ",");
			//System.out.print(aEmp.getAdopt_Ani_status() + ",");
			//System.out.print(aEmp.getAdopt_Ani_CreDate() + ",");
			//System.out.print(aEmp.getAdopt_Ani_FinLat() + ",");
			//System.out.print(aEmp.getAdopt_Ani_FinLon() + ",");
			//System.out.print(aEmp.getAdopt_Ani_city() + ",");
			//System.out.print(aEmp.getAdopt_Ani_town() + ",");
			//System.out.print(aEmp.getAdopt_Ani_road() + ",");
			//System.out.print(aEmp.getAdopt_Ani_like() + ",");
			System.out.println();
		}
	}
}
