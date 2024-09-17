package com.booleanuk.extension;

import java.time.LocalDate;
import java.time.LocalTime;

public class CurrentAccount extends Account {
    private String typeOfAccount;
    boolean overdraft;

    public CurrentAccount() {
        this.typeOfAccount = "current";
        this.overdraft = false;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public boolean isOverdraft() {
        return overdraft;
    }

    public void setOverdraft(boolean overdraft) {
        this.overdraft = overdraft;
    }
    @Override
    public void withdrawFunds(double amount){
        double maxOverdraft = -500.0;
        if(isOverdraft()){
            balance -= amount;
            if(balance <= maxOverdraft){
                throw new RuntimeException("Your account overdraft limit has been reached!");
            }
        } else {
            if(amount > balance){
                throw new RuntimeException("You cannot withdraw more than you've got in your account!");
            }
            balance -= amount;
        }
        Transaction transaction = new Transaction(LocalDate.now(), amount, "debit", LocalTime.now(), balance);
        transactions.add(transaction);
    }
}
