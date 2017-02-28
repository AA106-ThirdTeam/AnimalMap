package test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;


/**
 * 日期工具類
 * 
 * @author yugc
 */
public final class Date_utils_Test {

    private Date_utils_Test() {

    }

    /**
     * yyyy-MM-dd
     */
    public static final String FORMAT1 = "yyyy-MM-dd";

    /**
     * yyyy.MM.dd
     */
    public static final String FORMAT2 = "yyyy.MM.dd";

    /**
     * yyyy/MM/dd
     */
    public static final String FORMAT3 = "yyyy/MM/dd";

    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String FORMAT4 = "yyyy-MM-dd HH:mm";

    /**
     * yyyy.MM.dd HH:mm
     */
    public static final String FORMAT5 = "yyyy.MM.dd HH:mm";

    /**
     * yyyy/MM/dd HH:mm
     */
    public static final String FORMAT6 = "yyyy/MM/dd HH:mm";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT7 = "yyyy-MM-dd HH:mm:ss";

    /**
     * YYYY-MM-dd HH-mm-ss
     */
    public static final String FORMAT15 = "YYYY-MM-dd HH-mm-ss";

    /**
     * yyyy.MM.dd HH:mm:ss
     */
    public static final String FORMAT8 = "yyyy.MM.dd HH:mm:ss";

    /**
     * yyyy/MM/dd HH:mm:ss
     */
    public static final String FORMAT9 = "yyyy/MM/dd HH:mm:ss";

    /**
     * yyyy_MM_dd_HH_mm_ss
     */
    public static final String FORMAT10 = "yyyy_MM_dd_HH_mm_ss";

    /**
     * yy-MM-dd
     */
    public static final String FORMAT11 = "yy-MM-dd";

    /**
     * yyyyMMdd
     */
    public static final String FORMAT12 = "yyyyMMdd";

    /**
     * yyyyMMddHHmmss
     */
    public static final String FORMAT13 = "yyyyMMddHHmmss";

    /**
     * yyyyMM
     */
    public static final String FORMAT14 = "yyyyMM";

    public static Date getCurrentDate() {

        return new Date(System.currentTimeMillis());
    }

    public static Date getYesterDay() {

        return addDay(new Date(System.currentTimeMillis()), -1);
    }

    public static String getYesterDayString() {

        return parseDateToString(addDay(new Date(System.currentTimeMillis()), -1), FORMAT1);
    }

    /**
     * 得到年月日的路徑
     * @return
     */
    public static String getThisYearMonthDay(String dateString) {

        Date date = parseStringToDate(dateString, FORMAT12);

        return Date_utils_Test.getYear(date) + "/" + Date_utils_Test.getMonth(date) + "/" + Date_utils_Test.getDay(date) + "/";
    }

    /**
     * 返回當前日期或時間
     * 
     * @param format
     * @return
     */
    public static String getCurrentDate(String format) {

        if (StringUtils.isBlank(format)) {
            format = FORMAT1;
        }

        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat(format);

        String currentTime = formatter.format(date);

        return currentTime;
    }

    /**
     * 返回當前時間
     * 
     * @return
     */
    public static String getCurrentTime() {

        String datetime = getCurrentDate(FORMAT7);
        String time = datetime.substring(datetime.indexOf(" ") + 1);

        return time;
    }

    /**
     * 返回當前時間加隨機數
     * 
     * @return
     */
    public static String getCurrentDateTimeRandom() {

        String datetime = getCurrentDate(Date_utils_Test.FORMAT10) + "_" + Math.random();

        return datetime;
    }

    /**
     * 返回當前時間和日期
     * @return
     */
    public static String getCurrentDateTimeString() {

        return getCurrentDate(Date_utils_Test.FORMAT7);

    }

    /**
     * 返回當前日期
     * 
     * @return
     */
    public static Date getCurrentDateTime() {

        String datetime = getCurrentDate(FORMAT7);

        return parseStringToDate(datetime, "");
    }

    public static Timestamp getCurrentTimestamp() {

        String datetime = getCurrentDate(FORMAT7);

        return parseStringToTimestamp(datetime, "");
    }

