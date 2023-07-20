package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
public class BankStatementTest {

    @Test
    public void testGenerateStatement() throws Exception {
        //3. As a customer,
        //So I can keep a record of my finances,
        //I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        BankStatement bankStatement = new BankStatement("1", "123456789");

        Date date1 = sdf.parse("10/01/2012");
        Date date2 = sdf.parse("13/01/2012");
        Date date3 = sdf.parse("14/01/2012");

        Transaction transaction1 = new Transaction("1", date1, 1000.00);
        Transaction transaction2 = new Transaction("2", date2, 2000.00);
        Transaction transaction3 = new Transaction("3", date3, -500.00);

        bankStatement.addTransaction(transaction1);
        bankStatement.addTransaction(transaction2);
        bankStatement.addTransaction(transaction3);
        bankStatement.generateStatement(sdf);
    }
}
