package com.booleanuk.core.account;

import com.booleanuk.core.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class BasicBankAccount implements BankAccount {
    private double balance;
    private final List<Statement> statements;
    public BasicBankAccount(double balance) {
        this.balance = balance;
        this.statements = new ArrayList<>();
    }
    @Override
    public double deposit(double amount) {
        return 0;
    }

    @Override
    public double withdraw(double amount) {
        return 0;
    }

    @Override
    public String statements() {
        return "";
    }
}
