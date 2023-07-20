package com.booleanuk.core;

public class OverdraftRequest {
    private String requestId;
    private String accountNumber;
    private double amount;
    private String status;

    public OverdraftRequest(String requestId, String accountNumber, double amount) {
        this.requestId = requestId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = "pending";
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}
