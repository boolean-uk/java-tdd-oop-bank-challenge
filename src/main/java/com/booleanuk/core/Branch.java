package com.booleanuk.core;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Costumer> costumers = new ArrayList<>();
    String branchId;

    Branch(String branchId) {
        this.branchId = branchId;
    }

    public ArrayList<Account> getAccountsForBranch() {
        return accounts;
    }

    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public String getBranchId() {
        return branchId;
    }

    public Account createSavingsAccount(Costumer costumer, int deposit){
        SavingsAccount savingsAccount = new SavingsAccount(generateId(), this);
        savingsAccount.deposit(deposit);
        costumer.openAccount(savingsAccount);
        accounts.add(savingsAccount);
        return savingsAccount;
    }

    public Account createCurrentAccount(Costumer costumer){
        CurrentAccount currentAccount = new CurrentAccount(generateId(), this);
        costumer.openAccount(currentAccount);
        accounts.add(currentAccount);

        return currentAccount;
    }

    private String generateId() {
       return branchId + " 123";
    }

}
