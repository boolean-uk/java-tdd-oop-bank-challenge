package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    String accountType;
    double amountSaved;
    HashMap<String,Transaction> transactionHistory;

    public Account(String accountType, double amountSaved) {
        this.accountType = accountType;
        this.amountSaved = amountSaved;
    }
}
