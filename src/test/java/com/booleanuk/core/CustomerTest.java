package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {


    @Test
    public void testCreateAccount(){
        Customer customer = new Customer();

        //Savings
        Assertions.assertTrue(customer.createAccount("Savings"));

        //Current
        Assertions.assertTrue(customer.createAccount("Current"));

        //Something else
        Assertions.assertFalse(customer.createAccount("Something else"));

    }

    @Test
    public void testDeposit(){
        Customer customer = new Customer();
        Account account = new SavingsAccount();

        //Positive Number
        Assertions.assertTrue(customer.deposit(account, 200));

        //Negative Number
        Assertions.assertFalse(customer.deposit(account, -200));
    }

    @Test
    public void testWithDraw(){
        Customer customer = new Customer();
        Account account = new SavingsAccount();

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
        Account account = new SavingsAccount();
        String date = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        customer.deposit(account, 100);

        customer.withdraw(account, 12);

        customer.withdraw(account, 7.5);


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

        System.out.println(removeSpaces(customer.generateBankStatement(account)));
        System.out.println(removeSpaces(test.toString()));

        System.out.println((customer.generateBankStatement(account)));
        System.out.println((test.toString()));



        Assertions.assertEquals(removeSpaces(test.toString()), (removeSpaces(customer.generateBankStatement(account))));


    }

    private static String removeSpaces(String input) {
        // Replace all spaces in the string with an empty string
        return input.replaceAll("\\s", "");
    }


}