package com.booleanuk.core;

import com.booleanuk.core.enums.AccountType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Bank {
    private final List<Branch> branches;
    private final AtomicInteger accountNumberCounter;
    private final AtomicInteger branchNumberCounter;

    public Bank() {
        this.branches = new ArrayList<>();
        this.accountNumberCounter = new AtomicInteger(480_00000);
        this.branchNumberCounter = new AtomicInteger(803_000);
    }

    private int generateAccountNumber() {
        return accountNumberCounter.getAndIncrement();
    }

    private int generateBranchNumber() {
        return accountNumberCounter.getAndIncrement();
    }

    public Branch getBranchByNumber(int branchNum) {
        for (Branch branch : branches) {
            if (branch.getBranchNumber() == (branchNum)) {
                return branch;
            }
        }
        System.out.println("Account [" + branchNum + "] not found");
        return null;
    }

    public int createAccount(Branch branch, AccountType accountType) {
        return branch.addNewAccount(accountType, generateAccountNumber());
    }

    public Branch getBranchByAccountNumber(int accountNumber) {
        for (Branch branch : branches) {
            if (branch.getAccountByAccountNumber(accountNumber) != null) {
                return branch;
            }
        }
        return null;
    }

    public int createBranch() {
        int branchNum = generateBranchNumber();
        Branch branch = new Branch(branchNum);
        // Could pass in bank/branch name in both class constructors if there needs to be a class variable name
        branches.add(branch);
        return branchNum;
    }
}
