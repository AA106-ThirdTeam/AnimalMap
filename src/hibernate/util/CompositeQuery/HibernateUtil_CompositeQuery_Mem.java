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
import heibernate_com.mem.model.MemVO;
public class HibernateUtil_CompositeQuery_Mem {
	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
		if ("mem_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_account".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_email".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_Psw".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_nick_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_name".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_gender".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_Tw_Id".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, ""+value+""));
		if ("mem_birth_date".equals(columnName))    //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value))); 
		if ("mem_phone".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_Intro".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_profile".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_black_list".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_permission".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_setting".equals(columnName))    //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		if ("mem_balance".equals(columnName))    //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));  
		return query;
	}
	public static List<MemVO> getAllC(Map<String, String[]> map) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<MemVO> list = null;
		try {
			Criteria query = session.createCriteria(MemVO.class);
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
			query.addOrder( Order.asc("mem_Id") );
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
//		map.put("mem_Id", new String[] { "7001" });	
//		map.put("mem_account", new String[] { "7001" });	
//		map.put("mem_email", new String[] { "7001" });	
//		map.put("mem_Psw", new String[] { "7001" });	
//		map.put("mem_nick_name", new String[] { "7001" });	
//		map.put("mem_name", new String[] { "7001" });	
//		map.put("mem_gender", new String[] { "7001" });	
//		map.put("mem_Tw_Id", new String[] { "7001" });	
//		map.put("mem_birth_date", new String[] { "7001" });	
//		map.put("mem_phone", new String[] { "7001" });	
//		map.put("mem_Intro", new String[] { "7001" });	
//		map.put("mem_profile", new String[] { "7001" });	
//		map.put("mem_black_list", new String[] { "7001" });	
//		map.put("mem_permission", new String[] { "7001" });	
//		map.put("mem_setting", new String[] { "7001" });	
//		map.put("mem_balance", new String[] { "7001" });	

//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		List<MemVO> list = getAllC(map);
		for (MemVO aEmp : list) {
			//System.out.print(aEmp.getMem_Id() + ",");
			//System.out.print(aEmp.getMem_account() + ",");
			//System.out.print(aEmp.getMem_email() + ",");
			//System.out.print(aEmp.getMem_Psw() + ",");
			//System.out.print(aEmp.getMem_nick_name() + ",");
			//System.out.print(aEmp.getMem_name() + ",");
			//System.out.print(aEmp.getMem_gender() + ",");
			//System.out.print(aEmp.getMem_Tw_Id() + ",");
			//System.out.print(aEmp.getMem_birth_date() + ",");
			//System.out.print(aEmp.getMem_phone() + ",");
			//System.out.print(aEmp.getMem_Intro() + ",");
			//System.out.print(aEmp.getMem_profile() + ",");
			//System.out.print(aEmp.getMem_black_list() + ",");
			//System.out.print(aEmp.getMem_permission() + ",");
			//System.out.print(aEmp.getMem_setting() + ",");
			//System.out.print(aEmp.getMem_balance() + ",");
			System.out.println();
		}
	}
}
