package com.booleanuk.extension;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {

    @Test
    public void createCurrentAccount() {
        CurrentAccount currentAccount = new CurrentAccount(
                "WCA",
                "123456789"
        );

        assertEquals(
                "WCA",
                currentAccount.getBranchCode()
        );
        assertEquals(
                "123456789",
                currentAccount.getUserPhoneNumber()
        );
        assertEquals(
                0,
                currentAccount.getCurrentBalance()
        );
        assertTrue(currentAccount.getTransactions().isEmpty());
    }

    @Nested
    public class Deposit {
        private static CurrentAccount CURRENT_ACCOUNT;

        @BeforeAll
        public static void initializeCurrentAccount() {
            CURRENT_ACCOUNT = new CurrentAccount(
                    "WCA",
                    "123456789"
            );
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
        private static CurrentAccount CURRENT_ACCOUNT;

        @BeforeAll
        public static void initializeCurrentAccount() {
            CURRENT_ACCOUNT = new CurrentAccount(
                    "WCA",
                    "123456789"
            );
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
        public void withdrawPositiveAmountGreaterThanTheAccountBalanceLessThanOverdraftLimit() {
            assertTrue(CURRENT_ACCOUNT.withdraw(220));

            assertEquals(
                    -20,
                    CURRENT_ACCOUNT.getCurrentBalance()
            );
        }

        @Test
        public void withdrawPositiveAmountGreaterThanTheAccountBalanceGreaterThanOverdraftLimit() {
            assertFalse(CURRENT_ACCOUNT.withdraw(5000000));

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
