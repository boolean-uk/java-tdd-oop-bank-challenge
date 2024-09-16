package com.booleanuk.core.bank;

import com.booleanuk.core.account.BankAccount;

public interface Bank {
    String location();
    boolean requestOverdraft(BankAccount bankAccount, int amount);
    void add(BankAccount bankAccount);
}
