package com.booleanuk.extensions;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private final int branchId;
    private final String branchName;
    private final List<Account> accounts;

    public Branch(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.accounts = new ArrayList<>();
    }

    public int getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
