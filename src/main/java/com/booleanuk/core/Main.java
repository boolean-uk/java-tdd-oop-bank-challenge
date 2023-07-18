package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Customer johnDoe = new Customer("0123456789", "john.doe@gmail.com", "John", "Doe");
        Customer janeDoe = new Customer("9876543210", "jane.doe@gmail.com", "Jane", "Doe");
        String mainBranchCode = "123456";
        BankAccount johnCurrentAccount = johnDoe.createAccount(AccountType.CURRENT, mainBranchCode);
        BankAccount johnSavingsAccount = johnDoe.createAccount(AccountType.SAVINGS, mainBranchCode);
        BankAccount janeCurrentAccount = janeDoe.createAccount(AccountType.CURRENT, mainBranchCode);

        System.out.println("As we can see, the bank stores information about all accounts, " +
                        "and each customer stores information about their own accounts.");
        System.out.println(bank.getAccounts());
        System.out.println(johnDoe.getAccounts());
        System.out.println(janeDoe.getAccounts());

        johnDoe.deposit(johnCurrentAccount.getAccountNumber(), 100.0d);
        johnDoe.deposit(johnSavingsAccount.getAccountNumber(), 150.0d);
        janeDoe.deposit(janeCurrentAccount.getAccountNumber(), 200.0d);

        System.out.println("After depositing money into the accounts, we can see that the " +
                "balances have been updated.");
        System.out.println(bank.getAccounts());
        System.out.println(johnDoe.getAccounts());
        System.out.println(janeDoe.getAccounts());

        johnDoe.withdraw(johnCurrentAccount.getAccountNumber(), 50.0d);
        System.out.println("After withdrawing money from the current account, we can see that " +
                "the balance has been updated for John Doe's current account.");
        johnDoe.getStatements().forEach(System.out::println);

        System.out.println("After withdrawing money from the current account, we can see that " +
                "the balance has been updated for the bank's current account.");
        bank.getStatements().forEach(System.out::println);


    }
}
