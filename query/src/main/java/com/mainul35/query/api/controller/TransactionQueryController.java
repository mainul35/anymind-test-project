package com.mainul35.query.api.controller;

import com.mainul35.query.api.model.PeriodicBtcTransactionHistoryResponse;
import com.mainul35.query.api.model.PeriodicHistoryIntervalRequest;
import com.mainul35.query.api.queries.PeriodicBtcTransactionHistoryQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/wallet")
public class TransactionQueryController {

    private final QueryGateway queryGateway;

    public TransactionQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @PostMapping("/{walletId}/transactions")
    public ResponseEntity<PeriodicBtcTransactionHistoryResponse> walletTransactionHistory (@PathVariable("walletId") String walletId, @RequestBody PeriodicHistoryIntervalRequest request) {
        PeriodicBtcTransactionHistoryQuery query = PeriodicBtcTransactionHistoryQuery
                .builder()
                .startDatetime(ZonedDateTime.parse(request.getStartDatetime(), DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                .endDatetime(ZonedDateTime.parse(request.getEndDatetime(), DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                .walletId(walletId)
                        .build();
        var response = queryGateway
                .query(query, ResponseTypes.instanceOf(PeriodicBtcTransactionHistoryResponse.class))
                .join();
        return ResponseEntity.ok(response);
    }
}
