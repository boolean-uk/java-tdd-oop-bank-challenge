package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accountsList = new ArrayList<>();


    public void createCurrentAccount(String branch){
        Account account = new Account("Current", branch );
        this.accountsList.add(account);
    }
    public void createSavingsAccount(String branch){
        Account account = new Account("Saving", branch );
        this.accountsList.add(account);

    }
    public ArrayList<Account> getAccountList() {
        return this.accountsList;
    }


}
