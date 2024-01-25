package com.booleanuk.core;

public class SavingsAccount extends Account{
    private double overdraftAmount;
    private boolean requestForOverdraftIsGranted;

    public SavingsAccount(int accountId, Branch branch) {
        super(accountId, branch);
    }

    @Override
    public void withdraw(double amount) {
        double balance = this.getBalance();
        if(amount <= balance) {
            super.withdraw(amount);
        }
        else if(requestForOverdraftIsGranted) {
            super.withdraw(amount);
            overdraftAmount = 0.0;
            requestForOverdraftIsGranted = false;
        }
    }

    public void makeRequestForOverdraft(double overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }

    public double getRequestForOverDraft() {
        return this.overdraftAmount;
    }

    public void grantOverdraftRequest(boolean requestForOverdraftIsGranted) {
        if(overdraftAmount > 0) {
            this.requestForOverdraftIsGranted = requestForOverdraftIsGranted;
        }
    }

    public boolean isOverDraftRequestGranted() {
        return this.requestForOverdraftIsGranted;
    }
}
