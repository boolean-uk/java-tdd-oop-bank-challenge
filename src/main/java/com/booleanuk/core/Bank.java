package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.HashMap;

public class Bank {
    CustomerAccount customerAccount;
    StringBuilder bankID;
    HashMap<String, CustomerAccount> accounts = new HashMap<String, CustomerAccount>();



    public Bank(String bankID) {
        this.bankID = new StringBuilder(bankID);
    }

    public void addAccount(String name, CustomerAccount customerAccount) {
        accounts.put(name,customerAccount);
    }

    public static void main(String[] args) {
        Bank bank = new Bank("Test Bank");
        bank.addAccount("Michał Siek", new CustomerAccount(AccountType.CURRENT));

        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(100),true);
        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(400),true);
        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(200),false);
        bank.accounts.get("Michał Siek").transaction(BigDecimal.valueOf(500),false);

        System.out.println(bank.accounts.get("Michał Siek").printStatement());

    }
}