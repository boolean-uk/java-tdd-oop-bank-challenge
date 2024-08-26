package com.booleanuk.core;

public class CurrentAccount extends Account {
    private double overDraftLimit;
    private double requestedOverdraftLimit;
    private double approvedOverdraftLimit;
    private boolean overdraftApproved;

    public CurrentAccount(double balance) {
        super(balance);
        this.overDraftLimit = 0;

    }

    public void requestOverdraft(double limit) {
        this.requestedOverdraftLimit = limit;
        this.overdraftApproved = false;
    }

    public boolean approveOverdraft(double limit) {
        if (limit <= requestedOverdraftLimit) {
            this.approvedOverdraftLimit = limit;
            this.overdraftApproved = true;
        }
        return false;
    }

    public void rejectOverdraft() {
        this.approvedOverdraftLimit = 0;
        this.overdraftApproved = false;
    }

    public double getApprovedOverdraftLimit() {
        return overdraftApproved ? approvedOverdraftLimit : 0;
    }

    @Override
    public String withdraw(double amount) {
        double currentBalance = getBalance();
        double availableFunds = currentBalance + getApprovedOverdraftLimit();

        if (availableFunds >= amount) {
            setBalance(currentBalance - amount);  // Use setBalance to update the balance
            addTransaction(-amount, "debit");
            return "Withdrawal Successful";
        } else {
            return "You don't have enough money for this withdrawal!";
        }
    }

    public boolean isOverdraftApproved() {
        return overdraftApproved;
    }

    public void setOverdraftApproved(boolean overdraftApproved) {
        this.overdraftApproved = overdraftApproved;
    }
}
