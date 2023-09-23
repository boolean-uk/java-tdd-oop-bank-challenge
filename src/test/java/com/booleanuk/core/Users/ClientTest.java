package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Branches;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private Client client;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;
    private Branch branch;
    private Manager manager;

    @BeforeEach
    public void setUp() {
        client = new Client("John Doe", "123-456-7890");
        manager = new Manager("John Manager", "123-456-7890", branch);

        branch = new Branch(Branches.Sofia, manager);
        currentAccount = new CurrentAccount(new BigDecimal("1000.00"), branch, client);
        savingsAccount = new SavingsAccount(new BigDecimal("2000.00"), branch, client);
    }
    @Test
    public void testCustomerCanOpenCurrentAccount() {
        assertTrue(client.openCurrentAccount( currentAccount));
        assertEquals(currentAccount, client.getCurrentAccount());
    }

    @Test
    public void testCustomerCanOpenSavingsAccount() {
        assertTrue(client.openSavingsAccount( savingsAccount));
        assertEquals(savingsAccount, client.getSavingsAccount());
    }
    @Test
    public void testCustomerCannotRequestOverdraftForSavingsAccount() {
        client.openSavingsAccount(savingsAccount);
        assertFalse(client.requestOverdraft(savingsAccount, BigDecimal.valueOf(1000)));
    }
}
