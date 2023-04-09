package com.mainul35.command.api.controller;

import com.mainul35.command.api.command.AddBtcTransactionCommand;
import com.mainul35.command.api.model.SaveBtcRequestModel;
import com.mainul35.command.api.model.SaveBtcResponseModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/transactions")
public class TransactionCommandController {

    private final CommandGateway commandGateway;

    public TransactionCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public ResponseEntity<SaveBtcResponseModel> addProduct(@RequestBody SaveBtcRequestModel model) {
        var cmd = AddBtcTransactionCommand.builder()
                .transactionId(UUID.randomUUID().toString())
                .amount(model.getAmount())
                .walletId(model.getWalletId())
                .datetime(model.getDatetime())
                .build();

        String result = commandGateway.sendAndWait(cmd);
        var resp = new SaveBtcResponseModel();
        resp.setTransactionId(result);
        resp.setTransactionStatus(String.valueOf(SaveBtcResponseModel.TransactionStatus.SUBMITTED));
        return ResponseEntity.ok(resp);
    }
}
