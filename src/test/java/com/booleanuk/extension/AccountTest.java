package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testCreateAccountInstance() {
        Account account = new Account();
        Assertions.assertNotNull(account);
        Assertions.assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testGetBalance() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getBalance());

        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        Branch branch = bank.getBranches().getFirst();
        customer.requestCurrentAccount(branch);
        Account currentAccount = customer.getAccounts().getFirst();
        customer.deposit(currentAccount, 100.00);
        customer.withdraw(currentAccount, 50.00);
        customer.deposit(currentAccount, 200.00);
        customer.withdraw(currentAccount, 100.00);
        customer.deposit(currentAccount, 1500.00);
        customer.withdraw(currentAccount, 1000.00);

        Assertions.assertEquals(650.00, currentAccount.getBalance());
        Assertions.assertEquals(6, currentAccount.getTransactions().size());

        customer.withdraw(currentAccount, 650.00);
        Assertions.assertEquals(0, currentAccount.getBalance());
        Assertions.assertEquals(7, currentAccount.getTransactions().size());

        customer.withdraw(currentAccount, 50.00);
        Assertions.assertEquals(0, currentAccount.getBalance());
        Assertions.assertEquals(7, currentAccount.getTransactions().size());
    }

    @Test
    public void testGetTransactions() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getTransactions().size());
    }

    @Test
    public void testAddTransaction() {
        double amountToDeposit = 100.00;
        Account account = new Account();
        account.addTransaction( new Transaction(amountToDeposit, account.getBalance() + amountToDeposit));
        Assertions.assertEquals(1, account.getTransactions().size());

        account.addTransaction( new Transaction(amountToDeposit, account.getBalance() - amountToDeposit));
        Assertions.assertEquals(2, account.getTransactions().size());
    }
}
