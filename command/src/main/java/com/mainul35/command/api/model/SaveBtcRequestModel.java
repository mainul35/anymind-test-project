package com.mainul35.command.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
public class SaveBtcRequestModel {
    private String walletId;
    private ZonedDateTime datetime;
    private BigDecimal amount;
}
