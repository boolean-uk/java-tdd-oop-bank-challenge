package com.booleanuk.core;

public class Manager {
    Branch branch;

    Manager(Branch branch) {
        this.branch = new Branch(branch.getBranchId());

    }
}
