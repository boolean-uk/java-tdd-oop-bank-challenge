package com.booleanuk.extension;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    Bank bank = new Bank();
    Account accNotExist = new CurrentAccount("I do not", "Exist in db");

    @Test
    void createAccountTest() {
        Assertions.assertTrue(bank.createAccount("Nick", "Giagk"));
        Assertions.assertEquals("Nick", bank.accounts.get(0).firstname);
        Assertions.assertEquals("Giagk", bank.accounts.get(0).lastname);

        Assertions.assertFalse(bank.createAccount("Nick", "Giagk"));
        Assertions.assertEquals(CurrentAccount.class, bank.accounts.get(0).getClass());

        Assertions.assertTrue(bank.createAccount("Nick", "Giagk", "savings"));
        Assertions.assertFalse(bank.createAccount("Nick", "Giagk", "savings"));
        Assertions.assertEquals(SavingAccount.class, bank.accounts.get(1).getClass());


    }

    @Test
    void printStatement() {

        Assertions.assertFalse(bank.printStatement(accNotExist));


        Assertions.assertTrue(bank.createAccount("Nick", "Giagk"));
        Account nick = bank.accounts.get(0);
        Assertions.assertFalse(bank.printStatement(nick));

        nick.deposit(1500.5);
        System.out.println();
        System.out.println();

//        Assertions.assertTrue(nick.activated);
//
//        Assertions.assertTrue(bank.printStatement(nick));

        nick.withdraw(500.5);
        nick.deposit(200.0);
        Assertions.assertTrue(bank.printStatement(nick));

        System.out.println();


    }
}
