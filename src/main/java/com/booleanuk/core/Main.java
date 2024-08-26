package com.booleanuk.core;

public class Main {
    public static void main(String[] args){
        Customer c = new Customer();
        c.createAccount(Customer.AccountType.CURRENT, new Branch("Oslo"));

        Account account = c.getAccounts().getFirst();

        int deposit = 20;

        int withdraw = 15;

        account.deposit(deposit);
        account.withdraw(withdraw);
        account.generateBankStatement();
    }
}
