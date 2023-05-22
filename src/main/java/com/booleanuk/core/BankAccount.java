package com.booleanuk.core;

import java.util.List;

public interface BankAccount {
    List<Transaction> getTransactions();
    double getBalance();
    void setBalance(double balance);
    void makeTransaction(Transaction transaction);
    boolean printStatement();
}
