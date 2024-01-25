package com.booleanuk.core.models.accounts;

import com.booleanuk.core.exceptions.InsufficientFundsException;
import com.booleanuk.core.exceptions.OverdraftRequestException;
import com.booleanuk.core.models.Transaction;
import com.booleanuk.extension.models.OverdraftRequest;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.booleanuk.core.util.CurrencyUtils.toBaseUnits;
import static com.booleanuk.core.util.CurrencyUtils.toSubUnits;
import static com.booleanuk.extension.OverdraftManager.requestOverdraft;

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
            // If not enough money on account request an overdraft
            // Should throw OverdraftRequestException and exit the method if denied
            requestOverdraft(new OverdraftRequest(this, amount));
        }

        balance -= subUnitAmount;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }
}
