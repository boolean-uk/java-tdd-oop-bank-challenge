package com.booleanuk.core;

import com.booleanuk.core.accounts.StandardAccount;
import com.booleanuk.core.users.BankManager;
import com.booleanuk.core.users.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
