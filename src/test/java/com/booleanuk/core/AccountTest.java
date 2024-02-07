package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void createAccountSavingAndCurrentTest() {

        Account account = new Account();

        Assertions.assertTrue(account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertTrue(account.addCustomerAccount("Savings", "2222-2222-2222", "Alexander Ellnestam", "ABC123"));

    }

    @Test
    public void invalidAccountSavingAndCurrentTest() {

        Account account = new Account();

        Assertions.assertTrue(account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertFalse(account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123"));
        Assertions.assertFalse(account.addCustomerAccount("Current and Saving", "3222-2222-2222", "Alexander Ellnestam", "ABC123"));

    }

    @Test
    public void findAccountTest() {

        Account account = new Account();

        account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123");

        Assertions.assertEquals(account.customerAccounts.get(0), account.findCustomerAccount("1111-1111-1111"));

        Assertions.assertNull(account.findCustomerAccount("1111-1111"));


    }

    @Test
    public void successfulDepositTest() {

        Account account = new Account();

        account.addCustomerAccount("Savings", "1111-1111-1111", "Alexander Ellnestam", "ABC123");

        Assertions.assertTrue(account.deposit("1111-1111-1111", 50.25));
        Assertions.assertTrue(account.deposit("1111-1111-1111", 5000.25));

        Assertions.assertEquals(5050.50, account.customerAccounts.get(0).getBalance());

    }

    @Test
    public void notSuccessfulDepositTest() {

        Account account = new Account();

        account.addCustomerAccount("Savings", "1111-1111-1111", "Alexander Ellnestam", "ABC123");

        Assertions.assertFalse(account.deposit("1111-1111", 50.25));

    }

    @Test
    public void successfulWithdrawTest() {
        Account account = new Account();
        account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123");
        account.deposit("1111-1111-1111", 1000);

        Assertions.assertTrue(account.withdraw("1111-1111-1111", 100));
        Assertions.assertTrue(account.withdraw("1111-1111-1111", 50));
        Assertions.assertTrue(account.withdraw("1111-1111-1111", 600));

        Assertions.assertEquals(250, account.customerAccounts.get(0).getBalance());

    }

    @Test
    public void nonSuccessfulWithdrawNoSuchAccountTest() {
        Account account = new Account();
        account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123");
        account.deposit("1111-1111-1111", 1000);

        Assertions.assertFalse(account.withdraw("1", 100));

    }

    @Test
    public void nonSuccessfulWithdrawNotEnoughMoneyInAccountTest() {
        Account account = new Account();
        account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123");
        account.deposit("1111-1111-1111", 10);

        Assertions.assertFalse(account.withdraw("1111-1111-1111", 100));



    }

    @Test
    public void approveOverdraftTest() {
        Account account = new Account();
        account.addCustomerAccount("Current", "1111-1111-1111", "Alexander Ellnestam", "ABC123");
        account.deposit("1111-1111-1111", 1000);

        Assertions.assertTrue(account.approvedOverdraft("1111-1111-1111"));
        Assertions.assertTrue(account.withdraw("1111-1111-1111", 1100));

        Assertions.assertEquals(-100, account.customerAccounts.get(0).getBalance());

    }

    @Test
    public void statementTest(){
        Account account = new Account();
        account.addCustomerAccount("Savings", "1111-1111-1111", "Alexander Ellnestam", "ABC123");
        account.deposit("1111-1111-1111",300);
        account.deposit("1111-1111-1111",300);
        account.withdraw("1111-1111-1111", 50.50);
        account.withdraw("1111-1111-1111", 300.50);
        account.reciveStatement("1111-1111-1111");
        Assertions.assertEquals(249, account.balance);
    }

}
