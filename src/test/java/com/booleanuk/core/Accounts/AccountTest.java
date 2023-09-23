package com.booleanuk.core.Accounts;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.Client;
import com.booleanuk.core.Users.Manager;
import com.booleanuk.core.Users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

    public class AccountTest {
    private Account currentAccount;
    private Account savingsAccount;
    private User client;
    private Branch branch;
        private Manager manager;

    @BeforeEach
    public void setUp() {
        client = new Client("John Doe","123456");
        manager = new Manager("John Manager", "123-456-7890", branch);

        branch = new Branch(Branches.Sofia, manager);
        currentAccount = new CurrentAccount(new BigDecimal("1000.00"), branch, client);
        savingsAccount = new SavingsAccount(new BigDecimal("2000.00"),branch, client);

    }

    @Test
    public void testDepositFunds() {
        BigDecimal depositAmount = new BigDecimal("500.00");
        currentAccount.depositFunds(depositAmount);
        assertEquals(new BigDecimal("1500.00"), currentAccount.getBalance());
    }

    @Test
    public void testWithdrawFunds() {
        BigDecimal withdrawalAmount = new BigDecimal("500.00");
        currentAccount.withdrawFunds(withdrawalAmount);
        assertEquals(new BigDecimal("500.00"), currentAccount.getBalance());
    }

    @Test
    public void testWithdrawFundsInsufficientBalance() {
        BigDecimal withdrawalAmount = new BigDecimal("1500.00");
        assertThrows(IllegalArgumentException.class, () -> currentAccount.withdrawFunds(withdrawalAmount));
    }

    @Test
    public void testWithdrawFundsNegativeAmount() {
        BigDecimal withdrawalAmount = new BigDecimal("-500.00");
        assertThrows(IllegalArgumentException.class, () -> currentAccount.withdrawFunds(withdrawalAmount));
    }

    @Test
    public void testDepositFundsNegativeAmount() {
        BigDecimal depositAmount = new BigDecimal("-500.00");
        assertThrows(IllegalArgumentException.class, () -> currentAccount.depositFunds(depositAmount));
    }
    @Test
    public void testCalculateBalanceBasedOnTransactionHistory() {
        currentAccount.depositFunds(new BigDecimal("1000.00"));
        currentAccount.withdrawFunds(new BigDecimal("500.00"));
        currentAccount.depositFunds(new BigDecimal("200.00"));
        assertEquals(new BigDecimal("1700.00"), currentAccount.getBalance());
    }
}
