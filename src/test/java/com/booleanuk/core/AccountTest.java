package com.booleanuk.core;

import com.booleanuk.core.accounts.Account;
import com.booleanuk.core.accounts.StandardAccount;
import com.booleanuk.core.accounts.Transaction;
import com.booleanuk.core.users.Bank;
import com.booleanuk.core.users.BankManager;
import com.booleanuk.core.users.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountTest {
    private Customer customer;
    private BankManager bankManager;
    private Bank bank = new Bank();


    @BeforeEach
    public void init(){
        bank.addBankManager("man", "man", "manman", "1234", "Warsaw1");
        bank.addCustomer("Karolina", "M", "KarolinaM", "1234", "Warsaw1");
        bankManager = Bank.getBankManagerList().get(0);
        customer = Bank.getCustomerList().get(0);
    }
    @Test
    public void createAccount(){
        customer.createStandardAccount();

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(customer.getAccounts().get(0).getId(), 1);
        Assertions.assertEquals(Account.getAccountCount(), 1);
    }

    @Test
    public void create2Accounts(){
        customer.createStandardAccount();
        customer.createSavingsAccount(2.2);

        Assertions.assertEquals(customer.getAccounts().size(), 2);
        Assertions.assertEquals(customer.getAccounts().get(1).getId(), 2);
        Assertions.assertEquals(Account.getAccountCount(), 2);
    }

    @Test
    public void create2AccountsDifferentUsers(){
        bank.addCustomer("Karol", "M", "KarolM", "1234", "Warsaw1");
        Customer customer1 = Bank.getCustomerList().get(1);
        customer.createStandardAccount();
        customer1.createStandardAccount();

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(customer.getAccounts().get(0).getId(), 1);
        Assertions.assertEquals(customer1.getAccounts().get(0).getId(), 2);
        Assertions.assertEquals(Account.getAccountCount(), 2);
    }

    @Test
    public void transactionStandardAccountPositiveBalance(){
        customer.createStandardAccount();
        customer.getAccounts().get(0).addTransaction(new Transaction(100.5));

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 1);
        Assertions.assertEquals(customer.getAccounts().get(0), customer.getAccounts().get(0).getTransactionHistory().get(0).getAccount());
    }

    @Test
    public void transactionStandardAccountNegativeBalanceNoOverdraftPossible(){
        customer.createStandardAccount();
        customer.getAccounts().get(0).addTransaction(new Transaction(100.5));
        customer.getAccounts().get(0).addTransaction(new Transaction(-200.00));

        Assertions.assertEquals(customer.getAccounts().size(), 1);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 2);
        Assertions.assertFalse(customer.getAccounts().get(0).getTransactionHistory().get(1).isAccepted());
    }

    @Test
    public void transactionStandardAccountNegativeBalanceOverdraftPossible(){
        StandardAccount account = new StandardAccount(customer);
        account.addTransaction(new Transaction(100.5));
        account.setMaxOverdraft(-500.00);
        account.addTransaction(new Transaction(-200.00));

        System.out.println(account.getTransactionHistory().get(1).isAccepted());
        Assertions.assertEquals(account.getTransactionHistory().size(), 2);
        Assertions.assertTrue(account.getTransactionHistory().get(1).isAccepted());
        Assertions.assertEquals(-99.5,account.calculateBalance(LocalDateTime.now()));
    }

    @Test
    public void calculateBalance(){
        customer.createStandardAccount();
        customer.getAccounts().get(0).addTransaction(new Transaction(100.00));
        customer.getAccounts().get(0).addTransaction(new Transaction(200.00));
        customer.getAccounts().get(0).addTransaction(new Transaction(-50.00));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


        Assertions.assertEquals(customer.getAccounts().get(0).calculateBalance(LocalDateTime.parse("2024-12-12"+ "T00:00:00", formatter)), 250.00);
    }


}
