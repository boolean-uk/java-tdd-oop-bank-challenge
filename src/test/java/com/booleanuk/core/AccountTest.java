package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class AccountTest {

    @Test
    public void generateAccountNumberIfClientIsNullTest() {
        Account account = new Account();
        Client client = null;
        String message = account.generateAccountNumber(client);
        Assertions.assertEquals("", message);
    }

    @Test
    public void generateAccountNumberIfClientIsNotNullWithOneNameTest() {
        Account account = new Account();
        Client client = new Client("John", "Smith", "01.01.1998", "234");
        StringBuilder sb = new StringBuilder();
        sb.append(client.name.toUpperCase().trim());
        sb.append(client.lastName.toUpperCase());
        sb.append(client.birthDate.replaceAll(".", ""));
        sb.append(client.id.toUpperCase());
        String accountNumber = sb.toString();
        String message = account.generateAccountNumber(client);
        Assertions.assertEquals(accountNumber, message);
    }

    @Test
    public void generateAccountNumberIfClientIsNotNullWithTwoNamesTest() {
        Account account = new Account();
        Client client = new Client("John Andrew", "Smith", "01.01.1998", "234");
        StringBuilder sb = new StringBuilder();
        sb.append(client.name.toUpperCase().trim());
        sb.append(client.lastName.toUpperCase());
        sb.append(client.birthDate.replaceAll(".", ""));
        sb.append(client.id.toUpperCase());
        String accountNumber = sb.toString();
        String message = account.generateAccountNumber(client);
        Assertions.assertEquals(accountNumber, message);
    }

    @Test
    public void createAccountIfClientExistsTest() {
        Account account = new Account();
        Client client = new Client("John", "Smith", "01.01.1998", "234");
        String message = account.createAccount(client);
        Assertions.assertEquals(account.generateAccountNumber(client), message);
    }

    @Test
    public void createAccountIfClientDoesNotExistTest() {
        Account account = new Account();
        Client client = new Client("John", "Smith", "01.01.1998", "123");
        String message = account.createAccount(client);
        Assertions.assertEquals("To create account you need to be registered", message);
    }

    @Test
    public void depositAmountAndDateGivenTest() {
        Account account = new Account();
        double amount = 2000;
        LocalDate date = LocalDate.parse("01.12.2020");
        Assertions.assertEquals("Money added to deposit", account.deposit(amount, date));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).get(0), amount);
    }

    @Test
    public void depositAmountAndDateGivenThreeTimesInOneDayTest() {
        Account account = new Account();
        double amount1 = 2000;
        double amount2 = 1000;
        double amount3 = 500;
        LocalDate date = LocalDate.parse("01.12.2020");

        Assertions.assertEquals("Money added to deposit", account.deposit(amount1, date));
        Assertions.assertEquals("Money added to deposit", account.deposit(amount2, date));
        Assertions.assertEquals("Money added to deposit", account.deposit(amount3, date));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> (e.equals(amount1))), amount1);
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> (e.equals(amount2))), amount2);
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> (e.equals(amount3))), amount3);
    }

    @Test
    public void depositAmountGivenAndDateNotTest() {
        Account account = new Account();
        double amount = 2000;
        LocalDate date = LocalDate.now();
        Assertions.assertEquals("Money added to deposit", account.deposit(amount));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).get(0), amount);
    }

    @Test
    public void depositDateGivenAndAmountNotTest() {
        Account account = new Account();
        LocalDate date = LocalDate.parse("01.12.2020");
        Assertions.assertEquals("No money to add to deposit", account.deposit(null, date));
    }

    @Test
    public void depositDateAndAmountNotGivenTest() {
        Account account = new Account();
        Assertions.assertEquals("No money to add to deposit", account.deposit(null, null));
    }

    @Test
    public void withdrawAmountAndDateGivenTest() {
        Account account = new Account();
        double amount = 500;
        LocalDate date = LocalDate.parse("01.12.2020");
        Assertions.assertEquals("Money withdrew", account.withdraw(amount, date));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).get(0), amount);
    }

    @Test
    public void withdrawAmountAndDateGivenThreeTimesInOneDayTest() {
        Account account = new Account();
        double amount1 = 500;
        double amount2 = 1500;
        double amount3 = 700;
        LocalDate date = LocalDate.parse("01.12.2020");

        Assertions.assertEquals("Money withdrew", account.withdraw(amount1, date));
        Assertions.assertEquals("Money withdrew", account.withdraw(amount2, date));
        Assertions.assertEquals("Money withdrew", account.withdraw(amount3, date));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> (e.equals(amount1))), amount1);
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> (e.equals(amount2))), amount2);
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> (e.equals(amount3))), amount3);
    }

    @Test
    public void withdrawAmountGivenAndDateNotTest() {
        Account account = new Account();
        double amount = 500;
        Assertions.assertEquals("Money withdrew", account.withdraw(amount));
    }

    @Test
    public void depositDateGivenAndAmountNotTest() {
        Account account = new Account();
        LocalDate date = LocalDate.parse("01.12.2020");
        Assertions.assertEquals("No money to withdraw to deposit", account.withdraw(null, date));
    }

    @Test
    public void depositDateAndAmountNotGivenTest() {
        Account account = new Account();
        Assertions.assertEquals("No money to add to deposit", account.withdraw(null, null));
    }

    @Test
    public void countBalanceTest() {
        Account account = new Account();
        double amountToDeposit = 1000;
        double amountToWithdraw = 700;
        LocalDate date1 = LocalDate.parse("01.12.2020");
        LocalDate date2 = LocalDate.parse("02.12.2020");
        account.deposit(amountToDeposit, date1);
        account.withdraw(amountToWithdraw, date2);

        Assertions.assertEquals(300.00, account.countBalance(account.getCreditList(), account.getDebitList()));
    }

    @Test
    public void countBalanceForEmptyAccountTest() {
        Account account = new Account();

        Assertions.assertEquals(00, account.countBalance(account.getCreditList(), account.getDebitList()));
    }

    public String generateBankStatementsForTest(HashMap<String, ArrayList<Double>> credit, HashMap<String, ArrayList<Double>> debit){
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    @Test
    public void generateBankStatementsTest() {
        Account account = new Account();
        HashMap<String, ArrayList<Double>> credit = new HashMap<>();
        HashMap<String, ArrayList<Double>> debit = new HashMap<>();

        Assertions.assertEquals(generateBankStatementsForTest(credit, debit), account.generateBankStatements(account.getCreditList(), account.getDebitList()));
    }

}
