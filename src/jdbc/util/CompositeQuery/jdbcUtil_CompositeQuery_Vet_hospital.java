 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Vet_hospital {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("hos_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_MemId".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_name".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_city".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_town".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_road".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_Eval".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("hos_URL".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_StartTime".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_EndTime".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_Tel".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_Desc".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("hos_Long".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("hos_Lat".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("hos_CreateTime".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("hos_visible".equals(columnName)){
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
        
