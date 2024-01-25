package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    List<Account> accountsList;

    ArrayList<Transaction> transactions = new ArrayList<>();
    public Bank() {
        this.accountsList = new ArrayList<>();

    }
    public boolean createAccount(Account account){
        if (accountsList.contains(account)) {
            System.out.println("Account already registered");
            return false;
        }
        accountsList.add(account);
        System.out.println("Account created successfully");
        return true;
    }

    public String generateBankStatement(){
        return " ";
    }


}

