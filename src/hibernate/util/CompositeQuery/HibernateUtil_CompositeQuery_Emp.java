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
import heibernate_com.emp.model.EmpVO;
public class HibernateUtil_CompositeQuery_Emp {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("emp_No".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_Pw".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_email".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_birthday".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("emp_phone".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_address".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_status".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_picture".equals(columnName))    //用於byte[]
			query.add(Restrictions.eq(columnName, null)); 
		if ("emp_Pic_format".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("emp_hiredate".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("emp_firedate".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		return query;
	}
	public static List<EmpVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<EmpVO> list = null;
		try {
			Criteria query = session.createCriteria(EmpVO.class);
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
			query.addOrder( Order.asc("emp_No") );
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
//		map.put("emp_No", new String[] { "7001" });	
//		map.put("emp_name", new String[] { "7001" });	
//		map.put("emp_Pw", new String[] { "7001" });	
//		map.put("emp_email", new String[] { "7001" });	
//		map.put("emp_Id", new String[] { "7001" });	
//		map.put("emp_birthday", new String[] { "7001" });	
//		map.put("emp_phone", new String[] { "7001" });	
//		map.put("emp_address", new String[] { "7001" });	
//		map.put("emp_status", new String[] { "7001" });	
//		map.put("emp_picture", new String[] { "7001" });	
//		map.put("emp_Pic_format", new String[] { "7001" });	
//		map.put("emp_hiredate", new String[] { "7001" });	
//		map.put("emp_firedate", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<EmpVO> list = getAllC(map);
		for (EmpVO aEmp : list) {
			//System.out.print(aEmp.getEmp_No() + ",");
			//System.out.print(aEmp.getEmp_name() + ",");
			//System.out.print(aEmp.getEmp_Pw() + ",");
			//System.out.print(aEmp.getEmp_email() + ",");
			//System.out.print(aEmp.getEmp_Id() + ",");
			//System.out.print(aEmp.getEmp_birthday() + ",");
			//System.out.print(aEmp.getEmp_phone() + ",");
			//System.out.print(aEmp.getEmp_address() + ",");
			//System.out.print(aEmp.getEmp_status() + ",");
			//System.out.print(aEmp.getEmp_picture() + ",");
			//System.out.print(aEmp.getEmp_Pic_format() + ",");
			//System.out.print(aEmp.getEmp_hiredate() + ",");
			//System.out.print(aEmp.getEmp_firedate() + ",");
			System.out.println();
		}
	}
}
