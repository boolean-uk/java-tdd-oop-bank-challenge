package com.booleanuk.core;

import java.util.HashMap;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(HashMap<Integer, Transaction> transactions, int accountNumber, double balance) {
        super(transactions, accountNumber, balance);
    }
}
