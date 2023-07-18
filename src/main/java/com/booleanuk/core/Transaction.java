package com.booleanuk.core;

import com.booleanuk.core.enums.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private final TRANSACTION_TYPE type;
    private final BigDecimal amount;
    private final Account account;
    private final LocalDate date;
    private final BigDecimal balance;


    public Transaction(TRANSACTION_TYPE type, BigDecimal amount, Account account) {
        this.type = type;
        this.amount = amount;
        this.account = account;
        this.date = LocalDate.now();
        this.balance = account.getBalance();
    }

    public TRANSACTION_TYPE getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }


}
