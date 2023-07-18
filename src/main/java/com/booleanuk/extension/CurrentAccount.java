package com.booleanuk.extension;

public class CurrentAccount extends Account {
    @Override
    public boolean withdraw(float amount){
        if(amount < 0) return false;
//        if(checkBalance() < amount) return false;

        super.transactions.add(new Transaction(0, amount, checkBalance()));
        return true;
    }
}
