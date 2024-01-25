package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    String accountType;
    double amountSaved;
    HashMap<String,Transaction> transactionHistory;

    public Account(String accountType, double amountSaved, Transaction transaction) {
        this.accountType = accountType;
        this.amountSaved = amountSaved;
        this.transactionHistory = new HashMap<>();
        this.transactionHistory.put(accountType,transaction);
    }
}