    public static Timestamp getCurrentTimestamp(String format) {

        String datetime = getCurrentDate(format);

        return parseStringToTimestamp(datetime, "");
    }

    /**
     * 日期轉換為字符串
     * 
     * @param date 日期
     * @param format 格式
     * @return 返回字符型日期
     */
    public static String parseDateToString(Date date, String format) {

        String result = "";
        DateFormat formatter = null;
        try {
            if (date != null) {
                if (StringUtils.isBlank(format)) {
                    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                }
                else {
                    formatter = new SimpleDateFormat(format);
                }
                result = formatter.format(date);
            }
        }
        catch (Exception e) {
        }

        return result;
    }

    /**
     * 時間1-時間2的毫秒
     * 
     * @param t1
     * @param t2
     * @return
     */
    public static long between(Timestamp t1, Timestamp t2) {

        if ((t1 != null) && (t2 != null)) {
            return t1.getTime() - t2.getTime();
        }

        return 0;
    }

    /**
     * 兩個日期date1-date2相減，相差的天數
     * 
     * @param date1
     *             日期
     * @param date2
     *             日期
     * @return 返回相減後的日期
     */
    public static int betweenTwoDates(Date date1, Date date2) {

        return (int) ((getMillis(date1) - getMillis(date2)) / (24 * 3600 * 1000));
    }

    /**   
     * 將字符串轉換為日期   
     *    
     * @param str   
     * @return   
     * @throws ParseException 
     */
    public static Date parseStringToDate(String str, String format) {

        DateFormat formatter = null;
        Date date = null;
        if (StringUtils.isNotBlank(str)) {

            if (StringUtils.isBlank(format)) {
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
            else {
                formatter = new SimpleDateFormat(format);
            }

            try {
                date = formatter.parse(str);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    /**
     * 返回2007到今年的年份
     * 
     * @return
     */
    public static List<Integer> get2007ToThisYear() {

        // 當前時間
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        // 返回的年份
        List<Integer> the2007ToThisYearList = new ArrayList<Integer>();
        // 當前年
        int thisYear = c.get(Calendar.YEAR);

        for (int i = thisYear; i >= 2007; i--) {
            the2007ToThisYearList.add(i);
        }

        return the2007ToThisYearList;
    }

    /**
     *  獲取當前月的前幾個月份的時間
     * @param months 
     * @return
     */
    public static Date getDateBeforeMonths(int months) {

        // 當前時間
        Calendar c = Calendar.getInstance();

        c.add(Calendar.MONTH, -months);

        return c.getTime();
    }

    /**
     * 獲取當前日期的前幾天的時間
     * @param days
     * @return
     */
    public static Date getDateBeforeDays(int days) {

        // 當前時間
        Calendar c = Calendar.getInstance();

        c.add(Calendar.DATE, -days);
        return c.getTime();
    }

    /**
     * 返回1-12月份
     * 
     * @return
     */
    public static List<String> getAllMonth() {

        List<String> theMonthList = new ArrayList<String>();

        for (int i = 1; i < 13; i++) {
            if (i < 10) {
                theMonthList.add("0" + i);
            }
            else {
                theMonthList.add("" + i);
            }
        }

        return theMonthList;
    }

    /**
     * 返回日期中的年份
     * 
     * @param date
     *             日期
     * @return 返回年份
     */
    public static int getYear(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.YEAR);
    }

    /**
     * 返回日期中的月份
     * 
     * @param date
     *             日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日期中的日
     * 
     * @param date
     *             日期
     * @return 返回日
     */
    public static int getDay(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回日期中的小時
     * 
     * @param date
     *             日期
     * @return 返回小時
     */
    public static int getHour(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回日期中的分鐘
     * 
     * @param date
     *             日期
     * @return 返回分鐘
     */
    public static int getMinute(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.MINUTE);
    }

    /**
     * 返回日期中的秒鐘
     * 
     * @param date
     *             日期
     * @return 返回秒鐘
     */
    public static int getSecond(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.SECOND);
    }

    /**
     * 返回日期代表的毫秒
     * 
     * @param date
     *             日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.getTimeInMillis();
    }

    /**
     * 返回當前日期代表的毫秒
     * 
     * @return
     */
    public static long getCurrentTimeMillis() {

        return System.currentTimeMillis();
    }

    public static Date addMonth(Date date, int month) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(c.MONTH, month);

        return c.getTime();
    }

    /**
     * 日期加天數,可以向前加，向後加
     * 
     * @param date
     *             日期
     * @param day
     *             天數
     * @return 返回相加後的日期
     */
    public static Date addDay(Date date, int day) {

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);

        return c.getTime();
    }

    /**
     * 日期加秒數,可以向前加，向後加
     * 
     * @param date
     *             日期
     * @param second
     *             秒數
     * @return 返回相加後的日期
     */
    public static Date addSecond(Date date, long second) {

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + second * 1000);

        return c.getTime();
    }

