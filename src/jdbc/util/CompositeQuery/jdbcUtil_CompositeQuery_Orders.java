 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Orders {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("orders_no".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("orders_receiver".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("post_no".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("post_adp_city".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("post_town".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("post_road".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("orders_phone".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("collect_mode_no".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("orders_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("orders_ship_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("orders_total".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("orders_status".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("orders_credit".equals(columnName)){
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
        
