package com.mainul35.query.api.queries;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
@Data
public class PeriodicBtcTransactionHistoryQuery {

    private String walletId;
    private ZonedDateTime startDatetime;
    private ZonedDateTime endDatetime;
}
