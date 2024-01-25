package com.booleanuk.core.models.accounts;

import com.booleanuk.core.exceptions.InsufficientFundsException;
import lombok.Data;

import static com.booleanuk.core.util.CurrencyUtils.toBaseUnits;
import static com.booleanuk.core.util.CurrencyUtils.toSubUnits;

@Data
public abstract class Account {
    protected int accountNumber;
    protected int balance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public double getBalanceInBaseUnits() {
        return toBaseUnits(balance);
    }

    public void deposit(double amount) {
        int SubUnitAmount = toSubUnits(amount);
        balance += SubUnitAmount;
    }

    public void withdraw(double amount) {
        int SubUnitAmount = toSubUnits(amount);
        if (balance >= SubUnitAmount) {
            balance -= SubUnitAmount;
        } else {
            throw new InsufficientFundsException();
        }
    }
}
