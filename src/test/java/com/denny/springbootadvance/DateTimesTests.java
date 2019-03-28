package com.denny.springbootadvance;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DateTimesTests {
    @Test
    public void today() {
        LocalDate now = LocalDate.now();
        log.info(now.toString());
        log.info("年:{},月：{}，日：{}", now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        LocalDate localDate = LocalDate.of(2019, 3, 12);
        log.info("输入的时间:{}", localDate);
        LocalDateTime now1 = LocalDateTime.now();
        log.info(now1.toString());
        LocalTime parse = LocalTime.parse("12:56:08");
        log.info(parse.toString());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(now1);
        log.info(format);
    }

}
