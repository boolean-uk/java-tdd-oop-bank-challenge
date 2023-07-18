package com.booleanuk.core;

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

    public List<Account> getAccountsByType(String accountType) {
        if (!accountType.equalsIgnoreCase("saving") && !accountType.equalsIgnoreCase("current")) {
            throw new RuntimeException("We don't have this type of account!");
        }
        return accounts.stream()
                .filter(account -> account.getTypeOfAccount().equalsIgnoreCase(accountType))
                .toList();
    }

    public SavingAccount createSavingAccount() {
        SavingAccount savingAccount = new SavingAccount();
        accounts.add(savingAccount);
        return savingAccount;
    }

    public CurrentAccount createCurrentAccount() {
        CurrentAccount currentAccount = new CurrentAccount();
        accounts.add(currentAccount);
        return currentAccount;
    }
}
