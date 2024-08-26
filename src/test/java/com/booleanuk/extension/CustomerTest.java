package com.booleanuk.extension;

import com.booleanuk.core.Account;
import com.booleanuk.core.Bank;
import com.booleanuk.core.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testCreateCustomerInstance() {
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        Assertions.assertNotNull(customer);
    }

    @Test
    public void testRequestCurrentAccount() {
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer);
        Assertions.assertTrue(customer.requestCurrentAccount());
        Assertions.assertEquals(1, customer.getAccounts().size());

        com.booleanuk.core.Customer customer2 = new com.booleanuk.core.Customer("Name");
        Assertions.assertFalse(customer2.requestCurrentAccount(), "Customer are not a customer of the bank.");

        com.booleanuk.core.Customer customer3 = new com.booleanuk.core.Customer("Name");
        customer3.setBank(new com.booleanuk.core.Bank("Name"));
        Assertions.assertFalse(customer3.requestCurrentAccount(), "Customer are not a customer of the bank.");
    }

    @Test
    public void testRequestSavingsAccount() {
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer);
        Assertions.assertTrue(customer.requestSavingsAccount());
        Assertions.assertEquals(1, customer.getAccounts().size());

        com.booleanuk.core.Customer customer2 = new com.booleanuk.core.Customer("Name");
        Assertions.assertFalse(customer2.requestSavingsAccount(), "Customer are not a customer of the bank.");

        com.booleanuk.core.Customer customer3 = new com.booleanuk.core.Customer("Name");
        customer3.setBank(new com.booleanuk.core.Bank("Name"));
        Assertions.assertFalse(customer3.requestCurrentAccount(), "Customer are not a customer of the bank.");
    }

    @Test
    public void testGetAccounts() {
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        Assertions.assertEquals(0, customer.getAccounts().size());

        bank.addCustomer(customer);
        customer.requestCurrentAccount();
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    @Test
    public void testSetAccounts() {
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        List<com.booleanuk.core.Account> accounts = new ArrayList<>();
        accounts.add(account);
        customer.setAccounts(accounts);
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    @Test
    public void testGetBank() {
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        Assertions.assertNull(customer.getBank());

        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        customer.setBank(bank);
        Assertions.assertEquals(bank, customer.getBank());
    }

    @Test
    public void testSetBank() {
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        customer.setBank(bank);
        Assertions.assertEquals(bank, customer.getBank());
    }

    @Test
    public void testDeposit() {
        double amountToDeposit = 100.00;
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer);
        customer.requestCurrentAccount();
        com.booleanuk.core.Account currentAccount = customer.getAccounts().getFirst();

        Assertions.assertTrue(customer.deposit(currentAccount, amountToDeposit));
        Assertions.assertEquals(amountToDeposit, currentAccount.getBalance());
        Assertions.assertEquals(1, currentAccount.getTransactions().size());

        com.booleanuk.core.Customer customer2 = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer2);
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        Assertions.assertFalse(customer.deposit(account, amountToDeposit));
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(0, account.getTransactions().size());
    }

    @Test
    public void testWithdraw() {
        double amountToWithdraw = 100.00;
        double amountToDeposit = 200.00;
        com.booleanuk.core.Bank bank = new com.booleanuk.core.Bank("Bank");
        com.booleanuk.core.Customer customer = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer);
        customer.requestCurrentAccount();
        com.booleanuk.core.Account currentAccount = customer.getAccounts().getFirst();
        customer.deposit(currentAccount, amountToDeposit);

        Assertions.assertTrue(customer.withdraw(currentAccount, amountToWithdraw));
        Assertions.assertEquals(amountToDeposit - amountToWithdraw, currentAccount.getBalance());
        Assertions.assertEquals(2, currentAccount.getTransactions().size());


        Assertions.assertFalse(customer.withdraw(currentAccount, amountToWithdraw + 1));
        Assertions.assertEquals(amountToDeposit - amountToWithdraw, currentAccount.getBalance());
        Assertions.assertEquals(2, currentAccount.getTransactions().size());

        com.booleanuk.core.Customer customer2 = new com.booleanuk.core.Customer("Name");
        bank.addCustomer(customer2);
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        Assertions.assertFalse(customer.deposit(account, amountToWithdraw), "Account not in the customer accounts.");
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(0, account.getTransactions().size());
    }
    // generate bank statment test
    @Test
    public void testGenerateBankStatement() {
        com.booleanuk.core.Bank bank = new Bank("Bank");
        com.booleanuk.core.Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        customer.requestCurrentAccount();
        Account currentAccount = customer.getAccounts().getFirst();
        customer.deposit(currentAccount, 100.00);
        customer.withdraw(currentAccount, 50.00);
        customer.deposit(currentAccount, 200.00);
        customer.withdraw(currentAccount, 100.00);
        customer.deposit(currentAccount, 1500.00);
        customer.withdraw(currentAccount, 1000.00);


        Assertions.assertTrue(customer.generateBankStatement(currentAccount));
    }
}
