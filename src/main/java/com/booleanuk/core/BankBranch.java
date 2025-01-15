package com.booleanuk.core;

import java.util.ArrayList;

public class BankBranch {
    private Integer branchID;
    private String location;
    private ArrayList<BankAccount> listOfBankAccounts;

    public BankBranch(Integer branchID, String location, ArrayList<BankAccount> listOfBankAccounts){
        this.branchID = branchID;
        this.location = location;
        this.listOfBankAccounts = listOfBankAccounts;
    }

    public BankBranch(Integer branchID, String location){
        this.branchID = branchID;
        this.location = location;
        this.listOfBankAccounts = new ArrayList<BankAccount>();
    }
}
