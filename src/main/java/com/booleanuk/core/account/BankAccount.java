package com.booleanuk.core.account;

import com.booleanuk.core.bank.Bank;

public interface BankAccount {
    double deposit(double amount);
    double withdraw(double amount);
    String statement();
    boolean deserveOverdraft(double maxDebt);
    void associateTo(Bank bank);
    Bank branch();
}
