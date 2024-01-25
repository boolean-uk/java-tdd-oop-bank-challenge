package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public boolean createCurrentAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)){
                return false;
            }

        }
        accounts.add(new CurrentAccount(accountNumber,0));
        return true;
    }

    public boolean createSavingAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)){
                return false;
            }
        }
        accounts.add(new SavingAccount(accountNumber,0));
        return true;
    }




}
