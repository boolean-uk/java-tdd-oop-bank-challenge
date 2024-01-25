package com.booleanuk.core;

public class CurrentAccount extends Account{
    public CurrentAccount(User user){
        super(user);
    }

    public String toString(){
        return "Balance of this current account is: " + this.getBalance();
    }
}
