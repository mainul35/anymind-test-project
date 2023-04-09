package com.mainul35.query.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PeriodicBtcTransactionHistoryResponse {
    private String walletId;
    private List<BtcTransaction> btcTransactions;
}
