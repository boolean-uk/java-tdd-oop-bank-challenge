package com.booleanuk.core;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {

    @Nested
    public class Deposit {
        private static CurrentAccount CURRENT_ACCOUNT;

        @BeforeAll
        public static void initializeBankAccount() {
            CURRENT_ACCOUNT = new CurrentAccount();
        }

        @Test
        public void depositNonPositiveAmount() {
            assertFalse(CURRENT_ACCOUNT.deposit(0));
            assertFalse(CURRENT_ACCOUNT.deposit(-2345));
        }

        @Test
        public void depositPositiveAmount() {
            assertTrue(CURRENT_ACCOUNT.deposit(23452));

            assertEquals(
                    23452,
                    CURRENT_ACCOUNT.getTransactions().get(0).getAmount()
            );
        }
    }

    @Nested
    public class Withdraw {
        private static BankAccount CURRENT_ACCOUNT;

        @BeforeAll
        public static void initializeBankAccount() {
            CURRENT_ACCOUNT = new BankAccount();
        }

        @BeforeEach
        public void addTransaction() {
            CURRENT_ACCOUNT.deposit(200);
        }

        @AfterEach
        public void clear() {
            CURRENT_ACCOUNT.clearAccount();
        }

        @Test
        public void withdrawNonPositiveAmount() {
            assertFalse(CURRENT_ACCOUNT.withdraw(0));
            assertFalse(CURRENT_ACCOUNT.withdraw(-2345));
        }

        @Test
        public void withdrawPositiveAmountGreaterThanTheAccountBalance() {
            assertFalse(CURRENT_ACCOUNT.withdraw(220));

            assertEquals(
                    200,
                    CURRENT_ACCOUNT.getCurrentBalance()
            );
        }

        @Test
        public void withdrawPositiveAmountLessThanTheAccountBalance() {
            assertTrue(CURRENT_ACCOUNT.withdraw(22));

            assertEquals(
                    178,
                    CURRENT_ACCOUNT.getCurrentBalance()
            );
        }
    }
}
