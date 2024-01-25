package com.booleanuk.core;

public class Customer {
    private String customerID;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;

    public Customer(String customerID, Branch branch){
        this.customerID = customerID;
        this.currentAccount = new CurrentAccount(branch);
        this.savingsAccount = new SavingsAccount(branch);

        this.currentAccount.setCustomer(this);
        this.savingsAccount.setCustomer(this);
    }
    public String getCustomerID() {
        return customerID;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }
}
