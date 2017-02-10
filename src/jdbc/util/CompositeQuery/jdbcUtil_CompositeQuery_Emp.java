 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Emp {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("emp_No".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_name".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_Pw".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_email".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_birthday".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("emp_phone".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_address".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_status".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_picture".equals(columnName)){
        }
        if ("emp_Pic_format".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emp_hiredate".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("emp_firedate".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }

        return aCondition + " ";
    }

    public static String get_WhereCondition(Map<String, String[]> map) {
        Set<String> keys = map.keySet();
        StringBuffer whereCondition = new StringBuffer();
        int count = 0;
        for (String key : keys) {
            String value = map.get(key)[0];
            if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
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
}
        
