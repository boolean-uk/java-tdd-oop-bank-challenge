package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.SortedMap;
import java.util.TreeMap;

public class CustomerAccount {

    private String accountNum;
    private String name;
    private String branchNum;

    private int balanceCent = 0;
    private LocalDateTime dateTime;

    private SortedMap<LocalDateTime, Integer> transaction;

    private boolean approvedOverdraft = false;
    public CustomerAccount(String accountNum, String name, String branchNum){
        this.setAccountNum(accountNum);
        this.setName(name);
        this.setBranchNum(branchNum);
        this.setTransactions(new TreeMap<>());
    }

    private void setTransactions(TreeMap<LocalDateTime, Integer> transaction) {
        this.transaction = transaction;
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


    public int getBalanceCent(){
        return balanceCent;
    }
    public void setBalanceCent(double amountToDeposit) {
        this.balanceCent += (int) (amountToDeposit * 100.0);
        this.setDateTime(LocalDateTime.now());
        this.getTransactions().put(this.getDateTime(), (int) (amountToDeposit * 100.0));
    }

    public double getBalance(){
        return (getBalanceCent() / 100.0);
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public SortedMap<LocalDateTime, Integer> getTransactions(){
        return transaction;
    }

    public boolean isApprovedOverdraft() {
        return approvedOverdraft;
    }

    public void setApprovedOverdraft(boolean approvedOverdraft){
        this.approvedOverdraft = approvedOverdraft;
    }
}
