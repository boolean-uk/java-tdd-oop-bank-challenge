package com.booleanuk.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestAccount {
    @Test
    void testDeposit() {
        Account acc = new CurrentAccount(1);

        Assertions.assertEquals(0f, acc.getBalance());
        Transaction tran = acc.deposit(2500.50f);
        Assertions.assertEquals(2500.50f, acc.getBalance());

        // check if transaction was created correctly
        Assertions.assertTrue(tran.getTime() != null);
        Assertions.assertEquals(2500.50f, tran.getAmount());
        Assertions.assertEquals(2500.50f, tran.getBalanceAfter());
        Assertions.assertTrue(tran.getIsDeposit());
    }

    @Test
    void testInvalidDeposit() {
        Account acc = new CurrentAccount(1);

        Transaction tran = acc.deposit(-1000f);
        Assertions.assertEquals(0f, acc.getBalance());

        Assertions.assertTrue(tran == null);
    }

    @Test
    void testValidWithdraw() {
        Account acc = new CurrentAccount(1);

        Assertions.assertEquals(0f, acc.getBalance());
        acc.deposit(2500f);
        Transaction tran = acc.withdraw(1000f);
        Assertions.assertEquals(1500f, acc.getBalance());

        // check if transaction was created correctly
        Assertions.assertTrue(tran.getTime() != null);
        Assertions.assertEquals(1000f, tran.getAmount());
        Assertions.assertEquals(1500f, tran.getBalanceAfter());
        Assertions.assertFalse(tran.getIsDeposit());
    }

    @Test
    void testInvalidWithdraw() {
        Account acc = new CurrentAccount(1);

        acc.deposit(1000f);
        Transaction tran = acc.withdraw(-1000f);
        Assertions.assertTrue(tran == null);

        tran = acc.withdraw(1000.1f);
        Assertions.assertTrue(tran == null);

        Assertions.assertEquals(1000f, acc.getBalance());
    }

    @Test
    void testAccountStatement() {
        Account acc = new CurrentAccount(1);

        acc.deposit(1000f);
        acc.deposit(2000f);
        acc.withdraw(500f);

        String[] statement = acc.statement().split("\n");

        String expected = "|Date|Credit|Debit|Balance|\n"
                + "|14/01/2012||500.00|2500.00|\n"
                + "|14/01/2012|2000.00||3000.00|\n"
                + "|14/01/2012|1000.00||1000.00|\n";
        String[] expectedLines = expected.split("\n");

        Assertions.assertEquals(expectedLines.length, statement.length);

        for (int i = 0; i < statement.length; i++) {
            String line = statement[i];

            String[] cells = line.strip().split("\\|");
            String[] expectedCells = expectedLines[i].strip().split("\\|");

            Assertions.assertEquals(expectedCells.length, cells.length);

            // skip date cell
            for (int n = 0; n < cells.length; n++) {
                // if transaction line, skip date
                if (i > 0 && n <= 1) {
                    continue;
                }
                Assertions.assertEquals(expectedCells[n].strip(), cells[n].strip());
            }
        }
    }
}
