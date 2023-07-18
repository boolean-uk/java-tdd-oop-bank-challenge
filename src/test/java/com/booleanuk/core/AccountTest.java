package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;
    @BeforeEach
    void setUp() {
        account = new Account("currentAccount");
    }

    @Test
    public void addTransactionTest_negativeAmount()
    {
        account.addTransaction("Date",-200);
        Assertions.assertEquals(-200,account.getCurrentBalance());
    }
    @Test
    public void addTransactionTest_possitiveAmount()
    {
        account.addTransaction("Date",200);
        Assertions.assertEquals(200,account.getCurrentBalance());
    }
}