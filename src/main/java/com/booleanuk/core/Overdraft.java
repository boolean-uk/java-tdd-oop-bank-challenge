package com.booleanuk.core;

public class Overdraft {

    private double amount;
    private boolean approved;
    private boolean isLookedAt;

    public Overdraft(double amount) {
        this.setAmount(amount);
        this.approved = false;
        this.isLookedAt = false;
    }

    public double getAmount() {
        return this.amount;
    }

    public boolean setAmount(double amount) {
        if(amount > 0) {
            this.amount = amount;
            return true;
        }
        return false;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public boolean setApproved(boolean approved) {
        this.approved = approved;
        return true;
    }

    public boolean isLookedAt() {
        return this.isLookedAt;
    }

    public void setLookedAt(boolean lookedAt) {
        isLookedAt = lookedAt;
    }
}
