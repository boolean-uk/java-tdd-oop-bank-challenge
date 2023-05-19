package com.booleanuk.core;

public class Customer {
    Account account;
    String name,address, dateOfBirth;
    int taxpayerIdentificationNumber;

    //being a customer in a bank requires you provide all of the attributes in this customer class
    public Customer(String fullName, String address, String dateBirt, int taxpayerIdentificationNumber) {
        this.name = fullName;
        this.address = address;
        dateOfBirth = dateBirt;
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }
    //as a customer, you can use setUpAccount to create a new account under your name using the methods below.
    public void setUpAccount(Balance balance){
        System.out.println("Setting up account....");
        account = new Account(balance);
    }
    public void setUpAccount(int intPart, int decimalPart){
        System.out.println("Setting up account....");
        account = new Account(intPart,decimalPart);
    }

}
