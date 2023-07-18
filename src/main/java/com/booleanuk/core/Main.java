package com.booleanuk.core;

public class Main {

    public static void main(String[] args){
        Customer customer = new Customer("hej");
        CurrentAccount currentAccount = customer.createCurrentAccount();
        currentAccount.depositFunds(13.0);
        currentAccount.depositFunds(14.0);
        currentAccount.withdrawFunds(12.0);
        currentAccount.depositFunds(14.0);
        customer.generateBankStatement();
    }
}
