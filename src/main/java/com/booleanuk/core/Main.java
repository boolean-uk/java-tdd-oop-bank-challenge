package com.booleanuk.core;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Account currentAccount = new CurrentAccount("123456");
        Account savingsAccount = new SavingsAccount("987654");

        currentAccount.deposit(new BigDecimal("1000"));
        currentAccount.deposit(new BigDecimal("2000"));
        currentAccount.withdraw(new BigDecimal("500"));
        currentAccount.withdraw(new BigDecimal("100"));

        savingsAccount.deposit(new BigDecimal("5000"));
        savingsAccount.deposit(new BigDecimal("1000"));


        BankStatement bankStatement = new BankStatement();

        System.out.println("Current Account Statement:");
        bankStatement.printStatement(currentAccount);

        System.out.println("\nSavings Account Statement:");
        bankStatement.printStatement(savingsAccount);
    }
}
