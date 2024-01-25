package com.booleanuk.core;

public class SavingsAccount extends Account{
    public SavingsAccount(User user){
        super(user);
    }

    public String toString(){
        return "Balance of this savings account is: " + this.getBalance();
    }
}
