package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementTest {

    CurrentAccount myAccount = new CurrentAccount("C123456789", 0);

    @Test
    public void testAddStatement() {

        myAccount.deposit(1000);

        Assertions.assertEquals(1, myAccount.getStatement().getTransactions().size());
    }

    @Test
    public void testAddStatements() {

        myAccount.deposit(1000);
        myAccount.deposit(1000);
        myAccount.deposit(1000);

        myAccount.withdraw(390);

        Assertions.assertEquals(4, myAccount.getStatement().getTransactions().size());
    }

    @Test
    public void testPrintStatement() {

        myAccount.setBalance(0);

        myAccount.deposit(1000);

        myAccount.withdraw(390);

        myAccount.setOverdraftLimit(1000);

        myAccount.withdraw(1000);

        myAccount.deposit(780);

        myAccount.deposit(200);

        System.out.println(myAccount.getStatement().generateStatement());

        Assertions.assertEquals(5, myAccount.getStatement().getTransactions().size());
    }

}
