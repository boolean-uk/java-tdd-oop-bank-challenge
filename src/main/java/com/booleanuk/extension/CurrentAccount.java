package com.booleanuk.extension;

public class CurrentAccount extends Account {
    private double overDraftLimit;
    public CurrentAccount(Branch branch) {
        super(branch);
        this.overDraftLimit = 0;
    }

    boolean setOverDraftLimit(double limit){
        if (limit < 0){
            return false;
        }
        this.overDraftLimit = limit;
        return true;
    }

    @Override
    public boolean remove(double amount){
        if (amount > this.getBalance() + this.overDraftLimit){
            return false;
        }
        this.getTransactions().add(new Transaction(-amount, this.getBalance()));
        //this.setBalance(this.getBalance() - amount);
        return true;
    }
}
