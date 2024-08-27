package com.booleanuk.core;

public class Manager {
    Branch branch;

    public Manager(Branch branch){
        this.branch = branch;

    }

    public void approveOverdraftRequest(CurrentAccount account){
        if (account.getOverdraftRequestPending() && account.getBranch() == this.branch){
            account.setCanOverdraft(true);
            account.setOverdraftRequestPending(false);
        }
    }

    public void denyOverdraftRequest(CurrentAccount account ){
        if (account.getOverdraftRequestPending() && account.getBranch() == this.branch){
            account.setCanOverdraft(false);
            account.setOverdraftRequestPending(false);
        }
    }
}
