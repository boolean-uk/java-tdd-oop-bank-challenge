package com.booleanuk.core.account;

import com.booleanuk.core.statement.CreditStatement;
import com.booleanuk.core.statement.DepositStatement;
import com.booleanuk.core.statement.Statements;

import java.time.LocalDate;

public class BasicBankAccount implements BankAccount {
    private double balance;
    private final Statements statements;
    public BasicBankAccount(double balance, Statements statements) {
        this.balance = balance;
        this.statements = statements;
    }
    @Override
    public double deposit(double amount) {
        if (amount <= 0) return balance;

        statements.add(new DepositStatement(LocalDate.now(), balance, amount));
        balance += amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) return balance;

        statements.add(new CreditStatement(LocalDate.now(), balance, amount));
        balance -= amount;
        return balance;
    }

    @Override
    public String statement() {
        return statements.details();
    }
}
