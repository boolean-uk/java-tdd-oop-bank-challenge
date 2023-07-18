package com.booleanuk.core.accounts;

import com.booleanuk.core.users.Customer;

import java.time.LocalDateTime;

public class SavingsAccount extends Account{
    private double bankRate;
    public SavingsAccount(Customer user, Double rate) {
        super(user);
        this.bankRate = rate;
    }

    public void earnInterest(){
        double balance = calculateBalance(LocalDateTime.now());
        addTransaction(new Transaction((balance * (100 + bankRate / 12) / 100) - balance));
    }
}
