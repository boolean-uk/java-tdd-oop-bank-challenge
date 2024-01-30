package com.booleanuk.core;

import com.booleanuk.core.BankApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAppTest {
    private BankApp.Customer customer;
    private BankApp.Branch branch;
    private BankApp.SavingsAccount savingsAccount;
    private BankApp.CurrentAccount currentAccount;

    @BeforeEach
    void setUp() {

        customer = BankApp.Customer.createCustomer("12345", "+1234567890");
        branch = new BankApp.Branch("Main Branch");
        savingsAccount = new BankApp.SavingsAccount("SA001");
        savingsAccount.createSavingsAccount(customer.customerId, branch.branchName);

        currentAccount = new BankApp.CurrentAccount("CA001");
        currentAccount.createCurrentAccount(customer.customerId, branch.branchName);
        currentAccount.requestOverdraft();

        currentAccount.sendStatement();

        branch.addAccount(savingsAccount);
        branch.addAccount(currentAccount);
        branch.assessOverdraftRequest(currentAccount);

    }


    @Test
    void Story1CreateCurrentAccount() {
        assertNotNull(currentAccount);
        assertEquals(customer.customerId, currentAccount.getCustomerId());
        assertEquals(branch.branchName, currentAccount.getBranchName());
    }

    @Test
    void Story2CreateSavingsAccount() {
        assertNotNull(savingsAccount);
        savingsAccount.deposit(200);
        savingsAccount.withdraw(200);
        assertEquals(customer.customerId, savingsAccount.getCustomerId());
        assertEquals(branch.branchName, savingsAccount.getBranchName());
    }

    @Test
    void Story3GenerateStatementWithDatesAndAmountsAndBalance() {
        currentAccount.deposit(1000);
        currentAccount.withdraw(100);
        currentAccount.calculateBalance();

        assertNotNull(savingsAccount);
        assertEquals(customer.customerId, savingsAccount.getCustomerId());
        assertEquals(900, currentAccount.calculateBalance());

        savingsAccount.deposit(1000);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(1100);
        currentAccount.calculateBalance();

        assertNotNull(savingsAccount);
        assertEquals(customer.customerId, savingsAccount.getCustomerId());
        assertEquals(900, currentAccount.calculateBalance());
    }

    @Test
    void Story4MakeDepositsAndWithdrawalsAsCustomer() {
        currentAccount.deposit(1000);
        currentAccount.withdraw(100);
        currentAccount.calculateBalance();

        assertNotNull(savingsAccount);
        assertEquals(customer.customerId, savingsAccount.getCustomerId());
        assertEquals(900, currentAccount.calculateBalance());

        savingsAccount.deposit(1000);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(1100);
        currentAccount.calculateBalance();

        assertNotNull(savingsAccount);
        assertEquals(customer.customerId, savingsAccount.getCustomerId());
        assertEquals(900, currentAccount.calculateBalance());

    }

}



