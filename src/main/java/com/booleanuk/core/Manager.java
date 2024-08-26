package com.booleanuk.core;

public class Manager {

    public Manager(){

    }

    public void approveOverdraftRequest(Account account){
        if (account.getOverdraftRequestPending()){
            account.setCanOverdraft(true);
            account.setOverdraftRequestPending(false);
        }
    }

    public void denyOverdraftRequest(Account account){
        if (account.getOverdraftRequestPending()){
            account.setCanOverdraft(false);
            account.setOverdraftRequestPending(false);
        }
    }
}
