package com.booleanuk.core.account;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Account {
    protected BigDecimal balance = BigDecimal.ZERO;
    protected final List<Transaction> transactions = new ArrayList<>();

    void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        transactions.add(Transaction.of(Transaction.Type.Deposit, amount));
    }

    void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException(
                    String.format("Cannot withdraw $%s - insufficient funds ($%s)", amount, balance)
            );
        }

        balance = balance.subtract(amount);
        transactions.add(Transaction.of(Transaction.Type.Withdrawal, amount));
    }

    String generateStatement() {
        return "";
    }
}
