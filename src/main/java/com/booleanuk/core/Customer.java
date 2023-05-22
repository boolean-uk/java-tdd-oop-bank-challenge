package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Account> accounts;
    private  String fullName;
    private String gender;
    private String address;
    private String dateOfBirth = new String();

    private int identificationNumber;

    public Customer(String fullName, String address, String dateBirth, int identificationNumber){
        this. fullName = fullName;
        this.address = address;
        this.dateOfBirth = dateBirth;
        this.identificationNumber = identificationNumber;
        this.accounts = new ArrayList<>();
    }

    public String getName(){
        return this.fullName;
    }

    public String address(){
        return this.address;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public int getIdentificationNumber(){
        return this.identificationNumber;
    }

    public void setUpCurrentAccount(){
        System.out.println("Setting up account!");
        CurrentAccount newCurrentAccount = new CurrentAccount();
    }

    public void setUpSavingsAccount(){
        System.out.println("Setting up savings account!");
        SavingsAccount newSavingsAccount = new SavingsAccount();
    }






}
