package com.booleanuk.core;

import java.util.Objects;

public class OverdraftRequest {
    private Customer customer;
    private int accountId;
    private double overdraft;

    public OverdraftRequest(Customer customer, int account, double overdraft) {
        this.customer = customer;
        this.accountId = account;
        this.overdraft = overdraft;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public String toString() {
        return customer.getName() + " requests "+ String.format("%.2f", overdraft) + " for their account with id " + accountId + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof OverdraftRequest)) {
            return false;
        }

        OverdraftRequest other = (OverdraftRequest) obj;
        return this.customer.equals(other.customer) && this.accountId == other.accountId && this.overdraft == other.overdraft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, accountId, overdraft);
    }

}
