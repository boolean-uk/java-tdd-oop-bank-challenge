package com.booleanuk.core;

public class CurrentAccount extends Account{
    public CurrentAccount(){
        super();
    }

    public String toString(){
        return "Balance of this current account is: " + this.getBalance();
    }
}
