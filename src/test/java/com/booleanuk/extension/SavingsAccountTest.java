package com.booleanuk.extension;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {

    @Test
    public void createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount(
                "WRS",
                "123456789"
        );

        assertEquals(
                "WRS",
                savingsAccount.getBranchCode()
        );
        assertEquals(
                "123456789",
                savingsAccount.getUserPhoneNumber()
        );
        assertEquals(
                0,
                savingsAccount.getCurrentBalance()
        );
        assertTrue(savingsAccount.getTransactions().isEmpty());
    }

    @Nested
    public class Deposit {
        private static SavingsAccount SAVINGS_ACCOUNT;

        @BeforeAll
        public static void initializeSavingsAccount() {
            SAVINGS_ACCOUNT = new SavingsAccount(
                    "WRS",
                    "123456789"
            );
        }

        @Test
        public void depositNonPositiveAmount() {
            assertFalse(SAVINGS_ACCOUNT.deposit(0));
            assertFalse(SAVINGS_ACCOUNT.deposit(-2345));
        }

        @Test
        public void depositPositiveAmount() {
            assertTrue(SAVINGS_ACCOUNT.deposit(23452));

            assertEquals(
                    23452,
                    SAVINGS_ACCOUNT.getTransactions().get(0).getAmount()
            );
        }
    }

    @Nested
    public class Withdraw {
        private static SavingsAccount SAVINGS_ACCOUNT;

        @BeforeAll
        public static void initializeSavingsAccount() {
            SAVINGS_ACCOUNT = new SavingsAccount(
                    "WRS",
                    "123456789"
            );
        }

        @BeforeEach
        public void addTransaction() {
            SAVINGS_ACCOUNT.deposit(200);
        }

        @AfterEach
        public void clear() {
            SAVINGS_ACCOUNT.clearAccount();
        }

        @Test
        public void withdrawNonPositiveAmount() {
            assertFalse(SAVINGS_ACCOUNT.withdraw(0));
            assertFalse(SAVINGS_ACCOUNT.withdraw(-2345));
        }

        @Test
        public void withdrawPositiveAmountGreaterThanTheAccountBalance() {
            assertFalse(SAVINGS_ACCOUNT.withdraw(220));

            assertEquals(
                    200,
                    SAVINGS_ACCOUNT.getCurrentBalance()
            );
        }

        @Test
        public void withdrawPositiveAmountLessThanTheAccountBalance() {
            assertTrue(SAVINGS_ACCOUNT.withdraw(22));

            assertEquals(
                    178,
                    SAVINGS_ACCOUNT.getCurrentBalance()
            );
        }
    }
}
