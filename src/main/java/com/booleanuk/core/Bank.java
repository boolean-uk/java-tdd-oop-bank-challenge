package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<>();

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public int getSizeOfBranch () {
        return branches.size();
    }
    public ArrayList<Branch> getBranch() {
        return this.branches;
    }
}
