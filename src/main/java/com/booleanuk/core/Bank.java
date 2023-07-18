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

    public enum ErrorType {
        ACCOUNT_EXISTS("Account Already Exists"),
        CUSTOMER_NOT_EXISTS("Customer Does Not Exist");

        public final String value;
        ErrorType(String value) {
            this.value = value;
        }
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

}
