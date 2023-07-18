package com.booleanuk.core;

import com.booleanuk.core.accounts.StandardAccount;
import com.booleanuk.core.users.BankManager;
import com.booleanuk.core.users.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class UserTest {
    @Test
    public void createBankManagerTest(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Assertions.assertEquals(BankManager.getManagerCount(), 1);
    }
    @Test
    public void createCustomerIfBranchExistTest(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        Assertions.assertTrue(bankManager.getCustomers().contains(customer));
        Assertions.assertEquals(Customer.getCustomerCount(), 1);

    }

    @Test
    public void createCustomerIfBranchNotExistTest(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw2");
        Assertions.assertFalse(bankManager.getCustomers().contains(customer));
        Assertions.assertEquals(Customer.getCustomerCount(), 0);
    }

    @Test
    public void setMaxOverdraft(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        StandardAccount standardAccount = new StandardAccount(customer);
        bankManager.setMaxOverdraft(standardAccount, 500.00);
        Assertions.assertEquals(standardAccount.getMaxOverdraft(), 500.00);

    }

    @Test
    public void deposit(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        Assertions.assertEquals(customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()), 100.00);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 1);
    }

    @Test
    public void depositWithdraw(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        customer.withdraw(10.00, 1);

        Assertions.assertEquals(customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()), 90.00);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 2);
    }

    @Test
    public void depositWithdrawWithOverdraftAccepted(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        customer.withdraw(1000.00, 1);
        bankManager.decideOverdraft(customer.getAccounts().get(0).getTransactionHistory().get(1), true);

        Assertions.assertEquals(customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()), -900.00);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 2);
        Assertions.assertEquals(customer.getAccounts().get(0).getMaxOverdraft(), 900.00);
    }

    @Test
    public void depositWithdrawWithOverdraftNotAccepted(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        customer.withdraw(1000.00, 1);
        bankManager.decideOverdraft(customer.getAccounts().get(0).getTransactionHistory().get(1), false);

        Assertions.assertEquals(customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()), 100.00);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 2);
        Assertions.assertEquals(customer.getAccounts().get(0).getMaxOverdraft(), 0.0);
    }
}
