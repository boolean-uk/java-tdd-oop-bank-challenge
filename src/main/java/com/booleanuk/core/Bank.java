package com.booleanuk.core;

import java.util.HashMap;

public class Bank {
    private final HashMap<Integer, SavingsAccount> savingsAccounts;
    private final HashMap<Integer, CurrentAccount> currentAccounts;
    private int accountsCounter;

    public Bank() {
        this.savingsAccounts = new HashMap<>();
        this.currentAccounts = new HashMap<>();
        this.accountsCounter = 0;
    }

    public int openCurrentAccount(String ownerName, String branchCode){
        currentAccounts.put(accountsCounter++,new CurrentAccount(ownerName, branchCode));
        return accountsCounter;
    }

    public int openSavingsAccount(String ownerName, String branchCode){
        savingsAccounts.put(accountsCounter++,new SavingsAccount(ownerName, branchCode));
        return accountsCounter;
    }

    public Account getAccountById(int id){
        if (id>accountsCounter-1)
            return null;

        if(savingsAccounts.containsKey(id))
            return savingsAccounts.get(id);
        else
            return currentAccounts.get(id);
    }

    public HashMap<Integer, SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public HashMap<Integer, CurrentAccount> getCurrentAccounts() {
        return currentAccounts;
    }

    public OverdraftRequest checkForOverdraftRequests(int accountNumber) {
        return getAccountById(accountNumber).getRequestHistory().stream()
                .filter(request -> "unchecked".equals(request.getStatus()))
                .findAny().orElse(null);
    }

    public String approveOverdraftRequest(OverdraftRequest request) {
        request.setStatus("approved");
        return "You approved overdraft";
    }

    public String rejectOverdraftRequest(OverdraftRequest request) {
        request.setStatus("rejected");
        return "You rejected overdraft";
    }

    public String checkAccountBranch(int accountNumber){
        return getAccountById(accountNumber).getBranchCode();
    }
}
