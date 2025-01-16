package com.booleanuk.core;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    public CurrentAccount(String branch, HashMap<Integer, Transaction> transactions, int accountNumber, double balance) {
        super(branch, transactions, accountNumber, balance);
    }
}
