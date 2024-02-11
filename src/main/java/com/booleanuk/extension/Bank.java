package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public boolean createAccount(Account account){
        if (accounts.contains(account)){
            return false;
        }
        accounts.add(account);
        return true;

    }
}
