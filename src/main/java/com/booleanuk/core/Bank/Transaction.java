package com.booleanuk.core.Bank;

import com.booleanuk.core.Enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class Transaction {
    private BigDecimal amount;
    private Instant timestamp;
    private TransactionType type;

    public Transaction(TransactionType type, BigDecimal amount) {
        this.setAmount(amount);
        this.setType(type);
        this.setTimestamp(Instant.now());

    }
}
