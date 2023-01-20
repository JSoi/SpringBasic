package com.practice.demo.mvc.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public interface ChartDataDto {
    Timestamp getDateTime();
    String getRate();
}
