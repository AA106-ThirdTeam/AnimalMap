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
import heibernate_com.product_kind.model.Product_kindVO;
public class HibernateUtil_CompositeQuery_Product_kind {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("product_kind_no".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("product_kind_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		return query;
	}
	public static List<Product_kindVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Product_kindVO> list = null;
		try {
			Criteria query = session.createCriteria(Product_kindVO.class);
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
			query.addOrder( Order.asc("product_kind_no") );
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
//		map.put("product_kind_no", new String[] { "7001" });	
//		map.put("product_kind_name", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Product_kindVO> list = getAllC(map);
		for (Product_kindVO aEmp : list) {
			//System.out.print(aEmp.getProduct_kind_no() + ",");
			//System.out.print(aEmp.getProduct_kind_name() + ",");
			System.out.println();
		}
	}
}
