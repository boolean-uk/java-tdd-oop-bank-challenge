package com.booleanuk.extensions;

import java.util.ArrayList;
import java.util.List;

public class CompanyAccount extends Account{
    List<BranchAccount> branchAccounts;

    public CompanyAccount() {
        super();
        branchAccounts = new ArrayList<>();
    }

    public List<BranchAccount> getBranchAccounts() {
        return branchAccounts;
    }
}
