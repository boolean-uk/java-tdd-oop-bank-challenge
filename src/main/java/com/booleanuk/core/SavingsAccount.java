package com.booleanuk.core;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountId, Customer customer, Branch branch) {
        super(accountId, customer, branch);
    }

    @Override
    public String requestOverdraft(double amount) {
        return "You can not overdraft a savings account";
    }
}
