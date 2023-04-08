package com.mainul35.command.api.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
public class Transaction {

    @Id
    private String transactionId;

    private OffsetDateTime datetime;
    private BigDecimal amount;

}
