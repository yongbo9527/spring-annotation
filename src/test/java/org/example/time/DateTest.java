package org.example.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Date;

/**
 * @Author: Ron
 * @Create: 2023-11-13 14:05
 */
public class DateTest {
    @Test
    public void test01() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        System.out.println("当前时间：" + format);

        String time = "2023-11-13 14:05:00";
        LocalDateTime parse = LocalDateTime.parse(time, dateTimeFormatter);
        // LocalDateTime 转为时间戳

        long l = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long l1 = System.currentTimeMillis();
        long nowTime = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println("当前时间：" + nowTime);
        System.out.println("指定时间：" + l);
        System.out.println("当前时间戳：" + l1);

        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println("获取本初子午线对应的标准时间: "+instant); //2020-05-10T10:00:00.641Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));//东八区
        System.out.println("添加时间的偏移量: "+offsetDateTime); //2020-05-10T18:00:00.641+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println("获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数: "+milli); //1589107200641


    }

    @Test
    public void test02() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        System.out.println("当前时间：" + format);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String name = dayOfWeek.name();
        System.out.println("今天是周几：" + name);

        LocalDateTime with = now.with(DayOfWeek.SUNDAY);
        String format1 = dateTimeFormatter.format(with);
        System.out.println("本周周日是：" + format1);

        int i = dayOfWeek.get(ChronoField.DAY_OF_WEEK);
        System.out.println("今天是周几：" + i);
    }

    @Test
    public void test03(){
        LocalDateTime now = LocalDateTime.now(); // 当前日期时间对象

        int year = now.get(ChronoField.YEAR); // 获取年份
        int month = now.get(ChronoField.MONTH_OF_YEAR); // 获取月份
        int day = now.get(ChronoField.DAY_OF_MONTH); // 获取日期
        System.out.println("年份：" + year);
        System.out.println("月份：" + month);
        System.out.println("日期：" + day);

        LocalDateTime modifiedDateTime = now.with(ChronoField.HOUR_OF_DAY, 10); // 修改小时字段为 10
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(modifiedDateTime);
        System.out.println("修改后的日期时间：" + format);


        ValueRange hourRange = ChronoField.HOUR_OF_DAY.range(); // 获取小时字段的有效范围
        long minHour = hourRange.getMinimum(); // 最小小时值
        long maxHour = hourRange.getMaximum(); // 最大小时值
        System.out.println("小时字段的最小值：" + minHour);
        System.out.println("小时字段的最大值：" + maxHour);

    }

    @Test
    public void test04(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println("instant：" + instant);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("zonedDateTime：" + zonedDateTime);
        LocalDateTime localDateTime1 = zonedDateTime.toLocalDateTime();
        System.out.println("localDateTime1：" + dateTimeFormatter.format(localDateTime1));


        //A time-zone ID, such as {@code Europe/Paris}.(时区)
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println("当前时间：" + format);

        String dateStr = "2023-11-13 14:05:00";
        LocalDateTime parse = LocalDateTime.parse(dateStr, dateTimeFormatter);
        Duration duration= Duration.between(parse,zonedDateTime.toLocalDateTime());
        System.out.println("相差小时数：" + duration.toHours());
    }

    @Test
    public void test05(){
        Duration duration = Duration.ofMinutes(30); // 创建表示30分钟的 Duration 对象

        long minutes = duration.toMinutes(); // 获取 Duration 对象的分钟数
        long seconds = duration.getSeconds(); // 获取 Duration 对象的秒数
        System.out.println("minutes：" + minutes);
        System.out.println("seconds：" + seconds);
    }

    @Test
    public void test06(){
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println("instant：" + instant);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Europe/Paris"));
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        int nano = localDateTime.getNano();
        System.out.println("nano：" + nano);

        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.of("Asia/Shanghai"));
        LocalDateTime localDateTime1 = zonedDateTime1.toLocalDateTime();
        int nano1 = localDateTime1.getNano();
        System.out.println("nano1：" + nano1);

        Duration duration = Duration.between(localDateTime, localDateTime1);
        System.out.println("相差小时数：" + duration.toHours());

    }
}
