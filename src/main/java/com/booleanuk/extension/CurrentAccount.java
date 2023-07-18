package com.booleanuk.extension;

public class CurrentAccount extends Account {
    public boolean withdraw(float amount, boolean managerApproved){
        if(amount < 0) return false;

        if(checkBalance() < amount && managerApproved) {
            super.transactions.add(new Transaction(0, amount, checkBalance()));
            return true;
        }

        super.transactions.add(new Transaction(0, amount, checkBalance()));
        return true;
    }
}
