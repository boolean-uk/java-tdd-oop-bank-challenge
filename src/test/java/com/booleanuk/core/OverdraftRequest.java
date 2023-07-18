package com.booleanuk.core;

public class OverdraftRequest {
    private String status;
    private String amount;

    public OverdraftRequest(String amount) {
        this.amount = amount;
        this.status = "unchecked";
    }

    public String getStatus() {
        return status;
    }

    public String getAmount() {
        return amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
