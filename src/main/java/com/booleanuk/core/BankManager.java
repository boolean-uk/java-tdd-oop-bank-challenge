package com.booleanuk.core;

import java.util.ArrayList;

public class BankManager {
    private String name;
    private int branch;
    private ArrayList<String> overdraftHistory;

    BankManager(String name){
        this.name = name;
        this.branch = 667453;
        this.overdraftHistory = new ArrayList<>();
    }

    protected int getBranch(){
        return this.branch;
    }

    public String getOverdraftRequest(CurrentAccount account){

        if(account.pendingOverdraftRequests.size() <= 0){
            return "There are no pending overdraft requests for this account.";
        }

        Overdraft request = account.pendingOverdraftRequests.get(0);

        return "Mr/Ms " + account.getOwner().getname() + " requested: " + request.getAmount() + "£ - "  + request.getMessage();
    }

    public String grantOverdraft(CurrentAccount account, double overdraftAmount){
        account.setOverdraftLimit(overdraftAmount);

        //Removed the granted overdraft.
        account.pendingOverdraftRequests.removeFirst();

        return "New overdraft limit set to: " + account.getOverdraftLimit();
    }

}
