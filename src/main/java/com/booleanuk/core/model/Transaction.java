package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Transaction {
    private String transactionID;
    private LocalDate date;
    private TRANSACTION_TYPE type;
    private Money money;
    private Money balance;
    private Account account;

    Transaction(TRANSACTION_TYPE type, Money money, Account account) {
        if (type == null || money == null || account == null)
            throw new NullPointerException("All fields must be non-null.");
        if (money.getAmount().compareTo(BigDecimal.ZERO) <= 0)
            throw new ArithmeticException("The amount can't be zero or negative number.");

        this.transactionID = UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.type = type;
        this.money = money;
        this.account = account;
        this.balance = this.account.getBalance();
    }

    public LocalDate getDate() {
        return date;
    }

    public TRANSACTION_TYPE getType() {
        return type;
    }

    public Money getMoney() {
        return money;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String credit = "";
        String debit = "";
        if (this.type == TRANSACTION_TYPE.DEPOSIT) credit += this.money;
        if (this.type == TRANSACTION_TYPE.WITHDRAWAL) debit += this.money;

        return String.format("%11s || %11s || %11s || %11s",
                formatter.format(this.date), credit, debit, this.balance);
    }
}
