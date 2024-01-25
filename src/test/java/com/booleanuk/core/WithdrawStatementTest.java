package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WithdrawStatementTest {

    @Test
    public void testDepositStatementInit() {
        Date date = new Date();

        BankStatement withdrawStatement = new WithdrawStatement(date, 500, 2000);


        Assertions.assertEquals(date, withdrawStatement.getTransactionDate());
        Assertions.assertEquals(500.00, withdrawStatement.getAmount());
        Assertions.assertEquals(2000.00, withdrawStatement.getBalance());
        Assertions.assertEquals("", withdrawStatement.getStatementAsString());

    }


    @Test
    public void getStatementAsStringCorrectlyFormatted() {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.format(date);



        BankStatement withdrawStatement = new WithdrawStatement(date, 500, 2000);

        Assertions.assertEquals(sdf + " ||  500.00  ||        || 1500.00", withdrawStatement.getStatementAsString());
    }

}
