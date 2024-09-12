package com.booleanuk.core;

import java.util.List;

public interface BankAccount {
    boolean printStatement();
    List<Transaction> getTransactions();
    double getBalance();
    void setBalance(double balance);
    boolean HasOverdraft();
    double getOverdraft();
    void setHasOverdraft(boolean bool);
    void setOverdraft(double overdraft);
}
