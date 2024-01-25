package com.booleanuk.core;

public class CurrentAccount extends Account{
    private double balance;
    private double overdraft;
    public CurrentAccount(User user) {
        super(user);
        this.balance = getBalance();
        this.overdraft = getOverdraft();
    }

    @Override
    public double getOverdraft(){
        return overdraft;
    }
    public void setOverdraft(double overdraft){
        this.overdraft = overdraft;
    }
}
