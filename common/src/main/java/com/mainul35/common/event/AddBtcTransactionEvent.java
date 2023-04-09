package com.mainul35.common.event;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
public class AddBtcTransactionEvent {
    private String transactionId;
    private String walletId;
    private ZonedDateTime datetime;
    private BigDecimal amount;
}
