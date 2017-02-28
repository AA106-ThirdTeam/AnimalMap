package test;

import java.util.Calendar;
import java.util.Date;

public class Date_ver02 {
	/**
     * 终极方法
     * 将一个时间戳转换成提示性时间字符串，如
     * 2分钟内 无显示
     * 2分钟-今天  2分钟-今天 HH:mm
     * 昨天 昨天 HH:mm
     * 前天 前天 HH:mm
     * 今年 MM:DD HH:mm
     * 去年 去年 MM:DD HH:mm
     * 前年 前年 MM:DD HH:mm
     * 更远 yyyy:MM:DD HH:mm
     * 毫秒计算
     * @param time
     * @return
     */
    public static String convertWEChartTimeFormatFinalMethed(long time) {
        long curTime = System.currentTimeMillis() ;
        String showTimeFormat = "";

        long temp = curTime - time;
        if (temp < 120 * 1000 && temp >= 0) {
            showTimeFormat = "";
            return showTimeFormat;
        }
        Date mayTime = new Date(time);

//        Date today = UtilDate.parse("2015-01-01 02:02:02.001", UtilDate.FORMAT_FULL);
        Date today = new Date();
        //时间值
        String mayTime_FORMAT_SHORT = format(mayTime, FORMAT_SHORT);
        String mayTime_FORMAT_SHORT_YEAR = getYear(mayTime);

        if(mayTime.after(today)){
            //除此以外
            showTimeFormat = format(mayTime, FORMAT_LONG_CN_1);

        } else {
            if(mayTime_FORMAT_SHORT != null && !mayTime_FORMAT_SHORT.trim().toString().equals("")){
                //今天的时间yyyy-MM-dd
                String today_str = format(today, FORMAT_SHORT);
                String thisYear_str = getYear(today);

                //昨天的时间 yyyy-MM-dd
                Calendar calLastDay = Calendar.getInstance();
                calLastDay.setTime(today);
                calLastDay.add(Calendar.DAY_OF_YEAR, -1);
                System.out.println("昨天：" + format(calLastDay.getTime(), FORMAT_SHORT));
                String lastDay = format(calLastDay.getTime(), FORMAT_SHORT);

                //前天的时间 yyyy-MM-dd
                Calendar calPreviousDay = Calendar.getInstance();
                calPreviousDay.setTime(today);
                calPreviousDay.add(Calendar.DAY_OF_YEAR, -2);
                System.out.println("前天：" + format(calPreviousDay.getTime(), FORMAT_SHORT));
                String previousDay = format(calPreviousDay.getTime(), FORMAT_SHORT);

                //去年的时间 yyyy
                Calendar calLastYear = Calendar.getInstance();
                calLastYear.setTime(today);
                calLastYear.add(Calendar.YEAR, -1);
                String lastYear = getYear(calLastYear.getTime());
                System.out.println("去年：" + format(calLastYear.getTime(), FORMAT_SHORT));

                //前年的时间 yyyy
                Calendar calPreviousYear = Calendar.getInstance();
                calPreviousYear.setTime(today);
                calPreviousYear.add(Calendar.YEAR, -2);
                String previousYear = getYear(calPreviousYear.getTime());
                System.out.println("前年：" + format(calPreviousYear.getTime(), FORMAT_SHORT));

                //首先判断是否是今天
                if(mayTime_FORMAT_SHORT.equals(today_str)){
                    //今天，则显示为 13:12
                    showTimeFormat = format(mayTime, FORMAT_HH_MM);
                } else if(mayTime_FORMAT_SHORT.equals(lastDay)){
                    //昨天
                    showTimeFormat = "昨天 " + format(mayTime,FORMAT_HH_MM);

                } else if(mayTime_FORMAT_SHORT.equals(previousDay)){
                    //昨天
                    showTimeFormat = "前天 " + format(mayTime,FORMAT_HH_MM);

                } else if(mayTime_FORMAT_SHORT_YEAR.equals(thisYear_str)){
                    //今年
                    showTimeFormat = format(mayTime, FORMAT_MM_DD_HH_MM);
                } else if(mayTime_FORMAT_SHORT_YEAR.equals(lastYear)){
                    //去年
                    showTimeFormat = "去年  " + format(mayTime, FORMAT_MM_DD_HH_MM);
                } else if(mayTime_FORMAT_SHORT_YEAR.equals(previousYear)){
                    //前年
                    showTimeFormat = "前年  " + format(mayTime, FORMAT_MM_DD_HH_MM);
                } else {
                    //除此以外
                    showTimeFormat = format(mayTime, FORMAT_LONG_CN_1);
                }

            }
        }


        return showTimeFormat;
    }
}
