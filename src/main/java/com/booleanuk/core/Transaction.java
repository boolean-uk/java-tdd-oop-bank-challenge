package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    BigDecimal amount;
    LocalDateTime dateTime;
    accountType type;
    enum accountType{
        CREDIT,
        DEBET
    }

    public Transaction(BigDecimal amount,accountType type) {
        this.amount = amount;
        this.dateTime=LocalDateTime.now();
        this.type=type;
    }
}
