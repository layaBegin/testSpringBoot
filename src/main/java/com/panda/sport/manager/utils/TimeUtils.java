package com.panda.sport.manager.utils;

import com.panda.sport.manager.constant.Constant;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author :  dorich
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.utils
 * @Description :  用于时间转换
 * @Date: 2019-08-02 11:40
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
public class TimeUtils {
    /**
     * 一小时多少毫秒
     **/
    private static long millsSecondPerHour = 3600 * 1000;

    /**
     * 一小时多少秒
     **/
    private static long secondPerHour = 3600;

    /**
     * 一小时多少微秒
     **/
    private static long microSecondPerHour = 3600 * 1000 * 1000;

    /**
     * @return long
     * @Description 将GMT时间转为指定时区的时间
     * @Param gmtTime:    格林威治时间，单位毫秒
     * timeZone:   时区数。 如果是 格林威治时间线 往东（美洲方向），则该数字小于0；往西（亚洲方向），数字大于0，跨时区个数是该数字的具体值。
     * @Author dorich
     * @Date 2019/8/2
     **/
    public static long timeMillsSecondsTimeZone(Long gmtTime, int timeZone) {
        return gmtTime;
    }

    /**
     * 将制定时间转换为 西4区时间(UTC-4时间)
     *
     * @param gmtTime UTC时间，精确到毫秒
     * @return long
     * @description 将制定时间转换为 西4区时间(UTC-4时间)
     * @author dorich
     * @date 2019/8/14
     **/
    public static long timeMillsSecondsToPlus4TimeZone(Long gmtTime) {
        return timeMillsSecondsTimeZone(gmtTime, -4);
    }

    /**
     * @param gmtTime  需要转换的UTC时间
     * @param timeZone 时区个数
     * @return long
     * @Description 将GMT时间转为指定时区的时间
     * @Param gmtTime:    格林威治时间，单位秒
     * timeZone:   时区数。 如果是 格林威治时间线 往东（美洲方向），则该数字小于0；往西（亚洲方向），数字大于0，跨时区个数是该数字的具体值。
     * @author dorich
     * @date 2019/8/9
     **/
    public static long timeSecondsTimeZone(Long gmtTime, int timeZone) {
        return gmtTime + timeZone * secondPerHour;
    }

    /**
     * @return long
     * @Description 本地的东八区时间转换为GMT时间
     * @Param
     * @Author dorich
     * @Date 2019/8/2
     **/
    public static long millsSecondsEast8ZoneGmt() {
        // 东八区的事件戳跟 
        return System.currentTimeMillis();
    }

    /**
     * @return long
     * @Description 将GMT时间转为指定时区的时间
     * @Param gmtTime:    格林威治时间，单位微秒
     * timeZone:   时区数。 如果是 格林威治时间线 往东（美洲方向），则该数字小于0；往西（亚洲方向），数字大于0，跨时区个数是该数字的具体值。
     * @Author dorich
     * @Date 2019/8/2
     **/
    @Deprecated
    public static long timeMicroSecondsTimeZone(Long gmtTime, int timeZone) {
        return gmtTime + timeZone * microSecondPerHour;
    }

    /**
     * 获取当天零点时间 GMT时间
     *
     * @return boolean
     * @description 获取当天零点时间 GMT时间
     * @author Alair
     * @date 2019/9/24 19:17
     **/
    public static Long getTodayZero() {
        Long timeStamp = System.currentTimeMillis();

        //  对天取余，得到 当前时间 到 今天0点 经过了多久，单位 毫秒
        long surplus = timeStamp % (24 * millsSecondPerHour);

        //  如果到了新一天的零点，则需要减去24小时
        if (surplus == 0) {
            surplus = millsSecondPerHour;
        }
        return timeStamp - surplus;
    }


