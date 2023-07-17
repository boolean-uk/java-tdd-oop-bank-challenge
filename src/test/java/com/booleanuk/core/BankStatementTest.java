package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BankStatementTest {
    BankStatement bankStatement = new BankStatement();
    Date date = new Date();

    @Test
    void shouldBeBalance100() {
        bankStatement.deposit(100, 0);

        Assertions.assertEquals(100.0, bankStatement.getBalance());

    }

    @Test
    void shouldBeBalance50() {
        bankStatement.deposit( 100, 0);
        bankStatement.withdraw( 50, 100);

        Assertions.assertEquals(50.0, bankStatement.getBalance());

    }

    @Test
    void shouldPrintStatement() {
        bankStatement.deposit(100, 0);
        String dateString = new SimpleDateFormat("dd/MM/yyyy").format(date);
        Assertions.assertEquals(dateString + "||100.0||0.0||100.0", bankStatement.toString());
        bankStatement.deposit(100, 100);
        Assertions.assertEquals(dateString + "||100.0||0.0||200.0", bankStatement.toString());

    }
}
