package com.booleanuk.core;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0, "Debit");
        Account account = new Account("Saving Account", 0,transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);
        //outContent.reset();
        //System.setOut(new PrintStream(outContent));
        // Assuming the first account number starts at 0
        int accountNumberForDeposit = 0;
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.printBankStatement(customer.id,accountNumberForDeposit);

    }
}
