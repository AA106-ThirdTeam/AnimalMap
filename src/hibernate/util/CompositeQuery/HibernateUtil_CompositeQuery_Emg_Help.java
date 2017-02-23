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
import heibernate_com.emg_help.model.Emg_HelpVO;
public class HibernateUtil_CompositeQuery_Emg_Help {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("emg_H_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emg_H_start_date".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("emg_H_end_date".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("emg_H_title".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emg_H_content".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emg_H_Pic".equals(columnName))    //用於byte[]
			query.add(Restrictions.eq(columnName, null)); 
		if ("emg_H_Pic_format".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emg_H_city".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emg_H_town".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emg_H_road".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emg_H_Lon".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("emg_H_Lat".equals(columnName))    //用於Double
			query.add(Restrictions.eq(columnName, new Double(value))); 
		if ("emg_H_status".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		return query;
	}
	public static List<Emg_HelpVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Emg_HelpVO> list = null;
		try {
			Criteria query = session.createCriteria(Emg_HelpVO.class);
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
			query.addOrder( Order.asc("emg_H_Id") );
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
//		map.put("emg_H_Id", new String[] { "7001" });	
//		map.put("mem_Id", new String[] { "7001" });	
//		map.put("emg_H_start_date", new String[] { "7001" });	
//		map.put("emg_H_end_date", new String[] { "7001" });	
//		map.put("emg_H_title", new String[] { "7001" });	
//		map.put("emg_H_content", new String[] { "7001" });	
//		map.put("emg_H_Pic", new String[] { "7001" });	
//		map.put("emg_H_Pic_format", new String[] { "7001" });	
//		map.put("emg_H_city", new String[] { "7001" });	
//		map.put("emg_H_town", new String[] { "7001" });	
//		map.put("emg_H_road", new String[] { "7001" });	
//		map.put("emg_H_Lon", new String[] { "7001" });	
//		map.put("emg_H_Lat", new String[] { "7001" });	
//		map.put("emg_H_status", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<Emg_HelpVO> list = getAllC(map);
		for (Emg_HelpVO aEmp : list) {
			//System.out.print(aEmp.getEmg_H_Id() + ",");
			//System.out.print(aEmp.getMem_Id() + ",");
			//System.out.print(aEmp.getEmg_H_start_date() + ",");
			//System.out.print(aEmp.getEmg_H_end_date() + ",");
			//System.out.print(aEmp.getEmg_H_title() + ",");
			//System.out.print(aEmp.getEmg_H_content() + ",");
			//System.out.print(aEmp.getEmg_H_Pic() + ",");
			//System.out.print(aEmp.getEmg_H_Pic_format() + ",");
			//System.out.print(aEmp.getEmg_H_city() + ",");
			//System.out.print(aEmp.getEmg_H_town() + ",");
			//System.out.print(aEmp.getEmg_H_road() + ",");
			//System.out.print(aEmp.getEmg_H_Lon() + ",");
			//System.out.print(aEmp.getEmg_H_Lat() + ",");
			//System.out.print(aEmp.getEmg_H_status() + ",");
			System.out.println();
		}
	}
}
