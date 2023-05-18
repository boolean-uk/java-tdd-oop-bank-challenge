package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerTest {

    @Test
    void shouldCreateCreditTrue() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("AccountName","BankBranch"));
        Assertions.assertTrue(customer.createCredit("AccountNameOther","BankBranch"));
        Assertions.assertTrue(customer.createCredit("AccountName","BankBranchOther"));

    }

    @Test
    void shouldCreateCreditFalse() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("AccountName","BankBranch"));

        Assertions.assertFalse(customer.createCredit("AccountName","BankBranch"));
    }

    @Test
    void shouldCreateCreditAndSavings() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("AccountName","BankBranch"));
        Assertions.assertTrue(customer.createSavings("AccountName","BankBranch"));
    }

    @Test
    void shouldDepositWithdrawFromCredit() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("AccountName","BankBranch"));
        Assertions.assertTrue(customer.createSavings("AccountName","BankBranch"));

        Assertions.assertTrue(customer.deposit(customer.getCredit("AccountName","BankBranch"), 100));
        Assertions.assertEquals(100, customer.getCredit("AccountName","BankBranch").getBalance());
        Assertions.assertEquals(0, customer.getSavings("AccountName","BankBranch").getBalance());
    }

    @Test
    void shouldPrintStatements() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createCredit("AccountName","BankBranch"));
        CustomerAccount credit = customer.getCredit("AccountName","BankBranch");
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
