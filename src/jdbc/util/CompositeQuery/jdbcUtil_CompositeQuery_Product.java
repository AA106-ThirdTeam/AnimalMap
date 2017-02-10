 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Product {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("product_no".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("product_name".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("product_introduction".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("product_price".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("product_stock".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("product_picture_large".equals(columnName)){
        }
        if ("product_picture_small".equals(columnName)){
        }
        if ("product_status".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("product_create_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("product_info".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("product_kind_no".equals(columnName)){
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
        
