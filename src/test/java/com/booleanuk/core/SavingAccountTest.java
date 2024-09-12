package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount("John", "Adams");
    }

    @Test
    public void depositTest() {
        account.deposit(300);
        Assertions.assertEquals(account.getCurrentBalance(), 300);
    }

    @Test
    public void withdrawTest() {
        account.deposit(300);
        account.withdraw(200);
        Assertions.assertEquals(account.getCurrentBalance(), 100);
    }
}
