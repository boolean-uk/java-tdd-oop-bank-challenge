package com.booleanuk.core;

public class Main {
    public static void main (String[]args) {
       BankAccount bankAccount = new BankAccount(1000);
        System.out.println("Balance: " + bankAccount.getBalance());
        bankAccount.deposit(1000);
        System.out.println("Balance: " + bankAccount.getBalance());
        bankAccount.withdraw(500);
        System.out.println("Balance: " + bankAccount.getBalance());
        System.out.println();

    }
}
