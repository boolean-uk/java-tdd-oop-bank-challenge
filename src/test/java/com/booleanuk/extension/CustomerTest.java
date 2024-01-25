package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

class CustomerTest {


    @Test
    public void testCreateAccount(){
        Customer customer = new Customer();

        //Savings
        Assertions.assertTrue(customer.createAccount("Savings", Branch.GOTHENBURG));

        //Current
        Assertions.assertTrue(customer.createAccount("Current", Branch.GOTHENBURG));

        //Something else
        Assertions.assertFalse(customer.createAccount("Something else", Branch.GOTHENBURG));

    }

    @Test
    public void testDeposit(){
        Customer customer = new Customer();
        Account account = new SavingsAccount(Branch.GOTHENBURG);

        //Positive Number
        Assertions.assertTrue(customer.deposit(account, 200));

        //Negative Number
        Assertions.assertFalse(customer.deposit(account, -200));
    }

    @Test
    public void testWithDraw(){
        Customer customer = new Customer();
        Account account = new SavingsAccount(Branch.GOTHENBURG);

        customer.deposit(account, 100);

        //Larger than balance
        Assertions.assertFalse(customer.withdraw(account, 101));

        //Negative number
        Assertions.assertFalse(customer.withdraw(account, -1));

        //Less than balance
        Assertions.assertTrue(customer.withdraw(account, 10));

    }

    @Test
    public void testGenerateBankStatement(){
        Customer customer = new Customer();
        Account account = new SavingsAccount(Branch.GOTHENBURG);
        String date = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        customer.deposit(account, 100);

        customer.withdraw(account, 12);

        customer.withdraw(account, 7.5);

        System.out.println(customer.generateBankStatement(account));

        StringBuilder test = new StringBuilder();

        test.append("| ").append(String.format("%-9s", "Date \t\t|"));
        test.append("| ").append(String.format("%-9s", "Transaction\t\t |"));
        test.append("| ").append(String.format("%-9s", "Balance |\n"));

        test.append("| ").append(String.format("%-9s",  date + "\t\t|"));
        test.append("| ").append(String.format("%-9s", "100.0 \t\t |"));
        test.append("| ").append(String.format("%-9s", "100.0  |\n"));

        test.append("| ").append(String.format("%-9s",  date + "\t\t|"));
        test.append("| ").append(String.format("%-9s", "-12.0\t\t |"));
        test.append("| ").append(String.format("%-9s", "88.0|\n"));

        test.append("| ").append(String.format("%-9s",  date + "\t\t|"));
        test.append("| ").append(String.format("%-9s", "-7.5\t\t |"));
        test.append("| ").append(String.format("%-9s", "80.5 |\n"));

        System.out.println(test);

        Assertions.assertEquals(removeSpaces(test.toString()), (removeSpaces(customer.generateBankStatement(account))));


    }

    @Test
    public void testRequestOverDraft(){
        Customer customer = new Customer();
        CurrentAccount account = new CurrentAccount(Branch.GOTHENBURG);

        //amount > 0
        Assertions.assertTrue(customer.requestOverDraft(account, 500));

        //amount < 0
        Assertions.assertFalse(customer.requestOverDraft(account, -10));


    }

    // Help methods
    private static String removeSpaces(String input) {
        // Replace all spaces in the string with an empty string
        return input.replaceAll("\\s", "");
    }




}