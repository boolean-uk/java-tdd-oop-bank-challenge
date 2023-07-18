package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String fullName;
    private List<Account> accounts;

    public Customer(String fullName) {
        this.fullName = fullName;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public CurrentAccount createCurrentAccount() {
        CurrentAccount currentAccount = new CurrentAccount();
        accounts.add(currentAccount);
        return currentAccount;
    }

}
