package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public class BankBranch {

    List<Account> accounts = new ArrayList<>();

    public void add(Account account) {
        if(!accounts.contains(account))
            accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
