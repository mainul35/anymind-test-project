package com.mainul35.command.api.events;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class AddBtcEvent {
    private String transactionId;
    private String walletId;
    private OffsetDateTime datetime;
    private BigDecimal amount;

}
