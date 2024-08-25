package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void makeCurrentAccountTest() {
        Account account = new CurrentAccount(500);
        Assertions.assertNotNull(account, "The account should be created");
    }

    @Test
    public void checkBalance() {
        Account account = new CurrentAccount(500);
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void DepositTest() {
        Account account = new CurrentAccount(500);
        account.deposit(100);
        Assertions.assertEquals(600, account.getBalance());

    }

    @Test
    public void WithdrawalTest() {
        Account account = new CurrentAccount(500);
        account.withdraw(100);
        Assertions.assertEquals(400, account.getBalance());

    }

    @Test
    public void NegativeDepositTest() {
        Account account = new CurrentAccount(500);
        Assertions.assertEquals("The amount should be positive!", account.deposit(-100));

    }

    @Test
    public void withdrawalTestIfAmountExceedsLimit() {
        Account account = new CurrentAccount(500);
        Assertions.assertEquals("You dont have enough money for this withdrawal!", account.withdraw(600));


    }


    @Test
    public void addTransactionShouldPrintHeaderOnce() {
        Account account = new CurrentAccount(500);
        Assertions.assertFalse(account.isHeaderPrinted(), "Header should not be printed initially");
        account.addTransaction(1000.00, "credit");
        account.addTransaction(500.00, "debit");

        Assertions.assertTrue(account.isHeaderPrinted(), "Header should be printed after the first transaction");
        Assertions.assertEquals(2, account.getTransactions().size(), "There should be two transactions recorded");

    }

    @Test
    public void getInterestRateTest() {
        Customer customer = new Customer("Melvin", "Seelan");
        Account account = new SavingAccount(500, 3);
        customer.addAccount(account);
        Assertions.assertTrue(true, "Account should be of type SavingAccount");
        Assertions.assertEquals(customer.getAccounts().get(0).getBalance(),500);
        SavingAccount savingAccountFromCustomer = (SavingAccount) account;
        Assertions.assertEquals(savingAccountFromCustomer.getInterestRate(),3);




    }

    @Test
    public void applyInterestRateTest() {
        Customer customer =  new Customer("Melvin", "Seelan");
        Account savingAccount = new SavingAccount(500, 3);
        customer.addAccount(savingAccount);
        savingAccount.applyInterest();
        double expectedBalance = 500 + (500*3.00/100);
        Assertions.assertNotNull(savingAccount);
        Assertions.assertEquals(expectedBalance, customer.getAccounts().get(0).getBalance());
    }

}
