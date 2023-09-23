package com.booleanuk.core.Accounts;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("John Doe");
        account = new CurrentAccount(new BigDecimal("1000.00"), Branches.Sofia, user);
    }

    @Test
    public void testDepositFunds() {
        BigDecimal depositAmount = new BigDecimal("500.00");
        account.depositFunds(depositAmount);
        assertEquals(new BigDecimal("1500.00"), account.getBalance());
    }

    @Test
    public void testWithdrawFunds() {
        BigDecimal withdrawalAmount = new BigDecimal("500.00");
        account.withdrawFunds(withdrawalAmount);
        assertEquals(new BigDecimal("500.00"), account.getBalance());
    }

    @Test
    public void testWithdrawFundsInsufficientBalance() {
        BigDecimal withdrawalAmount = new BigDecimal("1500.00");
        assertThrows(IllegalArgumentException.class, () -> account.withdrawFunds(withdrawalAmount));
    }

    @Test
    public void testWithdrawFundsNegativeAmount() {
        BigDecimal withdrawalAmount = new BigDecimal("-500.00");
        assertThrows(IllegalArgumentException.class, () -> account.withdrawFunds(withdrawalAmount));
    }

    @Test
    public void testDepositFundsNegativeAmount() {
        BigDecimal depositAmount = new BigDecimal("-500.00");
        assertThrows(IllegalArgumentException.class, () -> account.depositFunds(depositAmount));
    }
}
