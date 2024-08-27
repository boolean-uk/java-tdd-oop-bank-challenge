package com.booleanuk.core;

public class Manager {

    public Manager(){

    }

    // account.getClass()== SavingsAccount.class
    public void approveOverdraftRequest(CurrentAccount account){
        if (account.getOverdraftRequestPending() ){
            account.setCanOverdraft(true);
            account.setOverdraftRequestPending(false);
        }
    }

    public void denyOverdraftRequest(CurrentAccount account){
        if (account.getOverdraftRequestPending()){
            account.setCanOverdraft(false);
            account.setOverdraftRequestPending(false);
        }
    }
}
