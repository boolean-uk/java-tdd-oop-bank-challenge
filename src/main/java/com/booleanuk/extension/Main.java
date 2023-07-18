package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        account.withdraw(200.62);
        account.deposit(99.38);
        account.deposit(200.62);
        System.out.println(account.generateStatement());
    }
}
