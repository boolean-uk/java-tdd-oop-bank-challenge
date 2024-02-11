package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    public void createCurrentAccount(){
        Bank bank = new Bank();
        User user = new User("1", "test");
        Account currentAccount = new Account(user, "1234", "current", 0.0);
        Assertions.assertTrue(bank.createAccount(currentAccount));
        Assertions.assertFalse(bank.createAccount(currentAccount));
    }
    @Test
    public void createSaveAccount(){
        Bank bank = new Bank();
        User user = new User("2", "test");
        Account saveAccount = new Account(user, "2345", "save", 0.0);
        Assertions.assertTrue(bank.createAccount(saveAccount));
    }

    @Test
    public void deposit(){
        User user = new User("1", "test");
        Account currentAccount = new Account(user, "1234", "current", 0.0);
        Account saveAccount = new Account(user, "2345", "save", 0.0);

        Assertions.assertEquals(6000,currentAccount.deposit(6000));
        Assertions.assertEquals(1000,saveAccount.deposit(1000));

    }
    @Test
    public void withdraw(){
        User user = new User("1", "test");
        Account currentAccount = new Account(user, "1234", "current", 2000);
        Assertions.assertEquals("Balance: " + 1000.0,currentAccount.withdraw(1000));
    }
    @Test
    public void withdrawShouldReturnMessage(){
        User user = new User("1", "test");
        Account currentAccount = new Account(user, "1234", "current", 0.0);
        Assertions.assertEquals("Your balance is low to withdraw" ,currentAccount.withdraw(1000));

    }

    @Test
    public void testGenerateBankStatement(){
        User user = new User("1", "user");
        Account account = new CurrentAccount(user,"1234", "current", 0.0);
        account.deposit(2000);
        account.deposit(4000);
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String testStatement = "date      credit    debit     balance   \n" +
                date + "    0.0       2000.0    2000.0       \n" +
                date + "   0.0       4000.0    6000.0 ";

        Assertions.assertEquals(removeSpaces(testStatement), removeSpaces(account.bank.generateBankStatement()));
    }
    //Help methods
    private static String removeSpaces(String string){
        return string.replaceAll("\\s", "");
    }

}