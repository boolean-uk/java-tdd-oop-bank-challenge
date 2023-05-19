package com.booleanuk.core;

public interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    void generateStatement();
}
