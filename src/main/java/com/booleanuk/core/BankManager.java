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



}
