package com.mainul35.command.api.aggregate;

import com.mainul35.command.api.command.AddBtcTransactionCommand;
import com.mainul35.command.api.events.AddBtcEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Aggregate
public class TransactionAggregate {

    private String walletId;
    @AggregateIdentifier
    private String transactionId;
    private OffsetDateTime datetime;
    private BigDecimal amount;

    public TransactionAggregate () {}

    @CommandHandler
    public TransactionAggregate(AddBtcTransactionCommand addBtcTransactionCommand) {
        AddBtcEvent productCreatedEvent =
                new AddBtcEvent();
        BeanUtils.copyProperties(addBtcTransactionCommand,productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(AddBtcEvent addBtcEvent) {
        this.amount = addBtcEvent.getAmount();
        this.transactionId = addBtcEvent.getTransactionId();
        this.walletId = addBtcEvent.getWalletId();
        this.amount = addBtcEvent.getAmount();
        this.datetime = addBtcEvent.getDatetime();
    }
}
