package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testCreateCustomerInstance() {
        Customer customer = new Customer("Name");
        Assertions.assertNotNull(customer);
    }

    @Test
    public void testRequestCurrentAccount() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Branch branch = bank.getBranches().getFirst();
        bank.addCustomer(customer);
        Assertions.assertTrue(customer.requestCurrentAccount(branch));
        Assertions.assertEquals(1, customer.getAccounts().size());

        Customer customer2 = new Customer("Name");
        Assertions.assertFalse(customer2.requestCurrentAccount(branch), "Customer are not a customer of the bank.");

        Customer customer3 = new Customer("Name");
        customer3.setBank(new Bank("Name"));
        Assertions.assertFalse(customer3.requestCurrentAccount(branch), "Customer are not a customer of the bank.");
    }

    @Test
    public void testRequestSavingsAccount() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Branch branch = bank.getBranches().getFirst();
        bank.addCustomer(customer);
        Assertions.assertTrue(customer.requestSavingsAccount(branch));
        Assertions.assertEquals(1, customer.getAccounts().size());

        Customer customer2 = new Customer("Name");
        Assertions.assertFalse(customer2.requestSavingsAccount(branch), "Customer are not a customer of the bank.");

        Customer customer3 = new Customer("Name");
        customer3.setBank(new Bank("Name"));
        Assertions.assertFalse(customer3.requestCurrentAccount(branch), "Customer are not a customer of the bank.");
    }

    @Test
    public void testGetAccounts() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Branch branch = bank.getBranches().getFirst();
        Assertions.assertEquals(0, customer.getAccounts().size());

        bank.addCustomer(customer);
        customer.requestCurrentAccount(branch);
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    @Test
    public void testSetAccounts() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Account account = new Account();
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        customer.setAccounts(accounts);
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    @Test
    public void testGetBank() {
        Customer customer = new Customer("Name");
        Assertions.assertNull(customer.getBank());

        Bank bank = new Bank("Bank");
        customer.setBank(bank);
        Assertions.assertEquals(bank, customer.getBank());
    }

    @Test
    public void testSetBank() {
        Customer customer = new Customer("Name");
        Bank bank = new Bank("Bank");
        customer.setBank(bank);
        Assertions.assertEquals(bank, customer.getBank());
    }

    @Test
    public void testDeposit() {
        double amountToDeposit = 100.00;
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Branch branch = bank.getBranches().getFirst();
        bank.addCustomer(customer);
        customer.requestCurrentAccount(branch);
        Account currentAccount = customer.getAccounts().getFirst();

        Assertions.assertTrue(customer.deposit(currentAccount, amountToDeposit));
        Assertions.assertEquals(amountToDeposit, currentAccount.getBalance());
        Assertions.assertEquals(1, currentAccount.getTransactions().size());

        Customer customer2 = new Customer("Name");
        bank.addCustomer(customer2);
        Account account = new Account();
        Assertions.assertFalse(customer.deposit(account, amountToDeposit));
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(0, account.getTransactions().size());
    }

    @Test
    public void testWithdraw() {
        double amountToWithdraw = 100.00;
        double amountToDeposit = 200.00;
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Branch branch = bank.getBranches().getFirst();
        bank.addCustomer(customer);
        customer.requestCurrentAccount(branch);
        Account currentAccount = customer.getAccounts().getFirst();
        customer.deposit(currentAccount, amountToDeposit);

        Assertions.assertTrue(customer.withdraw(currentAccount, amountToWithdraw));
        Assertions.assertEquals(amountToDeposit - amountToWithdraw, currentAccount.getBalance());
        Assertions.assertEquals(2, currentAccount.getTransactions().size());


        Assertions.assertFalse(customer.withdraw(currentAccount, amountToWithdraw + 1));
        Assertions.assertEquals(amountToDeposit - amountToWithdraw, currentAccount.getBalance());
        Assertions.assertEquals(2, currentAccount.getTransactions().size());

        Customer customer2 = new Customer("Name");
        bank.addCustomer(customer2);
        Account account = new Account();
        Assertions.assertFalse(customer.deposit(account, amountToWithdraw), "Account not in the customer accounts.");
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(0, account.getTransactions().size());
    }
    // generate bank statment test
    @Test
    public void testGenerateBankStatement() {
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


        Assertions.assertTrue(customer.generateBankStatement(currentAccount));
    }

    @Test
    public void testRequestOverdraft() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        Branch branch = bank.getBranches().getFirst();
        customer.requestCurrentAccount(branch);
        Account currentAccount = customer.getAccounts().getFirst();

        Assertions.assertTrue(customer.requestOverdraft(currentAccount, 1000.00));
        Assertions.assertEquals(1000.00, currentAccount.getOverdraftRequest().getAmount());
        Assertions.assertFalse(currentAccount.getOverdraftRequest().isApproved());

        currentAccount.getOverdraftRequest().setApproved(true);
        Assertions.assertTrue(currentAccount.getOverdraftRequest().isApproved());

        Customer customer2 = new Customer("Name");
        bank.addCustomer(customer2);
        Account account = new Account();
        Assertions.assertFalse(customer.requestOverdraft(account, 1000.00), "Account not in the customer accounts.");
        Assertions.assertNull(account.getOverdraftRequest(), "Account should not have overdraft request.");

        customer2.requestSavingsAccount(branch);
        Account savingsAccount = customer2.getAccounts().getFirst();
        System.out.println(savingsAccount.getClass());
        Assertions.assertFalse(customer2.requestOverdraft(savingsAccount, 1000.00), "Account is not a current account.");
        Assertions.assertNull(savingsAccount.getOverdraftRequest(), "Account should not have overdraft request.");

    }

    @Test
    public void testRequestOverdraftOverLimit() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        Branch branch = bank.getBranches().getFirst();
        customer.requestCurrentAccount(branch);
        Account currentAccount = customer.getAccounts().getFirst();

        Assertions.assertFalse(customer.requestOverdraft(currentAccount, 1001.00), "Overdraft request is over the limit.");

    }


}
