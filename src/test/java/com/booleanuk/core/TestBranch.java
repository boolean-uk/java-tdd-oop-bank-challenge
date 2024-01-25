package com.booleanuk.core;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBranch {

    @Test
    public void testAccountAssociationWithBranch() {
        Bank bank = new Bank();
        Branch branch = new Branch("Oslo", "123 City Street");
        bank.addBranch(branch);
        Customer customer = new Customer(1, "John", "Doe");
        bank.addCustomer(customer);

        // Create account and associate it with the branch
        boolean accountCreated = bank.createAccount(customer.getId(), "Checking", 1000.0, branch.getName());
        Account account = customer.getAccount(1);

        // Assertions
        Assertions.assertTrue(accountCreated, "Account should be created successfully");
        Assertions.assertNotNull(account, "Account should not be null");
        Assertions.assertEquals(branch, account.getBranch(), "Account should be associated with the correct branch");
        Assertions.assertTrue(branch.getAccounts().contains(account), "Branch should contain the created account");
    }
}

