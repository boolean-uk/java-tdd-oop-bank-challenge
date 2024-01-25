package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {
    @Test
    public void testTransactionList(){
        User user = new User("John", "John@example.org");
        user.createCurrentAccount();
        user.getCurrentAccount().deposit(500);
        Assertions.assertEquals(1, user.getCurrentAccount().getTransactions().size());
        user.getCurrentAccount().deposit(500);
        user.getCurrentAccount().deposit(250);
        user.getCurrentAccount().withdraw(700);
        Assertions.assertEquals(4, user.getCurrentAccount().getTransactions().size());


    }
}
