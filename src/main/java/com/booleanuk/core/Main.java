package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        User user = new User(123456, "UserName");

        user.createAccount("Current");

        Account account = user.getAccounts().get(0);

        account.deposit(100.00);
        account.withdraw(20.00);
        System.out.println(account.getBankStatement());
    }
}
