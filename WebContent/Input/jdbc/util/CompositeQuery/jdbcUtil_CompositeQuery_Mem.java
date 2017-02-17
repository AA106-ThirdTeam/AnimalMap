 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Mem {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("mem_Id".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("mem_account".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Psw".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_nick_name".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_name".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_gender".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Tw_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_birth_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("mem_phone".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Intro".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_profile".equals(columnName)){
        }
        if ("mem_black_list".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_permission".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_setting".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_balance".equals(columnName)){
        	aCondition = columnName + "=" + value;
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
        
