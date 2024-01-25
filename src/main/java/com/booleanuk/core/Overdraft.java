package com.booleanuk.core;

public class Overdraft {

    private double amount;
    private boolean approved;

    public Overdraft(double amount) {
        this.amount = amount;
        this.approved = false;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
