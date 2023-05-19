package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CustomerTest {

    @Test
    void shouldCreateCreditTrue() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"));
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountNameOther","BankBranch"));
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranchOther"));

    }

    @Test
    void shouldCreateCreditFalse() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"));

        Assertions.assertFalse(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"));
    }

    @Test
    void shouldCreateCreditAndSavings() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"));
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.SAVINGS,"AccountName","BankBranch"));
    }

    @Test
    void shouldDepositWithdrawFromCredit() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"));
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.SAVINGS,"AccountName","BankBranch"));

        Assertions.assertTrue(customer.deposit(customer.getAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"), 100));
        Assertions.assertEquals(100, customer.getAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch").getBalance());
        Assertions.assertEquals(0, customer.getAccount(ACCOUNTTYPE.SAVINGS,"AccountName","BankBranch").getBalance());
    }

    @Test
    void shouldPrintStatements() {
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"));
        CustomerAccount credit = customer.getAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
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
        customer.printStatementsToFile(credit);
    }
    @Test
    void ShouldAppendStateMentToFIle(){
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"));
        CustomerAccount credit = customer.getAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.withdraw(credit, 50));
        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.withdraw(credit, 10));
        customer.printStatementsToFile(credit);
        try {
            File file = new File("PhoneNumberSMS.txt");
            Scanner reader = new Scanner(file);
            String[] expectedData =customer.printStatements(credit).split("\\R");
            ArrayList<String> actualData = new ArrayList<>();
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                actualData.add(data);
            }
            for (int i = 0; i < actualData.size(); i++) {
                Assertions.assertEquals(expectedData[i],actualData.get(i));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(customer.printStatements(credit).split("\\R")[0]);
    }

    @Test
    void ShouldSentMessage(){
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch"));
        CustomerAccount credit = customer.getAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.withdraw(credit, 50));
        Assertions.assertTrue(customer.deposit(credit, 100));
        Assertions.assertTrue(customer.withdraw(credit, 50));
        //customer.sentMessage(credit);
    }
}
