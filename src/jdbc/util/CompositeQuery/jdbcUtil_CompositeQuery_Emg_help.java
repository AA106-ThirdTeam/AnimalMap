 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Emg_help {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("emg_H_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emg_H_start_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("emg_H_end_date".equals(columnName)){
        	aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";
        }
        if ("emg_H_title".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emg_H_content".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emg_H_Pic".equals(columnName)){
        }
        if ("emg_H_Pic_format".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emg_H_city".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emg_H_town".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emg_H_road".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("emg_H_Lon".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("emg_H_Lat".equals(columnName)){
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
        
