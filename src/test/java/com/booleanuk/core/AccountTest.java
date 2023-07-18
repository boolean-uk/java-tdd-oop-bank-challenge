package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AccountTest {



    @Test
    public void createTest(){
        Customer customer = new Customer("Adilet", "Nasirov", LocalDate.of(2001, 02, 19));
        Account account = new Account(AccountType.DEBIT, customer, LocalDate.now(), 0);
        Assertions.assertEquals("Account has been created", account.create());
        Assertions.assertEquals(account.deposit(1000), "Your balance after update: 1000.0");
    }

    @Test
    public void depositTest(){
        Customer customer = new Customer("Adilet", "Nasirov", LocalDate.of(2001, 02, 19));
        Account account = new Account(AccountType.DEBIT, customer, LocalDate.now(), 0);
        account.create();
        Assertions.assertEquals(account.deposit(1000), "Your balance after update: 1000.0");
    }

    @Test
    public void withdrawTest(){
        Customer customer = new Customer("Adilet", "Nasirov", LocalDate.of(2001, 02, 19));
        Account account = new Account(AccountType.DEBIT, customer, LocalDate.now(), 0);
        account.create();
        account.deposit(1000);
        Assertions.assertEquals("Your balance after update: 900.0", account.withdraw(100.0));
    }

    @Test
    public void generateStatementTest(){
        Customer customer = new Customer("Adilet", "Nasirov", LocalDate.of(2001, 02, 19));
        Account account = new Account(AccountType.DEBIT, customer, LocalDate.now(), 0);
        account.create();
        account.deposit(1000);
        account.deposit(1100);
        account.withdraw(1100);
        String result = "[Transaction{date=2023-07-18, type=CREDIT, amount=1000.0, balance=1000.0}, Transaction{date=2023-07-18, type=CREDIT, amount=1100.0, balance=2100.0}, Transaction{date=2023-07-18, type=DEBIT, amount=1100.0, balance=1000.0}]";
        Assertions.assertEquals(result, account.generateStatement());
    }
}
