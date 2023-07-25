package com.booleanuk.core;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Nested
    public class Deposit {
        private static BankAccount BANK_ACCOUNT;

        @BeforeAll
        public static void initializeBankAccount() {
            BANK_ACCOUNT = new BankAccount();
        }

        @Test
        public void depositNonPositiveAmount() {
            assertFalse(BANK_ACCOUNT.deposit(0));
            assertFalse(BANK_ACCOUNT.deposit(-2345));
        }

        @Test
        public void depositPositiveAmount() {
            assertTrue(BANK_ACCOUNT.deposit(23452));

            assertEquals(
                    23452,
                    BANK_ACCOUNT.getTransactions().get(0).getAmount()
            );
        }
    }

    @Nested
    public class Withdraw {
        private static BankAccount BANK_ACCOUNT;

        @BeforeAll
        public static void initializeBankAccount() {
            BANK_ACCOUNT = new BankAccount();
        }

        @BeforeEach
        public void addTransaction() {
            BANK_ACCOUNT.deposit(200);
        }

        @AfterEach
        public void clear() {
            BANK_ACCOUNT.clearAccount();
        }

        @Test
        public void withdrawNonPositiveAmount() {
            assertFalse(BANK_ACCOUNT.withdraw(0));
            assertFalse(BANK_ACCOUNT.withdraw(-2345));
        }

        @Test
        public void withdrawPositiveAmountGreaterThanTheAccountBalance() {
            assertFalse(BANK_ACCOUNT.withdraw(220));

            assertEquals(
                    200,
                    BANK_ACCOUNT.getCurrentBalance()
            );
        }

        @Test
        public void withdrawPositiveAmountLessThanTheAccountBalance() {
            assertTrue(BANK_ACCOUNT.withdraw(22));

            assertEquals(
                    178,
                    BANK_ACCOUNT.getCurrentBalance()
            );
        }
    }
}
