package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerTest {

    @Test
    void shouldCreateCreditTrue() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit());
    }

    @Test
    void shouldCreateCreditFalse() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit());

        Assertions.assertFalse(customer.createCredit());
    }

    @Test
    void shouldCreateCreditAndSavings() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit());
        Assertions.assertTrue(customer.createSavings());
    }

    @Test
    void shouldDepositWithdrawFromCredit() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit());
        Assertions.assertTrue(customer.deposit(customer.getCredit(), 100));
        Assertions.assertEquals(100, customer.getCredit().getBalance());
    }

    @Test
    void shouldPrintStatements() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit());
        Assertions.assertTrue(customer.deposit(customer.getCredit(), 100));
        Assertions.assertTrue(customer.deposit(customer.getCredit(), 100));
        Assertions.assertTrue(customer.withdraw(customer.getCredit(), 50));

        Assertions.assertTrue(customer.deposit(customer.getCredit(), 100));
        Assertions.assertTrue(customer.withdraw(customer.getCredit(), 50));
        customer.printStatements(customer.getCredit());
        String dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        String answer = "date || credit  || debit  || balance\n" +
                dateString + "||0.0||50.0||200.0\n" +
                dateString + "||100.0||0.0||250.0\n" +
                dateString + "||0.0||50.0||150.0\n" +
                dateString + "||100.0||0.0||200.0\n" +
                dateString + "||100.0||0.0||100.0";
        Assertions.assertEquals(answer, customer.printStatements(customer.getCredit()));
    }
}
