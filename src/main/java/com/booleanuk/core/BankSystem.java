package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankSystem {
    private List<OverdraftRequest> overdraftRequests;
    private Map<String, SavingsAccount> savingsAccounts;
    private Map<String, CurrentAccount> currentAccounts;

    public BankSystem() {
        overdraftRequests = new ArrayList<>();
        savingsAccounts = new HashMap<>();
        currentAccounts = new HashMap<>();
    }

    // maybe void?
    public boolean approve(OverdraftRequest or) {
        return savingsAccounts.get(or.accountNumber + or.branchNumber).setMaxOverdraft(or.getAmount());
    }

    public void addCurrentAccount(CurrentAccount b) {
        currentAccounts.put(b.getAccountNumber() + b.getBranchNumber(), b);
    }

    public void addSavingsAccount(SavingsAccount b) {
        savingsAccounts.put(b.getAccountNumber() + b.getBranchNumber(), b);
    }

    public Map<String, BankAccount> getBankAccounts() {
        Map<String, BankAccount> bankAccounts = new HashMap<>(currentAccounts);
        bankAccounts.putAll(savingsAccounts);
        return bankAccounts;
    }

    public List<OverdraftRequest> getOverdraftRequests() {
        return overdraftRequests;
    }
}
