package com.mainul35.command.api.controller;

import com.mainul35.command.api.command.AddBtcTransactionCommand;
import com.mainul35.command.api.model.SaveBtcRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/btc")
public class BtcCommandController {

    private final CommandGateway commandGateway;

    public BtcCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @PostMapping("/save")
    public String addProduct(@RequestBody SaveBtcRequestModel model) {
        var cmd = AddBtcTransactionCommand.builder()
                .transactionId(UUID.randomUUID().toString())
                .amount(model.getAmount())
                .datetime(model.getDatetime())
                .build();

        String result = commandGateway.sendAndWait(cmd);
        return result;
    }
}