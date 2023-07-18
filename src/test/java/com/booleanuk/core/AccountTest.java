package com.booleanuk.core;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class AccountTest {
    Account account = new CurrentAccount("Kinga", "Hernet");

    @Test
    void depositTestShouldFail() {
        Assertions.assertFalse(account, deposit(0));
        Assertions.assertFalse(account, deposit(-100.0));
        Assertions.assertFalse(account.activated);
    }

    @Test
    void depositTestShouldSucceed() {
        Assertions.assertTrue(account, deposit(100.5));
        Assertions.assertTrue(10050, account.getCurrentBalance());
        Assertions.assertTrue(account.activated);
    }

    @Test
    void depositTestBalance() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Assertions.assertEquals(formatter.format(date), account.dateHistory.get(0));

        Assertions.assertEquals(100.5, account.balanceMoveHistory.get(0));

        // 100.5 equals 10050 cents
        Assertions.assertEquals(10050, account.balanceHistory.get(0));
    }

    @Test
    void withdrawTest() {
        account.deposit(100.5);

        Assertions.assertFalse(account.withdraw(101.1));
        Assertions.assertTrue(account.withdraw(1.5));
        Assertions.assertEquals(9900, account.getCurrentBalance());
    }

    @Test
    void withdrawTestBalance() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Assertions.assertEquals(formatter.format(date), account1.dateHistory.get(0));
        Assertions.assertEquals(100.5, account1.balanceMoveHistory.get(0));
        Assertions.assertEquals(10050, account1.balanceHistory.get(0));

        Assertions.assertEquals(formatter.format(date), account1.dateHistory.get(1));
        Assertions.assertEquals(1.5, account1.balanceMoveHistory.get(1));
        Assertions.assertEquals(9900, account1.balanceHistory.get(1));
    }

    @Test
    void doubleToInt() {
        Assertions.assertEquals(0,account1.getCurrentBalance());
        Assertions.assertTrue(account1.deposit(100.5));
        Assertions.assertEquals(10050,account1.getCurrentBalance());
    }

}
