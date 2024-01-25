package com.booleanuk.core;

public class CurrentAccount extends Account{
    private boolean overdraftRequested;
    private double overdraftAmount;

    public CurrentAccount(User owner) {
        super(owner);
        this.overdraftRequested = false;
        this.overdraftAmount = 0.0;
    }

    public boolean requestOverdraft() {
        if (this.overdraftRequested){
            System.out.println("Overdraft already requested.");
            return false;
        }
        this.overdraftRequested = true;
        return true;
    }

    public void answearOverdraftRequest(boolean confirm, double overdraftAmount) {

    }


}
