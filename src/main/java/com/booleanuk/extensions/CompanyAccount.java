package com.booleanuk.extensions;

import java.util.ArrayList;
import java.util.List;

public class CompanyAccount extends Account {
    List<BranchAccount> branchAccounts;

    public CompanyAccount() {
        super();
        branchAccounts = new ArrayList<>();
    }

    public List<BranchAccount> getBranchAccounts() {
        return branchAccounts;
    }

    public String createBranchAccount(String branch) {
        if (branchAccounts.stream().anyMatch(e -> e.getBranch().equals(branch))) {
            return "A branch account in " + branch + " exists.";
        } else {
            BranchAccount branchAccount = new BranchAccount(branch);
            branchAccounts.add(branchAccount);
            return "A branch account in " + branch + " was created.";
        }
    }

    public float getBalanceFromAllBranches() {
        float balance = 0;
        for(BranchAccount branchAccount: branchAccounts){
            balance += branchAccount.countTheBalance();
        }
        return balance;
    }
}
