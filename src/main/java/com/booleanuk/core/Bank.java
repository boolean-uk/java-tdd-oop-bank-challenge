package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public List<Branch> getBranches() {
        return branches;
    }


}
