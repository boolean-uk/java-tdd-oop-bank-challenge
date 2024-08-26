package com.booleanuk.core;

import java.util.HashMap;

public class Branch implements Bank {
    private String name;
    private String location;
    private int branchID;
    private Manager manager;
    private HashMap<Integer, Account> savingsAccounts;
    private HashMap<Integer, Account> currentAccounts;

    public Branch(String name, String location, int branchID, Manager manager) {
        this.setName(name);
        this.setLocation(location);
        this.setBranchID(branchID);
        this.setManager(manager);
        this.setSavingsAccounts();
        this.setCurrentAccounts();
    }

    @Override
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    @Override
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public HashMap<Integer, Account> getSavingsAccounts() {
        return savingsAccounts;
    }

    public void setSavingsAccounts() {
        this.savingsAccounts = new HashMap<Integer, Account>();
    }

    public HashMap<Integer, Account> getCurrentAccounts() {
        return currentAccounts;
    }

    public void setCurrentAccounts() {
        this.currentAccounts = new HashMap<Integer, Account>();
    }
}
