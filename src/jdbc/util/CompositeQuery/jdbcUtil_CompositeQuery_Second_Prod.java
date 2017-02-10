 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Second_Prod {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("second_Prod_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("second_Prod_Title".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("second_Prod_Content".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("second_Prod_adp_start_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("second_Prod_adp_end_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("second_Prod_adp_upDate".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("second_Prod_adp_city".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("second_Prod_Town".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("second_Prod_Road".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("second_Prod_Lon".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("second_Prod_Lat".equals(columnName)){
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
        
