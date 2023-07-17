package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.ProxySelector;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

public class AccountTest {

    @Test
    public void addDepositCheckingAccountTest(){
        Account account = new Account("1111", 100.0, "Checking");
        account.formerDeposit(100, LocalDate.of(2000, 12, 2));
        Assertions.assertEquals(200, account.getBalance());
    }

    @Test
    public void withdrawCheckingAccountTest(){
        Account account = new Account("2222", 300.0, "Checking");
        account.withdraw(200, LocalDate.of(2000, 12, 2));
        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void withdrawFailureCheckingAccountTest(){
        Account account1 = new Account("1111", 100.0, "Checking");
        Assertions.assertFalse(account1.withdraw(150.50, LocalDate.of(2000, 12, 2)));
        Assertions.assertEquals(100, account1.getBalance());
        Assertions.assertTrue(account1.withdraw(50.5, LocalDate.of(2000, 12, 2)));
        Assertions.assertEquals(49.5, account1.getBalance());
    }

    @Test
    public void printStatementTest(){
        Account account = new Account("1111", 0.00,"Checking");
        account.formerDeposit(1000.00, LocalDate.of(2012, 1, 10));
        account.formerDeposit(2000.00, LocalDate.of(2012, 1, 13));
        account.withdraw(500.00, LocalDate.of(2012, 1, 14));
        Collections.reverse(account.transactions);
//        Collections.reverse();
        String expectedStatement = " date   ||  credit  ||  debit || balance " + "\n";
        expectedStatement += LocalDate.of(2012, 01, 14) + " ||      || " + 500.00 + " || " + 2500.00 + "\n";
        expectedStatement += LocalDate.of(2012, 01,13) + " || " + 2000.00 + " ||      || " + 3000.00 + "\n";
        expectedStatement += LocalDate.of(2012, 01,10) + " || " + 1000.00 + " ||      || " + 1000.00 + "\n";
        Assertions.assertEquals(expectedStatement, account.printStatement());
    }

}
