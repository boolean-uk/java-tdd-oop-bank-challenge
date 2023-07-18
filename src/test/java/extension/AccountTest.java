package extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountTest {
    private Account account;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @BeforeEach
    void setUp() {
        account = new CurrentAccount("Kinga", "Hernet");
    }

    @Test
    void depositShouldFailWithInvalidAmounts() {
        Assertions.assertFalse(account.deposit(0), "Deposit of 0 should fail");
        Assertions.assertFalse(account.deposit(-100.0), "Deposit of negative amount should fail");
        Assertions.assertFalse(account.activated, "Account should not be activated if deposit failed");
    }

    @Test
    void depositShouldSucceedWithValidAmount() {
        double depositAmount = 100.5;
        int depositCents = 10050; // 100.5 * 100

        boolean depositResult = account.deposit(depositAmount);

        Assertions.assertTrue(depositResult, "Deposit should succeed with valid amount");
        Assertions.assertEquals(depositCents, account.getCurrentBalanceInCents(), "Account balance should match deposit amount");
        Assertions.assertTrue(account.activated, "Account should be activated after successful deposit");

        Assertions.assertEquals(formatter.format(LocalDate.now()), account.dateHistory.get(0), "Current date should be recorded in date history");
        Assertions.assertEquals(depositAmount, account.balanceMoveHistory.get(0), "Deposit amount should be recorded in balance move history");
        Assertions.assertEquals(depositCents, account.balanceHistory.get(0), "Deposit amount in cents should be recorded in balance history");
    }

    @Test
    void withdrawShouldUpdateAccountCorrectly() {
        account.deposit(100.5);

        Assertions.assertFalse(account.withdraw(200.0), "Withdrawal should fail if the amount is greater than the balance");
        Assertions.assertTrue(account.withdraw(10), "Withdrawal should succeed if the amount is less than the balance");

        int remainingBalanceCents = 9050; // 100.5 * 100 - 10 * 100
        Assertions.assertEquals(remainingBalanceCents, account.getCurrentBalanceInCents(), "Remaining balance should match expected value");

        Assertions.assertEquals(formatter.format(LocalDate.now()), account.dateHistory.get(1), "Current date should be recorded in date history after withdrawal");
        Assertions.assertEquals(remainingBalanceCents, account.balanceHistory.get(1), "Remaining balance in cents should be recorded in balance history after withdrawal");
    }

    @Test
    void depositShouldUpdateBalanceCorrectly() {
        boolean depositResult = account.deposit(100.5);

        Assertions.assertTrue(depositResult, "Deposit should succeed with valid amount");
        Assertions.assertEquals(10050, account.getCurrentBalanceInCents(), "Account balance should match deposit amount in cents");
    }


    @Test
    void branchTest() {
        account.setBranch("Super branch");

        Assertions.assertEquals("Super branch", account.getBranch());
    }

    @Test
    void overDraftTest() {
        account.deposit(100.5);

        Assertions.assertFalse(account.withdraw(101.5));

        ((CurrentAccount) account).setOverDraftAbility(true);
        Assertions.assertTrue(account.withdraw(130.5));
        Assertions.assertEquals(-30.0, account.getCurrentBalance());
    }
}