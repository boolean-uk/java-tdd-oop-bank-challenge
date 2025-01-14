package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void testCalculateBalance() {
        Account a = new CurrentAccount("1", "0000", "01");
        Account b = new CurrentAccount("1", "0000", "02");
        Controller.depositables.put("02", b);
        Transaction t1 = new Transaction(LocalDateTime.now().minusDays(10), "-1", "01", 10000);
        Transaction t2 = new Transaction(LocalDateTime.now().minusDays(6), "-1", "01", 5000);
        Transaction t3 = new Transaction(LocalDateTime.now().plusDays(1), "01", "02", 3000);
        a.deposit(t1);
        a.deposit(t2);
        a.deposit(t3);
        b.deposit(t3);
        Assertions.assertEquals(15000, a.calculateBalance());
        Assertions.assertEquals(0, b.calculateBalance());
        Assertions.assertEquals(12000, a.calculateBalance(3));
        Assertions.assertEquals(3000, b.calculateBalance(3));
    }
}