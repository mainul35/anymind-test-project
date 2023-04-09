package com.mainul35.query.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeriodicHistoryIntervalRequest {
    private String startDatetime;
    private String endDatetime;
}
