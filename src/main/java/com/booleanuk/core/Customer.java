package com.booleanuk.core;

public class Customer {
    private Account account;
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
    }
    //as a customer, you can use setUpAccount to create a new account under your name using the methods below.
    public void setUpAccount(Balance balance){
        System.out.println("Setting up account....");
        account = new Account(balance);
    }
    public void setUpAccount(int intPart, int decimalPart){
        System.out.println("Setting up account....");
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        account = new Account(intPart,decimalPart);

    }

    public Account getAccount() {
        return account;
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

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
