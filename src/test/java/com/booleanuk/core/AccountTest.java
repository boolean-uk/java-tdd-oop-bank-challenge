package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AccountTest {
    private Account account;
    @Test
    public void testGenerateInfo() {
        account = new Account(1, "Savings", 0);
        LocalDateTime dateTime1 = LocalDateTime.of(2012, 1, 10, 0, 0);
        account.generateInfo(1000, dateTime1, "debit");

        LocalDateTime dateTime2 = LocalDateTime.of(2012, 1, 13, 0, 0);
        account.generateInfo(2000, dateTime2, "debit");

        LocalDateTime dateTime3 = LocalDateTime.of(2012, 1, 14, 0, 0);
        account.generateInfo(500, dateTime3, "credit");

        Assertions.assertEquals(3, account.getInfo().size());
        Assertions.assertEquals(2500, account.getBalance());

    }
}
