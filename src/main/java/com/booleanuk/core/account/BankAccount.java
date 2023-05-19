package com.booleanuk.core.account;

public interface BankAccount {
    double deposit(double amount);
    double withdraw(double amount);
    String statement();
}
