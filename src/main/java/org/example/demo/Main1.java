package org.example.demo;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Ron
 * @Create: 2023-07-14 10:14
 */
public class Main1 {
    public static void main(String[] args) {
        String inputDate = "2023-05-19 13:07:02";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(inputDate, inputFormatter);

        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String outputDate = offsetDateTime.format(outputFormatter);

        System.out.println(outputDate);
    }
}
