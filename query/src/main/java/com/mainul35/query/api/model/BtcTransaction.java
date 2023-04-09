package com.mainul35.query.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
public class BtcTransaction {
    private ZonedDateTime datetime;
    private BigDecimal amount;
}
