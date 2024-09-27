package com.booleanuk.core;

import java.util.Date;
import java.util.List;

public class CurrentAccount extends Account{

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount, Date date) {
        if (amount > 0 && getBalance() >= amount) {
            super.balance -= amount;
            getHistory().add(new Transaction(date, 0, amount, getBalance()));
            System.out.println("withdraw done successfully");
        } else {
            System.out.println("withdraw failed");
        }
    }
}
