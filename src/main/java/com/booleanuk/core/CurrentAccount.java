package com.booleanuk.core;

public class CurrentAccount extends Account {

    private Overdraft overdraft;

    public CurrentAccount(String accountName, Branches branch) {
        super(accountName, branch);
    }


    public Overdraft getOverdraft() {

        return this.overdraft;
    }

    public boolean setOverdraft(Overdraft overdraft) {

        if(this.overdraft == null) {
            this.overdraft = overdraft;
            return true;
        }
        return false;
    }
}
