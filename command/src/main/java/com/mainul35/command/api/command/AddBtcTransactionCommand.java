package com.mainul35.command.api.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
public class AddBtcTransactionCommand {

    @TargetAggregateIdentifier
    private String transactionId;
    private String walletId;
    private ZonedDateTime datetime;
    private BigDecimal amount;
}
