package com.booleanuk.core.models.accounts;

import com.booleanuk.core.exceptions.InsufficientFundsException;
import com.booleanuk.core.exceptions.OverdraftRequestException;
import com.booleanuk.core.models.Transaction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.booleanuk.core.util.CurrencyUtils.toBaseUnits;
import static com.booleanuk.core.util.CurrencyUtils.toSubUnits;

@Data
public abstract class Account {
    protected int accountNumber;
    protected int balance;
    protected int maximumOverdraft;
    private List<Transaction> transactionHistory;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.maximumOverdraft = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalanceInBaseUnits() {
        return toBaseUnits(balance);
    }

    public double getBalanceInBaseUnitsFromTransactions() {
        return toBaseUnits(getBalanceFromTransactions());
    }

    public int getBalanceFromTransactions() {
        int sum = 0;
        for (Transaction transaction : transactionHistory) {
            switch (transaction.getTransactionType()) {
                case DEPOSIT -> sum += transaction.getAmount();
                case WITHDRAWAL -> sum -= transaction.getAmount();
            }
        }
        return sum;
    }

    public void deposit(double amount) {
        int subUnitAmount = toSubUnits(amount);
        balance += subUnitAmount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, OverdraftRequestException {
        int subUnitAmount = toSubUnits(amount);
        if (balance < subUnitAmount) {
            requestOverdraft(subUnitAmount);
        }
        balance -= subUnitAmount;
    }

    private void requestOverdraft(int amount) throws OverdraftRequestException, InsufficientFundsException {
        // Check if account with a maximum overdraft
        if (this.getMaximumOverdraft() == 0) {
            throw new InsufficientFundsException();
        }
        // Check if account would dip below the maximum overcharge
        int balanceAfter = balance - amount;
        if (balanceAfter < -getMaximumOverdraft()) {
            throw new OverdraftRequestException();
        }
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }
}
