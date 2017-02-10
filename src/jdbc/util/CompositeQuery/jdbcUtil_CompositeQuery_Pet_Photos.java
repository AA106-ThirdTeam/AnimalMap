 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Pet_Photos {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("pet_Pic_No".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("pet_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("pet_Pic".equals(columnName)){
        }
        if ("pet_Pic_name".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("pet_Pic_extent".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("pet_Pic_time".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("pet_Pic_type".equals(columnName)){
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
        
