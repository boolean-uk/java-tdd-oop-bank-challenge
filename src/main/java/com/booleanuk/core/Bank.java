package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private String name;
    private Integer bankID;
    private ArrayList<BankBranch> listOfBranches;

    public Bank(String name, Integer bankID, ArrayList<BankBranch> listOfBranches){
        this.name = name;
        this.bankID = bankID;
        this.listOfBranches = listOfBranches;
    }

    public Bank(String name, Integer bankID){
        this.name = name;
        this.bankID = bankID;
        this.listOfBranches = new ArrayList<BankBranch>();
    }
}
