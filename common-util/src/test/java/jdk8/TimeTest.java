package jdk8;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.util.Assert;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastInMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * Created by pmz on 2018/5/31 18:21.
 * https://lw900925.github.io/java/java8-newtime-api.html
 */
public class TimeTest {

    @Test
    public void common(){
        Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        System.out.println(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
        Date end = DateUtils.addDays(today, 4);
        System.out.println(end);
        Date start = DateUtils.addDays(end, -1);
        System.out.println(start);
    }
    @Test
    public void date(){
        LocalDate localDate = LocalDate.of(2017, 1, 4);     // 初始化一个日期：2017-01-04
        int year = localDate.getYear();                     // 年份：2017
        Month month = localDate.getMonth();                 // 月份：JANUARY
        int dayOfMonth = localDate.getDayOfMonth();         // 月份中的第几天：4
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();     // 一周的第几天：WEDNESDAY
        int length = localDate.lengthOfMonth();             // 月份的天数：31
        boolean leapYear = localDate.isLeapYear();
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek.getValue());
        System.out.println(length);
        System.out.println(leapYear);
    }

    @Test
    public void time(){
        LocalTime localTime = LocalTime.of(17, 23, 52);     // 初始化一个时间：17:23:52
        int hour = localTime.getHour();                     // 时：17
        int minute = localTime.getMinute();                 // 分：23
        int second = localTime.getSecond();
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        System.out.println(localTime);
        System.out.println(localTime.atDate(LocalDate.now()));
    }

    @Test
    public void duration(){
        LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7, 0);    // 2017-01-05 10:07:00
        LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7, 0);     // 2017-02-05 10:07:00
        Duration duration = Duration.between(from, to);     // 表示从 2017-01-05 10:07:00 到 2017-02-05 10:07:00 这段时间

        long days = duration.toDays();              // 这段时间的总天数
        long hours = duration.toHours();            // 这段时间的小时数
        long minutes = duration.toMinutes();        // 这段时间的分钟数
        long seconds = duration.getSeconds();       // 这段时间的秒数
        long milliSeconds = duration.toMillis();    // 这段时间的毫秒数
        long nanoSeconds = duration.toNanos();      // 这段时间的纳秒数
        Duration duration1 = Duration.of(5, ChronoUnit.DAYS);       // 5天
        Duration duration2 = Duration.of(1000, ChronoUnit.MILLIS);  // 1000毫秒
    }

    @Test
    public void period(){
        // 2017-01-05 到 2017-02-05 这段时间
        Period period = Period.between(
                LocalDate.of(2017, 1, 5),
                LocalDate.of(2017, 2, 5));
        System.out.println(period);
    }

    @Test
    public void curd(){
        LocalDate date = LocalDate.of(2017, 1, 5);          // 2017-01-05

        LocalDate date1 = date.withYear(2016);              // 修改为 2016-01-05
        LocalDate date2 = date.withMonth(2);                // 修改为 2017-02-05
        LocalDate date3 = date.withDayOfMonth(1);           // 修改为 2017-01-01

        LocalDate date4 = date.plusYears(1);                // 增加一年 2018-01-05
        LocalDate date5 = date.minusMonths(2);              // 减少两个月 2016-11-05
        LocalDate date6 = date.plus(5, ChronoUnit.DAYS);    // 增加5天 2017-01-10
        System.out.println(23_33l);
    }

    @Test
    public void adjust(){
        LocalDate date = LocalDate.of(2017, 1, 5);
        LocalDate date7 = date.with(nextOrSame(DayOfWeek.SUNDAY));      // 返回下一个距离当前时间最近的星期日
        LocalDate date9 = date.with(lastInMonth(DayOfWeek.SATURDAY));   // 返回本月最后一个星期六
    }

    @Test
    public void format(){
        LocalDateTime dateTime = LocalDateTime.now();
        String strDate1 = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);    // 20170105
        String strDate2 = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);    // 2017-01-05
        String strDate3 = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);    // 14:20:16.998
        String strDate4 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   // 2017-01-05
//        String strDate5 = dateTime.format(DateTimeFormatter.ofPattern("今天是：YYYY年 MM DD日 E", Locale.CHINESE)); // 今天是：2017年 一月 05日 星期四
        System.out.println(strDate1);
        System.out.println(strDate2);
        System.out.println(strDate3);
        String strDate6 = "2017-01-05";
        String strDate7 = "2017-01-05 12:30:05";

        LocalDate date = LocalDate.parse(strDate6, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime dateTime1 = LocalDateTime.parse(strDate7, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }

    @Test
    public void zone(){
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        ZoneId systemZoneId = ZoneId.systemDefault();
        System.out.println(shanghaiZoneId);
        System.out.println(systemZoneId);
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, shanghaiZoneId);
        System.out.println(zonedDateTime);

        ZoneOffset zoneOffset = ZoneOffset.of("+09:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        System.out.println(offsetDateTime);

    }
}
