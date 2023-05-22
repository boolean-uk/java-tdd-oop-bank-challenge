package com.booleanuk.core.account;

import com.booleanuk.core.bank.Bank;
import com.booleanuk.core.statement.CreditStatement;
import com.booleanuk.core.statement.DepositStatement;
import com.booleanuk.core.statement.Statements;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class StatelessBasicBankAccount implements BankAccount {
    private double maxDebt;
    private final Statements statements;
    private Bank bank;

    public StatelessBasicBankAccount(Statements statements) {
        this.statements = statements;
        maxDebt = 0;
        this.bank = null;
    }

    private double balance() {
        return BigDecimal.valueOf(statements.balance()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
    @Override
    public double deposit(double amount) {
        if (amount <= 0) return balance();

        statements.add(new DepositStatement(LocalDate.now(), balance(), amount));
        return balance();
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0 || amount > balance() + maxDebt) return balance();

        statements.add(new CreditStatement(LocalDate.now(), balance(), amount));
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
        this.bank = bank;
    }

    @Override
    public Bank branch() {
        return this.bank;
    }
}
