package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CustomerTest {

    @Test
    public void initCustomer() {
        Customer customer = new Customer();
        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);
        Account savingsAccount = new SavingsAccount("AccountName", Branches.Oslo);

        Assertions.assertTrue(customer.createAccount(currentAccount));
        Assertions.assertTrue(customer.createAccount(savingsAccount));

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(currentAccount, savingsAccount)),customer.getAccounts());
    }

    @Test
    public void createAndDeleteAccount() {
        Customer customer = new Customer();
        Account savingsAccount = new SavingsAccount("AccountName", Branches.Oslo);
        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);

        Assertions.assertTrue(customer.createAccount(savingsAccount));
        Assertions.assertTrue(customer.createAccount(currentAccount));

        Assertions.assertEquals(savingsAccount, customer.getAccount(savingsAccount));
        Assertions.assertEquals(currentAccount, customer.getAccount(currentAccount));

        Assertions.assertTrue(customer.getAccounts().contains(savingsAccount));
        Assertions.assertTrue(customer.getAccounts().contains(currentAccount));

        Assertions.assertTrue(customer.deleteAccount(savingsAccount));
        Assertions.assertTrue(customer.deleteAccount(currentAccount));

        Assertions.assertFalse(customer.getAccounts().contains(savingsAccount));
        Assertions.assertFalse(customer.getAccounts().contains(currentAccount));
    }

    @Test
    public void depositAndWithdraw() {
        Customer customer = new Customer();
        Account savingsAccount = new SavingsAccount("AccountName", Branches.Oslo);
        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);

        Assertions.assertTrue(customer.createAccount(savingsAccount));
        Assertions.assertTrue(customer.createAccount(currentAccount));

        Assertions.assertEquals(0.00, customer.getAccount(savingsAccount).getBalance());
        Assertions.assertTrue(customer.deposit(savingsAccount, 500.00));
        Assertions.assertEquals(500.00, customer.getAccount(savingsAccount).getBalance());
        Assertions.assertTrue(customer.withdraw(savingsAccount, 400.00));
        Assertions.assertEquals(100.00, customer.getAccount(savingsAccount).getBalance());

    }

    @Test
    public void transferCredit() {
        Customer customer = new Customer();
        Account savingsAccount = new SavingsAccount("AccountName", Branches.Oslo);
        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);

        Assertions.assertTrue(customer.createAccount(savingsAccount));
        Assertions.assertTrue(customer.createAccount(currentAccount));

        Assertions.assertEquals(0.00, customer.getAccount(currentAccount).getBalance());
        Assertions.assertTrue(customer.deposit(currentAccount, 500.00));
        Assertions.assertEquals(500.00, customer.getAccount(currentAccount).getBalance());

        Assertions.assertFalse(customer.transferCredit(currentAccount, savingsAccount, 600.00));
        Assertions.assertTrue(customer.transferCredit(currentAccount, savingsAccount, 400.00));
        Assertions.assertEquals(400.00, customer.getAccount(savingsAccount).getBalance());
        Assertions.assertEquals(100.00, customer.getAccount(currentAccount).getBalance());

    }

    @Test
    public void printCorrectBankStatements() {
        Customer customer = new Customer();
        Account currentAccount = new CurrentAccount("AccountName", Branches.Oslo);

        Assertions.assertTrue(customer.createAccount(currentAccount));

        Assertions.assertEquals(0.00, currentAccount.getBalance());
        Assertions.assertEquals(new ArrayList<BankStatement>(), currentAccount.getBankStatements());
        Assertions.assertTrue(currentAccount.deposit(500));
        Assertions.assertTrue(currentAccount.withdraw(100));

        LocalDate localDate = LocalDate.now();

        Assertions.assertEquals("\n    Date        Debit       Credit     Balance\n" +
                localDate +" ||          ||    500.0 ||     500.0\n" +
                localDate +" ||    500.0 ||          ||    2000.0\n", customer.getAccount(currentAccount).printBankStatements());

    }

    @Test
    public void requestOverdraft() {
        Customer customer = new Customer();

        CurrentAccount currentAccount = new CurrentAccount("AccountName1", Branches.Kristiansand);

        BankManager bankManager = new BankManager();

        Assertions.assertTrue(customer.requestOverdraft(currentAccount, bankManager));

    }

}
