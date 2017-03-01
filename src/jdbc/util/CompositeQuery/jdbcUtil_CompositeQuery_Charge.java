

package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Charge {

	public static String get_aCondition_For_Oracle(String columnName, String value){
		
		String aCondition = null;

		if ("empno".equals(columnName) || "sal".equals(columnName) || "comm".equals(columnName) || "deptno".equals(columnName)) // 用於其他
			aCondition = columnName + "=" + value;
		else if ("ename".equals(columnName) || "job".equals(columnName)) // 用於varchar
			aCondition = columnName + " like '%" + value + "%'";
		else if ("hiredate".equals(columnName))                          // 用於Oracle的date
			aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";

		return aCondition + " ";
	}
	
	public static String get_WhereCondition(Map<String, String[]> map) {
		Set<String> keys = map.keySet();
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		for (String key : keys) {
			String value = map.get(key)[0];
			if (value != null && value.trim().length() != 0	&& !"action".equals(key)) {
				count++;
				String aCondition = get_aCondition_For_Oracle(key, value.trim());

				if (count == 1)
					whereCondition.append(" where " + aCondition);
				else
					whereCondition.append(" and " + aCondition);

				System.out.println("有送出查詢資料的欄位數count = " + count);
			}
		}
		
		return whereCondition.toString();
	}
	public static void main(String argv[]) {

		// 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
		Map<String, String[]> map = new TreeMap<String, String[]>();
		map.put("charge_no", new String[] { "1" });
		map.put("mem_id", new String[] { "7001" });
		map.put("charge_number", new String[] { "500" });
		map.put("pay", new String[] { "1" });
		map.put("applytime", new String[] { "2017-01-01" });
		map.put("action", new String[] { "getXXX" }); 

		String finalSQL = "select * from charge "
				          + jdbcUtil_CompositeQuery_Charge.get_WhereCondition(map)
				          + "order by charge_no";
		System.out.println("●●finalSQL = " + finalSQL);

	}
}
