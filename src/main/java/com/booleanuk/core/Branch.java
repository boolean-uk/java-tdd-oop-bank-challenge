package com.booleanuk.core;

import java.util.ArrayList;

public class Branch {
    private String address;

    private int identificationNumber, numberOfEmployees;
    ArrayList<Account> accounts;
    public Branch(String address, int identificationNumber, int numberOfEmployees){
        this.address = address;
        this.identificationNumber = identificationNumber;
        this.numberOfEmployees = numberOfEmployees;
    }
    public Branch(int identificationNumber) {
        BranchList mustBeThere = new BranchList();
        this.accounts = new ArrayList<>();
        for(Branch branch: mustBeThere.availableBranches){
            if(identificationNumber == branch.getIdentificationNumber()){
                this.address = branch.getAddress();
                this.numberOfEmployees = branch.getNumberOfEmployees();
                this.identificationNumber = identificationNumber;
                return;
            }
        }
        System.out.println("Branch given is not an actual Bank Branch");
    }
    public String getAddress() {
        return address;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
