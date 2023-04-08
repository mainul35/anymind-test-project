package com.mainul35.command.api.events;

import com.mainul35.command.api.data.Transaction;
import com.mainul35.command.api.data.TransactionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddBtcEventHandler {
        private final TransactionRepository transactionRepository;

        public AddBtcEventHandler(TransactionRepository transactionRepository) {
                this.transactionRepository = transactionRepository;
        }

        @EventHandler
        public void on(AddBtcEvent event) {
                var transaction = new Transaction();
                BeanUtils.copyProperties(event, transaction);
                transactionRepository.save(transaction);
        }
}
