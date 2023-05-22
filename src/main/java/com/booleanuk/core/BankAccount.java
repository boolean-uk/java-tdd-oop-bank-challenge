package com.booleanuk.core;

import java.util.List;

public interface BankAccount {
    List<Transaction> getTransactions();
    double getBalance();
    void makeTransaction(Transaction transaction);
}
