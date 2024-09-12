package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.TRANSACTION_TYPE;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

class Transaction {
    private final String transactionID;
    private final LocalDate date;
    private final TRANSACTION_TYPE type;
    private final Money money;
    private final Money balance;
    private final Account account;

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
        return this.date;
    }

    public TRANSACTION_TYPE getType() {
        return this.type;
    }

    public Money getMoney() {
        return this.money;
    }

    public  Money getBalance() { return this.balance; }

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
