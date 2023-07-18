package com.booleanuk.core;

public class OverdraftRequest {
    private String status;
    private final double amount;

    public OverdraftRequest(double amount) {
        this.amount = amount;
        this.status = "unchecked";
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
