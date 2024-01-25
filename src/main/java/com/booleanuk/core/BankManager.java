package com.booleanuk.core;

import java.util.ArrayList;

public class BankManager {


    private ArrayList<Overdraft> overdraftRequests;


    public BankManager() {
        this.overdraftRequests = new ArrayList<>();
    }


    public ArrayList<Overdraft> getOverdraftRequests() {
        return overdraftRequests;
    }


    public boolean approveOverdraft(Overdraft overdraft) {
        overdraft.setLookedAt(true);
        overdraft.setApproved(true);
        return true;
    }

    public boolean rejectOverdraft(Overdraft overdraft) {
        overdraft.setApproved(false);
        overdraft.setLookedAt(true);
        return true;
    }

    public boolean addOverDraft(Overdraft overdraft) {
        this.overdraftRequests.add(overdraft);
        return true;
    }

    public boolean removeOverdraft(Overdraft overdraft) {
        if(this.overdraftRequests.contains(overdraft)) {
            this.overdraftRequests.remove(overdraft);
            return true;
        }

        return false;

    }
}
