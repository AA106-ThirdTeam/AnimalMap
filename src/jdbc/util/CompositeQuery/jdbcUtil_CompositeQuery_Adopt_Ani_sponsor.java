 package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Adopt_Ani_sponsor {

    public static String get_aCondition_For_Oracle(String columnName, String value) {

        String aCondition = null;
        if ("ado_Ani_Spo_No".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("adopt_Ani_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("mem_Id".equals(columnName)){
        	aCondition = columnName + " like '%" + value + "%'";
        }
        if ("ado_Ani_Spo_money".equals(columnName)){
        	aCondition = columnName + "=" + value;
        }
        if ("adoAniSpoMat".equals(columnName)){
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
        
