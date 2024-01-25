package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        Transaction t = new Transaction(100, 100);
        System.out.println(t.getDateTimeString());

        User user = new User(123456, "UserName");
        System.out.println(user.createAccount("Current"));
        System.out.println(user.getAccounts().get(0).getClass());

        user.createAccount("Savings");
        System.out.println(user.getAccounts().get(1).getClass());
    }
}
