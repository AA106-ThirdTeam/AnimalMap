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
import heibernate_com.priv_message.model.Priv_messageVO;
public class HibernateUtil_CompositeQuery_Priv_message {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("privMsg_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("privMsg_content".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("privMsg_SendTime".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("privMsg_type".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		return query;
	}
	public static List<Priv_messageVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Priv_messageVO> list = null;
		try {
			Criteria query = session.createCriteria(Priv_messageVO.class);
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
			query.addOrder( Order.asc("privMsg_Id") );
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
//		map.put("privMsg_Id", new String[] { "7001" });	
//		map.put("privMsgSend_MemId", new String[] { "7001" });	
//		map.put("privMsgRec_MemId", new String[] { "7001" });	
//		map.put("privMsg_content", new String[] { "7001" });	
//		map.put("privMsg_SendTime", new String[] { "7001" });	
//		map.put("privMsg_type", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Priv_messageVO> list = getAllC(map);
		for (Priv_messageVO aEmp : list) {
			//System.out.print(aEmp.getPrivMsg_Id() + ",");
			//System.out.print(aEmp.getPrivMsgSend_MemId() + ",");
			//System.out.print(aEmp.getPrivMsgRec_MemId() + ",");
			//System.out.print(aEmp.getPrivMsg_content() + ",");
			//System.out.print(aEmp.getPrivMsg_SendTime() + ",");
			//System.out.print(aEmp.getPrivMsg_type() + ",");
			System.out.println();
		}
	}
}
