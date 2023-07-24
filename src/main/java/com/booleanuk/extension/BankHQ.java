package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public class BankHQ {
    private int branchCount;
    private List<BankBranch> branches;

    public BankHQ() {
        branchCount = 0;
        branches = new ArrayList<>();
    }

    public BankBranch openBranch() {
        String branchId = String.format("%04d", ++branchCount);
        BankBranch branch = new BankBranch(branchId);
        branches.add(branch);
        return branch;
    }
}
