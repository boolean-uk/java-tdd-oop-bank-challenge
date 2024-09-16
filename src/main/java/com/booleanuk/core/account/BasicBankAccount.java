package com.booleanuk.core.account;

import com.booleanuk.core.bank.Bank;
import com.booleanuk.core.statement.CreditStatement;
import com.booleanuk.core.statement.DepositStatement;
import com.booleanuk.core.statement.Statements;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class BasicBankAccount implements BankAccount {
    private double maxDebt;
    private double balance;
    private final Statements statements;
    private Bank assosiatedBank;

    public BasicBankAccount(double balance, Statements statements) {
        this.balance = balance;
        this.statements = statements;
        maxDebt = 0;
        this.assosiatedBank = null;
    }

    private double balance() {
        return BigDecimal.valueOf(balance).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    @Override
    public double deposit(double amount) {
        if (amount <= 0) return balance;

        statements.add(new DepositStatement(LocalDate.now(), balance, amount));
        balance += amount;
        return balance();
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0 || amount > balance) return balance;

        statements.add(new CreditStatement(LocalDate.now(), balance, amount));
        balance -= amount;
        return balance();
    }

    @Override
    public String statement() {
        return statements.details();
    }

    @Override
    public boolean deserveOverdraft(double maxDebt) {
        if (balance() < 0) return false;
        this.maxDebt = maxDebt;
        return true;
    }

    @Override
    public void associateTo(Bank bank) {
        this.assosiatedBank = bank;
    }

    @Override
    public Bank branch() {
        return this.assosiatedBank;
    }
}
