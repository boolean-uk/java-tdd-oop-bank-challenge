package com.booleanuk.core.accounts;

import com.booleanuk.core.idgenerator.IdGenerator;
import com.booleanuk.core.idgenerator.IdPrefix;

public abstract class Account {

    private final String accountNumber;
    private Branch branch;
    boolean isPossibleToOverdraft;

    public Account() {
        this.accountNumber = new IdGenerator(IdPrefix.AC).getId();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public boolean isPossibleToOverdraft() {
        return isPossibleToOverdraft;
    }

    public void setPossibleToOverdraft(boolean possibleToOverdraft) {
        isPossibleToOverdraft = possibleToOverdraft;
    }
}
