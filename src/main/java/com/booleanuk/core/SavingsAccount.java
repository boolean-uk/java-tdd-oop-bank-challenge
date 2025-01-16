package com.booleanuk.core;

import java.util.HashMap;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String branch, HashMap<Integer, Transaction> transactions, int accountNumber, double balance) {
        super(branch, transactions, accountNumber, balance);
    }
}
