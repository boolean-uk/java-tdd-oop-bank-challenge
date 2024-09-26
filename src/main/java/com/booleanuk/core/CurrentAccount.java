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
        this.overdraft = overdraft;
        return true;
    }

    @Override
    public boolean withdraw(double v) {
        if(this.overdraft != null) {
            System.out.println(this.overdraft.getAmount());
            if(this.overdraft.isApproved()) {
                if(v <= this.getBalance() + this.overdraft.getAmount()) {
                    this.addBankStatement(new WithdrawStatement(v, this.getBalance()-v));
                    return true;
                }
            }
        }


        if(v <= this.getBalance()) {

            this.addBankStatement(new WithdrawStatement(v, this.getBalance()-v));
            return true;
        }


        return false;
    }


}
