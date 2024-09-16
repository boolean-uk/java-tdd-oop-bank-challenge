package com.booleanuk.extension;

public class Branch {

    String address;
    String branchName;

    public Branch(String address, String branchName) {
        this.address = address;
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public String getBranchName() {
        return branchName;
    }
}
