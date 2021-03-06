package com.zywork.common;

import com.zywork.enums.DatePatternEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间解析工具类<br/>
 * 创建于2019-02-28<br/>
 *
 * @author 危锦辉
 * @version 1.0
 */
public class DateParseUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateParseUtils.class);

    /**
     * 把时间字符串执照默认时间格式解析成Date实例
     * @param dateStr 时间字符串
     * @return 通过默认的时间格式解析成的Date实例
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, DatePatternEnum.DATETIME.getValue());
    }

    /**
     * 把时间字符串按照指定时间格式解析成Date实例
     * @param dateStr 时间字符串
     * @param pattern 时间格式
     * @return 通过指定时间格式解析成的Date实例
     */
    public static Date parseDate(String dateStr, String pattern) {
        try {
            return DateFormatUtils.getDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            logger.error("Parse date error: {}, dateStr: {}, pattern: {}" , e.getMessage(), dateStr, pattern);
            return null;
        }
    }

    /**
     * 把时间字符串按照指定格式解析成Calendar实例
     * @param dateStr 时间字符串
     * @param pattern 时间格式
     * @return 通过指定格式解析成的Calendar实例
     */
    public static Calendar parseCalendar(String dateStr, String pattern) {
        return DateUtils.dateToCalendar(parseDate(dateStr, pattern));
    }

    /**
     * 把时间字符串按照指定格式解析成LocalDateTime实例
     * @param dateStr 时间字符串
     * @param pattern 时间格式
     * @return 通过指定格式解析成的LocalDateTime实例
     */
    public static LocalDateTime parseLocalDateTime(String dateStr, String pattern) {
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 把时间字符串按照指定格式解析成Instant实例
     * @param dateStr 时间字符串
     * @param pattern 时间格式
     * @return 通过指定格式解析成的Instant实例
     */
    public static Instant parseInstant(String dateStr, String pattern) {
        return DateUtils.localDateTimeToInstant(parseLocalDateTime(dateStr, pattern));
    }

}
