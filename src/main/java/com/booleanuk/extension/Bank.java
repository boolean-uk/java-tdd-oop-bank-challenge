package com.booleanuk.extension;

import java.util.HashMap;

public class Bank {
    private HashMap<Integer, Branch> branches = new HashMap<>();
    private int nextBranchId = 1000;

    Branch newBranch() {
        Branch branch = new Branch(nextBranchId);
        branches.put(nextBranchId, branch);
        nextBranchId++;

        return branch;
    }

    HashMap<Integer, Branch> getBranches() {
        return branches;
    }
}
