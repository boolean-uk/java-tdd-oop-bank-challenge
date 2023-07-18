package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class transactionTest {
    @Test
    public void assertTransactionIsCreated() {
        Transaction transaction = new Transaction(100, "01/01/2021", TransactionType.CREDIT, 100);
        Assertions.assertEquals(100, transaction.balanceAfter());
        Assertions.assertEquals("01/01/2021", transaction.transactionDate());
        Assertions.assertEquals(TransactionType.CREDIT, transaction.type());
        Assertions.assertEquals(100, transaction.amount());
    }

    @Test
    public void assertTransactionWithNegativeBalanceThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(-100, "01/01/2021", TransactionType.CREDIT, 100);
        });
    }

    @Test
    public void assertTransactionWithInvalidDateThrows1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(100, "01/01/21", TransactionType.CREDIT, 100);
        });
    }

    @Test
    public void assertTransactionWithInvalidDateThrows2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(100, "01/101/2021", TransactionType.CREDIT, 100);
        });
    }

    @Test
    public void assertTransactionWithInvalidDateThrows3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(100, "01/01/2a21", TransactionType.CREDIT, 100);
        });
    }

    @Test
    public void assertTransactionWithInvalidDateThrows4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(100, "01-01-2021", TransactionType.CREDIT, 100);
        });
    }

    @Test
    public void assertTransactionWithInvalidDateThrows5() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(100, "01/01/2021/01", TransactionType.CREDIT, 100);
        });
    }

    @Test
    public void assertTransactionWithInvalidAmmountThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(100, "01/01/2021", TransactionType.CREDIT, -100);
        });
    }

}
