package com.booleanuk.core;

public class OverdraftRequest {

    private Customer customer;
    private Account account;
    private double requestAmount;

    public OverdraftRequest(Customer customer, Account account, double requestAmount){
        this.customer = customer;
        this.account = account;
        this.requestAmount = requestAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(double requestAmount) {
        this.requestAmount = requestAmount;
    }
}
