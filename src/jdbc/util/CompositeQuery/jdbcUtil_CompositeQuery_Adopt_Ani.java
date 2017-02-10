 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Adopt_Ani {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("adopt_Ani_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_name".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_type".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_gender".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_heal".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_Vac".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_color".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_body".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_age".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_Neu".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_chip".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("adopt_Ani_status".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_CreDate".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("adopt_Ani_FinLat".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("adopt_Ani_FinLon".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("adopt_Ani_city".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_town".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_road".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_like".equals(columnName)){
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
        
