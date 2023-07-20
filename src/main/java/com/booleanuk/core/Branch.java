package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchId;
    private List<Account> accounts;

    public Branch(String branchId) {
        this.branchId = branchId;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}
