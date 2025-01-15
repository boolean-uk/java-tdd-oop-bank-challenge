package com.booleanuk.core;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    public CurrentAccount(HashMap<Integer, Transaction> transactions, int accountNumber, double balance) {
        super(transactions, accountNumber, balance);
    }
}