    /**   
     * 根據一個日期，返回是星期幾   
     *    
     * @param sdate   
     * @return   
     */
    public static String getWeekByDate(String sdate) {

        // 再轉換為時間
        Date date = parseStringToDate(sdate, "");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_WEEK);
        // day中存的就是星期幾了，其範圍 1~7
        // 1=星期日 7=星期六，其他類推
        return day + "";
    }

    /**   
     * 根據一個日期，返回是星期幾
     * 1=星期日 7=星期六，其他類推   
     *    
     * @param sdate   
     * @return   
     */
    public static int getWeekByDate(Date date) {

        // 再轉換為時間
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // day中存的就是星期幾了，其範圍 1~7
        // 1=星期日 7=星期六，其他類推
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 日期為一年中的第幾周
     * @return
     */
    public static String getWeekNum(Date date) {

        Calendar c = Calendar.getInstance(Locale.CHINA);
        c.setTime(date);
        String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));

        return week;

    }

    public static java.sql.Date parseUtilDateToSqlDate(Date date) {

        if (date != null) {
            return new java.sql.Date(date.getTime());
        }
        else {
            return null;
        }
    }

    public static java.sql.Date parseStringToSqlDate(String dateStr, String format) {

        Date date = null;
        if (StringUtils.isBlank(format)) {
            date = parseStringToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        }
        else {
            date = parseStringToDate(dateStr, format);
        }

        return parseUtilDateToSqlDate(date);
    }

    public static Timestamp parseUtilDateToTimestamp(Date date, String format) {

        return parseStringToTimestamp(parseDateToString(date, format), format);
    }

    public static Date parseTimestampToUtilDate(Timestamp date, String format) {

        return parseStringToDate(parseDateToString(date, format), format);
    }

    public static Timestamp parseStringToTimestamp(String dateStr, String format) {

        if (StringUtils.isBlank(dateStr)) {
            return null;
        }

        Date date = null;
        if (StringUtils.isBlank(format)) {
            date = parseStringToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        }
        else {
            date = parseStringToDate(dateStr, format);
        }

        if (date != null) {
            long t = date.getTime();
            return new Timestamp(t);
        }
        else {
            return null;
        }
    }

    /**
     * 獲取時間2099-12-31，23:59:59
     * 
     * @return
     */
    public static Timestamp getMaxTimestamp() {

        return Date_utils_Test.parseStringToTimestamp("2099-12-31 23:59:59", Date_utils_Test.FORMAT7);
    }

    /**
     * 返回日期中的年月日，格式化成yyyyMMdd
     * @param date
     * @return
     */
    public static String getYearMonthDay(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT12);

        String currentTime = formatter.format(date);

        return currentTime;
    }

    /**
     * 取得指定月份的第一天
     *
     * @param strdate String
     * @return String
     */
    public static String getMonthBegin(String strdate) {

        return parseDateToString(parseStringToDate(strdate, "yyyy-MM"), "");
    }

    /**
     * 取得指定月份的最後一天
     *
     * @param strdate String
     * @return String
     */
    public static String getMonthEnd(String strdate) {

        Date date = parseStringToDate(getMonthBegin(strdate), "");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        return parseDateToString(calendar.getTime(), "");
    }

    public static String getPreviousMonthBegin() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        Date date = new Date(cal.getTimeInMillis());

        return parseDateToString(parseStringToDate(parseDateToString(date, FORMAT1), "yyyy-MM"), FORMAT1);
    }

    public static String getPreviousMonthEnd() {

        Date date = parseStringToDate(getPreviousMonthBegin(), FORMAT1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        return parseDateToString(calendar.getTime(), FORMAT1);
    }

    /**
     * 上個月
     * 
     * @return
     */
    public static String getPreviousMonth() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        Date date = new Date(cal.getTimeInMillis());

        return parseDateToString(parseStringToDate(parseDateToString(date, FORMAT1), "yyyy-MM"), FORMAT14);
    }

    /**
     * 上兩個月
     * 
     * @return
     */
    public static String getPreviousTwoMonth() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 2);
        Date date = new Date(cal.getTimeInMillis());

        return parseDateToString(parseStringToDate(parseDateToString(date, FORMAT1), "yyyy-MM"), FORMAT14);
    }

    /**
     * 判斷兩個日期是否在同一周
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        }
        else if ((1 == subYear) && (11 == cal2.get(Calendar.MONTH))) {
            // 如果12月的最後一周橫跨來年第一周的話則最後一周即算做來年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        }
        else if ((-1 == subYear) && (11 == cal1.get(Calendar.MONTH))) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(getPreviousMonthBegin());
        System.out.println(getPreviousMonthEnd());
        System.out.println(getYearMonthDay(new Date()));
        System.out.println(getYearMonthDay(parseStringToDate("2009-11-2 12:1:21", FORMAT7)));
        System.out.println("current time: " + getCurrentDateTime());
        System.out.println("addsecond: " + addSecond(getCurrentDateTime(), -1L));
        Date date = new Date();
        System.out.println("current date: " + date.toString());

        System.out.println("test parseDateToString: " + parseDateToString(date, ""));
        System.out.println("test parseStringToDate: " + parseStringToDate("1990-01-1 00:00:00", ""));

        System.out.println("test getYear: " + getYear(date));
        System.out.println("test getMonth: " + getMonth(date));
        System.out.println("test getDay: " + getDay(date));
        System.out.println("test getHour: " + getHour(date));
        System.out.println("test getMinute: " + getMinute(date));
        System.out.println("test getSecond: " + getSecond(date));
        System.out.println("test getMillis: " + getMillis(date));
        System.out.println("test addDate: " + addDay(date, 2));
        System.out.println("test betweenTwoDays: " + betweenTwoDates(date, addDay(date, 2)));
        System.out.println("test getWeekNum: " + getWeekNum(addDay(date, -2)));
        System.out.println("test getWeekByDate: " + getWeekByDate(parseDateToString(date, "")));
        System.out.println("test getMonthBegin: " + getMonthBegin(parseDateToString(date, "")));
        System.out.println("test getMonthEnd: " + getMonthEnd(parseDateToString(date, "")));
        System.out.println("test isSameWeekDates: " + isSameWeekDates(date, addDay(date, -2)));

        System.out.println(getPreviousTwoMonth());
        System.out.println(getPreviousMonth());
        List<Integer> yearList = get2007ToThisYear();
        List<String> monthList = getAllMonth();
    }

    public static String addOneDay(String stopTime) {
        String finishTime = stopTime;
        Date finishDate = null;
        if(stopTime != null && !"".equals(stopTime))
        {
            if(stopTime.length() < 19)
            {
                finishTime = stopTime.substring(0, 10) + " 00:00:00";
            }
            finishDate = Date_utils_Test.parseStringToDate(finishTime, Date_utils_Test.FORMAT7);
            finishDate = Date_utils_Test.addDay(finishDate, 1);
            return Date_utils_Test.parseDateToString(finishDate, Date_utils_Test.FORMAT7);
        }else{
            return null;
        }
    }

    /**
     * 給date加1天
     * @param date
     * @return
     */
    public static Date addOneDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

}
