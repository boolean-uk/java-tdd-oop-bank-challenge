package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositStatementTest {

    @Test
    public void testDepositStatementInit() {
        Date date = new Date();

        BankStatement depositStatement = new DepositStatement(date, 500, 2000);


        Assertions.assertEquals(date, depositStatement.getTransactionDate());
        Assertions.assertEquals(500.00, depositStatement.getAmount());
        Assertions.assertEquals(2000.00, depositStatement.getBalance());
        Assertions.assertEquals("", depositStatement.getStatementAsString());
    }

    @Test
    public void getStatementAsStringCorrectlyFormatted() {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.format(date);



        BankStatement depositStatement = new DepositStatement(date, 500, 2000);

        Assertions.assertEquals(sdf + " ||          || 500.00 || 2500.00", depositStatement.getStatementAsString());

    }

}
