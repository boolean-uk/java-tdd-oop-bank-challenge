package com.booleanuk.core.users;

import com.booleanuk.core.accounts.Account;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    protected static int customerCount = 0;
    private List<Account> accounts;
    public Customer(String name, String surname, String login, String password, String branchID) {
        super(name, surname, login, password, branchID);
        accounts = new ArrayList<>();
    }

    public void createStandardAccount(){}

    public void createSavingsAccount(Double rate){}

    public void deposit(double amount, long accountId){}

    public void withdraw(double amount, long accountId){}

    public static int getCustomerCount() {
        return customerCount;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
