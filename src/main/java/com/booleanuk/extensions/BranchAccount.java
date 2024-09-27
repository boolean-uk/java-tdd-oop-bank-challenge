package com.booleanuk.extensions;

public class BranchAccount extends Account{
    String branch;

    public BranchAccount(String branch) {
        super();
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }
}
