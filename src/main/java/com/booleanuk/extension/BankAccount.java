package com.booleanuk.extension;

public interface BankAccount {

    boolean deposit(double amount);
    boolean withdraw(double amount);
    void generateBankStatement();

    String balanceCalculation();


}
