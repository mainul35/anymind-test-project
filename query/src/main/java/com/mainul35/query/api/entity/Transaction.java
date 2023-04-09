package com.mainul35.query.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
public class Transaction {

    @Id
    private String transactionId;
    private String walletId;
    private ZonedDateTime datetime;
    private BigDecimal amount;
}
