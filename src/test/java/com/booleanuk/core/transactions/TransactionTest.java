package com.booleanuk.core.transactions;

import com.booleanuk.core.transactons.Transaction;
import com.booleanuk.core.transactons.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionTest {

    @Test
    public void createTransactionReturnsCorrectId() {
        Assertions.assertEquals("TR_1", new Transaction(2000.0, TransactionType.CREDIT, 3000.0).getId());
        Assertions.assertEquals("TR_2", new Transaction(2000.0, TransactionType.CREDIT, 3000.0).getId());
    }

    @Test
    public void getDateAndTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm");

        Assertions.assertEquals(
                localDateTime.format(formatter),
                new Transaction(10.0, TransactionType.CREDIT, 1000.0).getTransactionDate().format(formatter));
    }

    @Test
    public void getAmountTypeAndCurrentBalance() {
        Transaction transaction = new Transaction(2000.00, TransactionType.CREDIT, 3000.00);
        Assertions.assertEquals(2000.00, transaction.getAmount());
        Assertions.assertEquals(TransactionType.CREDIT, transaction.getType());
        Assertions.assertEquals(3000.00, transaction.getCurrentBalance());
    }
}
