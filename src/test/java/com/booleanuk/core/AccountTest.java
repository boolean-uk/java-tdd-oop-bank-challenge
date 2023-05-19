package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountTest {


    @Test
    void doubleToInt() {
        Account account1 = new CurrentAccount("Nick", "Giagk");

        Assertions.assertEquals(0,account1.getCurrentBalance());
        Assertions.assertTrue(account1.deposit(100.5));
        Assertions.assertEquals(10050,account1.getCurrentBalance());
    }

    @Test
    void depositTest() {
        Account account1 = new CurrentAccount("Nick", "Giagk");

        Assertions.assertFalse(account1.deposit(0));
        Assertions.assertFalse(account1.deposit(-100.0));
        Assertions.assertFalse(account1.activated);

        Assertions.assertTrue(account1.deposit(100.5));
        Assertions.assertEquals(10050,account1.getCurrentBalance());
        Assertions.assertTrue(account1.activated);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Assertions.assertEquals(formatter.format(date), account1.dateHistory.get(0));

        Assertions.assertEquals(100.5, account1.balanceMoveHistory.get(0));

        // 100.5 equals 10050 cents
        Assertions.assertEquals(10050, account1.balanceHistory.get(0));
    }

    @Test
    void withdrawTest() {
        Account account1 = new CurrentAccount("Nick", "Giagk");
        account1.deposit(100.5);

        Assertions.assertFalse(account1.withdraw(101.0));
        Assertions.assertTrue(account1.withdraw(1.5));

        // 99.00 equals 9900 cents
        Assertions.assertEquals(9900, account1.getCurrentBalance());


        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Assertions.assertEquals(formatter.format(date), account1.dateHistory.get(0));
        Assertions.assertEquals(100.5, account1.balanceMoveHistory.get(0));
        Assertions.assertEquals(10050, account1.balanceHistory.get(0));

        Assertions.assertEquals(formatter.format(date), account1.dateHistory.get(1));
        Assertions.assertEquals(1.5, account1.balanceMoveHistory.get(1));
        Assertions.assertEquals(9900, account1.balanceHistory.get(1));


    }
}
