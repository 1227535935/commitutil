package utils.date;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 * @author Administrator
 */
public class DateUtil {

    /**时间格式**/
    public static final SimpleDateFormat ymdSdf = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat ymdhmsSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**数字月份**/
    public static final String MONTH_JAN = "01";    //January
    public static final String MONTH_FEB = "02";    //February
    public static final String MONTH_MAR = "03";    //March
    public static final String MONTH_APR = "04";    //April
    public static final String MONTH_MAY = "05";    //May
    public static final String MONTH_JUN = "06";    //June
    public static final String MONTH_JUL = "07";    //July
    public static final String MONTH_AUG = "08";    //August
    public static final String MONTH_SEPT = "09";   //September
    public static final String MONTH_OCT = "10";    //October
    public static final String MONTH_NOV = "11";    //November
    public static final String MONTH_DEC = "12";    //December
    /**月份天数**/
    public static final Integer MONTH_DAYS_BIG = 31;    //1，3，5，7，8，10，12
    public static final Integer MONTH_DAYS_MIN = 30;    //4,6,9,11
    public static final Integer MONTH_DAYS_FEB = 28;    //平年2月
    public static final Integer MONTH_DAYS_FEB_LEAPYEAR = 29;   //闰年2月

    public static String getNow() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return ymdSdf.format(cal.getTime());
    }

    public static String getStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return ymdhmsSdf.format(cal.getTime());
    }

    public static String getEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return ymdhmsSdf.format(cal.getTime());
    }

    /**
     * 获取指定天数前的零点时间：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getYestoryStart(Integer days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -days);          //TODO 明天时间：cal.add(Calendar.DATE,1);后天：后天就是把1改成2 ，以此类推。
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return ymdhmsSdf.format(cal.getTime());
    }

    /**
     * 获取制定天数前的结束时间：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getYestoryEnd(Integer days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -days);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return ymdhmsSdf.format(cal.getTime());
    }

    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     *
     * @param timestampString 时间戳 如："1473048265";
     * @param formats         要格式化的格式 默认："yyyy-MM-dd HH:mm:ss";
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String TimeStamp2Date(String timestampString, String formats) {
        if (StringUtils.isBlank(timestampString)) {
            return null;
        }
        if (TextUtils.isEmpty(formats)) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }
        Long timestamp = null;
        if (timestampString.length() == 13) {
            timestamp = Long.parseLong(timestampString);
        } else {
            timestamp = Long.parseLong(timestampString) * 1000;
        }

        return new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
    }

    /**
     * 获取指定格式的当前时间
     *
     * @param formats
     * @return String
     */
    public static String getCurrentFormatDate(String formats) {
        if (TextUtils.isEmpty(formats)) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(formats);
        return dateFormat.format(date);
    }

    /**
     * 获取指定格式的当前时间--返回Timestamp类型
     *
     * @param formats
     * @return Timestamp
     */
    public static Timestamp getCurrentTimeStampFormat(String formats) {
        if (TextUtils.isEmpty(formats)) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(formats);
        return Timestamp.valueOf(dateFormat.format(date));
    }

    /**
     * 获取两个时间的时间差，返回差距多少秒
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     * @throws ParseException
     */
    public static int getTimeDiffSecond(Timestamp startTime, Timestamp endTime) throws ParseException {

        long diff = startTime.getTime() - endTime.getTime();
        return (int) (diff / (1000));
    }

    /**
     * 获取某日期往前多少天的日期
     *
     * @param nowDate
     * @param beforeNum
     * @return
     * @CreateTime 2016-1-13
     */
    public static Date getBeforeDate(Date nowDate, Integer beforeNum) {
        Calendar calendar = Calendar.getInstance(); // 得到日历
        calendar.setTime(nowDate);// 把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -beforeNum); // 设置为前beforeNum天
        return calendar.getTime(); // 得到前beforeNum天的时间
    }


    /**
     * 获取某日期往前/后多少月份的日期
     *
     * @param nowDate
     * @param num
     * @return
     * @CreateTime 2016-1-13
     */
    public static Date getDateMonth(Date nowDate, Integer num) {
        Calendar calendar = Calendar.getInstance(); // 得到日历
        calendar.setTime(nowDate);// 把当前时间赋给日历
        calendar.add(Calendar.MONTH, num); // 设置为前/后beforeNum月份
        return calendar.getTime();
    }

    /**
     * 比较两个日期是否相同
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isEqualDate(Date d1, Date d2) {
        LocalDate localDate1 = ZonedDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = ZonedDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return localDate1.isEqual(localDate2);
    }

    /**
     * 返回需要的日期形式
     * </p>
     * 如：style=“yyyy年MM月dd日 HH时mm分ss秒SSS毫秒”。 返回“xxxx年xx月xx日xx时xx分xx秒xxx毫秒”
     * </p>
     *
     * @param date
     * @param style
     * @return
     */
    public static String getNeededDateStyle(Date date, String style) {
        if (date == null) {
            date = new Date();
        }
        if (StringUtils.isEmpty(style)) {
            style = "yyyy年MM月dd日";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(style);
        return sdf.format(date);
    }

    /**
     * 获取过去12个月的月份
     *
     * @return
     */
    public static String[] getLast12Months() {

        String[] last12Months = new String[12];

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) +1); //要先+1,才能把本月的算进去</span>
        for (int i = 0; i < 12; i++) {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
            last12Months[11 - i] = cal.get(Calendar.YEAR) + String.format("%02d", (cal.get(Calendar.MONTH) + 1));
        }
        return last12Months;
    }

    /**
     * 更改时间格式
     *
     * @param time
     * @param format
     * @return
     */
    public static String formatTime(Timestamp time, String format) {
        if (TextUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(time);
    }


//	/**
//	 * 转Timestamp
//	 * @param date
//	 * @return
//	 */
//	public static Timestamp getTimeStampDate(String date) {
//		// TODO: 2018/6/24 0024 2018/05/06 多零会报错
//		if(StringUtils.isBlank(date)){
//			return null;
//		}
//		date  = date + " 00:00:00";
//		return Timestamp.valueOf(date);
//	}

    /**
     * 将时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDateFormat(String strDate) {
        Date date = null;
        try {
            date = ymdSdf.parse(strDate);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    /**
     * 功能：判断输入年份是否为闰年
     *公历闰年计算方法：
     * 1、普通年能被4整除且不能被100整除的为闰年。（如2004年就是闰年,1900年不是闰年）
     * 2、世纪年能被400整除的是闰年。(如2000年是闰年，1900年不是闰年)
     * 3、对于数值很大的年份,这年如果能整除3200，并且能整除172800则是闰年。
     *
     * @param year
     * @return 是：true  否：false
     */
    public static boolean leapYear(int year) {
        boolean leap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                leap = year % 400 == 0;
            } else {
                leap = true;
            }
        } else {
            leap = false;
        }
        return leap;
    }

    /**
     * 获取当月最后一天
     *
     * @param month
     * @param year
     * @return 31 30 29 28
     */
    public static String getMoneyEndDay(String month, String year) {
        if(MONTH_JAN.equals(month) || MONTH_MAR.equals(month) || MONTH_MAY.equals(month) || MONTH_JUL.equals(month) || MONTH_AUG.equals(month) || MONTH_OCT.equals(month) || MONTH_DEC.equals(month)){
            return MONTH_DAYS_BIG.toString();
        }
        else if(MONTH_APR.equals(month) || MONTH_JUN.equals(month) || MONTH_SEPT.equals(month) || MONTH_NOV.equals(month)){
            return MONTH_DAYS_MIN.toString();
        }
        else if (MONTH_FEB.equals(month)) {
            if (leapYear(Integer.parseInt(year))) {
                return MONTH_DAYS_FEB_LEAPYEAR.toString();
            } else {
                return MONTH_DAYS_FEB.toString();
            }
        }
        else {
            throw new RuntimeException("month is error with "+month);
        }
    }


    public static void main(String[] args) {
        System.err.println(getMoneyEndDay("12", "2018"));
        System.err.println(leapYear(200));
        System.err.println(strToDateFormat(ymdSdf.format(new Date())));
        getLast12Months();
        System.err.println(getNeededDateStyle(null, null));
        System.err.println(getDateMonth(new Date(), 1));
        System.err.println(getBeforeDate(new Date(),100));
        System.err.println(getYestoryEnd(2));
        System.err.println(getStart());
    }
}