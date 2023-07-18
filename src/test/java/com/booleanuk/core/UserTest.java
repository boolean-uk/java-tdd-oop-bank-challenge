package com.booleanuk.core;

import com.booleanuk.core.accounts.SavingsAccount;
import com.booleanuk.core.accounts.StandardAccount;
import com.booleanuk.core.users.Bank;
import com.booleanuk.core.users.BankManager;
import com.booleanuk.core.users.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserTest {
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
    public void createBankManagerTest(){
        Assertions.assertEquals(Bank.getBankManagerList().size(), 1);
        Assertions.assertEquals(BankManager.getManagerCount(), 1);
    }
    @Test
    public void createCustomerIfBranchExistTest(){
        Assertions.assertTrue(bankManager.getCustomers().contains(customer));
        Assertions.assertEquals(Customer.getCustomerCount(), 1);
    }

    @Test
    public void createCustomerIfBranchNotExistTest(){
        bank.addCustomer("Karolina", "M", "KarolinaM", "1234", "Warsaw2");
        Assertions.assertFalse(bankManager.getCustomers().stream().anyMatch(a->a.getBranchID().equals("Warsaw2")));
        Assertions.assertEquals(Customer.getCustomerCount(), 1);
    }

    @Test
    public void setMaxOverdraft(){
        StandardAccount standardAccount = new StandardAccount(customer);
        bankManager.setMaxOverdraft(standardAccount, 500.00);
        Assertions.assertEquals(standardAccount.getMaxOverdraft(), 500.00);
    }

    @Test
    public void deposit(){
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        Assertions.assertEquals(1, customer.getAccounts().get(0).getTransactionHistory().size());
        Assertions.assertEquals(100.00, customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()));
    }

    @Test
    public void depositWithdraw(){
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        customer.withdraw(10.00, 1);

        Assertions.assertEquals(customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()), 90.00);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 2);
    }

    @Test
    public void depositWithdrawWithOverdraftAccepted(){
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        customer.withdraw(1000.00, 1);
        bankManager.decideOverdraft(customer.getAccounts().get(0).getTransactionHistory().get(1), true);

        Assertions.assertEquals(-900.00, customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()));
        Assertions.assertEquals(2, customer.getAccounts().get(0).getTransactionHistory().size());
        Assertions.assertEquals(-900.00, customer.getAccounts().get(0).getMaxOverdraft());
    }

    @Test
    public void depositWithdrawWithOverdraftNotAccepted(){
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        customer.withdraw(1000.00, 1);
        bankManager.decideOverdraft(customer.getAccounts().get(0).getTransactionHistory().get(1), false);

        Assertions.assertEquals(customer.getAccounts().get(0).calculateBalance(LocalDateTime.now()), 100.00);
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 2);
        Assertions.assertEquals(0.0, customer.getAccounts().get(0).getMaxOverdraft());
    }

    @Test
    public void printStatements() {
        customer.createStandardAccount();
        customer.createStandardAccount();
        customer.deposit(100.00, 1);
        customer.deposit(1000.00, 1);
        customer.withdraw(50.00, 1);
        customer.deposit(22,2);
        String statements = customer.printStatements();
        System.out.println(statements);
        Assertions.assertTrue(statements.contains("12/12/2000   ||            || -50.00     || 1050.00"));
        Assertions.assertTrue(statements.contains("12/12/2000   || 22.00      ||            || 22.00"));
    }

    @Test
    public void earnInterest(){
        customer.createSavingsAccount(12.0);
        customer.deposit(2000, 1);
        customer.deposit(1000, 1);
        ((SavingsAccount) customer.getAccounts().get(0)).earnInterest();
        Assertions.assertEquals(customer.getAccounts().get(0).getTransactionHistory().size(), 3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        Assertions.assertEquals(3030, customer.getAccounts().get(0).calculateBalance(LocalDateTime.parse("2024-12-12"+ "T00:00:00", formatter)) );
    }


}
