package com.booleanuk.core;

import java.util.*;

public class Bank {

    public enum AccountType {
        CURRENT,
        SAVINGS
    }

    public enum OverdraftStatus {
        NON_APPLICABLE,
        NONE,
        PENDING,
        ACCEPTED,
        REJECTED
    }

    private final Map<String, Branch> branches;
    private String name;

    public Bank(String name){
        this.name = name;
        this.branches = new HashMap<>();
    }

    public Map<String, Branch> getBranches(){return branches;}
    public String getName(){return name;}


    public Branch createBranch(String branchName){
        if(branches.containsKey(branchName)) return null;

        Branch branch = new Branch(branchName);
        branches.put(branchName, branch);
        return branch;
    }
    public int createAccount(String branch, AccountType accountType, double initialBalance) {
        Account newAccount = AccountType.CURRENT.equals(accountType) ?
                new CurrentAccount(branch, initialBalance) :
                new SavingsAccount(branch, initialBalance);
        branches.put(newAccount.getId(), newAccount);

        return newAccount.getId();
    }

    public boolean requestOverdraft(int accountId){
        if(!branches.containsKey(accountId)) return false;
        if(branches.get(accountId).getOverdraftStatus().equals(OverdraftStatus.NON_APPLICABLE)) return false;
        if(branches.get(accountId).getOverdraftStatus().equals(OverdraftStatus.PENDING)) return false;

        branches.get(accountId).setOverdraftStatus(OverdraftStatus.PENDING);
        return true;
    }

    public void evaluateOverdraftRequest(int accountId, OverdraftStatus updatedStatus){
        if(updatedStatus.equals(OverdraftStatus.PENDING)) return;
        if(!getBranches().containsKey(accountId)) return;
        if(!getBranches().get(accountId).getOverdraftStatus().equals(OverdraftStatus.PENDING)) return;

        getBranches().get(accountId).setOverdraftStatus(updatedStatus);

    }

}
