package extension;

import com.booleanuk.extension.CurrentAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    CurrentAccount account;
    public CurrentAccountTest() {
        account = new CurrentAccount();
    }

    @Test
    public void depositWithPositiveAmountTest() {

        account.deposit(100);

        Assertions.assertEquals(100.00, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());
        account.deposit(100.55);
        Assertions.assertEquals(200.55, account.getBalance());
        account.deposit(100.44);
        Assertions.assertEquals(300.99, account.getBalance());
        Assertions.assertEquals(3,account.getTransactions().size());
    }

    @Test
    public void depositWith0OrNegativeAmountTest() {
        account.deposit(100.11);
        Assertions.assertEquals(100.11, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());

        account.deposit(0);
        account.deposit(-100.11);
        Assertions.assertEquals(100.11, account.getBalance());
        Assertions.assertEquals(1, account.getTransactions().size());
    }

    @Test
    public void withdrawWithPositiveAmountTest() {
        account.deposit(1000);

        account.withdraw(100);
        Assertions.assertEquals(900, account.getBalance());
        Assertions.assertEquals(2, account.getTransactions().size());
        account.withdraw(899.99);
        Assertions.assertEquals(0.01, account.getBalance());
        Assertions.assertEquals(3, account.getTransactions().size());
        account.withdraw(0.01);
        Assertions.assertEquals(0.00, account.getBalance());
        Assertions.assertEquals(4, account.getTransactions().size());
        account.withdraw(100);
        Assertions.assertEquals(0.00, account.getBalance());
        Assertions.assertEquals(4, account.getTransactions().size());
    }

    @Test
    public void withdrawWithZeroOrNegativeNumber() {
        account.deposit(100);
        account.withdraw(0);
        account.withdraw(-0.01);
        account.withdraw((-99));

        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(1,account.getTransactions().size());
    }

    @Test
    public void withdrawWithOverdraftAllowedTo500Test() {
        account.deposit(100);
        account.withdraw(100);
        Assertions.assertFalse(account.getCanBeOverdrafted());
        account.overdraftRequest();
        Assertions.assertTrue(account.getCanBeOverdrafted());
        Assertions.assertEquals(2, account.getTransactions().size());
        Assertions.assertEquals(0, account.getBalance());
        account.withdraw(499.99);
        Assertions.assertEquals(3, account.getTransactions().size());
        Assertions.assertEquals(-499.99, account.getBalance());
        account.withdraw(0.01);
        Assertions.assertEquals(4, account.getTransactions().size());
        Assertions.assertEquals(-500, account.getBalance());
        account.withdraw(0.01);
        Assertions.assertEquals(-500, account.getBalance());
        Assertions.assertEquals(4, account.getTransactions().size());
        account.generateBankStatement();

    }
    @Test
    public void balanceCalculationTest() {
        Assertions.assertEquals("0.00", account.balanceCalculation());
        account.deposit(100);
        Assertions.assertEquals("100.00", account.balanceCalculation());
        account.deposit(100.01);
        account.deposit(100.02);
        account.deposit(100.03);
        Assertions.assertEquals("400.06", account.balanceCalculation());
        account.withdraw(100.05);
        Assertions.assertEquals("300.01", account.balanceCalculation());

    }


}
