package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Account> accounts;
    private  String fullName;
    private String gender;
    private String address;
    private String dateOfBirth = new String();

    private int identificationNumber;

    public Customer(String fullName, String gender, String address, String dateBirth, int identificationNumber){
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateBirth;
        this.identificationNumber = identificationNumber;
        this.accounts = new ArrayList<>();
    }

    public String getName(){
        return this.fullName;
    }

    public String getGender(){
        return this.gender;
    }

    public String getAddress(){
        return this.address;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public int getIdentificationNumber(){
        return this.identificationNumber;
    }

    public void setUpCurrentAccount(String branch){
        System.out.println("Setting up account!");
        CurrentAccount newCurrentAccount = new CurrentAccount(branch);
        accounts.add(newCurrentAccount);
    }

    public void setUpSavingsAccount(String branch){
        System.out.println("Setting up savings account!");
        SavingsAccount newSavingsAccount = new SavingsAccount(branch);
        accounts.add(newSavingsAccount);
    }

}
