package com.mainul35.query.api.projection;

import com.mainul35.common.exceptions.NotFoundException;
import com.mainul35.query.api.entity.HourlyWalletBalanceHistoryView;
import com.mainul35.query.api.model.BtcTransaction;
import com.mainul35.query.api.model.PeriodicBtcTransactionHistoryResponse;
import com.mainul35.query.api.queries.PeriodicBtcTransactionHistoryQuery;
import com.mainul35.query.api.repository.HourlyWalletBalanceHistoryViewRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionProjection {
    private final HourlyWalletBalanceHistoryViewRepository hourlyWalletBalanceHistoryViewRepository;

    public TransactionProjection(HourlyWalletBalanceHistoryViewRepository hourlyWalletBalanceHistoryViewRepository) {
        this.hourlyWalletBalanceHistoryViewRepository = hourlyWalletBalanceHistoryViewRepository;
    }

    @QueryHandler
    public PeriodicBtcTransactionHistoryResponse handle(PeriodicBtcTransactionHistoryQuery query) {
        List<HourlyWalletBalanceHistoryView> hourlyWalletBalanceHistoryViewList =
                hourlyWalletBalanceHistoryViewRepository.findBetweenDateTimesForWallet(query.getStartDatetime(), query.getEndDatetime(), query.getWalletId());

        var response = PeriodicBtcTransactionHistoryResponse
                .builder()
                .btcTransactions(new ArrayList<>())
                .build();
        hourlyWalletBalanceHistoryViewList.stream()
                        .forEach(view -> {
                            response.setWalletId(view.getWallerId());
                            var tx = BtcTransaction.builder().datetime(view.getDateTime())
                                    .amount(view.getBalance())
                                    .build();
                            response.getBtcTransactions().add(tx);
                        });
        return response;
    }
}
