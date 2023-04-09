package com.mainul35.command.api.aggregate;

import com.mainul35.command.api.command.AddBtcTransactionCommand;
import com.mainul35.common.event.AddBtcTransactionEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Aggregate
public class TransactionAggregate {

    private String walletId;
    @AggregateIdentifier
    private String transactionId;
    private ZonedDateTime datetime;
    private BigDecimal amount;

    public TransactionAggregate () {}

    @CommandHandler
    public TransactionAggregate(AddBtcTransactionCommand addBtcTransactionCommand) {
        AddBtcTransactionEvent addBtcTransactionEvent =
                new AddBtcTransactionEvent();
        BeanUtils.copyProperties(addBtcTransactionCommand,addBtcTransactionEvent);
        AggregateLifecycle.apply(addBtcTransactionEvent);
    }

    @EventSourcingHandler
    public void on(AddBtcTransactionEvent addBtcEvent) {
        this.amount = addBtcEvent.getAmount();
        this.transactionId = addBtcEvent.getTransactionId();
        this.walletId = addBtcEvent.getWalletId();
        this.amount = addBtcEvent.getAmount();
        this.datetime = addBtcEvent.getDatetime();
    }
}
