package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Account> accounts;
    private String name;
    private String address;
    private final String dateOfBirth;
    private int taxpayerIdentificationNumber;

    //being a customer in a bank requires you provide all of the attributes in this customer class
    //You name and your address can change legally. But you cannot change your date of birth or your assigned taxpayer number, so there are no setters for these attributes.
    public Customer(String fullName, String address, String dateBirt, int taxpayerIdentificationNumber) {
        this.name = fullName;
        this.address = address;
        dateOfBirth = dateBirt;
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        this.accounts = new ArrayList<>();
    }
    //as a customer, you can use setUpAccount to create a new account under your name using the methods below.
    public void setUpCurrentAccount(Branch branch,Balance balance){
        System.out.println("Setting up account....");
        Account add = new CurrentAccount(balance);
        this.accounts.add(add);
        branch.getAccounts().add(add);
        this.removeNullAccounts();
    }
    public void setUpCurrentAccount(Branch branch,int intPart, int decimalPart){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        setUpCurrentAccount(branch,new Balance(intPart,decimalPart));

    }
    public void setUpSavingsAccount(Branch branch, Balance balance){
        System.out.println("Setting up account....");
        Account add = new SavingsAccount(balance);
        this.accounts.add(add);
        branch.getAccounts().add(add);
        this.removeNullAccounts();
    }
    public void setUpSavingsAccount(int intPart, int decimalPart, Branch branch){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        setUpSavingsAccount(branch,new Balance(intPart, decimalPart));

    }
    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getTaxpayerIdentificationNumber() {
        return taxpayerIdentificationNumber;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void removeNullAccounts(){
        for(int i=0;i<this.accounts.size();i++){
            if(this.accounts.get(i).getBalance()==null){
                this.accounts.remove(i);
            }
        }
    }
}
