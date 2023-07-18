package com.booleanuk.core;

import java.util.ArrayList;

public class AccountManager {


    private ArrayList<Account> accounts;

    public AccountManager() {
      accounts = new ArrayList<>();
    }

    public Account createAccount(Client client) {
        Account account = new Account(client);
        accounts.add(account);
        return account;
    }

    public SavingAccount createSavingAccount(Client client) {
        SavingAccount savingAccount = new SavingAccount(client);
        accounts.add(savingAccount);
        return savingAccount;
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
