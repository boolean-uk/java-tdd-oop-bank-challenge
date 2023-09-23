package com.booleanuk.core.Bank;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.Client;
import com.booleanuk.core.Users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BankStatementTest {
    private Account currentAccount;
    private Account savingsAccount;
    private User client;
    private Branch branch;
    @BeforeEach
    public void setUp() {
        client = new Client("John Doe","123456");
        currentAccount = new CurrentAccount(new BigDecimal("1000.00"), Branches.Sofia, client);
        savingsAccount = new SavingsAccount(new BigDecimal("1000.00"), Branches.Sofia, client);

//        branch = new Branch("Main Branch");
    }
    @Test
    public void testGenerateBankStatementWithTransactionDetails() {
        currentAccount.depositFunds(new BigDecimal("1000.00"));
        currentAccount.withdrawFunds(new BigDecimal("500.00"));
        BankStatement statement = currentAccount.generateStatement();
        assertNotNull(statement);
        // ... add assertions for statement content
    }

    @Test
    public void testGenerateBankStatementWithNoTransactionHistory() {
        BankStatement statement = currentAccount.generateStatement();
        assertNotNull(statement);
        // add assertions for empty statement
    }
}
