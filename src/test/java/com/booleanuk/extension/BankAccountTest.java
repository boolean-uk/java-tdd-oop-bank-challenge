package com.booleanuk.extension;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void createBankAccount() {
        BankAccount bankAccount = new BankAccount(
                "WRS",
                "123456789"
        );

        assertEquals(
                "WRS",
                bankAccount.getBranchCode()
        );
        assertEquals(
                "123456789",
                bankAccount.getUserPhoneNumber()
        );
        assertEquals(
                0,
                bankAccount.getCurrentBalance()
        );
        assertTrue(bankAccount.getTransactions().isEmpty());
    }

    @Nested
    public class Deposit {
        private static BankAccount BANK_ACCOUNT;

        @BeforeAll
        public static void initializeBankAccount() {
            BANK_ACCOUNT = new BankAccount(
                    "WRS",
                    "123456789"
            );
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
            BANK_ACCOUNT = new BankAccount(
                    "WRS",
                    "123456789"
            );
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
