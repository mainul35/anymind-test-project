//package com.mainul35.command.api.aggregate;
//
//import lombok.Data;
//import org.axonframework.commandhandling.CommandHandler;
//import org.axonframework.eventsourcing.EventSourcingHandler;
//import org.axonframework.modelling.command.AggregateIdentifier;
//import org.axonframework.modelling.command.AggregateLifecycle;
//import org.axonframework.modelling.command.AggregateMember;
//import org.axonframework.modelling.command.TargetAggregateIdentifier;
//import org.axonframework.spring.stereotype.Aggregate;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Aggregate
//public class WalletAggregate {
//
//    @AggregateIdentifier
//    private String walletId;
//
//    private BigDecimal balance;
//
//    @AggregateMember
//    private final List<Transaction> transactions = new ArrayList<>();
//
//    @CommandHandler
//    public WalletAggregate(CreateWalletCommand command) {
//        AggregateLifecycle.apply(new WalletCreatedEvent(command.walletId()));
//    }
//
//    @EventSourcingHandler
//    public void on(WalletCreatedEvent event) {
//        walletId = event.walletId();
//        balance = BigDecimal.ZERO;
//    }
//
//    public WalletAggregate() {
//    }
//
//    @CommandHandler
//    public void addTransaction(AddTransactionCommand command) {
//        AggregateLifecycle.apply(new TransactionAddedEvent(walletId, command.transaction()));
//    }
//
//    @EventSourcingHandler
//    public void on(TransactionAddedEvent event) {
//        transactions.add(event.transaction());
//        balance = calculateBalance(transactions);
//    }
//
//    private BigDecimal calculateBalance(List<Transaction> transactions) {
//        BigDecimal total = BigDecimal.ZERO;
//        for (Transaction t : transactions) {
//            total = total.add(t.getAmount());
//        }
//        return total;
//    }
//
//    // Getters and setters omitted for brevity
//}
//
//@Data
//class Transaction {
//
//    private LocalDateTime datetime;
//    private BigDecimal amount;
//
//    public Transaction(LocalDateTime datetime, BigDecimal amount) {
//        this.datetime = datetime;
//        this.amount = amount;
//    }
//
//}
//
//
//// Commands and events
//record CreateWalletCommand(@TargetAggregateIdentifier String walletId) {
//
//    @Override
//    public String walletId() {
//        return walletId;
//    }
//}
//
//record WalletCreatedEvent(String walletId) {
//
//}
//
//record AddTransactionCommand(@TargetAggregateIdentifier String walletId, Transaction transaction) {
//
//    @Override
//    public String walletId() {
//        return walletId;
//    }
//}
//
//record TransactionAddedEvent(String walletId, Transaction transaction) {
//
//}