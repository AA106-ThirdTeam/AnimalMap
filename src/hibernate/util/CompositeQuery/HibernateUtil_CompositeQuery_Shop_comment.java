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
import heibernate_com.shop_comment.model.Shop_commentVO;
public class HibernateUtil_CompositeQuery_Shop_comment {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("shopComment_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shopComment_content".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("shopComment_SendTime".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		return query;
	}
	public static List<Shop_commentVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Shop_commentVO> list = null;
		try {
			Criteria query = session.createCriteria(Shop_commentVO.class);
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
			query.addOrder( Order.asc("shopComment_Id") );
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
//		map.put("shopComment_Id", new String[] { "7001" });	
//		map.put("shopComment_MemId", new String[] { "7001" });	
//		map.put("shopComment_ShopId", new String[] { "7001" });	
//		map.put("shopComment_content", new String[] { "7001" });	
//		map.put("shopComment_SendTime", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Shop_commentVO> list = getAllC(map);
		for (Shop_commentVO aEmp : list) {
			//System.out.print(aEmp.getShopComment_Id() + ",");
			//System.out.print(aEmp.getShopComment_MemId() + ",");
			//System.out.print(aEmp.getShopComment_ShopId() + ",");
			//System.out.print(aEmp.getShopComment_content() + ",");
			//System.out.print(aEmp.getShopComment_SendTime() + ",");
			System.out.println();
		}
	}
}
