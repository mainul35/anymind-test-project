package com.mainul35.command.api.model;

import lombok.Data;

@Data
public class SaveBtcResponseModel {
    private String transactionStatus;
    private String transactionId;

    public enum TransactionStatus {
        SUBMITTED, PENDING, FAILED
    }
}
