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
import heibernate_com.hos_comment.model.Hos_commentVO;
public class HibernateUtil_CompositeQuery_Hos_comment {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("hosComment_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hosComment_content".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("hosComment_SendTime".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		return query;
	}
	public static List<Hos_commentVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Hos_commentVO> list = null;
		try {
			Criteria query = session.createCriteria(Hos_commentVO.class);
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
			query.addOrder( Order.asc("hosComment_Id") );
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
//		map.put("hosComment_Id", new String[] { "7001" });	
//		map.put("hosComment_MemId", new String[] { "7001" });	
//		map.put("hosComment_HosId", new String[] { "7001" });	
//		map.put("hosComment_content", new String[] { "7001" });	
//		map.put("hosComment_SendTime", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Hos_commentVO> list = getAllC(map);
		for (Hos_commentVO aEmp : list) {
			//System.out.print(aEmp.getHosComment_Id() + ",");
			//System.out.print(aEmp.getHosComment_MemId() + ",");
			//System.out.print(aEmp.getHosComment_HosId() + ",");
			//System.out.print(aEmp.getHosComment_content() + ",");
			//System.out.print(aEmp.getHosComment_SendTime() + ",");
			System.out.println();
		}
	}
}
