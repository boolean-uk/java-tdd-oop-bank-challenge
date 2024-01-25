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
        return false;
    }

    public String generateBankStatement(){
        return " ";
    }


}

