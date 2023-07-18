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
}