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

    public Account createSavingsAccount(Costumer costumer, double deposit){
        SavingsAccount savingsAccount = new SavingsAccount(generateId(), this);
        costumer.addAccount(savingsAccount);
        accounts.add(savingsAccount);


        return savingsAccount;
    }

    private String generateId() {
       return branchId + " 123";
    }

}
