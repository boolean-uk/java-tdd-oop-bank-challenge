package com.booleanuk.extension;

public class OverdraftRequest {

    private double amount;
    private boolean approved;

    public OverdraftRequest(double amount){
        this.amount = amount;
        this.approved = false;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
