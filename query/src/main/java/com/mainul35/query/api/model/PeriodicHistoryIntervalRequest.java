package com.mainul35.query.api.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class PeriodicHistoryIntervalRequest {
    private String startDatetime;
    private String endDatetime;
}
