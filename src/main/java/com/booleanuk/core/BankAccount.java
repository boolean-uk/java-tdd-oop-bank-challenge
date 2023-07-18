package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private List<Transaction> transactionHistory;
    private Branch branch;
    public BankAccount(String accountNumber,Branch branch) {
        this.accountNumber = accountNumber;
        this.transactionHistory = new ArrayList<>();
        this.branch = branch;
        branch.addAccount(this);
    }

    public Branch getBranch() {
        return branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }



}
