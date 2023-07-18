package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        //Main utworzony do testow Bank Statement
        Account account = new CurrentAccount(123, "abc123");
        account.deposit(2000);
        account.withdraw(500);
        account.deposit(1000);
        BankStatement.printStatement();
    }
}
