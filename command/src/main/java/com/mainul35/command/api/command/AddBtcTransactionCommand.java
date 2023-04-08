package com.mainul35.command.api.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
public class AddBtcTransactionCommand {

    @TargetAggregateIdentifier
    private String transactionId;

    private OffsetDateTime datetime;
    private BigDecimal amount;
}
