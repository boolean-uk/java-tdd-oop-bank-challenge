package com.booleanuk.core;

import java.util.Date;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount, Date date) {
        if (amount > 0 && getBalance() >= amount) {
            super.withdraw(amount, date);
            System.out.println("Withdrawal of " + amount + " completed successfully");
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or amount should be greater than 0.");
        }
    }
}
