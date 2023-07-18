package com.booleanuk.core;

import java.util.ArrayList;

public class AccountManager {


    private ArrayList<Account> accounts;

    public AccountManager() {
      accounts = new ArrayList<>();
    }

    public Account createAccount(Client client1) {
        Account account = new Account(client1);
        accounts.add(account);
        return account;
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
