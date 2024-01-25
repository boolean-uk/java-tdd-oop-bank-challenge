package com.booleanuk.core;

public class CurrentAccount extends Account{
    private boolean overdraftRequested;
    private double overdraftAmount;

    public CurrentAccount(User owner) {
        super(owner);
        this.overdraftRequested = false;
        this.overdraftAmount = 0.0;
    }

    public boolean isOverdraftRequested() {
        return this.overdraftRequested;
    }

    public double getOverdraftAmount() {
        return this.overdraftAmount;
    }

    public boolean requestOverdraft() {
        if (this.overdraftRequested){
            System.out.println("Overdraft already requested.");
            return false;
        }
        this.overdraftRequested = true;
        return true;
    }

    public void answerOverdraftRequest(boolean confirm, double overdraftAmount) {
        if (confirm && isOverdraftRequested()) {
            this.overdraftAmount = overdraftAmount;
            this.overdraftRequested = false;
        }
        else if (!isOverdraftRequested()) {
            System.out.println("The owner has not requested overdraft.");
        }
        else {
            this.overdraftRequested = false;
            System.out.println("The request was rejected.");
        }
    }

    @Override
    public boolean withdraw(double debit) {
        boolean newBalanceNotLessThanOverdraftAmount = (this.calculateBalance() - debit) >= -this.getOverdraftAmount();
        if(debit > 0 && newBalanceNotLessThanOverdraftAmount) {
            this.setBalance(-this.toInt(debit));
            this.transactions.add(new Transaction(-toInt(debit),toInt(this.calculateBalance())));
            return true;
        }
        return false;
    }


}
