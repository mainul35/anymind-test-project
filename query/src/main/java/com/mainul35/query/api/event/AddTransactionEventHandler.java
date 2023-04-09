package com.mainul35.query.api.event;

import com.mainul35.query.api.entity.Transaction;
import com.mainul35.common.event.AddBtcTransactionEvent;
import com.mainul35.query.api.repository.TransactionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddTransactionEventHandler {
        private final TransactionRepository transactionRepository;

        public AddTransactionEventHandler(TransactionRepository transactionRepository) {
                this.transactionRepository = transactionRepository;
        }

        @EventHandler
        public void on(AddBtcTransactionEvent event) {
                var transaction = new Transaction();
                BeanUtils.copyProperties(event, transaction);
                transactionRepository.save(transaction);
        }
}
