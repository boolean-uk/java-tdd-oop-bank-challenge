package com.booleanuk.core;

public class Overdraft {

    private double amount;
    private boolean approved;

    public Overdraft(double amount) {
        this.setAmount(amount)
        this.approved = false;
    }

    public double getAmount() {
        return this.amount;
    }

    public boolean setAmount(double amount) {
        this.amount = amount;
        return true;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public boolean setApproved(boolean approved) {
        this.approved = approved;
        return true;
    }
}
