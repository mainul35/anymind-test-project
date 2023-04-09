package com.mainul35.query.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.Immutable;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity(name = "hourly_wallet_balance_history")
@Immutable
public class HourlyWalletBalanceHistoryView {
    @Id
    private Long id;
    @Column(name = "datetime_hour")
    private ZonedDateTime dateTime;
    @Column(name = "wallet_id")
    private String wallerId;
    @Column(name = "balance")
    private BigDecimal balance;
}
