package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerTest {

    @Test
    void shouldCreateCreditTrue() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("John"));
    }

    @Test
    void shouldCreateCreditFalse() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("John"));

        Assertions.assertFalse(customer.createCredit("John"));
    }

    @Test
    void shouldCreateCreditAndSavings() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("John"));
        Assertions.assertTrue(customer.createSavings("John"));
    }

    @Test
    void shouldDepositWithdrawFromCredit() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("John"));
        Assertions.assertTrue(customer.createSavings("Panos"));

        Assertions.assertTrue(customer.deposit(customer.getCredit("John"), 100));
        Assertions.assertEquals(100, customer.getCredit("John").getBalance());
        Assertions.assertEquals(0, customer.getSavings("Panos").getBalance());
    }

    @Test
    void shouldPrintStatements() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("John"));
        CustomerAccount credit = customer.getCredit("John");
        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.withdraw(credit, 50));

        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.withdraw(credit, 50));
        String dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        String answer = "date || credit  || debit  || balance\n" +
                dateString + "||0.0||50.0||200.0\n" +
                dateString + "||100.0||0.0||250.0\n" +
                dateString + "||0.0||50.0||150.0\n" +
                dateString + "||100.0||0.0||200.0\n" +
                dateString + "||100.0||0.0||100.0";
        Assertions.assertEquals(answer, customer.printStatements(credit));
    }
}
