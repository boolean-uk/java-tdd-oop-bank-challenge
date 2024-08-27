package com.booleanuk.core;

import java.util.ArrayList;

public class AccountOwner {

    private String bankName;
    private String name;
    private ArrayList<String> accounts;

    AccountOwner(String name){
        this.bankName = "Boolean Bank";
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    protected String getname(){
        return this.name;
    }









}
