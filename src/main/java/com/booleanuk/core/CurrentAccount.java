package com.booleanuk.core;

import java.time.LocalDateTime;

public class CurrentAccount extends BankAccount{

    private double overdraftLimit;

    public CurrentAccount(Branch branch) {
        super(branch);
        overdraftLimit = -500;
    }

    public void withdraw(double amount, LocalDateTime localDateTime){
        double newValue = balance - amount;
        if(newValue < 0 || newValue > 0){
            // Request for overdraft
            if(requestOverdraft(newValue)){
                balance -= amount;
                transactions.add(new Transaction(localDateTime, amount, balance, "-"));
            }
        }
    }

    private Boolean requestOverdraft(double belowZero){
        // Reject or accept request
        return (belowZero > overdraftLimit);
    }

}