    /**
     * 判断前端传递的参数是不是今日
     *
     * @param gmtTime
     * @return boolean
     * @description 判断前端传递的参数是不是今日
     * @author Alair
     * @date 2019/9/25 12:04
     **/
    public static boolean isTodayZeorForPage(Long gmtTime) {
    	if(gmtTime == null) {
    		return false;
    	}
        Long timeStamp = System.currentTimeMillis();
        //  判断当前时间是否为北京时间中午12点之前，跟前端确认，等于12点，归算到后一天
        if (timeStamp % (24 * millsSecondPerHour) < (4 * millsSecondPerHour)) {
            return getTodayZero().equals(gmtTime + 20 * millsSecondPerHour);
        }
        return getTodayZero().equals(gmtTime + (-4) * millsSecondPerHour);
    }

    /**
     * 判断前端传递的参数 大于等于 今日 还是 历史赛程  true表示大于等于  false表示历史赛程
     *
     * @param gmtTime
     * @return boolean
     * @description 判断前端传递的参数 大于等于 今日 还是 历史赛程  true表示大于等于  false表示历史赛程
     * @author Alair
     * @date 2019/9/25 12:04
     **/
    public static boolean compareTodayZeorForPage(Long gmtTime, Integer historyFlag) {
        Long timeStamp = System.currentTimeMillis();
        //  判断当前时间是否为北京时间中午12点之前，跟前端确认，等于12点，归算到后一天
        if (timeStamp % (24 * millsSecondPerHour) < (4 * millsSecondPerHour)) {
            gmtTime = gmtTime + 20 * millsSecondPerHour;
        } else {
            gmtTime = gmtTime - 4 * millsSecondPerHour;
        }
        Long localGmtTime = getTodayZero();
        //  对今日做特殊处理
        if (localGmtTime.equals(gmtTime)) {
            if (Constant.IS_HISTORY_FLAG.equals(historyFlag)) {
                return false;
            } else if (Constant.IS_NOT_HISTORY_FLAG.equals(historyFlag)) {
                return true;
            }
        }
        return gmtTime.longValue() > localGmtTime.longValue();
    }

    /**
     * 获取赛程查询页面上的 今日时间
     *
     * @return boolean
     * @description 获取当天零点时间 GMT时间
     * @author Alair
     * @date 2019/9/24 19:17
     **/
    public static Long getPageToday() {
        Long localGmtTime = getTodayZero();
        //  如果12点之前，则返回前一天的GMT-4 零时
        if (System.currentTimeMillis() % (24 * millsSecondPerHour) < (4 * millsSecondPerHour)) {
            return localGmtTime - 20 * millsSecondPerHour;
        }
        return localGmtTime + 4 * millsSecondPerHour;
    }

    public static String longCovertString(Long time) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm");
        String format = dtf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
        return format;
    }

    /**
     * 格式化时间
     * yyyy-MM-dd HH:mm
     *
     * @param date yyyy-MM-dd HH:mm
     * @return
     */
    public static String yyyyMMddHHmm(Date date) {
        if (date == null) {
            return null;
        }
        return format(date, "yyyy-MM-dd HH:mm");
    }

    /**
     * 格式化时间
     * yyyy-MM-dd HH:mm
     *
     * @param date yyyy-MM-dd HH:mm
     * @return
     */
    public static String yyyyMMdd(Date date) {
        if (date == null) {
            return null;
        }
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 函数介绍：根据默认模式包日期对象转换成日期字符串 参数：date ,日期对象；parttern,日期字符格式 返回值：日期字符串
     */
    public static String format(Date date, String parttern) {
        if (date == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(parttern);
        return df.format(date);
    }

    /**
     * 转化字符串日期未日期对象
     *
     * @param dateStr 字符串日期
     * @return 日期对象
     */
    public static Date parseStrToDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public static Integer getFromMatchTime(Integer secondsMatchStart, Long eventTime) {
        Integer accurateTime = secondsMatchStart;
        if (NumberUtils.isNotEmpty(eventTime)) {
            accurateTime = accurateTime + (int) ((System.currentTimeMillis() - eventTime) / 1000);
        }
        return accurateTime;
    }*/

    /**
     * 获取精确到秒的时间戳
     *
     * @return 秒为单位的时间戳
     */
    public static int genSecondTimestamp() {
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime() / 1000);
        return Integer.valueOf(timestamp);
    }

    public static void main(String[] args) {
        System.out.println(longCovertString(1578522500000L));
    }
}
