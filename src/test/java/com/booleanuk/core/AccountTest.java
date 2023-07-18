package com.booleanuk.core;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.StandardAccount;
import com.booleanuk.core.accounts.Transaction;
import com.booleanuk.core.users.BankManager;
import com.booleanuk.core.users.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AccountTest {
    @Test
    public void createAccount(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(customer.getAccounts().get(0).getId(), 1);
        Assertions.assertEquals(Account.getAccountCount(), 1);
    }

    @Test
    public void create2Accounts(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer.createSavingsAccount(2.2);

        Assertions.assertEquals(customer.getAccounts().size(), 2);
        Assertions.assertEquals(customer.getAccounts().get(1).getId(), 2);
        Assertions.assertEquals(Account.getAccountCount(), 2);
    }

    @Test
    public void create2AccountsDifferentUsers(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        Customer customer1 = new Customer("Karol", "M", "KarolM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer1.createStandardAccount();

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(customer1.getAccounts().get(0).getId(), 1);
        Assertions.assertEquals(customer1.getAccounts().get(0).getId(), 2);
        Assertions.assertEquals(Account.getAccountCount(), 2);
    }

    @Test
    public void transactionStandardAccountPositiveBalance(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer.getAccounts().get(0).addTransaction(new Transaction(100.5));

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 1);
    }

    @Test
    public void transactionStandardAccountNegativeBalanceNoOverdraftPossible(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer.getAccounts().get(0).addTransaction(new Transaction(100.5));
        customer.getAccounts().get(0).addTransaction(new Transaction(-200.00));

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 1);
    }

    @Test
    public void transactionStandardAccountNegativeBalanceOverdraftPossible(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        StandardAccount account = new StandardAccount(customer);
        account.addTransaction(new Transaction(100.5));
        account.setMaxOverdraft(500.00);
        account.addTransaction(new Transaction(-200.00));

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(account.getTransactionHistory().size(), 2);
    }

    @Test
    public void calculateBalance(){
        BankManager bankManager = new BankManager("man", "man", "manman", "1234", "Warsaw1");
        Customer customer = new Customer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        customer.createStandardAccount();
        customer.getAccounts().get(0).addTransaction(new Transaction(100.00));
        customer.getAccounts().get(0).addTransaction(new Transaction(200.00));
        customer.getAccounts().get(0).addTransaction(new Transaction(-50.00));

        Assertions.assertEquals(customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()), 250.00);
    }


}
