package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface BankAccount {

    boolean deposit(double amount);
    public boolean withdraw(double amount);
    public void generateBankStatement();


}
