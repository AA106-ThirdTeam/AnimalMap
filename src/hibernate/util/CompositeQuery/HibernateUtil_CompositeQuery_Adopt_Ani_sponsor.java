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
import heibernate_com.adopt_ani_sponsor.model.Adopt_Ani_sponsorVO;
public class HibernateUtil_CompositeQuery_Adopt_Ani_sponsor {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("ado_Ani_Spo_No".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("ado_Ani_Spo_money".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		if ("ado_Ani_Spo_thing".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("ado_Ani_Spo_time".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		return query;
	}
	public static List<Adopt_Ani_sponsorVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Adopt_Ani_sponsorVO> list = null;
		try {
			Criteria query = session.createCriteria(Adopt_Ani_sponsorVO.class);
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
			query.addOrder( Order.asc("ado_Ani_Spo_No") );
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
//		map.put("ado_Ani_Spo_No", new String[] { "7001" });	
//		map.put("adopt_Ani_Id", new String[] { "7001" });	
//		map.put("mem_Id", new String[] { "7001" });	
//		map.put("ado_Ani_Spo_money", new String[] { "7001" });	
//		map.put("ado_Ani_Spo_thing", new String[] { "7001" });	
//		map.put("ado_Ani_Spo_time", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Adopt_Ani_sponsorVO> list = getAllC(map);
		for (Adopt_Ani_sponsorVO aEmp : list) {
			//System.out.print(aEmp.getAdo_Ani_Spo_No() + ",");
			//System.out.print(aEmp.getAdopt_Ani_Id() + ",");
			//System.out.print(aEmp.getMem_Id() + ",");
			//System.out.print(aEmp.getAdo_Ani_Spo_money() + ",");
			//System.out.print(aEmp.getAdo_Ani_Spo_thing() + ",");
			//System.out.print(aEmp.getAdo_Ani_Spo_time() + ",");
			System.out.println();
		}
	}
}
