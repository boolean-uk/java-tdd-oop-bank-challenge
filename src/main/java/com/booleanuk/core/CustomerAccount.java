package com.booleanuk.core;

public class CustomerAccount {

    private String accountNum;
    private String name;
    private String branchNum;

    public CustomerAccount(String accountNum, String name, String branchNum){
        this.setAccountNum(accountNum);
        this.setName(name);
        this.setBranchNum(branchNum);
    }

    public String getBranchNum(){
        return branchNum;
    }
    public void setBranchNum(String branchNum) {
        this.branchNum = branchNum;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNum(){
        return accountNum;
    }
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
}
