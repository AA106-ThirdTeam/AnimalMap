 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_PetShop {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("shop_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_MemId".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_name".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_city".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_town".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_road".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_Eval".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("shop_URL".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_StartTime".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_EndTime".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_Tel".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_Desc".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("shop_Long".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("shop_Lat".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("shop_CreateTime".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("shop_visible".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
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
        
