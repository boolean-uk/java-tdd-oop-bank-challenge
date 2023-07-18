package com.booleanuk.core;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        BankStatement bankStatement = new BankStatement();

        Account currentAccount = new CurrentAccount();
        currentAccount.deposit(new BigDecimal("1000"));
        currentAccount.deposit(new BigDecimal("2000"));
        currentAccount.withdraw(new BigDecimal("500"));

        Account savingsAccount = new SavingsAccount();
        savingsAccount.deposit(new BigDecimal("5000"));
        savingsAccount.deposit(new BigDecimal("1000"));

        System.out.println("Current Account Statement");
        bankStatement.printStatement(currentAccount);

        System.out.println("\nSavings Account Statement");
        bankStatement.printStatement(savingsAccount);

    }
}
