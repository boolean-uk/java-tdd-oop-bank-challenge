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
        return false;
    }

    public void answearOverdraftRequest(boolean confirm, double overdraftAmount) {

    }


}
