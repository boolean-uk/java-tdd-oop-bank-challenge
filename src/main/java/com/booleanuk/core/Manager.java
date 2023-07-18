package com.booleanuk.core;

//the manager is responsible for the overdrafts. So here i will add a way for the Manager to interact with the overdraft request.
public class Manager {
    private boolean canOverdraft;

    public Manager(boolean canOverdraft) {
        this.canOverdraft = canOverdraft;
    }
    public boolean getCanOverdraft(){
        return this.canOverdraft;
    }
}
