package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();


        Customer customer = new Customer(1, "Harry", "Potter");
        bank.addCustomer(customer);

        bank.createAccount(1, "Saving Account", 500.0);
        int accountNumberForDeposit = 1;

        bank.deposit(1, accountNumberForDeposit, 100.0);
        bank.deposit(1, accountNumberForDeposit, 100.0);
        bank.deposit(1, accountNumberForDeposit, 100.0);
        bank.deposit(1, accountNumberForDeposit, 100.0);
        bank.deposit(1, accountNumberForDeposit, 100.0);

        bank.withdraw(1, accountNumberForDeposit, 100.0);

        bank.printBankStatement(1, accountNumberForDeposit);
    }
}
