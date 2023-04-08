package com.mainul35.command.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class SaveBtcRequestModel {
    private OffsetDateTime datetime;
    private BigDecimal amount;
}
