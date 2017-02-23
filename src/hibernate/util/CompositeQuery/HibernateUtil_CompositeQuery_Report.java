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
import heibernate_com.report.model.ReportVO;
public class HibernateUtil_CompositeQuery_Report {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("report_No".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("report_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("report_class".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("report_class_No".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("report_class_No_value".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("report_content".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("report_status".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("report_time".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("report_class_status".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		return query;
	}
	public static List<ReportVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<ReportVO> list = null;
		try {
			Criteria query = session.createCriteria(ReportVO.class);
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
			query.addOrder( Order.asc("report_No") );
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
//		map.put("report_No", new String[] { "7001" });	
//		map.put("report_name", new String[] { "7001" });	
//		map.put("report_class", new String[] { "7001" });	
//		map.put("report_class_No", new String[] { "7001" });	
//		map.put("report_class_No_value", new String[] { "7001" });	
//		map.put("report_content", new String[] { "7001" });	
//		map.put("report_status", new String[] { "7001" });	
//		map.put("mem_Id_active", new String[] { "7001" });	
//		map.put("mem_Id_passive", new String[] { "7001" });	
//		map.put("report_time", new String[] { "7001" });	
//		map.put("report_class_status", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<ReportVO> list = getAllC(map);
		for (ReportVO aEmp : list) {
			//System.out.print(aEmp.getReport_No() + ",");
			//System.out.print(aEmp.getReport_name() + ",");
			//System.out.print(aEmp.getReport_class() + ",");
			//System.out.print(aEmp.getReport_class_No() + ",");
			//System.out.print(aEmp.getReport_class_No_value() + ",");
			//System.out.print(aEmp.getReport_content() + ",");
			//System.out.print(aEmp.getReport_status() + ",");
			//System.out.print(aEmp.getMem_Id_active() + ",");
			//System.out.print(aEmp.getMem_Id_passive() + ",");
			//System.out.print(aEmp.getReport_time() + ",");
			//System.out.print(aEmp.getReport_class_status() + ",");
			System.out.println();
		}
	}
}
