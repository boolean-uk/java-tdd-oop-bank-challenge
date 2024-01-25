package com.booleanuk.extension;

public class CurrentAccount extends Account {
    double overDraftLimit;
    public CurrentAccount() {
        this.overDraftLimit = 0;
    }

    boolean setOverDraftLimit(double limit){
        return false;
    }

    @Override
    public boolean add(double amount){
        return false;
    }
}
