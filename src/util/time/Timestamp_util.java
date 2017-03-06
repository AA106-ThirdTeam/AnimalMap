package util.time;

import java.sql.Timestamp;

public class Timestamp_util {
	public static long sec_time = 1000;
	public static long min_time = 60 * sec_time;
	public static long hour_time = 60 * min_time;
	public static long day_time = 24 * hour_time;
	public static long month_time = 30 * day_time;
	public static long year_time = 365 * day_time;

	public static String getBetweenTime(java.sql.Timestamp timestamp) {
		java.sql.Timestamp timestamp_system_time = new java.sql.Timestamp(System.currentTimeMillis());
		long btn_time = timestamp_system_time.getTime() - timestamp.getTime();

		String tem_str = "";
		if ((btn_time / year_time) >= 1) {
			tem_str = "約 "+btn_time / (year_time) + " 年之前";
		} else {
			if ((btn_time / month_time) >= 1) {
				tem_str = "約 "+btn_time / (month_time) + " 個月之前";
			} else {
				if ((btn_time / day_time) >= 1) {
					tem_str = "約 " + btn_time / (day_time) + " 天之前";
				} else {
					if ((btn_time / hour_time) >= 1) {
						tem_str = btn_time / (hour_time) + "小時之前";
					} else {
						if ((btn_time / min_time) >= 1) {
							tem_str = btn_time / (min_time) + " 分鐘之前";
						} else {
							if ((btn_time / sec_time) >= 1) {
								tem_str = btn_time / (sec_time) + " 秒之前";
							}
						}
					}
				}
			}
		}
		return tem_str;
	}	
	
}
